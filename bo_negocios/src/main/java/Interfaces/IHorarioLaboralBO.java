/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public interface IHorarioLaboralBO {
    
    public boolean validarHorarioLaboral(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws ObjetosNegocioException;
    
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws ObjetosNegocioException;
}

