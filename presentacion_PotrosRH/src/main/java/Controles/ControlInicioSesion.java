package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Fachada.ObtenerEmpleado;
import Interfaces.IObtenerEmpleado;
import dto.EmpleadoDTO;

/**
 * Clase que coordina las operaciones entre la capa de presentación
 * y los subsistemas de negocio para el inicio de sesión de empleados
 * de recursos humanos.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlInicioSesion {
    // Subsistema para la obtención de empleados.
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();
    /**
     * Constructor por defecto.
     */
    public ControlInicioSesion() {}
    /**
     * Busca un empleado de recursos humanos por su RFC, a través
     * del método obtenerEmpleadoRH del subsistema obtenerEmpleado.
     * @param empleado Empleado a buscar (con su RFC encapsulado).
     * @return Empleado de recursos humanos.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public EmpleadoDTO buscarEmpleadoRH(EmpleadoDTO empleado) throws PresentacionException{
        try {
            return obtenerEmpleado.obtenerEmpleadoRH(empleado);
        } catch (ObtenerEmpleadoException e) {throw new PresentacionException(e.getMessage(), e);}
    }
}