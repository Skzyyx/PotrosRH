/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Entidades.Evaluacion;
import Enums.ResultadoEvaluacion;
import dto.EvaluacionDTO;
import org.bson.types.ObjectId;

/**
 * Clase que proporciona métodos para mapear entre objetos Evaluacion (entidad)
 * y EvaluacionDTO (objeto de transferencia de datos). Facilita la conversión
 * entre la capa de dominio y la capa de presentación o servicio.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class EvaluacionMapper {

    /**
     * Convierte un objeto EvaluacionDTO a un objeto Evaluacion para registros
     * existentes. Este método se utiliza cuando se va a actualizar una
     * evaluación existente que ya tiene ID.
     *
     * @param dto El objeto EvaluacionDTO a convertir
     * @return Un objeto Evaluacion con los datos del DTO, incluyendo el ID
     */
    public static Evaluacion toEntityViejo(EvaluacionDTO dto) {
        return new Evaluacion(
                new ObjectId(dto.getId()),
                dto.getFechaHoraEvaluacion(),
                ResultadoEvaluacion.valueOf(dto.getResultado()),
                dto.getPuntuacionesClave(),
                dto.getNotas(),
                CandidatoMapper.toEntityViejo(dto.getCandidato()),
                PreguntaMapper.toEntitySet(dto.getPreguntas())
        );
    }

    /**
     * Convierte un objeto EvaluacionDTO a un objeto Evaluacion para nuevos
     * registros. Este método se utiliza cuando se va a crear una nueva
     * evaluación y no tiene ID asignado.
     *
     * @param dto El objeto EvaluacionDTO a convertir
     * @return Un nuevo objeto Evaluacion con los datos del DTO
     */
    public static Evaluacion toEntityNuevo(EvaluacionDTO dto) {
        return new Evaluacion(
                dto.getFechaHoraEvaluacion(),
                ResultadoEvaluacion.valueOf(dto.getResultado()),
                dto.getPuntuacionesClave(),
                dto.getNotas(),
                CandidatoMapper.toEntityViejo(dto.getCandidato()),
                PreguntaMapper.toEntitySet(dto.getPreguntas())
        );
    }

    /**
     * Convierte un objeto Evaluacion a un objeto EvaluacionDTO para registros
     * existentes. Este método incluye el ID en el DTO resultante.
     *
     * @param evaluacion El objeto Evaluacion a convertir
     * @return Un objeto EvaluacionDTO con los datos de la entidad, incluyendo
     * el ID
     */
    public static EvaluacionDTO toDTOViejo(Evaluacion evaluacion) {
        return new EvaluacionDTO(
                evaluacion.getId().toString(),
                evaluacion.getFechaHoraEvaluacion(),
                evaluacion.getResultado().toString(),
                evaluacion.getPuntuacionesClave(),
                evaluacion.getNotas(),
                CandidatoMapper.toDTOViejo(evaluacion.getCandidato()),
                PreguntaMapper.toDTOSet(evaluacion.getPreguntas())
        );
    }
}
