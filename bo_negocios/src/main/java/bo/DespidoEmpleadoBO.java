package bo;

import DAO.DespidoDAO;
import DAO.EmpleadoDAO;
import Entidades.Despido;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.DespidoDTO;
import enums.EstadoEmpleado;
import mappers.EmpleadoMapper;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoEmpleadoBO {
    private final EmpleadoDAO empleadoDAO;
    private final DespidoDAO despidoDAO;
    private final EmpleadoMapper empleadoMapper;

    public DespidoEmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
        this.despidoDAO = new DespidoDAO();
        this.empleadoMapper = new EmpleadoMapper();
    }

    /**
     * Método para registrar un despido.
     * Convierte el DespidoDTO en una entidad Despido y lo guarda en la base de datos.
     *
     * @param despidoDTO El DTO con la información del despido.
     */
    public void registrarDespido(DespidoDTO despidoDTO) {
        Despido despidoEntity = new Despido(
            despidoDTO.getIdDespido(),
            despidoDTO.getRfcEmpleado(),
            despidoDTO.getFechaDespido(),
            despidoDTO.getMotivo()
        );
        // Llamar al DespidoDAO para guardar el despido en la base de datos
        despidoDAO.guardarDespido(despidoEntity);
    }

    /**
     * Método para actualizar el estado de un empleado en la base de datos.
     * 
     * @param rfc El RFC del empleado cuyo estado se desea actualizar.
     * @param nuevoEstado El nuevo estado que se desea asignar al empleado.
     * @return El DTO con la información actualizada del empleado.
     */
    public boolean actualizarEstadoEmpleado(String rfc, String nuevoEstado) throws ObjetosNegocioException, AccesoDatosException {
        Empleado empleado = empleadoDAO.obtenerEmpleado(rfc);

        if (empleado == null) {
            throw new ObjetosNegocioException("Empleado no encontrado con el RFC: " + rfc);
        }

        if (empleado.getEstado() != EstadoEmpleado.ACTIVO) {
            throw new ObjetosNegocioException("No se puede despedir un empleado que ya ha sido despedido.");
        }
        
        return true;
                //empleadoDAO.actualizarEmpleado(rfc, EstadoEmpleado.INACTIVO);
    }
}