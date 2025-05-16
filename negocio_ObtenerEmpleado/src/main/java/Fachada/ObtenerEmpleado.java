package Fachada;

import Excepciones.ObtenerEmpleadoException;
import Interfaces.IObtenerEmpleado;
import Control.ControlObtenerEmpleado;
import dto.EmpleadoDTO;

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
}