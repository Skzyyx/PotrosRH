package dto;

import java.util.Set;

/**
 * Objeto de transferencia para un Reporte Revisado Sancionado.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoSancionadoDTO extends ReporteRevisadoDTO{
    // Atributos de un reporte revisado sancionado.
    private Set<String> normasVioladas;
    private String nivelGravedad;
    private String sancionImpuesta;
    private String descripcionOtraSancionImpuesta;
    /**
     * Contructor por defecto.
     */
    public ReporteRevisadoSancionadoDTO() {}
    /**
     * Constructor con todos los atributos, menos el ID.
     * @param normasVioladas Conjunto de normas violadas por el empleado.
     * @param nivelGravedad Nivel de gravedad del incidente.
     * @param sancionImpuesta Sanción impuesta al empleado.
     * @param descripcionOtraSancionImpuesta Descripción de la otra sanción impuesta al empleado.
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param descripcionOtrasEntrevistasRealizadas Descripción de otras entrevistas realizadas.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     * @param descripcionOtrasEvidencias Descripción de otras evidencias revisadas.
     */
    public ReporteRevisadoSancionadoDTO(
            Set<String> normasVioladas, 
            String nivelGravedad, 
            String sancionImpuesta, 
            String descripcionOtraSancionImpuesta, 
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
        this.normasVioladas = normasVioladas;
        this.nivelGravedad = nivelGravedad;
        this.sancionImpuesta = sancionImpuesta;
        this.descripcionOtraSancionImpuesta = descripcionOtraSancionImpuesta;
    }
    /**
     * Constructor con todos los atributos, incluido el ID.
     * @param id ID del reporte sancionado.
     * @param normasVioladas Conjunto de normas violadas por el empleado.
     * @param nivelGravedad Nivel de gravedad del incidente.
     * @param sancionImpuesta Sanción impuesta al empleado.
     * @param descripcionOtraSancionImpuesta Descripción de la otra sanción impuesta al empleado.
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param descripcionOtrasEntrevistasRealizadas Descripción de otras entrevistas realizadas.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     * @param descripcionOtrasEvidencias Descripción de otras evidencias revisadas.
     */
    public ReporteRevisadoSancionadoDTO(
            String id,
            Set<String> normasVioladas, 
            String nivelGravedad, 
            String sancionImpuesta, 
            String descripcionOtraSancionImpuesta, 
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
                id,
                reporteMalaConducta, 
                infoCompleta, 
                tieneAntecedentesPrevios, 
                descripcionAntecedentesPrevios, 
                entrevistasRealizadas, 
                descripcionOtrasEntrevistasRealizadas,
                evidenciasRevisadas,
                descripcionOtrasEvidencias
        );
        this.normasVioladas = normasVioladas;
        this.nivelGravedad = nivelGravedad;
        this.sancionImpuesta = sancionImpuesta;
        this.descripcionOtraSancionImpuesta = descripcionOtraSancionImpuesta;
    }
    /**
     * Retorna el conjunto de normas violadas por el empleado.
     * @return Conjunto de normas violadas por el empleado.
     */
    public Set<String> getNormasVioladas() {return normasVioladas;}
    /**
     * Retorna el nivel de gravedad del incidente.
     * @return Nivel de gravedad del incidente.
     */
    public String getNivelGravedad() {return nivelGravedad;}
    /**
     * Retorna la sanción impuesta al empleado.
     * @return Sanción impuesta al empleado.
     */
    public String getSancionImpuesta() {return sancionImpuesta;}
    /**
     * Retorna la descripción de la otra sanción impuesta al empleado.
     * @return Descripción de la otra sanción impuesta al empleado.
     */
    public String getDescripcionOtraSancionImpuesta() {return descripcionOtraSancionImpuesta;}
    /**
     * Establece el conjunto de normas violadas por el empleado.
     * @param normasVioladas Nuevo conjunto de normas violadas por el empleado.
     */
    public void setNormasVioladas(Set<String> normasVioladas) {this.normasVioladas = normasVioladas;}
    /**
     * Establece el nivel de gravedad del incidente.
     * @param nivelGravedad Nuevo nivel de gravedad del incidente.
     */
    public void setNivelGravedad(String nivelGravedad) {this.nivelGravedad = nivelGravedad;}
    /**
     * Establece la sanción impuesta al empleado.
     * @param sancionImpuesta Nueva sanción impuesta al empleado.
     */
    public void setSancionImpuesta(String sancionImpuesta) {this.sancionImpuesta = sancionImpuesta;}
    /**
     * Establece la descripción de la otra sanción impuesta al empleado.
     * @param descripcionOtraSancionImpuesta Nueva descripción de la otra sanción impuesta al empleado.
     */
    public void setDescripcionOtraSancionImpuesta(String descripcionOtraSancionImpuesta) {this.descripcionOtraSancionImpuesta = descripcionOtraSancionImpuesta;}
    /**
     * Retorna una cadena con la información relevante del reporte sancionado.
     * @return Cadena con la información relevante del reporte sancionado.
     */
    @Override
    public String toString() {
        return "ReporteRevisadoSancionado{" + "normasVioladas=" + normasVioladas + ", nivelGravedad=" + nivelGravedad + ", sancionImpuesta=" + sancionImpuesta + '}';
    }
}