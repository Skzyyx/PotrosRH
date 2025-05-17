/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlRegistrarEvaluacion;
import Exceptions.RegistrarEvaluacionException;
import Interface.IRegistrarEvaluacion;
import dto.EvaluacionDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class RegistrarEvaluación implements IRegistrarEvaluacion {

    private ControlRegistrarEvaluacion control;

    public RegistrarEvaluación() {
        this.control = new ControlRegistrarEvaluacion();
    }
    
    
    @Override
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws RegistrarEvaluacionException {
        try {
            control.validarEvaluacion(evaluacion);
            
            return control.registrarEvaluacion(evaluacion);
        } catch (RegistrarEvaluacionException ex) {
            Logger.getLogger(RegistrarEvaluación.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarEvaluacionException(ex.getMessage());
        }
    }
    
}
