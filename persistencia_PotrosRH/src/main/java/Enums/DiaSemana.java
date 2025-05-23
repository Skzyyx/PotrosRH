/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public enum DiaSemana {
    
    LUNES(1),MARTES(2),MIERCOLES(3),JUEVES(4),VIERNES(5),SABADO(6),DOMINGO(7);
    
    private final int numero;

    private DiaSemana(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
        public static DiaSemana fromDayOfWeek(java.time.DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:    return LUNES;
            case TUESDAY:   return MARTES;
            case WEDNESDAY: return MIERCOLES;
            case THURSDAY:  return JUEVES;
            case FRIDAY:    return VIERNES;
            case SATURDAY:  return SABADO;
            case SUNDAY:    return DOMINGO;
            default:        return null;
        }
    }
}
