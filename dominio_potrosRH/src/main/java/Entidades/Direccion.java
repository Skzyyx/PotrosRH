package Entidades;

/**
 * Dirección de un empleado.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Direccion {
    // Atributos de una dirección.
    private String calle;
    private String numero;
    private String colonia;
    /**
     * Constructor por defecto.
     */
    public Direccion() {}
    /**
     * Constructor que recibe todos los atributos como parámetros.
     * @param calle Calle de la dirección.
     * @param numero Número de casa de la dirección.
     * @param colonia Colonia de la dirección.
     */
    public Direccion(String calle, String numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }
    /**
     * Retorna la calle de la dirección.
     * @return Calle de la dirección.
     */
    public String getCalle() {return calle;}
    /**
     * Establece la calle de la dirección.
     * @param calle Nueva calle de la dirección.
     */
    public void setCalle(String calle) {this.calle = calle;}
    /**
     * Retorna el número de casa de la dirección.
     * @return Númnero de casa de la dirección.
     */
    public String getNumero() {return numero;}
    /**
     * Establece el número de casa de la dirección.
     * @param numero Nuevo número de casa de la dirección.
     */
    public void setNumero(String numero) {this.numero = numero;}
    /**
     * Retorna la colonia de la dirección.
     * @return Colonia de la dirección.
     */
    public String getColonia() {return colonia;}
    /**
     * Establece la colonia de la dirección.
     * @param colonia Nueva colonia de la dirección.
     */
    public void setColonia(String colonia) {this.colonia = colonia;}
    /**
     * Retorna una cadena con la información relevante de la dirección.
     * @return Cadena con la información relevante de la dirección.
     */
    @Override
    public String toString() {return String.format("%s, %s, %s", getCalle(), getColonia(), getNumero());}
}