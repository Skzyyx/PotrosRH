package mappers;

import Entidades.HorarioLaboral;
import dto.HorarioLaboralDTO;

/**
 * Clase que mapea entidades HorarioLaboral a HorarioLaboralDTO, 
 * y viceversa.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralMapper {
    
    public static HorarioLaboral toEntityNuevo(HorarioLaboralDTO horarioLaboralDTO){
        HorarioLaboral horarioLaboral = new HorarioLaboral();
        horarioLaboral.setDiaSemana(horarioLaboralDTO.getDiaSemana());
        horarioLaboral.setHoraInicioTurno(horarioLaboralDTO.getHoraInicioTurno());
        horarioLaboral.setHoraFinTurno(horarioLaboralDTO.getHoraFinTurno());
        // Retorna la entidad mapeada.
        return horarioLaboral;
    }
    
    public static HorarioLaboral toEntityViejo(HorarioLaboralDTO horarioLaboralDTO){
        HorarioLaboral horarioLaboral = new HorarioLaboral();
        // Falta el ID.
        horarioLaboral.setDiaSemana(horarioLaboralDTO.getDiaSemana());
        horarioLaboral.setHoraInicioTurno(horarioLaboralDTO.getHoraInicioTurno());
        horarioLaboral.setHoraFinTurno(horarioLaboralDTO.getHoraFinTurno());
        // Retorna la entidad mapeada.
        return horarioLaboral;
    }
    
    public static HorarioLaboralDTO toDTO(HorarioLaboral horarioLaboral){
        HorarioLaboralDTO horarioLaboralDTO = new HorarioLaboralDTO();
        // Falta el ID.
        horarioLaboralDTO.setDiaSemana(horarioLaboral.getDiaSemana());
        horarioLaboralDTO.setHoraInicioTurno(horarioLaboral.getHoraInicioTurno());
        horarioLaboralDTO.setHoraFinTurno(horarioLaboral.getHoraFinTurno());
        // Se retorna el objeto de transferencia mapeado.
        return horarioLaboralDTO;
    }
    
}