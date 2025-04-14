/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;

/**
 *
 * @author skyro
 */
public interface IEmpleadoBO {
    
    public boolean validarEstado(EmpleadoDTO empleado) throws ObjetosNegocioException;
    
    public boolean validarPorcentajeAsistencias(String rfc) throws ObjetosNegocioException;
    
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObjetosNegocioException;
}
