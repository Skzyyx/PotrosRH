/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Excepciones.CorreoException;
import Excepciones.RegistrarAsistenciaException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IHorarioLaboralBO;
import Interfaces.IRegistroAsistenciaBO;
import SistemaCorreo.SistemaCorreo;
import bo.HorarioLaboralBO;
import bo.RegistroAsistenciaBO;
import dto.CorreoDTO;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase de control para registrar asistencias de empleados.
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlRegistrarAsistencia {
    
    private static IRegistroAsistenciaBO registrarAsistenciaBO = RegistroAsistenciaBO.getInstance();
    private static IHorarioLaboralBO horarioLaboralBO= HorarioLaboralBO.getInstance();

    /**
     * Registra la entrada de un empleado en una fecha y hora específica.
     * 
     * @param empleado El empleado que registra su entrada.
     * @param fechaAsistencia Fecha en la que se registra la entrada.
     * @param horaEntrada Hora exacta de la entrada.
     * @return {@code true} si el registro fue exitoso, de lo contrario lanza excepción.
     * @throws RegistrarAsistenciaException si el empleado es nulo, su RFC es nulo, o ocurre un error en la lógica de negocio.
     */
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws RegistrarAsistenciaException {
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

    /**
     * Registra la salida de un empleado en una fecha y hora específica.
     * 
     * @param empleado El empleado que registra su salida.
     * @param fechaAsistencia Fecha del registro de salida.
     * @param horaSalida Hora exacta de la salida.
     * @return {@code true} si el registro fue exitoso, de lo contrario lanza excepción.
     * @throws RegistrarAsistenciaException si el empleado es nulo, su RFC es nulo, o ocurre un error en la lógica de negocio.
     */
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws RegistrarAsistenciaException {
        if (empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");

        if (empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");

        try {
            return registrarAsistenciaBO.registrarSalida(empleado, fechaAsistencia, horaSalida);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }

    /**
     * Valida si el empleado tiene horario laboral asignado para la fecha dada.
     * 
     * @param empleado El empleado a validar.
     * @param fechaAsistencia Fecha que se desea validar.
     * @return {@code true} si el empleado tiene un horario laboral válido ese día.
     * @throws RegistrarAsistenciaException si el empleado o su RFC es nulo, o si ocurre un error en la lógica de negocio.
     */
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        if (empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");

        if (empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");

        try {
            return horarioLaboralBO.validarHorarioLaboral(empleado, fechaAsistencia);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }

    /**
     * Obtiene los detalles del horario laboral del empleado para un día específico.
     * 
     * @param empleado El empleado cuyo horario se desea consultar.
     * @param fechaAsistencia Fecha del día que se desea consultar.
     * @return Un objeto {@link HorarioLaboralDTO} con los detalles del horario laboral.
     * @throws RegistrarAsistenciaException si el empleado o su RFC es nulo, o si ocurre un error en la lógica de negocio.
     */
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws RegistrarAsistenciaException {
        if(empleado == null)
            throw new RegistrarAsistenciaException("El empleado a validar no puede ser nulo.");

        if(empleado.getRfc() == null)
            throw new RegistrarAsistenciaException("El RFC del empleado no puede estar vacío.");

        try{
            return horarioLaboralBO.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
        }catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException(ex.getMessage(), ex);
        }
    }

    /**
     * Envía un correo electrónico al empleado confirmando su registro de entrada o salida.
     * 
     * @param empleado El empleado que recibió el registro.
     * @param fechaAsistencia Fecha del registro.
     * @param hora Hora del registro.
     * @param tipoAsistencia Tipo de registro: "entrada" o "salida".
     * @return {@code true} si el correo fue enviado correctamente.
     * @throws RegistrarAsistenciaException si ocurre un error durante el envío del correo.
     */
    public boolean enviarCorreo(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime hora, String tipoAsistencia) throws RegistrarAsistenciaException {
        try {
            ISistemaCorreo sistemaCorreo = new SistemaCorreo();
            CorreoDTO dto = new CorreoDTO();
            dto.setCorreoReceptor(empleado.getEmail());
            dto.setPlantillaCorreo("ASISTENCIA");

            DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

            Map<String, Object> values = Map.of(
                "nombre", String.join(" ",
                    empleado.getNombre(),
                    empleado.getApellidoPaterno(),
                    empleado.getApellidoMaterno()
                ),
                "tipoRegistro", tipoAsistencia.toLowerCase(),
                "fecha", fechaAsistencia.format(fechaFormatter),
                "hora", hora.format(horaFormatter)
            );

            dto.setValues(values);
            sistemaCorreo.sendEmail(dto);
            return true;
        } catch (CorreoException ex) {
            Logger.getLogger(ControlRegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarAsistenciaException("Error al enviar correo: " + ex.getMessage());
        }
    }

}