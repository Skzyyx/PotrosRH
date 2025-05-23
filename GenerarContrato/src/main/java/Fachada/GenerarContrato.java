/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlGenerarContrato;
import Exceptions.GenerarContratoException;
import Interfaces.IGenerarContrato;
import dto.ContratoDTO;
import dto.CorreoDTO;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase fachada que implementa la interfaz IGenerarContrato y proporciona un
 * punto de acceso unificado para la funcionalidad de generación de contratos.
 * Sigue el patrón Singleton para garantizar una única instancia en toda la
 * aplicación y el patrón Fachada para simplificar la interacción con el
 * subsistema de contratos.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class GenerarContrato implements IGenerarContrato {

    /**
     * Instancia única de la clase (patrón Singleton).
     */
    private static GenerarContrato instance;

    /**
     * Objeto de control que implementa la lógica de generación de contratos.
     */
    private ControlGenerarContrato control;

    /**
     * Constructor privado para implementar el patrón Singleton. Inicializa el
     * objeto de control.
     */
    private GenerarContrato() {
        this.control = new ControlGenerarContrato();
    }

    /**
     * Método para obtener la instancia única de la clase (patrón Singleton).
     *
     * @return Instancia única de GenerarContrato
     */
    public static IGenerarContrato getInstance() {
        if (instance == null) {
            instance = new GenerarContrato();
        }
        return instance;
    }

    /**
     * Registra un nuevo contrato en el sistema y envía un correo electrónico al
     * empleado con el documento PDF del contrato.
     *
     * @param contrato El objeto ContratoDTO con la información del contrato a
     * registrar
     * @return El objeto ContratoDTO registrado, con identificadores generados
     * @throws GenerarContratoException Si ocurre un error durante el registro,
     * validación o procesamiento del contrato
     */
    @Override
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws GenerarContratoException {
        try {
            contrato = control.registrarContrato(contrato);

            CorreoDTO correo = new CorreoDTO();
            correo.setCorreoReceptor(contrato.getEmpleado().getEmail());
            correo.setPlantillaCorreo("CONTRATACION");
            correo.setValues(Map.of(
                    "nombre", String.join(" ", contrato.getEmpleado().getNombre(), contrato.getEmpleado().getApellidoPaterno(), contrato.getEmpleado().getApellidoMaterno()),
                    "puesto", contrato.getPuesto(),
                    "fechaInicio", contrato.getFechaInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            ));

            control.enviarContrato(correo, contrato);
            return contrato;
        } catch (GenerarContratoException ex) {
            Logger.getLogger(GenerarContrato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarContratoException(ex.getMessage());
        }
    }
}
