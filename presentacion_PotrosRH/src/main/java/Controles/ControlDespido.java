package Controles;

import Excepciones.PresentacionException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import java.time.LocalDate;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class ControlDespido {

    private final ControlSubsistemaDespido subsistemaDespido = new ControlSubsistemaDespido();

    public EmpleadoDTO buscarEmpleadoPorRFC(String rfc) throws PresentacionException, ObjetosNegocioException {
        try {
            return subsistemaDespido.buscarEmpleadoPorRFC(rfc);
        } catch (ObjetosNegocioException e) {
            throw new ObjetosNegocioException("Error al buscar empleado: " + e.getMessage());
        }
    }

    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws ObjetosNegocioException {
        // 1. Crear el DTO de Despido
        dto.DespidoDTO despidoDTO = new dto.DespidoDTO();
        despidoDTO.setRfcEmpleado(empleadoDTO.getRfc());
        despidoDTO.setMotivo(motivo);
        despidoDTO.setFechaDespido(LocalDate.now());
        // 2. Llamar al subsistema de Despido para registrar el despido
        // TODO: Crear método en ControlSubsistemaDespido para registrar el despido
        // subsistemaDespido.registrarDespido(despidoDTO);
        try {
            // 3. Cambiar el estado del empleado a través del subsistema
            subsistemaDespido.actualizarEstadoEmpleado(empleadoDTO.getRfc(), "INACTIVO");
            
            // 4. Enviar notificación por correo electrónico (esto podría ser otro subsistema o un servicio)
            
        } catch (ObjetosNegocioException e) {
            throw new ObjetosNegocioException("Error al registrar despido: " + e.getMessage());
        }
    }

    public EmpleadoDTO actualizarEstadoEmpleado(String rfc, String nuevoEstado) throws PresentacionException, ObjetosNegocioException {
        try {
            return subsistemaDespido.actualizarEstadoEmpleado(rfc, nuevoEstado);
        } catch (ObjetosNegocioException e) {
            throw new ObjetosNegocioException("Error al actualizar el estado del empleado: " + e.getMessage());
        }
    }
}
