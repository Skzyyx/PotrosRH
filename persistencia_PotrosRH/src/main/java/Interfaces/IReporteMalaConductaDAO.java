package Interfaces;

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
    public boolean registrarReporteNuevo(ReporteMalaConducta reporteNuevo) throws AccesoDatosException;
    /**
     * Obtiene un reporte de mala conducta de la base de datos.
     * @param rfcEmpleado RFC del empleado reportado asociado.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public List<ReporteMalaConducta> obtenerReporte(String rfcEmpleado, LocalDate fechaIncidente) throws AccesoDatosException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public boolean registrarReporteSancionado(ReporteRevisadoSancionado reporteSancionadoNuevo) throws AccesoDatosException;
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    public boolean registrarReporteOmitido(ReporteRevisadoOmitido reporteOmitidoNuevo) throws AccesoDatosException;
}