package dto;

import java.util.Set;

/**
 * Objeto de transferencia para Reportes Revisados.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoDTO {
    // Atributos de un reporte de mala conducta revisado.
    private ReporteMalaConductaDTO reporteMalaConducta;
    private boolean infoCompleta;
    private boolean tieneAntecedentesPrevios;
    private Set<String> entrevistasRealizadas;
    private String descripcionOtrasEntrevistasRealizadas;
    /**
     * Constructor por defecto.
     */
    public ReporteRevisadoDTO() {}
    /**
     * Constructor con todos los atributos.
     *
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param descripcionOtrasEntrevistasRealizadas Descripción de otras entrevistas realizadas.
     */
    public ReporteRevisadoDTO(
            ReporteMalaConductaDTO reporteMalaConducta, 
            boolean infoCompleta, 
            boolean tieneAntecedentesPrevios, 
            Set<String> entrevistasRealizadas, 
            String descripcionOtrasEntrevistasRealizadas
    ) {
        this.reporteMalaConducta = reporteMalaConducta;
        this.infoCompleta = infoCompleta;
        this.tieneAntecedentesPrevios = tieneAntecedentesPrevios;
        this.entrevistasRealizadas = entrevistasRealizadas;
        this.descripcionOtrasEntrevistasRealizadas = descripcionOtrasEntrevistasRealizadas;
    }
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
     * Retorna las entrevistas realizadas para el reporte.
     * @return Entrevistas realizadas para el reporte.
     */
    public Set<String> getEntrevistasRealizadas() {return entrevistasRealizadas;}
    /**
     * Retorna la descripción de otras entrevistas realizadas.
     * @return Descripción de otras entrevistas realizadas.
     */
    public String getDescripcionOtrasEntrevistasRealizadas() {return descripcionOtrasEntrevistasRealizadas;}
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
     * Establece las entrevistas realizadas para el reporte.
     * @param entrevistasRealizadas Nuevas entrevistas realizadas para el
     * reporte.
     */
    public void setEntrevistasRealizadas(Set<String> entrevistasRealizadas) {this.entrevistasRealizadas = entrevistasRealizadas;}
    /**
     * Establece la descripción de otras entrevistas realizadas.
     * @param descripcionOtrasEntrevistasRealizadas Nueva descripción de otras
     * entrevistas realizadas.
     */
    public void setDescripcionOtrasEntrevistasRealizadas(String descripcionOtrasEntrevistasRealizadas) {this.descripcionOtrasEntrevistasRealizadas = descripcionOtrasEntrevistasRealizadas;}
    /**
     * Retorna una cadena con la información relevante del reporte revisado.
     * @return Cadena con la información relevante del reporte revisado.
     */
    @Override
    public String toString() {
        return "ReporteRevisado{" + "reporteMalaConducta=" + reporteMalaConducta + ", infoCompleta=" + infoCompleta + '}';
    }
}