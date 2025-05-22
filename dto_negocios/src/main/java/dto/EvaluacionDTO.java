/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para evaluaciones.
 * Contiene la información de una evaluación realizada a un candidato, incluyendo
 * el resultado, las preguntas realizadas y el candidato evaluado.
 * 
 * @author Jose Luis Islas Molina 252574
 */
public class EvaluacionDTO {
    
    private String id;
    private LocalDateTime fechaHoraEvaluacion;
    private String resultado;
    private String puntuacionesClave;
    private String notas;
    private CandidatoDTO candidato;
    private Set<PreguntaDTO> preguntas = new HashSet<>();

    /**
     * Constructor por defecto.
     */
    public EvaluacionDTO() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     * 
     * @param id Identificador único de la evaluación
     * @param fechaHoraEvaluacion Fecha y hora de la evaluación
     * @param resultado Resultado de la evaluación
     * @param puntuacionesClave Puntuaciones clave obtenidas en la evaluación
     * @param notas Notas adicionales sobre la evaluación
     * @param candidato Candidato evaluado
     * @param preguntas Conjunto de preguntas realizadas
     */
    public EvaluacionDTO(String id, LocalDateTime fechaHoraEvaluacion, String resultado, String puntuacionesClave, String notas, CandidatoDTO candidato, Set<PreguntaDTO> preguntas) {
        this.id = id;
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
        this.resultado = resultado;
        this.puntuacionesClave = puntuacionesClave;
        this.notas = notas;
        this.candidato = candidato;
        this.preguntas = preguntas;
    }

    /**
     * Constructor con todos los atributos excepto el id, que se generará automáticamente.
     * 
     * @param fechaHoraEvaluacion Fecha y hora de la evaluación
     * @param resultado Resultado de la evaluación
     * @param puntuacionesClave Puntuaciones clave obtenidas en la evaluación
     * @param notas Notas adicionales sobre la evaluación
     * @param candidato Candidato evaluado
     * @param preguntas Conjunto de preguntas realizadas
     */
    public EvaluacionDTO(LocalDateTime fechaHoraEvaluacion, String resultado, String puntuacionesClave, String notas, CandidatoDTO candidato, Set<PreguntaDTO> preguntas) {
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
        this.resultado = resultado;
        this.puntuacionesClave = puntuacionesClave;
        this.notas = notas;
        this.candidato = candidato;
        this.preguntas = preguntas;
    }

    /**
     * Obtiene el identificador único de la evaluación.
     * 
     * @return Identificador único de la evaluación
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la evaluación.
     * 
     * @param id Nuevo identificador único de la evaluación
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora en que se realizó la evaluación.
     * 
     * @return Fecha y hora de la evaluación
     */
    public LocalDateTime getFechaHoraEvaluacion() {
        return fechaHoraEvaluacion;
    }

    /**
     * Establece la fecha y hora en que se realizó la evaluación.
     * 
     * @param fechaHoraEvaluacion Nueva fecha y hora de la evaluación
     */
    public void setFechaHoraEvaluacion(LocalDateTime fechaHoraEvaluacion) {
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
    }

    /**
     * Obtiene el resultado de la evaluación.
     * 
     * @return Resultado de la evaluación
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Establece el resultado de la evaluación.
     * 
     * @param resultado Nuevo resultado de la evaluación
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Obtiene las puntuaciones clave de la evaluación.
     * 
     * @return Puntuaciones clave de la evaluación
     */
    public String getPuntuacionesClave() {
        return puntuacionesClave;
    }

    /**
     * Establece las puntuaciones clave de la evaluación.
     * 
     * @param puntuacionesClave Nuevas puntuaciones clave de la evaluación
     */
    public void setPuntuacionesClave(String puntuacionesClave) {
        this.puntuacionesClave = puntuacionesClave;
    }

    /**
     * Obtiene las notas adicionales de la evaluación.
     * 
     * @return Notas adicionales de la evaluación
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Establece las notas adicionales de la evaluación.
     * 
     * @param notas Nuevas notas adicionales de la evaluación
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Obtiene el candidato evaluado.
     * 
     * @return Candidato evaluado
     */
    public CandidatoDTO getCandidato() {
        return candidato;
    }

    /**
     * Establece el candidato evaluado.
     * 
     * @param candidato Nuevo candidato evaluado
     */
    public void setCandidato(CandidatoDTO candidato) {
        this.candidato = candidato;
    }

    /**
     * Obtiene el conjunto de preguntas realizadas en la evaluación.
     * 
     * @return Conjunto de preguntas de la evaluación
     */
    public Set<PreguntaDTO> getPreguntas() {
        return preguntas;
    }

    /**
     * Establece el conjunto de preguntas realizadas en la evaluación.
     * 
     * @param preguntas Nuevo conjunto de preguntas para la evaluación
     */
    public void setPreguntas(Set<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto EvaluacionDTO.
     * 
     * @return Cadena con todos los atributos de la evaluación
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EvaluacionDTO{");
        sb.append("id=").append(id);
        sb.append(", fechaHoraEvaluacion=").append(fechaHoraEvaluacion);
        sb.append(", resultado=").append(resultado);
        sb.append(", puntuacionesClave=").append(puntuacionesClave);
        sb.append(", notas=").append(notas);
        sb.append(", candidato=").append(candidato);
        sb.append(", preguntas=").append(preguntas);
        sb.append('}');
        return sb.toString();
    }

}