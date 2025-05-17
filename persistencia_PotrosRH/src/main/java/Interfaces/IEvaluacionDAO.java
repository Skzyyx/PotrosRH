/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Evaluacion;
import Exceptions.AccesoDatosException;

/**
 *
 * @author skyro
 */
public interface IEvaluacionDAO {
    
    Evaluacion registrarEvaluacion(Evaluacion evaluacion) throws AccesoDatosException;
}
