package Interfaz;

import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IDespedirEmpleado {
    public EmpleadoDTO cambiarEstado(EmpleadoDTO empleado, String estado);
    
    public boolean envCorreoCont(EmpleadoDTO correo, String razon);
}
