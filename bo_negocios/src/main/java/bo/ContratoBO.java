/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.ContratoDAO;
import Entidades.Contrato;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IContratoBO;
import Interfaces.IContratoDAO;
import dto.ContratoDTO;
import dto.EmpleadoDTO;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ContratoMapper;
import org.bson.types.ObjectId;

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
            Contrato map = ContratoMapper.toEntityNuevo(contrato);
            return ContratoMapper.toDTO(contratoDAO.registrarContrato(map));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(ContratoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());

        }
    }
    
    /**
     * Obtiene la fecha de inicio del contrato de 
     * un empleado en particular.
     * @param empleado Empleado asociado.
     * @return Fecha de inicio del contrato del empleado.
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    @Override
    public LocalDate obtenerFechaInicioContrato(EmpleadoDTO empleado) throws ObjetosNegocioException{
        if (!(empleado != null && empleado.getId() != null))
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        
        try {
            //Se extrae el ID del empleado
            Empleado empleadoId = new Empleado();
            empleadoId.setId(new ObjectId(empleado.getId()));
            
            // Se obtiene la fecha de la última nómina del empleado.
            return contratoDAO.obtenerFechaInicioContrato(empleadoId);
        } catch (AccesoDatosException e) {
            Logger.getLogger(NominaBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }
}
