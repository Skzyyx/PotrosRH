package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.time.LocalDate;

/**
 * Interfaz del objeto de Negocio NominaBO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface INominaBO {
    /**
     * Genera una nómina para un empleado dado.
     * 
     * @param empleado Objeto EmpleadoDTO con los datos del empleado.
     * @return NominaDTO con los datos de la nómina generada.
     * @throws ObjetosNegocioException si el empleado es nulo.
     */
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws ObjetosNegocioException;
    /**
     * Simula el guardado de una nómina en la base de datos.
     * @param nomina Objeto NominaDTO que se desea guardar.
     * @return NominaDTO con nómina insertada.
     * @throws Exceptions.ObjetosNegocioException Excepción.
     */
    public NominaDTO guardarNomina(NominaDTO nomina) throws ObjetosNegocioException;
    /**
     * Obtiene la fecha de la última nómina de un empleado.
     * @param empleado Empleado asociado.
     * @return Fecha de la última nómina del empleado.
     * @throws ObjetosNegocioException Excepción.
     */
    public LocalDate obtenerFechaUltimaNomina(EmpleadoDTO empleado) throws ObjetosNegocioException;
}