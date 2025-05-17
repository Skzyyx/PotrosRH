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
    public static RegistrarAsistencia instance;

    public RegistrarAsistencia() {
        
    }
    
    public static synchronized IRegistrarAsistencia getInstance() {
        if (instance == null) {
            instance = new RegistrarAsistencia();
        }
        return instance;
    }

    @Override
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws RegistrarAsistenciaException {
        return new ControlRegistrarAsistencia().registrarEntrada(empleado, fechaAsistencia, horaEntrada);
    }

    @Override
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws RegistrarAsistenciaException {
        return new ControlRegistrarAsistencia().registrarSalida(empleado, fechaAsistencia, horaSalida);
    }

    @Override
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        return new ControlRegistrarAsistencia().validarHorarioLaboral(empleado, fechaAsistencia);
    }

    @Override
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        return new ControlRegistrarAsistencia().obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
    }
}
