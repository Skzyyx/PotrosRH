/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Empleado;
import Entidades.HorarioLaboral;
import Enums.DiaSemana;
import Exceptions.AccesoDatosException;
import Interfaces.IHorarioLaboralDAO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralDAO implements IHorarioLaboralDAO{
    
    @Override
    public boolean validarHorarioLaboral(Empleado empleado,LocalDate fechaAsistencia)throws AccesoDatosException{
        return true;
    }
    @Override
     public HorarioLaboral obtenerDetallesHorarioLaboralDia(Empleado empleado,LocalDate fechaAsistencia)throws AccesoDatosException{
        DiaSemana diaSemana = DiaSemana.fromDayOfWeek(LocalDate.now().getDayOfWeek());
        LocalTime horaInicio = LocalTime.of(9, 0);
        LocalTime horaFin = LocalTime.of(18, 0);

        return new HorarioLaboral(diaSemana, horaInicio, horaFin);
    }
}
