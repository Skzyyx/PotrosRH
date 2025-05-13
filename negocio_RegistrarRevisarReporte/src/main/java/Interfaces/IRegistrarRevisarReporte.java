package Interfaces;

import Exception.ReporteException;
import dto.ReporteMalaConductaDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz que declara los métodos del subsistema RegistrarRevisarReporte.
 * Incluye métodos para registrar y obtener nuevos reportes (sin revisar) y
 * para registrar nuevos reportes revisados (sancionados u omitidos).
 * @author Leonardo Flores Leyva (252390)
 */
public interface IRegistrarRevisarReporte {
    /**
     * Registrar un nuevo reporte de mala conducta.
     * Valida que el nuevo reporte cumpla con todas las reglas de 
     * negocio, antes de ser registrado.
     * @param reporteNuevo Reporte de mala conducta a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    public boolean registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ReporteException;
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param rfcEmpleado RFC del empleado reportado.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes obtenidos.
     * @throws ReporteException Excepción del subsistema.
     */
    public List<ReporteMalaConductaDTO> obtenerReporte(String rfcEmpleado, LocalDate fechaIncidente) throws ReporteException;
    /**
     * Registra un nuevo reporte revisado sancionado.
     * Valida que el nuevo reporte cumpla con todas las reglas de 
     * negocio, antes de ser registrado.
     * @param reporteSancionadoNuevo Reporte revisado sancionado a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    public boolean registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevo) throws ReporteException;
    /**
     * Registra un nuevo reporte revisado omitido.
     * @param reporteOmitidoNuevo Reporte revisado omitido a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    public boolean registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevo) throws ReporteException;
}