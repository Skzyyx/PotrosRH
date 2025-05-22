package Controles;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */
import Excepciones.PresentacionException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IExpedienteBO;
import bo.ExpedienteBO;
import dto.ExpedienteDTO;

/**
 * Clase controladora para la gestión del expediente de empleados.
 * Se encarga de coordinar las operaciones de presentación con la lógica de negocio.
 * Aplica el patrón Singleton para asegurar una única instancia.
 * 
 */
public class ControlExpediente {

    /**
     * Instancia única de la clase.
     */
    private static ControlExpediente instance;

    /**
     * Componente de negocio para la gestión de expedientes.
     */
    private final IExpedienteBO expedienteBO = ExpedienteBO.getInstance();

    /**
     * Constructor privado para aplicar el patrón Singleton.
     */
    private ControlExpediente() {
    }

    /**
     * Devuelve la instancia única del controlador.
     *
     * @return Instancia única de ControlExpediente.
     */
    public static ControlExpediente getInstance() {
        if (instance == null) {
            instance = new ControlExpediente();
        }
        return instance;
    }

    /**
     * Actualiza la información editable del expediente.
     *
     * @param expedienteDTO Expediente con los datos actualizados.
     * @return Expediente actualizado.
     * @throws PresentacionException Si ocurre un error durante la actualización.
     * @throws Exceptions.ObjetosNegocioException
     */
    public ExpedienteDTO actualizarExpediente(ExpedienteDTO expedienteDTO) throws PresentacionException, ObjetosNegocioException {
        try {
            return expedienteBO.actualizarExpediente(expedienteDTO);
        } catch (ObjetosNegocioException e) {
            throw new PresentacionException("Error al actualizar expediente: " + e.getMessage(), e);
        }
    }
}
