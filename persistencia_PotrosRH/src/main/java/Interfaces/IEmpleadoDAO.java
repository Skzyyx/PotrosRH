package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import java.util.List;
import org.bson.conversions.Bson;

/**
 * Interfaz para clases EmpleadoDAO.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoDAO {

    /**
     * Obtiene un empleado de la base de datos.
     *
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la
     * BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Empleado obtenerEmpleado(Empleado empleado) throws AccesoDatosException;

    /**
     * Obtiene un empleado a partir de su ID.
     *
     * @param empleado Entidad empleado con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws AccesoDatosException Exceción del proyecto DAO.
     */
    public Empleado obtenerEmpleadoId(Empleado empleado) throws AccesoDatosException;

    /**
     * Obtiene un empleado activo de la base de datos.
     *
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la
     * BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Empleado obtenerEmpleadoActivo(Empleado empleado) throws AccesoDatosException;
    /**
     * Obtiene un empleado cuyo departamento es el de Recursos Humanos.
     * @param empleado Empleado con RFC a buscar.
     * @return Empleado de Recursos Humanos.
     * @throws AccesoDatosException 
     */
    public Empleado obtenerEmpleadoRH(Empleado empleado) throws AccesoDatosException;

    /**
     * Registra un nuevo empleado en el sistema de persistencia.
     *
     * @param empleado El objeto Empleado que se va a registrar
     * @return El objeto Empleado registrado, posiblemente con identificadores
     * generados
     * @throws AccesoDatosException Si ocurre un error durante el registro o si
     * ya existe un empleado con el mismo RFC
     */
    public Empleado registrarEmpleado(Empleado empleado) throws AccesoDatosException;

    /**
     * Actualiza el estado de un empleado identificado por su RFC.
     *
     * @param rfc RFC del empleado cuyo estado se va a actualizar
     * @param nuevoEstado Nuevo estado que se asignará al empleado
     * @throws AccesoDatosException Si ocurre un error durante la actualización
     * o si el empleado no existe
     */
    public void actualizarEstado(String rfc, String nuevoEstado) throws AccesoDatosException;

    /**
     * Recupera todos los empleados que no tienen contrato asociado y que
     * cumplen con los criterios especificados en el pipeline de agregación.
     *
     * @param pipeline Lista de etapas de agregación para filtrar empleados
     * @return Lista de empleados sin contrato que cumplen con los criterios de
     * filtrado
     * @throws AccesoDatosException Si ocurre un error al consultar la base de
     * datos
     */
    public List<Empleado> obtenerTodosSinContrato(List<Bson> pipeline) throws AccesoDatosException;
}
