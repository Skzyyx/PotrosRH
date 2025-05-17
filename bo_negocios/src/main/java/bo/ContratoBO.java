/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.ContratoDAO;
import Entidades.Contrato;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IContratoBO;
import Interfaces.IContratoDAO;
import dto.ContratoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ContratoMapper;

/**
 *
 * @author skyro
 */
public class ContratoBO implements IContratoBO {

    private static ContratoBO instance;

    private IContratoDAO contratoDAO = new ContratoDAO();

    private ContratoBO() {
    }

    public static synchronized IContratoBO getInstance() {
        if (instance == null) {
            instance = new ContratoBO();
        }
        return instance;
    }
    
    @Override
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws ObjetosNegocioException {
        if (contrato == null) {
            throw new ObjetosNegocioException("El contrato no puede ser nulo.");
        }
        
        try {
            Contrato map = ContratoMapper.toEntity(contrato);
            return ContratoMapper.toDTO(contratoDAO.registrarContrato(map));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(ContratoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());

        }
    }
}
