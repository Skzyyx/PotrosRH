/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import Exceptions.GenerarNominaException;
import Exceptions.ObjetosNegocioException;
import GenerarNomina.GenerarNomina;
import bo.NominaBO;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import enums.EstadoEmpleado;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class PruebasGenerarNomina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            NominaBO nominaBO = new NominaBO();
            EmpleadoDTO empleado = new EmpleadoDTO("Benjamin", "Soto", "Coronado", "benjamin.sc@gmail.com", "1231231231231", "Cactus", "Casa Blanca", "123", "1231231231", "Seguridad", "Empleado", 8000, EstadoEmpleado.ACTIVO);
            GenerarNomina gn = new GenerarNomina();
            NominaDTO nomina = nominaBO.generarNomina(empleado, 400);
            System.out.println(nomina.getIsr());
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(PruebasGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
