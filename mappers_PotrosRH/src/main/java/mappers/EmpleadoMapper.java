package mappers;

import Entidades.Empleado;
import dto.EmpleadoDTO;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoMapper {
    
    public static Empleado toEntityNuevo(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellidoPaterno(empleadoDTO.getApellidoPaterno());
        empleado.setApellidoMaterno(empleadoDTO.getApellidoMaterno());
        empleado.setCurp(empleadoDTO.getC);
    }
    
}