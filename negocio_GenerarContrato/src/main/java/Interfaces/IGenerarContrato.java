/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.GenerarContratoException;
import dto.ContratoDTO;

/**
 *
 * @author skyro
 */
public interface IGenerarContrato {
    
    ContratoDTO registrarContrato(ContratoDTO contrato) throws GenerarContratoException;
}
