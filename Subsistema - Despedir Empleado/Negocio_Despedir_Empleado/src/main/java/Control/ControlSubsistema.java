package Control;

import Excepciones.CorreoException;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IDespidoEmpleadoBO;
import Interfaces.IEmpleadoBO;
import SistemaCorreo.PlantillaCorreo;
import SistemaCorreo.RepoPlantillaCorreo;
import SistemaCorreo.TipoPlantillaCorreo;
import bo.DespidoEmpleadoBO;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class ControlSubsistema {

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    private final IDespidoEmpleadoBO despidoBO = DespidoEmpleadoBO.getInstance();
    private final ISistemaCorreo sistemaCorreo = new SistemaCorreo.SistemaCorreo();

    public EmpleadoDTO cambiarEstado(EmpleadoDTO empleadoDTO, String estado) throws CorreoException {
        try {
            empleadoBO.actualizarEstadoEmpleado(empleadoDTO.getRfc(), estado);
            return empleadoBO.obtenerEmpleado(empleadoDTO);
        } catch (ObjetosNegocioException e) {
            throw new CorreoException("Error al cambiar el estado del empleado: " + e.getMessage(), e);
        }
    }

    public EmpleadoDTO buscarEmpleadoPorRFC(String rfc) throws CorreoException {
        try {
            EmpleadoDTO empleado = new EmpleadoDTO();
            empleado.setRfc(rfc);
            return empleadoBO.obtenerEmpleado(empleado);
        } catch (ObjetosNegocioException e) {
            throw new CorreoException("Error al buscar empleado: " + e.getMessage(), e);
        }
    }

    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws CorreoException {
        dto.DespidoDTO despidoDTO = new dto.DespidoDTO();
        despidoDTO.setRfcEmpleado(empleadoDTO.getRfc());
        despidoDTO.setMotivo(motivo);
        despidoDTO.setFechaDespido(java.time.LocalDate.now());
        try {
            despidoBO.registrarDespido(despidoDTO);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(ControlSubsistema.class.getName()).log(Level.SEVERE, null, ex);
        }
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