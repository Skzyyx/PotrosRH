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
        boolean esActivo = new ControlValidarEmpleado().validarEstado(empleado);
        boolean periodoValido = new ControlValidarEmpleado().validarPeriodoNomina(empleado);
        boolean asistencia = new ControlValidarEmpleado().validarPorcentajeAsistencias(empleado);
        return esActivo && asistencia && periodoValido;
    }
}