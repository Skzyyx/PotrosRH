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

public class EmpleadoBO {
    
    public boolean validarEstado(String rfc) throws ObjetosNegocioException {
        if (rfc == null) 
            throw new ObjetosNegocioException("El rfc no puede ser nulo");
        
        if (rfc.trim().isEmpty()) 
            throw new ObjetosNegocioException("El rfc no puede estar vacio");
        
        return true;
    }

    public boolean validarPorcentajeFaltas(String rfc) {
        double porcentajeFaltas = Math.random();
        return porcentajeFaltas < 0.80;
    }

    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObjetosNegocioException {
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";
        
        if(!(rfc != null && rfc.matches(regexRFC) && rfc.length() <= 13))
            throw new ObjetosNegocioException("RFC no válido");
        
        return new EmpleadoDTO(
                "Benjamin", "Soto", "Coronado", 
                "jose.islas252574@potros.itson.edu.mx", 
                rfc, 
                "Cactus", "Casa Blanca", "123", 
                "1231231231", 
                "Seguridad", 
                "Empleado", 
                8000, 
                EstadoEmpleado.ACTIVO);
    }
}