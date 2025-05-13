package Control;

import Excepciones.CorreoException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import SistemaCorreo.PlantillaCorreo;
import SistemaCorreo.RepoPlantillaCorreo;
import SistemaCorreo.TipoPlantillaCorreo;
import bo.DespidoEmpleadoBO;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class ControlSubsistema {

    private final EmpleadoBO empleadoBO = new EmpleadoBO();
    private final DespidoEmpleadoBO despidoBO = new DespidoEmpleadoBO();
    private final ISistemaCorreo sistemaCorreo = new SistemaCorreo.SistemaCorreo();

    public EmpleadoDTO cambiarEstado(EmpleadoDTO empleadoDTO, String estado) throws CorreoException {
        try {
            empleadoBO.actualizarEstadoEmpleado(empleadoDTO.getRfc(), estado);
            return empleadoBO.obtenerEmpleado(empleadoDTO.getRfc());
        } catch (ObjetosNegocioException e) {
            throw new CorreoException("Error al cambiar el estado del empleado: " + e.getMessage(), e);
        }
    }

    public EmpleadoDTO buscarEmpleadoPorRFC(String rfc) throws CorreoException {
        try {
            return empleadoBO.obtenerEmpleado(rfc);
        } catch (ObjetosNegocioException e) {
            throw new CorreoException("Error al buscar empleado: " + e.getMessage(), e);
        }
    }

    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws CorreoException {
        dto.DespidoDTO despidoDTO = new dto.DespidoDTO();
        despidoDTO.setRfcEmpleado(empleadoDTO.getRfc());
        despidoDTO.setMotivo(motivo);
        despidoDTO.setFechaDespido(java.time.LocalDate.now());
        //despidoBO.registrarDespido(despidoDTO);
        cambiarEstado(empleadoDTO, "INACTIVO");
        enviarCorreoDespido(empleadoDTO);
    }

    private void enviarCorreoDespido(EmpleadoDTO empleadoDTO) throws CorreoException {
        PlantillaCorreo plantillaDespido = RepoPlantillaCorreo.getTemplate(TipoPlantillaCorreo.DESPIDO);
        if (plantillaDespido != null) {
            Map<String, Object> valores = new HashMap<>();
            valores.put("nombre", empleadoDTO.getNombre() + " " + empleadoDTO.getApellidoPaterno()
            + " " + empleadoDTO.getApellidoMaterno());
            valores.put("fechaDespido", java.time.LocalDate.now().toString()); // Formateamos la fecha
            sistemaCorreo.sendEmail(empleadoDTO.getEmail(), plantillaDespido, valores);
            System.out.println("Correo de despido enviado a: " + empleadoDTO.getEmail());
        } else {
            System.err.println("No se encontró la plantilla de correo para DESPIDO.");
        }
    }
}