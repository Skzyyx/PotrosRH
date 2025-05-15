package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private Empleado empleado;
    private LocalDate fechaAsistencia;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    /**
     * Constructor por defecto.
     */
    public RegistroAsistencia() {}
    /**
     * Constructor que recibe los atributos.
     * @param empleado Empleado asociado al registro de la asistencia.
     * @param fechaAsistencia Fecha del registro de la asistencia.
     * @param horaEntrada Hora de entrada del registro de la asistencia.
     * @param horaSalida Hora de salida del registro de la asistencia.
     */
    public RegistroAsistencia(Empleado empleado, LocalDate fechaAsistencia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.empleado = empleado;
        this.fechaAsistencia = fechaAsistencia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }
    /**
     * Retorna el empleado asociado al registro de la asistencia.
     * @return Empleado asociado al registro de la asistencia.
     */
    public Empleado getEmpleado() {return empleado;}
    /**
     * Establece el empleado asociado al registro de la asistencia.
     * @param empleado Nuevo empleado asociado al registro de la asistencia.
     */
    public void setEmpleado(Empleado empleado) {this.empleado = empleado;}
    /**
     * Retorna la fecha del registro de la asistencia.
     * @return Fecha del registro de la asistencia.
     */
    public LocalDate getFechaAsistencia() {return fechaAsistencia;}
    /**
     * Establece la fecha del registro de la asistencia.
     * @param fechaAsistencia Nueva fecha del registro de la asistencia.
     */
    public void setFechaAsistencia(LocalDate fechaAsistencia) {this.fechaAsistencia = fechaAsistencia;}
    /**
     * Retorna la hora de entrada del registro de la asistencia.
     * @return Hora de entrada del registro de la asistencia.
     */
    public LocalTime getHoraEntrada() {return horaEntrada;}
    /**
     * Establece la hora de entrada del registro de la asistencia.
     * @param horaEntrada Nueva hora de entrada del registro de la asistencia.
     */
    public void setHoraEntrada(LocalTime horaEntrada) {this.horaEntrada = horaEntrada;}
    /**
     * Retorna la hora de salida del registro de la asistencia.
     * @return Hora de salida del registro de la asistencia.
     */
    public LocalTime getHoraSalida() {return horaSalida;}
    /**
     * Establece la hora de salida del registro de la asistencia.
     * @param horaSalida Nueva hora de salida del registro de la asistencia.
     */
    public void setHoraSalida(LocalTime horaSalida) {this.horaSalida = horaSalida;}
    /**
     * Retorna una cadena con la información relevante del registro de la asistencia.
     * @return Cadena con la información relevante del registro de la asistencia.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %d/%d/%d, %d:%d:%d, %d:%d:%d", 
                getEmpleado().getNombre(),
                getFechaAsistencia().getDayOfMonth(),
                getFechaAsistencia().getMonthValue(),
                getFechaAsistencia().getYear(),
                getHoraEntrada().getHour(),
                getHoraEntrada().getMinute(),
                getHoraEntrada().getSecond(),
                getHoraSalida().getHour(),
                getHoraSalida().getMinute(),
                getHoraSalida().getSecond()
        );
    }   
}