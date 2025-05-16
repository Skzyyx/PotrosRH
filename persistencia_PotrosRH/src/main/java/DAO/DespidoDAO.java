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

    private final MongoCollection<Despido> despidosCollection;

    public DespidoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.despidosCollection = database.getCollection("despidos", Despido.class);
    }

    public void guardarDespido(Despido despido) throws AccesoDatosException {
        try {
            despidosCollection.insertOne(despido);
            System.out.println("Despido guardado en la colección 'despidos'.");
        } catch (Exception e) {
            throw new AccesoDatosException("Error al guardar el despido en la colección 'despidos'.", e);
        }
    }

    public Despido obtenerDespidoPorRFC(String rfcEmpleado) throws AccesoDatosException {
        try {
            return despidosCollection.find(eq("rfcEmpleado", rfcEmpleado)).first();
        } catch (Exception e) {
            throw new AccesoDatosException("Error al obtener el despido por RFC.", e);
        }
    }
}