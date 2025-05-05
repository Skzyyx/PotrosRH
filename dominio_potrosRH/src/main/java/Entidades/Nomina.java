/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Nomina {
    private Empleado empleado;
    private Double bono;
    private Double isr;
    private Double salarioBruto;
    private Double salarioNeto;
    private LocalDate fechaCorte;
    private Integer diasTrabajados;
    private Double horasTrabajadas;
    private Double horasExtra;
    private boolean estadoCobro;

    public Nomina() {
    }
    
    
    public Nomina(Empleado empleado, Double bono, Double isr, Double salarioBruto, Double salarioNeto, LocalDate fechaCorte, Integer diasTrabajados, Double horasTrabajadas, Double horasExtra, boolean estadoCobro) {
        this.empleado = empleado;
        this.bono = bono;
        this.isr = isr;
        this.salarioBruto = salarioBruto;
        this.salarioNeto = salarioNeto;
        this.fechaCorte = fechaCorte;
        this.diasTrabajados = diasTrabajados;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtra = horasExtra;
        this.estadoCobro = estadoCobro;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }

    public Double getIsr() {
        return isr;
    }

    public void setIsr(Double isr) {
        this.isr = isr;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(Double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public LocalDate getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(LocalDate fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Integer getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(Integer diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public Double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(Double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public boolean isEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(boolean estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    @Override
    public String toString() {
        return "Nomina{" + "empleado=" + empleado + ", bono=" + bono + ", isr=" + isr + ", salarioBruto=" + salarioBruto + ", salarioNeto=" + salarioNeto + ", fechaCorte=" + fechaCorte + ", diasTrabajados=" + diasTrabajados + ", horasTrabajadas=" + horasTrabajadas + ", horasExtra=" + horasExtra + ", estadoCobro=" + estadoCobro + '}';
    }
    
    
}
