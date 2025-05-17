/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Candidato;
import Exceptions.AccesoDatosException;
import Interfaces.ICandidatoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author skyro
 */
public class CandidatoDAO implements ICandidatoDAO {

    private static final Logger LOG = Logger.getLogger(CandidatoDAO.class.getName());

    private final MongoCollection<Candidato> candidatosCollection;

    public CandidatoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.candidatosCollection = database.getCollection("candidatos", Candidato.class);
    }

    @Override
    public Candidato registrarCandidato(Candidato candidato) throws AccesoDatosException {
        try {
            // Verifica si ya existe un candidato con el mismo nombre
            Candidato existente = candidatosCollection
                    .find(Filters.eq("rfc", candidato.getRfc()))
                    .first();

            if (existente != null) {
                throw new AccesoDatosException("Ya existe un candidato con el rfc: " + candidato.getRfc());
            }

            InsertOneResult result = candidatosCollection.insertOne(candidato);
            ObjectId idGenerado = result.getInsertedId().asObjectId().getValue();
            candidato.setId(idGenerado);
            return candidato;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al intentar registrar el candidato.");
        }
    }

    @Override
    public Candidato obtenerCandidato(String rfc) throws AccesoDatosException {
        try {
            return candidatosCollection.find(Filters.eq("rfc", rfc)).first();
        } catch (MongoException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al intentar obtener el candidato.");
        }
    }

    @Override
    public List<Candidato> obtenerTodos() throws AccesoDatosException {
        try {
            return candidatosCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new AccesoDatosException("Error al consultar todos los candidatos.", e);
        }
    }

}
