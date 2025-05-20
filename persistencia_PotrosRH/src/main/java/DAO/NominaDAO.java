package DAO;

import Conexion.Conexion;
import Entidades.Empleado;
import Entidades.Nomina;
import Exceptions.AccesoDatosException;
import Interfaces.INominaDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

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
    private final List<Nomina> nominasLista = new ArrayList<>();
    // Coleccion de nóminas
    private final MongoCollection<Nomina> nominas;
    /**
     * Constructor por defecto. Obtiene la colección de nóminas
     * de la base de datos.
     */
    public NominaDAO() {this.nominas = Conexion.getDatabase().getCollection("nominas", Nomina.class);}
    
    /**
     * Guarda una nueva nómina en la base de datos.
     * @param nomina Nómina a guardar.
     * @return Nomina con nómina insertada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Nomina guardarNomina(Nomina nomina) throws AccesoDatosException {
        // Ejecuta la inserción
        nominas.insertOne(nomina);
        // Devuelve la nómina actualizada.
        return nomina;
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
        // Filtro para buscar el empleado por su ID
        Bson filtroEmpleado = Filters.eq("empleado_id", empleado.getId());
        // Se ejecuta la consuta y se obtiene la fecha
        Nomina fechaEncontrada = nominas
                .find(filtroEmpleado)
                .projection(Projections.include("fechaCorte"))
                .sort(Sorts.descending("fechaCorte"))
                .first();
        if(!(fechaEncontrada != null && fechaEncontrada.getFechaCorte() != null))
            return fechaEncontrada.getFechaCorte();
        else
            return null;
    }
}