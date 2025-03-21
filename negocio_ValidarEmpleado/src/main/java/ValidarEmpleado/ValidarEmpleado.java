package ValidarEmpleado;

import Excepciones.ValidarEmpleadoException;
import dto.EmpleadoDTO;

/**
 *
 * @author ErnestoLpz_252663
 */
public class ValidarEmpleado {
    
    public boolean validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        
        if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
            throw new ValidarEmpleadoException("El nombre no puede estar vacío.");
        }
        if (empleado.getApellidoPaterno() == null || empleado.getApellidoPaterno().trim().isEmpty()) {
            throw new ValidarEmpleadoException("El apellido paterno no puede estar vacío.");
        }
        if (empleado.getEmail() == null || !empleado.getEmail().contains("@") || !empleado.getEmail().contains(".")) {
            throw new ValidarEmpleadoException("El email no tiene un formato válido.");
        }
        if (empleado.getRfc() == null || empleado.getRfc().length() < 12 || empleado.getRfc().length() > 13) {
            throw new ValidarEmpleadoException("El RFC debe tener entre 12 y 13 caracteres.");
        }
        if (empleado.getTelefono() == null || empleado.getTelefono().length() != 10 || !empleado.getTelefono().matches("\\d+")) {
            throw new ValidarEmpleadoException("El teléfono debe contener exactamente 10 dígitos.");
        }
        if (empleado.getSalarioBase() <= 0) {
            throw new ValidarEmpleadoException("El salario base debe ser un número positivo.");
        }
        if (empleado.getDepartamento() == null || empleado.getDepartamento().trim().isEmpty()) {
            throw new ValidarEmpleadoException("El departamento no puede estar vacío.");
        }
        if (empleado.getPuesto() == null || empleado.getPuesto().trim().isEmpty()) {
            throw new ValidarEmpleadoException("El puesto no puede estar vacío.");
        }
        return true;
    }
    
}