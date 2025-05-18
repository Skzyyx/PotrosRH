/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Candidato;
import Exceptions.AccesoDatosException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Candidato. Proporciona los métodos necesarios para realizar operaciones CRUD
 * básicas como registrar, consultar y recuperar todos los candidatos de la base
 * de datos.
 *
 * Esta interfaz es implementada por las clases que proporcionan acceso a los
 * datos de candidatos, independientemente del sistema de almacenamiento
 * utilizado.
 *
 * @author Jose Luis Islas Molina 252574
 */
public interface ICandidatoDAO {

    /**
     * Registra un nuevo candidato en el sistema de persistencia.
     *
     * @param candidato El objeto Candidato que se va a registrar
     * @return El objeto Candidato registrado, posiblemente con identificadores
     * generados
     * @throws AccesoDatosException Si ocurre un error durante el registro o si
     * ya existe un candidato con el mismo RFC
     */
    Candidato registrarCandidato(Candidato candidato) throws AccesoDatosException;

    /**
     * Busca y recupera un candidato según su RFC.
     *
     * @param rfc El RFC del candidato a buscar
     * @return El objeto Candidato encontrado, o null si no existe
     * @throws AccesoDatosException Si ocurre un error durante la consulta
     */
    Candidato obtenerCandidato(String rfc) throws AccesoDatosException;

    /**
     * Recupera todos los candidatos almacenados en el sistema.
     *
     * @return Una lista con todos los objetos Candidato disponibles
     * @throws AccesoDatosException Si ocurre un error durante la consulta
     */
    List<Candidato> obtenerTodos() throws AccesoDatosException;
}
