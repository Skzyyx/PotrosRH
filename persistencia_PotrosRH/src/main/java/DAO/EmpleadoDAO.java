package DAO;

import Conexion.Conexion;
import Entidades.Empleado;
import Enums.EstadoEmpleado;
import Exceptions.AccesoDatosException;
import Interfaces.IEmpleadoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Clase para métodos de Persistencia con entidades Empleado.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoDAO implements IEmpleadoDAO {

    private static final Logger LOG = Logger.getLogger(ContratoDAO.class.getName());
    // Lista de empleados que simula la BD.
    // private final List<Empleado> empleados;

    private final MongoCollection<Empleado> empleados;

    public EmpleadoDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.empleados = database.getCollection("empleados", Empleado.class);
    }

    /**
     * Obtiene un empleado de la base de datos.
     *
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la
     * BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Empleado obtenerEmpleado(Empleado empleado) throws AccesoDatosException {
        try {
            return empleados.find(Filters.eq("rfc", empleado.getRfc())).first();
        } catch (MongoException e) {
            LOG.log(Level.WARNING, "Error al obtener empleado por RFC: {0}", e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al acceder a la base de datos para obtener el empleado.");
        }
    }

    /**
     * Obtiene un empleado a partir de su ID.
     *
     * @param empleado Entidad empleado con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws AccesoDatosException Exceción del proyecto DAO.
     */
    @Override
    public Empleado obtenerEmpleadoId(Empleado empleado) throws AccesoDatosException {
        try {
            return empleados.find(Filters.eq("_id", empleado.getId())).first();
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Error al obtener empleado por RFC: {0}", e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al obtener el empleado.");
        }
    }

    /**
     * Obtiene un empleado activo de la base de datos.
     *
     * @param empleado Empleado del cual se el extra su RFC, para buscarlo en la
     * BD.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Empleado obtenerEmpleadoActivo(Empleado empleado) throws AccesoDatosException {
        try {
            // Filtro para el RFC
            Bson filtroRFC = Filters.eq("rfc", empleado.getRfc());
            // Filtro para el estado del empleado.
            Bson filtroEstado = Filters.eq("estado", EstadoEmpleado.ACTIVO);
            // Ejecuta la consulta y devuelve el empleado obtenido.
            return empleados.find(Filters.and(filtroRFC, filtroEstado)).first();
        } catch (MongoException e) {
            LOG.log(Level.WARNING, "Error al obtener empleado activo por RFC: {0}", e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al acceder a la base de datos para obtener el empleado.");
        }
    }

    /**
     * Obtiene un empleado cuyo departamento es el de Recursos Humanos.
     *
     * @param empleado Empleado con RFC a buscar.
     * @return Empleado de Recursos Humanos.
     * @throws AccesoDatosException
     */
    @Override
    public Empleado obtenerEmpleadoRH(Empleado empleado) throws AccesoDatosException {
        try {
            // Filtro para el RFC
            Bson filtroRFC = Filters.eq("rfc", empleado.getRfc());
            // Filtro para el estado del empleado.
            Bson filtroEstado = Filters.eq("estado", EstadoEmpleado.ACTIVO);
            // Filtro para encontrar empleados del departamento de RH, con regex.
            Bson filtroRH = Filters.regex("departamento", "^Recursos Humanos", "i");
            // Ejecuta la consulta y devuelve el empleado obtenido.
            return empleados.find(Filters.and(filtroRFC, filtroEstado, filtroRH)).first();
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Error al obtener empleado activo por RFC: {0}", e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al acceder a la base de datos para obtener el empleado de recursos humanos.");
        }
    }

    @Override
    public Empleado registrarEmpleado(Empleado empleado) throws AccesoDatosException {
        try {

            Bson match = Aggregates.match(Filters.eq("candidato.rfc", empleado.getRfc()));

            AggregateIterable<Empleado> resultado = empleados.aggregate(Arrays.asList(
                    match
            ));

            if (resultado.iterator().hasNext()) {
                throw new AccesoDatosException("Ya existe un candidato con el rfc '" + empleado.getRfc() + "'.");
            }

            empleados.insertOne(empleado);

            return empleado;
        } catch (MongoException e) {
            LOG.log(Level.WARNING, e.getMessage());
            throw new AccesoDatosException("Ocurrió un error al intentar registrar la evaluación.");
        }
    }

    @Override
    public void actualizarEstado(String rfc, String nuevoEstado) throws AccesoDatosException {
        try {
            empleados.updateOne(Filters.eq("rfc", rfc), Updates.set("estado", nuevoEstado));
            LOG.log(Level.INFO, "Estado del empleado con RFC {0} actualizado a {1}", new Object[]{rfc, nuevoEstado});
        } catch (MongoException e) {
            LOG.log(Level.WARNING, "Error al actualizar el estado del empleado con RFC {0}: {1}", new Object[]{rfc, e.getMessage()});
            throw new AccesoDatosException("Ocurrió un error al actualizar el estado del empleado en la base de datos.");
        }
    }

    /**
     * Recupera todos los empleados que no tienen contrato asociado y que
     * cumplen con los criterios especificados en el pipeline de agregación.
     *
     * @param rfc RFC a filtrar
     * @param email Email a filtrar
     * @param telefono Teléfono a filtrar
     * @return Lista de empleados sin contrato que cumplen con los criterios de
     * filtrado
     * @throws AccesoDatosException Si ocurre un error al consultar la base de
     * datos
     */
    @Override
    public List<Empleado> obtenerTodosSinContrato(String rfc, String email, String telefono) throws AccesoDatosException {
        try {
            List<Bson> filters = new ArrayList<>();

            if (rfc != null && !rfc.isBlank()) {
                filters.add(Filters.regex("rfc", ".*" + rfc + ".*", "i"));
            }

            if (email != null && !email.isBlank()) {
                filters.add(Filters.regex("email", ".*" + email + ".*", "i"));
            }

            if (telefono != null && !telefono.isBlank()) {
                filters.add(Filters.regex("telefono", ".*" + telefono + ".*", "i"));
            }

            List<Bson> pipeline = new ArrayList<>();

            if (!filters.isEmpty()) {
                pipeline.add(Aggregates.match(Filters.and(filters)));
            }

            // Lógica para obtener empleados sin contrato vigente
            pipeline.add(Aggregates.lookup("contratos", "_id", "empleadoId", "contratos"));
            pipeline.add(Aggregates.match(Filters.or(
                    Filters.eq("contratos", Arrays.asList()),
                    Filters.expr(new Document("$not",
                            new Document("$anyElementTrue", new Document("$map", new Document()
                                    .append("input", "$contratos")
                                    .append("as", "c")
                                    .append("in", new Document("$gt", Arrays.asList("$$c.fechaFin", LocalDate.now())))
                            ))
                    ))
            )));

            return empleados.aggregate(pipeline, Empleado.class).into(new ArrayList<>());
        } catch (Exception e) {
            throw new AccesoDatosException("Ocurrió un error al obtener los empleados sin contrato");
        }
    }
}
