package Facade;

import Control.ControlSubsistemaDespidos;
import Excepciones.CorreoException;
import Exceptions.ObjetosNegocioException;
import Exceptions.SubsistemaException;
import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoEmpleadoFachada {

    private final ControlSubsistemaDespidos controlDespido = new ControlSubsistemaDespidos();
    private static DespidoEmpleadoFachada instance;

    private DespidoEmpleadoFachada() {
    }

    public static DespidoEmpleadoFachada getInstance() {
        if (instance == null) {
            instance = new DespidoEmpleadoFachada();
        }
        return instance;
    }

    /**
     * Registra el despido de un empleado
     *
     * @param empleadoDTO El DTO del empleado que será despedido
     * @param motivo      El motivo del despido
     * @throws PresentacionException Si ocurre un error durante el registro del despido
     */
    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws SubsistemaException {
        try {
            controlDespido.registrarDespido(empleadoDTO, motivo);
        } catch (CorreoException | ObjetosNegocioException e) {
            throw new SubsistemaException("Error al registrar el despido: " + e.getMessage());
        }
    }

    /**
     * Cambia el estado de un empleado
     *
     * @param empleadoDTO El DTO del empleado
     * @param estado      El nuevo estado
     * @return El DTO del empleado con el estado actualizado
     * @throws PresentacionException Si ocurre un error al cambiar el estado
     */
    public EmpleadoDTO cambiarEstado(EmpleadoDTO empleadoDTO, String estado) throws SubsistemaException {
        try {
            return controlDespido.cambiarEstado(empleadoDTO, estado);
        } catch (CorreoException e) {
            throw new SubsistemaException("Error al cambiar el estado del empleado: " + e.getMessage());
        }
    }
}