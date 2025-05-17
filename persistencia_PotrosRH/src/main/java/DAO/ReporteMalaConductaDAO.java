package DAO;

import Entidades.Empleado;
import Entidades.ReporteMalaConducta;
import Entidades.ReporteRevisadoOmitido;
import Entidades.ReporteRevisadoSancionado;
import Exceptions.AccesoDatosException;
import Interfaces.IReporteMalaConductaDAO;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase que implementa la interfaz IReporteMalaConductaDAO y sus 
 * métodos de persistencia. Utiliza MongoDB como base de datos.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteMalaConductaDAO implements IReporteMalaConductaDAO {
    /**
     * Registra un nuevo reporte de mala conducta.
     * @param reporteNuevo Reporte de Mala Conducta a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteMalaConducta registrarReporteNuevo(ReporteMalaConducta reporteNuevo) throws AccesoDatosException {
        return null;
    }
    /**
     * Obtiene un reporte de mala conducta de la base de datos.
     * @param empleado Empleado a buscar, asociado a un reporte de mala conducta.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public List<ReporteMalaConducta> obtenerReporteEmpleado(Empleado empleado, LocalDate fechaIncidente) throws AccesoDatosException {
        return null;
    }
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param reporteSeguimiento Reporte con número de seguimiento.
     * @return Reporte encontrado.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteMalaConducta obtenerReporteSeguimiento(ReporteMalaConducta reporteSeguimiento) throws AccesoDatosException{
        return null;
    }
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteRevisadoSancionado registrarReporteSancionado(ReporteRevisadoSancionado reporteSancionadoNuevo) throws AccesoDatosException {
        return null;
    }
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteRevisadoOmitido registrarReporteOmitido(ReporteRevisadoOmitido reporteOmitidoNuevo) throws AccesoDatosException {
        return null;
    }   
}