package bo;

import DAO.DespidoDAO;
import DAO.EmpleadoDAO;
import Entidades.Despido;
import Entidades.Empleado;
import Enums.EstadoEmpleado;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IDespidoEmpleadoBO;
import dto.DespidoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoEmpleadoBO implements IDespidoEmpleadoBO {
    private final EmpleadoDAO empleadoDAO;
    private final DespidoDAO despidoDAO;
    private static DespidoEmpleadoBO instance;

    public DespidoEmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
        this.despidoDAO = new DespidoDAO();
    }

    /**
     * Método SingleTon de la clase.
     * @return Instancia SingleTon de la clase.
     */
    public static synchronized DespidoEmpleadoBO getInstance() {
        if (instance == null) {
            instance = new DespidoEmpleadoBO();
        }
        return instance;
    }

    /**
     * Método para registrar un despido.
     * Convierte el DespidoDTO en una entidad Despido y lo guarda en la base de datos.
     *
     * @param despidoDTO El DTO con la información del despido.
     */
    @Override
    public void registrarDespido(DespidoDTO despidoDTO) throws AccesoDatosException {
        Despido despidoEntity = new Despido(
            despidoDTO.getIdDespido(),
            despidoDTO.getRfcEmpleado(),
            despidoDTO.getFechaDespido(),
            despidoDTO.getMotivo()
        );
        despidoDAO.guardarDespido(despidoEntity);
    }

    /**
     * Método para actualizar el estado de un empleado en la base de datos.
     * 
     * @param rfc El RFC del empleado cuyo estado se desea actualizar.
     * @param nuevoEstado El nuevo estado que se desea asignar al empleado.
     * @return El DTO con la información actualizada del empleado. segun se arreglo esto lmao
     */
    @Override
    public void actualizarEstadoEmpleado(String rfc) throws ObjetosNegocioException, AccesoDatosException {
        Empleado empleado = new Empleado();
        empleado.setRfc(rfc);
        empleado = empleadoDAO.obtenerEmpleado(empleado);

        if (empleado == null) {
            throw new ObjetosNegocioException("Empleado no encontrado con el RFC: " + rfc);
        }

        if (empleado.getEstado() != EstadoEmpleado.ACTIVO) {
            throw new ObjetosNegocioException("No se puede despedir un empleado que ya ha sido despedido.");
        }
        
        empleado.setEstado(EstadoEmpleado.INACTIVO);
    }
}