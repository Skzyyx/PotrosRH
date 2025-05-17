/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author skyro
 */
public class Candidato {
    
    private ObjectId id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rfc;
    private String email;
    private String telefono;
    private Integer edad;
    private String experiencia;
    private String nivelEstudio;
    private String habilidadesClave;

    public Candidato() {
    }

    public Candidato(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, String email, String telefono, Integer edad, String experiencia, String nivelEstudio, String habilidadesClave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.experiencia = experiencia;
        this.nivelEstudio = nivelEstudio;
        this.habilidadesClave = habilidadesClave;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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
        sb.append("Candidato{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", rfc=").append(rfc);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append(", edad=").append(edad);
        sb.append(", experiencia=").append(experiencia);
        sb.append(", nivelEstudio=").append(nivelEstudio);
        sb.append(", habilidadesClave=").append(habilidadesClave);
        sb.append('}');
        return sb.toString();
    }
    
    
}
