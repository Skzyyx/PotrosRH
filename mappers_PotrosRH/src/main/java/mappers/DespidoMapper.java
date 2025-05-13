package mappers;

import Entidades.Despido;
import dto.DespidoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoMapper {

    public Despido toEntity(DespidoDTO dto) {
        if (dto == null) return null;
        return new Despido(
            String.valueOf(dto.getIdDespido()),
            dto.getFechaDespido(),
            dto.getMotivo()         
        );
    }

    public DespidoDTO toDTO(Despido entity) { 
        if (entity == null) return null;
        return new DespidoDTO(
            entity.getIdDespido(),
            entity.getRfcEmpleado(),
            entity.getFechaDespido(),
            entity.getMotivo()
        );
    }
}