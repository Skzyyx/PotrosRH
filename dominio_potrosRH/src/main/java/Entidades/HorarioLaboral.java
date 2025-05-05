/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalTime;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboral {
    private Empleado empleado;
    private short diaSemana;
    private LocalTime horaInicioTurno;
    private LocalTime horaFinTurno;

    public HorarioLaboral() {
    }
    
    
    public HorarioLaboral(Empleado empleado, short diaSemana, LocalTime horaInicioTurno, LocalTime horaFinTurno) {
        this.empleado = empleado;
        this.diaSemana = diaSemana;
        this.horaInicioTurno = horaInicioTurno;
        this.horaFinTurno = horaFinTurno;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public short getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(short diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicioTurno() {
        return horaInicioTurno;
    }

    public void setHoraInicioTurno(LocalTime horaInicioTurno) {
        this.horaInicioTurno = horaInicioTurno;
    }

    public LocalTime getHoraFinTurno() {
        return horaFinTurno;
    }

    public void setHoraFinTurno(LocalTime horaFinTurno) {
        this.horaFinTurno = horaFinTurno;
    }

    @Override
    public String toString() {
        return "HorarioLaboral{" + "empleado=" + empleado + ", diaSemana=" + diaSemana + ", horaInicioTurno=" + horaInicioTurno + ", horaFinTurno=" + horaFinTurno + '}';
    }
    
    
}
