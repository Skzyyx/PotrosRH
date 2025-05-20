package Interfaces;

import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.DespidoDTO;

/**
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IDespidoEmpleadoBO {
  /**
     * Registra la información de un despido en el sistema.
     *
     * @param despidoDTO El DTO que contiene los detalles del despido.
     * @throws AccesoDatosException Si ocurre un error al acceder a la capa de datos
     * durante el registro del despido.
     */
    public void registrarDespido(DespidoDTO despidoDTO) throws AccesoDatosException;

    /**
     * Actualiza el estado de un empleado en el sistema, por ejemplo, marcándolo
     * como inactivo o despedido.
     *
     * @param rfc El RFC del empleado cuyo estado se va a actualizar.
     * @throws ObjetosNegocioException Si ocurre un error en la lógica de negocio
     * al intentar actualizar el estado del empleado.
     * @throws AccesoDatosException    Si ocurre un error al acceder a la capa de datos
     * durante la actualización del estado del empleado.
     */
    public void actualizarEstadoEmpleado(String rfc) throws ObjetosNegocioException, AccesoDatosException;
} 