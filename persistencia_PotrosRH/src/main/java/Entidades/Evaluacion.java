/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Enums.ResultadoEvaluacion;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 *
 * @author skyro
 */
public class Evaluacion {
    
    private ObjectId id;
    private LocalDateTime fechaHoraEvaluacion;
    private ResultadoEvaluacion resultado;
    private Candidato candidato;
    private Set<Pregunta> preguntas = new HashSet<>();

    public Evaluacion() {
    }

    public Evaluacion(ObjectId id, LocalDateTime fechaHoraEvaluacion, ResultadoEvaluacion resultado, Candidato candidato, Set<Pregunta> preguntas) {
        this.id = id;
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
        this.resultado = resultado;
        this.candidato = candidato;
        this.preguntas = preguntas;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraEvaluacion() {
        return fechaHoraEvaluacion;
    }

    public void setFechaHoraEvaluacion(LocalDateTime fechaHoraEvaluacion) {
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
    }

    public ResultadoEvaluacion getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEvaluacion resultado) {
        this.resultado = resultado;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evaluacion{");
        sb.append("id=").append(id);
        sb.append(", fechaHoraEvaluacion=").append(fechaHoraEvaluacion);
        sb.append(", resultado=").append(resultado);
        sb.append(", candidato=").append(candidato);
        sb.append(", preguntas=").append(preguntas);
        sb.append('}');
        return sb.toString();
    }

    
}
