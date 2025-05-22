package dto;

import java.time.LocalDate;

/**
 *
 * @author Jesus Ernesto López Ibarra (252663)
 */
public class DespidoDTO {
    
    //ID general del registro
    private String id;

    // ID numérico del despido
    private int idDespido;

    // ID del empleado despedido
    private String empleadoid;

    // RFC del empleado despedido
    private String rfcEmpleado;

    // Fecha en la que se efectuó el despido
    private LocalDate fechaDespido;

    // Motivo por el cual se realizó el despido
    private String motivo;

    /**
     * Obtiene el ID del despido
     * 
     * @return ID del despido como entero
     */
    public int getIdDespido() {
        return idDespido;
    }

    /**
     * Establece el ID del despido
     * 
     * @param idDespido ID del despido como entero
     */
    public void setIdDespido(int idDespido) {
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
     * Obtiene la fecha en que se realizó el despido
     * 
     * @return fecha del despido
     */
    public LocalDate getFechaDespido() {
        return fechaDespido;
    }

    /**
     * Establece la fecha en que se realizó el despido
     * 
     * @param fechaDespido fecha del despido
     */
    public void setFechaDespido(LocalDate fechaDespido) {
        this.fechaDespido = fechaDespido;
    }

    /**
     * Obtiene el motivo del despido
     * 
     * @return motivo del despido
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Establece el motivo del despido
     * 
     * @param motivo motivo del despido
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene el ID del empleado despedido
     * 
     * @return ID del empleado
     */
    public String getEmpleadoid() {
        return empleadoid;
    }

    /**
     * Establece el ID del empleado despedido
     * 
     * @param empleadoid ID del empleado
     */
    public void setEmpleadoid(String empleadoid) {
        this.empleadoid = empleadoid;
    }

    /**
     * Obtiene el ID general del registro.
     * 
     * @return ID como cadena
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID general del registro
     * 
     * @param id ID como cadena
     */
    public void setId(String id) {
        this.id = id;
    }

    // Constructor vacío por defecto
    public DespidoDTO() {}

    /**
     * Constructor con ID numérico, RFC, fecha y motivo
     */
    public DespidoDTO(int idDespido, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.idDespido = idDespido;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor con RFC, fecha y motivo
     */
    public DespidoDTO(String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor con ID numérico, fecha y motivo
     */
    public DespidoDTO(int idDespido, LocalDate fechaDespido, String motivo) {
        this.idDespido = idDespido;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor con todos los campos excepto ID general
     */
    public DespidoDTO(int idDespido, String empleadoid, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.idDespido = idDespido;
        this.empleadoid = empleadoid;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor sin ID general ni numérico
     */
    public DespidoDTO(String empleadoid, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.empleadoid = empleadoid;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor con todos los campos
     */
    public DespidoDTO(String id, int idDespido, String empleadoid, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.id = id;
        this.idDespido = idDespido;
        this.empleadoid = empleadoid;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Constructor con ID general, sin ID numérico
     */
    public DespidoDTO(String id, String empleadoid, String rfcEmpleado, LocalDate fechaDespido, String motivo) {
        this.id = id;
        this.empleadoid = empleadoid;
        this.rfcEmpleado = rfcEmpleado;
        this.fechaDespido = fechaDespido;
        this.motivo = motivo;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto DespidoDTO
     * 
     * @return representación del despido en forma de cadena
     */
    @Override
    public String toString() {
        return "DespidoDTO{" +
                "idDespido=" + idDespido +
                ", rfcEmpleado='" + rfcEmpleado + '\'' +
                ", fechaDespido=" + fechaDespido +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}