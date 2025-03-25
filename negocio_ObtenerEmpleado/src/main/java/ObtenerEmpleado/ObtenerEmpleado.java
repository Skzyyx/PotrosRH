package ObtenerEmpleado;

import Excepciones.ObtenerEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IObtenerEmpleado;
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
public class ObtenerEmpleado implements IObtenerEmpleado {

    private final EmpleadoBO empleadoBO = new EmpleadoBO();
    
    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException {
        
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";
        
        if(!(rfc != null && rfc.matches(regexRFC) && rfc.length() <= 13))
            throw new ObtenerEmpleadoException("RFC no válido");
        
        try {
            return empleadoBO.obtenerEmpleado(rfc);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ObtenerEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObtenerEmpleadoException(ex.getMessage(), ex);
        }
    }
}