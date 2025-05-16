package Interfaces;

import Excepciones.ObtenerEmpleadoException;
import dto.EmpleadoDTO;

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
}