package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *Interfaz que define las operaciones de negocio para la entidad RegistroAsistencia.
 * @author Benjamin Soto Coronado (253183)
 */
public interface IRegistroAsistenciaBO {
    /**
     * Registra la hora de entrada de un empleado en una fecha específica.
     * 
     * @param empleado DTO del empleado que realiza la entrada.
     * @param fechaAsistencia Fecha del registro de entrada.
     * @param horaEntrada Hora exacta en la que se registra la entrada.
     * @return true si el registro fue exitoso, false en caso contrario.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         o si ocurre un error al acceder a los datos.
     */
    public boolean registrarEntrada(EmpleadoDTO empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws ObjetosNegocioException;
    /**
     * Registra la hora de salida de un empleado en una fecha específica.
     * 
     * @param empleado DTO del empleado que realiza la salida.
     * @param fechaAsistencia Fecha del registro de salida.
     * @param horaSalida Hora exacta en la que se registra la salida.
     * @return true si el registro fue exitoso, false en caso contrario.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         o si ocurre un error al acceder a los datos.
     */
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