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
public class RegistrarEvaluacion implements IRegistrarEvaluacion {

    private static RegistrarEvaluacion instance;
    private ControlRegistrarEvaluacion control;

    private RegistrarEvaluacion() {
        this.control = new ControlRegistrarEvaluacion();
    }
    
    public static IRegistrarEvaluacion getInstance() {
        if (instance == null) {
            instance = new RegistrarEvaluacion();
        }
        return instance;
    }
    
    @Override
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws RegistrarEvaluacionException {
        try {
            control.validarEvaluacion(evaluacion);
            
            return control.registrarEvaluacion(evaluacion);
        } catch (RegistrarEvaluacionException ex) {
            Logger.getLogger(RegistrarEvaluacion.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarEvaluacionException(ex.getMessage());
        }
    }
    
}
