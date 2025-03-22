/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import GenerarNomina.GenerarNomina;
import Interfaces.IGenerarNomina;
import Interfaces.IObtenerEmpleado;
import ObtenerEmpleado.ObtenerEmpleado;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class ControlNomina {

    private static EmpleadoDTO empleadoDTO;
    private static NominaDTO nominaDTO;

    public static boolean validarEmpleado(String rfc) {
        return true;
    }

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

    public static NominaDTO generarNomina() {
        IGenerarNomina gn = new GenerarNomina();
        nominaDTO = gn.generarNomina(empleadoDTO);
        return nominaDTO;
    }

    public static NominaDTO guardarNomina(NominaDTO nomina) {
        return new NominaDTO();
    }

    public static boolean validarRFC(String rfc) {
        return true;
    }

    public static EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    public static void setEmpleadoDTO(EmpleadoDTO empleadoDTO) {
        ControlNomina.empleadoDTO = empleadoDTO;
    }

    public static NominaDTO getNominaDTO() {
        return nominaDTO;
    }

    public static void setNominaDTO(NominaDTO nominaDTO) {
        ControlNomina.nominaDTO = nominaDTO;
    }

}
