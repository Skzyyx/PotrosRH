package mappers;

import Entidades.ReporteMalaConducta;
import dto.ReporteMalaConductaDTO;
import Enums.EstadoReporte;
import dto.EmpleadoDTO;
import org.bson.types.ObjectId;

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
        reporteMalaConducta.setEmpleadoReportado(new ObjectId(nuevoReporteDTO.getEmpleadoReportado().getId()));
        reporteMalaConducta.setEmpleadoReportante(new ObjectId(nuevoReporteDTO.getEmpleadoReportante().getId()));
        reporteMalaConducta.setFechaHoraIncidente(nuevoReporteDTO.getFechaHoraIncidente());
        reporteMalaConducta.setLugarIncidente(nuevoReporteDTO.getLugarIncidente());
        reporteMalaConducta.setDescripcionDetallada(nuevoReporteDTO.getDescripcionDetallada());
        
        if(nuevoReporteDTO.getTestigos() != null && !nuevoReporteDTO.getTestigos().isEmpty())
            reporteMalaConducta.setTestigos(nuevoReporteDTO.getTestigos());
        
        reporteMalaConducta.setImpactoIncidente(nuevoReporteDTO.getImpactoIncidente());
        
        if(nuevoReporteDTO.getAccionesPrevias() != null && !nuevoReporteDTO.getAccionesPrevias().trim().isEmpty())
            reporteMalaConducta.setAccionesPrevias(nuevoReporteDTO.getAccionesPrevias());
        
        reporteMalaConducta.setFechaRegistro(nuevoReporteDTO.getFechaRegistro());
        reporteMalaConducta.setEstadoReporte(EstadoReporte.NO_REVISADO);
        reporteMalaConducta.setNumeroSeguimiento(nuevoReporteDTO.getNumeroSeguimiento());
        // Se retorna la entidad mapeada.
        return reporteMalaConducta;
    }
    /**
     * Mapea el DTO recibido a una vieja entidad ReporteMalaConducta.
     * @param viejoReporteDTO ReporteDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteMalaConducta toEntityViejo(ReporteMalaConductaDTO viejoReporteDTO){
        ReporteMalaConducta reporteMalaConducta = new ReporteMalaConducta();
        reporteMalaConducta.setId(new ObjectId(viejoReporteDTO.getId()));
        reporteMalaConducta.setEmpleadoReportado(new ObjectId(viejoReporteDTO.getEmpleadoReportado().getId()));
        reporteMalaConducta.setEmpleadoReportante(new ObjectId(viejoReporteDTO.getEmpleadoReportante().getId()));
        reporteMalaConducta.setFechaHoraIncidente(viejoReporteDTO.getFechaHoraIncidente());
        reporteMalaConducta.setLugarIncidente(viejoReporteDTO.getLugarIncidente());
        reporteMalaConducta.setDescripcionDetallada(viejoReporteDTO.getDescripcionDetallada());
        
        if(viejoReporteDTO.getTestigos() != null && !viejoReporteDTO.getTestigos().isEmpty())
            reporteMalaConducta.setTestigos(viejoReporteDTO.getTestigos());
        
        reporteMalaConducta.setImpactoIncidente(viejoReporteDTO.getImpactoIncidente());
        
        if(viejoReporteDTO.getAccionesPrevias() != null && !viejoReporteDTO.getAccionesPrevias().trim().isEmpty())
            reporteMalaConducta.setAccionesPrevias(viejoReporteDTO.getAccionesPrevias());
        
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
        reporteMalaConductaDTO.setId(viejoReporte.getId().toHexString());
        
        EmpleadoDTO empleadoReportado = new EmpleadoDTO();
        empleadoReportado.setId(viejoReporte.getEmpleadoReportado().toHexString());;
        reporteMalaConductaDTO.setEmpleadoReportado(empleadoReportado);
        
        EmpleadoDTO empleadoReportante = new EmpleadoDTO();
        empleadoReportante.setId(viejoReporte.getEmpleadoReportante().toHexString());;
        reporteMalaConductaDTO.setEmpleadoReportante(empleadoReportante);
        
        reporteMalaConductaDTO.setFechaHoraIncidente(viejoReporte.getFechaHoraIncidente());
        reporteMalaConductaDTO.setLugarIncidente(viejoReporte.getLugarIncidente());
        reporteMalaConductaDTO.setDescripcionDetallada(viejoReporte.getDescripcionDetallada());
        
        if(viejoReporte.getTestigos() != null && !viejoReporte.getTestigos().isEmpty())
            reporteMalaConductaDTO.setTestigos(viejoReporte.getTestigos());
        
        reporteMalaConductaDTO.setImpactoIncidente(viejoReporte.getImpactoIncidente());
        
        if(viejoReporte.getAccionesPrevias() != null && !viejoReporte.getAccionesPrevias().trim().isEmpty())
            reporteMalaConductaDTO.setAccionesPrevias(viejoReporte.getAccionesPrevias());
        
        reporteMalaConductaDTO.setFechaRegistro(viejoReporte.getFechaRegistro());
        reporteMalaConductaDTO.setEstadoReporte(viejoReporte.getEstadoReporte().toString());
        reporteMalaConductaDTO.setNumeroSeguimiento(viejoReporte.getNumeroSeguimiento());
        
        return reporteMalaConductaDTO;
    }
}