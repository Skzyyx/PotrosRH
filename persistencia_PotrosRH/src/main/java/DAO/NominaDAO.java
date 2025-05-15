package DAO;

import Entidades.Empleado;
import Entidades.Nomina;
import Exceptions.AccesoDatosException;
import Interfaces.INominaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para métodos de Persistencia con entidades Nomina.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class NominaDAO implements INominaDAO {
    // Lista de nóminas que simula la BD.
    private final List<Nomina> nominas = new ArrayList<>();
    /**
     * Guarda una nueva nómina en la base de datos.
     * @param nomina Nómina a guardar.
     * @return VERDADERO si la nómina fue guardada con éxito, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public boolean guardarNomina(Nomina nomina) throws AccesoDatosException {
        nominas.add(nomina);
        return true;
    }
    /**
     * Obtiene la fecha de la última nómina generada, correspondiente al empleado
     * recibido.
     * @param empleado Empleado cuya última nómina se desea buscar.
     * @return La fecha de la última nómina del empleado.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public LocalDate obtenerFechaUltimaNomina(Empleado empleado) throws AccesoDatosException {
        return null;
    }
}