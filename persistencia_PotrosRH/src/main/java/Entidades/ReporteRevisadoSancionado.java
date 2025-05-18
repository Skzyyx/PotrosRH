package Entidades;

import Enums.GravedadSancion;
import java.util.Set;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad ReporteRevisadoSancionado.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteRevisadoSancionado extends ReporteRevisado{
    // Atributos de un reporte revisado sancionado.
    private Set<String> normasVioladas;
    private GravedadSancion nivelGravedad;
    private String sancionImpuesta;
    /**
     * Contructor por defecto.
     */
    public ReporteRevisadoSancionado() {}
    /**
     * Constructor con todos los atributos, menos el ID.
     * @param normasVioladas Conjunto de normas violadas por el empleado.
     * @param nivelGravedad Nivel de gravedad del incidente.
     * @param sancionImpuesta Sanción impuesta al empleado.
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     */
    public ReporteRevisadoSancionado(
            Set<String> normasVioladas, 
            GravedadSancion nivelGravedad, 
            String sancionImpuesta,
            ReporteMalaConducta reporteMalaConducta, 
            boolean infoCompleta, 
            boolean tieneAntecedentesPrevios,
            String descripcionAntecedentesPrevios,
            Set<String> entrevistasRealizadas,
            Set<String> evidenciasRevisadas
    ) {
        super(
                reporteMalaConducta, 
                infoCompleta, 
                tieneAntecedentesPrevios, 
                descripcionAntecedentesPrevios, 
                entrevistasRealizadas,
                evidenciasRevisadas
        );
        this.normasVioladas = normasVioladas;
        this.nivelGravedad = nivelGravedad;
        this.sancionImpuesta = sancionImpuesta;
    }
    /**
     * Constructor con todos los atributos, incluido el ID.
     * @param id ID del reporte sancionado.
     * @param normasVioladas Conjunto de normas violadas por el empleado.
     * @param nivelGravedad Nivel de gravedad del incidente.
     * @param sancionImpuesta Sanción impuesta al empleado.
     * @param reporteMalaConducta Reporte de mala conducta asociado.
     * @param infoCompleta Si es que tiene la información completa.
     * @param tieneAntecedentesPrevios Si es que se cuentan con antecedentes previos del empleado.
     * @param descripcionAntecedentesPrevios Descripción de los antecedentes previos.
     * @param entrevistasRealizadas Entrevistas realizadas para el reporte.
     * @param evidenciasRevisadas Conjunto de evidencias revisadas para el reporte.
     */
    public ReporteRevisadoSancionado(
            ObjectId id,
            Set<String> normasVioladas, 
            GravedadSancion nivelGravedad, 
            String sancionImpuesta,
            ReporteMalaConducta reporteMalaConducta, 
            boolean infoCompleta, 
            boolean tieneAntecedentesPrevios,
            String descripcionAntecedentesPrevios,
            Set<String> entrevistasRealizadas,
            Set<String> evidenciasRevisadas
    ) {
        super(
                id,
                reporteMalaConducta, 
                infoCompleta, 
                tieneAntecedentesPrevios, 
                descripcionAntecedentesPrevios, 
                entrevistasRealizadas,
                evidenciasRevisadas
        );
        this.normasVioladas = normasVioladas;
        this.nivelGravedad = nivelGravedad;
        this.sancionImpuesta = sancionImpuesta;
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
    public GravedadSancion getNivelGravedad() {return nivelGravedad;}
    /**
     * Retorna la sanción impuesta al empleado.
     * @return Sanción impuesta al empleado.
     */
    public String getSancionImpuesta() {return sancionImpuesta;}
    /**
     * Establece el conjunto de normas violadas por el empleado.
     * @param normasVioladas Nuevo conjunto de normas violadas por el empleado.
     */
    public void setNormasVioladas(Set<String> normasVioladas) {this.normasVioladas = normasVioladas;}
    /**
     * Establece el nivel de gravedad del incidente.
     * @param nivelGravedad Nuevo nivel de gravedad del incidente.
     */
    public void setNivelGravedad(GravedadSancion nivelGravedad) {this.nivelGravedad = nivelGravedad;}
    /**
     * Establece la sanción impuesta al empleado.
     * @param sancionImpuesta Nueva sanción impuesta al empleado.
     */
    public void setSancionImpuesta(String sancionImpuesta) {this.sancionImpuesta = sancionImpuesta;}
    /**
     * Retorna una cadena con la información relevante del reporte sancionado.
     * @return Cadena con la información relevante del reporte sancionado.
     */
    @Override
    public String toString() {
        return "ReporteRevisadoSancionado{" + "normasVioladas=" + normasVioladas + 
                ", nivelGravedad=" + nivelGravedad + 
                ", sancionImpuesta=" + sancionImpuesta + '}';
    }
}