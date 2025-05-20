package Interfaz;

import Excepciones.CorreoException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IDespedirEmpleado {

    /**
     * Cambia el estado de un empleado a un nuevo estado especificado
     *
     * @param empleadoDTO El DTO del empleado cuyo estado se va a modificar
     * @param estado      El nuevo estado que se asignará al empleado
     * @return El DTO del empleado con el estado actualizado
     * @throws CorreoException Si ocurre un error al cambiar el estado
     */
    EmpleadoDTO cambiarEstado(EmpleadoDTO empleadoDTO, String estado) throws CorreoException;

    /**
     * Registra el despido de un empleado, actualiza su estado a "INACTIVO" y envía una
     * notificación por correo al empleado
     *
     * @param empleadoDTO El DTO del empleado que será despedido
     * @param motivo      El motivo del despido
     * @throws CorreoException           Si ocurre un error al registrar el despido o enviar el correo.
     * @throws ObjetosNegocioException Si ocurre un error en la lógica de negocio
     */
    void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws CorreoException, ObjetosNegocioException;
}