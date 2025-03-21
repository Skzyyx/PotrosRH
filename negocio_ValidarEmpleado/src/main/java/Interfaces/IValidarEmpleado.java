package Interfaces;

import Excepciones.ValidarEmpleadoException;
import dto.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author ErnestoLpz_252663
 */
public interface IValidarEmpleado {
    
    public boolean validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException;
}
