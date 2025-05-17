package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.ReporteMalaConductaDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz que declara los métodos de BO para el manejo
 * de Reportes de Mala Conducta (revisados y no revisados).
 * @author Leonardo Flores Leyva (252390)
 */
public interface IReporteMalaConductaBO {
    /**
     * Registra un nuevo reporte de mala conducta. Mapea el DTO recibido a su
     * entidad correspondiente ReporteMalaConducta.
     * @param reporteNuevo Reporte de Mala Conducta a persistir.
     * @return Reporte registrado.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public ReporteMalaConductaDTO registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ObjetosNegocioException;
    /**
     * Obtiene un reporte de mala conducta de la base de datos. Mapea las entidades obtenidas
     * a sus correspondientes objetos ReporteMalaConductaDTO.
     * @param empleado Empleado a buscar, asociado a un reporte de mala conducta.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public List<ReporteMalaConductaDTO> obtenerReporteEmpleado(EmpleadoDTO empleado, LocalDate fechaIncidente) throws ObjetosNegocioException;
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param reporteSeguimiento Reporte con número de seguimiento.
     * @return Reporte encontrado.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public ReporteMalaConductaDTO obtenerReporteSeguimiento(ReporteMalaConductaDTO reporteSeguimiento) throws ObjetosNegocioException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado. Mapea el DTO recibido a su
     * entidad correspondiente ReporteRevisadoSancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return Reporte sancionado registrado.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public ReporteRevisadoSancionadoDTO registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevo) throws ObjetosNegocioException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido. Mapea el DTO recibido a su
     * entidad correspondiente ReporteRevisadoOmitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return Reporte omitido registrado.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public ReporteRevisadoOmitidoDTO registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevo) throws ObjetosNegocioException;
}