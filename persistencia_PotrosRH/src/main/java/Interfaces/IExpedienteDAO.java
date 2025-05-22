package Interfaces;

/**
 *
 * @author José Alfredo Guzman Moreno (252524)
 */

import Entidades.Expediente;
import Exceptions.AccesoDatosException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Expediente.
 * Solo se permiten consultas y modificaciones específicas.
 */
public interface IExpedienteDAO {

    /**
     * Consulta un expediente laboral basado en el RFC del empleado.
     *
     * @param rfc RFC del empleado
     * @return El expediente correspondiente si existe
     * @throws AccesoDatosException Si ocurre un error durante la consulta o si no se encuentra el expediente
     */
    Expediente consultarPorRFC(String rfc) throws AccesoDatosException;

    /**
     * Actualiza los datos modificables de un expediente laboral. Solo se deben actualizar:
     * sueldo base, departamento y puesto.
     *
     * @param expediente El expediente con los datos actualizados (debe incluir el ID)
     * @return El expediente actualizado
     * @throws AccesoDatosException Si ocurre un error durante la actualización
     */
    Expediente actualizarExpediente(Expediente expediente) throws AccesoDatosException;

    /**
     * Verifica si existe un expediente asociado al RFC proporcionado.
     *
     * @param rfc RFC del empleado
     * @return true si existe, false en caso contrario
     * @throws AccesoDatosException Si ocurre un error durante la verificación
     */
    boolean existeExpedientePorRFC(String rfc) throws AccesoDatosException;
}
