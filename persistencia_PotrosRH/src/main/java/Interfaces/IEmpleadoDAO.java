package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import java.util.List;
import org.bson.conversions.Bson;

/**
 * Interfaz para clases EmpleadoDAO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoDAO {
    /**
     * Obtiene un empleado de la base de datos.
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Empleado obtenerEmpleado(Empleado empleado) throws AccesoDatosException;
    /**
     * Obtiene un empleado a partir de su ID.
     * @param empleado Entidad empleado con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws AccesoDatosException Exceción del proyecto DAO.
     */
    public Empleado obtenerEmpleadoId(Empleado empleado) throws AccesoDatosException;
    /**
     * Obtiene un empleado activo de la base de datos.
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Empleado obtenerEmpleadoActivo(Empleado empleado) throws AccesoDatosException;
    
    public void actualizarEmpleado(Empleado empleado) throws AccesoDatosException;
    
    public Empleado registrarEmpleado(Empleado empleado) throws AccesoDatosException;
    
    public void actualizarEstado(String rfc, String nuevoEstado) throws AccesoDatosException;
    
    public List<Empleado> obtenerTodosSinContrato(List<Bson> pipeline) throws AccesoDatosException;
}