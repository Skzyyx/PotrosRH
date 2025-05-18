package DAO;

import Conexion.Conexion;
import Entidades.Direccion;
import Entidades.Empleado;
import Entidades.Evaluacion;
import Entidades.HorarioLaboral;
import Exceptions.AccesoDatosException;
import Interfaces.IEmpleadoDAO;
import Enums.EstadoEmpleado;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

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

//    /**
//     * Constructor por defecto.
//     */
//    public EmpleadoDAO() {
//        // Se crea la lista de empleados.
//        empleados = new ArrayList<>();
//        // Empleados Mock
//        Empleado empleadoFreddy = new Empleado();
//        empleadoFreddy.setNombre("Freedy");
//        empleadoFreddy.setApellidoPaterno("Guzmán");
//        empleadoFreddy.setApellidoMaterno("Moreno");
//        empleadoFreddy.setEmail("jose.guzman252524@potros.itson.edu.mx");
//        empleadoFreddy.setRfc("GUMF900101ABC");
//        empleadoFreddy.setCurp("CURPFREDDY1234");
//        empleadoFreddy.setDireccion(new Direccion("Peppa", "Power Rangers", "123"));
//        empleadoFreddy.setTelefono("1231231950");
//        empleadoFreddy.setDepartamento("Limpieza");
//        empleadoFreddy.setPuesto("Empleado");
//        empleadoFreddy.setSalarioBase(4000.0);
//        empleadoFreddy.setEstado(EstadoEmpleado.ACTIVO);
//        
//        HorarioLaboral horarioFreddyLunes = new HorarioLaboral(empleadoFreddy, (short) 1, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
//        HorarioLaboral horarioFreddyMartes = new HorarioLaboral(empleadoFreddy, (short) 2, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
//        HorarioLaboral horarioFreddyMiercoles = new HorarioLaboral(empleadoFreddy, (short) 3, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
//        HorarioLaboral horarioFreddyJueves = new HorarioLaboral(empleadoFreddy, (short) 4, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
//        HorarioLaboral horarioFreddyViernes = new HorarioLaboral(empleadoFreddy, (short) 5, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
//        List<HorarioLaboral> horariosFreddy = Arrays.asList(horarioFreddyLunes, horarioFreddyMartes, horarioFreddyMiercoles, horarioFreddyJueves, horarioFreddyViernes);
//        
//        empleadoFreddy.setHorariosLaborales(horariosFreddy);
//                
//        Empleado empleadoNeto = new Empleado();
//        empleadoNeto.setNombre("Jesús Ernesto");
//        empleadoNeto.setApellidoPaterno("López");
//        empleadoNeto.setApellidoMaterno("Ibarra");
//        empleadoNeto.setEmail("jesus.lopez252663@potros.itson.edu.mx");
//        empleadoNeto.setRfc("LOIJ920315XYZ");
//        empleadoNeto.setCurp("CURPNETO1234");
//        empleadoNeto.setDireccion(new Direccion("Furbo", "Real Madrid", "123"));
//        empleadoNeto.setTelefono("6442291849");
//        empleadoNeto.setDepartamento("Recursos Humanos");
//        empleadoNeto.setPuesto("Empleado");
//        empleadoNeto.setSalarioBase(8000.0);
//        empleadoNeto.setEstado(EstadoEmpleado.ACTIVO);
//        
//        HorarioLaboral horarioNetoLunes = new HorarioLaboral(empleadoFreddy, (short) 1, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
//        HorarioLaboral horarioNetoMartes = new HorarioLaboral(empleadoFreddy, (short) 2, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
//        HorarioLaboral horarioNetoMiercoles = new HorarioLaboral(empleadoFreddy, (short) 3, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
//        HorarioLaboral horarioNetoJueves = new HorarioLaboral(empleadoFreddy, (short) 4, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
//        HorarioLaboral horarioNetoViernes = new HorarioLaboral(empleadoFreddy, (short) 5, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
//        List<HorarioLaboral> horariosNeto = Arrays.asList(horarioNetoLunes, horarioNetoMartes, horarioNetoMiercoles, horarioNetoJueves, horarioNetoViernes);
//        
//        empleadoNeto.setHorariosLaborales(horariosNeto);
//                
//        Empleado empleadoJose = new Empleado();
//        empleadoJose.setNombre("José Luis");
//        empleadoJose.setApellidoPaterno("Islas");
//        empleadoJose.setApellidoMaterno("Molina");
//        empleadoJose.setEmail("jose.islas252574@potros.itson.edu.mx");
//        empleadoJose.setRfc("ISLM850525DEF");
//        empleadoJose.setCurp("CURPJOSE1234");
//        empleadoJose.setDireccion(new Direccion("Avenida Siempre Viva", "Centro", "456"));
//        empleadoJose.setTelefono("9876543210");
//        empleadoJose.setDepartamento("TI");
//        empleadoJose.setPuesto("Analista");
//        empleadoJose.setSalarioBase(12000.0);
//        empleadoJose.setEstado(EstadoEmpleado.ACTIVO);
//        
//        HorarioLaboral horarioJoseLunes = new HorarioLaboral(empleadoFreddy, (short) 1, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
//        HorarioLaboral horarioJoseMartes = new HorarioLaboral(empleadoFreddy, (short) 2, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
//        HorarioLaboral horarioJoseMiercoles = new HorarioLaboral(empleadoFreddy, (short) 3, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
//        HorarioLaboral horarioJoseJueves = new HorarioLaboral(empleadoFreddy, (short) 4, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
//        HorarioLaboral horarioJoseViernes = new HorarioLaboral(empleadoFreddy, (short) 5, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
//        List<HorarioLaboral> horariosJose = Arrays.asList(horarioJoseLunes, horarioJoseMartes, horarioJoseMiercoles, horarioJoseJueves, horarioJoseViernes);
//        
//        empleadoJose.setHorariosLaborales(horariosJose);
//        
//        empleados.add(empleadoFreddy);
//        empleados.add(empleadoNeto);
//        empleados.add(empleadoJose);
//    }
    /**
     * Valida el estado de un empleado.
     *
     * @param empleado Empleado del cual se le extrae su RFC.
     * @return VERDADERO si el empleado está activo, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public boolean validarEstado(Empleado empleado) throws AccesoDatosException {
        return true;
    }

    /**
     * Valida que el porcentaje de asistencia de un empleado sea igual o
     * superior al 80%, correspondiente con su período de trabajo.
     *
     * @param empleado Empleado del cual se le extrae su RFC.
     * @return VERDADERO si el porcentaje de asistencia es igual o superior al
     * 80%, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public boolean validarPorcentajeAsistencias(Empleado empleado) throws AccesoDatosException {
        return true;
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
     * Actualiza la información de un empleado en la base de datos simulada
     *
     * @param empleado La entidad Empleado con la información actualizada
     * @throws AccesoDatosException Si ocurre un error al actualizar el empleado
     * o si no se encuentra
     */
    @Override
    public void actualizarEmpleado(Empleado empleado) throws AccesoDatosException {
//        for (int i = 0; i < empleados.size(); i++) {
//            if (empleados.get(i).getRfc().equalsIgnoreCase(empleado.getRfc())) {
//                empleados.set(i, empleado);
//                return;
//            }
//        }
//        throw new AccesoDatosException("No se encontró el empleado con el RFC proporcionado para actualizar.");
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
    
    public void actualizarEstado(String rfc, String nuevoEstado) throws AccesoDatosException {
        try {
            empleados.updateOne(Filters.eq("rfc", rfc), Updates.set("estado", nuevoEstado));
            LOG.log(Level.INFO, "Estado del empleado con RFC {0} actualizado a {1}", new Object[]{rfc, nuevoEstado});
        } catch (MongoException e) {
            LOG.log(Level.WARNING, "Error al actualizar el estado del empleado con RFC {0}: {1}", new Object[]{rfc, e.getMessage()});
            throw new AccesoDatosException("Ocurrió un error al actualizar el estado del empleado en la base de datos.");
        }
    }
}
