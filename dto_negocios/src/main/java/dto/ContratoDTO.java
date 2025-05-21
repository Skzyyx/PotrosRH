/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author skyro
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
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
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

    public String getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public Set<HorarioLaboralDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<HorarioLaboralDTO> horarios) {
        this.horarios = horarios;
    }

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
