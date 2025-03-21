/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarNomina;

import Excepciones.SistemaCorreoException;
import Exceptions.GenerarNominaException;
import Interface.ISistemaCorreo;
import Interfaces.IGenerarNomina;
import SistemaCorreo.SistemaCorreo;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.io.File;
import java.net.URI;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class GenerarNomina implements IGenerarNomina {

    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) {
        
        NominaDTO nomina = new NominaDTO(empleado, 0, calcularISR(8000, 14), empleado.getSalarioBase(), 0, LocalDate.now(), 40, 5);
        nomina.setSalarioNeto(nomina.getSalarioBruto() - nomina.getIsr());
        return nomina;
    }

    @Override
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException{
        ISistemaCorreo sistemaCorreo = new SistemaCorreo();
        
        try {
            sistemaCorreo.enviarCorreo(nomina);
            return true;
        } catch (SistemaCorreoException ex) {
            Logger.getLogger(GenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException("Ocurrió un error al enviar el correo.");
        }
    }
    
    // Tabla del SAT (Límite Inferior, Cuota Fija, % Excedente)
    private final double[][] TABLA_ISR = {
        {0.01, 0.00, 1.92},
        {746.05, 14.32, 6.40},
        {6332.06, 371.83, 10.88},
        {11128.02, 893.63, 16.00},
        {12934.84, 1198.93, 17.92},
        {15487.73, 1742.13, 21.36},
        {19391.45, 2612.89, 23.52},
        {24518.46, 3962.34, 30.00},
        {32324.03, 6351.23, 32.00},
        {38177.70, 8482.74, 34.00},
        {74835.47, 22159.88, 35.00}
    };

    public double calcularISR(double ingresoTotal, int diasPagados) {
        double ingresoDiario = ingresoTotal / diasPagados;
        double ingresoMensual = ingresoDiario * 30.4;

        // Buscar el rango en la tabla del SAT
        double cuotaFija = 0, tasaExcedente = 0, limiteInferior = 0;
        for (double[] rango : TABLA_ISR) {
            if (ingresoMensual >= rango[0]) {
                limiteInferior = rango[0];
                cuotaFija = rango[1];
                tasaExcedente = rango[2];
            } else {
                break;
            }
        }

        // Calcular ISR mensual
        double excedente = ingresoMensual - limiteInferior;
        double isrMensual = cuotaFija + (excedente * (tasaExcedente / 100));

        // Ajustar ISR a los días trabajados
        return isrMensual * (diasPagados / 30.4);
    }


}
