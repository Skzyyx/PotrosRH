/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public interface IRegistroAsistenciaBO {
    
    public boolean registrarEntrada(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws ObjetosNegocioException;
    
    public boolean registrarSalida(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaSalida)throws ObjetosNegocioException;
    
}
