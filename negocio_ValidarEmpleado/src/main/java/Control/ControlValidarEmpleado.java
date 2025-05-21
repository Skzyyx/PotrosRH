package Control;

import Excepciones.ValidarEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoBO;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;

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
    // Objeto de negocio EmpleadoBO para el uso de sus métodos.
    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    /**
     * Valida que un empleado esté activo.
     * @param empleado Empleado a validar.
     * @return VERDADERO si el empleado está activo, FALSO en caso contrario.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    public boolean validarEstado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        // Se valida el empleado y su RFC.
        validarEmpleado(empleado);
        return true;
    }
    /**
     * Valida que el empleado tenga al menos un 80% de asistencia,
     * correspondiente al período de pago.
     * @param empleado Empleado a validar.
     * @return VERDADERO si el empleado tiene al menos un 80% de asistencia, FALSO en caso contrario.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    public boolean validarPorcentajeAsistencias(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        // Se valida el empleado y su RFC.
        validarEmpleado(empleado);
        return true;
    }
    /**
     * Valida el objeto EmpleadoDTO recibido, y que contiene un RFC válido.
     * @param empleado DTO a validar.
     * @throws ValidarEmpleadoException 
     */
    private void validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        
        if (!(empleado != null && empleado.getId() != null)) 
            throw new ValidarEmpleadoException("El empleado no puede estar vacío.");
        
         // Si el empleado no está cargado con su horario laboral completo.
        if(!(empleado.getHorariosLaborales() != null && !empleado.getHorariosLaborales().isEmpty()))
            throw new ValidarEmpleadoException("El empleado recibido no cuenta con su horario laboral completo.");
    }
}