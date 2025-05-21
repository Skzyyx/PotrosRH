package Control;

import Excepciones.CorreoException;
import Exceptions.GenerarNominaException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IGenerarNomina;
import bo.NominaBO;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.INominaBO;
import SistemaCorreo.SistemaCorreo;
import java.util.Map;
import Interface.ISistemaCorreo;
import Interfaces.IContratoBO;
import Interfaces.IEmpleadoBO;
import Interfaces.IRegistroAsistenciaBO;
import bo.ContratoBO;
import bo.EmpleadoBO;
import bo.RegistroAsistenciaBO;
import dto.CorreoDTO;
import java.time.LocalDate;

/**
 * Realiza validaciones de negocio y genera la nómina correspondiente al
 * empleado recibido.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlGenerarNomina implements IGenerarNomina {

    /**
     * Objeto BO de las nóminas.
     */
    private final INominaBO nominaBO = NominaBO.getInstance();
    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    private final IContratoBO contratoBO = ContratoBO.getInstance();
    private final IRegistroAsistenciaBO asistenciaBO = RegistroAsistenciaBO.getInstance();
    
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
     * Genera la nómina de un empleado activo.
     *
     * @param empleado Objeto EmpleadoDTO con la información del empleado.
     * @return Objeto NominaDTO con los detalles de la nómina generada.
     * @throws GenerarNominaException Si el empleado es nulo o está inactivo.
     */
    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException {
        
        // Si el empleado o su ID es null
        if (!(empleado != null && empleado.getId() != null)) 
            throw new GenerarNominaException("El empleado no puede ser nulo.");
        
        // Si el DTO recibido no tiene el salario base del empleado.
        if(empleado.getSalarioBase() == null )
            throw new GenerarNominaException("El empleado recibido no cuenta con un salario base.");
        
        // Si el empleado no está cargado con su horario laboral completo.
        if(!(empleado.getHorariosLaborales() != null && !empleado.getHorariosLaborales().isEmpty()))
            throw new GenerarNominaException("El empleado recibido no cuenta con su horario laboral completo.");

        try {
            
            // Se obtiene la fecha de la última nómina del empleado.
            LocalDate fechaInicio = nominaBO.obtenerFechaUltimaNomina(empleado);
            
            // Si el empleado todavía no tiene nóminas asociadas, primero se busca su fecha de inicio de su contrato.
            if(fechaInicio == null){
                // Se obtiene la fecha del inicio del contrato del empleado.
                fechaInicio = contratoBO.obtenerFechaInicioContrato(empleado);
                
                // Si el empleado tampoco tiene una fecha de inicio del contrato (no debería pasar)
                if(fechaInicio == null)
                    throw new ObjetosNegocioException("El empleado no tiene un contrato asociado. Contacte a su gerente para evaluar esta anomalía.");

                /*
                    Se obtiene la fecha que teóricamente debería ser su primer día de trabajo, ya que
                    la fecha de inicio del contrato podría no ser necesariamente su primer día de
                    trabajo.
                */
                fechaInicio = nominaBO.obtenerFechaPrimerDiaTrabajoEsperado(empleado, fechaInicio);

                // Si se retorna null, quiere decir que el empleado no tiene un horario laboral (tampoco no debería pasar)
                if(fechaInicio == null)
                    throw new ObjetosNegocioException("El empleado asociado no tiene un horario laboral. Contacte a su gerente para evaluar esta anomalía.");
            }
            
            // Se calculan las horas esperadas
            Double horasEsperadas = nominaBO.calcularHorasEsperadas(empleado, fechaInicio);
            
            // Se verifica que se obtuvo una cantidad.
            if(horasEsperadas == null)
                throw new GenerarNominaException("Ocurrió un error en el cálculo del salario bruto y neto de la nómina.");
            
            // Se obtiene la cantidad de días trabajados del empleado.
            Integer diasTrabajados = asistenciaBO.obtenerDiasTrabajados(empleado, fechaInicio);
            
            // Se verifica que el empleado sí trabajó.
            if(diasTrabajados == null)
                throw new ObjetosNegocioException("El empleado no ha asistido ningún día a trabajar.");
            
            // Se obtiene la cantidad de horas trabajadas.
            Double horasTrabajadas = asistenciaBO.obtenerHorasTrabajadas(empleado, fechaInicio);
            
            // Se verifica que se obtuvo una cantidad de horas trabajadas
            if(horasTrabajadas == null)
                throw new GenerarNominaException("Ocurrió un error en el cálculo del salario bruto y neto de la nómina.");
            
            // Se calculan las horas extra.
            Double horasExtra = horasTrabajadas - horasEsperadas;
            
            // Se cargan los datos de la nómina.
            NominaDTO nomina = new NominaDTO();
            nomina.setEmpleadoId(empleado.getId());
            nomina.setBono(0.0);
            nomina.setDiasTrabajados(diasTrabajados);
            nomina.setSalarioBruto(empleado.getSalarioBase() * horasTrabajadas);
            nomina.setIsr(calcularISR(nomina.getSalarioBruto(), diasTrabajados));
            nomina.setSalarioNeto(nomina.getSalarioBruto() - nomina.getIsr());
            nomina.setFechaCorte(LocalDate.now());
            nomina.setHorasTrabajadas(horasTrabajadas);
            // Se agregan las horas extra (si es que hay).
            if(horasExtra > 0.0)
                nomina.setHorasExtra(horasExtra);
            else
                nomina.setHorasExtra(0.0);
            
            // Se regresa la nómina generada.
            return nomina;
            
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException(ex.getMessage(), ex);
        }
    }

    /**
     * Guarda la nómina en la base de datos.
     *
     * @param nomina Objeto NominaDTO con la información de la nómina.
     * @return `true` si el proceso fue exitoso, `false` en caso contrario.
     * @throws GenerarNominaException Si la nómina es nula o si ocurre un error.
     */
    @Override
    public NominaDTO guardarNomina(NominaDTO nomina) throws GenerarNominaException {
        // Si la nómina está vacía.
        if (nomina == null) 
            throw new GenerarNominaException("La nomina no puede ser nula.");
        
        // Valida los atributos de la nómina recibida.
        validarNomina(nomina);
        
        try {
            NominaDTO nominaDTO = nominaBO.guardarNomina(nomina); // Se guarda la nómina.
            return nominaDTO; // Regresa true como confirmación de nómina generada con éxito.
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException(ex.getMessage(), ex);
        }
    }

    /**
     * Envia un correo al empleado con la información de su nómina.
     *
     * @param nomina Objeto NominaDTO con la información de la nómina.
     * @return `true` si el proceso fue exitoso, `false` en caso contrario.
     * @throws GenerarNominaException Si ocurre un error al enviar el correo.
     */
    public boolean enviarCorreo(NominaDTO nomina) throws GenerarNominaException {
        try {
            EmpleadoDTO empleadoBuscar = new EmpleadoDTO();
            empleadoBuscar.setId(nomina.getEmpleadoId());
            EmpleadoDTO empleado = empleadoBO.obtenerEmpleadoId(empleadoBuscar);
            
            ISistemaCorreo sistemaCorreo = new SistemaCorreo();
            
            CorreoDTO dto = new CorreoDTO();
            dto.setCorreoReceptor(empleado.getEmail());
            dto.setPlantillaCorreo("NOMINA");
            
            Map<String, Object> values = Map.of(
                    "nombreCompleto", String.join(" ",
                            empleado.getNombre(),
                            empleado.getApellidoPaterno(),
                            empleado.getApellidoMaterno()
                    ),
                    "fechaCorte", nomina.getFechaCorte(),
                    "salarioBase", empleado.getSalarioBase(),
                    "bono", nomina.getBono(),
                    "salarioBruto", nomina.getSalarioBruto(),
                    "isr", nomina.getIsr(),
                    "salarioNeto", nomina.getSalarioNeto()
            );
            
            dto.setValues(values);
            
            sistemaCorreo.sendEmail(dto);
            return true;
        } catch (CorreoException | ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarNominaException("Ocurrió un error al intentar enviar el correo.");
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
     * Valida los atributos de una nómina recibida.
     * @param nomina Nómina a validar.
     * @throws GenerarNominaException 
     */
    private void validarNomina(NominaDTO nomina) throws GenerarNominaException{
        // Si la nómina no tiene un empleado asociado.
        if(!(nomina.getEmpleadoId() != null && !nomina.getEmpleadoId().isEmpty()))
            throw new GenerarNominaException("La nomina debe tener un empleado asociado.");
        
        // Si la nómina cuenta con un bono, pero es negativo.
        if(nomina.getBono() != null && nomina.getBono() < 0.0)
            throw new GenerarNominaException("No se le puede aplicar un bono negativo a la nómina.");
        
        // Si la nómina no tiene el ISR
        if(nomina.getIsr() == null)
            throw new GenerarNominaException("La nomina debe contar con el ISR aplicado al sueldo del empleado.");
        // Si el ISR es negativo.
        if(nomina.getIsr() < 0.0)
            throw new GenerarNominaException("El ISR no puede ser negativo.");
        
        // Si la nómina no cuenta con el salario bruto.
        if(nomina.getSalarioBruto() == null)
            throw new GenerarNominaException("La nómina debe contar con el salario bruto.");
        
        // Si el salario bruto es negativo.
        if(nomina.getSalarioBruto() < 0.0)
            throw new GenerarNominaException("El salario bruto no puede ser negativo.");
        
        // Si la nómina no cuenta con el salario neto.
        if(nomina.getSalarioNeto() == null)
            throw new GenerarNominaException("La nómina debe contar con el salario neto.");
        
        // Si el salario neto es negativo.
        if(nomina.getSalarioNeto() < 0.0)
            throw new GenerarNominaException("El salario neto no puede ser negativo.");
        
        // Si la nómina no tiene la fecha de corte.
        if(nomina.getFechaCorte() == null)
            throw new GenerarNominaException("La nómina debe contar con una fecha de corte");
        
        // Si la fecha de corte está después de la actual.
        if(nomina.getFechaCorte().isAfter(LocalDate.now()))
            throw new GenerarNominaException("La fecha de corte no puede estar después de la fecha actual.");
        
        // Si la nómina no cuenta con los días trabajados.
        if(nomina.getDiasTrabajados() == null)
            throw new GenerarNominaException("La nómina debe contar con los días trabajados del empleado.");
        
        // Si los días trabajados es una cantidad negativa
        if(nomina.getDiasTrabajados() < 0)
            throw new GenerarNominaException("La nomina debe contar con los días trabajados del empleado.");
        
        // Si la nómina no cuenta con las horas trabajadas del empleado.
        if(nomina.getHorasTrabajadas() == null)
            throw new GenerarNominaException("La nómina debe contar con las horas trabajadas del empleado");
        
        // Si las horas trabajas es un número negativo
        if(nomina.getHorasTrabajadas() < 0.0)
            throw new GenerarNominaException("Las cantidad de horas trabajadas no puede ser negativa.");
        
        // Si la nómina cuenta con horas extra, pero es una cantidad negativa
        if(nomina.getHorasExtra() != null && nomina.getHorasExtra() < 0.0)
            throw new GenerarNominaException("Las cantidad de horas extra no puede ser negativa.");
        
        // Si el estado de cobro de la nómina es positivo
        if(nomina.getEstadoCobro() == true)
            throw new GenerarNominaException("No se puede guardar una nómina que ya ha sido cobrada.");
    }
}
