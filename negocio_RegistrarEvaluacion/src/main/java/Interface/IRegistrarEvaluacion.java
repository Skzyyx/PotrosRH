/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Exceptions.RegistrarEvaluacionException;
import dto.EvaluacionDTO;

/**
 * Interfaz que define las operaciones para registrar evaluaciones.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IRegistrarEvaluacion {

    /**
     * Registra una nueva evaluación en el sistema.
     *
     * @param evaluacion El DTO de evaluación a registrar
     * @return La evaluación registrada
     * @throws RegistrarEvaluacionException Si ocurre un error durante el
     * registro
     */
    EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws RegistrarEvaluacionException;
}
