package mappers;

import Entidades.ReporteRevisadoOmitido;
import Entidades.ReporteRevisadoSancionado;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import Enums.GravedadSancion;
import org.bson.types.ObjectId;

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
        ReporteRevisadoSancionado reporteRevisadoSancionado = new ReporteRevisadoSancionado();
        reporteRevisadoSancionado.setReporteMalaConducta(ReporteMalaConductaMapper.toEntityViejo(reporteSancionadoNuevoDTO.getReporteMalaConducta()));
        reporteRevisadoSancionado.setInfoCompleta(reporteSancionadoNuevoDTO.isInfoCompleta());
        reporteRevisadoSancionado.setTieneAntecedentesPrevios(reporteSancionadoNuevoDTO.isTieneAntecedentesPrevios());
        
        if(reporteSancionadoNuevoDTO.getDescripcionAntecedentesPrevios() != null && !reporteSancionadoNuevoDTO.getDescripcionAntecedentesPrevios().isEmpty())
            reporteRevisadoSancionado.setDescripcionAntecedentesPrevios(reporteSancionadoNuevoDTO.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoSancionado.setEntrevistasRealizadas(reporteSancionadoNuevoDTO.getEntrevistasRealizadas());
        reporteRevisadoSancionado.setEvidenciasRevisadas(reporteSancionadoNuevoDTO.getEvidenciasRevisadas());
        
        reporteRevisadoSancionado.setNormasVioladas(reporteSancionadoNuevoDTO.getNormasVioladas());
        reporteRevisadoSancionado.setNivelGravedad(GravedadSancion.valueOf(reporteSancionadoNuevoDTO.getNivelGravedad()));
        reporteRevisadoSancionado.setSancionImpuesta(reporteSancionadoNuevoDTO.getSancionImpuesta());
        
        return reporteRevisadoSancionado;
    }
    /**
     * Mapea el DTO recibido a una entidad ReporteRevisadoSancionado.
     * @param reporteSancionadoViejoDTO ReporteRevisadoSancionadoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoSancionado toEntityViejoSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoViejoDTO){
        ReporteRevisadoSancionado reporteRevisadoSancionado = new ReporteRevisadoSancionado();
        reporteRevisadoSancionado.setId(new ObjectId(reporteSancionadoViejoDTO.getId()));
        reporteRevisadoSancionado.setReporteMalaConducta(ReporteMalaConductaMapper.toEntityViejo(reporteSancionadoViejoDTO.getReporteMalaConducta()));
        reporteRevisadoSancionado.setInfoCompleta(reporteSancionadoViejoDTO.isInfoCompleta());
        reporteRevisadoSancionado.setTieneAntecedentesPrevios(reporteSancionadoViejoDTO.isTieneAntecedentesPrevios());
        
        if(reporteSancionadoViejoDTO.getDescripcionAntecedentesPrevios() != null && !reporteSancionadoViejoDTO.getDescripcionAntecedentesPrevios().isEmpty())
            reporteRevisadoSancionado.setDescripcionAntecedentesPrevios(reporteSancionadoViejoDTO.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoSancionado.setEntrevistasRealizadas(reporteSancionadoViejoDTO.getEntrevistasRealizadas());
        reporteRevisadoSancionado.setEvidenciasRevisadas(reporteSancionadoViejoDTO.getEvidenciasRevisadas());
        
        reporteRevisadoSancionado.setNormasVioladas(reporteSancionadoViejoDTO.getNormasVioladas());
        reporteRevisadoSancionado.setNivelGravedad(GravedadSancion.valueOf(reporteSancionadoViejoDTO.getNivelGravedad()));
        reporteRevisadoSancionado.setSancionImpuesta(reporteSancionadoViejoDTO.getSancionImpuesta());
        
        return reporteRevisadoSancionado;
    }
    /**
     * Mapea la entidad recibida a un objeto de transferencia ReporteRevisadoSancionadoDTO.
     * @param reporteSancionado Entidad ReporteRevisadoSancionado a mapear.
     * @return DTO mapeado.
     */
    public static ReporteRevisadoSancionadoDTO toDTOSancionado(ReporteRevisadoSancionado reporteSancionado){
        ReporteRevisadoSancionadoDTO reporteRevisadoSancionadoDTO = new ReporteRevisadoSancionadoDTO();
        reporteRevisadoSancionadoDTO.setId(reporteSancionado.getId().toHexString());
        reporteRevisadoSancionadoDTO.setReporteMalaConducta(ReporteMalaConductaMapper.toDTO(reporteSancionado.getReporteMalaConducta()));
        reporteRevisadoSancionadoDTO.setInfoCompleta(reporteSancionado.isInfoCompleta());
        reporteRevisadoSancionadoDTO.setTieneAntecedentesPrevios(reporteSancionado.isTieneAntecedentesPrevios());
        
        if(reporteSancionado.getDescripcionAntecedentesPrevios() != null && !reporteSancionado.getDescripcionAntecedentesPrevios().isEmpty())
            reporteRevisadoSancionadoDTO.setDescripcionAntecedentesPrevios(reporteSancionado.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoSancionadoDTO.setEntrevistasRealizadas(reporteSancionado.getEntrevistasRealizadas());
        reporteRevisadoSancionadoDTO.setEvidenciasRevisadas(reporteSancionado.getEvidenciasRevisadas());
        
        reporteRevisadoSancionadoDTO.setNormasVioladas(reporteSancionado.getNormasVioladas());
        reporteRevisadoSancionadoDTO.setNivelGravedad(reporteSancionado.getNivelGravedad().toString());
        reporteRevisadoSancionadoDTO.setSancionImpuesta(reporteSancionado.getSancionImpuesta());
        
        return reporteRevisadoSancionadoDTO;
    }
    /**
     * Mapea el DTO recibido a una nueva entidad ReporteRevisadoOmitido.
     * @param reporteOmitidoNuevoDTO ReporteRevisadoOmitidoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoOmitido toEntityNuevoOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevoDTO){
        ReporteRevisadoOmitido reporteRevisadoOmitido = new ReporteRevisadoOmitido();
        reporteRevisadoOmitido.setReporteMalaConducta(ReporteMalaConductaMapper.toEntityViejo(reporteOmitidoNuevoDTO.getReporteMalaConducta()));
        reporteRevisadoOmitido.setInfoCompleta(reporteOmitidoNuevoDTO.isInfoCompleta());
        reporteRevisadoOmitido.setTieneAntecedentesPrevios(reporteOmitidoNuevoDTO.isTieneAntecedentesPrevios());
        
        if(reporteOmitidoNuevoDTO.getDescripcionAntecedentesPrevios() != null && !reporteOmitidoNuevoDTO.getDescripcionAntecedentesPrevios().isEmpty())
            reporteRevisadoOmitido.setDescripcionAntecedentesPrevios(reporteOmitidoNuevoDTO.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoOmitido.setEntrevistasRealizadas(reporteOmitidoNuevoDTO.getEntrevistasRealizadas());
        reporteRevisadoOmitido.setEvidenciasRevisadas(reporteOmitidoNuevoDTO.getEvidenciasRevisadas());
        
        reporteRevisadoOmitido.setMotivoOmision(reporteOmitidoNuevoDTO.getMotivoOmision());
        
        return reporteRevisadoOmitido;
    }
    /**
     * Mapea el DTO recibido a una entidad ReporteRevisadoOmitido.
     * @param reporteOmitidoViejoDTO ReporteRevisadoOmitidoDTO a mapear.
     * @return Entidad mapeada.
     */
    public static ReporteRevisadoOmitido toEntityViejoOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoViejoDTO){
        ReporteRevisadoOmitido reporteRevisadoOmitido = new ReporteRevisadoOmitido();
        reporteRevisadoOmitido.setId(new ObjectId(reporteOmitidoViejoDTO.getId()));
        reporteRevisadoOmitido.setReporteMalaConducta(ReporteMalaConductaMapper.toEntityViejo(reporteOmitidoViejoDTO.getReporteMalaConducta()));
        reporteRevisadoOmitido.setInfoCompleta(reporteOmitidoViejoDTO.isInfoCompleta());
        reporteRevisadoOmitido.setTieneAntecedentesPrevios(reporteOmitidoViejoDTO.isTieneAntecedentesPrevios());
        
        if(reporteOmitidoViejoDTO.getDescripcionAntecedentesPrevios() != null && !reporteOmitidoViejoDTO.getDescripcionAntecedentesPrevios().isEmpty())
            reporteRevisadoOmitido.setDescripcionAntecedentesPrevios(reporteOmitidoViejoDTO.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoOmitido.setEntrevistasRealizadas(reporteOmitidoViejoDTO.getEntrevistasRealizadas());
        reporteRevisadoOmitido.setEvidenciasRevisadas(reporteOmitidoViejoDTO.getEvidenciasRevisadas());
        
        reporteRevisadoOmitido.setMotivoOmision(reporteOmitidoViejoDTO.getMotivoOmision());
        
        return reporteRevisadoOmitido;
    }
    /**
     * Mapea la entidad recibida a un objeto de transferencia ReporteRevisadoOmitidoDTO.
     * @param reporteOmitido Entidad ReporteRevisadoOmitido a mapear.
     * @return DTO mapeado.
     */
    public static ReporteRevisadoOmitidoDTO toDTOOmitido(ReporteRevisadoOmitido reporteOmitido){
        ReporteRevisadoOmitidoDTO reporteRevisadoOmitidoDTO = new ReporteRevisadoOmitidoDTO();
        reporteRevisadoOmitidoDTO.setId(reporteOmitido.getId().toHexString());
        reporteRevisadoOmitidoDTO.setReporteMalaConducta(ReporteMalaConductaMapper.toDTO(reporteOmitido.getReporteMalaConducta()));
        reporteRevisadoOmitidoDTO.setInfoCompleta(reporteOmitido.isInfoCompleta());
        reporteRevisadoOmitidoDTO.setTieneAntecedentesPrevios(reporteOmitido.isTieneAntecedentesPrevios());
        
        if(reporteOmitido.getDescripcionAntecedentesPrevios() != null && !reporteOmitido.getDescripcionAntecedentesPrevios().isEmpty())
            reporteRevisadoOmitidoDTO.setDescripcionAntecedentesPrevios(reporteOmitido.getDescripcionAntecedentesPrevios());
        
        reporteRevisadoOmitidoDTO.setEntrevistasRealizadas(reporteOmitido.getEntrevistasRealizadas());
        reporteRevisadoOmitidoDTO.setEvidenciasRevisadas(reporteOmitido.getEvidenciasRevisadas());
        
        reporteRevisadoOmitidoDTO.setMotivoOmision(reporteOmitido.getMotivoOmision());
        
        return reporteRevisadoOmitidoDTO;
    }
}