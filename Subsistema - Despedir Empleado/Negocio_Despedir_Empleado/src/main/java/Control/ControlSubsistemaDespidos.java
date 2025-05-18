package Control;

import Excepciones.CorreoException;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IDespidoEmpleadoBO;
import Interfaces.IEmpleadoBO;
import Interfaz.IDespedirEmpleado;
import SistemaCorreo.PlantillaCorreo;
import SistemaCorreo.RepoPlantillaCorreo;
import SistemaCorreo.TipoPlantillaCorreo;
import bo.DespidoEmpleadoBO;
import bo.EmpleadoBO;
import dto.CorreoDTO;
import dto.EmpleadoDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz {IDespedirEmpleado} y coordina las operaciones
 * relacionadas con el despido de empleados, incluyendo la actualización del estado,
 * el registro del despido y el envío de una notificación por correo
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */

public class ControlSubsistemaDespidos implements IDespedirEmpleado{

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    private final IDespidoEmpleadoBO despidoBO = DespidoEmpleadoBO.getInstance();
    private final ISistemaCorreo sistemaCorreo = new SistemaCorreo.SistemaCorreo();

    /**
     * Cambia el estado de un empleado a un nuevo estado especificado
     *
     * @param empleadoDTO El DTO del empleado cuyo estado se va a modificar
     * @param estado      El nuevo estado que se asignará al empleado
     * @return El DTO del empleado con el estado actualizado
     * @throws CorreoException Si los datos de entrada son incompletos o si ocurre un error
     * al actualizar el estado del empleado en la capa de negocio
     */
    @Override
    public EmpleadoDTO cambiarEstado(EmpleadoDTO empleadoDTO, String estado) throws CorreoException {
        if (empleadoDTO == null || empleadoDTO.getRfc() == null || empleadoDTO.getRfc().isEmpty() || estado == null || estado.isEmpty()) {
            throw new CorreoException("Error: Datos incompletos para cambiar el estado del empleado.");
        }
        try {
            try {
                empleadoBO.actualizarEstadoEmpleadoD(empleadoDTO.getRfc(), "INACTIVO");
            } catch (AccesoDatosException ex) {
                Logger.getLogger(ControlSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return empleadoBO.obtenerEmpleado(empleadoDTO);
        } catch (ObjetosNegocioException e) {
            throw new CorreoException("Error al cambiar el estado del empleado: " + e.getMessage(), e);
        }
    }

    /**
     * Busca un empleado por su RFC
     *
     * @param rfc El RFC del empleado a buscar
     * @return El DTO del empleado encontrado
     * @throws CorreoException           Si el RFC proporcionado está vacío o si ocurre un error
     * al buscar el empleado en la capa de negocio
     * @throws ObjetosNegocioException Si no se encuentra ningún empleado con el RFC proporcionado
     */
    @Override
    public EmpleadoDTO buscarEmpleadoPorRFC(String rfc) throws CorreoException, ObjetosNegocioException {
        if (rfc == null || rfc.isEmpty()) {
            throw new ObjetosNegocioException("Error: El RFC no puede estar vacío para buscar un empleado.");
        }
        try {
            EmpleadoDTO empleado = new EmpleadoDTO();
            empleado.setRfc(rfc);
            return empleadoBO.obtenerEmpleado(empleado);
        } catch (ObjetosNegocioException e) {
            throw new CorreoException("Error al buscar empleado: " + e.getMessage(), e);
        }
    }

    /**
     * Registra el despido de un empleado, actualiza su estado a "INACTIVO" y envía una
     * notificación por correo al empleado
     *
     * @param empleadoDTO El DTO del empleado que será despedido
     * @param motivo      El motivo del despido
     * @throws CorreoException           Si los datos de entrada son incompletos o si ocurre un error
     * al registrar el despido o al enviar el correo electrónico
     * @throws ObjetosNegocioException Si ocurre un error en la lógica de negocio al registrar el despido.
     */
    @Override
    public void registrarDespido(EmpleadoDTO empleadoDTO, String motivo) throws CorreoException, ObjetosNegocioException {
        if (empleadoDTO == null || empleadoDTO.getRfc() == null || empleadoDTO.getRfc().isEmpty() || motivo == null || motivo.isEmpty()) {
            throw new ObjetosNegocioException("Error: Datos incompletos para registrar el despido.");
        }
        dto.DespidoDTO despidoDTO = new dto.DespidoDTO();
        despidoDTO.setRfcEmpleado(empleadoDTO.getRfc());
        despidoDTO.setMotivo(motivo);
        despidoDTO.setFechaDespido(java.time.LocalDate.now());
        try {
            despidoBO.registrarDespido(despidoDTO);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(ControlSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
            throw new CorreoException("Error al registrar el despido: " + ex.getMessage(), ex); // Lanza una CorreoException
        }

        try {
            cambiarEstado(empleadoDTO, "INACTIVO");
        } catch (CorreoException ex) {
            Logger.getLogger(ControlSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
            throw new CorreoException("Error al cambiar el estado del empleado: " + ex.getMessage(), ex);
        }

        // Crear el CorreoDTO y enviarlo
        try {
            CorreoDTO correoDespidoDTO = crearCorreoDespidoDTO(empleadoDTO, motivo);
            if (correoDespidoDTO != null) {
                sistemaCorreo.sendEmail(correoDespidoDTO);
                System.out.println("Correo de despido enviado a: " + correoDespidoDTO.getCorreoReceptor());
            } else {
                System.err.println("No se pudo crear el CorreoDTO para el envío.");
                throw new CorreoException("Error al crear el CorreoDTO para el envío.");
            }
        } catch (CorreoException ex) {
            Logger.getLogger(ControlSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
            throw new CorreoException("Error al enviar el correo de despido: " + ex.getMessage(), ex); 
        }
    }


    /**
     * Crea un objeto {CorreoDTO} con la información necesaria para enviar la
     * notificación de despido al empleado, utiliza la plantilla de correo de despido
     * y los datos del empleado para formatear el cuerpo del correo
     *
     * @param empleadoDTO El DTO del empleado despedido, conteniendo su nombre completo y correo
     * @return Un objeto {CorreoDTO} listo para ser enviado, o {CorreoException} si no se encuentra la plantilla de correo.
     */
    private CorreoDTO crearCorreoDespidoDTO(EmpleadoDTO empleadoDTO, String motivo) throws CorreoException {
        PlantillaCorreo plantillaDespido = RepoPlantillaCorreo.getTemplate(TipoPlantillaCorreo.DESPIDO);
        if (plantillaDespido != null) {
            Map<String, Object> valores = new HashMap<>();
            valores.put("nombre", empleadoDTO.getNombre() + " " + empleadoDTO.getApellidoPaterno()
                    + " " + empleadoDTO.getApellidoMaterno());
            valores.put("fechaDespido", java.time.LocalDate.now().toString());
            valores.put("razonDespido", motivo);

            CorreoDTO correoDTO = new CorreoDTO();
            correoDTO.setCorreoReceptor(empleadoDTO.getEmail());
            correoDTO.setPlantillaCorreo("DESPIDO");
            correoDTO.setValues(valores);

            return correoDTO;
        } else {
            throw new CorreoException("No se encontró la plantilla de correo para el despido."); // Lanza una CorreoException
        }
    }
}