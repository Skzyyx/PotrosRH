package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IEmpleadoBO {
    /**
     * Valida que el estado del empleado sea ACTIVO.
     * @param rfc RFC del empleado a evaluar.
     * @return {@code true} si el RFC es válido.
     * @throws ObjetosNegocioException Si el RFC es nulo o está vacío.
     */
    public boolean validarEstado(String rfc) throws ObjetosNegocioException;
    /**
     * Determina si el porcentaje de faltas de un empleado es aceptable.
     * @param rfc RFC del empleado a evaluar.
     * @return {@code true} si el porcentaje de faltas es menor al 80%, {@code false} en caso contrario.
     * @throws Exceptions.ObjetosNegocioException cuando no cumple con el minimo de asistencias.
     */
    public boolean validarPorcentajeAsistencias(String rfc) throws ObjetosNegocioException;
    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC. Si el RFC es
     * inválido o el empleado no se encuentra en la lista, lanza una excepción.
     * @param rfc RFC del empleado a buscar.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no
     * está registrado.
     */
    public EmpleadoDTO obtenerEmpleado(String rfc) throws ObjetosNegocioException;
}