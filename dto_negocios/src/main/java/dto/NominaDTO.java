package dto;

import java.time.LocalDate;

/**
 *
 * @author ErnestoLpz_252663
 */
public class NominaDTO {
    private EmpleadoDTO empleado;
    private double bono;
    private double isr;
    private double salarioBruto;
    private double salarioNeto;
    private LocalDate fechaCorte;
    private double horasTrabajadas;
    private double horaExtra;

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public double getIsr() {
        return isr;
    }

    public void setIsr(double isr) {
        this.isr = isr;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    public LocalDate getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(LocalDate fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(double horaExtra) {
        this.horaExtra = horaExtra;
    }

    public NominaDTO() {
    }

    public NominaDTO(EmpleadoDTO empleado, double bono, double isr, double salarioBruto, double salarioNeto, LocalDate fechaCorte, double horasTrabajadas, double horaExtra) {
        this.empleado = empleado;
        this.bono = bono;
        this.isr = isr;
        this.salarioBruto = salarioBruto;
        this.salarioNeto = salarioNeto;
        this.fechaCorte = fechaCorte;
        this.horasTrabajadas = horasTrabajadas;
        this.horaExtra = horaExtra;
    }

    @Override
    public String toString() {
        return "NominaDTO{" + "empleado=" + empleado + ", bono=" + bono + ", isr=" + isr + ", salarioBruto=" + salarioBruto + ", salarioNeto=" + salarioNeto + ", fechaCorte=" + fechaCorte + ", horasTrabajadas=" + horasTrabajadas + ", horaExtra=" + horaExtra + '}';
    }    
}