/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Entidades.Candidato;
import Entidades.Direccion;
import Enums.Sexo;
import dto.CandidatoDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author skyro
 */
public class CandidatoMapper {
    
    public static Candidato toEntityNuevo(CandidatoDTO dto) {
        return new Candidato(
                dto.getNombre(), 
                dto.getApellidoPaterno(), 
                dto.getApellidoMaterno(), 
                dto.getRfc(),
                dto.getCurp(),
                dto.getEmail(), 
                dto.getTelefono(), 
                dto.getFechaNacimiento(),
                Sexo.valueOf(dto.getSexo()),
                new Direccion(dto.getCalle(), dto.getNumero(), dto.getColonia()),
                dto.getExperiencia(),
                dto.getNivelEstudio(), 
                dto.getHabilidadesClave()
        );
    }
    
    public static Candidato toEntityViejo(CandidatoDTO dto) {
        return new Candidato(
                new ObjectId(dto.getId()),
                dto.getNombre(), 
                dto.getApellidoPaterno(), 
                dto.getApellidoMaterno(), 
                dto.getRfc(), 
                dto.getCurp(),
                dto.getEmail(), 
                dto.getTelefono(), 
                dto.getFechaNacimiento(),
                Sexo.valueOf(dto.getSexo()),
                new Direccion(dto.getCalle(), dto.getNumero(), dto.getColonia()),
                dto.getExperiencia(),
                dto.getNivelEstudio(), 
                dto.getHabilidadesClave()
        );
    }
    
    public static CandidatoDTO toDTOViejo(Candidato candidato) {
        return new CandidatoDTO(
                candidato.getId().toString(),
                candidato.getNombre(), 
                candidato.getApellidoPaterno(), 
                candidato.getApellidoMaterno(), 
                candidato.getRfc(), 
                candidato.getCurp(),
                candidato.getEmail(), 
                candidato.getTelefono(), 
                candidato.getFechaNacimiento(),
                candidato.getSexo().toString(), 
                candidato.getDireccion().getCalle(),
                candidato.getDireccion().getNumero(),
                candidato.getDireccion().getColonia(),
                candidato.getExperiencia(),
                candidato.getNivelEstudio(), 
                candidato.getHabilidadesClave()
        );
    }
    
    public static CandidatoDTO toDTONuevo(Candidato candidato) {
        return new CandidatoDTO(
                candidato.getNombre(), 
                candidato.getApellidoPaterno(), 
                candidato.getApellidoMaterno(), 
                candidato.getRfc(), 
                candidato.getCurp(),
                candidato.getEmail(), 
                candidato.getTelefono(), 
                candidato.getFechaNacimiento(),
                candidato.getSexo().toString(), 
                candidato.getDireccion().getCalle(),
                candidato.getDireccion().getNumero(),
                candidato.getDireccion().getColonia(),
                candidato.getExperiencia(),
                candidato.getNivelEstudio(), 
                candidato.getHabilidadesClave()
        );
    }
    
    public static List<CandidatoDTO> toDTOViejoList(List<Candidato> candidatos) {
        List<CandidatoDTO> dtos = new ArrayList<>();
        for (Candidato c : candidatos) {
            dtos.add(toDTOViejo(c));
        }
        return dtos;
    }
}
