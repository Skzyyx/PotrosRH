package bo;

/**
 * Objeto de negocio EmpleadoBO.
 *
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
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import dto.EmpleadoFiltroDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EmpleadoMapper;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementa la interfaz IEmpleadoBO y sus métodos.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoBO implements IEmpleadoBO {

    // Atributo de la misma clase (SingleTon).
    private static IEmpleadoBO instance;
    // Atributo DAO para operaciones CRUD con Empleados.
    private static final IEmpleadoDAO empleadoDAO = new EmpleadoDAO();

    /**
     * Constructor por defecto.
     */
    private EmpleadoBO() {
    }

    /**
     * Método SingleTon de la clase.
     *
     * @return Instancia SingleTon de la clase.
     */
    public static synchronized IEmpleadoBO getInstance() {
        if (instance == null) {
            instance = new EmpleadoBO();
        }
        return instance;
    }

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC. Si el RFC es
     * inválido o el empleado no se encuentra en la lista, lanza una excepción.
     *
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no
     * está registrado.
     */
    @Override
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws ObjetosNegocioException {

        if (!(empleado != null && empleado.getRfc() != null && !empleado.getRfc().isEmpty())) {
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        }

        try {

            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(empleado.getRfc());
            empleadoPersistir = empleadoDAO.obtenerEmpleado(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;

        } catch (AccesoDatosException ex) {
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

    /**
     * Obtiene un empleado a partir de su ID.
     *
     * @param empleado Objeto EmpleadoDTO con el ID a buscar.
     * @return Empleado obtenidos.
     * @throws ObjetosNegocioException Exceción del proyecto EmpleadoBO.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoId(EmpleadoDTO empleado) throws ObjetosNegocioException {

        if (!(empleado != null && empleado.getId() != null && !empleado.getId().isEmpty())) {
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        }

        try {

            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setId(new ObjectId(empleado.getId()));
            empleadoPersistir = empleadoDAO.obtenerEmpleadoId(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;

        } catch (AccesoDatosException ex) {
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }

    /**
     * Obtiene un objeto {@link EmpleadoDTO} a partir de su RFC, cuyo estado sea
     * ACTIVO. Si el RFC es inválido o el empleado no se encuentra en la lista,
     * lanza una excepción.
     *
     * @param empleado Objeto EmpleadoBO del cual se extrae su RFC.
     * @return {@link EmpleadoDTO} con la información del empleado encontrado.
     * @throws ObjetosNegocioException Si el RFC es inválido o el empleado no
     * está registrado.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoActivo(EmpleadoDTO empleado) throws ObjetosNegocioException {

        if (!(empleado != null && empleado.getRfc() != null && !empleado.getRfc().isEmpty())) {
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        }

        try {

            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(empleado.getRfc());
            empleadoPersistir = empleadoDAO.obtenerEmpleadoActivo(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;

        } catch (AccesoDatosException ex) {
            throw new ObjetosNegocioException(ex.getMessage());
        }
    }
    
    /**
     * Obtiene un empleado activo a partir de su RFC, cuyo departamento es
     * igual a Recursos Humanos.
     * @param empleado Empleado con RFC de búsqueda.
     * @return Empleado de recursos humanos.
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    @Override
    public EmpleadoDTO obtenerEmpleadoRH(EmpleadoDTO empleado) throws ObjetosNegocioException{
        
        if (!(empleado != null && empleado.getRfc() != null && !empleado.getRfc().isEmpty())) {
            throw new ObjetosNegocioException("El RFC no puede estar vacío.");
        }

        try {

            Empleado empleadoPersistir = new Empleado();
            empleadoPersistir.setRfc(empleado.getRfc());
            empleadoPersistir = empleadoDAO.obtenerEmpleadoRH(empleadoPersistir);
            return empleadoPersistir != null ? EmpleadoMapper.toDTO(empleadoPersistir) : null;

        } catch (AccesoDatosException ex) {throw new ObjetosNegocioException(ex.getMessage());}
    }
    
    /**
     * Registra un nuevo empleado en el sistema.
     *
     * @param empleado El objeto EmpleadoDTO con la información del empleado a
     * registrar
     * @return El objeto EmpleadoDTO registrado, con identificadores generados
     * @throws ObjetosNegocioException Si ocurre un error durante el registro o
     * si ya existe un empleado con el mismo RFC
     */
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

    /**
     * Actualiza el estado de un empleado directamente en la base de datos.
     *
     * @param rfc RFC del empleado cuyo estado se va a actualizar
     * @param nuevoEstado Nuevo estado que se asignará al empleado
     * @return El objeto EmpleadoDTO con la información actualizada del empleado
     * @throws ObjetosNegocioException Si ocurre un error durante la
     * actualización o si el empleado no existe
     * @throws AccesoDatosException Si ocurre un error al acceder a la base de
     * datos
     */
    @Override
    public EmpleadoDTO actualizarEstadoEmpleadoD(String rfc, String nuevoEstado) throws ObjetosNegocioException, AccesoDatosException {
        try {
            empleadoDAO.actualizarEstado(rfc, nuevoEstado);

            Empleado empleadoRFC = new Empleado();
            empleadoRFC.setRfc(rfc);
            Empleado empleadoActualizado = empleadoDAO.obtenerEmpleado(empleadoRFC);

            if (empleadoActualizado != null) {
                EmpleadoDTO empleadoDTO = new EmpleadoDTO();
                empleadoDTO.setId(empleadoActualizado.getId() != null ? empleadoActualizado.getId().toHexString() : null);
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

    /**
     * Recupera todos los empleados que no tienen contrato asociado y que
     * cumplen con los criterios de filtrado especificados.
     *
     * @param filtro Objeto EmpleadoFiltroDTO con los criterios de filtrado
     * @return Lista de objetos EmpleadoDTO que cumplen con los criterios
     * @throws ObjetosNegocioException Si ocurre un error durante la consulta
     */
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
}
