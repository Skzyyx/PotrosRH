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
 * Interfaz que define las operaciones para registrar y obtener candidatos.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface IRegistrarObteneCandidato {

    /**
     * Registra un nuevo candidato en el sistema.
     *
     * @param candidato El candidato a registrar
     * @return El candidato registrado
     * @throws RegistrarObtenerCandidatoException Si ocurre un error
     */
    CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException;

    /**
     * Obtiene un candidato del sistema.
     *
     * @param candidato El candidato con los datos de búsqueda (RFC)
     * @return El candidato encontrado
     * @throws RegistrarObtenerCandidatoException Si ocurre un error
     */
    CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException;

    /**
     * Obtiene todos los candidatos registrados.
     *
     * @return Lista de todos los candidatos
     * @throws RegistrarObtenerCandidatoException Si ocurre un error
     */
    List<CandidatoDTO> obtenerTodos() throws RegistrarObtenerCandidatoException;

    /**
     * Obtiene candidatos que coinciden con un filtro.
     *
     * @param filtro Los criterios de búsqueda
     * @return Lista de candidatos que coinciden
     * @throws RegistrarObtenerCandidatoException Si ocurre un error
     */
    List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws RegistrarObtenerCandidatoException;
}
