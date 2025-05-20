package mappers;

import Entidades.Despido;
import dto.DespidoDTO;
import org.bson.types.ObjectId;

/**
 * La clase proporciona métodos para convertir entre
 * la entidad y el DTO facilita la transferencia de datos entre la capa de negocio y la capa de datos
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoMapper {

    /**
     * Convierte un objeto DespidoDTO a una entidad Despido.
     *
     * @param dto El objeto DespidoDTO a convertir
     * @return Una nueva instancia de Despido creada a partir del DTO,
     * o null si el DTO de entrada es null
     * @throws IllegalArgumentException Si el empleadoId en el DTO es null
     * o una cadena vacía, ya que es un campo obligatorio para la entidad
     */
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

    /**
     * Convierte una entidad Despido a un objeto DespidoDTO.
     *
     * @param entity La entidad Despido a convertir.
     * @return Una nueva instancia de DespidoDTO creada a partir de la
     * entidad, o null si la entidad de entrada es null.
     */
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