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
 * Objeto de negocio ContratoBO. Implementa la interfaz IContratoBO y
 * proporciona la lógica de negocio para gestionar contratos de empleados en el
 * sistema. Actúa como intermediario entre la capa de presentación y la capa de
 * acceso a datos, aplicando reglas de negocio y validaciones.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ContratoBO implements IContratoBO {

    /**
     * Instancia única de la clase (patrón Singleton).
     */
    private static ContratoBO instance;

    /**
     * Objeto DAO para operaciones CRUD con Contratos.
     */
    private IContratoDAO contratoDAO = new ContratoDAO();

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private ContratoBO() {
    }

    /**
     * Método para obtener la instancia única de la clase (patrón Singleton).
     *
     * @return Instancia única de ContratoBO
     */
    public static synchronized IContratoBO getInstance() {
        if (instance == null) {
            instance = new ContratoBO();
        }
        return instance;
    }

    /**
     * Registra un nuevo contrato en el sistema.
     *
     * @param contrato El objeto ContratoDTO con la información del contrato a
     * registrar
     * @return El objeto ContratoDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si ya existe un contrato para el mismo empleado
     */
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
     * Obtiene la fecha de inicio del contrato de un empleado en particular.
     *
     * @param empleado Empleado asociado.
     * @return Fecha de inicio del contrato del empleado.
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    @Override
    public LocalDate obtenerFechaInicioContrato(EmpleadoDTO empleado) throws ObjetosNegocioException {
        if (!(empleado != null && empleado.getId() != null)) {
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        }

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
