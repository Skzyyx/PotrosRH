package DAO;

import Entidades.Direccion;
import Entidades.Empleado;
import Entidades.HorarioLaboral;
import Exceptions.AccesoDatosException;
import Interfaces.IEmpleadoDAO;
import enums.EstadoEmpleado;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para métodos de Persistencia con entidades Empleado.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoDAO implements IEmpleadoDAO {   
    // Lista de empleados que simula la BD.
    private final List<Empleado> empleados;

    public EmpleadoDAO() {
        // Se crea la lista de empleados.
        empleados = new ArrayList<>();
        // Empleados Mock
        Empleado empleadoFreddy = new Empleado();
        empleadoFreddy.setNombre("Freedy");
        empleadoFreddy.setApellidoPaterno("Guzmán");
        empleadoFreddy.setApellidoMaterno("Moreno");
        empleadoFreddy.setEmail("jose.guzman252524@potros.itson.edu.mx");
        empleadoFreddy.setRfc("GUMF900101ABC");
        empleadoFreddy.setCurp("CURPFREDDY1234");
        empleadoFreddy.setDireccion(new Direccion("Peppa", "Power Rangers", "123"));
        empleadoFreddy.setTelefono("1231231950");
        empleadoFreddy.setDepartamento("Limpieza");
        empleadoFreddy.setPuesto("Empleado");
        empleadoFreddy.setSalarioBase(4000.0);
        empleadoFreddy.setEstado(EstadoEmpleado.ACTIVO);
        
        HorarioLaboral horarioFreddyLunes = new HorarioLaboral(empleadoFreddy, (short) 1, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
        HorarioLaboral horarioFreddyMartes = new HorarioLaboral(empleadoFreddy, (short) 2, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
        HorarioLaboral horarioFreddyMiercoles = new HorarioLaboral(empleadoFreddy, (short) 3, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
        HorarioLaboral horarioFreddyJueves = new HorarioLaboral(empleadoFreddy, (short) 4, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
        HorarioLaboral horarioFreddyViernes = new HorarioLaboral(empleadoFreddy, (short) 5, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
        List<HorarioLaboral> horariosFreddy = Arrays.asList(horarioFreddyLunes, horarioFreddyMartes, horarioFreddyMiercoles, horarioFreddyJueves, horarioFreddyViernes);
        
        empleadoFreddy.setHorariosLaborales(horariosFreddy);
                
        Empleado empleadoNeto = new Empleado();
        empleadoNeto.setNombre("Jesús Ernesto");
        empleadoNeto.setApellidoPaterno("López");
        empleadoNeto.setApellidoMaterno("Ibarra");
        empleadoNeto.setEmail("leonardoflores29088@gmail.com");
        empleadoNeto.setRfc("LOIJ920315XYZ");
        empleadoNeto.setCurp("CURPNETO1234");
        empleadoNeto.setDireccion(new Direccion("Furbo", "Real Madrid", "123"));
        empleadoNeto.setTelefono("6442291849");
        empleadoNeto.setDepartamento("Recursos Humanos");
        empleadoNeto.setPuesto("Empleado");
        empleadoNeto.setSalarioBase(8000.0);
        empleadoNeto.setEstado(EstadoEmpleado.ACTIVO);
        
        HorarioLaboral horarioNetoLunes = new HorarioLaboral(empleadoFreddy, (short) 1, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
        HorarioLaboral horarioNetoMartes = new HorarioLaboral(empleadoFreddy, (short) 2, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
        HorarioLaboral horarioNetoMiercoles = new HorarioLaboral(empleadoFreddy, (short) 3, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
        HorarioLaboral horarioNetoJueves = new HorarioLaboral(empleadoFreddy, (short) 4, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
        HorarioLaboral horarioNetoViernes = new HorarioLaboral(empleadoFreddy, (short) 5, LocalTime.of(9, 0, 0), LocalTime.of(17, 0, 0));
        List<HorarioLaboral> horariosNeto = Arrays.asList(horarioNetoLunes, horarioNetoMartes, horarioNetoMiercoles, horarioNetoJueves, horarioNetoViernes);
        
        empleadoNeto.setHorariosLaborales(horariosNeto);
                
        Empleado empleadoJose = new Empleado();
        empleadoJose.setNombre("José Luis");
        empleadoJose.setApellidoPaterno("Islas");
        empleadoJose.setApellidoMaterno("Molina");
        empleadoJose.setEmail("jose.islas252574@potros.itson.edu.mx");
        empleadoJose.setRfc("ISLM850525DEF");
        empleadoJose.setCurp("CURPJOSE1234");
        empleadoJose.setDireccion(new Direccion("Avenida Siempre Viva", "Centro", "456"));
        empleadoJose.setTelefono("9876543210");
        empleadoJose.setDepartamento("TI");
        empleadoJose.setPuesto("Analista");
        empleadoJose.setSalarioBase(12000.0);
        empleadoJose.setEstado(EstadoEmpleado.ACTIVO);
        
        HorarioLaboral horarioJoseLunes = new HorarioLaboral(empleadoFreddy, (short) 1, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
        HorarioLaboral horarioJoseMartes = new HorarioLaboral(empleadoFreddy, (short) 2, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
        HorarioLaboral horarioJoseMiercoles = new HorarioLaboral(empleadoFreddy, (short) 3, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
        HorarioLaboral horarioJoseJueves = new HorarioLaboral(empleadoFreddy, (short) 4, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
        HorarioLaboral horarioJoseViernes = new HorarioLaboral(empleadoFreddy, (short) 5, LocalTime.of(10, 0, 0), LocalTime.of(18, 0, 0));
        List<HorarioLaboral> horariosJose = Arrays.asList(horarioJoseLunes, horarioJoseMartes, horarioJoseMiercoles, horarioJoseJueves, horarioJoseViernes);
        
        empleadoJose.setHorariosLaborales(horariosJose);
        
        empleados.add(empleadoFreddy);
        empleados.add(empleadoNeto);
        empleados.add(empleadoJose);
    }
    /**
     * Valida el estado de un empleado.
     * @param rfc RFC del empleado.
     * @return VERDADERO si el empleado está activo, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public boolean validarEstado(String rfc) throws AccesoDatosException {return true;}
    /**
     * Valida que el porcentaje de asistencia de un empleado sea
     * igual o superior al 80%, correspondiente con su período
     * de trabajo.
     * @param rfc RFC del empleado.
     * @return VERDADERO si el porcentaje de asistencia es igual o superior al 80%, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public boolean validarPorcentajeAsistencias(String rfc) throws AccesoDatosException {return true;}
    /**
     * Obtiene un empleado de la base de datos.
     * @param rfc RFC del empleado.
     * @return Entidad empleado, correspondiente al RFC recibido.
     * @throws AccesoDatosException Excepción del proyecto.
     */
    @Override
    public Empleado obtenerEmpleado(String rfc) throws AccesoDatosException {
        // Buscar al empleado por RFC
        for (Empleado empleado : empleados) {
            if (empleado.getRfc().equalsIgnoreCase(rfc)) 
                return empleado;
        }

        // Si no se encuentra el empleado, lanza una excepción
        throw new AccesoDatosException("No se encontró un empleado con el RFC proporcionado");
    }
}
