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
 *
 * @author skyro
 */
public class CandidatoBO implements ICandidatoBO {

    private static CandidatoBO instance;

    private ICandidatoDAO candidatoDAO = new CandidatoDAO();

    private CandidatoBO() {
    }

    public static synchronized ICandidatoBO getInstance() {
        if (instance == null) {
            instance = new CandidatoBO();
        }
        return instance;
    }

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

    @Override
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws ObjetosNegocioException {
        try {
            return CandidatoMapper.toDTOViejo(candidatoDAO.obtenerCandidato(candidato.getRfc()));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

    @Override
    public List<CandidatoDTO> obtenerTodos() throws ObjetosNegocioException {
        try {
            return CandidatoMapper.toDTOViejoList(candidatoDAO.obtenerTodos());
        } catch (AccesoDatosException ex) {
            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

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
