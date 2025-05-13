package dto;

import java.util.Set;

/**
 * Objeto de transferencia para Reportes Revisados Omitidos.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoOmitidoDTO extends ReporteRevisadoDTO{
    // Motivo de la omisión del reporte
    private String motivoOmision;
    /**
     * Constructor por defecto.
     */
    public ReporteRevisadoOmitidoDTO() {}
    /**
     * Constructor que recibe todos los atributos.
     * @param motivoOmision Motivo de la omisión del reporte
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param descripcionOtrasEntrevistasRealizadas Descripción de otras entrevistas realizadas.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     * @param descripcionOtrasEvidencias Descripción de otras evidencias revisadas.
     */
    public ReporteRevisadoOmitidoDTO(
            String motivoOmision, 
            ReporteMalaConductaDTO reporteMalaConducta, 
            boolean infoCompleta, 
            boolean tieneAntecedentesPrevios,
            String descripcionAntecedentesPrevios,
            Set<String> entrevistasRealizadas, 
            String descripcionOtrasEntrevistasRealizadas,
            Set<String> evidenciasRevisadas,
            String descripcionOtrasEvidencias
    ) {
        super(
                reporteMalaConducta, 
                infoCompleta, 
                tieneAntecedentesPrevios, 
                descripcionAntecedentesPrevios, 
                entrevistasRealizadas, 
                descripcionOtrasEntrevistasRealizadas,
                evidenciasRevisadas,
                descripcionOtrasEvidencias
        );
        this.motivoOmision = motivoOmision;
    }
    /**
     * Retorna el motivo de la omisión del reporte.
     * @return Motivo de la omisión del reporte.
     */
    public String getMotivoOmision() {return motivoOmision;}
    /**
     * Establece el motivo de la omisión del reporte.
     * @param motivoOmision Nuevo motivo de la omisión del reporte.
     */
    public void setMotivoOmision(String motivoOmision) {this.motivoOmision = motivoOmision;}
    /**
     * Retorna una cadena con la información relevante del reporte omitido.
     * @return Cadena con la información relevante del reporte omitido.
     */
    @Override
    public String toString() {
        return "ReporteRevisadoOmitido{" + "motivoOmision=" + motivoOmision + '}';
    }
}