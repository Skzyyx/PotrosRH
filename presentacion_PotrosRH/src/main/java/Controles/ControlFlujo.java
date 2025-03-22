/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Paneles.BusquedaRFCNomina;
import Paneles.MenuPrincipal;
import Paneles.PrevisualizarEmpleado;
import Paneles.PrevisualizarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import javax.swing.JPanel;

/**
 *
 * @author skyro
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
    
    public static void mostrarBusquedaRFCNomina() {
        //Verificaciones

        // Cambiar de panel
        if (panelActual != null) {
            panelActual.setVisible(false); // Ocultar el panel actual
        }
        MenuPrincipal.getInstance().setVisible(false);
        BusquedaRFCNomina.getInstance().setVisible(true);
        panelActual = BusquedaRFCNomina.getInstance();
    }
    
    public static void mostrarPrevisualizarEmpleado() throws PresentacionException {
        //Verificaciones
        
        /* Operaciones */
        // Buscar y Obtener el empleado.
        String rfc = BusquedaRFCNomina.getInstance().getTxtRfc().getText();
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
