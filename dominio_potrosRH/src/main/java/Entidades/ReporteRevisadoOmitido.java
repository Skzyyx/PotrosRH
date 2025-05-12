package Entidades;

import java.util.Set;

/**
 * Clase que representa la entidad ReporteRevisadoOmitido.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoOmitido extends ReporteRevisado{
    // Motivo de la omisión del reporte
    private String motivoOmision;
    /**
     * Constructor por defecto.
     */
    public ReporteRevisadoOmitido() {}
    /**
     * Constructor que recibe todos los atributos.
     * @param motivoOmision Motivo de la omisión del reporte
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param descripcionOtrasEntrevistasRealizadas Descripción de otras entrevistas realizadas.
     */
    public ReporteRevisadoOmitido(String motivoOmision, ReporteMalaConducta reporteMalaConducta, boolean infoCompleta, boolean tieneAntecedentesPrevios, Set<String> entrevistasRealizadas, String descripcionOtrasEntrevistasRealizadas) {
        super(reporteMalaConducta, infoCompleta, tieneAntecedentesPrevios, entrevistasRealizadas, descripcionOtrasEntrevistasRealizadas);
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