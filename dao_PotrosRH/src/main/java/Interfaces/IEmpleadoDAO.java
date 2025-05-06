/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;

/**
 *
 * @author skyro
 */
public interface IEmpleadoDAO {
    
    public boolean validarEstado(String rfc) throws AccesoDatosException;
    
    public boolean validarPorcentajeAsistencias(String rfc) throws AccesoDatosException;
    
    public Empleado obtenerEmpleado(String rfc) throws AccesoDatosException;
}
