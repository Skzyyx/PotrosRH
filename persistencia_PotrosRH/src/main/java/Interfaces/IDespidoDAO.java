package Interfaces;

import Entidades.Despido;
import Exceptions.AccesoDatosException;



/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IDespidoDAO {
    public void guardarDespido(Despido despido) throws AccesoDatosException;
    public Despido obtenerDespidoPorRFC(String rfcEmpleado) throws AccesoDatosException;
}
