package Entidades;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */
import org.bson.types.ObjectId;
import java.time.LocalDate;
import java.util.List;

/**
 * Representa el expediente laboral de un empleado
 * Contiene datos personales, laborales, contrato y nómina, que son necesarios 
 * para construir el expediente laboral de un empleado
 */
public class Expediente {

    /**
     * Identificador único del expediente para la base de datos
     */
    private ObjectId id;

    /**
     * Datos personales del empleado
     */
    private Empleado empleado;

    /**
     * Datos del contrato
     */
    private Contrato contrato;

    /**
     * Historial de nóminas del empleado
     */
    private List<Nomina> historialNominas;

    /**
     * Fecha de creación del expediente
     */
    private LocalDate fechaCreacion;

    /**
     * Constructor por defecto
     */
    public Expediente() {
    }

    /**
     * Constructor que recibe todos los atributos del expediente
     *
     * @param id Identificador único del expediente
     * @param empleado Datos personales del empleado
     * @param contrato Datos del contrato laboral
     * @param historialNominas Historial de nóminas del empleado
     * @param fechaCreacion Fecha de creación del expediente
     */
    public Expediente(ObjectId id, Empleado empleado, Contrato contrato, List<Nomina> historialNominas, LocalDate fechaCreacion) {
        this.id = id;
        this.empleado = empleado;
        this.contrato = contrato;
        this.historialNominas = historialNominas;
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Constructor sin el identificador único, pero si con los demás atributos
     *
     * @param empleado Datos personales del empleado
     * @param contrato Datos del contrato laboral
     * @param historialNominas Historial de nóminas del empleado
     * @param fechaCreacion Fecha de creación del expediente
     */
    public Expediente(Empleado empleado, Contrato contrato, List<Nomina> historialNominas, LocalDate fechaCreacion) {
        this.empleado = empleado;
        this.contrato = contrato;
        this.historialNominas = historialNominas;
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Obtiene el identificador único del expediente
     *
     * @return Retorna el identificador único del expediente
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Setea/establece el identificador único del expediente
     *
     * @param id identificador único del expediente
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene los datos personales del empleado
     *
     * @return Datos personales del empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece los datos personales del empleado
     *
     * @param empleado datos personales del empleado
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene los datos del contrato laboral
     *
     * @return Datos del contrato laboral
     */
    public Contrato getContrato() {
        return contrato;
    }

    /**
     * Establece los datos del contrato laboral
     *
     * @param contrato datos del contrato laboral
     */
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    /**
     * Obtiene el historial de nóminas del empleado
     *
     * @return Lista con el historial de nóminas
     */
    public List<Nomina> getHistorialNominas() {
        return historialNominas;
    }

    /**
     * Establece el historial de nóminas del empleado
     *
     * @param historialNominas lista con el historial de nóminas
     */
    public void setHistorialNominas(List<Nomina> historialNominas) {
        this.historialNominas = historialNominas;
    }

    /**
     * Obtiene la fecha de creación del expediente
     *
     * @return Fecha de creación del expediente
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del expediente
     *
     * @param fechaCreacion fecha de creación del expediente
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Representación en cadena del expediente laboral
     *
     * @return Cadena con la información relevante del expediente
     */
    @Override
    public String toString() {
        return "ExpedienteLaboral{" +
                "id=" + id +
                ", empleado=" + empleado +
                ", contrato=" + contrato +
                ", historialNominas=" + historialNominas +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
