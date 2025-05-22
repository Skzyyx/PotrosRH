/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para preguntas
 * y respuestas. Contiene la información de una pregunta y su respuesta
 * asociada, utilizada en el proceso de evaluación de candidatos.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class PreguntaDTO {

    private String pregunta;
    private String respuesta;

    /**
     * Constructor por defecto.
     */
    public PreguntaDTO() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param pregunta Texto de la pregunta
     * @param respuesta Texto de la respuesta
     */
    public PreguntaDTO(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    /**
     * Obtiene el texto de la pregunta.
     *
     * @return Texto de la pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * Establece el texto de la pregunta.
     *
     * @param pregunta Nuevo texto de la pregunta
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * Obtiene el texto de la respuesta.
     *
     * @return Texto de la respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * Establece el texto de la respuesta.
     *
     * @param respuesta Nuevo texto de la respuesta
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto PreguntaDTO.
     *
     * @return Cadena con los atributos de la pregunta y respuesta
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreguntaDTO{");
        sb.append("pregunta=").append(pregunta);
        sb.append(", respuesta=").append(respuesta);
        sb.append('}');
        return sb.toString();
    }
}
