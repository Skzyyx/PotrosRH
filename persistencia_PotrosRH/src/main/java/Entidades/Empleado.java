package Entidades;

import Enums.EstadoEmpleado;
import java.util.List;

/**
 * Clase que representa a un Empleado.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Empleado {
    // Atributos de un empleado.
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
    /**
     * Constructor por defecto.
     */
    public Empleado() {}
    /**
     * Constructor que recibe los atributos.
     * @param nombre Nombre del empleado.
     * @param apellidoPaterno Apellido paterno del empleado.
     * @param apellidoMaterno Apellido materno del empleado.
     * @param email Correco electrónico del empleado.
     * @param rfc RFC del empleado.
     * @param curp CURP del empleado.
     * @param direccion Dirección del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param departamento Departamento en la empresa del empleado.
     * @param puesto Pueso en la empresa del empleado.
     * @param salarioBase Salario base del empleado.
     * @param estado Estado actual del empleado.
     * @param horariosLaborales Horarios laborales del empleado.
     */
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
    /**
     * Retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre() {return nombre;}
    /**
     * Establece el nombre del empleado.
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {this.nombre = nombre;}
    /**
     * Retorna el apellido paterno del empleado.
     * @return Apellido paterno del empleado.
     */
    public String getApellidoPaterno() {return apellidoPaterno;}
    /**
     * Establece el apellido paterno del empleado.
     * @param apellidoPaterno Nuevo apellido paterno del empleado.
     */
    public void setApellidoPaterno(String apellidoPaterno) {this.apellidoPaterno = apellidoPaterno;}
    /**
     * Retorna el apellido materno del empleado.
     * @return Apellido materno del empleado.
     */
    public String getApellidoMaterno() {return apellidoMaterno;}
    /**
     * Establece el apellido materno del empleado.
     * @param apellidoMaterno Nuevo apellido materno del empleado.
     */
    public void setApellidoMaterno(String apellidoMaterno) {this.apellidoMaterno = apellidoMaterno;}
    /**
     * Retorna el correo electrónico del empleado.
     * @return Correo electrónico del empleado.
     */
    public String getEmail() {return email;}
    /**
     * Establece el correo electrónico del empleado.
     * @param email Nuevo correo electrónico del empleado.
     */
    public void setEmail(String email) {this.email = email;}
    /**
     * Retorna el RFC del empleado.
     * @return RFC del empleado.
     */
    public String getRfc() {return rfc;}
    /**
     * Establece el RFC del empleado.
     * @param rfc Nuevo RFC del empleado.
     */
    public void setRfc(String rfc) {this.rfc = rfc;}
    /**
     * Retorna la CURP del empleado.
     * @return CURP del empleado.
     */
    public String getCurp() {return curp;}
    /**
     * Establece la CURP del empleado.
     * @param curp Nueva CURP del empleado.
     */
    public void setCurp(String curp) {this.curp = curp;}
    /**
     * Retorna la dirección del empleado.
     * @return Dirección del empleado.
     */
    public Direccion getDireccion() {return direccion;}
    /**
     * Establece la dirección del empleado.
     * @param direccion Nueva dirección del empleado.
     */
    public void setDireccion(Direccion direccion) {this.direccion = direccion;}
    /**
     * Retorna el número de teléfono del empleado.
     * @return Número de teléfono del empleado.
     */
    public String getTelefono() {return telefono;}
    /**
     * Establece el número de teléfono del empleado.
     * @param telefono Nuevo número de teléfono del empleado.
     */
    public void setTelefono(String telefono) {this.telefono = telefono;}
    /**
     * Retorna el departamento en la empresa del empleado.
     * @return Departamento en la empresa del empleado.
     */
    public String getDepartamento() {return departamento;}
    /**
     * Establece el departamento en la empresa del empleado.
     * @param departamento Nuevo departamento en la empresa del empleado.
     */
    public void setDepartamento(String departamento) {this.departamento = departamento;}
    /**
     * Retorna el puesto en la empresa del empleado.
     * @return Puesto en la empresa del empleado.
     */
    public String getPuesto() {return puesto;}
    /**
     * Establece el puesto en la empresa del empleado.
     * @param puesto Nuevo puesto en la empresa del empleado.
     */
    public void setPuesto(String puesto) {this.puesto = puesto;}
    /**
     * Retorna el salario base del empleado.
     * @return Salario base del empleado.
     */
    public Double getSalarioBase() {return salarioBase;}
    /**
     * Establece el salario base del empleado.
     * @param salarioBase Nuevo salario base del empleado.
     */
    public void setSalarioBase(Double salarioBase) {this.salarioBase = salarioBase;}
    /**
     * Retorna el estado actual del empleado.
     * @return Estado actual del empleado.
     */
    public EstadoEmpleado getEstado() {return estado;}
    /**
     * Establece el estado actual del empleado.
     * @param estado Nuevo estado actual del empleado.
     */
    public void setEstado(EstadoEmpleado estado) {this.estado = estado;}
    /**
     * Retorna la lista de horarios laborales del empleado.
     * @return Lista de horarios laborales del empleado.
     */
    public List<HorarioLaboral> getHorariosLaborales() {return horariosLaborales;}
    /**
     * Establece la lista de horarios laborales del empleado.
     * @param horariosLaborales Nueva lista de horarios laborales del empleado.
     */
    public void setHorariosLaborales(List<HorarioLaboral> horariosLaborales) {this.horariosLaborales = horariosLaborales;}
    /**
     * Compara el RFC recibido con el RFC del empleado.
     * @param rfc RFC a comparar.
     * @return VERDADERO si ambos RFCs coinciden, FALSO en caso contrario.
     */
    public boolean compararRFC (String rfc){return rfc.equals(this.rfc);}
    /**
     * Regresa una cadena con la información relevante del empleado.
     * @return Cadena con la información relevante del empleado.
     */
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