package mappers;

import Entidades.HorarioLaboral;
import Enums.DiaSemana;
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
    /**
     * Convierte un objeto HorarioLaboralDTO a HorarioLaboral.
     * Pensado para nuevos registros (inserción).
     * @param horarioLaboralDTO DTO a mapear.
     * @return Entidad HorarioLaboral mapeada.
     */
    public static HorarioLaboral toEntityNuevo(HorarioLaboralDTO horarioLaboralDTO) {
        HorarioLaboral horarioLaboral = new HorarioLaboral();
        horarioLaboral.setDiaSemana(DiaSemana.valueOf(horarioLaboralDTO.getDiaSemana().trim().toUpperCase()));
        horarioLaboral.setHoraInicioTurno(horarioLaboralDTO.getHoraInicioTurno());
        horarioLaboral.setHoraFinTurno(horarioLaboralDTO.getHoraFinTurno());
        //Retorna la entidad mapeada
        return horarioLaboral;
    }
    /**
     * Convierte un objeto HorarioLaboralDTO a HorarioLaboral.
     * Pensado para viejos registros o registros persistidos
     * previamente (actualización).
     * @param horarioLaboralDTO DTO a mapear.
     * @return Entidad HorarioLaboral mapeada.
     */
    public static HorarioLaboral toEntityViejo(HorarioLaboralDTO horarioLaboralDTO){
        HorarioLaboral horarioLaboral = new HorarioLaboral();
        // Falta el ID.
        horarioLaboral.setDiaSemana(DiaSemana.valueOf(horarioLaboralDTO.getDiaSemana().trim().toUpperCase()));
        horarioLaboral.setHoraInicioTurno(horarioLaboralDTO.getHoraInicioTurno());
        horarioLaboral.setHoraFinTurno(horarioLaboralDTO.getHoraFinTurno());
        // Retorna la entidad mapeada.
        return horarioLaboral;
    }
    /**
     * Convierte un objeto HorarioLaboral a HorarioLaboralDTO.
     * @param horarioLaboral Entidad a mapear.
     * @return Objeto HorarioLaboralDTO mapeado.
     */
    public static HorarioLaboralDTO toDTO(HorarioLaboral horarioLaboral){
        HorarioLaboralDTO horarioLaboralDTO = new HorarioLaboralDTO();
        // Falta el ID.
        horarioLaboralDTO.setDiaSemana(horarioLaboral.getDiaSemana().name());
        horarioLaboralDTO.setHoraInicioTurno(horarioLaboral.getHoraInicioTurno());
        horarioLaboralDTO.setHoraFinTurno(horarioLaboral.getHoraFinTurno());
        // Se retorna el objeto de transferencia mapeado.
        return horarioLaboralDTO;
    }
    
}