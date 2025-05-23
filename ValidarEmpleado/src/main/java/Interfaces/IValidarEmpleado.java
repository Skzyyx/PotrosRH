package Interfaces;

import Excepciones.ValidarEmpleadoException;
import dto.EmpleadoDTO;

/**
 * Interfaz con métodos para validar un empleado, previo
 * a la generación de su nómina.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IValidarEmpleado {
    /**
     * Valida que un empleado esté activo y cumpla con un
     * 80% de asistencias del período a ser pagado.
     * @param empleado Empleado a validar, del cual se extrae su RFC.
     * @return VERDADERO si el empleado cumple con las validaciones.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    public boolean validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException;    
}