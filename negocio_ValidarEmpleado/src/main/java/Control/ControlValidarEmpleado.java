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
        try {
            return empleadoBO.validarEstado(empleado);
        } catch (ObjetosNegocioException ex) {throw new ValidarEmpleadoException(ex.getMessage());}
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
        try {
            return empleadoBO.validarPorcentajeAsistencias(empleado);
        } catch (ObjetosNegocioException ex) {throw new ValidarEmpleadoException(ex.getMessage());}
    }
    /**
     * Valida el objeto EmpleadoDTO recibido, y que contiene un RFC válido.
     * @param empleado DTO a validar.
     * @throws ValidarEmpleadoException 
     */
    private void validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        
        if(empleado == null)
            throw new ValidarEmpleadoException("El RFC no puede estar vacío.");
        
        // Se extrae el RFC del empleado.
        String rfc = empleado.getRfc();
        
        if (rfc == null) 
            throw new ValidarEmpleadoException("El rfc no puede estar vacío.");       
        
        if (rfc.isEmpty()) 
            throw new ValidarEmpleadoException("El rfc no puede estar vacío.");       
        
        if(!rfc.matches("^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$"))
            throw new ValidarEmpleadoException("RFC con formato inválido.");
    }
}