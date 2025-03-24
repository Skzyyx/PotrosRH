/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import dto.NominaDTO;

/**
 *
 * @author alfre
 */
public class NominaBO {
    private NominaDTO nomina;

    public NominaBO(NominaDTO nomina) {
        this.nomina = nomina;
    }

    public double calcularSalarioTotal() {
        return nomina.getSalarioBruto() + nomina.getBono() - nomina.getIsr();
    }
}