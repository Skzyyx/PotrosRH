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

    private static EmpleadoDTO empleadoDTO;
    private static NominaDTO nominaDTO;
    
    private static IGenerarNomina gn = new GenerarNomina();

    public static boolean validarEmpleado(String rfc) {return true;}

    public static EmpleadoDTO obtenerEmpleado(String rfc) throws PresentacionException {
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

    public static NominaDTO generarNomina() throws PresentacionException {
        try {
            nominaDTO = gn.generarNomina(empleadoDTO);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error al generar la nómina: " + ex.getMessage());
        }
        return nominaDTO;
    }
    
    public static boolean guardarNomina() throws PresentacionException {
        IGenerarNomina gn = new GenerarNomina();
        try {
            return gn.guardarNomina(nominaDTO);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Ocurrió un error al guardar la nomina.");
        }
    }

    public static boolean validarRFC(String rfc) throws PresentacionException {
        String regexRFC = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$";
        return rfc != null && rfc.matches(regexRFC) && rfc.length() <= 13;
    }

    public static EmpleadoDTO getEmpleadoDTO() {return empleadoDTO;}

    public static void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {ControlNomina.empleadoDTO = empleadoDTO;}

    public static NominaDTO getNominaDTO() {return nominaDTO;}

    public static void setNominaDTO(NominaDTO nominaDTO) {ControlNomina.nominaDTO = nominaDTO;}

}