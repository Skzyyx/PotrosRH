package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.ContratoDTO;
import dto.EmpleadoDTO;
import java.time.LocalDate;

/**
 * Interfaz que define las operaciones de negocio para la entidad Contrato.
 * Establece el contrato para la capa de negocio relacionada con la gestión de
 * contratos, definiendo las operaciones que deben ser implementadas para
 * manipular la información de contratos de empleados en el sistema.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IContratoBO {

    /**
     * Registra un nuevo contrato en el sistema.
     *
     * @param contrato El objeto ContratoDTO con la información del contrato a
     * registrar
     * @return El objeto ContratoDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si ya existe un contrato para el mismo empleado
     */
    ContratoDTO registrarContrato(ContratoDTO contrato) throws ObjetosNegocioException;

    /**
     * Obtiene la fecha de inicio del contrato de un empleado en particular.
     *
     * @param empleado Empleado asociado.
     * @return Fecha de inicio del contrato del empleado.
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    public LocalDate obtenerFechaInicioContrato(EmpleadoDTO empleado) throws ObjetosNegocioException;
}
