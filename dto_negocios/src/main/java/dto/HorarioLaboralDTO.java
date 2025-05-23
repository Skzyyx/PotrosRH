package dto;

import java.time.LocalTime;

/**
 * Objeto de transferencia para Horarios Laborales.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralDTO {
    // Atributos de un horario laboral.
    private String diaSemana;
    private LocalTime horaInicioTurno;
    private LocalTime horaFinTurno;
    /**
     * Constructor por defecto.
     */
    public HorarioLaboralDTO() {}
    /**
     * Constructor que recibe los atributos.
     * @param diaSemana Día de la semana del horario laboral.
     * @param horaInicioTurno Hora de inicio del turno del horario laboral.
     * @param horaFinTurno Hora de fin de turno del horario laboral.
     */
    public HorarioLaboralDTO(String diaSemana, LocalTime horaInicioTurno, LocalTime horaFinTurno) {
        this.diaSemana = diaSemana;
        this.horaInicioTurno = horaInicioTurno;
        this.horaFinTurno = horaFinTurno;
    }
    /**
     * Retorna el día de la semana del horario laboral.
     * @return Día de la semana del horario laboral.
     */
    public String getDiaSemana() {return diaSemana;}
    /**
     * Establece el día de la semana del horario laboral.
     * @param diaSemana Nuevo día de la semana del horario laboral.
     */
    public void setDiaSemana(String diaSemana) {this.diaSemana = diaSemana;}
    /**
     * Retorna la hora de inicio del turno del horario laboral.
     * @return Hora de inicio del turno del horario laboral.
     */
    public LocalTime getHoraInicioTurno() {return horaInicioTurno;}
    /**
     * Establece la hora de inicio del turno del horario laboral.
     * @param horaInicioTurno Nueva hora de inicio del turno del horario laboral.
     */
    public void setHoraInicioTurno(LocalTime horaInicioTurno) {this.horaInicioTurno = horaInicioTurno;}
    /**
     * Retorna la hora de fin del turno del horario laboral.
     * @return Hora de fin del turno del horario laboral.
     */
    public LocalTime getHoraFinTurno() {return horaFinTurno;}
    /**
     * Establece la hora de fin del turno del horario laboral.
     * @param horaFinTurno Nueva hora de fin del turno del horario laboral.
     */
    public void setHoraFinTurno(LocalTime horaFinTurno) {this.horaFinTurno = horaFinTurno;}

    /**
     * Retorna una cadena con la información relevante del horario laboral.
     * @return Cadena con información relevante del horario laboral.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HorarioLaboralDTO{");
        sb.append("diaSemana=").append(diaSemana);
        sb.append(", horaInicioTurno=").append(horaInicioTurno);
        sb.append(", horaFinTurno=").append(horaFinTurno);
        sb.append('}');
        return sb.toString();
    }
    
    
}