package Entidades;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Direccion {
    private String calle;
    private String numero;
    private String colonia;

    public Direccion() {}
    
    public Direccion(String calle, String numero, String colonia) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    public String getCalle() {return calle;}

    public void setCalle(String calle) {this.calle = calle;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public String getColonia() {return colonia;}

    public void setColonia(String colonia) {this.colonia = colonia;}

    @Override
    public String toString() {return String.format("%s, %s, %s", getCalle(), getColonia(), getNumero());}
}