/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EvaluacionDTO;

/**
 *
 * @author skyro
 */
public interface IEvaluacionBO {
    
    EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws ObjetosNegocioException;
}
