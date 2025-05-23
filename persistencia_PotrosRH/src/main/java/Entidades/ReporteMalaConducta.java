package Entidades;

import Enums.EstadoReporte;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad ReporteMalaConducta.
 * @author Leonardo Flores Leyva (252390)
 */
public class ReporteMalaConducta {
    // Atributos de un reporte de mala conducta.
    private ObjectId id;
    private Long numeroSeguimiento;
    private ObjectId empleadoReportado;
    private ObjectId empleadoReportante;
    private LocalDateTime fechaHoraIncidente;
    private String lugarIncidente;
    private String descripcionDetallada;
    private List<String> testigos;
    private String impactoIncidente;
    private String accionesPrevias;
    private LocalDate fechaRegistro;
    private EstadoReporte estadoReporte;
    /**
     * Constructor por defecto.
     */
    public ReporteMalaConducta() {}
    /**
     * Constructor con todos los atributos, menos el ID.
     * @param numeroSeguimiento Número de seguimiento del reporte.
     * @param empleadoReportado Empleado reportado del reporte.
     * @param empleadoReportante Empleado reportante del reporte.
     * @param fechaHoraIncidente Fecha y hora del incidente.
     * @param lugarIncidente Lugar del incidente.
     * @param descripcionDetallada Descripción detallada del reporte.
     * @param testigos Testigos del reporte.
     * @param impactoIncidente Impacto de incidente
     * @param accionesPrevias Acciones previas del empleado reportado.
     * @param fechaRegistro Fecha de registro del reporte.
     * @param estadoReporte Estado del reporte.
     */
    public ReporteMalaConducta(
            Long numeroSeguimiento, 
            ObjectId empleadoReportado, 
            ObjectId empleadoReportante, 
            LocalDateTime fechaHoraIncidente, 
            String lugarIncidente, 
            String descripcionDetallada, 
            List<String> testigos, 
            String impactoIncidente, 
            String accionesPrevias, 
            LocalDate fechaRegistro, 
            EstadoReporte estadoReporte
    ) {
        this.numeroSeguimiento = numeroSeguimiento;
        this.empleadoReportado = empleadoReportado;
        this.empleadoReportante = empleadoReportante;
        this.fechaHoraIncidente = fechaHoraIncidente;
        this.lugarIncidente = lugarIncidente;
        this.descripcionDetallada = descripcionDetallada;
        this.testigos = testigos;
        this.impactoIncidente = impactoIncidente;
        this.accionesPrevias = accionesPrevias;
        this.fechaRegistro = fechaRegistro;
        this.estadoReporte = estadoReporte;
    }
    /**
     * Constructor con todos los atributos, incluido el ID.
     * @param id ID del reporte.
     * @param numeroSeguimiento Número de seguimiento del reporte.
     * @param empleadoReportado Empleado reportado del reporte.
     * @param empleadoReportante Empleado reportante del reporte.
     * @param fechaHoraIncidente Fecha y hora del incidente.
     * @param lugarIncidente Lugar del incidente.
     * @param descripcionDetallada Descripción detallada del reporte.
     * @param testigos Testigos del reporte.
     * @param impactoIncidente Impacto de incidente
     * @param accionesPrevias Acciones previas del empleado reportado.
     * @param fechaRegistro Fecha de registro del reporte.
     * @param estadoReporte Estado del reporte.
     */
    public ReporteMalaConducta(
            ObjectId id,
            Long numeroSeguimiento, 
            ObjectId empleadoReportado, 
            ObjectId empleadoReportante, 
            LocalDateTime fechaHoraIncidente, 
            String lugarIncidente, 
            String descripcionDetallada, 
            List<String> testigos, 
            String impactoIncidente, 
            String accionesPrevias, 
            LocalDate fechaRegistro, 
            EstadoReporte estadoReporte
    ) {
        this.id = id;
        this.numeroSeguimiento = numeroSeguimiento;
        this.empleadoReportado = empleadoReportado;
        this.empleadoReportante = empleadoReportante;
        this.fechaHoraIncidente = fechaHoraIncidente;
        this.lugarIncidente = lugarIncidente;
        this.descripcionDetallada = descripcionDetallada;
        this.testigos = testigos;
        this.impactoIncidente = impactoIncidente;
        this.accionesPrevias = accionesPrevias;
        this.fechaRegistro = fechaRegistro;
        this.estadoReporte = estadoReporte;
    }
    /**
     * Retorna el ID del reporte.
     * @return ID del reporte.
     */
    public ObjectId getId() {return id;}
    /**
     * Retorna el número de seguimiento del reporte.
     * @return Número de seguimiento del reporte.
     */
    public Long getNumeroSeguimiento() {return numeroSeguimiento;}
    /**
     * Retorna el empleado reportado del reporte.
     * @return Empleado reportado del reporte.
     */
    public ObjectId getEmpleadoReportado() {return empleadoReportado;}
    /**
     * Retorna el empleado reportante del reporte.
     * @return Empleado reportante del reporte.
     */
    public ObjectId getEmpleadoReportante() {return empleadoReportante;}
    /**
     * Retorna la fecha y hora del incidente.
     * @return Fecha y hora del incidente.
     */
    public LocalDateTime getFechaHoraIncidente() {return fechaHoraIncidente;}
    /**
     * Retorna el lugar del incidente.
     * @return Lugar del incidente.
     */
    public String getLugarIncidente() {return lugarIncidente;}
    /**
     * Retorna la descripción detallada del incidente.
     * @return Descripción detallada del incidente.
     */
    public String getDescripcionDetallada() {return descripcionDetallada;}
    /**
     * Retorna los testigos del incidente.
     * @return Testigos del incidente.
     */
    public List<String> getTestigos() {return testigos;}
    /**
     * Retorna el impacto del incidente.
     * @return Impacto del incidente.
     */
    public String getImpactoIncidente() {return impactoIncidente;}
    /**
     * Retorna las acciones previas del empleado reportado.
     * @return Acciones previas del empleado reportado.
     */
    public String getAccionesPrevias() {return accionesPrevias;}
    /**
     * Retorna la fecha de registro del reporte.
     * @return Fecha de registro del reporte.
     */
    public LocalDate getFechaRegistro() {return fechaRegistro;}
    /**
     * Retorna el estado del reporte.
     * @return Estado del reporte.
     */
    public EstadoReporte getEstadoReporte() {return estadoReporte;}
    /**
     * Establece el ID del reporte.
     * @param id Nuevo ID del reporte.
     */
    public void setId(ObjectId id) {this.id = id;}
    /**
     * Establece el número de seguimiento del reporte.
     * @param numeroSeguimiento Nuevo número de seguimiento del reporte.
     */
    public void setNumeroSeguimiento(Long numeroSeguimiento) {this.numeroSeguimiento = numeroSeguimiento;}
    /**
     * Establece el empleado reportado del reporte.
     * @param empleadoReportado Nuevo empleado reportado del reporte.
     */
    public void setEmpleadoReportado(ObjectId empleadoReportado) {this.empleadoReportado = empleadoReportado;}
    /**
     * Establece el empleado reportante del reporte.
     * @param empleadoReportante Nuevo empleado reportante del reporte.
     */
    public void setEmpleadoReportante(ObjectId empleadoReportante) {this.empleadoReportante = empleadoReportante;}
    /**
     * Establece la fecha y hora del incidente.
     * @param fechaHoraIncidente Nueva fecha y hora del incidente.
     */
    public void setFechaHoraIncidente(LocalDateTime fechaHoraIncidente) {this.fechaHoraIncidente = fechaHoraIncidente;}
    /**
     * Establece el lugar del incidente.
     * @param lugarIncidente Nuevo lugar del incidente.
     */
    public void setLugarIncidente(String lugarIncidente) {this.lugarIncidente = lugarIncidente;}
    /**
     * Establece la descripción detallada del incidente.
     * @param descripcionDetallada Nueva descripción detallada del incidente.
     */
    public void setDescripcionDetallada(String descripcionDetallada) {this.descripcionDetallada = descripcionDetallada;}
    /**
     * Establece los testigos del incidente.
     * @param testigos Nuevos testigos del incidente.
     */
    public void setTestigos(List<String> testigos) {this.testigos = testigos;}
    /**
     * Establece el impacto del incidente.
     * @param impactoAccidente Nuevo impacto del incidente.
     */
    public void setImpactoIncidente(String impactoAccidente) {this.impactoIncidente = impactoAccidente;}
    /**
     * Establece las acciones previas del empleado reportado.
     * @param accionesPrevias Nuevas acciones previas del empleado reportado.
     */
    public void setAccionesPrevias(String accionesPrevias) {this.accionesPrevias = accionesPrevias;}
    /**
     * Establece la fecha de registro del reporte.
     * @param fechaRegistro Nueva fecha de registro del reporte.
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {this.fechaRegistro = fechaRegistro;}
    /**
     * Establece el estado del reporte.
     * @param estadoReporte Nuevo estado del reporte.
     */
    public void setEstadoReporte(EstadoReporte estadoReporte) {this.estadoReporte = estadoReporte;}
    /**
     * Retorna una cadena con la información relevante del reporte.
     * @return Cadena con la información relevante del reporte.
     */
    @Override
    public String toString() {
        return "ReporteMalaConducta{" + "numeroSeguimiento=" + numeroSeguimiento + 
                ", empleadoReportado=" + empleadoReportado + 
                ", empleadoReportante=" + empleadoReportante + 
                ", fechaHoraIncidente=" + fechaHoraIncidente + 
                ", lugarIncidente=" + lugarIncidente + 
                ", fechaRegistro=" + fechaRegistro + 
                ", estadoReporte=" + estadoReporte + '}';
    }
}