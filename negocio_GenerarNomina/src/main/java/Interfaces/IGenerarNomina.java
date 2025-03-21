/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dto.EmpleadoDTO;
import dto.NominaDTO;

/**
 *
 * @author skyro
 */
public interface IGenerarNomina {
    
    public NominaDTO generarNomina(EmpleadoDTO empleado, double bono);
}
