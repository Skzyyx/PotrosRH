/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlRegistrarObtenerCandidato;
import Exceptions.RegistrarObtenerCandidatoException;
import Interfaces.IRegistrarObteneCandidato;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import java.util.List;

/**
 *
 * @author skyro
 */
public class RegistrarObtenerCandidato implements IRegistrarObteneCandidato {

    private static RegistrarObtenerCandidato instance;
    private ControlRegistrarObtenerCandidato control;

    private RegistrarObtenerCandidato() {
        this.control = new ControlRegistrarObtenerCandidato();
    }

    public static synchronized IRegistrarObteneCandidato getInstance() {
        if (instance == null) {
            instance = new RegistrarObtenerCandidato();
        }
        return instance;
    }

    @Override
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {
        control.validarDatosCandidato(candidato);
        return control.registrarCandidato(candidato);
    }

    @Override
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {
        return control.obtenerCandidato(candidato);
    }

    @Override
    public List<CandidatoDTO> obtenerTodos() throws RegistrarObtenerCandidatoException {
        return control.obtenerTodos();
    }

    @Override
    public List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws RegistrarObtenerCandidatoException {
        return control.obtenerPorFiltro(filtro);
    }
}
