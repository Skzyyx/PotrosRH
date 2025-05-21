package Fachada;

import Control.ControlValidarEmpleado;
import Excepciones.ValidarEmpleadoException;
import Interfaces.IValidarEmpleado;
import dto.EmpleadoDTO;

/**
 * Clase Fachada que implementa la interfaz del subsistema.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ValidarEmpleado implements IValidarEmpleado {
    // Atributo SingleTon de la clase.
    private static ValidarEmpleado instance;
    /**
     * Constructor por defecto.
     */
    private ValidarEmpleado() {}
    /**
     * Devuelve la instancia de esta clase.
     * @return Instancia de la clase.
     */
    public static synchronized IValidarEmpleado getInstance() {
        if (instance == null) 
            instance = new ValidarEmpleado();
        return instance;
    }
    /**
     * Valida que un empleado esté activo y cumpla con un
     * 80% de asistencias del período a ser pagado.
     * @param empleado Empleado a validar, del cual se extrae su RFC.
     * @return VERDADERO si el empleado cumple con las validaciones.
     * @throws ValidarEmpleadoException Excepción del subsistema.
     */
    @Override
    public boolean validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        // Valida si el empleado está activo.
        boolean esActivo = new ControlValidarEmpleado().validarEstado(empleado);
        if(!esActivo)
            throw new ValidarEmpleadoException("El empleado no se encuentra activo.");
        
        // Valida si no se le ha generado otra nómina hace poco tiempo al empleado.
        boolean periodoValido = new ControlValidarEmpleado().validarPeriodoNomina(empleado);
        if(!periodoValido)
            throw new ValidarEmpleadoException("Ya se le ha generado una nómina al empleado recibido, hace menos de 5 días.");
        
        // Valida si el empleado ha sido lo suficientemente puntual.
        boolean asistencia = new ControlValidarEmpleado().validarPorcentajeAsistencias(empleado);
        if(!asistencia)
            throw new ValidarEmpleadoException("El empleado no ha cumplido con al menos el 80% de asistencias en el período de su nómina.");
        
        // Regresa verdadero si pasa todas las validaciones.
        return true;
    }
}