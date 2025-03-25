package Interfaces;

import Exceptions.GenerarNominaException;
import dto.EmpleadoDTO;
import dto.NominaDTO;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IGenerarNomina {
    
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException;
    
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException;
}