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
 * Interfaz que define las operaciones de negocio para la entidad Candidato.
 * Establece el contrato para la capa de negocio relacionada con la gestión de
 * candidatos, definiendo las operaciones que deben ser implementadas para
 * manipular la información de candidatos en el sistema.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface ICandidatoBO {

    /**
     * Registra un nuevo candidato en el sistema.
     *
     * @param candidato El objeto CandidatoDTO con la información del candidato
     * a registrar
     * @return El objeto CandidatoDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si ya existe un candidato con el mismo RFC
     */
    CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws ObjetosNegocioException;

    /**
     * Busca y recupera un candidato según su RFC.
     *
     * @param candidato El objeto CandidatoDTO con el RFC del candidato a buscar
     * @return El objeto CandidatoDTO encontrado, o null si no existe
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws ObjetosNegocioException;

    /**
     * Recupera todos los candidatos almacenados en el sistema.
     *
     * @return Una lista con todos los objetos CandidatoDTO disponibles
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    List<CandidatoDTO> obtenerTodos() throws ObjetosNegocioException;

    /**
     * Recupera candidatos que cumplen con los criterios de filtrado
     * especificados.
     *
     * @param filtro Objeto CandidatoFiltroDTO con los criterios de filtrado
     * @return Lista de objetos CandidatoDTO que cumplen con los criterios
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
    List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws ObjetosNegocioException;
}
