package BOs;

import DAOs.DespidoDAO;
import DAOs.EmpleadoDAO;
import DTOs.DespidoDTO;
import DTOs.EmpleadoDTO;
import Mappers.EmpleadoMapper;

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

    public void registrarDespido(DespidoDTO despidoDTO) {
        // TODO: Implementar la lógica para registrar el despido
        // 1. Convertir DespidoDTO a Entidad Despido (si es necesario)
        // 2. Llamar al DespidoDAO para persistir la información
        despidoDAO.guardarDespido(despidoDTO); // Ejemplo
    }

//    public EmpleadoDTO actualizarEstadoEmpleado(String rfc, String nuevoEstado) {
//        // TODO: Implementar la lógica para actualizar el estado del empleado
//        // 1. Llamar al EmpleadoDAO para obtener la entidad del empleado
//        // 2. Actualizar el estado en la entidad
//        // 3. Llamar al EmpleadoDAO para persistir los cambios
//        // 4. Convertir la entidad actualizada a EmpleadoDTO y devolverla
//        return empleadoDAO.actualizarEstado(rfc, nuevoEstado);
//    }

}