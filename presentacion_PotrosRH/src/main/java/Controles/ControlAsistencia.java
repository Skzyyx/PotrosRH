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
 *
 * @author benjy
 */
public class ControlAsistencia {
    private static ControlAsistencia instance;
    private EmpleadoDTO empleadoDTO;
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();
    private final IRegistrarAsistencia registrarAsistencia = RegistrarAsistencia.getInstance();

    public ControlAsistencia() {
    }
    
    
    public static ControlAsistencia getInstance() {
        if (instance == null) {
            instance = new ControlAsistencia();
        }
        return instance;
    }
    
    public EmpleadoDTO buscarEmpleadoPorRFC(EmpleadoDTO empleado) throws PresentacionException {
        try {
            return obtenerEmpleado.obtenerEmpleadoActivo(empleado);
        } catch (ObtenerEmpleadoException e) {
            throw new PresentacionException("Error al buscar empleado: " + e.getMessage());
        }
    }
    
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws PresentacionException{
        try {
            return registrarAsistencia.registrarEntrada(empleado, fechaAsistencia, horaEntrada);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al registrar entrada"+e.getMessage());
        }
    }
    
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws PresentacionException{
        try {
            return registrarAsistencia.registrarSalida(empleado, fechaAsistencia, horaSalida);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al registrar salida"+e.getMessage());
        }
    }
    
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia)throws PresentacionException{
        try {
            return registrarAsistencia.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al obtener los detalles del horario laboral"+e.getMessage());
        }
    } 
    
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws PresentacionException {
        try {
            return registrarAsistencia.validarHorarioLaboral(empleado, fechaAsistencia);
        } catch (RegistrarAsistenciaException e) {
            throw new PresentacionException("Error al validar el horario laboral"+e.getMessage());
        }
    }
}
