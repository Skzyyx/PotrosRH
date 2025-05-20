/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Excepciones.PresentacionException;
import Exceptions.GenerarContratoException;
import Exceptions.RegistrarEvaluacionException;
import Exceptions.RegistrarObtenerCandidatoException;
import Fachada.GenerarContrato;
import Fachada.RegistrarEvaluacion;
import Fachada.RegistrarObtenerCandidato;
import Interface.IRegistrarEvaluacion;
import Interfaces.IGenerarContrato;
import Interfaces.IRegistrarObteneCandidato;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import dto.ContratoDTO;
import dto.EvaluacionDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class ControlRegistro {
    
    private static ControlRegistro instance;
    
    private CandidatoDTO candidatoDTO;
    private EvaluacionDTO evaluacionDTO;
    private ContratoDTO contratoDTO;
    
    private final IRegistrarObteneCandidato registrarObteneCandidato = RegistrarObtenerCandidato.getInstance();
    private final IRegistrarEvaluacion registrarEvaluacion = RegistrarEvaluacion.getInstance();
    private final IGenerarContrato generarContrato = GenerarContrato.getInstance();

    private ControlRegistro() {
        this.candidatoDTO = new CandidatoDTO();
        this.evaluacionDTO = new EvaluacionDTO();
        this.contratoDTO = new ContratoDTO();
    }
    
    public static ControlRegistro getInstance() {
        if (instance == null) {
            instance = new ControlRegistro();
        }
        return instance;
    }
    
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws PresentacionException {
        try {
            candidatoDTO = registrarObteneCandidato.registrarCandidato(candidato);
            return candidatoDTO;
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
    
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws PresentacionException {
        try {
            return registrarObteneCandidato.obtenerCandidato(candidato);
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
    
    public List<CandidatoDTO> obtenerTodosCandidatos() throws PresentacionException {
        try {
            return registrarObteneCandidato.obtenerTodos();
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
    
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws PresentacionException {
        try {
            evaluacionDTO = registrarEvaluacion.registrarEvaluacion(evaluacion);
            return evaluacionDTO;
        } catch (RegistrarEvaluacionException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
    
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws PresentacionException {
        try {
            contratoDTO = generarContrato.registrarContrato(contrato);
            return contratoDTO;
        } catch (GenerarContratoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
    
    public List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws PresentacionException {
        try {
            return registrarObteneCandidato.obtenerPorFiltro(filtro);
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
    
}
