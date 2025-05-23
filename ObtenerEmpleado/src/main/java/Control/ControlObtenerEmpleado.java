package Control;

import Excepciones.ObtenerEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoBO;
import Interfaces.IObtenerEmpleado;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import java.util.List;
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
public class ControlObtenerEmpleado {

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    /**
     * Obtiene los datos de un empleado a partir de su RFC.Valida que el RFC no esté vacío 
     * y cumpla con el formato oficial (4 letras, 6 números de fecha y 3 caracteres alfanuméricos).Si el RFC es válido, se solicita el empleado a la capa de negocio.  
     * En caso de error, se lanza una excepción con el mensaje correspondiente.
     * @param empleado Objeto EmpleadoDTO, del cual se extrae el RFC del empleado a validar.
     * @return Un objeto EmpleadoDTO con la información del empleado.
     * @throws ObtenerEmpleadoException Si el RFC es inválido o ocurre un error al obtener los datos.
    */
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObtenerEmpleadoException {
        
        validarEmpleadoRFC(empleado);
        
        try {
            EmpleadoDTO empleadoEncontrado = empleadoBO.obtenerEmpleado(empleado);
            if(empleadoEncontrado == null)
                throw new ObtenerEmpleadoException("No existe un empleado registrado con el RFC recibido.");
            else
                return empleadoEncontrado;
        } catch (ObjetosNegocioException ex) {throw new ObtenerEmpleadoException(ex.getMessage(), ex);}
    }
    /**
     * Obtiene los datos de un empleado a partir de su RFC.Valida que el RFC no esté vacío 
     * y cumpla con el formato oficial (4 letras, 6 números de fecha y 3 caracteres alfanuméricos).Si el RFC es válido, se solicita el empleado a la capa de negocio.  
     * En caso de error, se lanza una excepción con el mensaje correspondiente.
     * @param empleado Objeto EmpleadoDTO, del cual se extrae el RFC del empleado a validar.
     * @return Un objeto EmpleadoDTO con la información del empleado.
     * @throws ObtenerEmpleadoException Si el RFC es inválido o ocurre un error al obtener los datos.
    */
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObtenerEmpleadoException {
        
        validarEmpleadoRFC(empleado);
        
        try {
            EmpleadoDTO empleadoEncontrado = empleadoBO.obtenerEmpleadoActivo(empleado);
            if(empleadoEncontrado == null)
                throw new ObtenerEmpleadoException("No existe un empleado registrado con el RFC recibido o el empleado ya fue despedido.");
            else
                return empleadoEncontrado;
        } catch (ObjetosNegocioException ex) {throw new ObtenerEmpleadoException(ex.getMessage(), ex);}
    }
    /**
     * Obtiene un empleado activo a partir de su RFC, cuyo departamento es
     * igual a Recursos Humanos.
     * @param empleado Empleado con RFC de búsqueda.
     * @return Empleado de recursos humanos.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    public EmpleadoDTO obtenerEmpleadoRH(EmpleadoDTO empleado) throws ObtenerEmpleadoException{
        
        validarEmpleadoRFC(empleado);
        
        try {
            EmpleadoDTO empleadoEncontrado = empleadoBO.obtenerEmpleadoRH(empleado);
            if(empleadoEncontrado == null)
                throw new ObtenerEmpleadoException("No existe un empleado de recursos humanos registrado con el RFC recibido.");
            else
                return empleadoEncontrado;
        } catch (ObjetosNegocioException ex) {throw new ObtenerEmpleadoException(ex.getMessage(), ex);}
    }
    /**
     * Valida el objeto EmpleadoDTO recibido y el RFC contenido en este.
     * @param empleado Empleado a validar.
     * @throws ObtenerEmpleadoException i el RFC es inválido o ocurre un error al obtener los datos.
     */
    private void validarEmpleadoRFC(EmpleadoDTO empleado) throws ObtenerEmpleadoException{
        if(!(empleado != null && empleado.getRfc() != null &&!empleado.getRfc().isEmpty()))
            throw new ObtenerEmpleadoException("El RFC no puede estar vacío.");
        
        // Se extrae el RFC del empleado.
        String rfc = empleado.getRfc();   
        
        if (!(rfc.matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$") && rfc.length() == 13))
            throw new ObtenerEmpleadoException("RFC no válido");
    }
    
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws ObtenerEmpleadoException {
        try {
            return empleadoBO.obtenerTodosSinContrato(filtro);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlObtenerEmpleado.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObtenerEmpleadoException(ex.getMessage());
        }
    }
    
    /**
     * Inserta empleados por default en la base de datos.
     * @throws ObtenerEmpleadoException Excepción del subsistema.
     */
    public void insertarEmpleadosDefault() throws ObtenerEmpleadoException{
        try {
            empleadoBO.insertarDefault();
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlObtenerEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}