package Entidades;

import Enums.ResultadoEvaluacion;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 * Clase que representa una evaluación realizada a un candidato en el proceso de
 * selección. Contiene información sobre el resultado, las preguntas realizadas
 * y el candidato evaluado.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class Evaluacion {

    private ObjectId id;
    private LocalDateTime fechaHoraEvaluacion;
    private ResultadoEvaluacion resultado;
    private String puntuacionesClave;
    private String notas;
    private Candidato candidato;
    private Set<Pregunta> preguntas = new HashSet<>();

    /**
     * Constructor por defecto.
     */
    public Evaluacion() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param id Identificador único de la evaluación
     * @param fechaHoraEvaluacion Fecha y hora de la evaluación
     * @param resultado Resultado de la evaluación
     * @param candidato Candidato evaluado
     * @param preguntas Conjunto de preguntas realizadas
     */
    
    public Evaluacion(ObjectId id, LocalDateTime fechaHoraEvaluacion, ResultadoEvaluacion resultado, String puntuacionesClave, String notas, Candidato candidato, Set<Pregunta> preguntas) {
        this.id = id;
        this.fechaHoraEvaluacion = fechaHoraEvaluacion;
        this.resultado = resultado;
        this.puntuacionesClave = puntuacionesClave;
        this.notas = notas;
        this.candidato = candidato;
        this.preguntas = preguntas;
    }

    public Evaluacion(LocalDateTime fechaHoraEvaluacion, ResultadoEvaluacion resultado, String puntuacionesClave, String notas, Candidato candidato, Set<Pregunta> preguntas) {
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
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la evaluación.
     *
     * @param id Nuevo identificador único de la evaluación
     */
    public void setId(ObjectId id) {
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
    public ResultadoEvaluacion getResultado() {
        return resultado;
    }

    /**
     * Establece el resultado de la evaluación.
     *
     * @param resultado Nuevo resultado de la evaluación
     */
    public void setResultado(ResultadoEvaluacion resultado) {
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

    /**
     * Obtiene el candidato evaluado.
     *
     * @return Candidato evaluado
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * Establece el candidato evaluado.
     *
     * @param candidato Nuevo candidato evaluado
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    /**
     * Obtiene el conjunto de preguntas realizadas en la evaluación.
     *
     * @return Conjunto de preguntas de la evaluación
     */
    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     * Establece el conjunto de preguntas realizadas en la evaluación.
     *
     * @param preguntas Nuevo conjunto de preguntas para la evaluación
     */
    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Evaluacion.
     *
     * @return Cadena con todos los atributos de la evaluación
     */
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
