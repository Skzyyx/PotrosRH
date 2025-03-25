package bo;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaBO {
    
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

    public NominaBO() {}

    public NominaDTO generarNomina(EmpleadoDTO empleado) throws ObjetosNegocioException {
        if (empleado == null) {
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        }
        NominaDTO nomina = new NominaDTO(empleado, 0, empleado.getSalarioBase(), calcularISR(empleado.getSalarioBase(), 14), 0, LocalDate.now(), 40, 5);
        nomina.setSalarioNeto(nomina.getSalarioBruto() - nomina.getIsr());
        return nomina;
    } 
    
    public boolean guardarNomina(NominaDTO nomina) {
        return new Random().nextBoolean();
    }
    
    private double calcularISR(double ingresoTotal, int diasPagados) {
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