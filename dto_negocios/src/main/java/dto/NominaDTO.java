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
    private Double bono;
    private Double salarioBruto;
    private Double isr;
    private Double salarioNeto;
    private LocalDate fechaCorte;
    private Integer diasTrabajados;
    private Double horasTrabajadas;
    private Double horasExtra;
    private boolean estadoCobro;

    public NominaDTO() {}

    public NominaDTO(
            EmpleadoDTO empleado, 
            Double bono, 
            Double salarioBruto, 
            Double isr, 
            Double salarioNeto, 
            LocalDate fechaCorte, 
            Integer diasTrabajados,
            Double horasTrabajadas, 
            Double horasExtra,
            boolean estadoCobro
    ) 
    {
        this.empleado = empleado;
        this.bono = bono;
        this.salarioBruto = salarioBruto;
        this.isr = isr;
        this.salarioNeto = salarioNeto;
        this.fechaCorte = fechaCorte;
        this.diasTrabajados = diasTrabajados;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtra = horasExtra;
        this.estadoCobro = estadoCobro;
    }
    
    public EmpleadoDTO getEmpleado() {return empleado;}

    public void setEmpleado(EmpleadoDTO empleado) {this.empleado = empleado;}

    public Double getBono() {return bono;}

    public void setBono(Double bono) {this.bono = bono;}

    public Double getIsr() {return isr;}

    public void setIsr(Double isr) {this.isr = isr;}

    public Double getSalarioBruto() {return salarioBruto;}

    public void setSalarioBruto(Double salarioBruto) {this.salarioBruto = salarioBruto;}

    public Double getSalarioNeto() {return salarioNeto;}

    public void setSalarioNeto(Double salarioNeto) {this.salarioNeto = salarioNeto;}

    public LocalDate getFechaCorte() {return fechaCorte;}

    public void setFechaCorte(LocalDate fechaCorte) {this.fechaCorte = fechaCorte;}
    
    public Double getHorasTrabajadas() {return horasTrabajadas;}

    public void setHorasTrabajadas(Double horasTrabajadas) {this.horasTrabajadas = horasTrabajadas;}

    public Double getHorasExtra() {return horasExtra;}

    public void setHorasExtra(Double horasExtra) {this.horasExtra = horasExtra;}
    
    public Integer getDiasTrabajados() {return diasTrabajados;}
    
    public void setDiasTrabajados(Integer diasTrabajados) {this.diasTrabajados = diasTrabajados;}

    public boolean getEstadoCobro() {return estadoCobro;}

    public void setEstadoCobro(boolean estadoCobro) {this.estadoCobro = estadoCobro;}
    
    @Override
    public String toString() {
        return String.format("%s, %f, %f, %f, %d/%d/%d, %d, %f, %f", 
                getEmpleado().getNombre(),
                getIsr(),
                getSalarioBruto(),
                getSalarioNeto(),
                getFechaCorte().getDayOfMonth(),
                getFechaCorte().getMonthValue(),
                getFechaCorte().getYear(),
                getDiasTrabajados(),
                getHorasTrabajadas(),
                getHorasExtra()
        );
    }    
}