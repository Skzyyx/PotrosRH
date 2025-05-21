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
 * Clase que coordina las operaciones entre la capa de presentación
 * y los subsistemas de negocio para la generación y la persistencia
 * de nuevas nóminas de empleados.
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
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();
    private final IValidarEmpleado validarEmpleado = ValidarEmpleado.getInstance();
    /**
    * Constructor privado de la clase ControlNomina.
    * 
    * Este constructor inicializa las instancias de los objetos necesarios para 
    * gestionar la creación y el manejo de nóminas. Es privado para garantizar 
    * que la clase siga un patrón de diseño como el Singleton, evitando múltiples 
    * instancias de la clase.
    */
    private ControlNomina() {
        this.empleadoDTO = new EmpleadoDTO();
        this.nominaDTO = new NominaDTO();
        this.generarNomina = new ControlGenerarNomina();

    }
    /**
    * Obtiene la instancia única de la clase ControlNomina.
    * 
    * Si la instancia no ha sido creada previamente, la crea y la devuelve.
    * 
    * @return La instancia única de la clase ControlNomina.
    */
    public static ControlNomina getInstance() {
        if (instance == null) {
            instance = new ControlNomina();
        }
        return instance;
    }
    /**
    * Valida la existencia y los datos de un empleado a partir de su RFC.
    * 
    * Este método obtiene el empleado mediante el RFC proporcionado y luego valida 
    * sus datos. Si ocurre un error durante el proceso, se lanzan excepciones específicas 
    * que se capturan y se vuelven a lanzar como una PresentacionException.
    * @param empleado Empleado a validar.
    * @return true si el empleado es válido, false si no lo es.
    * @throws PresentacionException Si ocurre un error al obtener o validar al empleado.
    */
    public boolean validarEmpleado(EmpleadoDTO empleado) throws PresentacionException {
        try {
            return validarEmpleado.validarEmpleado(empleado);
            
        } catch (ValidarEmpleadoException ex) {throw new PresentacionException("Error: " + ex.getMessage());}
    }
    /**
    * Obtiene un empleado a partir de su RFC, encapsulado en el
    * DTO recibido.
    * @param empleado Empleado con su RFC.
    * @return El objeto EmpleadoDTO correspondiente al RFC proporcionado.
    * @throws PresentacionException Si ocurre un error al obtener el empleado.
    */
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws PresentacionException {
        try {
            return obtenerEmpleado.obtenerEmpleadoActivo(empleado);
        } catch (ObtenerEmpleadoException ex) {throw new PresentacionException("Error: " + ex.getMessage());}
    }
    /**
    * Genera una nómina para el empleado actual.
    * 
    * Este método utiliza los datos del empleado actual para generar una nómina.
    * Si ocurre un error durante el proceso de generación, se lanza una excepción 
    * PresentacionException con el mensaje correspondiente.
    * @param empleado Empleado asociado a la nueva nómina.
    * @return El objeto NominaDTO generado para el empleado.
    * @throws PresentacionException Si ocurre un error al generar la nómina.
    */
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws PresentacionException {
        try {
            NominaDTO nomina  = generarNomina.generarNomina(empleado);
            nominaDTO = nomina;
            return nomina;
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
    }
    /**
    * Guarda la nómina generada en el sistema.
    * 
    * Este método intenta guardar una nómina utilizando el objeto NominaDTO proporcionado.
    * Si ocurre un error durante el proceso de guardado, se lanza una excepción 
    * PresentacionException con el mensaje correspondiente.
    * 
    * @param nomina El objeto NominaDTO que contiene los datos de la nómina a guardar.
    * 
    * @return true si la nómina se guarda correctamente, false si ocurre algún error.
    * 
    * @throws PresentacionException Si ocurre un error al guardar la nómina.
    */    
    public NominaDTO guardarNomina(NominaDTO nomina) throws PresentacionException {
        try {
            return generarNomina.guardarNomina(nominaDTO);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(ControlNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException("Error: " + ex.getMessage());
        }
    }
}