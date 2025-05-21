package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.ContratoDTO;
import dto.EmpleadoDTO;
import java.time.LocalDate;

/**
 *
 * @author skyro
 */
public interface IContratoBO {
    
    ContratoDTO registrarContrato(ContratoDTO contrato) throws ObjetosNegocioException;
    /**
     * Obtiene la fecha de inicio del contrato de 
     * un empleado en particular.
     * @param empleado Empleado asociado.
     * @return Fecha de inicio del contrato del empleado.
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    public LocalDate obtenerFechaInicioContrato(EmpleadoDTO empleado) throws ObjetosNegocioException;
}