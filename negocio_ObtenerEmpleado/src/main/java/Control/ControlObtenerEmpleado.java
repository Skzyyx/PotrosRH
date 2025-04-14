package Control;

import Excepciones.ObtenerEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoBO;
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
public class ControlObtenerEmpleado implements IObtenerEmpleado {

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    
    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException {
        
        if (rfc.isEmpty()) 
            throw new ObtenerEmpleadoException("El rfc no puede estar vacío.");
        
        String regex = "^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$";
        
        if(!rfc.matches(regex))
            throw new ObtenerEmpleadoException("RFC no válido");
        
        try {
            return empleadoBO.obtenerEmpleado(rfc);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlObtenerEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObtenerEmpleadoException(ex.getMessage(), ex);
        }
    }
}