/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para
 * candidatos. Contiene toda la información personal y profesional relevante de
 * un candidato en un formato adecuado para la transferencia entre capas de la
 * aplicación.
 *
 * @author Jose Luis Islas Molina 252574
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

    /**
     * Constructor por defecto.
     */
    public CandidatoDTO() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param id Identificador único del candidato
     * @param nombre Nombre del candidato
     * @param apellidoPaterno Apellido paterno del candidato
     * @param apellidoMaterno Apellido materno del candidato
     * @param rfc RFC del candidato
     * @param curp CURP del candidato
     * @param email Correo electrónico del candidato
     * @param telefono Número telefónico del candidato
     * @param fechaNacimiento Fecha de nacimiento del candidato
     * @param sexo Sexo del candidato
     * @param calle Calle de la dirección del candidato
     * @param numero Número de la dirección del candidato
     * @param colonia Colonia de la dirección del candidato
     * @param experiencia Descripción de la experiencia laboral del candidato
     * @param nivelEstudio Nivel de estudios del candidato
     * @param habilidadesClave Habilidades clave del candidato
     */
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

    /**
     * Constructor con todos los atributos excepto el id, que se generará
     * automáticamente.
     *
     * @param nombre Nombre del candidato
     * @param apellidoPaterno Apellido paterno del candidato
     * @param apellidoMaterno Apellido materno del candidato
     * @param rfc RFC del candidato
     * @param curp CURP del candidato
     * @param email Correo electrónico del candidato
     * @param telefono Número telefónico del candidato
     * @param fechaNacimiento Fecha de nacimiento del candidato
     * @param sexo Sexo del candidato
     * @param calle Calle de la dirección del candidato
     * @param numero Número de la dirección del candidato
     * @param colonia Colonia de la dirección del candidato
     * @param experiencia Descripción de la experiencia laboral del candidato
     * @param nivelEstudio Nivel de estudios del candidato
     * @param habilidadesClave Habilidades clave del candidato
     */
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

    /**
     * Obtiene el identificador único del candidato.
     *
     * @return Identificador único del candidato
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del candidato.
     *
     * @param id Nuevo identificador único del candidato
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del candidato.
     *
     * @return Nombre del candidato
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del candidato.
     *
     * @param nombre Nuevo nombre del candidato
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del candidato.
     *
     * @return Apellido paterno del candidato
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del candidato.
     *
     * @param apellidoPaterno Nuevo apellido paterno del candidato
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del candidato.
     *
     * @return Apellido materno del candidato
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del candidato.
     *
     * @param apellidoMaterno Nuevo apellido materno del candidato
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el RFC del candidato.
     *
     * @return RFC del candidato
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del candidato.
     *
     * @param rfc Nuevo RFC del candidato
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene la CURP del candidato.
     *
     * @return CURP del candidato
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece la CURP del candidato.
     *
     * @param curp Nueva CURP del candidato
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Obtiene el correo electrónico del candidato.
     *
     * @return Correo electrónico del candidato
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del candidato.
     *
     * @param email Nuevo correo electrónico del candidato
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono del candidato.
     *
     * @return Número de teléfono del candidato
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del candidato.
     *
     * @param telefono Nuevo número de teléfono del candidato
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento del candidato.
     *
     * @return Fecha de nacimiento del candidato
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del candidato.
     *
     * @param fechaNacimiento Nueva fecha de nacimiento del candidato
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el sexo del candidato.
     *
     * @return Sexo del candidato
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del candidato.
     *
     * @param sexo Nuevo sexo del candidato
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene la calle de la dirección del candidato.
     *
     * @return Calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección del candidato.
     *
     * @param calle Nueva calle de la dirección
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la dirección del candidato.
     *
     * @return Número de la dirección
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección del candidato.
     *
     * @param numero Nuevo número de la dirección
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la colonia de la dirección del candidato.
     *
     * @return Colonia de la dirección
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección del candidato.
     *
     * @param colonia Nueva colonia de la dirección
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene la experiencia laboral del candidato.
     *
     * @return Descripción de la experiencia laboral
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia laboral del candidato.
     *
     * @param experiencia Nueva descripción de la experiencia laboral
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Obtiene el nivel de estudios del candidato.
     *
     * @return Nivel de estudios
     */
    public String getNivelEstudio() {
        return nivelEstudio;
    }

    /**
     * Establece el nivel de estudios del candidato.
     *
     * @param nivelEstudio Nuevo nivel de estudios
     */
    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    /**
     * Obtiene las habilidades clave del candidato.
     *
     * @return Habilidades clave
     */
    public String getHabilidadesClave() {
        return habilidadesClave;
    }

    /**
     * Establece las habilidades clave del candidato.
     *
     * @param habilidadesClave Nuevas habilidades clave
     */
    public void setHabilidadesClave(String habilidadesClave) {
        this.habilidadesClave = habilidadesClave;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto CandidatoDTO.
     *
     * @return Cadena con todos los atributos del candidato
     */
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
