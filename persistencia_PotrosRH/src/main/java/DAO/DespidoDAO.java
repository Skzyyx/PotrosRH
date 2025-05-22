package DAO;

import Entidades.Despido;
import Exceptions.AccesoDatosException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import Conexion.Conexion; 

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoDAO {

    /**
     * Colección MongoDB donde se almacenan los documentos
     */
    private final MongoCollection<Despido> despidosCollection;

    /**
     * Constructor que inicializa la colección 'despidos' desde la base de datos MongoDB
     */
    public DespidoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.despidosCollection = database.getCollection("despidos", Despido.class);
    }

    /**
     * Guarda un objeto Despido en la colección 'despidos' de MongoDB
     * 
     * @param despido El objeto {@code Despido} que se desea guardar
     * @throws AccesoDatosException Si ocurre un error durante la inserción en la base de datos
     */
    public void guardarDespido(Despido despido) throws AccesoDatosException {
        try {
            despidosCollection.insertOne(despido);
            System.out.println("Despido guardado en la colección 'despidos'.");
        } catch (Exception e) {
            throw new AccesoDatosException("Error al guardar el despido en la colección 'despidos'.", e);
        }
    }

    /**
     * Busca y obtiene un objeto Despido en base al RFC del empleado
     * 
     * @param rfcEmpleado El RFC del empleado cuyo despido se desea consultar
     * @return El objeto Despido correspondiente al RFC, o {@code null} si no se encuentra
     * @throws AccesoDatosException Si ocurre un error al acceder a la base de datos
     */
    public Despido obtenerDespidoPorRFC(String rfcEmpleado) throws AccesoDatosException {
        try {
            return despidosCollection.find(eq("rfcEmpleado", rfcEmpleado)).first();
        } catch (Exception e) {
            throw new AccesoDatosException("Error al obtener el despido por RFC.", e);
        }
    }
}