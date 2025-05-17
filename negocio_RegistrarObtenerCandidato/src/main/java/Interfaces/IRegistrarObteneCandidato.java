/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.RegistrarObtenerCandidatoException;
import dto.CandidatoDTO;

/**
 *
 * @author skyro
 */
public interface IRegistrarObteneCandidato {
    
    CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException;
    
    CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException;
}
