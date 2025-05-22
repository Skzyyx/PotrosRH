package Entidades;

import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class Despido {

    // Identificador único del documento en MongoDB
    private ObjectId _id;

    // Identificador lógico del despido 
    private ObjectId idDespido;

    // Identificador del empleado asociado al despido
    private String empleadoId;

    // RFC del empleado despedido
    private String rfcEmpleado;

    // Fecha en que se realizó el despido
    private LocalDate fechaDespido;

    // Motivo del despido
    private String motivo;

    /**
     * Obtiene el identificador lógico del despido
     * 
     * @return El ID del despido
     */
    public ObjectId getIdDespido() {
        return idDespido;
    }

    /**
     * Establece el identificador lógico del despido
     * 
     * @param idDespido El nuevo ID del despido
     */
    public void setIdDespido(ObjectId idDespido) {
        this.idDespido = idDespido;
    }

    /**
     * Obtiene el RFC del empleado despedido
     * 
     * @return RFC del empleado
     */
    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    /**
     * Establece el RFC del empleado despedido
     * 
     * @param rfcEmpleado RFC del empleado
     */
    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }

    /**
     * Obtiene la fecha del despido
     * 
     * @return Fecha en que ocurrió el despido
     */
    public LocalDate getFechaDespido() {
        return fechaDespido;
    }

    /**
     * Establece la fecha del despido
     * 
     * @param fechaDespido Fecha del despido
     */
    public void setFechaDespido(LocalDate fechaDespido) {
        this.fechaDespido = fechaDespido;
    }

    /**
     * Obtiene el motivo del despido
     * 
     * @return Motivo del despido
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo del despido
     * 
     * @param motivo Motivo del despido
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene el identificador único del documento en MongoDB
     * 
     * @return ID del documento
     */
    public ObjectId getId() {
        return _id;
    }

    /**
     * Establece el identificador único del documento en MongoDB
     * 
     * @param _id ID del documento
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el identificador del empleado asociado al despido
     * 
     * @return ID del empleado
     */
    public String getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el identificador del empleado asociado al despido
     * 
     * @param empleadoId ID del empleado
     */
    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Constructor vacío
     */
    public Despido() {
    }

    /**
     * Constructor completo con todos los campos, incluyendo IDs internos
     * 
     * @param _id ID del documento en MongoDB.
     * @param idDespido ID lógico del despido.
     * @param empleadoId ID del empleado.
     * @param rfcEmpleado RFC del empleado.
     * @param fechaDespido Fecha del despido.
     * @param motivo Motivo del despido.
     */
    public Despido(ObjectId _id, ObjectId idDespido, String empleadoId, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this._id = _id;
        this.idDespido = idDespido;
        this.empleadoId = empleadoId;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor sin ID lógico de despido
     * 
     * @param _id ID del documento
     * @param empleadoId ID del empleado
     * @param rfcEmpleado RFC del empleado
     * @param fechaDespido Fecha del despido
     * @param motivo Motivo del despido
     */
    public Despido(ObjectId _id, String empleadoId, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this._id = _id;
        this.empleadoId = empleadoId;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor sin ID de documento (_id)
     * 
     * @param idDespido ID lógico del despido
     * @param rfcEmpleado RFC del empleado
     * @param fechaDespido Fecha del despido
     * @param motivo Motivo del despido
     */
    public Despido(ObjectId idDespido, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.idDespido = idDespido;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor sin ningún identificador, útil para crear nuevos registros
     * 
     * @param rfcEmpleado RFC del empleado
     * @param fechaDespido Fecha del despido
     * @param motivo Motivo del despido
     */
    public Despido(String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor que incluye IDs de documento y despido
     * 
     * @param _id ID del documento
     * @param idDespido ID lógico del despido
     * @param rfcEmpleado RFC del empleado
     * @param fechaDespido Fecha del despido
     * @param motivo Motivo del despido
     */
    public Despido(ObjectId _id, ObjectId idDespido, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this._id = _id;
        this.idDespido = idDespido;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Devuelve una representación en texto del objeto Despido
     * 
     * @return Cadena con todos los campos del despido
     */
    @Override
    public String toString() {
        return "Despido{" +
               "_id=" + _id +
               ", idDespido=" + idDespido +
               ", empleadoId=" + empleadoId +
               ", rfcEmpleado=" + rfcEmpleado +
               ", fechaDespido=" + fechaDespido +
               ", motivo=" + motivo +
               '}';
    }
}