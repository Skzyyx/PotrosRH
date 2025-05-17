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
 *
 * @author skyro
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

    public Contrato() {
    }

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
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public PeriodoPago getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(PeriodoPago periodoPago) {
        this.periodoPago = periodoPago;
    }

    public ModoPago getModoPago() {
        return modoPago;
    }

    public void setModoPago(ModoPago modoPago) {
        this.modoPago = modoPago;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public ObjectId getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(ObjectId empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Set<HorarioLaboral> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<HorarioLaboral> horarios) {
        this.horarios = horarios;
    }

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
