package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;

/**
 *
 * @author skyro
 */
public interface IEmpleadoBO {
    /**
     * Valida que el estado del empleado sea ACTIVO.
     * @param empleado Empleado a validar.
     * @return {@code true} si el RFC es válido.
     * @throws ObjetosNegocioException Si el RFC es nulo o está vacío.
     */
    public boolean validarEstado(EmpleadoDTO empleado) throws ObjetosNegocioException;
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