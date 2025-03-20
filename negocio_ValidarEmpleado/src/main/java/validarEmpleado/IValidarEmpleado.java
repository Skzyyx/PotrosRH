package validarEmpleado;

import dto.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author ErnestoLpz_252663
 */
public interface IValidarEmpleado {
    public List<String> validar(EmpleadoDTO empleado);
}
