/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Entidades.Pregunta;
import dto.PreguntaDTO;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que proporciona métodos para mapear entre objetos Pregunta (entidad) y
 * PreguntaDTO (objeto de transferencia de datos). Facilita la conversión entre
 * la capa de dominio y la capa de presentación o servicio.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class PreguntaMapper {

    /**
     * Convierte un objeto PreguntaDTO a un objeto Pregunta.
     *
     * @param dto El objeto PreguntaDTO a convertir
     * @return Un objeto Pregunta con los datos del DTO
     */
    public static Pregunta toEntity(PreguntaDTO dto) {
        return new Pregunta(
                dto.getPregunta(),
                dto.getRespuesta()
        );
    }

    /**
     * Convierte un objeto Pregunta a un objeto PreguntaDTO.
     *
     * @param pregunta El objeto Pregunta a convertir
     * @return Un objeto PreguntaDTO con los datos de la entidad
     */
    public static PreguntaDTO toDTO(Pregunta pregunta) {
        return new PreguntaDTO(
                pregunta.getPregunta(),
                pregunta.getRespuesta()
        );
    }

    /**
     * Convierte un conjunto de objetos PreguntaDTO a un conjunto de objetos
     * Pregunta.
     *
     * @param dtos El conjunto de objetos PreguntaDTO a convertir
     * @return Un conjunto de objetos Pregunta con los datos de los DTOs
     */
    public static Set<Pregunta> toEntitySet(Set<PreguntaDTO> dtos) {
        Set<Pregunta> preguntas = new HashSet<>();

        for (PreguntaDTO pregunta : dtos) {
            preguntas.add(toEntity(pregunta));
        }
        return preguntas;
    }

    /**
     * Convierte un conjunto de objetos Pregunta a un conjunto de objetos
     * PreguntaDTO.
     *
     * @param preguntas El conjunto de objetos Pregunta a convertir
     * @return Un conjunto de objetos PreguntaDTO con los datos de las entidades
     */
    public static Set<PreguntaDTO> toDTOSet(Set<Pregunta> preguntas) {
        Set<PreguntaDTO> dtos = new HashSet<>();

        for (Pregunta pregunta : preguntas) {
            dtos.add(toDTO(pregunta));
        }
        return dtos;
    }
}
