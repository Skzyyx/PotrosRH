package Control;

import Exception.ReporteException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IReporteMalaConductaBO;
import bo.ReporteMalaConductaBO;
import dto.ReporteRevisadoDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;

/**
 * Clase para el registro de reportes revisados.
 * @author Leonardo Flores Leyva (252390)
 */
public class RevisarReporte {
    // Atributo BO para las operaciones de negocio.
    private final IReporteMalaConductaBO reporteBO = ReporteMalaConductaBO.getInstance();
    /**
     * Constructor por defecto.
     */
    public RevisarReporte() {}
    /**
     * Registra un nuevo reporte revisado sancionado.
     * Valida que el nuevo reporte cumpla con todas las reglas de 
     * negocio, antes de ser registrado.
     * @param reporteSancionadoNuevo Reporte revisado sancionado a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    public boolean registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevo) throws ReporteException {
        
        if(reporteSancionadoNuevo == null)
            throw new ReporteException("ERROR: No se aceptan reportes sancionados nulos.");
        
        verificarReporteRevisado(reporteSancionadoNuevo);
        
        if(reporteSancionadoNuevo.getNormasVioladas() == null)
            throw new ReporteException("ERROR: Debe seleccionar al menos una norma violada por el empleado.");
        
        if(reporteSancionadoNuevo.getNormasVioladas().isEmpty())
            throw new ReporteException("ERROR: Debe seleccionar al menos una norma violada por el empleado.");
        
        if(reporteSancionadoNuevo.getNivelGravedad()== null)
            throw new ReporteException("ERROR: Debe seleccionar el nivel de gravedad del incidente.");
        
        if(reporteSancionadoNuevo.getNivelGravedad().trim().isEmpty())
            throw new ReporteException("ERROR: Debe seleccionar el nivel de gravedad del incidente.");
        
        if(
              !(
                reporteSancionadoNuevo.getNivelGravedad().toUpperCase().equals("Leve") || 
                reporteSancionadoNuevo.getNivelGravedad().toUpperCase().equals("Moderado") ||
                reporteSancionadoNuevo.getNivelGravedad().toUpperCase().equals("Grave")
                )
        )
            throw new ReporteException("ERROR: Debe seleccionar un nivel de gravedad equivalente a Leve, Moderado o Grave.");
        
        if(reporteSancionadoNuevo.getSancionImpuesta() == null)
            throw new ReporteException("ERROR: Debe seleccionar la sanción impuesta al empleado.");
        
        if(reporteSancionadoNuevo.getSancionImpuesta().trim().isEmpty())
            throw new ReporteException("ERROR: Debe seleccionar la sanción impuesta al empleado.");
        
        try {
            return reporteBO.registrarReporteSancionado(reporteSancionadoNuevo);
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
        
    }
    /**
     * Registra un nuevo reporte revisado omitido.
     * @param reporteOmitidoNuevo Reporte revisado omitido a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    public boolean registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevo) throws ReporteException {
        
        if(reporteOmitidoNuevo == null)
            throw new ReporteException("ERROR: No se aceptan reportes sancionados nulos.");
        
        verificarReporteRevisado(reporteOmitidoNuevo);
        
        if(reporteOmitidoNuevo.getMotivoOmision() == null)
            throw new ReporteException("ERROR: El motivo de la omisión no puede ser nulo.");
        
        try {
            return reporteBO.registrarReporteOmitido(reporteOmitidoNuevo);
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
    }
    /**
     * Valida los atributos generales de un Reporte Revisado.
     * @param reporte Reporte revisado a validar.
     * @throws ReporteException Excepción del subsitema.
     */
    private void verificarReporteRevisado(ReporteRevisadoDTO reporte) throws ReporteException{
        
        if(reporte.getReporteMalaConducta() == null)
            throw new ReporteException("ERROR: El reporte revisado debe contar con un reporte de mala conducta asociado.");
        
        if(reporte.isTieneAntecedentesPrevios() && reporte.getDescripcionAntecedentesPrevios() == null)
            throw new ReporteException("ERROR: Ingrese la descripción de los antecedentes previos.");
        
        if(reporte.isTieneAntecedentesPrevios() && reporte.getDescripcionAntecedentesPrevios().trim().isEmpty())
            throw new ReporteException("ERROR: Ingrese la descripción de los antecedentes previos.");
        
        if(reporte.getEntrevistasRealizadas() == null)
            throw new ReporteException("ERROR: Se debe haber entrevistado por lo menos a una persona.");
        
        if(reporte.getEntrevistasRealizadas().isEmpty())
            throw new ReporteException("ERROR: Se debe haber entrevistado por lo menos a una persona.");
        
        if(reporte.getEvidenciasRevisadas() == null)
            throw new ReporteException("ERROR: Se debe haber revisado al menos una evidencia.");
        
        if(reporte.getEvidenciasRevisadas().isEmpty())
            throw new ReporteException("ERROR: Se debe haber revisado al menos una evidencia.");
        
    }
}