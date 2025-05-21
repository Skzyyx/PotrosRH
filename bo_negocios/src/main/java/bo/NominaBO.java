package bo;

import DAO.NominaDAO;
import Entidades.Empleado;
import Enums.DiaSemana;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.INominaBO;
import Interfaces.INominaDAO;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import dto.NominaDTO;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.NominaMapper;
import org.bson.types.ObjectId;

/**
 * Objeto de negocio NominaBO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaBO implements INominaBO {
    // Atributo de la misma clase (SingleTon).
    private static INominaBO instance;
    // Atributo DAO para operaciones CRUD con Nóminas.
    private static final INominaDAO nominaDAO = new NominaDAO();
    /**
     * Constructor por defecto.
     */
    private NominaBO() {}
    /**
     * Método SingleTon de la clase.
     * @return Instancia SingleTon de la clase.
     */
    public static synchronized INominaBO getInstance() {
        if (instance == null) 
            instance = new NominaBO();
        return instance;
    } 
    
    /**
     * Simula el guardado de una nómina en la base de datos.
     * @param nomina Objeto NominaDTO que se desea guardar.
     * @return NominaDTO con nómina insertada.
     * @throws Exceptions.ObjetosNegocioException Excepción.
     */
    @Override
    public NominaDTO guardarNomina(NominaDTO nomina) throws ObjetosNegocioException{
        if(!(nomina != null && nomina.getEmpleadoId() != null))
            throw new ObjetosNegocioException("No se aceptan nominas vacias.");
        
        try {
            return NominaMapper.toDTO(nominaDAO.guardarNomina(NominaMapper.toEntityNuevo(nomina)));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(NominaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
    
    /**
     * Obtiene la fecha de la última nómina de un empleado.
     * @param empleado Empleado asociado.
     * @return Fecha de la última nómina del empleado.
     * @throws ObjetosNegocioException Excepción.
     */
    @Override
    public LocalDate obtenerFechaUltimaNomina(EmpleadoDTO empleado) throws ObjetosNegocioException{
        
        if (!(empleado != null && empleado.getId() != null))
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        
        try {
            //Se extrae el ID del empleado
            Empleado empleadoId = new Empleado();
            empleadoId.setId(new ObjectId(empleado.getId()));
            
            // Se obtiene la fecha de la última nómina del empleado.
            return nominaDAO.obtenerFechaUltimaNomina(empleadoId);
            
        } catch (AccesoDatosException e) {
            Logger.getLogger(NominaBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }
    /**
     * Calcula las horas esperadas de un empleado, a partir 
     * de su horario laboral y la fecha de inicio, que se
     * espera que sea de la última nómina o la de su primer
     * día esperado de trabajo.
     * @param empleado Empleado asociado a la nómina.
     * @param fechaInicio Fecha de inicio del período de la nómina.
     * @return Horas esperadas de trabajo del empleado, de acuerdo al período.
     */
    @Override
    public Double calcularHorasEsperadas(EmpleadoDTO empleado, LocalDate fechaInicio){
        // Fecha actual, para establecer el período de las horas esperadas.
        LocalDate fechaActual = LocalDate.now();
        // Se extrae el horario laboral completo del empleado.
        List<HorarioLaboralDTO> horario = empleado.getHorariosLaborales();
        // Acumulador de las horas esperadas.
        Double horasEsperadas = 0.0;
        // Itera sobre el período, añadiendo las horas de cada día laboral
        while(!fechaInicio.isEqual(fechaActual)){ // Mientras la fecha que se está iterando no sea la misma que la actual.
            // Recorre cada día laboral del empleado.
            for(HorarioLaboralDTO diaLaboral : horario){
                // Si el día coincide con el de la fecha de inicio, se suman sus horas al acumulador.
                if(DiaSemana.valueOf(diaLaboral.getDiaSemana()).getNumero() == fechaInicio.getDayOfWeek().getValue() ){
                    Duration duracion = Duration.between(diaLaboral.getHoraInicioTurno(), diaLaboral.getHoraFinTurno());
                    horasEsperadas += duracion.toSeconds() / 3600;
                    break;
                }
            }
            // Pasa al día siguiente del período.
            fechaInicio = fechaInicio.plusDays(1);
        }
        
        if(horasEsperadas > 0)
            return horasEsperadas;
        else return null;
    }
    
    /**
     * Al no contar con un atributo especial en alguna entidad, y suponiendo que el empleado
     * falte a su primer día de trabajo, se obtiene la fecha en la que debería haber trabajado
     * por primera vez. Esto se hace al tomar el primer día del horario laboral del empleado
     * que se ubique dentro el período, tomando como límite superior la fecha actual, y como
     * límite inferior la fecha de inicio del contrato del empleado. ¿Se podría considerar
     * una mexicanada?
     * @param empleado Empleado, con su horario laboral completo.
     * @param fechaInicioContrato Fecha de inicio del contrato del empleado.
     * @return Fecha del primero día de trabajo del empleado.
     */
    @Override
    public LocalDate obtenerFechaPrimerDiaTrabajoEsperado(EmpleadoDTO empleado, LocalDate fechaInicioContrato){
        // Fecha actual, para establecer el límite superior.
        LocalDate fechaActual = LocalDate.now();
        // Se extrae el horario laboral completo
        List<HorarioLaboralDTO> horario = empleado.getHorariosLaborales();
        // Almacenará la fecha que se espera sea el primer día de 
        LocalDate fechaPrimerDiaTrabajoEsperado = null;
        // Variable para salirse del ciclo cuando se encunetre el día
        boolean encontrado = false;
        // Itera sobre el período
        while(!fechaInicioContrato.isEqual(fechaActual)){ // Mientras la fecha que se está iterando no sea la misma que la actual.
            // Recorre cada día laboral del empleado.
            for(HorarioLaboralDTO diaLaboral : horario){
                /*
                    Si el día coincide con el de la fecha de inicio del contrato, 
                    se agrega dicha fecha a la variable fechaPrimerDiaTrabajoEsperado y se sale del ciclo.
                */
                if(DiaSemana.valueOf(diaLaboral.getDiaSemana()).getNumero() == fechaInicioContrato.getDayOfWeek().getValue() ){
                    fechaPrimerDiaTrabajoEsperado = fechaInicioContrato;
                    encontrado = true;
                    break;
                }
            }
            if(encontrado == false)
                // Pasa al día siguiente del período.
                fechaInicioContrato = fechaInicioContrato.plusDays(1);
            else 
                break;
        } 
        // Regresa la fecha del primer día de trabajo esperado.
        return fechaPrimerDiaTrabajoEsperado;
    }
}