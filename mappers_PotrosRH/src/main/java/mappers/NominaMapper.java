package mappers;

import Entidades.Nomina;
import dto.NominaDTO;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaMapper {
    
    public static Nomina toEntityNuevo(NominaDTO nominaDTO){
        Nomina nomina = new Nomina();
        nomina.setEmpleado(EmpleadoMapper.toEntityViejo(nominaDTO.getEmpleado()));
        nomina.setBono(nominaDTO.getBono());
        nomina.setFechaCorte(nominaDTO.getFechaCorte());
        nomina.setDiasTrabajados(nominaDTO.getDiasTrabajados());
        nomina.setHorasTrabajadas(nominaDTO.getHorasTrabajadas());
        nomina.setHorasExtra(nominaDTO.getHorasExtra());
        nomina.setIsr(nominaDTO.getIsr());
        nomina.setSalarioBruto(nominaDTO.getSalarioBruto());
        nomina.setSalarioNeto(nominaDTO.getSalarioNeto());
        nomina.setEstadoCobro(nominaDTO.getEstadoCobro());
        
        return nomina;
    }
    
    public static Nomina toEntityViejo(NominaDTO nominaDTO){
        Nomina nomina = new Nomina();
        // Falta el ID.
        nomina.setEmpleado(EmpleadoMapper.toEntityViejo(nominaDTO.getEmpleado()));
        nomina.setBono(nominaDTO.getBono());
        nomina.setFechaCorte(nominaDTO.getFechaCorte());
        nomina.setDiasTrabajados(nominaDTO.getDiasTrabajados());
        nomina.setHorasTrabajadas(nominaDTO.getHorasTrabajadas());
        nomina.setHorasExtra(nominaDTO.getHorasExtra());
        nomina.setIsr(nominaDTO.getIsr());
        nomina.setSalarioBruto(nominaDTO.getSalarioBruto());
        nomina.setSalarioNeto(nominaDTO.getSalarioNeto());
        nomina.setEstadoCobro(nominaDTO.getEstadoCobro());
        
        return nomina;
    }
    
    public static NominaDTO toDTO(Nomina nomina){
        // Falta el ID.
        NominaDTO nominaDTO = new NominaDTO();
        nominaDTO.setEmpleado(EmpleadoMapper.toDTO(nomina.getEmpleado()));
        nominaDTO.setBono(nomina.getBono());
        nominaDTO.setFechaCorte(nomina.getFechaCorte());
        nominaDTO.setDiasTrabajados(nomina.getDiasTrabajados());
        nominaDTO.setHorasTrabajadas(nomina.getHorasTrabajadas());
        nominaDTO.setHorasExtra(nomina.getHorasExtra());
        nominaDTO.setIsr(nomina.getIsr());
        nominaDTO.setSalarioBruto(nomina.getSalarioBruto());
        nominaDTO.setSalarioNeto(nomina.getSalarioNeto());
        nominaDTO.setEstadoCobro(nomina.getEstadoCobro());  
        
        return nominaDTO;
    }
}