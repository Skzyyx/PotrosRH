package Controles;

import Excepciones.PresentacionException;
import Paneles.BusquedaEmpleado;
import Paneles.MenuPrincipal;
import Paneles.PrevisualizarEmpleado;
import Paneles.PrevisualizarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;
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
    private static BusquedaEmpleado busquedaEmpleado;
    private static PrevisualizarEmpleado previsualizarEmpleado;
    private static PrevisualizarNomina previsualizarNomina;

    public static void mostrarMenuPrincipal() {
        if (menuPrincipal == null) {
            menuPrincipal = new MenuPrincipal();
        }
        cambiarPantalla(menuPrincipal);
    }

    public static void mostrarBusquedaEmpleado() {
        if (busquedaEmpleado == null) {
            busquedaEmpleado = new BusquedaEmpleado();
        }
        busquedaEmpleado.limpiarCampo();
        cambiarPantalla(busquedaEmpleado);
    }

    public static void mostrarPrevisualizarEmpleado(String rfc) throws PresentacionException {

        ControlNomina controlNomina = ControlNomina.getInstance();
        EmpleadoDTO empleado = controlNomina.obtenerEmpleado(rfc);

        if (previsualizarEmpleado == null) {
            previsualizarEmpleado = new PrevisualizarEmpleado();
        }
        previsualizarEmpleado.setDatosEmpleado(empleado);
        cambiarPantalla(previsualizarEmpleado);
    }

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

    public static void setContenedor(JPanel contenedor) {
        panelContenedor = contenedor;
    }
}