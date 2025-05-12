package DTOs;

import java.time.LocalDate;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoDTO {
    private int idDespido;
    private String rfcEmpleado;
    private String motivo;
    private LocalDate fechaDespido;

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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaDespido() {
        return fechaDespido;
    }

    public void setFechaDespido(LocalDate fechaDespido) {
        this.fechaDespido = fechaDespido;
    }

    public DespidoDTO() {
    }

    public DespidoDTO(String rfcEmpleado, String motivo, LocalDate fechaDespido) {
        this.rfcEmpleado = rfcEmpleado;
        this.motivo = motivo;
        this.fechaDespido = fechaDespido;
    }

    public DespidoDTO(int idDespido, String motivo, LocalDate fechaDespido) {
        this.idDespido = idDespido;
        this.motivo = motivo;
        this.fechaDespido = fechaDespido;
    }

    public DespidoDTO(int idDespido, String rfcEmpleado, String motivo, LocalDate fechaDespido) {
        this.idDespido = idDespido;
        this.rfcEmpleado = rfcEmpleado;
        this.motivo = motivo;
        this.fechaDespido = fechaDespido;
    }

    public DespidoDTO(String motivo, LocalDate fechaDespido) {
        this.motivo = motivo;
        this.fechaDespido = fechaDespido;
    }

    @Override
    public String toString() {
        return "DespidoDTO{" + "idDespido=" + idDespido + ", rfcEmpleado=" + rfcEmpleado + ", motivo=" + motivo + ", fechaDespido=" + fechaDespido + '}';
    }
}