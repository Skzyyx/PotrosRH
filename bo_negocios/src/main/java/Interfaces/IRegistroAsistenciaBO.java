package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public interface IRegistroAsistenciaBO {
    
    public boolean registrarEntrada(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws ObjetosNegocioException;
    
    public boolean registrarSalida(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaSalida)throws ObjetosNegocioException;
    /**
     * Obtiene los días trabajados de un empleado.
     * @param empleado Empleado asociado.
     * @param fechaInicio Fecha de inicio del período.
     * @return Días trabajados del empleado en el período (fecha de inicio y actual).
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    public Integer obtenerDiasTrabajados(EmpleadoDTO empleado, LocalDate fechaInicio) throws ObjetosNegocioException;
    /**
     * Obtiene las horas trabajadas de un empleado.
     * @param empleado Empleado asociado.
     * @param fechaInicio Fecha de inicio del período.
     * @return Horas trabajadas del empleado, en el período establecido (fecha de inicio y actual).
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    public Double obtenerHorasTrabajadas(EmpleadoDTO empleado, LocalDate fechaInicio) throws ObjetosNegocioException;
}