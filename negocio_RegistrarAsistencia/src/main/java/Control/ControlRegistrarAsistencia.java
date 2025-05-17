/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Excepciones.RegistrarAsistenciaException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IHorarioLaboralBO;
import Interfaces.IRegistroAsistenciaBO;
import bo.HorarioLaboralBO;
import bo.RegistroAsistenciaBO;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlRegistrarAsistencia {
    
    private static IRegistroAsistenciaBO registrarAsistenciaBO = RegistroAsistenciaBO.getInstance();
    private static IHorarioLaboralBO horarioLaboralBO= HorarioLaboralBO.getInstance();
    
    public boolean registrarEntrada(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws RegistrarAsistenciaException{
        if(empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");
        try{
            return registrarAsistenciaBO.registrarEntrada(empleado, fechaAsistencia, horaEntrada);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }
    
    public boolean registrarSalida(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaSalida)throws RegistrarAsistenciaException{
        if(empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");
        try{
            return registrarAsistenciaBO.registrarSalida(empleado, fechaAsistencia, horaSalida);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }

    public boolean validarHorarioLaboral(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws RegistrarAsistenciaException{
        if(empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");
        try{
            return horarioLaboralBO.validarHorarioLaboral(empleado, fechaAsistencia);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }
    
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado,LocalDate fechaAsistencia)throws RegistrarAsistenciaException{
        if(empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");
        try{
        return horarioLaboralBO.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }
    
    public boolean enviarCorreo(){
        return true;
    }
    
}
