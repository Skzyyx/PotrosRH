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
        DespidoDTO dto = new DespidoDTO();
        if (entity.getId()!= null) {
            dto.setId(entity.getId().toHexString());
        }
        if (entity.getId()!= null) {
            dto.setEmpleadoid(entity.getId().toHexString());
        }
        dto.setFechaDespido(entity.getFechaDespido());
        dto.setMotivo(entity.getMotivo());
        return dto;
    }
}