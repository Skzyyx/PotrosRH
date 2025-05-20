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
import Enums.EstadoEmpleado;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import Interfaces.IEmpleadoBO;
import Interfaces.IEmpleadoDAO;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import dto.EmpleadoFiltroDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EmpleadoMapper;
import org.bson.conversions.Bson;
/**
 * Implementa la interfaz IEmpleadoBO y sus métodos.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
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
        
        if(!(empleado != null && empleado.getRfc() != null &&!empleado.getRfc().isEmpty()))
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        
        try {
            
            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(empleado.getRfc());
            empleadoPersistir = empleadoDAO.obtenerEmpleado(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;
            
        } catch (AccesoDatosException ex) {throw new ObjetosNegocioException(ex.getMessage());}
    }
    /**
     * Obtiene un empleado a partir de su ID.
     * @param empleado Objeto EmpleadoDTO con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws ObjetosNegocioException Exceción del proyecto EmpleadoBO.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoId(EmpleadoDTO empleado) throws ObjetosNegocioException{
        
        if(!(empleado != null && empleado.getId() != null &&!empleado.getId().isEmpty()))
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        
        try {
            
            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(empleado.getId());
            empleadoPersistir = empleadoDAO.obtenerEmpleadoId(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;
            
        } catch (AccesoDatosException ex) {throw new ObjetosNegocioException(ex.getMessage());}
    }
    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC, cuyo estado sea ACTIVO.
     * Si el RFC es inválido o el empleado no se encuentra en la lista, lanza una excepción.
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no está registrado.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObjetosNegocioException{
        
        if(!(empleado != null && empleado.getRfc() != null &&!empleado.getRfc().isEmpty()))
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        
        try {
            
            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(empleado.getRfc());
            empleadoPersistir = empleadoDAO.obtenerEmpleadoActivo(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;
            
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
//        if (rfc == null || rfc.trim().isEmpty()) {
//            throw new ObjetosNegocioException("El RFC del empleado no puede ser nulo o vacío para actualizar el estado.");
//        }
//        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
//            throw new ObjetosNegocioException("El nuevo estado del empleado no puede ser nulo o vacío.");
//        }
//
//        try {
//            EstadoEmpleado estado;
//            try {
//                estado = EstadoEmpleado.valueOf(nuevoEstado.toUpperCase());
//            } catch (IllegalArgumentException e) {
//                throw new ObjetosNegocioException("El estado '" + nuevoEstado + "' no es un estado de empleado válido.");
//            }
//            Empleado empleadoRFC = new Empleado();
//            empleadoRFC.setRfc(rfc);
//            Empleado empleado = empleadoDAO.obtenerEmpleado(empleadoRFC);
//            if (empleado != null) {
//                empleado.setEstado(estado);
//                empleadoDAO.actualizarEmpleado(empleado);
//                return EmpleadoMapper.toDTO(empleado);
//            } else {
//                throw new ObjetosNegocioException("No se encontró el empleado con el RFC proporcionado para actualizar el estado.");
//            }
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex);
//            throw new ObjetosNegocioException("Error al actualizar el estado del empleado: " + ex.getMessage(), ex);
//        }
        return null;
    }
    
    @Override
    public EmpleadoDTO registrarEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException {
        try {
            Empleado map = EmpleadoMapper.toEntityNuevo(empleado);
            return EmpleadoMapper.toDTO(empleadoDAO.registrarEmpleado(map));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
    
    @Override
    public EmpleadoDTO actualizarEstadoEmpleadoD(String rfc, String nuevoEstado) throws ObjetosNegocioException, AccesoDatosException {
        try {
            empleadoDAO.actualizarEstado(rfc, nuevoEstado);

            Empleado empleadoRFC = new Empleado();
            empleadoRFC.setRfc(rfc);
            Empleado empleadoActualizado = empleadoDAO.obtenerEmpleado(empleadoRFC);

            if (empleadoActualizado != null) {
                EmpleadoDTO empleadoDTO = new EmpleadoDTO();
                empleadoDTO.setId(empleadoActualizado.getId()!= null ? empleadoActualizado.getId().toHexString() : null);
                empleadoDTO.setRfc(empleadoActualizado.getRfc());
                empleadoDTO.setEstado(empleadoActualizado.getEstado().toString());

                return empleadoDTO;
            } else {
                throw new ObjetosNegocioException("Error al obtener el empleado actualizado.");
            }

        } catch (AccesoDatosException ex) {
            throw new ObjetosNegocioException("Error al actualizar el estado del empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws ObjetosNegocioException {
        List<Bson> filters = new ArrayList<>();

        if (filtro.getRfc() != null && !filtro.getRfc().isBlank()) {
            filters.add(Filters.regex("rfc", ".*" + filtro.getRfc() + ".*", "i")); // Contiene, ignorando mayúsculas
        }

        if (filtro.getEmail() != null && !filtro.getEmail().isBlank()) {
            filters.add(Filters.regex("email", ".*" + filtro.getEmail() + ".*", "i"));
        }

        if (filtro.getTelefono() != null && !filtro.getTelefono().isBlank()) {
            filters.add(Filters.regex("telefono", ".*" + filtro.getTelefono() + ".*", "i"));
        }
        
        List<Bson> pipeline = new ArrayList<>();

        if (!filters.isEmpty()) {
            pipeline.add(Aggregates.match(Filters.and(filters)));
        }
        
        try {
            return EmpleadoMapper.toDTOViejoList(empleadoDAO.obtenerTodosSinContrato(pipeline));
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
    
//    public List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws ObjetosNegocioException {
//        List<Bson> filters = new ArrayList<>();
//
//        if (filtro.getRfc() != null && !filtro.getRfc().isBlank()) {
//            filters.add(Filters.regex("rfc", ".*" + filtro.getRfc() + ".*", "i")); // Contiene, ignorando mayúsculas
//        }
//
//        if (filtro.getEmail() != null && !filtro.getEmail().isBlank()) {
//            filters.add(Filters.regex("email", ".*" + filtro.getEmail() + ".*", "i"));
//        }
//
//        if (filtro.getTelefono() != null && !filtro.getTelefono().isBlank()) {
//            filters.add(Filters.regex("telefono", ".*" + filtro.getTelefono() + ".*", "i"));
//        }
//
//        List<Bson> pipeline = new ArrayList<>();
//
//        if (!filters.isEmpty()) {
//            pipeline.add(Aggregates.match(Filters.and(filters)));
//        }
//
//        try {
//            return CandidatoMapper.toDTOViejoList(candidatoDAO.obtenerPorFiltro(pipeline));
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(CandidatoBO.class.getName()).log(Level.SEVERE, null, ex.getMessage());
//            throw new ObjetosNegocioException(ex.getMessage());
//        }
//    }
}