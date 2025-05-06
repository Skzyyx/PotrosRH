package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoDAO {
    
    public boolean validarEstado(String rfc) throws AccesoDatosException;
    
    public boolean validarPorcentajeAsistencias(String rfc) throws AccesoDatosException;
    
    public Empleado obtenerEmpleado(String rfc) throws AccesoDatosException;
}