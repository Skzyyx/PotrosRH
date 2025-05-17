/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Entidades.Pregunta;
import dto.PreguntaDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author skyro
 */
public class PreguntaMapper {
    
    public static Pregunta toEntity(PreguntaDTO dto) {
        return new Pregunta(
                dto.getPregunta(),
                dto.getRespuesta()
        );
    }
    
    public static PreguntaDTO toDTO(Pregunta pregunta) {
        return new PreguntaDTO(
                pregunta.getPregunta(),
                pregunta.getRespuesta()
        );
    }
    
    public static Set<Pregunta> toEntitySet(Set<PreguntaDTO> dtos) {
        Set<Pregunta> preguntas = new HashSet<>();
        
        for (PreguntaDTO pregunta : dtos) {
            preguntas.add(toEntity(pregunta));
        }
        return preguntas;
    }
    
    public static Set<PreguntaDTO> toDTOSet(Set<Pregunta> preguntas) {
        Set<PreguntaDTO> dtos = new HashSet<>();
        
        for (Pregunta pregunta : preguntas) {
            dtos.add(toDTO(pregunta));
        }
        return dtos;
    }
}
