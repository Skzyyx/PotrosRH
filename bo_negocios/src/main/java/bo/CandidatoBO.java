/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.CandidatoDAO;
import Entidades.Candidato;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.ICandidatoBO;
import Interfaces.ICandidatoDAO;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.CandidatoMapper;
import org.bson.conversions.Bson;

/**
 * Objeto de negocio CandidatoBO. Implementa la interfaz ICandidatoBO y
 * proporciona la lógica de negocio para gestionar candidatos en el sistema.
 * Actúa como intermediario entre la capa de presentación y la capa de acceso a
 * datos, aplicando reglas de negocio y validaciones.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class CandidatoBO implements ICandidatoBO {

    /**
     * Instancia única de la clase (patrón Singleton).
     */
    private static CandidatoBO instance;

    /**
     * Objeto DAO para operaciones CRUD con Candidatos.
     */
    private ICandidatoDAO candidatoDAO = new CandidatoDAO();

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private CandidatoBO() {
    }

    /**
     * Método para obtener la instancia única de la clase (patrón Singleton).
     *
     * @return Instancia única de CandidatoBO
     */
    public static synchronized ICandidatoBO getInstance() {
        if (instance == null) {
            instance = new CandidatoBO();
        }
        return instance;
    }

    /**
     * Registra un nuevo candidato en el sistema.
     *
     * @param candidato El objeto CandidatoDTO con la información del candidato
     * a registrar
     * @return El objeto CandidatoDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si ya existe un candidato con el mismo RFC
     */
    @Override
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws ObjetosNegocioException {
        if (candidato == null) {
            throw new ObjetosNegocioException("El candidato no puede ser nulo.");
        }

        try {
            Candidato map = CandidatoMapper.toEntityNuevo(candidato);
            return CandidatoMapper.toDTOViejo(candidatoDAO.registrarCandidato(map));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

    /**
     * Busca y recupera un candidato según su RFC.
     *
     * @param candidato El objeto CandidatoDTO con el RFC del candidato a buscar
     * @return El objeto CandidatoDTO encontrado, o null si no existe
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    @Override
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws ObjetosNegocioException {
        try {
            return CandidatoMapper.toDTOViejo(candidatoDAO.obtenerCandidato(candidato.getRfc()));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

    /**
     * Recupera todos los candidatos almacenados en el sistema.
     *
     * @return Una lista con todos los objetos CandidatoDTO disponibles
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    @Override
    public List<CandidatoDTO> obtenerTodos() throws ObjetosNegocioException {
        try {
            return CandidatoMapper.toDTOViejoList(candidatoDAO.obtenerTodos());
        } catch (AccesoDatosException ex) {
            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

    /**
     * Recupera candidatos que cumplen con los criterios de filtrado
     * especificados.
     *
     * @param filtro Objeto CandidatoFiltroDTO con los criterios de filtrado
     * @return Lista de objetos CandidatoDTO que cumplen con los criterios
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    @Override
    public List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws ObjetosNegocioException {
        List<Bson> filters = new ArrayList<>();

        if (filtro.getRfc() != null && !filtro.getRfc().isBlank()) {
            filters.add(Filters.regex("rfc", ".*" + filtro.getRfc() + ".*", "i")); // Contiene, ignorando mayúsculas
        }

        if (filtro.getEmail() != null && !filtro.getEmail().isBlank()) {
            filters.add(Filters.regex("email", ".*" + filtro.getEmail() + ".*", "i"));
        }

        if (filtro.getTelefono() != null && !filtro.getTelefono().isBlank()) {
            filters.add(Filters.regex("telefono", ".*" + filtro.getTelefono() + ".*", "i"));
        }

        List<Bson> pipeline = new ArrayList<>();

        if (!filters.isEmpty()) {
            pipeline.add(Aggregates.match(Filters.and(filters)));
        }

        try {
            return CandidatoMapper.toDTOViejoList(candidatoDAO.obtenerPorFiltro(pipeline));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
}
