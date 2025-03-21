/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepciones.ObtenerEmpleadoException;
import dto.EmpleadoDTO;

/**
 *
 * @author skyro
 */
public interface IObtenerEmpleado {
    
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException; 
}
