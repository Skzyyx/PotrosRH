package Interfaces;

import Excepciones.ObtenerEmpleadoException;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import java.util.List;

/**
 * 
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */

/**
 * Obtiene un empleado a partir de su RFC.Delega la operación al ControlObtenerEmpleado.
 * @throws ObtenerEmpleadoException si el RFC es inválido o ocurre un error durante la obtención.
 */
public interface IObtenerEmpleado {
    /**
     * Obtiene un empleado de la base de datos. Extrae su RFC para
     * dicho fin.
     * @param empleado Objeto DTO que debe contener el RFC del empleado a buscar.
     * @return Empleado encontrado, devuelto como un DTO.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObtenerEmpleadoException;
    /**
     * Obtiene un empleado activo de la base de datos. 
     * Extrae su RFC para dicho fin.
     * @param empleado Objeto DTO que debe contener el RFC del empleado a buscar.
     * @return Empleado encontrado, devuelto como un DTO.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObtenerEmpleadoException;
    /**
     * Obtiene un empleado activo a partir de su RFC, cuyo departamento es
     * igual a Recursos Humanos.
     * @param empleado Empleado con RFC de búsqueda.
     * @return Empleado de recursos humanos.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    public EmpleadoDTO obtenerEmpleadoRH(EmpleadoDTO empleado) throws ObtenerEmpleadoException;
    
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws ObtenerEmpleadoException;
    /**
     * Inserta empleados por default en la base de datos.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    public void insertarEmpleadosDefault() throws ObtenerEmpleadoException;
}