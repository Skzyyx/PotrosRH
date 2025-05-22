package Entidades;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */
import org.bson.types.ObjectId;
import java.time.LocalDate;

/**
 * Representa el expediente laboral de un empleado
 * Contiene datos personales, laborales, contrato y nómina, que son necesarios 
 * para construir el expediente laboral de un empleado
 */

public class Expediente {
    
    private ObjectId id;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private String rfc;
    private String puesto;
    private String departamento;
    private LocalDate fechaIngreso;
    private double sueldoBase;

    /**
     * Constructor por defecto.
     */
    public Expediente() {
    }

    /**
     * Constructor con todos los atributos, incluyendo el ID.
     * 
     * @param id Identificador único del expediente
     * @param nombreCompleto Nombre completo del empleado
     * @param fechaNacimiento Fecha de nacimiento del empleado
     * @param correoElectronico Correo electrónico del empleado
     * @param rfc RFC del empleado
     * @param puesto Puesto que ocupa el empleado
     * @param departamento Departamento en el que trabaja el empleado
     * @param fechaIngreso Fecha de ingreso a la empresa
     * @param sueldoBase Sueldo base del empleado
     */
    public Expediente(ObjectId id, String nombreCompleto, LocalDate fechaNacimiento, String correoElectronico, String rfc,
                      String puesto, String departamento, LocalDate fechaIngreso, double sueldoBase) {
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
     * Constructor sin ID (para registros nuevos).
     * 
     * @param nombreCompleto Nombre completo del empleado
     * @param fechaNacimiento Fecha de nacimiento del empleado
     * @param correoElectronico Correo electrónico del empleado
     * @param rfc RFC del empleado
     * @param puesto Puesto que ocupa el empleado
     * @param departamento Departamento en el que trabaja el empleado
     * @param fechaIngreso Fecha de ingreso a la empresa
     * @param sueldoBase Sueldo base del empleado
     */
    public Expediente(String nombreCompleto, LocalDate fechaNacimiento, String correoElectronico, String rfc,
                      String puesto, String departamento, LocalDate fechaIngreso, double sueldoBase) {
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
     * Obtiene el identificador único del expediente.
     *
     * @return El identificador único (ObjectId)
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del expediente.
     *
     * @param id Nuevo identificador único (ObjectId)
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del empleado.
     *
     * @return Nombre completo del empleado
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del empleado.
     *
     * @param nombreCompleto Nuevo nombre completo del empleado
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene la fecha de nacimiento del empleado.
     *
     * @return Fecha de nacimiento del empleado
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del empleado.
     *
     * @param fechaNacimiento Nueva fecha de nacimiento del empleado
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return Correo electrónico del empleado
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correoElectronico Nuevo correo electrónico del empleado
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el RFC del empleado.
     *
     * @return RFC del empleado
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del empleado.
     *
     * @param rfc Nuevo RFC del empleado
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el puesto actual del empleado.
     *
     * @return Puesto del empleado
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto actual del empleado.
     *
     * @param puesto Nuevo puesto del empleado
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el departamento al que pertenece el empleado.
     *
     * @return Departamento del empleado
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento al que pertenece el empleado.
     *
     * @param departamento Nuevo departamento del empleado
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene la fecha de ingreso del empleado a la empresa.
     *
     * @return Fecha de ingreso del empleado
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del empleado a la empresa.
     *
     * @param fechaIngreso Nueva fecha de ingreso del empleado
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene el sueldo base del empleado.
     *
     * @return Sueldo base del empleado
     */
    public double getSueldoBase() {
        return sueldoBase;
    }

    /**
     * Establece el sueldo base del empleado.
     *
     * @param sueldoBase Nuevo sueldo base del empleado
     */
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }


    /**
     * Devuelve una representación en cadena de texto del objeto Expediente.
     * 
     * @return Cadena con todos los atributos del expediente
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Expediente{");
        sb.append("id=").append(id);
        sb.append(", nombreCompleto=").append(nombreCompleto);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", correoElectronico=").append(correoElectronico);
        sb.append(", rfc=").append(rfc);
        sb.append(", puesto=").append(puesto);
        sb.append(", departamento=").append(departamento);
        sb.append(", fechaIngreso=").append(fechaIngreso);
        sb.append(", sueldoBase=").append(sueldoBase);
        sb.append('}');
        return sb.toString();
    }
}
