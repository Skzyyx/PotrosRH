package bo;

/**
 * Objeto de negocio EmpleadoBO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
import DAO.EmpleadoDAO;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import Interfaces.IEmpleadoBO;
import Interfaces.IEmpleadoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EmpleadoMapper;
/**
 * 
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoBO implements IEmpleadoBO{
    
    private static IEmpleadoBO instance;
    private static final IEmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    private EmpleadoBO (){}
    
    public static synchronized IEmpleadoBO getInstance() {
        if (instance == null) 
            instance = new EmpleadoBO();
        
        return instance;
    }
    
    /**
     * Valida que el estado del empleado sea ACTIVO.
     *
     * @param rfc RFC del empleado a evaluar.
     * @return {@code true si el RFC es válido.
     * @throws ObjetosNegocioException Si el RFC es nulo o está vacío.
     */
    @Override
    public boolean validarEstado(String rfc) throws ObjetosNegocioException {
        
        if (rfc == null) 
            throw new ObjetosNegocioException("El RFC del empleado no puede ser nulo.");
        
        try {
            
            return empleadoDAO.validarEstado(rfc);
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }

    /**
     * Determina si el porcentaje de faltas de un empleado es aceptable.
     * @param rfc RFC del empleado a evaluar.
     * @return {@code true} si el porcentaje de faltas es menor al 80%, {@code false} en caso contrario.
     * @throws Exceptions.ObjetosNegocioException cuando no cumple con el minimo de asistencias.
     */
    @Override
    public boolean validarPorcentajeAsistencias(String rfc) throws ObjetosNegocioException {
        
        if (rfc == null) 
            throw new ObjetosNegocioException("El RFC del empleado no puede ser nulo."); 
        
        try {
            
            return empleadoDAO.validarPorcentajeAsistencias(rfc);
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC.
     * Si el RFC es inválido o el empleado no se encuentra en la lista, lanza una excepción.
     * @param rfc RFC del empleado a buscar.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no está registrado.
     */
    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObjetosNegocioException {
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";

        if (!(rfc != null && rfc.matches(regexRFC) && rfc.length() <= 13))
            throw new ObjetosNegocioException("RFC no válido");
        
        try {
            return EmpleadoMapper.toDTO(empleadoDAO.obtenerEmpleado(rfc));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
}