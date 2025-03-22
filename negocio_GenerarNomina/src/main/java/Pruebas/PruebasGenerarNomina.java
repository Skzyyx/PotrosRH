/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import GenerarNomina.GenerarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import enums.EstadoEmpleado;

/**
 *
 * @author skyro
 */
public class PruebasGenerarNomina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EmpleadoDTO empleado = new EmpleadoDTO("Benjamin", "Soto", "Coronado", "benjamin.sc@gmail.com", "1231231231231", "Cactus", "Casa Blanca", "123", "1231231231", "Seguridad", "Empleado", 8000, EstadoEmpleado.ACTIVO);
        
        GenerarNomina gn = new GenerarNomina();
        
        NominaDTO nomina = gn.generarNomina(empleado);
        
        System.out.println(nomina.getIsr());
    }
    
}
