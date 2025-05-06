/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Empleado;
import Entidades.Nomina;
import Exceptions.AccesoDatosException;
import java.time.LocalDate;

/**
 *
 * @author skyro
 */
public interface INominaDAO {
    
    public boolean guardarNomina(Nomina nomina) throws AccesoDatosException;
    
    public LocalDate obtenerFechaUltimaNomina(Empleado empleado) throws AccesoDatosException;
}
