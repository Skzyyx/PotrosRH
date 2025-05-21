package Control;

import Excepciones.ValidarEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IContratoBO;
import Interfaces.INominaBO;
import Interfaces.IRegistroAsistenciaBO;
import bo.ContratoBO;
import bo.NominaBO;
import bo.RegistroAsistenciaBO;
import dto.EmpleadoDTO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que valida un empleado para la generación
 * de su nómina.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlValidarEmpleado {
    // BOs requeridos.
    private final INominaBO nominaBO = NominaBO.getInstance();
    private final IContratoBO contratoBO = ContratoBO.getInstance();
    private final IRegistroAsistenciaBO asistenciaBO = RegistroAsistenciaBO.getInstance();
    
    /**
     * Valida que un empleado esté activo.
     * @param empleado Empleado a validar.
     * @return VERDADERO si el empleado está activo, FALSO en caso contrario.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    public boolean validarEstado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        // Se valida el empleado y su ID.
        validarEmpleado(empleado);
        
        if(empleado.getEstado() == null)
            throw new ValidarEmpleadoException("El estado del empleado no puede estar vacío.");
        
        return empleado.getEstado().equals("ACTIVO");
    }
    /**
     * Valida que el empleado tenga al menos un 80% de asistencia,
     * correspondiente al período de pago.
     * @param empleado Empleado a validar.
     * @return VERDADERO si el empleado tiene al menos un 80% de asistencia, FALSO en caso contrario.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    public boolean validarPorcentajeAsistencias(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        // Se valida el empleado y su ID.
        validarEmpleado(empleado);
        
        if(!(empleado.getHorariosLaborales() != null && !empleado.getHorariosLaborales().isEmpty()))
            throw new ValidarEmpleadoException("El empleado recibido no cuenta con su horario laboral completo.");
        
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
                throw new ValidarEmpleadoException("Ocurrió un error en la validación del porcentaje de asistencia del empleado.");
            
            // Se obtiene la cantidad de horas trabajadas.
            Double horasTrabajadas = asistenciaBO.obtenerHorasTrabajadas(empleado, fechaInicio);
            
            // Se verifica que se obtuvo una cantidad de horas trabajadas
            if(horasTrabajadas == null)
                throw new ValidarEmpleadoException("Ocurrió un error en el cálculo del salario bruto y neto de la nómina.");
            
            // Obtiene el 80% de asistencias, a partir de las horas trabajadas esperadas.
            double porcentaje = horasEsperadas * 0.8;
            
            // Si las horas trabajas es mayor que el porcentaje.
            return horasTrabajadas > porcentaje;
            
        } catch (ObjetosNegocioException e) {
            Logger.getLogger(ValidarEmpleadoException.class.getName()).log(Level.SEVERE, null, e);
            throw new ValidarEmpleadoException(e.getMessage(), e);
        }
    }
    /**
     * Valida hayan pasado al menos 5 días desde
     * la última nómina generada al empleado o
     * desde su primer día de trabajo.
     * @param empleado Empleado asociado.
     * @return VERDADERO si han pasado más de 5 días desde la última nómina del empleado, FALSO en caso contrario.
     * @throws Excepciones.ValidarEmpleadoException
     */
    public boolean validarPeriodoNomina(EmpleadoDTO empleado) throws ValidarEmpleadoException{
        validarEmpleado(empleado);
        try {
             // Se obtiene la fecha de la última nómina del empleado.
            LocalDate fechaValidar = nominaBO.obtenerFechaUltimaNomina(empleado);
            
            // Si el empleado todavía no tiene nóminas asociadas, primero se busca su fecha de inicio de su contrato.
            if(fechaValidar == null){
                // Se obtiene la fecha del inicio del contrato del empleado.
                fechaValidar = contratoBO.obtenerFechaInicioContrato(empleado);
                
                // Si el empleado tampoco tiene una fecha de inicio del contrato (no debería pasar)
                if(fechaValidar == null)
                    throw new ObjetosNegocioException("El empleado no tiene un contrato asociado. Contacte a su gerente para evaluar esta anomalía.");

                /*
                    Se obtiene la fecha que teóricamente debería ser su primer día de trabajo, ya que
                    la fecha de inicio del contrato podría no ser necesariamente su primer día de
                    trabajo.
                */
                fechaValidar = nominaBO.obtenerFechaPrimerDiaTrabajoEsperado(empleado, fechaValidar);

                // Si se retorna null, quiere decir que el empleado no tiene un horario laboral (tampoco no debería pasar)
                if(fechaValidar == null)
                    throw new ObjetosNegocioException("El empleado asociado no tiene un horario laboral. Contacte a su gerente para evaluar esta anomalía.");
            }
            
            return ChronoUnit.DAYS.between(fechaValidar, LocalDate.now()) >= 5;
            
        } catch (ObjetosNegocioException e) {
            Logger.getLogger(ValidarEmpleadoException.class.getName()).log(Level.SEVERE, null, e);
            throw new ValidarEmpleadoException(e.getMessage(), e);
        }
    }
    
    /**
     * Valida el objeto EmpleadoDTO recibido, y que contiene un ID válido.
     * @param empleado DTO a validar.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    private void validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        
        if (!(empleado != null && empleado.getId() != null)) 
            throw new ValidarEmpleadoException("El empleado no puede estar vacío.");
    }
}