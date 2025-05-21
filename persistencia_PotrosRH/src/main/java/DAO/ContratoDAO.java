/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Contrato;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Interfaces.IContratoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

/**
 * Esta clase implementa la interfaz IContratoDAO y proporciona métodos para
 * gestionar contratos de empleados en la base de datos MongoDB. Permite 
 * registrar nuevos contratos verificando que no exista uno previo para 
 * el mismo empleado.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ContratoDAO implements IContratoDAO {

    /**
     * Logger para registrar mensajes y excepciones de la clase.
     */
    private static final Logger LOG = Logger.getLogger(ContratoDAO.class.getName());

    /**
     * Colección de MongoDB que almacena los documentos de contratos.
     */
    private final MongoCollection<Contrato> contratosCollection;

    /**
     * Constructor que inicializa la conexión a la colección de contratos en MongoDB.
     * Obtiene la base de datos a través de la clase Conexion y configura la colección
     * para trabajar con objetos de tipo Contrato.
     */
    public ContratoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.contratosCollection = database.getCollection("contratos", Contrato.class);
    }

    /**
     * Registra un nuevo contrato en la base de datos.
     * Verifica que no exista un contrato previo para el mismo empleado antes de registrarlo.
     *
     * @param contrato El objeto Contrato que se va a registrar
     * @return El contrato registrado con éxito
     * @throws AccesoDatosException Si ya existe un contrato para el mismo empleado o si ocurre un error en la base de datos
     */
    @Override
    public Contrato registrarContrato(Contrato contrato) throws AccesoDatosException {
        try {
            Bson unwind = Aggregates.unwind("$empleado");
            Bson match = Aggregates.match(Filters.eq("empleado._id", contrato.getEmpleado().getId()));
            // Verifica si ya existe un candidato con el mismo nombre
            AggregateIterable<Contrato> resultado = contratosCollection.aggregate(Arrays.asList(
                    unwind,
                    match
            ));

            if (resultado.iterator().hasNext()) {
                throw new AccesoDatosException("Ya existe un contrato para ese empleado.");
            }

            contratosCollection.insertOne(contrato);

            return contrato;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, null, e);
            throw new AccesoDatosException("Ocurrió un error al intentar registrar el candidato.");
        }
    }
    
    /**
     * Obtiene la fecha de inicio del contrato de un
     * empleado.
     * @param empleado Empleado asociado al contrato.
     * @return Fecha de inicio del contrato asociado al empleado.
     * @throws AccesoDatosException Excepción de la capa de Persistencia.
     */
    @Override
    public LocalDate obtenerFechaInicioContrato(Empleado empleado) throws AccesoDatosException{
        try {
            // Filtro para el id del empleado, asociado al contrato.
            Bson empleadoId = Filters.eq("empleado._id", empleado.getId());
            // Realiza la consulta y obtiene la fecha de inicio del contrato en una entidad Contrato.
            Contrato resultado = contratosCollection.find(empleadoId).projection(Projections.include("fechaInicio")).first();
            // Si la búsqueda fue exitosa, se extrae la fecha de inicio del contrato.
            if(resultado != null && resultado.getFechaInicio() != null)
                return resultado.getFechaInicio();
            else
                return null;
            
        } catch (Exception e) {
            throw new AccesoDatosException("Error al buscar la fecha de inicio del contrato asociado al empleado.");
        }
    }
}
