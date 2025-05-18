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
 * Esta clase implementa la interfaz ICandidatoDAO y proporciona métodos para
 * realizar operaciones CRUD relacionadas con la entidad Candidato en la base de
 * datos MongoDB. Incluye funcionalidades para registrar nuevos candidatos,
 * obtener candidatos por RFC y recuperar todos los candidatos almacenados,
 * entre otras.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class CandidatoDAO implements ICandidatoDAO {

    /**
     * Logger para registrar mensajes y excepciones de la clase.
     */
    private static final Logger LOG = Logger.getLogger(CandidatoDAO.class.getName());

    /**
     * Colección de MongoDB que almacena los documentos de candidatos.
     */
    private final MongoCollection<Candidato> candidatosCollection;

    /**
     * Constructor que inicializa la conexión a la colección de candidatos en
     * MongoDB. Obtiene la base de datos a través de la clase Conexion y
     * configura la colección para trabajar con objetos de tipo Candidato.
     */
    public CandidatoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.candidatosCollection = database.getCollection("candidatos", Candidato.class);
    }

    /**
     * Registra un nuevo candidato en la base de datos. Verifica que no exista
     * un candidato con el mismo RFC antes de registrarlo.
     *
     * @param candidato El objeto Candidato que se va a registrar
     * @return El candidato registrado con éxito
     * @throws AccesoDatosException Si ya existe un candidato con el mismo RFC o
     * si ocurre un error en la base de datos
     */
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

            candidatosCollection.insertOne(candidato);

            return candidato;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, null, e);
            throw new AccesoDatosException("Ocurrió un error al intentar registrar el candidato.");
        }
    }

    /**
     * Busca y recupera un candidato por su RFC.
     *
     * @param rfc El RFC del candidato a buscar
     * @return El objeto Candidato encontrado, o null si no existe
     * @throws AccesoDatosException Si ocurre un error al intentar acceder a la base de datos
     */
    @Override
    public Candidato obtenerCandidato(String rfc) throws AccesoDatosException {
        try {
            return candidatosCollection.find(Filters.eq("rfc", rfc)).first();
        } catch (MongoException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al intentar obtener el candidato.");
        }
    }

    /**
     * Recupera todos los candidatos almacenados en la base de datos.
     *
     * @return Una lista con todos los objetos Candidato encontrados
     * @throws AccesoDatosException Si ocurre un error al intentar acceder a la base de datos
     */
    @Override
    public List<Candidato> obtenerTodos() throws AccesoDatosException {
        try {
            return candidatosCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new AccesoDatosException("Error al consultar todos los candidatos.", e);
        }
    }
}
