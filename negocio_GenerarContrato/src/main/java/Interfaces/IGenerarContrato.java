/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.GenerarContratoException;
import dto.ContratoDTO;

/**
 * Interfaz que define las operaciones para la generación y registro de
 * contratos de empleados. Establece el contrato que deben implementar las
 * clases que proporcionan funcionalidad para crear y gestionar contratos en el
 * sistema.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IGenerarContrato {

    /**
     * Registra un nuevo contrato en el sistema y realiza las operaciones
     * necesarias como la generación del documento PDF y el envío por correo.
     *
     * @param contrato El objeto ContratoDTO con la información del contrato a
     * registrar
     * @return El objeto ContratoDTO registrado, con identificadores generados
     * @throws GenerarContratoException Si ocurre un error durante el registro,
     * validación o procesamiento del contrato
     */
    ContratoDTO registrarContrato(ContratoDTO contrato) throws GenerarContratoException;
}
