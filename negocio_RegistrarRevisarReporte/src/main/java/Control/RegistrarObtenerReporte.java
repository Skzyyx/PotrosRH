package Control;

import Exception.ReporteException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IReporteMalaConductaBO;
import bo.ReporteMalaConductaBO;
import dto.ReporteMalaConductaDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase de control para el registro y la obtención de
 * nuevos reportes de mala conducta.
 * @author Leonardo Flores Leyva (252390)
 */
public class RegistrarObtenerReporte {
    // Atributo BO para las operaciones de negocio.
    private final IReporteMalaConductaBO reporteBO = ReporteMalaConductaBO.getInstance();
    /**
     * Constructor por defecto.
     */
    public RegistrarObtenerReporte() {}
    /**
     * Registrar un nuevo reporte de mala conducta.
     * Valida que el nuevo reporte cumpla con todas las reglas de 
     * negocio, antes de ser registrado.
     * @param reporteNuevo Reporte de mala conducta a registrar.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ReporteException Excepción del subsistema.
     */
    public boolean registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ReporteException {
        
        if(reporteNuevo == null)
            throw new ReporteException("ERROR: El reporte no puede ser nulo.");
        
        verificarReporteRevisado(reporteNuevo);
        // Se agrega la fecha de hoy como fecha de registro del nuevo reporte.
        reporteNuevo.setFechaRegistro(LocalDate.now());
        
        try {
            return reporteBO.registrarReporteNuevo(reporteNuevo);
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
    }
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param rfcEmpleado RFC del empleado reportado.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes obtenidos.
     * @throws ReporteException Excepción del subsistema.
     */
    public List<ReporteMalaConductaDTO> obtenerReporte(String rfcEmpleado, LocalDate fechaIncidente) throws ReporteException {
        try {
            return reporteBO.obtenerReporte(rfcEmpleado, fechaIncidente);
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
    }
    /**
     * Verifica que el contenido del reporte sea válido.
     * @param reporte Reporte a revisar.
     * @throws ReporteException Excepción del subsistema.
     */
    private void verificarReporteRevisado(ReporteMalaConductaDTO reporte) throws ReporteException{
        
        if(reporte.getEmpleadoReportado() == null)
            throw new ReporteException("ERROR: El reporte debe tener asociado a un empleado a reportar.");
        
        if(reporte.getEmpleadoReportante() == null)
            throw new ReporteException("ERROR: El reporte debe tener asociado a un empleado responsable del reporte.");
        
        if(reporte.getEmpleadoReportante().getRfc().equals(reporte.getEmpleadoReportado().getRfc()))
            throw new ReporteException("ERROR: El empleado no se puede reportar a sí mismo. Elija dos empleados diferentes");
        
        if(reporte.getFechaHoraIncidente() == null)
            throw new ReporteException("ERROR: El reporte debe contar con la fecha del incidente.");
        
        if(reporte.getFechaHoraIncidente().isAfter(LocalDateTime.now()))
            throw new ReporteException("ERROR: La fecha y hora elegida no puede estar después de la fecha y hora actual.");
        
        if(reporte.getLugarIncidente() == null)
            throw new ReporteException("ERROR: El reporte debe contar con un lugar del incidente asociado obligatorio.");
        
        if(reporte.getLugarIncidente().trim().isEmpty())
            throw new ReporteException("ERROR: El reporte debe contar con un lugar del incidente asociado obligatorio.");
        
        if(reporte.getLugarIncidente().length() > 100)
            throw new ReporteException("ERROR: Solo se permiten máximo 100 caracteres para el lugar del incidente.");
        
        if(reporte.getDescripcionDetallada() == null)
            throw new ReporteException("ERROR: El reporte debe contar con una descripción detallada del incidente.");
        
        if(reporte.getDescripcionDetallada().trim().isEmpty())
            throw new ReporteException("ERROR: El reporte debe contar con una descripción detallada del incidente.");
        
        if(reporte.getDescripcionDetallada().length() > 1000)
            throw new ReporteException("ERROR: La descripción detallada del reporte puede tener hasta un máximo de 1000 caracteres.");
        
        if(reporte.getTestigos() != null && reporte.getTestigos().isEmpty())
            reporte.setTestigos(null);
        
        if(reporte.getImpactoIncidente() == null)
            throw new ReporteException("ERROR: El reporte debe tener un impacto del incidente asociado.");
        
        if(reporte.getImpactoIncidente().trim().isEmpty())
            throw new ReporteException("ERROR: El reporte debe tener un impacto del incidente asociado.");
        
        if(reporte.getImpactoIncidente().length() > 150)
            throw new ReporteException("ERROR: El impacto del incidente puede tener hasta un máximo de 150 caracteres.");
        
        if(reporte.getAccionesPrevias() != null && reporte.getAccionesPrevias().length() > 200)
            throw new ReporteException("ERROR: La descripción de las acciones previas puede tener hasta un méximo de 200 caracteres.");
        
    }
}