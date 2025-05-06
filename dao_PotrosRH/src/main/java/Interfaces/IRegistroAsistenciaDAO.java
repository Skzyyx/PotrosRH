package Interfaces;

import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import java.time.LocalDate;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IRegistroAsistenciaDAO {
    
    public Integer obtenerDiasTrabajados(Empleado empleado) throws AccesoDatosException;
    
    public Integer obtenerHorasTrabajadas(Empleado empleado) throws AccesoDatosException;
    
    public LocalDate obtenerFechaPrimerDiaTrabajo(Empleado empleado) throws AccesoDatosException;
    
}