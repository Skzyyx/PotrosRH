package bo;

/**
 * Objeto de negocio EmpleadoBO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
import DAO.EmpleadoDAO;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import Interfaces.IEmpleadoBO;
import Interfaces.IEmpleadoDAO;
import enums.EstadoEmpleado;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EmpleadoMapper;

public class EmpleadoBO implements IEmpleadoBO{
    // Atributo de la misma clase (SingleTon).
    private static IEmpleadoBO instance;
    // Atributo DAO para operaciones CRUD con Empleados.
    private static final IEmpleadoDAO empleadoDAO = new EmpleadoDAO();
    /**
     * Constructor por defecto.
     */
    private EmpleadoBO (){}
    /**
     * Método SingleTon de la clase.
     * @return Instancia SingleTon de la clase.
     */
    public static synchronized IEmpleadoBO getInstance() {
        if (instance == null)
            instance = new EmpleadoBO();
        return instance;
    }
    
    /**
     * Valida que el estado del empleado sea ACTIVO.
     * @param empleado Empleado cuyo estado será validado.
     * @return {@code true} si el RFC es válido.
     * @throws ObjetosNegocioException Si el RFC es nulo o está vacío.
     */
    @Override
    public boolean validarEstado(EmpleadoDTO empleado) throws ObjetosNegocioException {
        
        if(empleado == null)
            throw new ObjetosNegocioException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new ObjetosNegocioException("El RFC del empleado no puede estar vacío.");
        
        try {
            Empleado empleadoValidar = new Empleado();
            empleadoValidar.setRfc(empleado.getRfc());
            return empleadoDAO.validarEstado(empleadoValidar);
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }

    /**
     * Determina si el porcentaje de faltas de un empleado es aceptable.
     * @param empleado Empleado a evaluar.
     * @return {@code true} si el porcentaje de faltas es menor al 80%, {@code false} en caso contrario.
     * @throws Exceptions.ObjetosNegocioException cuando no cumple con el minimo de asistencias.
     */
    @Override
    public boolean validarPorcentajeAsistencias(EmpleadoDTO empleado) throws ObjetosNegocioException {
        
        if(empleado == null)
            throw new ObjetosNegocioException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new ObjetosNegocioException("El RFC del empleado no puede estar vacío.");
        
        try {    
            Empleado empleadoValidar = new Empleado();
            empleadoValidar.setRfc(empleado.getRfc());
            return empleadoDAO.validarPorcentajeAsistencias(empleadoValidar);
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC.
     * Si el RFC es inválido o el empleado no se encuentra en la lista, lanza una excepción.
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no está registrado.
     */
    @Override
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException {
        
        if(empleado == null)
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        
        // Se extrae el RFC del empleado.
        String rfc = empleado.getRfc();

        if (!(rfc != null && rfc.matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{2,3}$") && rfc.length() <= 13))
            throw new ObjetosNegocioException("RFC no válido");
        
        try {
            
            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(rfc);
            return EmpleadoMapper.toDTO(empleadoDAO.obtenerEmpleado(empleadoPersistir));
            
        } catch (AccesoDatosException ex) {throw new ObjetosNegocioException(ex.getMessage());}
    }
    
    /**
     * Actualiza el estado de un empleado
     * @param rfc RFC del empleado a actualizar
     * @param nuevoEstado El nuevo estado del empleado
     * @return El EmpleadoDTO con la información actualizada del empleado
     * @throws ObjetosNegocioException Si el RFC es nulo o vacío, o si el nuevo estado no es válido,
     * o si ocurre un error al actualizar el estado
     */
    @Override
    public EmpleadoDTO actualizarEstadoEmpleado(String rfc, String nuevoEstado) throws ObjetosNegocioException {
        if (rfc == null || rfc.trim().isEmpty()) {
            throw new ObjetosNegocioException("El RFC del empleado no puede ser nulo o vacío para actualizar el estado.");
        }
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new ObjetosNegocioException("El nuevo estado del empleado no puede ser nulo o vacío.");
        }

        try {
            EstadoEmpleado estado;
            try {
                estado = EstadoEmpleado.valueOf(nuevoEstado.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new ObjetosNegocioException("El estado '" + nuevoEstado + "' no es un estado de empleado válido.");
            }
            Empleado empleadoRFC = new Empleado();
            empleadoRFC.setRfc(rfc);
            Empleado empleado = empleadoDAO.obtenerEmpleado(empleadoRFC);
            if (empleado != null) {
                empleado.setEstado(estado);
                empleadoDAO.actualizarEmpleado(empleado);
                return EmpleadoMapper.toDTO(empleado);
            } else {
                throw new ObjetosNegocioException("No se encontró el empleado con el RFC proporcionado para actualizar el estado.");
            }
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException("Error al actualizar el estado del empleado: " + ex.getMessage(), ex);
        }
    }
    
    public EmpleadoDTO actualizarEstado(String rfc, String nuevoEstado) {
        // Implementar la lógica para actualizar el estado de un empleado en la base de datos
        System.out.println("EmpleadoDAO: Actualizar estado del empleado con RFC " + rfc + " a " + nuevoEstado);
        // Simulación de la actualización y retorno de un DTO (deberías obtenerlo de la DB)
        EmpleadoDTO empleadoActualizado = new EmpleadoDTO();
            empleadoActualizado.setRfc(rfc);
            empleadoActualizado.setEstado(nuevoEstado);
            return empleadoActualizado;
    }
}