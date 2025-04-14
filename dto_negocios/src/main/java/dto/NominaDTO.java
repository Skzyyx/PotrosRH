package dto;

import java.time.LocalDate;

/**
 * Objeto de transferencia para Nominas.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaDTO {
    
    private EmpleadoDTO empleado;
    private double bono;
    private double salarioBruto;
    private double isr;
    private double salarioNeto;
    private LocalDate fechaCorte;
    private double horasTrabajadas;
    private double horaExtra;

    public NominaDTO() {}

    public NominaDTO(
            EmpleadoDTO empleado, 
            double bono, 
            double salarioBruto, 
            double isr, 
            double salarioNeto, 
            LocalDate fechaCorte, 
            double horasTrabajadas, 
            double horaExtra
    ) 
    {
        this.empleado = empleado;
        this.bono = bono;
        this.salarioBruto = salarioBruto;
        this.isr = isr;
        this.salarioNeto = salarioNeto;
        this.fechaCorte = fechaCorte;
        this.horasTrabajadas = horasTrabajadas;
        this.horaExtra = horaExtra;
    }
    
    public EmpleadoDTO getEmpleado() {return empleado;}

    public void setEmpleado(EmpleadoDTO empleado) {this.empleado = empleado;}

    public double getBono() {return bono;}

    public void setBono(double bono) {this.bono = bono;}

    public double getIsr() {return isr;}

    public void setIsr(double isr) {this.isr = isr;}

    public double getSalarioBruto() {return salarioBruto;}

    public void setSalarioBruto(double salarioBruto) {this.salarioBruto = salarioBruto;}

    public double getSalarioNeto() {return salarioNeto;}

    public void setSalarioNeto(double salarioNeto) {this.salarioNeto = salarioNeto;}

    public LocalDate getFechaCorte() {return fechaCorte;}

    public void setFechaCorte(LocalDate fechaCorte) {this.fechaCorte = fechaCorte;}

    public double getHorasTrabajadas() {return horasTrabajadas;}

    public void setHorasTrabajadas(double horasTrabajadas) {this.horasTrabajadas = horasTrabajadas;}

    public double getHoraExtra() {return horaExtra;}

    public void setHoraExtra(double horaExtra) {this.horaExtra = horaExtra;}

    @Override
    public String toString() {
        return "NominaDTO{" + "empleado=" + empleado + ", bono=" + bono + ", isr=" + isr + ", salarioBruto=" + salarioBruto + ", salarioNeto=" + salarioNeto + ", fechaCorte=" + fechaCorte + ", horasTrabajadas=" + horasTrabajadas + ", horaExtra=" + horaExtra + '}';
    }    
}