/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlRegistrarAsistencia;
import Excepciones.RegistrarAsistenciaException;
import Interfaces.IRegistrarAsistencia;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *Fachada para el subsistema de registrar asistencia que implementa 
 * la interfaz IRegisrtarAsistencia
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistrarAsistencia implements IRegistrarAsistencia{
   /** 
    * Instancia única de la clase
    */
    private static RegistrarAsistencia instance;

    /**  
     * Controlador que gestiona la lógica específica del registro de asistencia 
     */
    private static ControlRegistrarAsistencia control;

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa el controlador de asistencia.
     */
    private RegistrarAsistencia() {
        control = new ControlRegistrarAsistencia();
    }

    /**
     * Obtiene la instancia única de {@code RegistrarAsistencia}.
     *
     * @return Instancia única de {@code IRegistrarAsistencia}.
     */
    public static synchronized IRegistrarAsistencia getInstance() {
        if (instance == null) {
            instance = new RegistrarAsistencia();
        }
        return instance;
    }

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
    @Override
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws RegistrarAsistenciaException {
        return control.registrarEntrada(empleado, fechaAsistencia, horaEntrada) && control.enviarCorreo(empleado, fechaAsistencia, horaEntrada, "Entrada");
    }

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
    @Override
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws RegistrarAsistenciaException {
        return control.registrarSalida(empleado, fechaAsistencia, horaSalida) && control.enviarCorreo(empleado, fechaAsistencia, horaSalida, "Salida");
    }

    /**
     * Valida si un empleado tiene un horario laboral asignado para una fecha específica.
     *
     * @param empleado El empleado a validar.
     * @param fechaAsistencia La fecha a verificar.
     * @return true si tiene un horario asignado para esa fecha.
     * @throws RegistrarAsistenciaException Si ocurre un error en el proceso.
     */
    @Override
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        return control.validarHorarioLaboral(empleado, fechaAsistencia);
    }

    /**
     * Obtiene los detalles del horario laboral de un empleado en una fecha específica.
     *
     * @param empleado El empleado del cual se quiere obtener el horario.
     * @param fechaAsistencia La fecha a consultar.
     * @return Un objeto HorarioLaboralDTO con los detalles del horario.
     * @throws RegistrarAsistenciaException Si ocurre un error en el proceso.
     */
    @Override
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        return control.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
    }
}
