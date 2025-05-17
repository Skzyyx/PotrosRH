/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Contrato;
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
import com.mongodb.client.result.InsertOneResult;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author skyro
 */
public class EvaluacionDAO implements IEvaluacionDAO {

    private static final Logger LOG = Logger.getLogger(ContratoDAO.class.getName());

    private final MongoCollection<Evaluacion> evaluacionesCollection;

    public EvaluacionDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.evaluacionesCollection = database.getCollection("evaluaciones", Evaluacion.class);
    }
    
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
            InsertOneResult result = evaluacionesCollection.insertOne(evaluacion);
            ObjectId idGenerado = result.getInsertedId().asObjectId().getValue();
            evaluacion.setId(idGenerado);
            return evaluacion;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al intentar registrar la evaluación.");
        }
    }

}
