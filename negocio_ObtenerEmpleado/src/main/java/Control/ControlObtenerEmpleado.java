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
    /**
    * Obtiene los datos de un empleado a partir de su RFC.
    *
    * Valida que el RFC no esté vacío y cumpla con el formato oficial (4 letras, 6 números de fecha y 3 caracteres alfanuméricos).
    * Si el RFC es válido, se solicita el empleado a la capa de negocio. 
    * En caso de error, se lanza una excepción con el mensaje correspondiente.
    *
    * @param rfc El RFC del empleado a buscar.
    * @return Un objeto EmpleadoDTO con la información del empleado.
    * @throws ObtenerEmpleadoException Si el RFC es inválido o ocurre un error al obtener los datos.
    */
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