package Entidades;

import enums.EstadoEmpleado;
import java.util.List;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Empleado {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String rfc;
    private String curp;
    private Direccion direccion;
    private String telefono;
    private String departamento;
    private String puesto;
    private Double salarioBase;
    private EstadoEmpleado estado;
    private List<HorarioLaboral> horariosLaborales;

    public Empleado() {}

    public Empleado(
            String nombre, 
            String apellidoPaterno, 
            String apellidoMaterno, 
            String email, 
            String rfc, 
            String curp, 
            Direccion direccion, 
            String telefono, 
            String departamento, 
            String puesto, 
            Double salarioBase, 
            EstadoEmpleado estado,
            List<HorarioLaboral> horariosLaborales
    ) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.rfc = rfc;
        this.curp = curp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.departamento = departamento;
        this.puesto = puesto;
        this.salarioBase = salarioBase;
        this.estado = estado;
        this.horariosLaborales = horariosLaborales;
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

    public String getCurp() {return curp;}

    public void setCurp(String curp) {this.curp = curp;}

    public Direccion getDireccion() {return direccion;}

    public void setDireccion(Direccion direccion) {this.direccion = direccion;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getDepartamento() {return departamento;}

    public void setDepartamento(String departamento) {this.departamento = departamento;}

    public String getPuesto() {return puesto;}

    public void setPuesto(String puesto) {this.puesto = puesto;}

    public Double getSalarioBase() {return salarioBase;}

    public void setSalarioBase(Double salarioBase) {this.salarioBase = salarioBase;}

    public EstadoEmpleado getEstado() {return estado;}

    public void setEstado(EstadoEmpleado estado) {this.estado = estado;}

    public List<HorarioLaboral> getHorariosLaborales() {return horariosLaborales;}

    public void setHorariosLaborales(List<HorarioLaboral> horariosLaborales) {this.horariosLaborales = horariosLaborales;}
    
    public boolean compararRFC (String rfc){return rfc.equals(this.rfc);}

    @Override
    public String toString() {return 
            String.format(
                    "%s %s %s, %s, %s, %s, %s", 
                    getNombre(), 
                    getApellidoPaterno(), 
                    getApellidoMaterno(), 
                    getEmail(), 
                    getTelefono(), 
                    getDepartamento(), 
                    getPuesto());
    }
}