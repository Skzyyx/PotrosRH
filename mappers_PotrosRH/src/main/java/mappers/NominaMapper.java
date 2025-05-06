package mappers;

import Entidades.Nomina;
import dto.NominaDTO;

/**
 *
 * @author PC WHITE WOLF
 */
public class NominaMapper {
    
    public static Nomina toEntityNuevo(NominaDTO nominaDTO){
        Nomina nomina = new Nomina();
        nomina.setEmpleado(EmpleadoMapper.toEntityViejo(nominaDTO.getEmpleado()));
        // faltan dias trabajados
        nomina.setBono(nominaDTO.getBono());
        // falta estado de cobro
        nomina.setFechaCorte(nominaDTO.getFechaCorte());
        nomina.setHorasTrabajadas(nominaDTO.getHorasTrabajadas());
        nomina.setHorasExtra(nominaDTO.getHoraExtra());
        nomina.setIsr(nominaDTO.getIsr());
        nomina.setSalarioBruto(nominaDTO.getSalarioBruto());
        nomina.setSalarioNeto(nominaDTO.getSalarioNeto());
        
        return nomina;
    }
    
    public static Nomina toEntityViejo(NominaDTO nominaDTO){
        Nomina nomina = new Nomina();
        nomina.setEmpleado(EmpleadoMapper.toEntityViejo(nominaDTO.getEmpleado()));
        // faltan dias trabajados
        nomina.setBono(nominaDTO.getBono());
        // falta estado de cobro
        nomina.setFechaCorte(nominaDTO.getFechaCorte());
        nomina.setHorasTrabajadas(nominaDTO.getHorasTrabajadas());
        nomina.setHorasExtra(nominaDTO.getHoraExtra());
        nomina.setIsr(nominaDTO.getIsr());
        nomina.setSalarioBruto(nominaDTO.getSalarioBruto());
        nomina.setSalarioNeto(nominaDTO.getSalarioNeto());
        
        return nomina;
    }
    
    public static NominaDTO toDTO(Nomina nomina){
        NominaDTO nominaDTO = new NominaDTO();
        nominaDTO.setEmpleado(EmpleadoMapper.toDTO(nomina.getEmpleado()));
        // faltan dias trabajados
        nominaDTO.setBono(nomina.getBono());
        // falta estado de cobro
        nominaDTO.setFechaCorte(nomina.getFechaCorte());
        nominaDTO.setHorasTrabajadas(nomina.getHorasTrabajadas());
        //nominaDTO.setHorasExtra(nomina.getHorasExtra().doubleValue());
        nominaDTO.setIsr(nomina.getIsr());
        nominaDTO.setSalarioBruto(nomina.getSalarioBruto());
        nominaDTO.setSalarioNeto(nomina.getSalarioNeto());
        
        return nominaDTO;
    }
}