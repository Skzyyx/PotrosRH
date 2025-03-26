package bo;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import enums.EstadoEmpleado;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmpleadoBO {
    
    /**
     * Valida que el RFC proporcionado no sea nulo ni vacío.
     *
     * @param rfc RFC del empleado a validar.
     * @return {@code true} si el RFC es válido.
     * @throws ObjetosNegocioException Si el RFC es nulo o está vacío.
     */
    public boolean validarEstado(String rfc) throws ObjetosNegocioException {
        if (rfc == null) 
            throw new ObjetosNegocioException("El rfc no puede ser nulo");
        
        if (rfc.trim().isEmpty()) 
            throw new ObjetosNegocioException("El rfc no puede estar vacio");
        
        return true;
    }

    /**
     * Determina si el porcentaje de faltas de un empleado es aceptable.
     *
     * @param rfc RFC del empleado a evaluar.
     * @return {@code true} si el porcentaje de faltas es menor al 80%, {@code false} en caso contrario.
     */
    public boolean validarPorcentajeFaltas(String rfc) {
        double porcentajeFaltas = Math.random();
        return porcentajeFaltas < 0.80;
    }

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC.
     * Si el RFC es inválido o el empleado no se encuentra en la lista, lanza una excepción.
     *
     * @param rfc RFC del empleado a buscar.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no está registrado.
     */
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObjetosNegocioException {
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";

        if (!(rfc != null && rfc.matches(regexRFC) && rfc.length() <= 13))
            throw new ObjetosNegocioException("RFC no válido");

        List<EmpleadoDTO> empleados = Arrays.asList(
                new EmpleadoDTO("Freddy", "Guzman", "Moreno", 
                    "jose.islas252574@potros.itson.edu.mx", 
                    "GUMF900101ABC", 
                    "Peppa", "Power Rangers", "123", 
                    "1231231950", 
                    "Limpieza", 
                    "Empleado", 
                    4000, 
                    EstadoEmpleado.ACTIVO),
                
                new EmpleadoDTO("Jesús Ernesto", "López", "Ibarra", 
                    "jose.islas252574@potros.itson.edu.mx", 
                    "LOIJ920315XYZ", 
                    "Furbo", "Real Madrid", "123", 
                    "6442291849", 
                    "Recursos Humanos", 
                    "Empleado", 
                    8000, 
                    EstadoEmpleado.ACTIVO),
                
                new EmpleadoDTO("José Luis", "Islas", "Molina", 
                    "jose.islas252574@potros.itson.edu.mx", 
                    "ISLM850525DEF", 
                    "Avenida Siempre Viva", "Centro", "456", 
                    "9876543210", 
                    "TI", 
                    "Analista", 
                    12000, 
                    EstadoEmpleado.ACTIVO)
        );

        // Buscar al empleado por RFC
        for (EmpleadoDTO empleado : empleados) {
            if (empleado.getRfc().equalsIgnoreCase(rfc)) {
                return empleado;
            }
        }

        // Si no se encuentra el empleado, lanza una excepción
        throw new ObjetosNegocioException("No se encontró un empleado con el RFC proporcionado");
    }
}