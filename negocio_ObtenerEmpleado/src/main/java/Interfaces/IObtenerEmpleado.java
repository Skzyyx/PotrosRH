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
    * Obtiene un empleado a partir de su RFC.
    *
    * Delega la operación al ControlObtenerEmpleado.
    *
    * @param rfc RFC del empleado a buscar.
    * @return Objeto EmpleadoDTO con los datos del empleado.
    * @throws ObtenerEmpleadoException si el RFC es inválido o ocurre un error durante la obtención.
    */
    public interface IObtenerEmpleado {
        public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException;
    }