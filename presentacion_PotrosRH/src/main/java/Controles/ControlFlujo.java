package Controles;

import Excepciones.PresentacionException;
import Paneles.BusquedaEmpleado;
import Paneles.MenuPrincipal;
import Paneles.PrevisualizarEmpleado;
import Paneles.PrevisualizarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;
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
    
    private static JPanel panelActual;

    public static void mostrarMenuPrincipal() {
        //Verificaciones
        
        // Cambiar de panel
        if (panelActual != null) {
            panelActual.setVisible(false); // Ocultar el panel actual
        }
        MenuPrincipal.getInstance().setVisible(true);
        panelActual = MenuPrincipal.getInstance();
    }
    
    public static void mostrarBusquedaEmpleado() {
        //Verificaciones

        // Cambiar de panel
        if (panelActual != null) {
            panelActual.setVisible(false); // Ocultar el panel actual
        }
        MenuPrincipal.getInstance().setVisible(false);
        BusquedaEmpleado.getInstance().getTxtRfc().setText("");
        BusquedaEmpleado.getInstance().setVisible(true);
        panelActual = BusquedaEmpleado.getInstance();
    }
    
    public static void mostrarPrevisualizarEmpleado() throws PresentacionException {
        //Verificaciones
        
        /* Operaciones */
        // Buscar y Obtener el empleado.
        String rfc = BusquedaEmpleado.getInstance().getTxtRfc().getText();
        EmpleadoDTO empleado = ControlNomina.obtenerEmpleado(rfc);
        
        // Se setean los valores del panel PrevisualizarEmpleado.
        PrevisualizarEmpleado pe = PrevisualizarEmpleado.getInstance();
        pe.getNombreEmpleado().setText(empleado.getNombre());
        pe.getApellidoPaternoEmpleado().setText(empleado.getApellidoPaterno());
        pe.getApellidoMaternoEmpleado().setText(empleado.getApellidoMaterno());
        pe.getRFCEmpleado().setText(empleado.getRfc());
        pe.getPuestoEmpleado().setText(empleado.getPuesto());
        pe.getEstadoEmpleado().setText(String.valueOf(empleado.getEstado()));
        // Cambiar de panel
        if (panelActual != null) {
            panelActual.setVisible(false); // Ocultar el panel actual
        }
        PrevisualizarEmpleado.getInstance().setVisible(true);
        panelActual = PrevisualizarEmpleado.getInstance();
    }
    
    public static void mostrarPrevisualizarNomina() {
        //Verificaciones
        
        /* Operaciones */
        // Buscar y Obtener el empleado.
        NominaDTO nomina = ControlNomina.getNominaDTO();
        EmpleadoDTO empleado = nomina.getEmpleado();
        
        System.out.println(nomina);
        // Se setean los valores del panel PrevisualizarNomina.
        PrevisualizarNomina pn = PrevisualizarNomina.getInstance();
        pn.getLblNombreEmpleado().setText(empleado.getNombre());
        pn.getLblApellidoPaternoEmpleado().setText(empleado.getApellidoPaterno());
        pn.getLblApellidoMaternoEmpleado().setText(empleado.getApellidoMaterno());
        pn.getLblRfcEmpleado().setText(empleado.getRfc());
        pn.getLblPuestoEmpleado().setText(empleado.getPuesto());
        pn.getLblEstadoEmpleado().setText(String.valueOf(empleado.getEstado()));
        pn.getLblHorasTrabajadasEmpleado().setText(String.valueOf(nomina.getHorasTrabajadas()));
        pn.getLblHorasExtraEmpleado().setText(String.valueOf(nomina.getHoraExtra()));
        pn.getLblSalarioBrutoEmpleado().setText(String.valueOf(nomina.getSalarioBruto()));
        pn.getLblIsrEmpleado().setText(String.format("%.1f", nomina.getIsr()));
        pn.getLblSalarioNetoEmpleado().setText(String.format("%.1f", nomina.getSalarioNeto()));
        
        // Cambiar de panel
        if (panelActual != null) {
            panelActual.setVisible(false); // Ocultar el panel actual
        }
        PrevisualizarNomina.getInstance().setVisible(true);
        panelActual = PrevisualizarNomina.getInstance();
    }
}
