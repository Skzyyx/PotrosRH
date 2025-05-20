/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author skyro
 */
public class CandidatoDTO {
    
    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rfc;
    private String curp;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String calle;
    private String numero;
    private String colonia;
    private String experiencia;
    private String nivelEstudio;
    private String habilidadesClave;

    public CandidatoDTO() {
    }

    public CandidatoDTO(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String curp, String email, String telefono, LocalDate fechaNacimiento, String sexo, String calle, String numero, String colonia, String experiencia, String nivelEstudio, String habilidadesClave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.curp = curp;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.experiencia = experiencia;
        this.nivelEstudio = nivelEstudio;
        this.habilidadesClave = habilidadesClave;
    }

    public CandidatoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String curp, String email, String telefono, LocalDate fechaNacimiento, String sexo, String calle, String numero, String colonia, String experiencia, String nivelEstudio, String habilidadesClave) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.curp = curp;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.experiencia = experiencia;
        this.nivelEstudio = nivelEstudio;
        this.habilidadesClave = habilidadesClave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getHabilidadesClave() {
        return habilidadesClave;
    }

    public void setHabilidadesClave(String habilidadesClave) {
        this.habilidadesClave = habilidadesClave;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CandidatoDTO{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", rfc=").append(rfc);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", sexo=").append(sexo);
        sb.append(", calle=").append(calle);
        sb.append(", numero=").append(numero);
        sb.append(", colonia=").append(colonia);
        sb.append(", experiencia=").append(experiencia);
        sb.append(", nivelEstudio=").append(nivelEstudio);
        sb.append(", habilidadesClave=").append(habilidadesClave);
        sb.append('}');
        return sb.toString();
    }
}
