package dto;

import java.time.LocalTime;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralDTO {
    
    private EmpleadoDTO empleado;
    private Short diaSemana;
    private LocalTime horaInicioTurno;
    private LocalTime horaFinTurno;

    public HorarioLaboralDTO() {}
    
    public HorarioLaboralDTO(EmpleadoDTO empleado, short diaSemana, LocalTime horaInicioTurno, LocalTime horaFinTurno) {
        this.empleado = empleado;
        this.diaSemana = diaSemana;
        this.horaInicioTurno = horaInicioTurno;
        this.horaFinTurno = horaFinTurno;
    }

    public EmpleadoDTO getEmpleado() {return empleado;}

    public void setEmpleado(EmpleadoDTO empleado) {this.empleado = empleado;}

    public Short getDiaSemana() {return diaSemana;}

    public void setDiaSemana(Short diaSemana) {this.diaSemana = diaSemana;}

    public LocalTime getHoraInicioTurno() {return horaInicioTurno;}

    public void setHoraInicioTurno(LocalTime horaInicioTurno) {this.horaInicioTurno = horaInicioTurno;}

    public LocalTime getHoraFinTurno() {return horaFinTurno;}

    public void setHoraFinTurno(LocalTime horaFinTurno) {this.horaFinTurno = horaFinTurno;}
    
    @Override
    public String toString() {
        return String.format(
                "%s, %d, %d/%d/%d, %d/%d/%d", 
                getEmpleado().getNombre(),
                getDiaSemana(),
                getHoraInicioTurno().getHour(),
                getHoraInicioTurno().getMinute(),
                getHoraInicioTurno().getSecond(),
                getHoraFinTurno().getHour(),
                getHoraFinTurno().getMinute(),
                getHoraFinTurno().getSecond()
        );
    }
}