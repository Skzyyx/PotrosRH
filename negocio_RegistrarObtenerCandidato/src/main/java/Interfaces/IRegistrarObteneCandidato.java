/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.RegistrarObtenerCandidatoException;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import java.util.List;

/**
 *
 * @author skyro
 */
public interface IRegistrarObteneCandidato {
    
    CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException;
    
    CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException;
    
    List<CandidatoDTO> obtenerTodos() throws RegistrarObtenerCandidatoException;

    List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws RegistrarObtenerCandidatoException;    
}
