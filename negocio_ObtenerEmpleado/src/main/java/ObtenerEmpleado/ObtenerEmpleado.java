/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObtenerEmpleado;

import Excepciones.ObtenerEmpleadoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IObtenerEmpleado;
import bo.EmpleadoBO;
import dto.EmpleadoDTO;
import enums.EstadoEmpleado;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class ObtenerEmpleado implements IObtenerEmpleado {

    private EmpleadoBO empleadoBO = new EmpleadoBO();
    
    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException {
        if (rfc.trim().isEmpty()) {
            throw new ObtenerEmpleadoException("El rfc no puede ser nulo.");
        }
        if (rfc.length() > 13 || rfc.length() < 13) {
            throw new ObtenerEmpleadoException("El rfc debe tener 13 caracteres.");
        }
        
        EmpleadoDTO empleado = new EmpleadoDTO();
        
        try {
            empleado = empleadoBO.obtenerEmpleado(rfc);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ObtenerEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return empleado;
    }
    
}
