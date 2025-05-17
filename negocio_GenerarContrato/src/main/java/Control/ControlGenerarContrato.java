/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Exceptions.GenerarContratoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IContratoBO;
import bo.ContratoBO;
import dto.ContratoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class ControlGenerarContrato {
    
    private static IContratoBO contratoBO = ContratoBO.getInstance();
    
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws GenerarContratoException {
        if (contrato == null) 
            throw new GenerarContratoException("El contrato no puede ser nulo.");
        
        try {
            return contratoBO.registrarContrato(contrato);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarContrato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarContratoException(ex.getMessage());
        }
    }
    
    public void enviarContrato(ContratoDTO contrato) {
        
    }
}
