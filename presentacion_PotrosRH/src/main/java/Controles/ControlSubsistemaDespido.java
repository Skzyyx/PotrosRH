package Controles;

import Excepciones.PresentacionException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoBO;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class ControlSubsistemaDespido {

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();

    public EmpleadoDTO buscarEmpleadoPorRFC(String rfc) throws ObjetosNegocioException{
        try {
            EmpleadoDTO empleado = new EmpleadoDTO();
            empleado.setRfc(rfc);
            return empleadoBO.obtenerEmpleado(empleado);
        } catch (ObjetosNegocioException e) {
            throw new ObjetosNegocioException("Error al buscar empleado: " + e.getMessage(), e);
        }
    }
    
    public EmpleadoDTO actualizarEstadoEmpleado(String rfc, String nuevoEstado) throws ObjetosNegocioException {
        try {
            return empleadoBO.actualizarEstadoEmpleado(rfc, nuevoEstado);
        } catch (ObjetosNegocioException e) {
            throw new ObjetosNegocioException("Error al actualizar el estado del empleado: " + e.getMessage(), e);
        }
    }
}