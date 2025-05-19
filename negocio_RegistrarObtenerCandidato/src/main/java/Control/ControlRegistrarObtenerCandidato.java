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
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class ControlRegistrarObtenerCandidato {
    
    private static ICandidatoBO candidatoBO = CandidatoBO.getInstance();
    
    public Boolean validarDatosCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException { 
        
        for (Field field : candidato.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            // Filtrar atributos que no quieres validar
            if (field.getName().equals("id")) continue;

            try {
                if (field.get(candidato) == null) {
                    throw new RegistrarObtenerCandidatoException("El campo '" + field.getName() + "' no puede ser nulo.");
                }
            } catch (IllegalAccessException e) {
                throw new RegistrarObtenerCandidatoException("Error al acceder al campo: " + field.getName());
            }
        }
        
        if (!candidato.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) 
            throw new RegistrarObtenerCandidatoException("El correo no tiene el formato correcto");
        
        if (candidato.getTelefono().trim().length() < 10) 
            throw new RegistrarObtenerCandidatoException("El teléfono puede tener hasta máximo 10 dígitos");
        
        if(!candidato.getRfc().matches("^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$"))
            throw new RegistrarObtenerCandidatoException("RFC con formato inválido.");
        return true;
    }
    
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {
        
        try {
            return candidatoBO.registrarCandidato(candidato);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }
    
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws RegistrarObtenerCandidatoException {
        
        if (candidato.getRfc() == null) 
            throw new RegistrarObtenerCandidatoException("El RFC no puede ser nulo.");
        
        try {
            return candidatoBO.obtenerCandidato(candidato);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrarObtenerCandidatoException(ex.getMessage());
        }
    }
}
