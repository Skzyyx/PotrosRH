/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Excepciones.RegistrarAsistenciaException;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public interface IRegistrarAsistencia {
   
    public boolean registrarEntrada(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws RegistrarAsistenciaException;
    
    public boolean registrarSalida(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaSalida)throws RegistrarAsistenciaException;

    public boolean validarHorarioLaboral(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws RegistrarAsistenciaException;
    
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws RegistrarAsistenciaException;
}
