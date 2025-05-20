package mappers;

import Entidades.Nomina;
import dto.NominaDTO;
import org.bson.types.ObjectId;

/**
 * Clase que mapea entidades Nomina a NominaDTO, 
 * y viceversa.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaMapper {
    /**
     * Convierte un objeto NominaDTO a Nomina.
     * Pensado para nuevos registros (inserción).
     * @param nominaDTO DTO a mapear.
     * @return Entidad Nomina mapeada.
     */
    public static Nomina toEntityNuevo(NominaDTO nominaDTO){
        Nomina nomina = new Nomina();
        nomina.setEmpleado_id(new ObjectId(nominaDTO.getEmpleado_id()));
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
    /**
     * Convierte un objeto NominaDTO a Nomina.
     * ensado para viejos registros o registros persistidos
     * previamente (actualización).
     * @param nominaDTO DTO a mapear.
     * @return Entidad Nomina mapeada.
     */
    public static Nomina toEntityViejo(NominaDTO nominaDTO){
        Nomina nomina = new Nomina();
        // Falta el ID.
        nomina.setEmpleado_id(new ObjectId(nominaDTO.getEmpleado_id()));
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
    /**
     * Convierte un objeto Nomina a NominaDTO.
     * @param nomina DTO a mapear.
     * @return Objeto NominaDTO mapeado.
     */
    public static NominaDTO toDTO(Nomina nomina){
        // Falta el ID.
        NominaDTO nominaDTO = new NominaDTO();
        nominaDTO.setEmpleado_id(nomina.getEmpleado_id().toHexString());
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