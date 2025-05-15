package mappers;

import Entidades.ReporteRevisado;
import Entidades.ReporteRevisadoOmitido;
import Entidades.ReporteRevisadoSancionado;
import dto.ReporteRevisadoDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import Enums.GravedadSancion;

/**
 * Clase que mapea entidades ReporteRevisadoSancionado y ReporteRevisadoOmitido a 
 * ReporteRevisadoSancionadoDTO y ReporteRevisadoOmitidoDTO respectivamente, y viceversa.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoMapper {
    /**
     * Mapea el DTO recibido a una nueva entidad ReporteRevisadoSancionado.
     * @param reporteSancionadoNuevoDTO ReporteRevisadoSancionadoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoSancionado toEntityNuevoSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevoDTO){
        ReporteRevisadoSancionado reporteRevisadoSancionado = (ReporteRevisadoSancionado) toEntityNuevo(reporteSancionadoNuevoDTO);
        reporteRevisadoSancionado.setNormasVioladas(reporteSancionadoNuevoDTO.getNormasVioladas());
        reporteRevisadoSancionado.setNivelGravedad(GravedadSancion.valueOf(reporteSancionadoNuevoDTO.getNivelGravedad()));
        reporteRevisadoSancionado.setSancionImpuesta(reporteSancionadoNuevoDTO.getSancionImpuesta());
        if(reporteSancionadoNuevoDTO.getDescripcionOtraSancionImpuesta() != null)
            reporteRevisadoSancionado.setDescripcionOtraSancionImpuesta(reporteSancionadoNuevoDTO.getDescripcionOtraSancionImpuesta());
        
        return reporteRevisadoSancionado;
    }
    /**
     * Mapea el DTO recibido a una entidad ReporteRevisadoSancionado.
     * @param reporteSancionadoViejoDTO ReporteRevisadoSancionadoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoSancionado toEntityViejoSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoViejoDTO){
        ReporteRevisadoSancionado reporteRevisadoSancionado = (ReporteRevisadoSancionado) toEntityViejo(reporteSancionadoViejoDTO);
        reporteRevisadoSancionado.setNormasVioladas(reporteSancionadoViejoDTO.getNormasVioladas());
        reporteRevisadoSancionado.setNivelGravedad(GravedadSancion.valueOf(reporteSancionadoViejoDTO.getNivelGravedad()));
        reporteRevisadoSancionado.setSancionImpuesta(reporteSancionadoViejoDTO.getSancionImpuesta());
        if(reporteSancionadoViejoDTO.getDescripcionOtraSancionImpuesta() != null)
            reporteRevisadoSancionado.setDescripcionOtraSancionImpuesta(reporteSancionadoViejoDTO.getDescripcionOtraSancionImpuesta());
        
        return reporteRevisadoSancionado;
    }
    /**
     * Mapea la entidad recibida a un objeto de transferencia ReporteRevisadoSancionadoDTO.
     * @param reporteSancionado Entidad ReporteRevisadoSancionado a mapear.
     * @return DTO mapeado.
     */
    public static ReporteRevisadoSancionadoDTO toDTOSancionado(ReporteRevisadoSancionado reporteSancionado){
        ReporteRevisadoSancionadoDTO reporteRevisadoSancionadoDTO = (ReporteRevisadoSancionadoDTO) toDTO(reporteSancionado);
        reporteRevisadoSancionadoDTO.setNormasVioladas(reporteSancionado.getNormasVioladas());
        reporteRevisadoSancionadoDTO.setNivelGravedad(reporteSancionado.getNivelGravedad().toString());
        reporteRevisadoSancionadoDTO.setSancionImpuesta(reporteSancionado.getSancionImpuesta());
        if(reporteSancionado.getDescripcionOtraSancionImpuesta() != null)
            reporteRevisadoSancionadoDTO.setDescripcionOtraSancionImpuesta(reporteSancionado.getDescripcionOtraSancionImpuesta());
        
        return reporteRevisadoSancionadoDTO;
    }
    /**
     * Mapea el DTO recibido a una nueva entidad ReporteRevisadoOmitido.
     * @param reporteOmitidoNuevoDTO ReporteRevisadoOmitidoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoOmitido toEntityNuevoOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevoDTO){
        ReporteRevisadoOmitido reporteRevisadoOmitido = (ReporteRevisadoOmitido) toEntityNuevo(reporteOmitidoNuevoDTO);
        reporteRevisadoOmitido.setMotivoOmision(reporteOmitidoNuevoDTO.getMotivoOmision());
        
        return reporteRevisadoOmitido;
    }
    /**
     * Mapea el DTO recibido a una entidad ReporteRevisadoOmitido.
     * @param reporteOmitidoViejoDTO ReporteRevisadoOmitidoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoOmitido toEntityViejoOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoViejoDTO){
        ReporteRevisadoOmitido reporteRevisadoOmitido = (ReporteRevisadoOmitido) toEntityViejo(reporteOmitidoViejoDTO);
        reporteRevisadoOmitido.setMotivoOmision(reporteOmitidoViejoDTO.getMotivoOmision());
        
        return reporteRevisadoOmitido;
    }
    /**
     * Mapea la entidad recibida a un objeto de transferencia ReporteRevisadoOmitidoDTO.
     * @param reporteOmitido Entidad ReporteRevisadoOmitido a mapear.
     * @return DTO mapeado.
     */
    public static ReporteRevisadoOmitidoDTO toDTOOmitido(ReporteRevisadoOmitido reporteOmitido){
        ReporteRevisadoOmitidoDTO reporteRevisadoOmitidoDTO = (ReporteRevisadoOmitidoDTO) toDTO(reporteOmitido);
        reporteRevisadoOmitidoDTO.setMotivoOmision(reporteOmitido.getMotivoOmision());
        
        return reporteRevisadoOmitidoDTO;
    }
    /**
     * Mapea el DTO recibido a una nueva entidad ReporteRevisado.
     * @param nuevoReporteDTO ReporteRevisado a mapear.
     * @return Entidad mapeada.
     */
    private static ReporteRevisado toEntityNuevo(ReporteRevisadoDTO nuevoReporteDTO){
        ReporteRevisado reporteRevisado = new ReporteRevisado();
        reporteRevisado.setReporteMalaConducta(ReporteMalaConductaMapper.toEntityViejo(nuevoReporteDTO.getReporteMalaConducta()));
        reporteRevisado.setInfoCompleta(nuevoReporteDTO.isInfoCompleta());
        reporteRevisado.setTieneAntecedentesPrevios(nuevoReporteDTO.isTieneAntecedentesPrevios());
        if(nuevoReporteDTO.getDescripcionAntecedentesPrevios() != null)
            reporteRevisado.setDescripcionAntecedentesPrevios(nuevoReporteDTO.getDescripcionAntecedentesPrevios());
        
        reporteRevisado.setEntrevistasRealizadas(nuevoReporteDTO.getEntrevistasRealizadas());
        if(nuevoReporteDTO.getDescripcionOtrasEntrevistasRealizadas() != null)
            reporteRevisado.setDescripcionOtrasEntrevistasRealizadas(nuevoReporteDTO.getDescripcionOtrasEntrevistasRealizadas());
        
        reporteRevisado.setEvidenciasRevisadas(nuevoReporteDTO.getEvidenciasRevisadas());
        if(nuevoReporteDTO.getDescripcionOtrasEvidencias() != null)
            reporteRevisado.setDescripcionOtrasEvidencias(nuevoReporteDTO.getDescripcionOtrasEvidencias());
        
        return reporteRevisado;
    }
    
    /**
     * Mapea el DTO recibido a una entidad ReporteRevisado.
     * @param viejoReporteDTO ReporteRevisado a mapear.
     * @return Entidad mapeada.
     */
    private static ReporteRevisado toEntityViejo(ReporteRevisadoDTO viejoReporteDTO){
        ReporteRevisado reporteRevisado = new ReporteRevisado();
        reporteRevisado.setReporteMalaConducta(ReporteMalaConductaMapper.toEntityViejo(viejoReporteDTO.getReporteMalaConducta()));
        reporteRevisado.setInfoCompleta(viejoReporteDTO.isInfoCompleta());
        reporteRevisado.setTieneAntecedentesPrevios(viejoReporteDTO.isTieneAntecedentesPrevios());
        if(viejoReporteDTO.getDescripcionAntecedentesPrevios() != null)
            reporteRevisado.setDescripcionAntecedentesPrevios(viejoReporteDTO.getDescripcionAntecedentesPrevios());
        
        reporteRevisado.setEntrevistasRealizadas(viejoReporteDTO.getEntrevistasRealizadas());
        if(viejoReporteDTO.getDescripcionOtrasEntrevistasRealizadas() != null)
            reporteRevisado.setDescripcionOtrasEntrevistasRealizadas(viejoReporteDTO.getDescripcionOtrasEntrevistasRealizadas());
        
        reporteRevisado.setEvidenciasRevisadas(viejoReporteDTO.getEvidenciasRevisadas());
        if(viejoReporteDTO.getDescripcionOtrasEvidencias() != null)
            reporteRevisado.setDescripcionOtrasEvidencias(viejoReporteDTO.getDescripcionOtrasEvidencias());
        
        return reporteRevisado;
    }
    
    /**
     * Mapea el DTO recibido a una entidad ReporteRevisado.
     * @param viejoReporte ReporteRevisado a mapear.
     * @return Entidad mapeada.
     */
    private static ReporteRevisadoDTO toDTO(ReporteRevisado viejoReporte){
        ReporteRevisadoDTO reporteRevisadoDTO = new ReporteRevisadoDTO();
        reporteRevisadoDTO.setReporteMalaConducta(ReporteMalaConductaMapper.toDTO(viejoReporte.getReporteMalaConducta()));
        reporteRevisadoDTO.setInfoCompleta(viejoReporte.isInfoCompleta());
        reporteRevisadoDTO.setTieneAntecedentesPrevios(viejoReporte.isTieneAntecedentesPrevios());
        if(viejoReporte.getDescripcionAntecedentesPrevios() != null)
            reporteRevisadoDTO.setDescripcionAntecedentesPrevios(viejoReporte.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoDTO.setEntrevistasRealizadas(viejoReporte.getEntrevistasRealizadas());
        if(viejoReporte.getDescripcionOtrasEntrevistasRealizadas() != null)
            reporteRevisadoDTO.setDescripcionOtrasEntrevistasRealizadas(viejoReporte.getDescripcionOtrasEntrevistasRealizadas());
        
        reporteRevisadoDTO.setEvidenciasRevisadas(viejoReporte.getEvidenciasRevisadas());
        if(viejoReporte.getDescripcionOtrasEvidencias() != null)
            reporteRevisadoDTO.setDescripcionOtrasEvidencias(viejoReporte.getDescripcionOtrasEvidencias());
        
        return reporteRevisadoDTO;
    }
}