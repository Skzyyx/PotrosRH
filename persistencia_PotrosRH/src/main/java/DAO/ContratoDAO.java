/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Candidato;
import Entidades.Contrato;
import Exceptions.AccesoDatosException;
import Interfaces.IContratoDAO;
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
public class ContratoDAO implements IContratoDAO {

    private static final Logger LOG = Logger.getLogger(ContratoDAO.class.getName());

    private final MongoCollection<Contrato> contratosCollection;

    public ContratoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.contratosCollection = database.getCollection("contratos", Contrato.class);
    }
    
    @Override
    public Contrato registrarContrato(Contrato contrato) throws AccesoDatosException {
        try {
            Bson match = Aggregates.match(Filters.eq("empleadoId", contrato.getEmpleadoId()));
            // Verifica si ya existe un candidato con el mismo nombre
            AggregateIterable<Contrato> resultado = contratosCollection.aggregate(Arrays.asList(
                    match
            ));


            if (resultado.iterator().hasNext()) {
                throw new AccesoDatosException("Ya existe un contrato para ese empleado.");
            }

            InsertOneResult result = contratosCollection.insertOne(contrato);
            ObjectId idGenerado = result.getInsertedId().asObjectId().getValue();
            contrato.setId(idGenerado);
            return contrato;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al intentar registrar el candidato.");
        }
    }
    
}
