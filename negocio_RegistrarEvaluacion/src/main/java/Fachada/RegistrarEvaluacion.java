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
 * Fachada para el registro de evaluaciones. Implementa el patrón Singleton y
 * delega las operaciones al controlador.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class RegistrarEvaluacion implements IRegistrarEvaluacion {

    private static RegistrarEvaluacion instance;
    private ControlRegistrarEvaluacion control;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private RegistrarEvaluacion() {
        this.control = new ControlRegistrarEvaluacion();
    }

    /**
     * Obtiene la instancia única de la clase (Singleton).
     *
     * @return La instancia única de RegistrarEvaluacion
     */
    public static IRegistrarEvaluacion getInstance() {
        if (instance == null) {
            instance = new RegistrarEvaluacion();
        }
        return instance;
    }

    /**
     * Registra una nueva evaluación después de validar sus datos.
     *
     * @param evaluacion El DTO de evaluación a registrar
     * @return La evaluación registrada
     * @throws RegistrarEvaluacionException Si la evaluación no es válida o
     * ocurre un error durante el registro
     */
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
