/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Clase que representa una pregunta y su respuesta asociada en el sistema de
 * evaluación. Utilizada como parte del proceso de evaluación de candidatos.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class Pregunta {

    private String pregunta;
    private String respuesta;

    /**
     * Constructor por defecto.
     */
    public Pregunta() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param pregunta Texto de la pregunta
     * @param respuesta Texto de la respuesta
     */
    public Pregunta(String pregunta, String respuesta) {
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
     * Devuelve una representación en cadena de texto del objeto Pregunta.
     *
     * @return Cadena con los atributos de la pregunta y respuesta
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pregunta{");
        sb.append("pregunta=").append(pregunta);
        sb.append(", respuesta=").append(respuesta);
        sb.append('}');
        return sb.toString();
    }
}
