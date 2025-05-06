/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Empleado;
import Entidades.Nomina;
import Exceptions.AccesoDatosException;
import Interfaces.INominaDAO;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaDAO implements INominaDAO {

    private List<Nomina> nominas;

    
    @Override
    public boolean guardarNomina(Nomina nomina) throws AccesoDatosException {
        nominas.add(nomina);
        return true;
    }

    @Override
    public LocalDate obtenerFechaUltimaNomina(Empleado empleado) throws AccesoDatosException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
