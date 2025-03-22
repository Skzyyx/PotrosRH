/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author skyro
 */
public enum Bonos {
    
    NINGUNO(0.0),
    DESEMPEÑO(100.0),
    ASISTENCIA(200.0),
    VENTAS(300.0),
    ANTIGUEDAD(400.0);
    
    private final double cantidad;

    private Bonos(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }
}
