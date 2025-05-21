package Interfaces;

import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import java.util.List;

/**
 * Interfaz que declara los métodos de EmpleadoBO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoBO {
    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC.
     * Si el RFC es inválido o el empleado no se encuentra en la lista, lanza una excepción.
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no está registrado.
     */
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException;
    /**
     * Obtiene un empleado a partir de su ID.
     * @param empleado Objeto EmpleadoDTO con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws ObjetosNegocioException Exceción del proyecto EmpleadoBO.
     */
    public EmpleadoDTO obtenerEmpleadoId(EmpleadoDTO empleado) throws ObjetosNegocioException;
    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC, cuyo estado sea ACTIVO.
     * Si el RFC es inválido o el empleado no se encuentra en la lista, lanza una excepción.
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no está registrado.
     */
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObjetosNegocioException;
    
    public EmpleadoDTO actualizarEstadoEmpleado(String rfc, String nuevoEstado) throws ObjetosNegocioException;
    
    public EmpleadoDTO actualizarEstadoEmpleadoD(String rfc, String nuevoEstado) throws ObjetosNegocioException, AccesoDatosException;
    
    public EmpleadoDTO registrarEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException;
    
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws ObjetosNegocioException;
}