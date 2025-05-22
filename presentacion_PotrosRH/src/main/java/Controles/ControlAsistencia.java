/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Excepciones.RegistrarAsistenciaException;
import Fachada.ObtenerEmpleado;
import Fachada.RegistrarAsistencia;
import Interfaces.IObtenerEmpleado;
import Interfaces.IRegistrarAsistencia;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase control asistencia para presentacion que se comunica con los subsitemas de Registrar Asistencia y Obtener empleado para hacer las operaciones en presentacion.
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlAsistencia {

    /** 
     * Instancia única de la clase
     */
    private static ControlAsistencia instance;

    /** 
     * Componente para obtener información de empleados activos.
     */
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();

    /*
     * Componente para registrar y validar asistencia de empleados. 
     */
    private final IRegistrarAsistencia registrarAsistencia = RegistrarAsistencia.getInstance();

    /**
     * Constructor privado para aplicar el patrón Singleton.
     */
    public ControlAsistencia() {
    }

    /**
     * Retorna la instancia única de ControlAsistencia.
     *
     * @return Instancia única del controlador.
     */
    public static ControlAsistencia getInstance() {
        if (instance == null) {
            instance = new ControlAsistencia();
        }
        return instance;
    }

    /**
     * Busca un empleado activo utilizando su RFC.
     *
     * @param empleado DTO que contiene el RFC del empleado a buscar.
     * @return EmpleadoDTO con los datos completos del empleado activo.
     * @throws PresentacionException Si ocurre un error durante la búsqueda.
     */
    public EmpleadoDTO buscarEmpleadoPorRFC(EmpleadoDTO empleado) throws PresentacionException {
        try {
            return obtenerEmpleado.obtenerEmpleadoActivo(empleado);
        } catch (ObtenerEmpleadoException e) {
            throw new PresentacionException("Error al buscar empleado: " + e.getMessage());
        }
    }

    /**
     * Registra la entrada de un empleado.
     *
     * @param empleado Empleado que registra su entrada.
     * @param fechaAsistencia Fecha del registro.
     * @param horaEntrada Hora exacta de entrada.
     * @return {@code true} si el registro fue exitoso.
     * @throws PresentacionException Si ocurre un error al registrar la entrada.
     */
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws PresentacionException {
        try {
            return registrarAsistencia.registrarEntrada(empleado, fechaAsistencia, horaEntrada);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al registrar entrada: " + e.getMessage());
        }
    }

    /**
     * Registra la salida de un empleado.
     *
     * @param empleado Empleado que registra su salida.
     * @param fechaAsistencia Fecha del registro.
     * @param horaSalida Hora exacta de salida.
     * @return true si el registro fue exitoso.
     * @throws PresentacionException Si ocurre un error al registrar la salida.
     */
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws PresentacionException {
        try {
            return registrarAsistencia.registrarSalida(empleado, fechaAsistencia, horaSalida);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al registrar salida: " + e.getMessage());
        }
    }

    /**
     * Obtiene los detalles del horario laboral de un empleado en una fecha específica.
     *
     * @param empleado Empleado a consultar.
     * @param fechaAsistencia Fecha del día a consultar.
     * @return DTO con los detalles del horario laboral del día.
     * @throws PresentacionException Si ocurre un error al obtener los detalles.
     */
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws PresentacionException {
        try {
            return registrarAsistencia.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al obtener los detalles del horario laboral: " + e.getMessage());
        }
    }

    /**
     * Valida si un empleado tiene asignado un horario laboral en una fecha específica.
     *
     * @param empleado Empleado a validar.
     * @param fechaAsistencia Fecha a verificar.
     * @return true si el empleado tiene horario asignado en esa fecha.
     * @throws PresentacionException Si ocurre un error durante la validación.
     */
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws PresentacionException {
        try {
            return registrarAsistencia.validarHorarioLaboral(empleado, fechaAsistencia);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al validar el horario laboral: " + e.getMessage());
        }
    }
}