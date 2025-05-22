/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EvaluacionDTO;

/**
 * Interfaz que define las operaciones de negocio para la entidad Evaluacion.
 * Establece el contrato para la capa de negocio relacionada con la gestión de
 * evaluaciones, definiendo las operaciones que deben ser implementadas para
 * manipular la información de evaluaciones de candidatos en el sistema.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IEvaluacionBO {

    /**
     * Registra una nueva evaluación en el sistema.
     *
     * @param evaluacion El objeto EvaluacionDTO con la información de la
     * evaluación a registrar
     * @return El objeto EvaluacionDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si el candidato ya tiene una evaluación aprobada
     */
    EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws ObjetosNegocioException;
}
