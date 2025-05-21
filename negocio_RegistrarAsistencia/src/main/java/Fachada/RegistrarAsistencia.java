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
 *
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistrarAsistencia implements IRegistrarAsistencia{
    private static RegistrarAsistencia instance;
    private static ControlRegistrarAsistencia control;
    
    private RegistrarAsistencia() {
        control = new ControlRegistrarAsistencia();
    }
    
    public static synchronized IRegistrarAsistencia getInstance() {
        if (instance == null) {
            instance = new RegistrarAsistencia();
        }
        return instance;
    }

    @Override
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws RegistrarAsistenciaException {
        return control.registrarEntrada(empleado, fechaAsistencia, horaEntrada) && control.enviarCorreo(empleado, fechaAsistencia, horaEntrada, "Entrada");
    }

    @Override
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws RegistrarAsistenciaException {
        return control.registrarSalida(empleado, fechaAsistencia, horaSalida) && control.enviarCorreo(empleado, fechaAsistencia, horaSalida, "Salida");
    }

    @Override
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        return control.validarHorarioLaboral(empleado, fechaAsistencia);
    }

    @Override
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        return control.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
    }
}
