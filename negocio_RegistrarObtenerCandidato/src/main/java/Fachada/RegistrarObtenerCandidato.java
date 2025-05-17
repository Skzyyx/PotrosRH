/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlRegistrarObtenerCandidato;
import Exceptions.RegistrarObtenerCandidatoException;
import Interfaces.IRegistrarObteneCandidato;
import dto.CandidatoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class RegistrarObtenerCandidato implements IRegistrarObteneCandidato {

    private ControlRegistrarObtenerCandidato control;

    public RegistrarObtenerCandidato() {
        this.control = new ControlRegistrarObtenerCandidato();
    }

    @Override
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {

        try {
            control.validarDatosCandidato(candidato);

            return control.registrarCandidato(candidato);
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(RegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }

    @Override
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {
        try {
            return control.obtenerCandidato(candidato);
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(RegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }
}
