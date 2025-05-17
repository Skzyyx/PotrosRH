package DAO;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Interfaces.IRegistroAsistenciaDAO;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase para métodos de Persistencia con entidades RegistroAsistencia.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistroAsistenciaDAO implements IRegistroAsistenciaDAO {
    /**
     * Obtiene los días trabajados de un empleado, cuyo período de tiempo
     * se ubica entre el día de la última nómina generada, hasta
     * el día de hoy. Se utiliza para generar nuevas nóminas.
     * @param empleado Empleado del cual de desea obtener sus cantidad de días trabajados.
     * @return Número de días trabajados, desde su última nómina generada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Integer obtenerDiasTrabajados(Empleado empleado) throws AccesoDatosException {
        return null;
    }
    /**
     * Obtiene las horas trabajadas de un empleado, cuyo período de tiempo
     * se ubica entre el día de la última nómina generada, hasta
     * el día de hoy. Se utiliza para generar nuevas nóminas.
     * @param empleado Empleado del cual de desea obtener sus cantidad de horas trabajadas.
     * @return Horas trabajadas del empleado, desde su última nómina generada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Integer obtenerHorasTrabajadas(Empleado empleado) throws AccesoDatosException {
        return null;
    }
    /**
     * Obtiene la fecha del primer día de trabajo de un empleado, 
     * el cual vendría siendo su primer registro de asistencia.
     * Se utiliza para generar la primera nómina de un empleado.
     * @param empleado Empleado del cual se desea obtener la fecha de su primer día de trabajo.
     * @return Fecha del primer día de trabajo del empleado.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public LocalDate obtenerFechaPrimerDiaTrabajo(Empleado empleado) throws AccesoDatosException {
        return null;
    }
    
    @Override
    public boolean registrarEntrada(Empleado empleado,LocalDate fechaAsistencia,LocalTime horaEntrada)throws AccesoDatosException{
        return true;
    }
    @Override
    public boolean registrarSalida(Empleado empleado,LocalDate FechaAsistencia,LocalTime horaSalida)throws AccesoDatosException{
        return true;
    }
}