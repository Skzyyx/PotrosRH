/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para filtrar
 * empleados. Contiene los criterios de búsqueda que se pueden utilizar para
 * filtrar empleados en el sistema de gestión de recursos humanos.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class EmpleadoFiltroDTO {

    private String rfc;
    private String email;
    private String telefono;

    /**
     * Constructor por defecto.
     */
    public EmpleadoFiltroDTO() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param rfc RFC del empleado a filtrar
     * @param email Correo electrónico del empleado a filtrar
     * @param telefono Número de teléfono del empleado a filtrar
     */
    public EmpleadoFiltroDTO(String rfc, String email, String telefono) {
        this.rfc = rfc;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * Obtiene el RFC utilizado como criterio de filtrado.
     *
     * @return RFC del empleado
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC como criterio de filtrado.
     *
     * @param rfc Nuevo RFC para filtrar
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el correo electrónico utilizado como criterio de filtrado.
     *
     * @return Correo electrónico del empleado
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico como criterio de filtrado.
     *
     * @param email Nuevo correo electrónico para filtrar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de teléfono utilizado como criterio de filtrado.
     *
     * @return Número de teléfono del empleado
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono como criterio de filtrado.
     *
     * @param telefono Nuevo número de teléfono para filtrar
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación en cadena de texto del objeto
     * EmpleadoFiltroDTO.
     *
     * @return Cadena con todos los criterios de filtrado
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmpleadoFiltroDTO{");
        sb.append("rfc=").append(rfc);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
}
