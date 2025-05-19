package bo;

import DAO.EmpleadoDAO;
import DAO.ReporteMalaConductaDAO;
import Entidades.Empleado;
import Entidades.ReporteMalaConducta;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IEmpleadoDAO;
import Interfaces.IReporteMalaConductaBO;
import Interfaces.IReporteMalaConductaDAO;
import dto.EmpleadoDTO;
import dto.ReporteMalaConductaDTO;
import dto.ReporteRevisadoOmitidoDTO;
import dto.ReporteRevisadoSancionadoDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mappers.EmpleadoMapper;
import mappers.ReporteMalaConductaMapper;
import mappers.ReporteRevisadoMapper;

/**
 * Objeto de negocio ReporteMalaConductaBO que implementa la interfaz IReporteMalaConductaBO. 
 * Mapea entidades ReporteMalaConducta, ReporteRevisadoSancionado y ReporteRevisadoOmitido
 * a sus respectivos DTOs y llama a los métodos de ReporteMalaConductaDAO.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteMalaConductaBO implements IReporteMalaConductaBO {
    // Atributo DAO para operaciones CRUD con entidades ReporteMalaConducta, ReporteRevisadoSancionado y ReporteRevisadoOmitido.
    private final IReporteMalaConductaDAO reportesDAO = new ReporteMalaConductaDAO();
    // Atributo DAO para obtener empleados a partir de sus IDs.
    private final IEmpleadoDAO empleadoDAO = new EmpleadoDAO();
    // Atributo SingleTon de la clase.
    private static ReporteMalaConductaBO instance;
    /**
     * Contructor por defecto.
     */
    private ReporteMalaConductaBO() {}
    
    /**
     * Método SingleTon de la clase.
     * @return Instancia SingleTon de la clase.
     */
    public static synchronized ReporteMalaConductaBO getInstance() {
        if (instance == null) 
            instance = new ReporteMalaConductaBO();
        return instance;
    }
    /**
     * Registra un nuevo reporte de mala conducta. Mapea el DTO recibido a su
     * entidad correspondiente ReporteMalaConducta.
     * @param reporteNuevo Reporte de Mala Conducta a persistir.
     * @return Reporte registrado.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    @Override
    public ReporteMalaConductaDTO registrarReporteNuevo(ReporteMalaConductaDTO reporteNuevo) throws ObjetosNegocioException{
        try {
            
            if(reporteNuevo == null)
                throw new ObjetosNegocioException("El reporte está vacío.");
            
            return ReporteMalaConductaMapper.toDTO(reportesDAO.registrarReporteNuevo(ReporteMalaConductaMapper.toEntityNuevo(reporteNuevo)));
            
        } catch (AccesoDatosException e) {throw new ObjetosNegocioException(e.getMessage(), e);}
    }
    /**
     * Obtiene un reporte de mala conducta de la base de datos. Mapea las entidades obtenidas
     * a sus correspondientes objetos ReporteMalaConductaDTO.
     * @param empleado Empleado a buscar, asociado a un reporte de mala conducta.
     * @param fechaIncidente Fecha del incidente.
     * @return Lista de reportes coincidentes.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    @Override
    public List<ReporteMalaConductaDTO> obtenerReporteEmpleado(EmpleadoDTO empleado, LocalDate fechaIncidente) throws ObjetosNegocioException{
        
        if(empleado == null)
            throw new ObjetosNegocioException("No se permite RFC vacío.");

        Empleado empleadoRfc = new Empleado();
        empleadoRfc.setRfc(empleado.getRfc());
        
        try {
            
            List<ReporteMalaConductaDTO> reportesObtenidosMapeados = new ArrayList<>();
            List<ReporteMalaConducta> reportesObtenidos = reportesDAO.obtenerReporteEmpleado(empleadoRfc, fechaIncidente);
            
            if(reportesObtenidos != null && !reportesObtenidos.isEmpty()){
                for(ReporteMalaConducta reporteMalaConducta : reportesObtenidos){
                    // Se mapea el reporte obtenido de la manera convencional.
                    ReporteMalaConductaDTO reporteObtenido = ReporteMalaConductaMapper.toDTO(reporteMalaConducta);
                    
                    // Se encapsula el ID del empleado reportante obtenido en una entidad Empleado.
                    Empleado empleadoReportado = new Empleado();
                    empleadoReportado.setId(reporteMalaConducta.getEmpleadoReportado());
                    // Se busca la entidad completa del empleado reportado a partir de su ID.
                    empleadoReportado = empleadoDAO.obtenerEmpleadoId(empleadoReportado);
                    // Se mapea la entidad obtenida y se añade al reporte obtenido.
                    reporteObtenido.setEmpleadoReportado(EmpleadoMapper.toDTO(empleadoReportado));
                    
                    // Se realiza el mismo proceso con el empleado reportante.
                    Empleado empleadoReportante = new Empleado();
                    empleadoReportante.setId(reporteMalaConducta.getEmpleadoReportante());
                    empleadoReportante = empleadoDAO.obtenerEmpleadoId(empleadoReportante);
                    reporteObtenido.setEmpleadoReportante(EmpleadoMapper.toDTO(empleadoReportante));
                    // Se agrega a la lista de reportes obtenidos, con los empleados completos.
                    reportesObtenidosMapeados.add(reporteObtenido);
                }
                return reportesObtenidosMapeados;
            } else
                return null;
            
        } catch (AccesoDatosException e) {throw new ObjetosNegocioException(e.getMessage(), e);}
    }
    /**
     * Obtiene una lista de reportes que coincidan con el RFC y la fecha
     * del incidente recibidas.
     * @param reporteSeguimiento Reporte con número de seguimiento.
     * @return Reporte encontrado.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    @Override
    public ReporteMalaConductaDTO obtenerReporteSeguimiento(ReporteMalaConductaDTO reporteSeguimiento) throws ObjetosNegocioException{
        
        if(reporteSeguimiento == null)
            throw new ObjetosNegocioException("No se permite un número de seguimiento vacío.");
        
        ReporteMalaConducta reporte = new ReporteMalaConducta();
        reporte.setNumeroSeguimiento(reporteSeguimiento.getNumeroSeguimiento());
        
        try {
            // Se ejecuta la consulta y se almacena el resultado en la misma entidad.
            reporte = reportesDAO.obtenerReporteSeguimiento(reporte);
            
            // Si no se encontró el reporte esperado, se retorna null.
            if(reporte == null)
                return null;
            
            // Se mapea el reporte obtenido de la manera convencional.
            ReporteMalaConductaDTO reporteObtenido = ReporteMalaConductaMapper.toDTO(reporte);
            
            // Se encapsula el ID del empleado reportante obtenido en una entidad Empleado.
            Empleado empleadoReportado = new Empleado();
            empleadoReportado.setId(reporte.getEmpleadoReportado());
            // Se busca la entidad completa del empleado reportado a partir de su ID.
            empleadoReportado = empleadoDAO.obtenerEmpleadoId(empleadoReportado);
            // Se mapea la entidad obtenida y se añade al reporte obtenido.
            reporteObtenido.setEmpleadoReportado(EmpleadoMapper.toDTO(empleadoReportado));

            // Se realiza el mismo proceso con el empleado reportante.
            Empleado empleadoReportante = new Empleado();
            empleadoReportante.setId(reporte.getEmpleadoReportante());
            empleadoReportante = empleadoDAO.obtenerEmpleadoId(empleadoReportante);
            reporteObtenido.setEmpleadoReportante(EmpleadoMapper.toDTO(empleadoReportante));
            
            // Se regresa el reporte obtenido, ahora con la información de los empleados completa.
            return reporteObtenido;
            
        } catch (AccesoDatosException e) {throw new ObjetosNegocioException(e.getMessage(), e);}
    }
    /**
     * Registra un nuevo reporte de mala conducta revisado y sancionado. Mapea el DTO recibido a su
     * entidad correspondiente ReporteRevisadoSancionado.
     * @param reporteSancionadoNuevo Reporte Revisado Sancionado a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    @Override
    public ReporteRevisadoSancionadoDTO registrarReporteSancionado(ReporteRevisadoSancionadoDTO reporteSancionadoNuevo) throws ObjetosNegocioException {
        try {
            
            if(reporteSancionadoNuevo == null)
                throw new ObjetosNegocioException("El reporte sancionado está vacío.");
            
            return ReporteRevisadoMapper.toDTOSancionado(reportesDAO.registrarReporteSancionado(ReporteRevisadoMapper.toEntityNuevoSancionado(reporteSancionadoNuevo)));
            
        } catch (AccesoDatosException ex) {throw new ObjetosNegocioException(ex.getMessage(), ex);}
    }
    /**
     * Registra un nuevo reporte de mala conducta revisado y omitido. Mapea el DTO recibido a su
     * entidad correspondiente ReporteRevisadoOmitido.
     * @param reporteOmitidoNuevo Reporte Revisado Omitido a persistir.
     * @return VERDADERO si el registro fue exitoso, FALSO en caso contrario.
     * @throws ObjetosNegocioException Excepción del proyecto.
     */
    @Override
    public ReporteRevisadoOmitidoDTO registrarReporteOmitido(ReporteRevisadoOmitidoDTO reporteOmitidoNuevo) throws ObjetosNegocioException {
        try {
            
            if(reporteOmitidoNuevo == null)
                throw new ObjetosNegocioException("El reporte omitido está vacío.");
            
            return ReporteRevisadoMapper.toDTOOmitido(reportesDAO.registrarReporteOmitido(ReporteRevisadoMapper.toEntityNuevoOmitido(reporteOmitidoNuevo)));
            
        } catch (AccesoDatosException e) {throw new ObjetosNegocioException(e.getMessage(), e);}
    }
}