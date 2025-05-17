/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.CandidatoDTO;
import java.util.List;

/**
 *
 * @author skyro
 */
public interface ICandidatoBO {
    
    CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws ObjetosNegocioException;
    
    CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws ObjetosNegocioException;

    List<CandidatoDTO> obtenerTodos() throws ObjetosNegocioException;
}
