/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Contrato;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import java.time.LocalDate;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Contrato. Establece los métodos necesarios para gestionar contratos de
 * empleados en el sistema de persistencia, independientemente de la
 * implementación específica.
 *
 * Actualmente define una operación básica para registrar nuevos contratos,
 * asegurando la integridad de los datos mediante validaciones como evitar
 * contratos duplicados para un mismo empleado.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IContratoDAO {

    /**
     * Registra un nuevo contrato en el sistema de persistencia. Debe
     * implementar validaciones para evitar contratos duplicados para el mismo
     * empleado.
     *
     * @param contrato El objeto Contrato que se va a registrar
     * @return El objeto Contrato registrado, posiblemente con identificadores
     * generados
     * @throws AccesoDatosException Si ocurre un error durante el registro o si
     * ya existe un contrato para el mismo empleado
     */
    Contrato registrarContrato(Contrato contrato) throws AccesoDatosException;
    /**
     * Obtiene la fecha de inicio del contrato de un
     * empleado.
     * @param empleado Empleado asociado al contrato.
     * @return Fecha de inicio del contrato asociado al empleado.
     * @throws AccesoDatosException Excepción de la capa de Persistencia.
     */
    public LocalDate obtenerFechaInicioContrato(Empleado empleado) throws AccesoDatosException;
}
