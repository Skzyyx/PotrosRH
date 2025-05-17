package Interfaces;

import Entidades.Empleado;
import Entidades.ReporteMalaConducta;
import Entidades.ReporteRevisadoOmitido;
import Entidades.ReporteRevisadoSancionado;
import Exceptions.AccesoDatosException;
import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz para métodos de persistencia con entidades ReporteMalaConducta, 
 * ReporteRevisadoSancionado y ReporteRevisadoOmitido.
 * @author Leonardo Flores Leyva (252390)
 */
public interface IReporteMalaConductaDAO {
    /**
     * Registra un nuevo reporte de mala conducta.
     * @param reporteNuevo Reporte de Mala Conducta a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public ReporteMalaConducta registrarReporteNuevo(ReporteMalaConducta reporteNuevo) throws AccesoDatosException;
    /**
     * Obtiene un reporte de mala conducta de la base de datos.
     * @param empleado Empleado a buscar, asociado a un reporte de mala conducta.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public List<ReporteMalaConducta> obtenerReporteEmpleado(Empleado empleado, LocalDate fechaIncidente) throws AccesoDatosException;
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param reporteSeguimiento Reporte con número de seguimiento.
     * @return Reporte encontrado.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public ReporteMalaConducta obtenerReporteSeguimiento(ReporteMalaConducta reporteSeguimiento) throws AccesoDatosException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public ReporteRevisadoSancionado registrarReporteSancionado(ReporteRevisadoSancionado reporteSancionadoNuevo) throws AccesoDatosException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public ReporteRevisadoOmitido registrarReporteOmitido(ReporteRevisadoOmitido reporteOmitidoNuevo) throws AccesoDatosException;
}