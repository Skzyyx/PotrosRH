package Entidades;

import java.time.LocalDate;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class Despido {
    
    private int idDespido;
    private String rfcEmpleado;
    private LocalDate fechaDespido;
    private String motivo;

    public int getIdDespido() {
        return idDespido;
    }

    public void setIdDespido(int idDespido) {
        this.idDespido = idDespido;
    }

    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }

    public LocalDate getFechaDespido() {
        return fechaDespido;
    }

    public void setFechaDespido(LocalDate fechaDespido) {
        this.fechaDespido = fechaDespido;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Despido() {
    }

    public Despido(int idDespido, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.idDespido = idDespido;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    public Despido(String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Despido{" + "idDespido=" + idDespido + ", rfcEmpleado=" + rfcEmpleado + ", fechaDespido=" + fechaDespido + ", motivo=" + motivo + '}';
    }
}
