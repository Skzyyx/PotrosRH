package Fachada;

import Control.RegistrarObtenerReporte;
import Control.RevisarReporte;
import Exception.ReporteException;
import Interfaces.IRegistrarRevisarReporte;
import dto.ReporteMalaConductaDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase fachada que implementa la interfaz IRegistrarRevisarReporte.
 * @author Leonardo Flores Leyva (252390)
 */
public class FRegistrarRevisarReporte implements IRegistrarRevisarReporte {
    // Atributo SingleTon de la clase.
    private static IRegistrarRevisarReporte instance;
    // Clases control para operaciones de negocio.
    private final RegistrarObtenerReporte reportesSinRevisar = new RegistrarObtenerReporte();
    private final RevisarReporte reportesRevisados = new RevisarReporte();
    /**
     * Constructor por defecto.
     */
    private FRegistrarRevisarReporte(){}
    /**
     * Método SingleTon de la clase.
     * @return Instancia de esta clase.
     */
    public static synchronized IRegistrarRevisarReporte getInstance(){
        if(instance == null)
            instance = new FRegistrarRevisarReporte();
        return instance;
    }
    /**
     * Registrar un nuevo reporte de mala conducta.
     * Valida que el nuevo reporte cumpla con todas las reglas de 
     * negocio, antes de ser registrado.
     * @param reporteNuevo Reporte de mala conducta a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    @Override
    public boolean registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ReporteException {return reportesSinRevisar.registrarReporteNuevo(reporteNuevo);}
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param rfcEmpleado RFC del empleado reportado.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes obtenidos.
     * @throws ReporteException Excepción del subsistema.
     */
    @Override
    public List<ReporteMalaConductaDTO> obtenerReporte(String rfcEmpleado, LocalDate fechaIncidente) throws ReporteException {
        return reportesSinRevisar.obtenerReporte(rfcEmpleado, fechaIncidente);
    }
    /**
     * Registra un nuevo reporte revisado sancionado.
     * Valida que el nuevo reporte cumpla con todas las reglas de 
     * negocio, antes de ser registrado.
     * @param reporteSancionadoNuevo Reporte revisado sancionado a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    @Override
    public boolean registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevo) throws ReporteException {
        return reportesRevisados.registrarReporteSancionado(reporteSancionadoNuevo);
    }
    /**
     * Registra un nuevo reporte revisado omitido.
     * @param reporteOmitidoNuevo Reporte revisado omitido a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    @Override
    public boolean registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevo) throws ReporteException {
        return reportesRevisados.registrarReporteOmitido(reporteOmitidoNuevo);
    }
}