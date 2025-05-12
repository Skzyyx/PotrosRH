package DAOs;

import DTOs.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IEmpleadoDAO {
    public EmpleadoDTO obtenerEmpleadoPorRFC(String rfc);
    public EmpleadoDTO actualizarEstado(String rfc, String nuevoEstado);
}
