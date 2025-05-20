package Entidades;

import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class Despido {
    private ObjectId _id;
    private ObjectId idDespido;
    private String empleadoId;
    private String rfcEmpleado;
    private LocalDate fechaDespido;
    private String motivo;

    public ObjectId getIdDespido() {
        return idDespido;
    }

    public void setIdDespido(ObjectId idDespido) {
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

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }
    
    public Despido() {
    }

    public Despido(ObjectId _id, ObjectId idDespido, String empleadoId, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this._id = _id;
        this.idDespido = idDespido;
        this.empleadoId = empleadoId;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    public Despido(ObjectId _id, String empleadoId, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this._id = _id;
        this.empleadoId = empleadoId;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }
    
    public Despido(ObjectId idDespido, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
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

    public Despido(ObjectId _id, ObjectId idDespido, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this._id = _id;
        this.idDespido = idDespido;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Despido{" + "_id=" + _id + ", idDespido=" + idDespido + ", empleadoId=" + empleadoId + ", rfcEmpleado=" + rfcEmpleado + ", fechaDespido=" + fechaDespido + ", motivo=" + motivo + '}';
    }
}
