package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Exception.ReporteException;
import Fachada.FRegistrarRevisarReporte;
import Fachada.ObtenerEmpleado;
import Interfaces.IObtenerEmpleado;
import Interfaces.IRegistrarRevisarReporte;
import dto.EmpleadoDTO;
import dto.ReporteMalaConductaDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase para operaciones de negocio con Reportes de Mala Conducta.
 * Se conecta con los subsistemas necesarios.
 * @author Leonardo Flores Leyva (252390)
 */
public class ControlReportes {
    // Atributo SingleTon de la clase.
    private static ControlReportes instance;
    // Subsistemas requeridos.
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();
    private final IRegistrarRevisarReporte reportes = FRegistrarRevisarReporte.getInstance();
    /**
     * Contructor por defecto.
     */
    private ControlReportes(){}
    /**
     * Método SingleTon de la clase.
     * @return Instancia SingleTon de la clase.
     */
    public static ControlReportes getInstance(){
        if(instance == null)
            instance = new ControlReportes();
        return instance;
    }
    /**
     * Obtiene un empleado para ser incluido en el reporte (reportado o reportante).
     * @param rfc RFC del empleado a buscar.
     * @return Empleado encontrado a partir de su RFC.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public EmpleadoDTO obtenerEmpleado(String rfc) throws PresentacionException{
        try {
            return obtenerEmpleado.obtenerEmpleado(rfc);
        } catch (ObtenerEmpleadoException e) {throw new PresentacionException(e.getMessage(), e);}
    }
    /**
     * Registra un nuevo reporte de mala conducta.
     * @param nuevoReporte Nuevo reporte de mala conducta.
     * @return VERDADERO si el registro se realizón con éxito, FALSO en caso contrario.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public boolean registrarReporte(ReporteMalaConductaDTO nuevoReporte) throws PresentacionException{
        try {
            return reportes.registrarReporteNuevo(nuevoReporte);
        } catch (ReporteException e) {throw new PresentacionException(e.getMessage(), e);}
    }
    /**
     * Regresa una lista de reportes de mala conducta de un empleado particular, 
     * en una fecha específica del incidente ocurrido.
     * @param rfcEmpleado RFC del empleado reportado.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes de mala conducta.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public List<ReporteMalaConductaDTO> obtenerReporte(String rfcEmpleado, LocalDate fechaIncidente) throws PresentacionException{
        try {
            return reportes.obtenerReporte(rfcEmpleado, fechaIncidente);
        } catch (ReporteException e) {throw new PresentacionException(e.getMessage(), e);}
    }
    /**
     * Registra un nuevo reporte revisado, del cual se dictaminó una sanción
     * a ser aplicada al empleado asociado al reporte de mala conducta
     * asociado.
     * @param reporteSancionado Reporte sancionado a registrar.
     * @return VERDADERO si el registro se realizón con éxito, FALSO en caso contrario.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public boolean registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionado) throws PresentacionException{
        try {
            return reportes.registrarReporteSancionado(reporteSancionado);
        } catch (ReporteException e) {throw new PresentacionException(e.getMessage(), e);}
    }
    /**
     * Registra un nuevo reporte revisado, del cual se dictaminó que debía
     * ser omtido, ya que el incidente no es lo suficientemente grave como 
     * para ser sancionado, o por otro motivo que justifica la omisión del
     * reporte.
     * @param reporteOmitido Reporte omitido a registrar.
     * @return VERDADERO si el registro se realizón con éxito, FALSO en caso contrario.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public boolean registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitido) throws PresentacionException{
        try {
            return reportes.registrarReporteOmitido(reporteOmitido);
        } catch (ReporteException e) {throw new PresentacionException(e.getMessage(), e);}
    }
}