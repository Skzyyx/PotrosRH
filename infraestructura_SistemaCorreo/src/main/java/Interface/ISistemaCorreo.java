/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Excepciones.SistemaCorreoException;
import dto.NominaDTO;
import java.io.File;

/**
 *
 * @author skyro
 */
public interface ISistemaCorreo {
    
    public void enviarCorreo(NominaDTO nomina) throws SistemaCorreoException;
}
