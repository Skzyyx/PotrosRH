package mappers;

import Entidades.ReporteMalaConducta;
import dto.ReporteMalaConductaDTO;
import enums.EstadoReporte;

/**
 * Clase que mapea entidades ReporteMalaConducta a 
 * ReporteMalaConductaDTO, y viceversa.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteMalaConductaMapper {
    /**
     * Mapea el DTO recibido a una nueva entidad ReporteMalaConducta.
     * No obtiene el número de seguimiento, ya que este se genera en la clase DAO, 
     * debido a que requiere acceder a la base de datos para verificar que no exista
     * otro número igual registrado (aunque es poco probable, pero igual se verifica)
     * @param nuevoReporteDTO ReporteDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteMalaConducta toEntityNuevo(ReporteMalaConductaDTO nuevoReporteDTO){
        ReporteMalaConducta reporteMalaConducta = new ReporteMalaConducta();
        reporteMalaConducta.setEmpleadoReportante(EmpleadoMapper.toEntityViejo(nuevoReporteDTO.getEmpleadoReportante()));
        reporteMalaConducta.setEmpleadoReportado(EmpleadoMapper.toEntityViejo(nuevoReporteDTO.getEmpleadoReportado()));
        reporteMalaConducta.setFechaHoraIncidente(nuevoReporteDTO.getFechaHoraIncidente());
        reporteMalaConducta.setLugarIncidente(nuevoReporteDTO.getLugarIncidente());
        reporteMalaConducta.setDescripcionDetallada(nuevoReporteDTO.getDescripcionDetallada());
        if(nuevoReporteDTO.getTestigos() != null && !nuevoReporteDTO.getTestigos().isEmpty())
            reporteMalaConducta.setTestigos(nuevoReporteDTO.getTestigos());
        
        reporteMalaConducta.setAccionesPrevias(nuevoReporteDTO.getAccionesPrevias());
        reporteMalaConducta.setImpactoAccidente(nuevoReporteDTO.getImpactoAccidente());
        reporteMalaConducta.setFechaRegistro(nuevoReporteDTO.getFechaRegistro());
        reporteMalaConducta.setEstadoReporte(EstadoReporte.NO_REVISADO);
        
        return reporteMalaConducta;
    }
    /**
     * Mapea el DTO recibido a una vieja entidad ReporteMalaConducta.
     * @param viejoReporteDTO ReporteDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteMalaConducta toEntityViejo(ReporteMalaConductaDTO viejoReporteDTO){
        ReporteMalaConducta reporteMalaConducta = new ReporteMalaConducta();
        reporteMalaConducta.setEmpleadoReportante(EmpleadoMapper.toEntityViejo(viejoReporteDTO.getEmpleadoReportante()));
        reporteMalaConducta.setEmpleadoReportado(EmpleadoMapper.toEntityViejo(viejoReporteDTO.getEmpleadoReportado()));
        reporteMalaConducta.setFechaHoraIncidente(viejoReporteDTO.getFechaHoraIncidente());
        reporteMalaConducta.setLugarIncidente(viejoReporteDTO.getLugarIncidente());
        reporteMalaConducta.setDescripcionDetallada(viejoReporteDTO.getDescripcionDetallada());
        if(viejoReporteDTO.getTestigos() != null && !viejoReporteDTO.getTestigos().isEmpty())
            reporteMalaConducta.setTestigos(viejoReporteDTO.getTestigos());
        
        reporteMalaConducta.setAccionesPrevias(viejoReporteDTO.getAccionesPrevias());
        reporteMalaConducta.setImpactoAccidente(viejoReporteDTO.getImpactoAccidente());
        reporteMalaConducta.setFechaRegistro(viejoReporteDTO.getFechaRegistro());
        reporteMalaConducta.setEstadoReporte(EstadoReporte.valueOf(viejoReporteDTO.getEstadoReporte()));
        reporteMalaConducta.setNumeroSeguimiento(viejoReporteDTO.getNumeroSeguimiento());
        
        return reporteMalaConducta;
    }
    /**
     * Mapea la entidad recibida a un objeto de transferencia ReporteMalaConductaDTO.
     * @param viejoReporte ReporteMalaConducta a mapear
     * @return DTO mapeado.
     */
    public static ReporteMalaConductaDTO toDTO(ReporteMalaConducta viejoReporte){
        ReporteMalaConductaDTO reporteMalaConductaDTO = new ReporteMalaConductaDTO();
        reporteMalaConductaDTO.setEmpleadoReportante(EmpleadoMapper.toDTO(viejoReporte.getEmpleadoReportante()));
        reporteMalaConductaDTO.setEmpleadoReportado(EmpleadoMapper.toDTO(viejoReporte.getEmpleadoReportado()));
        reporteMalaConductaDTO.setFechaHoraIncidente(viejoReporte.getFechaHoraIncidente());
        reporteMalaConductaDTO.setLugarIncidente(viejoReporte.getLugarIncidente());
        reporteMalaConductaDTO.setDescripcionDetallada(viejoReporte.getDescripcionDetallada());
        if(viejoReporte.getTestigos() != null && !viejoReporte.getTestigos().isEmpty())
            reporteMalaConductaDTO.setTestigos(viejoReporte.getTestigos());
        
        reporteMalaConductaDTO.setAccionesPrevias(viejoReporte.getAccionesPrevias());
        reporteMalaConductaDTO.setImpactoAccidente(viejoReporte.getImpactoAccidente());
        reporteMalaConductaDTO.setFechaRegistro(viejoReporte.getFechaRegistro());
        reporteMalaConductaDTO.setEstadoReporte(viejoReporte.getEstadoReporte().toString());
        reporteMalaConductaDTO.setNumeroSeguimiento(viejoReporte.getNumeroSeguimiento());
        
        return reporteMalaConductaDTO;
    }
}