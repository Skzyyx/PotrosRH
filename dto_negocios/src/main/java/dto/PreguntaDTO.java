/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author skyro
 */
public class PreguntaDTO {
    
    private String pregunta;
    private String respuesta;

    public PreguntaDTO() {
    }

    public PreguntaDTO(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

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
