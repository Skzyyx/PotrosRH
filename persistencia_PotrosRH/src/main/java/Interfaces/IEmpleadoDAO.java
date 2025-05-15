package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;

/**
 * Interfaz para clases EmpleadoDAO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoDAO {
    /**
     * Valida el estado de un empleado.
     * @param rfc RFC del empleado.
     * @return VERDADERO si el empleado está activo, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public boolean validarEstado(String rfc) throws AccesoDatosException;
    /**
     * Valida que el porcentaje de asistencia de un empleado sea
     * igual o superior al 80%, correspondiente con su período
     * de trabajo.
     * @param rfc RFC del empleado.
     * @return VERDADERO si el porcentaje de asistencia es igual o superior al 80%, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public boolean validarPorcentajeAsistencias(String rfc) throws AccesoDatosException;
    /**
     * Obtiene un empleado de la base de datos.
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    public Empleado obtenerEmpleado(Empleado empleado) throws AccesoDatosException;
    
    public void actualizarEmpleado(Empleado empleado) throws AccesoDatosException;
}