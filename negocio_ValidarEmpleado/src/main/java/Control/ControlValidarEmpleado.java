package Control;

import Excepciones.ValidarEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoBO;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlValidarEmpleado {

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();

    public boolean validarEstado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        try {
            return empleadoBO.validarEstado(empleado.getRfc());
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlValidarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            throw new ValidarEmpleadoException(ex.getMessage());
        }
    }

    public boolean validarPorcentajeAsistencias(String rfc) throws ValidarEmpleadoException {
        try {
            return empleadoBO.validarPorcentajeAsistencias(rfc);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlValidarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            throw new ValidarEmpleadoException(ex.getMessage());
        }

    }
}
