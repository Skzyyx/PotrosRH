package Interfaces;

import Excepciones.ValidarEmpleadoException;
import dto.EmpleadoDTO;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IValidarEmpleado {
    public boolean validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException;    
}