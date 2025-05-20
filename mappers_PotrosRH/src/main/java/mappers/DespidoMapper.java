package mappers;

import Entidades.Despido;
import dto.DespidoDTO;
import org.bson.types.ObjectId;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoMapper {

    public Despido toEntity(DespidoDTO dto) {
        if (dto == null) return null;
        Despido entity = new Despido();
        if (dto.getEmpleadoid() != null && !dto.getEmpleadoid().isEmpty()) {
            entity.setId(new ObjectId(dto.getEmpleadoid()));
        } else {
            throw new IllegalArgumentException("El empleadoId en el DTO no puede ser nulo.");
        }
        entity.setFechaDespido(dto.getFechaDespido());
        entity.setMotivo(dto.getMotivo());
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            try {
                entity.setId(new ObjectId(dto.getId()));
            } catch (IllegalArgumentException e) {
                System.err.println("Error al convertir ID del DTO a ObjectId: " + dto.getId());
            }
        }
        return entity;
    }

    public DespidoDTO toDTO(Despido entity) {
        if (entity == null) return null;
        DespidoDTO dto = new DespidoDTO();
        if (entity.getId()!= null) {
            dto.setId(entity.getId().toHexString());
        }
        if (entity.getEmpleadoId() != null) {
            dto.setEmpleadoid(entity.getEmpleadoId());
        }
        dto.setFechaDespido(entity.getFechaDespido());
        dto.setMotivo(entity.getMotivo());
        return dto;
    }
}