package DAO;

import Entidades.Empleado;
import Entidades.Nomina;
import Exceptions.AccesoDatosException;
import Interfaces.INominaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaDAO implements INominaDAO {

    private final List<Nomina> nominas = new ArrayList<>();
    
    @Override
    public boolean guardarNomina(Nomina nomina) throws AccesoDatosException {
        nominas.add(nomina);
        return true;
    }

    @Override
    public LocalDate obtenerFechaUltimaNomina(Empleado empleado) throws AccesoDatosException {
        return null;
    }
}