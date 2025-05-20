package mappers;

import Entidades.Direccion;
import Entidades.Empleado;
import Entidades.HorarioLaboral;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import Enums.EstadoEmpleado;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que mapea entidades Empleado a EmpleadolDTO, 
 * y viceversa.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoMapper {
    /**
     * Convierte un objeto EmpleadoDTO a un objeto Empleado.
     * Pensado para nuevos registros (inserción).
     * @param empleadoDTO DTO a mapear.
     * @return Entidad Empleado mapeada.
     */
    public static Empleado toEntityNuevo(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellidoPaterno(empleadoDTO.getApellidoPaterno());
        empleado.setApellidoMaterno(empleadoDTO.getApellidoMaterno());
        empleado.setFechaNacimiento(empleadoDTO.getFechaNacimiento());
        empleado.setRfc(empleadoDTO.getRfc());
        empleado.setCurp(empleadoDTO.getCurp());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setTelefono(empleadoDTO.getTelefono());
        empleado.setEstado(Enum.valueOf(EstadoEmpleado.class, empleadoDTO.getEstado()));
        empleado.setDepartamento(empleadoDTO.getDepartamento());
        empleado.setPuesto(empleadoDTO.getPuesto());
        empleado.setSalarioBase(empleadoDTO.getSalarioBase());
        
        // Se crea una nueva dirección, con cada dato obtenido del empleadoDTO.
        Direccion direccion = new Direccion();
        direccion.setCalle(empleadoDTO.getCalle());
        direccion.setColonia(empleadoDTO.getColonia());
        direccion.setNumero(empleadoDTO.getNumero());
        // Se agrega la dirección mapeada a la entidad.
        empleado.setDireccion(direccion);
        
        // Se crea una lista de entidades HorarioLaboral.
        List<HorarioLaboral> horariosLaborales = new ArrayList<>();
        
        if (empleadoDTO.getHorariosLaborales() != null) {
            // Se recorre cada HorarioLaboralDTO de la lista de horarios laborales del empleadoDTO.
            for(HorarioLaboralDTO horarioLaboralDTO: empleadoDTO.getHorariosLaborales())
                // Se mapea cada horario obtenido y se agrega a la lista de horarios laborales.
                horariosLaborales.add(HorarioLaboralMapper.toEntityNuevo(horarioLaboralDTO));
            // Se agrega la lista de horarios laborales mapeada a la entidad.
            empleado.setHorariosLaborales(horariosLaborales);
        }
        
        // Se retorna la entidad mapeada.
        return empleado;
    }
    /**
     * Convierte un objeto EmpleadoDTO a un objeto Empleado.
     * Pensado para viejos registros o registros persistidos
     * previamente (actualización).
     * @param empleadoDTO DTO a mapear.
     * @return Entidad Empleado mapeada.
     */
    public static Empleado toEntityViejo(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setId(new ObjectId(empleadoDTO.getId()));
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setApellidoPaterno(empleadoDTO.getApellidoPaterno());
        empleado.setApellidoMaterno(empleadoDTO.getApellidoMaterno());
        empleado.setFechaNacimiento(empleadoDTO.getFechaNacimiento());
        empleado.setRfc(empleadoDTO.getRfc());
        empleado.setCurp(empleadoDTO.getCurp());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setTelefono(empleadoDTO.getTelefono());
        empleado.setEstado(Enum.valueOf(EstadoEmpleado.class, empleadoDTO.getEstado()));
        empleado.setDepartamento(empleadoDTO.getDepartamento());
        empleado.setPuesto(empleadoDTO.getPuesto());
        empleado.setSalarioBase(empleadoDTO.getSalarioBase());
        
        // Se crea una nueva dirección, con cada dato obtenido del empleadoDTO.
        Direccion direccion = new Direccion();
        direccion.setCalle(empleadoDTO.getCalle());
        direccion.setColonia(empleadoDTO.getColonia());
        direccion.setNumero(empleadoDTO.getNumero());
        // Se agrega la dirección mapeada a la entidad.
        empleado.setDireccion(direccion);
        
        // Se crea una lista de entidades HorarioLaboral.
        List<HorarioLaboral> horariosLaborales = new ArrayList<>();
        // Se recorre cada HorarioLaboralDTO de la lista de horarios laborales del empleadoDTO.
        for(HorarioLaboralDTO horarioLaboralDTO: empleadoDTO.getHorariosLaborales())
            // Se mapea cada horario obtenido y se agrega a la lista de horarios laborales.
            horariosLaborales.add(HorarioLaboralMapper.toEntityNuevo(horarioLaboralDTO));
        // Se agrega la lista de horarios laborales mapeada a la entidad.
        empleado.setHorariosLaborales(horariosLaborales);
        
        // Se retorna la entidad mapeada.
        return empleado;
    }
    /**
     * Convierte un objeto Empleado a un objeto EmpleadoDTO.
     * @param empleado Entidad a mapear.
     * @return Objeto EmpleadoDTO mapeado.
     */
    public static EmpleadoDTO toDTO(Empleado empleado){
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        
        if (empleado.getId() != null)
            empleadoDTO.setId(empleado.getId().toString());
        
        empleadoDTO.setNombre(empleado.getNombre());
        empleadoDTO.setApellidoPaterno(empleado.getApellidoPaterno());
        empleadoDTO.setApellidoMaterno(empleado.getApellidoMaterno());
        empleadoDTO.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoDTO.setRfc(empleado.getRfc());
        empleadoDTO.setCurp(empleado.getCurp());
        empleadoDTO.setEmail(empleado.getEmail());
        empleadoDTO.setTelefono(empleado.getTelefono());
        empleadoDTO.setEstado(empleado.getEstado().toString());
        empleadoDTO.setDepartamento(empleado.getDepartamento());
        empleadoDTO.setPuesto(empleado.getPuesto());
        empleadoDTO.setSalarioBase(empleado.getSalarioBase());
        // Se obtiene cada dato de la Dirección del empleado, y se agrega al empleadoDTO.
        empleadoDTO.setNumero(empleado.getDireccion().getNumero());
        empleadoDTO.setCalle(empleado.getDireccion().getCalle());
        empleadoDTO.setColonia(empleado.getDireccion().getColonia());
        
        // Se crea una lista que almacena objetos de transferencia HorarioLaboralDTO.
        List<HorarioLaboralDTO> horariosLaboralesDTO = new ArrayList<>();
        // Se recorre cada entidad HorarioLaboral de la lista de horarios laborales del empleado.
        for(HorarioLaboral horarioLaboral : empleado.getHorariosLaborales())
            // Se mapea cada horario obtenido y se agrega a la lista de horarios laborales DTO.
            horariosLaboralesDTO.add(HorarioLaboralMapper.toDTO(horarioLaboral));
        // Se agrega la lista de horarios laborales mapeada al objeto de transferencia.
        empleadoDTO.setHorariosLaborales(horariosLaboralesDTO);
        
        // Se retorna el objeto de transferencia mapeado.
        return empleadoDTO;
    }

    public static List<EmpleadoDTO> toDTOViejoList(List<Empleado> empleados) {
        List<EmpleadoDTO> dtos = new ArrayList<>();
        for (Empleado empleado : empleados) {
            dtos.add(toDTO(empleado));
        }
        return dtos;
    }
}