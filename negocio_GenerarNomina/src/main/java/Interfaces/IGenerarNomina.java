/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.GenerarNominaException;
import dto.EmpleadoDTO;
import dto.NominaDTO;

/**
 *
 * @author skyro
 */
public interface IGenerarNomina {
    
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException;
    
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException;
}
