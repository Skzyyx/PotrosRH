package validarEmpleado;

import dto.EmpleadoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ErnestoLpz_252663
 */
public class ValidarEmpleado {
    
    public List<String> validar(EmpleadoDTO empleado) {
        List<String> errores = new ArrayList<>();
        
        if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
            errores.add("El nombre no puede estar vacío.");
        }
        if (empleado.getApellidoPaterno() == null || empleado.getApellidoPaterno().trim().isEmpty()) {
            errores.add("El apellido paterno no puede estar vacío.");
        }
        if (empleado.getEmail() == null || !empleado.getEmail().contains("@") || !empleado.getEmail().contains(".")) {
            errores.add("El email no tiene un formato válido.");
        }
        if (empleado.getRfc() == null || empleado.getRfc().length() < 12 || empleado.getRfc().length() > 13) {
            errores.add("El RFC debe tener entre 12 y 13 caracteres.");
        }
        if (empleado.getTelefono() == null || empleado.getTelefono().length() != 10 || !empleado.getTelefono().matches("\\d+")) {
            errores.add("El teléfono debe contener exactamente 10 dígitos.");
        }
        if (empleado.getSalarioBase() <= 0) {
            errores.add("El salario base debe ser un número positivo.");
        }
        if (empleado.getDepartamento() == null || empleado.getDepartamento().trim().isEmpty()) {
            errores.add("El departamento no puede estar vacío.");
        }
        if (empleado.getPuesto() == null || empleado.getPuesto().trim().isEmpty()) {
            errores.add("El puesto no puede estar vacío.");
        }
        return errores;
    }
}