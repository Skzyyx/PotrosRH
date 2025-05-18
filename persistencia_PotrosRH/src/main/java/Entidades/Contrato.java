/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Enums.ModoPago;
import Enums.PeriodoPago;
import Enums.TipoContrato;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 * Clase que representa un contrato laboral en el sistema de gestión de recursos humanos.
 * Contiene toda la información relacionada con las condiciones laborales de un empleado.
 * 
 * @author Jose Luis Islas Molina 252574
 */
public class Contrato {
    
    private ObjectId id;
    private String departamento;
    private TipoContrato tipoContrato;
    private String lugarTrabajo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String puesto;
    private Double sueldo;
    private PeriodoPago periodoPago;
    private ModoPago modoPago;
    private Evaluacion evaluacion;
    private ObjectId empleadoId;
    private Set<HorarioLaboral> horarios = new HashSet<>();

    /**
     * Constructor por defecto.
     */
    public Contrato() {
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
     * @param evaluacion Evaluación asociada al proceso de contratación
     * @param empleadoId Identificador del empleado
     * @param horarios Conjunto de horarios laborales
     */
    public Contrato(ObjectId id, String departamento, TipoContrato tipoContrato, String lugarTrabajo, LocalDate fechaInicio, LocalDate fechaFin, String puesto, Double sueldo, PeriodoPago periodoPago, ModoPago modoPago, Evaluacion evaluacion, ObjectId empleadoId, Set<HorarioLaboral> horarios) {
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
        this.evaluacion = evaluacion;
        this.empleadoId = empleadoId;
        this.horarios = horarios;
    }
    
    /**
     * Obtiene el identificador único del contrato.
     * 
     * @return Identificador único del contrato
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del contrato.
     * 
     * @param id Nuevo identificador único del contrato
     */
    public void setId(ObjectId id) {
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
    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    /**
     * Establece el tipo de contrato.
     * 
     * @param tipoContrato Nuevo tipo de contrato
     */
    public void setTipoContrato(TipoContrato tipoContrato) {
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
    public PeriodoPago getPeriodoPago() {
        return periodoPago;
    }

    /**
     * Establece la periodicidad del pago.
     * 
     * @param periodoPago Nuevo periodo de pago
     */
    public void setPeriodoPago(PeriodoPago periodoPago) {
        this.periodoPago = periodoPago;
    }

    /**
     * Obtiene el método de pago.
     * 
     * @return Modo de pago acordado
     */
    public ModoPago getModoPago() {
        return modoPago;
    }

    /**
     * Establece el método de pago.
     * 
     * @param modoPago Nuevo modo de pago
     */
    public void setModoPago(ModoPago modoPago) {
        this.modoPago = modoPago;
    }

    /**
     * Obtiene la evaluación asociada al proceso de contratación.
     * 
     * @return Evaluación asociada
     */
    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    /**
     * Establece la evaluación asociada al proceso de contratación.
     * 
     * @param evaluacion Nueva evaluación asociada
     */
    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * Obtiene el identificador del empleado asociado al contrato.
     * 
     * @return Identificador único del empleado
     */
    public ObjectId getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el identificador del empleado asociado al contrato.
     * 
     * @param empleadoId Nuevo identificador único del empleado
     */
    public void setEmpleadoId(ObjectId empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Obtiene el conjunto de horarios laborales asociados al contrato.
     * 
     * @return Conjunto de horarios laborales
     */
    public Set<HorarioLaboral> getHorarios() {
        return horarios;
    }

    /**
     * Establece el conjunto de horarios laborales asociados al contrato.
     * 
     * @param horarios Nuevo conjunto de horarios laborales
     */
    public void setHorarios(Set<HorarioLaboral> horarios) {
        this.horarios = horarios;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Contrato.
     * 
     * @return Cadena con todos los atributos del contrato
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contrato{");
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
        sb.append(", evaluacion=").append(evaluacion);
        sb.append(", empleadoId=").append(empleadoId);
        sb.append(", horarios=").append(horarios);
        sb.append('}');
        return sb.toString();
    }
}
