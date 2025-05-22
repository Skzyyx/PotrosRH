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
 * Interfaz que define las operaciones de negocio para la entidad HorarioLaboral.
 * @author Benjamin Soto Coronado (253183)
 */
public interface IHorarioLaboralBO {
    /**
     * Valida si el empleado tiene asignado un horario laboral para una fecha específica.
     * 
     * @param empleado DTO del empleado a validar.
     * @param fechaAsistencia Fecha en la que se desea verificar el horario laboral.
     * @return true si tiene horario laboral asignado en esa fecha, false en caso contrario.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         no tiene horarios laborales, o ocurre un error en la capa de datos.
     */
    public boolean validarHorarioLaboral(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws ObjetosNegocioException;
     /**
     * Obtiene los detalles del horario laboral del empleado para una fecha específica.
     * 
     * @param empleado DTO del empleado del cual se quiere obtener el horario.
     * @param fechaAsistencia Fecha para la que se desea obtener el horario laboral.
     * @return HorarioLaboralDTO con los detalles del horario para la fecha indicada.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         no tiene horarios laborales, o ocurre un error en la capa de datos.
     */
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws ObjetosNegocioException;
}

