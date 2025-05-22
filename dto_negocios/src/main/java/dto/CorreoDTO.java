/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Map;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para correos
 * electrónicos. Contiene la información necesaria para enviar un correo
 * electrónico utilizando una plantilla y valores dinámicos que se insertarán en
 * la plantilla.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class CorreoDTO {

    private String correoReceptor;
    private String plantillaCorreo;
    private Map<String, Object> values;

    /**
     * Constructor por defecto.
     */
    public CorreoDTO() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param correoReceptor Dirección de correo electrónico del destinatario
     * @param plantillaCorreo Nombre o identificador de la plantilla de correo a
     * utilizar
     * @param values Mapa de valores que se insertarán en la plantilla
     */
    public CorreoDTO(String correoReceptor, String plantillaCorreo, Map<String, Object> values) {
        this.correoReceptor = correoReceptor;
        this.plantillaCorreo = plantillaCorreo;
        this.values = values;
    }

    /**
     * Obtiene la dirección de correo electrónico del destinatario.
     *
     * @return Dirección de correo electrónico del destinatario
     */
    public String getCorreoReceptor() {
        return correoReceptor;
    }

    /**
     * Establece la dirección de correo electrónico del destinatario.
     *
     * @param correoReceptor Nueva dirección de correo electrónico del
     * destinatario
     */
    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    /**
     * Obtiene el nombre o identificador de la plantilla de correo.
     *
     * @return Nombre o identificador de la plantilla de correo
     */
    public String getPlantillaCorreo() {
        return plantillaCorreo;
    }

    /**
     * Establece el nombre o identificador de la plantilla de correo.
     *
     * @param plantillaCorreo Nuevo nombre o identificador de la plantilla de
     * correo
     */
    public void setPlantillaCorreo(String plantillaCorreo) {
        this.plantillaCorreo = plantillaCorreo;
    }

    /**
     * Obtiene el mapa de valores que se insertarán en la plantilla.
     *
     * @return Mapa de valores para la plantilla
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Establece el mapa de valores que se insertarán en la plantilla.
     *
     * @param values Nuevo mapa de valores para la plantilla
     */
    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto CorreoDTO.
     *
     * @return Cadena con todos los atributos del correo
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CorreoDTO{");
        sb.append("correoReceptor=").append(correoReceptor);
        sb.append(", plantillaCorreo=").append(plantillaCorreo);
        sb.append(", values=").append(values);
        sb.append('}');
        return sb.toString();
    }
}
