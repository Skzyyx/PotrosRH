/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para contratos
 * laborales. Contiene toda la información relacionada con las condiciones
 * laborales de un empleado en un formato adecuado para la transferencia entre
 * capas de la aplicación.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ContratoDTO {

    private String id;
    private String departamento;
    private String tipoContrato;
    private String lugarTrabajo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puesto;
    private Double sueldo;
    private String periodoPago;
    private String modoPago;
    private EmpleadoDTO empleado;
    private Set<HorarioLaboralDTO> horarios = new HashSet<>();

    public ContratoDTO() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param id Identificador único del contrato
     * @param departamento Departamento asignado
     * @param tipoContrato Tipo de contrato
     * @param lugarTrabajo Ubicación del trabajo
     * @param fechaInicio Fecha de inicio del contrato
     * @param fechaFin Fecha de finalización del contrato
     * @param puesto Puesto o cargo asignado
     * @param sueldo Salario acordado
     * @param periodoPago Periodicidad del pago
     * @param modoPago Método de pago
     * @param empleado Empleado asociado al contrato
     * @param horarios Conjunto de horarios laborales
     */
    public ContratoDTO(String id, String departamento, String tipoContrato, String lugarTrabajo, LocalDate fechaInicio, LocalDate fechaFin, String puesto, Double sueldo, String periodoPago, String modoPago, EmpleadoDTO empleado, Set<HorarioLaboralDTO> horarios) {
        this.id = id;
        this.departamento = departamento;
        this.tipoContrato = tipoContrato;
        this.lugarTrabajo = lugarTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.periodoPago = periodoPago;
        this.modoPago = modoPago;
        this.empleado = empleado;
        this.horarios = horarios;
    }

    /**
     * Constructor con todos los atributos excepto el id, que se generará
     * automáticamente.
     *
     * @param departamento Departamento asignado
     * @param tipoContrato Tipo de contrato
     * @param lugarTrabajo Ubicación del trabajo
     * @param fechaInicio Fecha de inicio del contrato
     * @param fechaFin Fecha de finalización del contrato
     * @param puesto Puesto o cargo asignado
     * @param sueldo Salario acordado
     * @param periodoPago Periodicidad del pago
     * @param modoPago Método de pago
     * @param empleado Empleado asociado al contrato
     * @param horarios Conjunto de horarios laborales
     */
    public ContratoDTO(String departamento, String tipoContrato, String lugarTrabajo, LocalDate fechaInicio, LocalDate fechaFin, String puesto, Double sueldo, String periodoPago, String modoPago, EmpleadoDTO empleado, Set<HorarioLaboralDTO> horarios) {
        this.departamento = departamento;
        this.tipoContrato = tipoContrato;
        this.lugarTrabajo = lugarTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.periodoPago = periodoPago;
        this.modoPago = modoPago;
        this.empleado = empleado;
        this.horarios = horarios;
    }

    /**
     * Obtiene el identificador único del contrato.
     *
     * @return Identificador único del contrato
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del contrato.
     *
     * @param id Nuevo identificador único del contrato
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el departamento asignado al empleado.
     *
     * @return Departamento del empleado
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento asignado al empleado.
     *
     * @param departamento Nuevo departamento para el empleado
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el tipo de contrato.
     *
     * @return Tipo de contrato
     */
    public String getTipoContrato() {
        return tipoContrato;
    }

    /**
     * Establece el tipo de contrato.
     *
     * @param tipoContrato Nuevo tipo de contrato
     */
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    /**
     * Obtiene el lugar de trabajo.
     *
     * @return Ubicación física del trabajo
     */
    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    /**
     * Establece el lugar de trabajo.
     *
     * @param lugarTrabajo Nueva ubicación física del trabajo
     */
    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    /**
     * Obtiene la fecha de inicio del contrato.
     *
     * @return Fecha de inicio del contrato
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del contrato.
     *
     * @param fechaInicio Nueva fecha de inicio del contrato
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de finalización del contrato.
     *
     * @return Fecha de finalización del contrato
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de finalización del contrato.
     *
     * @param fechaFin Nueva fecha de finalización del contrato
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el puesto o cargo asignado al empleado.
     *
     * @return Puesto o cargo del empleado
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto o cargo asignado al empleado.
     *
     * @param puesto Nuevo puesto o cargo para el empleado
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el sueldo acordado en el contrato.
     *
     * @return Sueldo acordado
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * Establece el sueldo acordado en el contrato.
     *
     * @param sueldo Nuevo sueldo acordado
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Obtiene la periodicidad del pago.
     *
     * @return Periodo de pago acordado
     */
    public String getPeriodoPago() {
        return periodoPago;
    }

    /**
     * Establece la periodicidad del pago.
     *
     * @param periodoPago Nuevo periodo de pago
     */
    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    /**
     * Obtiene el método de pago.
     *
     * @return Modo de pago acordado
     */
    public String getModoPago() {
        return modoPago;
    }

    /**
     * Establece el método de pago.
     *
     * @param modoPago Nuevo modo de pago
     */
    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    /**
     * Obtiene el empleado asociado al contrato.
     *
     * @return Empleado asociado al contrato
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado asociado al contrato.
     *
     * @param empleado Nuevo empleado asociado al contrato
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el conjunto de horarios laborales asociados al contrato.
     *
     * @return Conjunto de horarios laborales
     */
    public Set<HorarioLaboralDTO> getHorarios() {
        return horarios;
    }

    /**
     * Establece el conjunto de horarios laborales asociados al contrato.
     *
     * @param horarios Nuevo conjunto de horarios laborales
     */
    public void setHorarios(Set<HorarioLaboralDTO> horarios) {
        this.horarios = horarios;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto ContratoDTO.
     *
     * @return Cadena con todos los atributos del contrato
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContratoDTO{");
        sb.append("id=").append(id);
        sb.append(", departamento=").append(departamento);
        sb.append(", tipoContrato=").append(tipoContrato);
        sb.append(", lugarTrabajo=").append(lugarTrabajo);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", puesto=").append(puesto);
        sb.append(", sueldo=").append(sueldo);
        sb.append(", periodoPago=").append(periodoPago);
        sb.append(", modoPago=").append(modoPago);
        sb.append(", empleado=").append(empleado);
        sb.append(", horarios=").append(horarios);
        sb.append('}');
        return sb.toString();
    }
}
