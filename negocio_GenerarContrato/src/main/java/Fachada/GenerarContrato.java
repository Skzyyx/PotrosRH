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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class GenerarContrato implements IGenerarContrato {

    private static GenerarContrato instance;
    private ControlGenerarContrato control;

    private GenerarContrato() {
        this.control = new ControlGenerarContrato();
    }

    public static IGenerarContrato getInstance() {
        if (instance == null) {
            instance = new GenerarContrato();
        }
        return instance;
    }

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
