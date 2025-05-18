/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlGenerarContrato;
import Exceptions.GenerarContratoException;
import Interfaces.IGenerarContrato;
import dto.ContratoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class GenerarContrato implements IGenerarContrato{

    private ControlGenerarContrato control;

    public GenerarContrato() {
        this.control = new ControlGenerarContrato();
    }
    
    @Override
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws GenerarContratoException {
        try {
            contrato =  control.registrarContrato(contrato);
            
//            control.enviarContrato(contrato);
            return contrato;
        } catch (GenerarContratoException ex) {
            Logger.getLogger(GenerarContrato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarContratoException(ex.getMessage());
        }
    }
    
}
