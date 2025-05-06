package mappers;

import Entidades.Direccion;
import Entidades.Empleado;
import dto.EmpleadoDTO;
import enums.EstadoEmpleado;

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
        empleado.setRfc(empleadoDTO.getRfc());
        empleado.setCurp(empleadoDTO.getCurp());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setTelefono(empleadoDTO.getTelefono());
        //Queda pendiente
        empleado.setEstado(false);
        empleado.setDepartamento(empleadoDTO.getDepartamento());
        empleado.setPuesto(empleadoDTO.getPuesto());
        empleado.setSalarioBase(empleadoDTO.getSalarioBase());
        
        Direccion direccion = new Direccion();
        direccion.setCalle(empleadoDTO.getCalle());
        direccion.setColonia(empleadoDTO.getColonia());
        direccion.setNumero(empleadoDTO.getNumero());
        
        empleado.setDireccion(direccion);
        
        return empleado;
    }
    
    public static Empleado toEntityViejo(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellidoPaterno(empleadoDTO.getApellidoPaterno());
        empleado.setApellidoMaterno(empleadoDTO.getApellidoMaterno());
        empleado.setRfc(empleadoDTO.getRfc());
        empleado.setCurp(empleadoDTO.getCurp());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setTelefono(empleadoDTO.getTelefono());
        //Queda pendiente
        empleado.setEstado(false);
        empleado.setDepartamento(empleadoDTO.getDepartamento());
        empleado.setPuesto(empleadoDTO.getPuesto());
        empleado.setSalarioBase(empleadoDTO.getSalarioBase());
        
        Direccion direccion = new Direccion();
        direccion.setCalle(empleadoDTO.getCalle());
        direccion.setColonia(empleadoDTO.getColonia());
        direccion.setNumero(empleadoDTO.getNumero());
        
        empleado.setDireccion(direccion);
        
        return empleado;
    }
    
    public static EmpleadoDTO toDTOViejo(Empleado empleado){
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombre(empleado.getNombre());
        empleadoDTO.setApellidoPaterno(empleado.getApellidoPaterno());
        empleadoDTO.setApellidoMaterno(empleado.getApellidoMaterno());
        empleadoDTO.setRfc(empleado.getRfc());
        empleadoDTO.setCurp(empleado.getCurp());
        empleadoDTO.setEmail(empleado.getEmail());
        empleadoDTO.setTelefono(empleado.getTelefono());
        //Queda pendiente
        empleadoDTO.setEstado(EstadoEmpleado.ACTIVO);
        empleadoDTO.setDepartamento(empleado.getDepartamento());
        empleadoDTO.setPuesto(empleado.getPuesto());
        empleadoDTO.setSalarioBase(empleado.getSalarioBase());
        
        return empleadoDTO;
    }
    
}