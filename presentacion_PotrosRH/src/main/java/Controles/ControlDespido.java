package Controles;

import Excepciones.PresentacionException;
import bo.EmpleadoBO;
import dto.DespidoDTO;
import dto.EmpleadoDTO;


/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class ControlDespido {
    
    private final EmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    
    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws PresentacionException {
        try {
            // 1. Crear la entidad de Despido
            DespidoDTO despido = new DespidoDTO();
            despido.setRfcEmpleado(empleadoDTO.getRfc());
            despido.setMotivo(motivo);
            despido.setFechaDespido(new java.sql.Date(System.currentTimeMillis()));

            // 2. Guardar el registro de despido en la base de datos (usando un DAODespido)
            // TODO: Crear la clase DespidoDAO y su método guardarDespido
            // DespidoDAO despidoDAO = new DespidoDAO();
            // despidoDAO.guardarDespido(despido);

            // 3. Cambiar el estado del empleado a "despedido"
            EmpleadoDTO empleado = empleadoBO.obtenerEmpleado(empleadoDTO.getRfc());
            if (empleado != null) {
                empleado.setEstado("despedido");
                empleadoBO.actualizarEmpleado(empleado);
            } else {
                throw new PresentacionException("No se encontró el empleado para actualizar su estado.");
            }

            // 4. Enviar notificación por correo electrónico
            // ...
        } catch (Exception e) {
            throw new PresentacionException("Error al registrar el despido: " + e.getMessage());
        }
    }
}
