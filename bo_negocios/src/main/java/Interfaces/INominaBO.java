/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.NominaDTO;

/**
 *
 * @author skyro
 */
public interface INominaBO {
    
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws ObjetosNegocioException;
    
    public boolean guardarNomina(NominaDTO nomina);
}
