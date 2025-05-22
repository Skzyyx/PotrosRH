package dto;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */

import java.time.LocalDate;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para el expediente
 * laboral de un empleado. Contiene información personal y laboral básica.
 * 
 * Este DTO se utiliza para transportar datos entre capas sin exponer la entidad directamente.
 * 
 */
public class ExpedienteDTO {

    private String id;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String rfc;
    private String puesto;
    private String departamento;
    private LocalDate fechaIngreso;
    private double sueldoBase;
    
    /**
     * Constructor por defecto
     */
    public ExpedienteDTO() {
    }

    /**
     * Constructor con todos los atributos del expediente.
     * 
     * @param id Identificador del expediente
     * @param nombreCompleto Nombre completo del empleado
     * @param fechaNacimiento Fecha de nacimiento del empleado
     * @param correoElectronico Correo electrónico del empleado
     * @param rfc RFC del empleado
     * @param puesto Puesto del empleado
     * @param departamento Departamento del empleado
     * @param fechaIngreso Fecha de ingreso del empleado
     * @param sueldoBase Sueldo base del empleado
     */
    public ExpedienteDTO(String id, String nombreCompleto, LocalDate fechaNacimiento,
                         String correoElectronico, String rfc, String puesto,
                         String departamento, LocalDate fechaIngreso, double sueldoBase) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.rfc = rfc;
        this.puesto = puesto;
        this.departamento = departamento;
        this.fechaIngreso = fechaIngreso;
        this.sueldoBase = sueldoBase;
    }

     /**
     * Obtiene el identificador del expediente.
     * @return el ID del expediente.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del expediente.
     * @param id el nuevo ID del expediente.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del empleado.
     * @return el nombre completo.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del empleado.
     * @param nombreCompleto el nuevo nombre completo.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene la fecha de nacimiento del empleado.
     * @return la fecha de nacimiento.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del empleado.
     * @param fechaNacimiento la nueva fecha de nacimiento.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     * @return el correo electrónico.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del empleado.
     * @param correoElectronico el nuevo correo electrónico.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el RFC del empleado.
     * @return el RFC.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del empleado.
     * @param rfc el nuevo RFC.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el puesto del empleado.
     * @return el puesto.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado.
     * @param puesto el nuevo puesto.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el departamento en el que trabaja el empleado.
     * @return el departamento.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento en el que trabaja el empleado.
     * @param departamento el nuevo departamento.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene la fecha de ingreso del empleado a la empresa.
     * @return la fecha de ingreso.
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del empleado a la empresa.
     * @param fechaIngreso la nueva fecha de ingreso.
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene el sueldo base del empleado.
     * @return el sueldo base.
     */
    public double getSueldoBase() {
        return sueldoBase;
    }

    /**
     * Establece el sueldo base del empleado.
     * @param sueldoBase el nuevo sueldo base.
     */
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    /**
     * Devuelve una representación en cadena del objeto.
     * @return una cadena que representa el estado del objeto.
     */
    @Override
    public String toString() {
        return "ExpedienteDTO{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", rfc='" + rfc + '\'' +
                ", puesto='" + puesto + '\'' +
                ", departamento='" + departamento + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", sueldoBase=" + sueldoBase +
                '}';
    }
}