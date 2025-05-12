package DTOs;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class EmpleadoDTO {
    private String rfc;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String estado;
    private String departamento;
    private String puesto;

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public EmpleadoDTO(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String departamento, String puesto) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.departamento = departamento;
        this.puesto = puesto;
    }

    public EmpleadoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String departamento, String puesto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.departamento = departamento;
        this.puesto = puesto;
    }

    public EmpleadoDTO(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public EmpleadoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String puesto) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "EmpleadoDTO{" + "rfc=" + rfc + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", estado=" + estado + ", departamento=" + departamento + ", puesto=" + puesto + '}';
    }
    
}