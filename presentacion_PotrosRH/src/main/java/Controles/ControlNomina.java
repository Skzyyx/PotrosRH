package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Exceptions.GenerarNominaException;
import GenerarNomina.GenerarNomina;
import Interfaces.IGenerarNomina;
import Interfaces.IObtenerEmpleado;
import ObtenerEmpleado.ObtenerEmpleado;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import enums.EstadoEmpleado;
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
    
    private static GenerarNomina generarNomina;
    
    private ControlNomina() {
        this.empleadoDTO = new EmpleadoDTO();
        this.nominaDTO = new NominaDTO();
        
        this.generarNomina = new GenerarNomina();

    }
    
    public static ControlNomina getInstance() {
        if (instance == null) {
            instance = new ControlNomina();
        }
        return instance;
    }

    public boolean validarEmpleado(String rfc) throws PresentacionException {
        
        validarRFC(rfc);
        EmpleadoDTO empleado = obtenerEmpleado(rfc);
        
        if (empleado == null) {
            throw new PresentacionException("No se encontró al empleado.");
        }
        
        if (empleado.getEstado() == EstadoEmpleado.INACTIVO) {
            throw new PresentacionException("No se puede generar una nómina a un empleado inactivo.");
        }
        return true;
    }

    public EmpleadoDTO obtenerEmpleado(String rfc) throws PresentacionException {
        EmpleadoDTO empleado = new EmpleadoDTO();
        IObtenerEmpleado obtenerEmpleado = new ObtenerEmpleado();
        try {
            empleado = obtenerEmpleado.obtenerEmpleado(rfc);
            empleadoDTO = empleado;
        } catch (ObtenerEmpleadoException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
        return empleado;
    }

    public NominaDTO generarNomina() throws PresentacionException {
        try {
            nominaDTO = generarNomina.generarNomina(empleadoDTO);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error al generar la nómina: " + ex.getMessage());
        }
        return nominaDTO;
    }
    
    public boolean guardarNomina(NominaDTO nomina) throws PresentacionException {
        try {
            return generarNomina.guardarNomina(nominaDTO);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Ocurrió un error al guardar la nomina.");
        }
    }

    public boolean validarRFC(String rfc) throws PresentacionException {
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";
        
        if (rfc == null) {
            throw new PresentacionException("El RFC no puede ser nulo.");
        }
        
        if (!rfc.matches(regexRFC)) {
            throw new PresentacionException("El formato del RFC es incorrecto.");
        }
        return true;
    }
}