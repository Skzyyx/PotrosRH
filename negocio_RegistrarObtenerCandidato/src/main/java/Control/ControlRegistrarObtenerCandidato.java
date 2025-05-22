/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Exceptions.ObjetosNegocioException;
import Exceptions.RegistrarObtenerCandidatoException;
import Interfaces.ICandidatoBO;
import bo.CandidatoBO;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador para las operaciones de registro y obtención de candidatos.
 * Valida los datos del candidato y maneja las excepciones relacionadas.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ControlRegistrarObtenerCandidato {

    private static ICandidatoBO candidatoBO = CandidatoBO.getInstance();

    /**
     * Valida los datos de un candidato antes de su registro.
     * 
     * @param candidato El DTO del candidato a validar
     * @return true si todos los datos son válidos
     * @throws RegistrarObtenerCandidatoException Si algún campo es inválido o nulo
     */
    public Boolean validarDatosCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {

        for (Field field : candidato.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            // Filtrar atributos que no quieres validar
            if (field.getName().equals("id")) {
                continue;
            }

            try {
                if (field.get(candidato) == null) {
                    throw new RegistrarObtenerCandidatoException("El campo '" + field.getName() + "' no puede ser nulo.");
                }
            } catch (IllegalAccessException e) {
                throw new RegistrarObtenerCandidatoException("Error al acceder al campo: " + field.getName());
            }
        }

        if (!candidato.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new RegistrarObtenerCandidatoException("El correo no tiene el formato correcto");
        }

        if (candidato.getTelefono().trim().length() < 10) {
            throw new RegistrarObtenerCandidatoException("El teléfono puede tener hasta máximo 10 dígitos");
        }

        if (!candidato.getRfc().matches("^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$")) {
            throw new RegistrarObtenerCandidatoException("RFC con formato inválido.");
        }

        if (!candidato.getCurp().matches("^[A-Z][AEIOU][A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]\\d$")) {
            throw new RegistrarObtenerCandidatoException("CURP con formato inválido.");
        }
        return true;
    }

    /**
     * Registra un nuevo candidato en el sistema.
     * 
     * @param candidato El DTO del candidato a registrar
     * @return El candidato registrado
     * @throws RegistrarObtenerCandidatoException Si ocurre un error durante el registro
     */
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {

        try {
            return candidatoBO.registrarCandidato(candidato);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }

    /**
     * Obtiene un candidato del sistema basado en su RFC.
     * 
     * @param candidato El DTO del candidato con el RFC a buscar
     * @return El candidato encontrado
     * @throws RegistrarObtenerCandidatoException Si el RFC es nulo o ocurre un error
     */
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {

        if (candidato.getRfc() == null) {
            throw new RegistrarObtenerCandidatoException("El RFC no puede ser nulo.");
        }

        try {
            return candidatoBO.obtenerCandidato(candidato);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }

    /**
     * Obtiene todos los candidatos registrados en el sistema.
     * 
     * @return Lista de todos los candidatos
     * @throws RegistrarObtenerCandidatoException Si ocurre un error al obtener los candidatos
     */
    public List<CandidatoDTO> obtenerTodos() throws RegistrarObtenerCandidatoException {
        try {
            return candidatoBO.obtenerTodos();
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }

    /**
     * Obtiene candidatos que coinciden con los criterios de filtrado.
     * 
     * @param filtro Los criterios de búsqueda
     * @return Lista de candidatos que coinciden con el filtro
     * @throws RegistrarObtenerCandidatoException Si ocurre un error durante la búsqueda
     */
    public List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws RegistrarObtenerCandidatoException {
        try {
            return candidatoBO.obtenerPorFiltro(filtro);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }
}
