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
 *
 * @author skyro
 */
public class EvaluacionMapper {
    
    public static Evaluacion toEntityViejo(EvaluacionDTO dto) {
        return new Evaluacion(
                new ObjectId(dto.getId()),
                dto.getFechaHoraEvaluacion(),
                ResultadoEvaluacion.valueOf(dto.getResultado()),
                CandidatoMapper.toEntityViejo(dto.getCandidato()),
                PreguntaMapper.toEntitySet(dto.getPreguntas())
        );
    }
    
    public static Evaluacion toEntityNuevo(EvaluacionDTO dto) {
        return new Evaluacion(
                dto.getFechaHoraEvaluacion(),
                ResultadoEvaluacion.valueOf(dto.getResultado()),
                CandidatoMapper.toEntityViejo(dto.getCandidato()),
                PreguntaMapper.toEntitySet(dto.getPreguntas())
        );
    }

    public static EvaluacionDTO toDTOViejo(Evaluacion evaluacion) {
        return new EvaluacionDTO(
                evaluacion.getId().toString(),
                evaluacion.getFechaHoraEvaluacion(),
                evaluacion.getResultado().toString(),
                CandidatoMapper.toDTOViejo(evaluacion.getCandidato()),
                PreguntaMapper.toDTOSet(evaluacion.getPreguntas())
        );
    }
}
