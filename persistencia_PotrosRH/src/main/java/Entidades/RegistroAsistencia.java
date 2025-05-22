package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import org.bson.types.ObjectId;

/**
 * Clase que representa un registro de asistencia de un empleado.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistroAsistencia {

    // Atrbutos de un registro de asistencia.
    private ObjectId id;
    private LocalDate fechaAsistencia;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private ObjectId empleadoId;

    /**
     * Constructor por defecto.
     */
    public RegistroAsistencia() {}

    /**
     * Constructor que recibe los atributos.
     * 
     * @param empleadoId Empleado asociado al registro de la asistencia.
     * @param fechaAsistencia Fecha del registro de la asistencia.
     * @param horaEntrada Hora de entrada del registro de la asistencia.
     * @param horaSalida Hora de salida del registro de la asistencia.
     */
    public RegistroAsistencia(ObjectId empleadoId, LocalDate fechaAsistencia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.empleadoId = empleadoId;
        this.fechaAsistencia = fechaAsistencia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    /**
     * Retorna la fecha del registro de la asistencia.
     * 
     * @return Fecha del registro de la asistencia.
     */
    public LocalDate getFechaAsistencia() { return fechaAsistencia; }

    /**
     * Establece la fecha del registro de la asistencia.
     * 
     * @param fechaAsistencia Nueva fecha del registro de la asistencia.
     */
    public void setFechaAsistencia(LocalDate fechaAsistencia) { this.fechaAsistencia = fechaAsistencia; }

    /**
     * Retorna la hora de entrada del registro de la asistencia.
     * 
     * @return Hora de entrada del registro de la asistencia.
     */
    public LocalTime getHoraEntrada() { return horaEntrada; }

    /**
     * Establece la hora de entrada del registro de la asistencia.
     * 
     * @param horaEntrada Nueva hora de entrada del registro de la asistencia.
     */
    public void setHoraEntrada(LocalTime horaEntrada) { this.horaEntrada = horaEntrada; }

    /**
     * Retorna la hora de salida del registro de la asistencia.
     * 
     * @return Hora de salida del registro de la asistencia.
     */
    public LocalTime getHoraSalida() { return horaSalida; }

    /**
     * Establece la hora de salida del registro de la asistencia.
     * 
     * @param horaSalida Nueva hora de salida del registro de la asistencia.
     */
    public void setHoraSalida(LocalTime horaSalida) { this.horaSalida = horaSalida; }

    /**
     * Retorna el identificador único del registro de asistencia.
     * 
     * @return Identificador del registro.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del registro de asistencia.
     * 
     * @param id Identificador a asignar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Retorna el identificador del empleado relacionado con este registro.
     * 
     * @return Identificador del empleado.
     */
    public ObjectId getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el identificador del empleado relacionado con este registro.
     * 
     * @param empleadoId Identificador del empleado.
     */
    public void setEmpleadoId(ObjectId empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Retorna una cadena con la información relevante del registro de la asistencia.
     * 
     * @return Cadena con los detalles del registro.
     */
    @Override
    public String toString() {
        return "RegistroAsistencia{" + 
                "id=" + id + 
                ", fechaAsistencia=" + fechaAsistencia + 
                ", horaEntrada=" + horaEntrada + 
                ", horaSalida=" + horaSalida + 
                ", empleadoId=" + empleadoId + 
                '}';
    }     
}