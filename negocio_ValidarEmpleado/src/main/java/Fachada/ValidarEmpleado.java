/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlValidarEmpleado;
import Excepciones.ValidarEmpleadoException;
import Interfaces.IValidarEmpleado;
import dto.EmpleadoDTO;

/**
 *
 * @author skyro
 */
public class ValidarEmpleado implements IValidarEmpleado {
    
    private static ValidarEmpleado instance;
    private static ControlValidarEmpleado control;

    private ValidarEmpleado() {
    }
    
    public static synchronized IValidarEmpleado getInstance() {
        if (instance == null) {
            instance = new ValidarEmpleado();
        }
        return instance;
    }
    

    @Override
    public boolean validarEmpleado(EmpleadoDTO empleado) throws ValidarEmpleadoException {
        boolean esActivo = control.validarEstado(empleado);
  
        return esActivo;
    }
    
}
