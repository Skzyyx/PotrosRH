package Interfaces;

import Entidades.Despido;
import Exceptions.AccesoDatosException;



/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IDespidoDAO {

    /**
     * Guarda un objeto Despido en la fuente de datos
     * 
     * @param despido El objeto Despido que se desea guardar
     * @throws AccesoDatosException Si ocurre un error durante el proceso de guardado
     */
    public void guardarDespido(Despido despido) throws AccesoDatosException;

    /**
     * Obtiene un objeto Despido asociado al RFC del empleado especificado
     * 
     * @param rfcEmpleado El RFC del empleado cuyo despido se desea obtener
     * @return El objeto Despido correspondiente al RFC, o null si no se encuentra
     * @throws AccesoDatosException Si ocurre un error durante la consulta
     */
    public Despido obtenerDespidoPorRFC(String rfcEmpleado) throws AccesoDatosException;
}
