/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Entidades.Contrato;
import Enums.ModoPago;
import Enums.PeriodoPago;
import Enums.TipoContrato;
import dto.ContratoDTO;
import org.bson.types.ObjectId;

/**
 * Clase que proporciona métodos para mapear entre objetos Contrato (entidad) y
 * ContratoDTO (objeto de transferencia de datos). Facilita la conversión entre
 * la capa de dominio y la capa de presentación o servicio.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ContratoMapper {

    /**
     * Convierte un objeto ContratoDTO a un objeto Contrato para nuevos
     * registros. Este método se utiliza cuando se va a crear un nuevo contrato
     * y no tiene ID asignado.
     *
     * @param dto El objeto ContratoDTO a convertir
     * @return Un nuevo objeto Contrato con los datos del DTO
     */
    public static Contrato toEntityNuevo(ContratoDTO dto) {
        return new Contrato(
                dto.getDepartamento(),
                TipoContrato.valueOf(dto.getTipoContrato()),
                dto.getLugarTrabajo(),
                dto.getFechaInicio(),
                dto.getFechaFin(),
                dto.getPuesto(),
                dto.getSueldo(),
                PeriodoPago.valueOf(dto.getPeriodoPago()),
                ModoPago.valueOf(dto.getModoPago()),
                EmpleadoMapper.toEntityViejo(dto.getEmpleado()),
                HorarioLaboralMapper.toEntitySet(dto.getHorarios())
        );
    }

    /**
     * Convierte un objeto ContratoDTO a un objeto Contrato para registros
     * existentes. Este método se utiliza cuando se va a actualizar un contrato
     * existente que ya tiene ID.
     *
     * @param dto El objeto ContratoDTO a convertir
     * @return Un objeto Contrato con los datos del DTO, incluyendo el ID
     */
    public static Contrato toEntityViejo(ContratoDTO dto) {
        return new Contrato(
                new ObjectId(dto.getId()),
                dto.getDepartamento(),
                TipoContrato.valueOf(dto.getTipoContrato()),
                dto.getLugarTrabajo(),
                dto.getFechaInicio(),
                dto.getFechaFin(),
                dto.getPuesto(),
                dto.getSueldo(),
                PeriodoPago.valueOf(dto.getPeriodoPago()),
                ModoPago.valueOf(dto.getModoPago()),
                EmpleadoMapper.toEntityViejo(dto.getEmpleado()),
                HorarioLaboralMapper.toEntitySet(dto.getHorarios())
        );
    }

    /**
     * Convierte un objeto Contrato a un objeto ContratoDTO. Este método se
     * utiliza para transformar una entidad de dominio en un objeto de
     * transferencia de datos que puede ser enviado a la capa de presentación.
     *
     * @param contrato El objeto Contrato a convertir
     * @return Un objeto ContratoDTO con los datos de la entidad
     */
    public static ContratoDTO toDTO(Contrato contrato) {
        return new ContratoDTO(
                contrato.getId().toString(),
                contrato.getDepartamento(),
                contrato.getTipoContrato().toString(),
                contrato.getLugarTrabajo(),
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getPuesto(),
                contrato.getSueldo(),
                contrato.getPeriodoPago().toString(),
                contrato.getModoPago().toString(),
                EmpleadoMapper.toDTO(contrato.getEmpleado()),
                HorarioLaboralMapper.toDTOSet(contrato.getHorarios())
        );
    }
}
