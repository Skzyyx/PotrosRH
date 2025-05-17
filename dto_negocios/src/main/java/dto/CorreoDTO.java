/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Map;

/**
 *
 * @author skyro
 */
public class CorreoDTO {
    
    private String correoReceptor;
    private String plantillaCorreo;
    private Map<String, Object> values;

    public CorreoDTO() {
    }

    public CorreoDTO(String correoReceptor, String plantillaCorreo, Map<String, Object> values) {
        this.correoReceptor = correoReceptor;
        this.plantillaCorreo = plantillaCorreo;
        this.values = values;
    }

    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public String getPlantillaCorreo() {
        return plantillaCorreo;
    }

    public void setPlantillaCorreo(String plantillaCorreo) {
        this.plantillaCorreo = plantillaCorreo;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

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
