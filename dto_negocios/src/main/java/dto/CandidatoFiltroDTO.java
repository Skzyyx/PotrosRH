/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author skyro
 */
public class CandidatoFiltroDTO {
    
    private String rfc;
    private String email;
    private String telefono;

    public CandidatoFiltroDTO() {
    }
    
    public CandidatoFiltroDTO(String rfc, String email, String telefono) {
        this.rfc = rfc;
        this.email = email;
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidatoFiltroDTO{");
        sb.append("rfc=").append(rfc);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
}
