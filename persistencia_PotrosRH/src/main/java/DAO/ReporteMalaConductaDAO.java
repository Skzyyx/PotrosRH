package DAO;

import Conexion.Conexion;
import Entidades.Empleado;
import Entidades.ReporteMalaConducta;
import Entidades.ReporteRevisadoOmitido;
import Entidades.ReporteRevisadoSancionado;
import Enums.EstadoReporte;
import Exceptions.AccesoDatosException;
import Interfaces.IReporteMalaConductaDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 * Clase que implementa la interfaz IReporteMalaConductaDAO y sus 
 * métodos de persistencia. Utiliza MongoDB como base de datos.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteMalaConductaDAO implements IReporteMalaConductaDAO {
    /**
     * Colección de Reportes de Mala Conducta en MongoDB.
     */
    private final MongoCollection<ReporteMalaConducta> reportes;
    /**
     * Colección de Reportes Revisados Sancionados en MongoDB.
     */
    private final MongoCollection<ReporteRevisadoSancionado> reportesSancionados;
    /**
     * Colección de Reportes Revisados Omitidos en MongoDB.
     */
    private final MongoCollection<ReporteRevisadoOmitido> reportesOmitidos;
    /**
     * Constructor por defecto. Obtiene la colección de
     * reportes de mala conducta.
     */
    public ReporteMalaConductaDAO() {
        reportes = Conexion.getDatabase().getCollection("reportes_mala_conducta", ReporteMalaConducta.class);
        reportesSancionados = Conexion.getDatabase().getCollection("reportes_sancionados", ReporteRevisadoSancionado.class);
        reportesOmitidos = Conexion.getDatabase().getCollection("reportes_omitidos", ReporteRevisadoOmitido.class);
    }
    /**
     * Registra un nuevo reporte de mala conducta.
     * @param reporteNuevo Reporte de Mala Conducta a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteMalaConducta registrarReporteNuevo(ReporteMalaConducta reporteNuevo) throws AccesoDatosException {
        try {
            // Ejecuta la inserción.
            reportes.insertOne(reporteNuevo);
            // Devuelve el reporte recién insertado.
            return reporteNuevo;
        } catch (Exception e) {throw new AccesoDatosException("Error al intentar registrar el nuevo reporte de mala conducta.", e);}
    }
    /**
     * Obtiene un reporte de mala conducta no revisado de la base de datos.
     * @param empleado Empleado a buscar, asociado a un reporte de mala conducta.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public List<ReporteMalaConducta> obtenerReporteEmpleado(Empleado empleado, LocalDate fechaIncidente) throws AccesoDatosException {
        try {
            // Filtro para el RFC.
            Bson filtroRFC = Filters.eq("empleadoReportado.rfc", empleado.getRfc());
            // Ejecuta la consulta y regresa una lista con los reportes obtenidos.
            return reportes.find(filtroRFC).into(new ArrayList<>());
        } catch (Exception e) {throw new AccesoDatosException("Error al consultar el reporte del empleado.", e);}
    }
    /**
     * Obtiene una lista de reportes que coincidan con el número de seguimiento
     * recibido y no esté revisado.
     * @param reporteSeguimiento Reporte con número de seguimiento.
     * @return Reporte encontrado.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteMalaConducta obtenerReporteSeguimiento(ReporteMalaConducta reporteSeguimiento) throws AccesoDatosException{
        try {
            // Filtro para el número de seguimiento, extraído del empleado recibido.
            Bson filtroNumSeguimiento = Filters.eq("numeroSeguimiento", reporteSeguimiento.getNumeroSeguimiento());
            // Ejecuta la consulta y devuelve el reporte encontrado.
            return reportes.find(filtroNumSeguimiento).first();
        } catch (Exception e) {throw new AccesoDatosException("Error al consultar el reporte del empleado.", e);}
    }
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteRevisadoSancionado registrarReporteSancionado(ReporteRevisadoSancionado reporteSancionadoNuevo) throws AccesoDatosException {
        try {
            // Actualización del estado del reporte de mala conducta asociado.
            Bson actualizarEstadoReporte = Updates.set("estadoReporte", EstadoReporte.REVISADO);
            // Filtro para buscar el reporte de mala conducta asociado por su ID.
            Bson filtroID = Filters.eq("id", reporteSancionadoNuevo.getReporteMalaConducta().getId());
            // Ejecuta la actualización del estado del reporte de mala conducta asociado.
            UpdateResult estadoActualizado = reportes.updateOne(filtroID, actualizarEstadoReporte);
            // Si el estado del reporte de mala conducta no fue actualizado.
            if(!estadoActualizado.wasAcknowledged())
                throw new Exception();
            // Si el estado del reporte de mala conducta asociado fue actualizado con éxito.
            else{
                // Se ejecuta la inserción.
                reportesSancionados.insertOne(reporteSancionadoNuevo);
                // Se devuelve el reporte revisado sancionado insertado.
                return reporteSancionadoNuevo;
            }
        } catch (Exception e) {throw new AccesoDatosException("Hubo un error al intentar registrar el reporte sancionado.", e);}
    }
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public ReporteRevisadoOmitido registrarReporteOmitido(ReporteRevisadoOmitido reporteOmitidoNuevo) throws AccesoDatosException {
        try {
            // Actualización del estado del reporte de mala conducta asociado.
            Bson actualizarEstadoReporte = Updates.set("estadoReporte", EstadoReporte.REVISADO);
            // Filtro para buscar el reporte de mala conducta asociado por su ID.
            Bson filtroID = Filters.eq("id", reporteOmitidoNuevo.getReporteMalaConducta().getId());
            // Ejecuta la actualización del estado del reporte de mala conducta asociado.
            UpdateResult estadoActualizado = reportes.updateOne(filtroID, actualizarEstadoReporte);
            // Si el estado del reporte de mala conducta no fue actualizado.
            if(!estadoActualizado.wasAcknowledged())
                throw new Exception();
            // Si el estado del reporte de mala conducta asociado fue actualizado con éxito.
            else{
                // Se ejecuta la inserción.
                reportesOmitidos.insertOne(reporteOmitidoNuevo);
                // Se devuelve el reporte revisado omitido insertado.
                return reporteOmitidoNuevo;
            }
        } catch (Exception e) {throw new AccesoDatosException("Hubo un error al intentar registrar el reporte sancionado.", e);}
    }   
}