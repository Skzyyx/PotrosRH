package Interfaces;

import Exceptions.ObjetosNegocioException;
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
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public boolean registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ObjetosNegocioException;
    /**
     * Obtiene un reporte de mala conducta de la base de datos. Mapea las entidades obtenidas
     * a sus correspondientes objetos ReporteMalaConductaDTO.
     * @param rfcEmpleado RFC del empleado reportado asociado.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public List<ReporteMalaConductaDTO> obtenerReporte(String rfcEmpleado, LocalDate fechaIncidente) throws ObjetosNegocioException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado. Mapea el DTO recibido a su
     * entidad correspondiente ReporteRevisadoSancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public boolean registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevo) throws ObjetosNegocioException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido. Mapea el DTO recibido a su
     * entidad correspondiente ReporteRevisadoOmitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    public boolean registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevo) throws ObjetosNegocioException;
}