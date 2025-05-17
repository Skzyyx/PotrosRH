/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Candidato;
import Exceptions.AccesoDatosException;
import java.util.List;

/**
 *
 * @author skyro
 */
public interface ICandidatoDAO {
    
    Candidato registrarCandidato(Candidato candidato) throws AccesoDatosException;
    
    Candidato obtenerCandidato(String rfc) throws AccesoDatosException;

    List<Candidato> obtenerTodos() throws AccesoDatosException;
}
