/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Candidato;
import Exceptions.ObjetosNegocioException;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import java.util.List;
import org.bson.conversions.Bson;

/**
 *
 * @author skyro
 */
public interface ICandidatoBO {
    
    CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws ObjetosNegocioException;
    
    CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws ObjetosNegocioException;

    List<CandidatoDTO> obtenerTodos() throws ObjetosNegocioException;
    
    List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws ObjetosNegocioException;
}
