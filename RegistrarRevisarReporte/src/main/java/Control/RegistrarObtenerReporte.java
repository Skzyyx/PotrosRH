package Control;

import Exception.ReporteException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IReporteMalaConductaBO;
import bo.ReporteMalaConductaBO;
import dto.EmpleadoDTO;
import dto.ReporteMalaConductaDTO;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
     * @return Reporte de mala conducta a registrar.
     * @throws ReporteException Excepción del subsistema.
     */
    public ReporteMalaConductaDTO registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ReporteException {
        
        if(reporteNuevo == null)
            throw new ReporteException("ERROR: El reporte no puede ser nulo.");
        
        verificarReporte(reporteNuevo);
        
        try {
            // Se agrega la fecha de hoy como fecha de registro del nuevo reporte.
            reporteNuevo.setFechaRegistro(LocalDate.now());
            
            do // Genera un nuevo número de seguimiento y lo asigna al nuevo reporte.
                reporteNuevo.setNumeroSeguimiento(new SecureRandom().nextLong(9999999999L));
            // Mientras no haya otro reporte con el mismo número de seguimiento (demasiado poco probable, pero no vaya a ser).
            while (reporteBO.obtenerReporteSeguimiento(reporteNuevo) != null);
            
            // Ejecuta el registro del nuevo reporte, y devuelve el mismo recién registrado.
            return reporteBO.registrarReporteNuevo(reporteNuevo);
            
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
    }
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param empleado Empleado a buscar, asociado a un reporte de mala conducta.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes obtenidos.
     * @throws ReporteException Excepción del subsistema.
     */
    public List<ReporteMalaConductaDTO> obtenerReporteEmpleado(EmpleadoDTO empleado, LocalDate fechaIncidente) throws ReporteException {
        
        if(!(empleado != null && !empleado.getRfc().isEmpty()))
                throw new ReporteException("No se permite un RFC vacío.");
        
        if(fechaIncidente == null)
            throw new ReporteException("Seleccione una fecha del incidente.");
        
        if(fechaIncidente.isAfter(LocalDate.now()))
            throw new ReporteException("No se permite una fecha posterior al actual.");
        
        try {
            // Lista de reportes sin revisar.
            List<ReporteMalaConductaDTO> reportesNoRevisados = new ArrayList<>();
            // Lista de reportes obtenidos, ejecutando la consulta a partir del RFC del empleado y la fecha obtenida.
            List<ReporteMalaConductaDTO> reportesObtenidos = reporteBO.obtenerReporteEmpleado(empleado, fechaIncidente);
            if(reportesObtenidos != null && !reportesObtenidos.isEmpty()){
                for(ReporteMalaConductaDTO reporte: reportesObtenidos){
                    if(reporte.getEstadoReporte().equals("NO_REVISADO"))
                        reportesNoRevisados.add(reporte);
                }
                // Si se encontraron reportes, pero ya fueron revisados.
                if(reportesNoRevisados.isEmpty())
                    throw new ReporteException("Todos los reportes asociados al empleado ya han sido revisados en la fecha especificada.");
                // Si se encontraron reportes sin revisar.
                else // Se regresa la lista con los reportes no revisados.
                    return reportesNoRevisados;
            } else // Si no se encontró ningún reporte asociado al empleado.
                throw new ReporteException("No existen reportes sin revisar asociados al empleado en la fecha especificada.");
            
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
    }
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param reporteSeguimiento Reporte con número de seguimiento.
     * @return Lista de reportes obtenidos.
     * @throws ReporteException Excepción del subsistema.
     */
    public ReporteMalaConductaDTO obtenerReporteSeguimiento(ReporteMalaConductaDTO reporteSeguimiento) throws ReporteException{
        
        if(!(reporteSeguimiento != null && reporteSeguimiento.getNumeroSeguimiento() != null))
                throw new ReporteException("No se permite un número de seguimiento vacío");
        
        try {
            
            ReporteMalaConductaDTO reporteNoRevisado = reporteBO.obtenerReporteSeguimiento(reporteSeguimiento);
            
            if(reporteNoRevisado == null)
                throw new ReporteException("No se encontró ningún reporte con el número de seguimiento recibido.");
            
            else if(reporteNoRevisado.getEstadoReporte().equals("REVISADO"))
                throw new ReporteException("El reporte ya ha sido revisado anteriormente.");
            
            else
                return reporteNoRevisado;
            
        } catch (ObjetosNegocioException e) {throw new ReporteException(e.getMessage(), e);}
    }
    /**
     * Verifica que el contenido del reporte sea válido.
     * @param reporte Reporte a revisar.
     * @throws ReporteException Excepción del subsistema.
     */
    private void verificarReporte(ReporteMalaConductaDTO reporte) throws ReporteException{
        // Si el empleado reportado no existe
        if(!(reporte.getEmpleadoReportado() != null && !reporte.getEmpleadoReportado().getId().isEmpty()))
            throw new ReporteException("El reporte debe tener asociado a un empleado a reportar.");
        
        // Si el empleado reportante no existe
        if(!(reporte.getEmpleadoReportante() != null && !reporte.getEmpleadoReportante().getId().isEmpty()))
            throw new ReporteException("El reporte debe tener asociado a un empleado responsable del reporte.");
        
        // Si el ID del empleado reportado es el mismo que el del empleado reportante.
        if(reporte.getEmpleadoReportante().getId().equals(reporte.getEmpleadoReportado().getId()))
            throw new ReporteException("El empleado no se puede reportar a sí mismo. Elija dos empleados diferentes");
        
        // Si la fecha y hora del incidente no existe.
        if(reporte.getFechaHoraIncidente() == null)
            throw new ReporteException("El reporte debe contar con la fecha del incidente.");
        
        // Si la fecha y hora del incidente existe, pero está después de la fecha y hora actual.
        if(reporte.getFechaHoraIncidente().isAfter(LocalDateTime.now()))
            throw new ReporteException("La fecha y hora elegida no puede estar después de la fecha y hora actual.");
        
        // Si el lugar del incidente no existe o está vacío.
        if(!(reporte.getLugarIncidente() != null && !reporte.getLugarIncidente().trim().isEmpty()))
            throw new ReporteException("El reporte debe contar con un lugar del incidente asociado obligatorio.");
        
        // Si la cantidad de caracteres del lugar del incidente es mayor a 100.
        if(reporte.getLugarIncidente().length() > 100)
            throw new ReporteException("Solo se permiten máximo 100 caracteres para el lugar del incidente.");
        
        // Si la descripción detallada del incidente no existe o está vacía.
        if(!(reporte.getDescripcionDetallada() != null && !reporte.getDescripcionDetallada().trim().isEmpty()))
            throw new ReporteException("El reporte debe contar con una descripción detallada del incidente.");
        
        // Si la cantidad de caracteres de la descripción detallada del incidentes es superior a 1000.
        if(reporte.getDescripcionDetallada().length() > 1000)
            throw new ReporteException("La descripción detallada del reporte puede tener hasta un máximo de 1000 caracteres.");
        
        // Si la lista de testigos existe, pero está vacía, se agrega como null al atributo del reporte.
        if(reporte.getTestigos() != null && reporte.getTestigos().isEmpty())
            reporte.setTestigos(null);
        
        // Si el impacto del incidente no existe o está vacío.
        if(!(reporte.getImpactoIncidente() != null && !reporte.getImpactoIncidente().trim().isEmpty()))
            throw new ReporteException("El reporte debe tener un impacto del incidente asociado.");
        
        // Si la cantidad de caracteres del impacto del incidente es superior a 150.
        if(reporte.getImpactoIncidente().length() > 150)
            throw new ReporteException("El impacto del incidente puede tener hasta un máximo de 150 caracteres.");
        
        // Si la descripción de acciones previas del empleado reportado sí existe, pero está vacía, se agrega null a dicho atributo.
        if(reporte.getAccionesPrevias() != null && reporte.getAccionesPrevias().trim().isEmpty())
            reporte.setAccionesPrevias(null);
        
        // Si se ingresó una descripción de acciones previas del empleado reportado, y su tamaño es superior a 200 caracteres.
        if((reporte.getAccionesPrevias() != null && !reporte.getAccionesPrevias().trim().isEmpty()) && reporte.getAccionesPrevias().length() > 200)
            throw new ReporteException("La descripción de las acciones previas puede tener hasta un méximo de 200 caracteres.");
        
    }
}