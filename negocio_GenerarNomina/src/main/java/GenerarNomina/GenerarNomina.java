/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarNomina;

import Excepciones.SistemaCorreoException;
import Exceptions.GenerarNominaException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IGenerarNomina;
import SistemaCorreo.SistemaCorreo;
import bo.NominaBO;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.io.File;
import java.net.URI;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class GenerarNomina implements IGenerarNomina {
    
    private NominaBO nominaBO = new NominaBO();

    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado, double bono) throws GenerarNominaException {
        if (empleado == null) {
            throw new GenerarNominaException("El empleado no puede ser nulo.");
        }
        
        try {
            return nominaBO.generarNomina(empleado, 0);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(GenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException("Error al generar la nómina: " + ex.getMessage());
        }
    }

    @Override
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException{
        ISistemaCorreo sistemaCorreo = new SistemaCorreo();
        
        try {
            nominaBO.guardarNomina(nomina);
            sistemaCorreo.enviarCorreo(nomina);
            return true;
        } catch (SistemaCorreoException ex) {
            Logger.getLogger(GenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException("Ocurrió un error al enviar el correo.");
        }
    }
}
