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
 * Clase que proporciona métodos para mapear entre objetos Candidato (entidad) y
 * CandidatoDTO (objeto de transferencia de datos). Facilita la conversión entre
 * la capa de dominio y la capa de presentación o servicio.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class CandidatoMapper {

    /**
     * Convierte un objeto CandidatoDTO a un objeto Candidato para nuevos
     * registros. Este método se utiliza cuando se va a crear un nuevo candidato
     * y no tiene ID asignado.
     *
     * @param dto El objeto CandidatoDTO a convertir
     * @return Un nuevo objeto Candidato con los datos del DTO
     */
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

    /**
     * Convierte un objeto CandidatoDTO a un objeto Candidato para registros
     * existentes. Este método se utiliza cuando se va a actualizar un candidato
     * existente que ya tiene ID.
     *
     * @param dto El objeto CandidatoDTO a convertir
     * @return Un objeto Candidato con los datos del DTO, incluyendo el ID
     */
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

    /**
     * Convierte un objeto Candidato a un objeto CandidatoDTO para registros
     * existentes. Este método incluye el ID en el DTO resultante.
     *
     * @param candidato El objeto Candidato a convertir
     * @return Un objeto CandidatoDTO con los datos de la entidad, incluyendo el
     * ID
     */
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

    /**
     * Convierte un objeto Candidato a un objeto CandidatoDTO para nuevos
     * registros. Este método no incluye el ID en el DTO resultante.
     *
     * @param candidato El objeto Candidato a convertir
     * @return Un objeto CandidatoDTO con los datos de la entidad, sin incluir
     * el ID
     */
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

    /**
     * Convierte una lista de objetos Candidato a una lista de objetos
     * CandidatoDTO. Este método incluye el ID en los DTOs resultantes.
     *
     * @param candidatos La lista de objetos Candidato a convertir
     * @return Una lista de objetos CandidatoDTO con los datos de las entidades
     */
    public static List<CandidatoDTO> toDTOViejoList(List<Candidato> candidatos) {
        List<CandidatoDTO> dtos = new ArrayList<>();
        for (Candidato c : candidatos) {
            dtos.add(toDTOViejo(c));
        }
        return dtos;
    }
}
