/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.RegistroAsistenciaDAO;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IRegistroAsistenciaBO;
import Interfaces.IRegistroAsistenciaDAO;
import dto.EmpleadoDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EmpleadoMapper;
import org.bson.types.ObjectId;

/**
 *Clase de negocio que gestiona el registro de asistencia de los empleados.
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistroAsistenciaBO implements IRegistroAsistenciaBO {

    /**
     * Instancia única de la clase para aplicar el patrón Singleton.
     */
    public static IRegistroAsistenciaBO instance;

    /**
     * DAO utilizado para acceder a los datos de registro de asistencia.
     */
    private final IRegistroAsistenciaDAO registroAsistenciaDAO = new RegistroAsistenciaDAO();

    /**
     * Constructor por defecto.
     */
    public RegistroAsistenciaBO(){
    }

    /**
     * Devuelve la instancia única de la clase RegistroAsistenciaBO.
     * 
     * @return Instancia única de IRegistroAsistenciaBO.
     */
    public static synchronized IRegistroAsistenciaBO getInstance() {
        if (instance == null) 
            instance = new RegistroAsistenciaBO();
        return instance;
    }

    /**
     * Registra la hora de entrada de un empleado en una fecha específica.
     * 
     * @param empleado DTO del empleado que realiza la entrada.
     * @param fechaAsistencia Fecha del registro de entrada.
     * @param horaEntrada Hora exacta en la que se registra la entrada.
     * @return true si el registro fue exitoso, false en caso contrario.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         o si ocurre un error al acceder a los datos.
     */
    @Override
    public boolean registrarEntrada(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws ObjetosNegocioException {
        if(empleado == null)
            throw new ObjetosNegocioException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new ObjetosNegocioException("El RFC del empleado no puede estar vacío.");
        try{
            return registroAsistenciaDAO.registrarEntrada(EmpleadoMapper.toEntityViejo(empleado), fechaAsistencia, horaEntrada);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(HorarioLaboralBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }

    /**
     * Registra la hora de salida de un empleado en una fecha específica.
     * 
     * @param empleado DTO del empleado que realiza la salida.
     * @param fechaAsistencia Fecha del registro de salida.
     * @param horaSalida Hora exacta en la que se registra la salida.
     * @return true si el registro fue exitoso, false en caso contrario.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         o si ocurre un error al acceder a los datos.
     */
    @Override
    public boolean registrarSalida(EmpleadoDTO empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws ObjetosNegocioException {
        if(empleado == null)
            throw new ObjetosNegocioException("El empleado a validar no puede ser nulo.");
        
        if(empleado.getRfc() == null)
            throw new ObjetosNegocioException("El RFC del empleado no puede estar vacío.");
        try{
            return registroAsistenciaDAO.registrarSalida(EmpleadoMapper.toEntityViejo(empleado), fechaAsistencia, horaSalida);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(HorarioLaboralBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }    
    }
    
    /**
     * Obtiene los días trabajados de un empleado.
     * @param empleado Empleado asociado.
     * @param fechaInicio Fecha de inicio del período.
     * @return Días trabajados del empleado en el período (fecha de inicio y actual).
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    @Override
    public Integer obtenerDiasTrabajados(EmpleadoDTO empleado, LocalDate fechaInicio) throws ObjetosNegocioException{
        
        if (!(empleado != null && empleado.getId() != null))
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        
        if(fechaInicio == null)
            throw new ObjetosNegocioException("La fecha no puede estra vacía");
        
        try {
            
            //Se extrae el ID del empleado
            Empleado empleadoId = new Empleado();
            empleadoId.setId(new ObjectId(empleado.getId()));
            
            return registroAsistenciaDAO.obtenerDiasTrabajados(empleadoId, fechaInicio);
            
        } catch (AccesoDatosException e) {
            Logger.getLogger(HorarioLaboralBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }
    
    /**
     * Obtiene las horas trabajadas de un empleado.
     * @param empleado Empleado asociado.
     * @param fechaInicio Fecha de inicio del período.
     * @return Horas trabajadas del empleado, en el período establecido (fecha de inicio y actual).
     * @throws ObjetosNegocioException Excepción de negocio.
     */
    @Override
    public Double obtenerHorasTrabajadas(EmpleadoDTO empleado, LocalDate fechaInicio) throws ObjetosNegocioException{
        if (!(empleado != null && empleado.getId() != null))
            throw new ObjetosNegocioException("El empleado no puede ser nulo");
        
        if(fechaInicio == null)
            throw new ObjetosNegocioException("La fecha no puede estra vacía");
        
        try {
            
            //Se extrae el ID del empleado
            Empleado empleadoId = new Empleado();
            empleadoId.setId(new ObjectId(empleado.getId()));
            
            return registroAsistenciaDAO.obtenerHorasTrabajadas(empleadoId, fechaInicio);
            
        } catch (AccesoDatosException e) {
            Logger.getLogger(HorarioLaboralBO.class.getName()).log(Level.SEVERE, null, e);
            throw new ObjetosNegocioException(e.getMessage(), e);
        }
    }
    
}
