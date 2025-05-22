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
    /**
     * Valida si un empleado tiene horario laboral para un día específico.
     * 
     * @param empleado El empleado cuyo horario se va a validar
     * @param fechaAsistencia La fecha para la cual se verifica el horario
     * @return true si el empleado tiene horario para ese día, false en caso contrario
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos
     */
    public boolean validarHorarioLaboral(Empleado empleado,LocalDate fechaAsistencia)throws AccesoDatosException;
    /**
     * Obtiene los detalles del horario laboral de un empleado para un día específico.
     * 
     * @param empleado El empleado cuyo horario se va a consultar
     * @param fechaAsistencia La fecha para la cual se solicita el horario
     * @return El objeto HorarioLaboral correspondiente al día solicitado, o null si no existe horario para ese día
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos
     */
    public HorarioLaboral obtenerDetallesHorarioLaboralDia(Empleado empleado,LocalDate fechaAsistencia)throws AccesoDatosException;
}
