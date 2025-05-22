package DAO;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */

import Conexion.Conexion;
import Entidades.Expediente;
import Exceptions.AccesoDatosException;
import Interfaces.IExpedienteDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;

/**
 * Implementación de IExpedienteDAO que permite consultar y modificar datos
 * de expedientes laborales en MongoDB.
 * 
 * Solo permite consultar por RFC y modificar campos autorizados: sueldoBase, 
 * departamento y puesto.
 * 
 * @author Jose
 */
public class ExpedienteDAO implements IExpedienteDAO {

    private static final Logger LOG = Logger.getLogger(ExpedienteDAO.class.getName());
    private final MongoCollection<Expediente> expedientesCollection;

    /**
     * Constructor que inicializa la conexión con la colección de expedientes.
     */
    public ExpedienteDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.expedientesCollection = database.getCollection("expedientes", Expediente.class);
    }

    /**
     * Consulta un expediente por RFC.
     * 
     * @param rfc RFC del empleado
     * @return El expediente correspondiente si se encuentra
     * @throws AccesoDatosException Si no se encuentra o hay un error
     */
    @Override
    public Expediente consultarPorRFC(String rfc) throws AccesoDatosException {
        try {
            Expediente expediente = expedientesCollection.find(Filters.eq("rfc", rfc)).first();
            if (expediente == null) {
                throw new AccesoDatosException("No se encontró expediente para el RFC proporcionado.");
            }
            return expediente;
        } catch (MongoException e) {
            LOG.log(Level.SEVERE, "Error al consultar expediente por RFC", e);
            throw new AccesoDatosException("Error al consultar expediente por RFC.", e);
        }
    }

    /**
     * Actualiza los campos modificables del expediente: sueldoBase, departamento y puesto.
     * 
     * @param expediente Objeto expediente con ID y nuevos valores
     * @return El expediente actualizado
     * @throws AccesoDatosException Si no se puede actualizar
     */
    @Override
    public Expediente actualizarExpediente(Expediente expediente) throws AccesoDatosException {
        try {
            Bson filtro = Filters.eq("_id", expediente.getId());
            Bson actualizaciones = Updates.combine(
                    Updates.set("sueldoBase", expediente.getSueldoBase()),
                    Updates.set("departamento", expediente.getDepartamento()),
                    Updates.set("puesto", expediente.getPuesto())
            );

            expedientesCollection.updateOne(filtro, actualizaciones);

            Expediente actualizado = expedientesCollection.find(filtro).first();
            if (actualizado == null) {
                throw new AccesoDatosException("No se encontró expediente después de actualizar.");
            }
            return actualizado;

        } catch (MongoException e) {
            LOG.log(Level.SEVERE, "Error al actualizar expediente", e);
            throw new AccesoDatosException("Error al actualizar expediente.", e);
        }
    }

    /**
     * Verifica si existe un expediente con el RFC dado.
     * 
     * @param rfc RFC del empleado
     * @return true si existe, false si no
     * @throws AccesoDatosException Si hay un error en la consulta
     */
    @Override
    public boolean existeExpedientePorRFC(String rfc) throws AccesoDatosException {
        try {
            return expedientesCollection.find(Filters.eq("rfc", rfc)).first() != null;
        } catch (MongoException e) {
            LOG.log(Level.SEVERE, "Error al verificar existencia de expediente", e);
            throw new AccesoDatosException("Error al verificar existencia de expediente.", e);
        }
    }
}
