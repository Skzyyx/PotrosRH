package dto;

import enums.EstadoEmpleado;

/**
 * Objeto de transferencia para Empleados.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String rfc;
    private String calle;
    private String colonia;
    private String numero;
    private String telefono;
    private String departamento;
    private String puesto;
    private double salarioBase;
    private EstadoEmpleado estado;
    
    public EmpleadoDTO() {}
  
    public EmpleadoDTO(
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            String email, 
            String rfc, 
            String calle, 
            String colonia, 
            String numero, 
            String telefono, 
            String departamento, 
            String puesto, 
            double salarioBase, 
            EstadoEmpleado estado
    ) 
    {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.rfc = rfc;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.telefono = telefono;
        this.departamento = departamento;
        this.puesto = puesto;
        this.salarioBase = salarioBase;
        this.estado = estado;
    }
    
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidoPaterno() {return apellidoPaterno;}

    public void setApellidoPaterno(String apellidoPaterno) {this.apellidoPaterno = apellidoPaterno;}

    public String getApellidoMaterno() {return apellidoMaterno;}

    public void setApellidoMaterno(String apellidoMaterno) {this.apellidoMaterno = apellidoMaterno;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getRfc() {return rfc;}

    public void setRfc(String rfc) {this.rfc = rfc;}

    public String getCalle() {return calle;}

    public void setCalle(String calle) {this.calle = calle;}

    public String getColonia() {return colonia;}

    public void setColonia(String colonia) {this.colonia = colonia;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getDepartamento() {return departamento;}

    public void setDepartamento(String departamento) {this.departamento = departamento;}

    public String getPuesto() {return puesto;}

    public void setPuesto(String puesto) {this.puesto = puesto;}

    public double getSalarioBase() {return salarioBase;}

    public void setSalarioBase(double salarioBase) {this.salarioBase = salarioBase;}

    public EstadoEmpleado getEstado() {return estado;}

    public void setEstado(EstadoEmpleado estado) {this.estado = estado;}
    
    @Override
    public String toString() {
        return "EmpleadoDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", rfc=" + rfc + ", calle=" + calle + ", colonia=" + colonia + ", numero=" + numero + ", telefono=" + telefono + ", departamento=" + departamento + ", puesto=" + puesto + ", salarioBase=" + salarioBase + ", estado=" + estado + '}';
    }
}