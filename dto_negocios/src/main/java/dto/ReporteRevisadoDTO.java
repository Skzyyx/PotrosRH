package dto;

import java.util.Set;

/**
 * Objeto de transferencia para Reportes Revisados.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoDTO {
    // Atributos de un reporte de mala conducta revisado.
    private String id;
    private ReporteMalaConductaDTO reporteMalaConducta;
    private boolean infoCompleta;
    private boolean tieneAntecedentesPrevios;
    private String descripcionAntecedentesPrevios;
    private Set<String> entrevistasRealizadas;
    private Set<String> evidenciasRevisadas;
    /**
     * Constructor por defecto.
     */
    public ReporteRevisadoDTO() {}
    /**
     * Constructor con todos los atributos, menos el ID.
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     */
    public ReporteRevisadoDTO(
            ReporteMalaConductaDTO reporteMalaConducta, 
            boolean infoCompleta, 
            boolean tieneAntecedentesPrevios,
            String descripcionAntecedentesPrevios,
            Set<String> entrevistasRealizadas,
            Set<String> evidenciasRevisadas
    ) {
        this.reporteMalaConducta = reporteMalaConducta;
        this.infoCompleta = infoCompleta;
        this.tieneAntecedentesPrevios = tieneAntecedentesPrevios;
        this.descripcionAntecedentesPrevios = descripcionAntecedentesPrevios;
        this.entrevistasRealizadas = entrevistasRealizadas;
        this.evidenciasRevisadas = evidenciasRevisadas;
    }
    /**
     * Constructor con todos los atributos, incluido el ID.
     * @param id ID del reporte revisado.
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     */
    public ReporteRevisadoDTO(
            String id,
            ReporteMalaConductaDTO reporteMalaConducta, 
            boolean infoCompleta, 
            boolean tieneAntecedentesPrevios,
            String descripcionAntecedentesPrevios,
            Set<String> entrevistasRealizadas,
            Set<String> evidenciasRevisadas
    ) {
        this.id = id;
        this.reporteMalaConducta = reporteMalaConducta;
        this.infoCompleta = infoCompleta;
        this.tieneAntecedentesPrevios = tieneAntecedentesPrevios;
        this.descripcionAntecedentesPrevios = descripcionAntecedentesPrevios;
        this.entrevistasRealizadas = entrevistasRealizadas;
        this.evidenciasRevisadas = evidenciasRevisadas;
    }
    /**
     * Retorna el ID del reporte revisado.
     * @return ID del reporte revisado.
     */
    public String getId() {return id;}
    /**
     * Retorna el reporte de mala conducta asociado.
     * @return Reporte de mala conducta asociado.
     */
    public ReporteMalaConductaDTO getReporteMalaConducta() {return reporteMalaConducta;}
    /**
     * Retorna si es que el reporte tiene la información completa.
     * @return Si el reporte tiene la información completa o no.
     */
    public boolean isInfoCompleta() {return infoCompleta;}
    /**
     * Retorna si se cuentan con antecedentes previos del empleado o no.
     * @return Si se cuentan con antecedentes previos del empleado o no.
     */
    public boolean isTieneAntecedentesPrevios() {return tieneAntecedentesPrevios;}
    /**
     * Retorna la descripción de los antecedentes previos.
     * @return Descripción de los antecedentes previos.
     */
    public String getDescripcionAntecedentesPrevios() {return descripcionAntecedentesPrevios;}
    /**
     * Retorna las entrevistas realizadas para el reporte.
     * @return Entrevistas realizadas para el reporte.
     */
    public Set<String> getEntrevistasRealizadas() {return entrevistasRealizadas;}
    /**
     * Retorna el conjunto de evidencias revisadas para el reporte.
     * @return Conjunto de evidencias revisadas para el reporte.
     */
    public Set<String> getEvidenciasRevisadas() {return evidenciasRevisadas;}
    /**
     * Establece el ID del reporte revisado.
     * @param id Nuevo ID del reporte revisado.
     */
    public void setId(String id) {this.id = id;}
    /**
     * Establece el reporte de mala conducta asociado.
     * @param reporteMalaConducta Nuevo reporte de mala conducta asociado.
     */
    public void setReporteMalaConducta(ReporteMalaConductaDTO reporteMalaConducta) {this.reporteMalaConducta = reporteMalaConducta;}
    /**
     * Establece si es que el reporte tiene la información completa.
     * @param infoCompleta Nuevo valor si se tiene la información completa.
     */
    public void setInfoCompleta(boolean infoCompleta) {this.infoCompleta = infoCompleta;}
    /**
     * Establece si se cuentan con antecedentes previos del empleado o no.
     * @param tieneAntecedentesPrevios Nuevo valor si se cuentan con
     * antecedentes previos del empleado o no.
     */
    public void setTieneAntecedentesPrevios(boolean tieneAntecedentesPrevios) {this.tieneAntecedentesPrevios = tieneAntecedentesPrevios;}
    /**
     * Establece la descripción de los antecedentes previos.
     * @param descripcionAntecedentesPrevios Nueva descripción de los antecedentes previos.
     */
    public void setDescripcionAntecedentesPrevios(String descripcionAntecedentesPrevios) {this.descripcionAntecedentesPrevios = descripcionAntecedentesPrevios;}
    /**
     * Establece las entrevistas realizadas para el reporte.
     * @param entrevistasRealizadas Nuevas entrevistas realizadas para el
     * reporte.
     */
    public void setEntrevistasRealizadas(Set<String> entrevistasRealizadas) {this.entrevistasRealizadas = entrevistasRealizadas;}
    /**
     * Establece el conjunto de evidencias revisadas para el reporte.
     * @param evidenciasRevisadas Nuevo conjunto de evidencias revisadas para el reporte.
     */
    public void setEvidenciasRevisadas(Set<String> evidenciasRevisadas) {this.evidenciasRevisadas = evidenciasRevisadas;}
    /**
     * Retorna una cadena con la información relevante del reporte revisado.
     * @return Cadena con la información relevante del reporte revisado.
     */
    @Override
    public String toString() {
        return "ReporteRevisado{" + "reporteMalaConducta=" + reporteMalaConducta + ", infoCompleta=" + infoCompleta + '}';
    }
}