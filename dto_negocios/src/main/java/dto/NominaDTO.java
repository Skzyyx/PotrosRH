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
    // Atributos de una nómina.
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
    /**
     * Constructor por defecto.
     */
    public NominaDTO() {}
    /**
     * Constructor que recibe los atributos.
     * @param empleado Empleado asociado a la nómina.
     * @param bono Bono de la nómina.
     * @param isr ISR aplicado de la nómina.
     * @param salarioBruto Salario bruto de la nómina.
     * @param salarioNeto Salario neto de la nómina.
     * @param fechaCorte Fecha de corte de la nómina.
     * @param diasTrabajados Días trabajados de la nómina.
     * @param horasTrabajadas Horas trabajadas de la nómina.
     * @param horasExtra Horas extra de la nómina.
     * @param estadoCobro Estado de cobro de la nómina.
     */
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
    /**
     * Retorna el empleado asociado a la nómina.
     * @return Empleado asociado a la nómina.
     */
    public EmpleadoDTO getEmpleado() {return empleado;}
    /**
     * Establece el empleado asociado a la nómina.
     * @param empleado Nuevo empleado asociado a la nómina.
     */
    public void setEmpleado(EmpleadoDTO empleado) {this.empleado = empleado;}
    /**
     * Retorna el bono de la nómina.
     * @return Bono de la nómina.
     */
    public Double getBono() {return bono;}
    /**
     * Establece el bono de la nómina.
     * @param bono Nuevo bono de la nómina.
     */
    public void setBono(Double bono) {this.bono = bono;}
    /**
     * Retorna el ISR aplicado de la nómina.
     * @return ISR aplicado de la nómina.
     */
    public Double getIsr() {return isr;}
    /**
     * Establece el ISR aplicado de la nómina.
     * @param isr Nuevo ISR aplicado de la nómina.
     */
    public void setIsr(Double isr) {this.isr = isr;}
    /**
     * Retorna el salario bruto de la nómina.
     * @return Salario bruto de la nómina.
     */
    public Double getSalarioBruto() {return salarioBruto;}
    /**
     * Establece el salario bruto de la nómina.
     * @param salarioBruto Nuevo salario bruto de la nómina.
     */
    public void setSalarioBruto(Double salarioBruto) {this.salarioBruto = salarioBruto;}
    /**
     * Retorna el salario neto de la nómina.
     * @return Salario neto de la nómina.
     */
    public Double getSalarioNeto() {return salarioNeto;}
    /**
     * Establece el salario neto de la nómina.
     * @param salarioNeto Nuevo salario neto de la nómina.
     */
    public void setSalarioNeto(Double salarioNeto) {this.salarioNeto = salarioNeto;}
    /**
     * Retorna la fecha de corte de la nómina.
     * @return Fecha de corte de la nómina.
     */
    public LocalDate getFechaCorte() {return fechaCorte;}
    /**
     * Establece la fecha de corte de la nómina.
     * @param fechaCorte Nueva fecha de corte de la nómina.
     */
    public void setFechaCorte(LocalDate fechaCorte) {this.fechaCorte = fechaCorte;}
    /**
     * Retorna la cantidad de horas trabajadas de la nómina.
     * @return Cantidad de horas trabajadas de la nómina.
     */
    public Double getHorasTrabajadas() {return horasTrabajadas;}
    /**
     * Establece la cantidad de horas trabajadas de la nómina.
     * @param horasTrabajadas Nueva cantidad de horas trabajadas de la nómina.
     */
    public void setHorasTrabajadas(Double horasTrabajadas) {this.horasTrabajadas = horasTrabajadas;}
    /**
     * Retorna la cantidad de horas extra de la nómina.
     * @return Cantidad de horas extra de la nómina.
     */
    public Double getHorasExtra() {return horasExtra;}
    /**
     * Establece la cantidad de horas extra de la nómina.
     * @param horasExtra Nueva cantidad de horas extra de la nómina.
     */
    public void setHorasExtra(Double horasExtra) {this.horasExtra = horasExtra;}
    /**
     * Retorna la cantidad de días trabajados de la nómina.
     * @return Cantidad de días trabajados de la nómina.
     */
    public Integer getDiasTrabajados() {return diasTrabajados;}
    /**
     * Establece la cantidad de días trabajados de la nómina.
     * @param diasTrabajados Nueva cantidad de días trabajados de la nómina.
     */
    public void setDiasTrabajados(Integer diasTrabajados) {this.diasTrabajados = diasTrabajados;}
    /**
     * Retorna el estado de cobro de la nómina.
     * @return Estado de cobro de la nómina.
     */
    public boolean getEstadoCobro() {return estadoCobro;}
    /**
     * Establece el estado de cobro de la nómina.
     * @param estadoCobro Nuevo estado de cobro de la nómina.
     */
    public void setEstadoCobro(boolean estadoCobro) {this.estadoCobro = estadoCobro;}
    /**
     * Retorna una cadena con la información relevante de la nómina.
     * @return Cadena con la información relevante de la nómina.
     */
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