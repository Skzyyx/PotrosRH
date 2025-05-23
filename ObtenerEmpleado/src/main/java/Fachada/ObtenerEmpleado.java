package Fachada;

import Excepciones.ObtenerEmpleadoException;
import Interfaces.IObtenerEmpleado;
import Control.ControlObtenerEmpleado;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import java.util.List;

/**
 * Clase fachada que implementa la interfaz IObtenerEmpleado.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ObtenerEmpleado implements IObtenerEmpleado{
    
    private static ObtenerEmpleado instance;
    /**
     * Constructor por defecto.
     */
    private ObtenerEmpleado() {}
    /**
    * Retorna la única instancia de ObtenerEmpleado.
    * 
    * Usa el patrón Singleton con sincronización para evitar múltiples instancias en entornos concurrentes.
    *
    * @return Instancia única de IObtenerEmpleado.
    */
    public static synchronized IObtenerEmpleado getInstance() {
        if (instance == null) {
            instance = new ObtenerEmpleado();
        }
        return instance;
    }
    /**
     * Obtiene un empleado de la base de datos. Extrae su RFC para
     * dicho fin.
     * @param empleado Objeto DTO que debe contener el RFC del empleado a buscar.
     * @return Empleado encontrado, devuelto como un DTO.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    @Override
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObtenerEmpleadoException {   
        return new ControlObtenerEmpleado().obtenerEmpleado(empleado);
    }
    /**
     * Obtiene un empleado activo de la base de datos. 
     * Extrae su RFC para dicho fin.
     * @param empleado Objeto DTO que debe contener el RFC del empleado a buscar.
     * @return Empleado encontrado, devuelto como un DTO.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObtenerEmpleadoException{
        return new ControlObtenerEmpleado().obtenerEmpleadoActivo(empleado);
    }
    /**
     * Obtiene un empleado activo a partir de su RFC, cuyo departamento es
     * igual a Recursos Humanos.
     * @param empleado Empleado con RFC de búsqueda.
     * @return Empleado de recursos humanos.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoRH(EmpleadoDTO empleado) throws ObtenerEmpleadoException{
        return new ControlObtenerEmpleado().obtenerEmpleadoRH(empleado);
    }
    
    @Override
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws ObtenerEmpleadoException {
        return new ControlObtenerEmpleado().obtenerTodosSinContrato(filtro);
    }
    
    /**
     * Inserta empleados por default en la base de datos.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    @Override
    public void insertarEmpleadosDefault() throws ObtenerEmpleadoException{
        new ControlObtenerEmpleado().insertarEmpleadosDefault();
    }
}