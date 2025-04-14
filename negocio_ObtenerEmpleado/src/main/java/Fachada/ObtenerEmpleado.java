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
    /**
    * Retorna la única instancia de ObtenerEmpleado.
    * 
    * Usa el patrón Singleton con sincronización para evitar múltiples instancias en entornos concurrentes.
    *
    * @return Instancia única de IObtenerEmpleado.
    */
    public static synchronized IObtenerEmpleado getInstance() {
        if (instance == null) {
            instance = new ObtenerEmpleado();
        }
        return instance;
    }
    
    
    /**
    * Obtiene un empleado a partir de su RFC.
    *
    * Delega la operación al ControlObtenerEmpleado.
    *
    * @param rfc RFC del empleado a buscar.
    * @return Objeto EmpleadoDTO con los datos del empleado.
    * @throws ObtenerEmpleadoException si el RFC es inválido o ocurre un error durante la obtención.
    */
    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException {   
        return control.obtenerEmpleado(rfc);
    }
    
}
