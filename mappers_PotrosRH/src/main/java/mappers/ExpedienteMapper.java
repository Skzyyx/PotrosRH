package mappers;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */
import Entidades.Expediente;
import dto.ExpedienteDTO;
import org.bson.types.ObjectId;

/**
 * Clase que proporciona métodos para mapear entre objetos Expediente (entidad) y
 * ExpedienteDTO (objeto de transferencia de datos). Facilita la conversión entre
 * la capa de dominio y la capa de presentación o servicio.
 * 
 */
public class ExpedienteMapper {

    /**
     * Convierte un objeto ExpedienteDTO a un objeto Expediente para nuevos registros.
     * Este método se utiliza cuando se va a crear un nuevo expediente y no tiene ID asignado.
     *
     * @param dto El objeto ExpedienteDTO a convertir
     * @return Un nuevo objeto Expediente con los datos del DTO
     */
    public static Expediente toEntityNuevo(ExpedienteDTO dto) {
        return new Expediente(
                dto.getNombreCompleto(),
                dto.getFechaNacimiento(),
                dto.getCorreoElectronico(),
                dto.getRfc(),
                dto.getPuesto(),
                dto.getDepartamento(),
                dto.getFechaIngreso(),
                dto.getSueldoBase()
        );
    }

    /**
     * Convierte un objeto Expediente a un objeto ExpedienteDTO.
     * Este método se utiliza para transformar una entidad de dominio en un objeto de
     * transferencia de datos que puede ser enviado a la capa de presentación.
     *
     * @param expediente El objeto Expediente a convertir
     * @return Un objeto ExpedienteDTO con los datos de la entidad
     */
    public static ExpedienteDTO toDTO(Expediente expediente) {
        return new ExpedienteDTO(
                expediente.getId().toString(),
                expediente.getNombreCompleto(),
                expediente.getFechaNacimiento(),
                expediente.getCorreoElectronico(),
                expediente.getRfc(),
                expediente.getPuesto(),
                expediente.getDepartamento(),
                expediente.getFechaIngreso(),
                expediente.getSueldoBase()
        );
    }
    
    /**
     * Convierte un objeto ExpedienteDTO a un objeto Expediente para registros existentes.
     * Valida que el ID sea válido antes de crear el ObjectId.
     *
     * @param dto El objeto ExpedienteDTO a convertir
     * @return Un objeto Expediente con los datos del DTO, incluyendo el ID
     * @throws IllegalArgumentException Si el ID es nulo, vacío o inválido
     */
    public static Expediente toEntityViejo(ExpedienteDTO dto) {
        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del ExpedienteDTO no puede ser nulo o vacío");
        }
        ObjectId id;
        try {
            id = new ObjectId(dto.getId());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("ID inválido para ObjectId: " + dto.getId(), ex);
        }

        return new Expediente(
                id,
                dto.getNombreCompleto(),
                dto.getFechaNacimiento(),
                dto.getCorreoElectronico(),
                dto.getRfc(),
                dto.getPuesto(),
                dto.getDepartamento(),
                dto.getFechaIngreso(),
                dto.getSueldoBase()
        );
    }
    
    /**
    * Convierte un objeto ExpedienteDTO a un objeto Expediente.
    * <p>
    * Este método selecciona la conversión adecuada según si el DTO contiene un ID válido o no:
    * <ul>
    *   <li>Si el ID es nulo o está vacío, se asume que es un nuevo expediente y se utiliza {@link #toEntityNuevo(ExpedienteDTO)}.</li>
    *   <li>Si el ID está presente, se utiliza {@link #toEntityViejo(ExpedienteDTO)} para crear un expediente existente con ID.</li>
    * </ul>
    * </p>
    *
    * @param dto El objeto ExpedienteDTO a convertir.
    * @return Un objeto Expediente con los datos del DTO.
    * @throws IllegalArgumentException Si el ID no es nulo ni vacío, pero no tiene un formato válido para {@link org.bson.types.ObjectId}.
    */
    public static Expediente toEntity(ExpedienteDTO dto) {
        if (dto.getId() == null || dto.getId().isBlank()) {
            return toEntityNuevo(dto);
        } else {
            return toEntityViejo(dto);
        }
    }
}
