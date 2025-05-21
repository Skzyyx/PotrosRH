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
 *
 * @author skyro
 */
public class ContratoMapper {
    
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
