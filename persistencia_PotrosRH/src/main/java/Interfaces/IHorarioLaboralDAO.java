/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.Empleado;
import Entidades.HorarioLaboral;
import Exceptions.AccesoDatosException;
import java.time.LocalDate;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public interface IHorarioLaboralDAO {
    public boolean validarHorarioLaboral(Empleado empleado,LocalDate fechaAsistencia)throws AccesoDatosException;
    public HorarioLaboral obtenerDetallesHorarioLaboralDia(Empleado empleado,LocalDate fechaAsistencia)throws AccesoDatosException;
}
