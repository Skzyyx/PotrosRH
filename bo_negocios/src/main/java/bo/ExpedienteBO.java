package bo;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */

import DAO.ExpedienteDAO;
import Entidades.Expediente;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IExpedienteBO;
import Interfaces.IExpedienteDAO;
import dto.ExpedienteDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ExpedienteMapper;

/**
 * Objeto de negocio que maneja la lógica relacionada al expediente laboral.
 * Implementa la interfaz IExpedienteBO y actúa como intermediario entre la
 * presentación y la persistencia.
 * 
 * Permite consultar y actualizar información limitada del expediente.
 * 
 * @author Jose
 */
public class ExpedienteBO implements IExpedienteBO {

    /**
     * Instancia Singleton de la clase.
     */
    private static ExpedienteBO instance;

    /**
     * Objeto DAO para operaciones con expedientes.
     */
    private final IExpedienteDAO expedienteDAO = new ExpedienteDAO();

    /**
     * Constructor privado para implementar Singleton.
     */
    private ExpedienteBO() {
    }

    /**
     * Devuelve la instancia única de ExpedienteBO.
     * 
     * @return Instancia única
     */
    public static synchronized IExpedienteBO getInstance() {
        if (instance == null) {
            instance = new ExpedienteBO();
        }
        return instance;
    }

    /**
     * Consulta un expediente a partir del RFC.
     * 
     * @param rfc RFC del empleado
     * @return DTO del expediente encontrado
     * @throws ObjetosNegocioException Si el RFC es inválido o ocurre un error
     */
    @Override
    public ExpedienteDTO consultarPorRFC(String rfc) throws ObjetosNegocioException {
        if (rfc == null || rfc.trim().isEmpty()) {
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        }

        try {
            Expediente expediente = expedienteDAO.consultarPorRFC(rfc);
            return ExpedienteMapper.toDTO(expediente);
        } catch (AccesoDatosException e) {
            Logger.getLogger(ExpedienteBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }

    /**
     * Actualiza campos modificables de un expediente: sueldo base, departamento, puesto.
     * 
     * @param expedienteDTO Objeto DTO con los nuevos valores
     * @return El expediente actualizado
     * @throws ObjetosNegocioException Si el objeto es inválido o hay error en acceso a datos
     */
    @Override
    public ExpedienteDTO actualizarExpediente(ExpedienteDTO expedienteDTO) throws ObjetosNegocioException {
        if (expedienteDTO == null || expedienteDTO.getId() == null || expedienteDTO.getId().isBlank()) {
            throw new ObjetosNegocioException("El expediente o su ID no pueden ser nulos.");
        }

        try {
            Expediente entidad = ExpedienteMapper.toEntity(expedienteDTO);
            Expediente actualizado = expedienteDAO.actualizarExpediente(entidad);
            return ExpedienteMapper.toDTO(actualizado);
        } catch (AccesoDatosException e) {
            Logger.getLogger(ExpedienteBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }

    /**
     * Verifica si existe un expediente para el RFC dado.
     * 
     * @param rfc RFC a consultar
     * @return true si existe, false si no
     * @throws ObjetosNegocioException Si ocurre un error en acceso a datos
     */
    @Override
    public boolean existeExpedientePorRFC(String rfc) throws ObjetosNegocioException {
        if (rfc == null || rfc.trim().isEmpty()) {
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        }

        try {
            return expedienteDAO.existeExpedientePorRFC(rfc);
        } catch (AccesoDatosException e) {
            Logger.getLogger(ExpedienteBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }
}
