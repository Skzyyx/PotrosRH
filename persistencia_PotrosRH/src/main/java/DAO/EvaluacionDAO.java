/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Evaluacion;
import Enums.ResultadoEvaluacion;
import Exceptions.AccesoDatosException;
import Interfaces.IEvaluacionDAO;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

/**
 * Esta clase implementa la interfaz IEvaluacionDAO y proporciona métodos para
 * gestionar evaluaciones de candidatos en la base de datos MongoDB. Permite 
 * registrar nuevas evaluaciones verificando que no exista una evaluación previa
 * aprobada para el mismo candidato.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class EvaluacionDAO implements IEvaluacionDAO {

    /**
     * Logger para registrar mensajes y excepciones de la clase.
     */
    private static final Logger LOG = Logger.getLogger(ContratoDAO.class.getName());

    /**
     * Colección de MongoDB que almacena los documentos de evaluaciones.
     */
    private final MongoCollection<Evaluacion> evaluacionesCollection;

    /**
     * Constructor que inicializa la conexión a la colección de evaluaciones en MongoDB.
     * Obtiene la base de datos a través de la clase Conexion y configura la colección
     * para trabajar con objetos de tipo Evaluacion.
     */
    public EvaluacionDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.evaluacionesCollection = database.getCollection("evaluaciones", Evaluacion.class);
    }

    /**
     * Registra una nueva evaluación en la base de datos.
     * Verifica que el candidato no tenga una evaluación previa con resultado APROBADO
     * antes de registrar la nueva evaluación.
     *
     * @param evaluacion El objeto Evaluacion que se va a registrar
     * @return La evaluación registrada con éxito
     * @throws AccesoDatosException Si el candidato ya tiene una evaluación aprobada o si ocurre un error en la base de datos
     */
    @Override
    public Evaluacion registrarEvaluacion(Evaluacion evaluacion) throws AccesoDatosException {
        try {
            Bson unwind = Aggregates.unwind("$candidato");
            Bson match = Aggregates.match(Filters.eq("candidato.rfc", evaluacion.getCandidato().getRfc()));
            Bson match2 = Aggregates.match(Filters.eqFull("resultado", ResultadoEvaluacion.APROBADO.toString()));

            AggregateIterable<Evaluacion> resultado = evaluacionesCollection.aggregate(Arrays.asList(
                    unwind,
                    match,
                    match2
            ));

            if (resultado.iterator().hasNext()) {
                throw new AccesoDatosException("El candidato ya tiene una entrevista aprobada asociada.");
            }

            evaluacionesCollection.insertOne(evaluacion);

            return evaluacion;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, null, e);
            throw new AccesoDatosException("Ocurrió un error al intentar registrar la evaluación.");
        }
    }

}
