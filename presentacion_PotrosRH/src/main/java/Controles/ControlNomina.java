package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Exceptions.GenerarNominaException;
import Control.ControlGenerarNomina;
import Interfaces.IGenerarNomina;
import Interfaces.IObtenerEmpleado;
import Excepciones.ValidarEmpleadoException;
import Fachada.GenerarNomina;
import Fachada.ObtenerEmpleado;
import Fachada.ValidarEmpleado;
import Interfaces.IValidarEmpleado;
import dto.EmpleadoDTO;
import dto.NominaDTO;
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
public class ControlNomina {

    private static ControlNomina instance;
    
    private EmpleadoDTO empleadoDTO;
    private NominaDTO nominaDTO;
    
    private IGenerarNomina generarNomina = GenerarNomina.getInstance();
    private IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();
    private IValidarEmpleado validarEmpleado = ValidarEmpleado.getInstance();
    
    private ControlNomina() {
        this.empleadoDTO = new EmpleadoDTO();
        this.nominaDTO = new NominaDTO();
        
        this.generarNomina = new ControlGenerarNomina();

    }
    
    public static ControlNomina getInstance() {
        if (instance == null) {
            instance = new ControlNomina();
        }
        return instance;
    }

    public boolean validarEmpleado(String rfc) throws PresentacionException {
        try {
            EmpleadoDTO empleado = obtenerEmpleado.obtenerEmpleado(rfc);
            return validarEmpleado.validarEmpleado(empleado);
        } catch (ValidarEmpleadoException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        } catch (ObtenerEmpleadoException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
    }

    public EmpleadoDTO obtenerEmpleado(String rfc) throws PresentacionException {
        try {
            EmpleadoDTO empleado = obtenerEmpleado.obtenerEmpleado(rfc);
            empleadoDTO = empleado;
            return empleado;
        } catch (ObtenerEmpleadoException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
        
    }

    public NominaDTO generarNomina() throws PresentacionException {
        try {
            NominaDTO nomina  = generarNomina.generarNomina(empleadoDTO);
            nominaDTO = nomina;
            return nomina;
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
    }
    
    public boolean guardarNomina(NominaDTO nomina) throws PresentacionException {
        try {
            return generarNomina.guardarNomina(nominaDTO);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
    }
}