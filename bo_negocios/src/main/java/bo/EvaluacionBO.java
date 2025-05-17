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
 *
 * @author skyro
 */
public class EvaluacionBO implements IEvaluacionBO {
    
    private static IEvaluacionBO instance;

    private IEvaluacionDAO evaluacionDAO = new EvaluacionDAO();

    private EvaluacionBO() {
    }

    public static synchronized IEvaluacionBO getInstance() {
        if (instance == null) {
            instance = new EvaluacionBO();
        }
        return instance;
    }

    @Override
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws ObjetosNegocioException {
        
        try {    
            Evaluacion map = EvaluacionMapper.toEntity(evaluacion);
            return EvaluacionMapper.toDTOViejo(evaluacionDAO.registrarEvaluacion(map));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EvaluacionBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

}
