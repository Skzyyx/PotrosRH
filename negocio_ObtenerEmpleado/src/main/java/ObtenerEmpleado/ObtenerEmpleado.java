/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObtenerEmpleado;

import Excepciones.ObtenerEmpleadoException;
import Interfaces.IObtenerEmpleado;
import dto.EmpleadoDTO;
import enums.EstadoEmpleado;

/**
 *
 * @author skyro
 */
public class ObtenerEmpleado implements IObtenerEmpleado {

    @Override
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObtenerEmpleadoException {
        if (rfc.trim().isEmpty()) {
            throw new ObtenerEmpleadoException("El rfc no puede ser nulo.");
        }
        if (rfc.length() > 13 || rfc.length() < 13) {
            throw new ObtenerEmpleadoException("El rfc debe tener 13 caracteres.");
        }
        
        return new EmpleadoDTO("Benjamin", "Soto", "Coronado", "benjamin.sc@gmail.com", rfc, "Cactus", "Casa Blanca", "123", "1231231231", "Seguridad", "Empleado", 8000, EstadoEmpleado.ACTIVO);
    }
    
}
