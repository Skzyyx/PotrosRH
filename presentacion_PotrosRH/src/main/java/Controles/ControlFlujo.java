package Controles;

import Excepciones.PresentacionException;
import PanelesCasoBase.BusquedaEmpleado;
import PanelesDespidos.BusquedaEmpleadoDespedir;
import PanelesDespidos.ConfirmacionDespido;
import PanelesCasoBase.MenuPrincipal;
import PanelesCasoBase.PrevisualizarEmpleado;
import PanelesDespidos.PrevisualizarEmpleadoDespedir;
import PanelesCasoBase.PrevisualizarNomina;
import PanelesReportes.DescripcionIncidente;
import PanelesReportes.ImpactoIncidente;
import PanelesReportes.RegistroDatosGenerales;
import PanelesReportes.SubmenuReportesMalaConducta;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import dto.ReporteMalaConductaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlFlujo {

    private static JPanel panelContenedor;
    private static JPanel panelActual;

    private static MenuPrincipal menuPrincipal;
    //CU: Nómina de empleado
    private static BusquedaEmpleado busquedaEmpleado;
    private static PrevisualizarEmpleado previsualizarEmpleado;
    private static PrevisualizarNomina previsualizarNomina;
    //CU: Despedir Empleado
    private static PrevisualizarEmpleadoDespedir previsualizarEmpleadoDespedir;
    private static BusquedaEmpleadoDespedir busquedaEmpleadoDespedir;
    private static ConfirmacionDespido confirmacionDespido;
    // CU: Reportes de mala conducta
    private static SubmenuReportesMalaConducta submenuReportesMalaConducta;
    private static RegistroDatosGenerales registroDatosGenerales;
    private static DescripcionIncidente descripcionIncidente;
    private static ImpactoIncidente impactoIncidente;
    /**
    * Muestra la pantalla del menú principal de la aplicación.
    * 
    * Si la instancia del menú principal aún no ha sido creada, se instancia.
    * Luego, se cambia la pantalla actual para mostrar dicha vista.
    */
    public static void mostrarMenuPrincipal() {
        if (menuPrincipal == null) {
            menuPrincipal = new MenuPrincipal();
        }
        cambiarPantalla(menuPrincipal);
    }
    
    /**
    * Muestra la pantalla de búsqueda de empleados.
    * 
    * Si la instancia de la pantalla de búsqueda aún no ha sido creada, se instancia.
    * Antes de mostrarla, se limpia el campo de búsqueda para asegurar que esté vacío.
    * Luego, se cambia la pantalla actual para mostrar esta vista.
    */
    public static void mostrarBusquedaEmpleado() {
        if (busquedaEmpleado == null) {
            busquedaEmpleado = new BusquedaEmpleado();
        }
        busquedaEmpleado.limpiarCampo();
        cambiarPantalla(busquedaEmpleado);
    }
    
    /**
    * Muestra la pantalla de previsualización de un empleado.
    * 
    * Obtiene la información del empleado a partir de su RFC utilizando la capa de control.
    * Si la instancia de la pantalla de previsualización no ha sido creada, se instancia.
    * Luego, se asignan los datos del empleado a la vista y se muestra la pantalla correspondiente.
    * 
    * @param rfc Clave RFC del empleado que se desea previsualizar.
    * @throws PresentacionException Si ocurre un error al obtener los datos del empleado.
    */
    public static void mostrarPrevisualizarEmpleado(String rfc) throws PresentacionException {

        ControlNomina controlNomina = ControlNomina.getInstance();
        EmpleadoDTO empleado = controlNomina.obtenerEmpleado(rfc);

        if (previsualizarEmpleado == null) {
            previsualizarEmpleado = new PrevisualizarEmpleado();
        }
        previsualizarEmpleado.setDatosEmpleado(empleado);
        cambiarPantalla(previsualizarEmpleado);
    }
    
    /**
    * Muestra la pantalla de previsualización de una nómina generada.
    * 
    * Genera una nueva nómina utilizando la capa de control y muestra la vista correspondiente.
    * Si la instancia de la pantalla de previsualización de nómina aún no ha sido creada, se instancia.
    * Luego, se cargan los datos de la nómina en la vista y se cambia la pantalla actual.
    * 
    * @throws PresentacionException Si ocurre un error durante la generación de la nómina.
    */
    public static void mostrarPrevisualizarNomina() throws PresentacionException {
        try {
            NominaDTO nomina = ControlNomina.getInstance().generarNomina();
            
            if (previsualizarNomina == null) {
                previsualizarNomina = new PrevisualizarNomina();
            }
            
            previsualizarNomina.setDatosNomina(nomina);
            cambiarPantalla(previsualizarNomina);
        } catch (PresentacionException ex) {
            Logger.getLogger(ControlFlujo.class.getName()).log(Level.SEVERE, null, ex);
            throw new PresentacionException(ex.getMessage());
        }
    }
    /**
     * Muestra el submenú de reportes de mala
     * conducta.
     */
    public static void mostrarSubmenuReportes(){
        // Convierte a null los paneles del registro de un reporte, para que 
        // la información que contenían estos se elimine, con el fin de que
        // no quede nada donde no debe.
        if(registroDatosGenerales != null)
            registroDatosGenerales = null;
        
        if(descripcionIncidente != null)
            descripcionIncidente = null;
        
        if(impactoIncidente != null)
            impactoIncidente = null;
        
        if(submenuReportesMalaConducta == null)
            submenuReportesMalaConducta = new SubmenuReportesMalaConducta();
        cambiarPantalla(submenuReportesMalaConducta);
    }
    /**
     * Muestra el panel para el registro de datos generales del
     * reporte de mala conducta.
     */
    public static void mostrarRegistroDatosGenerales(){
        if(registroDatosGenerales == null)
            registroDatosGenerales = new RegistroDatosGenerales();
        cambiarPantalla(registroDatosGenerales);
    }
    /**
     * Muestra el panel de la descripción del incidente.Pide un reporte de mala conducta, que se espera}
     * que contenga los datos generales.
     * @param reporteMalaConducta Reporte de mala conducta incompleto.
     * @throws PresentacionException Excepción de la capa de presentación.
     */
    public static void mostrarDescripcionIncidente(ReporteMalaConductaDTO reporteMalaConducta) throws PresentacionException{
        if(descripcionIncidente == null)
            descripcionIncidente = new DescripcionIncidente();
        descripcionIncidente.setReporte(reporteMalaConducta);
        cambiarPantalla(descripcionIncidente);
    }
    /**
     * Muestra el panel del impacto del incidente.
     * Pide un reporte de mala conducta, que se espera
     * que contenga la descripción del incidente y
     * los datos generales.
     * @param reporteMalaConducta Reporte de mala conducta incompleto.
     */
    public static void mostrarImpactoIncidente(ReporteMalaConductaDTO reporteMalaConducta) throws PresentacionException{
        if(impactoIncidente == null)
            impactoIncidente = new ImpactoIncidente();
        impactoIncidente.setReporte(reporteMalaConducta);
        cambiarPantalla(impactoIncidente);
    }
    
    /**
    * Cambia la vista actual del sistema mostrando el panel recibido como nuevo contenido.
    * 
    * El método limpia el contenido del panel contenedor principal y agrega el nuevo panel.
    * Luego actualiza la interfaz gráfica para reflejar el cambio y guarda la referencia
    * del panel que está siendo mostrado actualmente.
    * 
    * @param nuevoPanel Panel que se desea mostrar en la interfaz.
    * @throws IllegalStateException Si el panel contenedor no ha sido inicializado previamente.
    */
    private static void cambiarPantalla(JPanel nuevoPanel) {
        if (panelContenedor == null) {
            throw new IllegalStateException("El contenedor no ha sido inicializado.");
        }

        panelContenedor.removeAll();
        panelContenedor.add(nuevoPanel);
        panelContenedor.revalidate();
        panelContenedor.repaint();

        panelActual = nuevoPanel;
    }
    
    /**
    * Establece el panel contenedor principal para la interfaz gráfica.
    * 
    * Este método recibe un panel como parámetro y lo asigna como el contenedor
    * principal en el cual se mostrarán las diferentes pantallas o vistas del sistema.
    * 
    * @param contenedor El panel que se debe establecer como contenedor principal.
    */
    public static void setContenedor(JPanel contenedor) {
        panelContenedor = contenedor;
    }
    
    /**
     * Muestra la pantalla de búsqueda de empleados para despedir.
     *
     * Si la instancia de la pantalla de búsqueda para despido aún no ha sido creada, se instancia.
     * Antes de mostrarla, se limpia el campo de búsqueda.
     * Luego, se cambia la pantalla actual para mostrar esta vista.
     */
    public static void mostrarBusquedaEmpleadoDespedir() {
        BusquedaEmpleadoDespedir busquedaEmpleadoDespedir = new BusquedaEmpleadoDespedir();
        busquedaEmpleadoDespedir.limpiarCampo();
        cambiarPantalla(busquedaEmpleadoDespedir);
    }
    
    /**
     * Muestra la pantalla de previsualización del empleado que se va a despedir.
     *
     * Obtiene la información del empleado a partir de su RFC utilizando la capa de control de negocio.
     * Si la instancia de la pantalla de previsualización para despido no ha sido creada, se instancia.
     * Luego, se asignan los datos del empleado a la vista y se muestra la pantalla correspondiente.
     *
     * @param rfc Clave RFC del empleado que se desea previsualizar para despedir.
     * @throws PresentacionException Si ocurre un error al obtener los datos del empleado.
     */
    public static void mostrarPrevisualizarEmpleadoDespedir(EmpleadoDTO empleadoDTO) {
        if (previsualizarEmpleadoDespedir == null) {
            previsualizarEmpleadoDespedir = new PrevisualizarEmpleadoDespedir();
        }
        previsualizarEmpleadoDespedir.setDatosEmpleado(empleadoDTO);
        cambiarPantalla(previsualizarEmpleadoDespedir);
    }
    
    
}