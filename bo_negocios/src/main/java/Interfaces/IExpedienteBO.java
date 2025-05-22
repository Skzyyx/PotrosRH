package Interfaces;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */

import Exceptions.ObjetosNegocioException;
import dto.ExpedienteDTO;

/**
 * Interfaz que define las operaciones de negocio para la entidad Expediente.
 * Establece el contrato para la capa de negocio relacionada con la gestión
 * de expedientes laborales, definiendo las operaciones para consultar y
 * actualizar expedientes de empleados.
 * 
 * @author José Alfredo Guzman Moreno (252524)
 */
public interface IExpedienteBO {

    /**
     * Consulta un expediente por el RFC del empleado.
     * 
     * @param rfc RFC del empleado.
     * @return Objeto ExpedienteDTO con los datos del expediente.
     * @throws ObjetosNegocioException Si ocurre un error en la lógica de negocio
     *                                 o si el RFC no es válido.
     */
    ExpedienteDTO consultarPorRFC(String rfc) throws ObjetosNegocioException;

    /**
     * Actualiza los datos modificables del expediente: sueldo bruto, departamento
     * y puesto.
     * 
     * @param expedienteDTO Objeto con la información del expediente a actualizar.
     * @return Objeto ExpedienteDTO actualizado.
     * @throws ObjetosNegocioException Si ocurre un error durante la actualización.
     */
    ExpedienteDTO actualizarExpediente(ExpedienteDTO expedienteDTO) throws ObjetosNegocioException;

    /**
     * Verifica si existe un expediente con el RFC proporcionado.
     * 
     * @param rfc RFC del empleado.
     * @return true si existe el expediente, false en caso contrario.
     * @throws ObjetosNegocioException Si ocurre un error durante la verificación.
     */
    boolean existeExpedientePorRFC(String rfc) throws ObjetosNegocioException;
}
