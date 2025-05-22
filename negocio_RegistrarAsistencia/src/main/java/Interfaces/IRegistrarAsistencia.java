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
   /**
     * Registra la entrada de un empleado en una fecha y hora específica, 
     * y envía un correo de confirmación.
     *
     * @param empleado El empleado que realiza la entrada.
     * @param fechaAsistencia La fecha en la que se registra la entrada.
     * @param horaEntrada La hora exacta de la entrada.
     * @return true si el registro y el envío de correo fueron exitosos.
     * @throws RegistrarAsistenciaException Si ocurre un error en el proceso.
     */
    public boolean registrarEntrada(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws RegistrarAsistenciaException;
    /**
     * Registra la salida de un empleado en una fecha y hora específica,
     * y envía un correo de confirmación.
     *
     * @param empleado El empleado que realiza la salida.
     * @param fechaAsistencia La fecha en la que se registra la salida.
     * @param horaSalida La hora exacta de la salida.
     * @return true si el registro y el envío de correo fueron exitosos.
     * @throws RegistrarAsistenciaException Si ocurre un error en el proceso.
     */
    public boolean registrarSalida(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaSalida)throws RegistrarAsistenciaException;
    /**
     * Valida si un empleado tiene un horario laboral asignado para una fecha específica.
     *
     * @param empleado El empleado a validar.
     * @param fechaAsistencia La fecha a verificar.
     * @return true si tiene un horario asignado para esa fecha.
     * @throws RegistrarAsistenciaException Si ocurre un error en el proceso.
     */
    public boolean validarHorarioLaboral(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws RegistrarAsistenciaException;
    /**
     * Obtiene los detalles del horario laboral de un empleado en una fecha específica.
     *
     * @param empleado El empleado del cual se quiere obtener el horario.
     * @param fechaAsistencia La fecha a consultar.
     * @return Un objeto HorarioLaboralDTO con los detalles del horario.
     * @throws RegistrarAsistenciaException Si ocurre un error en el proceso.
     */
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws RegistrarAsistenciaException;
}
