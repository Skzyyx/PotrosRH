/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author skyro
 */
public class EvaluacionDTO {
    
    private String id;
    private LocalDateTime fechaHoraEvaluacion;
    private String resultado;
    private String puntuacionesClave;
    private String notas;
    private CandidatoDTO candidato;
    private Set<PreguntaDTO> preguntas = new HashSet<>();

    public EvaluacionDTO() {
    }

    public EvaluacionDTO(String id, LocalDateTime fechaHoraEvaluacion, String resultado, String puntuacionesClave, String notas, CandidatoDTO candidato, Set<PreguntaDTO> preguntas) {
        this.id = id;
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
        this.resultado = resultado;
        this.puntuacionesClave = puntuacionesClave;
        this.notas = notas;
        this.candidato = candidato;
        this.preguntas = preguntas;
    }

    public EvaluacionDTO(LocalDateTime fechaHoraEvaluacion, String resultado, String puntuacionesClave, String notas, CandidatoDTO candidato, Set<PreguntaDTO> preguntas) {
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
        this.resultado = resultado;
        this.puntuacionesClave = puntuacionesClave;
        this.notas = notas;
        this.candidato = candidato;
        this.preguntas = preguntas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraEvaluacion() {
        return fechaHoraEvaluacion;
    }

    public void setFechaHoraEvaluacion(LocalDateTime fechaHoraEvaluacion) {
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getPuntuacionesClave() {
        return puntuacionesClave;
    }

    public void setPuntuacionesClave(String puntuacionesClave) {
        this.puntuacionesClave = puntuacionesClave;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public CandidatoDTO getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoDTO candidato) {
        this.candidato = candidato;
    }

    public Set<PreguntaDTO> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EvaluacionDTO{");
        sb.append("id=").append(id);
        sb.append(", fechaHoraEvaluacion=").append(fechaHoraEvaluacion);
        sb.append(", resultado=").append(resultado);
        sb.append(", candidato=").append(candidato);
        sb.append(", preguntas=").append(preguntas);
        sb.append('}');
        return sb.toString();
    }
}
