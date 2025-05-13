package DAO;

import Entidades.Despido;
import Exceptions.AccesoDatosException;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoDAO {

    public DespidoDAO() {
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
