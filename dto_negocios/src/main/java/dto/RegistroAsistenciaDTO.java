package dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistroAsistenciaDTO {
 
    private EmpleadoDTO empleado;
    private LocalDate fechaAsistencia;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    public RegistroAsistenciaDTO() {}

    public RegistroAsistenciaDTO(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.empleado = empleado;
        this.fechaAsistencia = fechaAsistencia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public EmpleadoDTO getEmpleado() {return empleado;}

    public void setEmpleado(EmpleadoDTO empleado) {this.empleado = empleado;}

    public LocalDate getFechaAsistencia() {return fechaAsistencia;}

    public void setFechaAsistencia(LocalDate fechaAsistencia) {this.fechaAsistencia = fechaAsistencia;}

    public LocalTime getHoraEntrada() {return horaEntrada;}

    public void setHoraEntrada(LocalTime horaEntrada) {this.horaEntrada = horaEntrada;}

    public LocalTime getHoraSalida() {return horaSalida;}

    public void setHoraSalida(LocalTime horaSalida) {this.horaSalida = horaSalida;}

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