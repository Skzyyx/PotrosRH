package Controles;

import Control.ControlSubsistemaDespidos;
import Excepciones.PresentacionException;
import Fachada.ObtenerEmpleado;
import Interfaces.IObtenerEmpleado;
import Interfaz.IDespedirEmpleado;
import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class ControlDespido {

    private static ControlDespido instance;
    private final IDespedirEmpleado subsistemaDespidos = new ControlSubsistemaDespidos();
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance(); 

    private ControlDespido() {
    }

    public static ControlDespido getInstance() {
        if (instance == null) {
            instance = new ControlDespido();
        }
        return instance;
    }
    
    public EmpleadoDTO buscarEmpleadoPorRFC(EmpleadoDTO empleadoDTO) throws PresentacionException {
        try {
            return obtenerEmpleado.obtenerEmpleado(empleadoDTO);
        } catch (Exception e) {
            throw new PresentacionException("Error al buscar empleado: " + e.getMessage());
        }
    }

    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws PresentacionException {
        try {
            subsistemaDespidos.registrarDespido(empleadoDTO, motivo);
        } catch (Exception e) {
            throw new PresentacionException("Error al registrar despido: " + e.getMessage());
        }
    }

    public EmpleadoDTO actualizarEstadoEmpleado(EmpleadoDTO empleadoDTO, String nuevoEstado) throws PresentacionException {
        try {
            return subsistemaDespidos.cambiarEstado(empleadoDTO, nuevoEstado);
        } catch (Exception e) {
            throw new PresentacionException("Error al actualizar el estado del empleado: " + e.getMessage());
        }
    }
}