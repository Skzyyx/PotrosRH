/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import PanelesCasoBase.MenuPrincipal;
import PanelesRegistroEmpleado.CapturarDatosContrato;
import PanelesRegistroEmpleado.CapturarDatosEvaluacion;
import PanelesRegistroEmpleado.MenuContrataciones;
import PanelesRegistroEmpleado.RegistrarCandidato;
import PanelesRegistroEmpleado.SeleccionarEmpleadoContrato;
import PanelesRegistroEmpleado.SeleccionarCandidatoEvaluacion;
import dto.CandidatoDTO;
import dto.EmpleadoDTO;
import javax.swing.JPanel;

/**
 *
 * @author skyro
 */
public class ControlFlujoRegistro {
    
    private static JPanel panelContenedor;
    private static JPanel panelActual;
    
    private static MenuPrincipal menuPrincipal;
    
    // CU: Registrar Empleado
    private static MenuContrataciones menuContrataciones;
    private static RegistrarCandidato registrarCandidato;
    private static SeleccionarCandidatoEvaluacion seleccionarCandidatoEvaluacion;
    private static CapturarDatosEvaluacion capturarDatosEvaluacion;
    private static SeleccionarEmpleadoContrato seleccionarEmpleadoContrato;
    private static CapturarDatosContrato capturarDatosContrato;
    
    public static void mostrarMenuContrataciones() {
        if (menuContrataciones == null) {
            menuContrataciones = new MenuContrataciones();
        }
        cambiarPantalla(menuContrataciones);
    }
    
    public static void mostrarRegistrarCandidato() {
        if (registrarCandidato == null) {
            registrarCandidato = new RegistrarCandidato();
        }
        cambiarPantalla(registrarCandidato);
    }
    
    public static void mostrarSeleccionarCandidatoEvaluacion() {
        if (seleccionarCandidatoEvaluacion == null) {
            seleccionarCandidatoEvaluacion = new SeleccionarCandidatoEvaluacion();
        }
        seleccionarCandidatoEvaluacion.limpiarCampos();
        cambiarPantalla(seleccionarCandidatoEvaluacion);
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

    public static void mostrarCapturarDatosEvaluacion(CandidatoDTO candidato) {
        if (capturarDatosEvaluacion == null) {
            capturarDatosEvaluacion = new CapturarDatosEvaluacion();
        }
        capturarDatosEvaluacion.setCandidato(candidato);
        cambiarPantalla(capturarDatosEvaluacion);
    }
    
    public static void mostrarSeleccionarEmpleadoContrato() {
        if (seleccionarEmpleadoContrato == null) {
            seleccionarEmpleadoContrato = new SeleccionarEmpleadoContrato();
        }
        cambiarPantalla(seleccionarEmpleadoContrato);
    }

    public static void mostrarCapturarDatosContrato(EmpleadoDTO empleado) {
        if (capturarDatosContrato == null) {
            capturarDatosContrato = new CapturarDatosContrato();
        }
        capturarDatosContrato.setEmpleado(empleado);
        cambiarPantalla(capturarDatosContrato);
    }
}
