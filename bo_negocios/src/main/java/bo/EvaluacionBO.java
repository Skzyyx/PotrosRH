/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.EvaluacionDAO;
import Entidades.Evaluacion;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEvaluacionBO;
import Interfaces.IEvaluacionDAO;
import dto.EvaluacionDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EvaluacionMapper;

/**
 * Objeto de negocio EvaluacionBO. Implementa la interfaz IEvaluacionBO y
 * proporciona la lógica de negocio para gestionar evaluaciones de candidatos en
 * el sistema. Actúa como intermediario entre la capa de presentación y la capa
 * de acceso a datos, aplicando reglas de negocio y validaciones.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class EvaluacionBO implements IEvaluacionBO {

    /**
     * Instancia única de la clase (patrón Singleton).
     */
    private static IEvaluacionBO instance;

    /**
     * Objeto DAO para operaciones CRUD con Evaluaciones.
     */
    private IEvaluacionDAO evaluacionDAO = new EvaluacionDAO();

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private EvaluacionBO() {
    }

    /**
     * Método para obtener la instancia única de la clase (patrón Singleton).
     *
     * @return Instancia única de EvaluacionBO
     */
    public static synchronized IEvaluacionBO getInstance() {
        if (instance == null) {
            instance = new EvaluacionBO();
        }
        return instance;
    }

    /**
     * Registra una nueva evaluación en el sistema.
     *
     * @param evaluacion El objeto EvaluacionDTO con la información de la
     * evaluación a registrar
     * @return El objeto EvaluacionDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si el candidato ya tiene una evaluación aprobada
     */
    @Override
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws ObjetosNegocioException {

        try {
            Evaluacion map = EvaluacionMapper.toEntityNuevo(evaluacion);
            return EvaluacionMapper.toDTOViejo(evaluacionDAO.registrarEvaluacion(map));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EvaluacionBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
}
