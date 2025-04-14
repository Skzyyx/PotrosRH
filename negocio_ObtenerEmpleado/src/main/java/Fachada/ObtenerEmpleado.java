/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Excepciones.ObtenerEmpleadoException;
import Interfaces.IObtenerEmpleado;
import Control.ControlObtenerEmpleado;
import dto.EmpleadoDTO;

/**
 *
 * @author skyro
 */
public class ObtenerEmpleado implements IObtenerEmpleado{
    
    private static ObtenerEmpleado instance;
    private ControlObtenerEmpleado control;

    private ObtenerEmpleado() {
        this.control = new ControlObtenerEmpleado();
    }
    
    public static synchronized IObtenerEmpleado getInstance() {
        if (instance == null) {
            instance = new ObtenerEmpleado();
        }
        return instance;
    }
    
    

    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException {
        
        return control.obtenerEmpleado(rfc);
    }
    
}
