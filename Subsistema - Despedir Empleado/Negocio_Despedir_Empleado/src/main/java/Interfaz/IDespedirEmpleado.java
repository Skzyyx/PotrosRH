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
     * Cambia el estado de un empleado.
     * @param empleadoDTO El DTO del empleado a actualizar.
     * @param estado El nuevo estado del empleado.
     * @return El DTO del empleado con el estado actualizado.
     * @throws CorreoException Si hay un error en la operación.
     */
    EmpleadoDTO cambiarEstado(EmpleadoDTO empleadoDTO, String estado) throws CorreoException;

    /**
     * Busca un empleado por su RFC.
     * @param rfc El RFC del empleado a buscar.
     * @return El DTO del empleado encontrado.
     * @throws CorreoException Si hay un error en la operación.
     * @throws ObjetosNegocioException Si no se encuentra el empleado.
     */
    EmpleadoDTO buscarEmpleadoPorRFC(String rfc) throws CorreoException, ObjetosNegocioException;

    /**
     * Registra el despido de un empleado.
     * @param empleadoDTO El DTO del empleado a despedir.
     * @param motivo El motivo del despido.
     * @throws CorreoException Si hay un error en la operación.
     * @throws ObjetosNegocioException Si hay un error en los datos.
     */
    void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws CorreoException, ObjetosNegocioException;
}
