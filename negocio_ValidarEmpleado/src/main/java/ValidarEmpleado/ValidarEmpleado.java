package ValidarEmpleado;

import Excepciones.ValidarEmpleadoException;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ValidarEmpleado {
    
    public boolean validarEmpleado(String rfc) throws ValidarEmpleadoException {
        
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";
        
        if(!(rfc != null && rfc.matches(regexRFC) && rfc.length() <= 13))
            throw new ValidarEmpleadoException("RFC no válido");
        
        return true;
    }
    
}