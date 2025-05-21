package bo;

import DAO.EmpleadoDAO;
import DAO.NominaDAO;
import DAO.RegistroAsistenciaDAO;
import Entidades.Empleado;
import Enums.DiaSemana;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoDAO;
import Interfaces.INominaBO;
import Interfaces.INominaDAO;
import Interfaces.IRegistroAsistenciaDAO;
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
    private static final IRegistroAsistenciaDAO asistenciaDAO = new RegistroAsistenciaDAO();
    private static final IEmpleadoDAO empleadoDAO= new EmpleadoDAO();
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
    
    // Tabla del SAT (Límite Inferior, Cuota Fija, % Excedente)
    private final double[][] TABLA_ISR = {
        {0.01, 0.00, 1.92},
        {746.05, 14.32, 6.40},
        {6332.06, 371.83, 10.88},
        {11128.02, 893.63, 16.00},
        {12934.84, 1198.93, 17.92},
        {15487.73, 1742.13, 21.36},
        {19391.45, 2612.89, 23.52},
        {24518.46, 3962.34, 30.00},
        {32324.03, 6351.23, 32.00},
        {38177.70, 8482.74, 34.00},
        {74835.47, 22159.88, 35.00}
    };

    /**
     * Genera una nómina para un empleado dado.
     * @param empleado Objeto EmpleadoDTO con los datos del empleado.
     * @return NominaDTO con los datos de la nómina generada.
     * @throws ObjetosNegocioException si el empleado es nulo.
     */
    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws ObjetosNegocioException {
        
        if (!(empleado != null && empleado.getId() != null))
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        
        try {
            
            //Se extrae el ID del empleado
            Empleado empleadoId = new Empleado();
            empleadoId.setId(new ObjectId(empleado.getId()));
            
            // Se obtiene la fecha de la última nómina del empleado.
            LocalDate fechaInicio = nominaDAO.obtenerFechaUltimaNomina(empleadoId);
            // Se calculan las horas esperadas
            Double horasEsperadas = calcularHorasEsperadas(empleado, fechaInicio);
            // Se obtiene la cantidad de días trabajados del empleado.
            Integer diasTrabajados = asistenciaDAO.obtenerDiasTrabajados(empleadoId, fechaInicio);
            // Se obtiene la cantidad de horas trabajadas.
            Double horasTrabajadas = asistenciaDAO.obtenerHorasTrabajadas(empleadoId, fechaInicio);
            // Se calculan las horas extra.
            Double horasExtra = horasTrabajadas - horasEsperadas;
            
            NominaDTO nomina = new NominaDTO();
            nomina.setEmpleadoId(empleado.getId());
            nomina.setBono(0.0);
            nomina.setDiasTrabajados(diasTrabajados);
            nomina.setIsr(calcularISR(empleado.getSalarioBase(), diasTrabajados));
            nomina.setSalarioBruto(empleado.getSalarioBase() * diasTrabajados);
            nomina.setSalarioNeto(nomina.getSalarioBruto() - nomina.getIsr());
            nomina.setFechaCorte(LocalDate.now());
            nomina.setHorasTrabajadas(horasTrabajadas);
            if(horasExtra > 0.0)
                nomina.setHorasExtra(horasExtra);
            else
                nomina.setHorasExtra(null);
            return nomina;
        } catch (AccesoDatosException ex) {
            Logger.getLogger(NominaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
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
     * Calcula el ISR aplicando la tabla de tasas del SAT en base al ingreso mensual del empleado.
     * @param ingresoTotal Monto total del salario a considerar.
     * @param diasPagados Número de días trabajados en el período de pago.
     * @return Monto del ISR calculado en base al salario y los días trabajados.
     */
    private double calcularISR(double ingresoTotal, int diasPagados) {
        double ingresoDiario = ingresoTotal / diasPagados;
        double ingresoMensual = ingresoDiario * 30.4;

        // Buscar el rango en la tabla del SAT
        double cuotaFija = 0, tasaExcedente = 0, limiteInferior = 0;
        for (double[] rango : TABLA_ISR) {
            if (ingresoMensual >= rango[0]) {
                limiteInferior = rango[0];
                cuotaFija = rango[1];
                tasaExcedente = rango[2];
            } else {
                break;
            }
        }
        // Calcular ISR mensual
        double excedente = ingresoMensual - limiteInferior;
        double isrMensual = cuotaFija + (excedente * (tasaExcedente / 100));
        // Ajustar ISR a los días trabajados
        return isrMensual * (diasPagados / 30.4);
    }
    /**
     * Calcula las horas esperadas de un empleado, a partir 
     * de su horario laboral y la fecha de inicio, que se
     * espera que sea de la última nómina o de su primer
     * día esperado de trabajo.
     * @param empleado Empleado asociado a la nómina.
     * @param fechaInicio Fecha de inicio del período de la nómina.
     */
    private double calcularHorasEsperadas(EmpleadoDTO empleado, LocalDate fechaInicio){
        // Fecha actual, para establecer el período de las horas esperadas.
        LocalDate fechaActual = LocalDate.now();
        // Se extrae el horario laboral completo del empleado.
        List<HorarioLaboralDTO> horario = empleado.getHorariosLaborales();
        // Acumulador de las horas esperadas.
        double horasEsperadas = 0.0;
        // Itera sobre el período, añadiendo las horas de cada día laboral
        do{
            for(HorarioLaboralDTO diaLaboral : horario){
                if(DiaSemana.valueOf(diaLaboral.getDiaSemana()).getNumero() == fechaActual.getDayOfWeek().getValue() ){
                    Duration duracion = Duration.between(diaLaboral.getHoraInicioTurno(), diaLaboral.getHoraFinTurno());
                    horasEsperadas += duracion.toSeconds() / 3600;
                }
                fechaActual.plusDays(1);
            }
        } while(!fechaInicio.isEqual(fechaActual));
        return horasEsperadas;
    }
}