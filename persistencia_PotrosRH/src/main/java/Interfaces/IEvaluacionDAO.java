/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Evaluacion;
import Exceptions.AccesoDatosException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Evaluacion. Establece los métodos necesarios para gestionar evaluaciones de
 * candidatos en el sistema de persistencia, independientemente de la
 * implementación específica.
 *
 * Esta interfaz proporciona el método para registrar evaluaciones, con
 * validaciones que pueden incluir restricciones como impedir múltiples
 * evaluaciones aprobadas para un mismo candidato.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IEvaluacionDAO {

    /**
     * Registra una nueva evaluación en el sistema de persistencia. Debe
     * implementar validaciones para asegurar la integridad de los datos, como
     * verificar que el candidato no tenga ya una evaluación aprobada.
     *
     * @param evaluacion El objeto Evaluacion que se va a registrar
     * @return El objeto Evaluacion registrado, posiblemente con identificadores
     * generados
     * @throws AccesoDatosException Si ocurre un error durante el registro o si
     * el candidato ya tiene una evaluación aprobada
     */
    Evaluacion registrarEvaluacion(Evaluacion evaluacion) throws AccesoDatosException;
}
