package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Interfaz para clases RegistroAsistenciasDAO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IRegistroAsistenciaDAO {
    /**
     * Obtiene los días trabajados de un empleado, cuyo período de tiempo
     * se ubica entre el día de la última nómina generada, hasta
     * el día de hoy.Se utiliza para generar nuevas nóminas.
     * @param empleado Empleado del cual de desea obtener sus cantidad de días trabajados.
     * @param fechaInicio Fecha de inicio del período de trabajo.
     * @return Número de días trabajados, desde su última nómina generada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Integer obtenerDiasTrabajados(Empleado empleado, LocalDate fechaInicio) throws AccesoDatosException;
    /**
     * Obtiene las horas trabajadas de un empleado, cuyo período de tiempo
     * se ubica entre el día de la última nómina generada, hasta
     * el día de hoy.Se utiliza para generar nuevas nóminas.
     * @param empleado Empleado del cual de desea obtener sus cantidad de horas trabajadas.
     * @param fechaInicio Fecha de inicio del período de trabajo.
     * @return Horas trabajadas del empleado, desde su última nómina generada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Double obtenerHorasTrabajadas(Empleado empleado, LocalDate fechaInicio) throws AccesoDatosException;
    /**
     * Obtiene la fecha del primer día de trabajo de un empleado, 
     * el cual vendría siendo su primer registro de asistencia.
     * Se utiliza para generar la primera nómina de un empleado.
     * @param empleado Empleado del cual se desea obtener la fecha de su primer día de trabajo.
     * @return Fecha del primer día de trabajo del empleado.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public LocalDate obtenerFechaPrimerDiaTrabajo(Empleado empleado) throws AccesoDatosException;
    /**
     * Registra la entrada de un empleado.
     * @param empleado Empleado que registra su entrada.
     * @param fechaAsistencia Fecha de la asistencia.
     * @param horaEntrada Hora de entrada.
     * @return VERDADERO si se registró la entrada, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public boolean registrarEntrada(Empleado empleado, LocalDate fechaAsistencia, LocalTime horaEntrada)throws AccesoDatosException;
    /**
     * Registra la salida de un empleado.
     * @param empleado Empleado que registra su entrada.
     * @param fechaAsistencia Fecha de la asistencia.
     * @param horaSalida Hora de salida.
     * @return VERDADERO si se registró la entrada, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public boolean registrarSalida(Empleado empleado, LocalDate fechaAsistencia, LocalTime horaSalida)throws AccesoDatosException;
} 