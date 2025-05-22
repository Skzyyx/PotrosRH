package Interfaces;

import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import java.util.List;

/**
 * Interfaz que declara los métodos de EmpleadoBO.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoBO {

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC. Si el RFC es
     * inválido o el empleado no se encuentra en la lista, lanza una excepción.
     *
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no
     * está registrado.
     */
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException;

    /**
     * Obtiene un empleado a partir de su ID.
     *
     * @param empleado Objeto EmpleadoDTO con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws ObjetosNegocioException Exceción del proyecto EmpleadoBO.
     */
    public EmpleadoDTO obtenerEmpleadoId(EmpleadoDTO empleado) throws ObjetosNegocioException;

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC, cuyo estado sea
     * ACTIVO. Si el RFC es inválido o el empleado no se encuentra en la lista,
     * lanza una excepción.
     *
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no
     * está registrado.
     */
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObjetosNegocioException;
    
    /**
     * Obtiene un empleado activo a partir de su RFC, cuyo departamento es
     * igual a Recursos Humanos.
     * @param empleado Empleado con RFC de búsqueda.
     * @return Empleado de recursos humanos.
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    public EmpleadoDTO obtenerEmpleadoRH(EmpleadoDTO empleado) throws ObjetosNegocioException;
    
    /**
     * Actualiza el estado de un empleado directamente en la base de datos.
     *
     * @param rfc RFC del empleado cuyo estado se va a actualizar
     * @param nuevoEstado Nuevo estado que se asignará al empleado
     * @return El objeto EmpleadoDTO con la información actualizada del empleado
     * @throws ObjetosNegocioException Si ocurre un error durante la
     * actualización o si el empleado no existe
     * @throws AccesoDatosException Si ocurre un error al acceder a la base de
     * datos
     */
    public EmpleadoDTO actualizarEstadoEmpleadoD(String rfc, String nuevoEstado) throws ObjetosNegocioException, AccesoDatosException;

    /**
     * Registra un nuevo empleado en el sistema.
     *
     * @param empleado El objeto EmpleadoDTO con la información del empleado a
     * registrar
     * @return El objeto EmpleadoDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si ya existe un empleado con el mismo RFC
     */
    public EmpleadoDTO registrarEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException;

    /**
     * Recupera todos los empleados que no tienen contrato asociado y que
     * cumplen con los criterios de filtrado especificados.
     *
     * @param filtro Objeto EmpleadoFiltroDTO con los criterios de filtrado
     * @return Lista de objetos EmpleadoDTO que cumplen con los criterios
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws ObjetosNegocioException;
}
