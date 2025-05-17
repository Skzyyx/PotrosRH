/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Contrato;
import Exceptions.AccesoDatosException;

/**
 *
 * @author skyro
 */
public interface IContratoDAO {
    
    Contrato registrarContrato(Contrato contrato) throws AccesoDatosException;
}
