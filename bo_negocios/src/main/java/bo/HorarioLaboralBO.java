/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.HorarioLaboralDAO;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IHorarioLaboralBO;
import Interfaces.IHorarioLaboralDAO;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EmpleadoMapper;
import mappers.HorarioLaboralMapper;

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralBO implements IHorarioLaboralBO{
    
     /**
     * Instancia única de la clase para aplicar el patrón Singleton.
     */
    public static IHorarioLaboralBO instance;

    /**
     * DAO utilizado para acceder a los datos de horarios laborales.
     */
    private final IHorarioLaboralDAO horarioLaboralDAO = new HorarioLaboralDAO();

    /**
     * Constructor por defecto.
     */
    public HorarioLaboralBO() {

    }

    /**
     * Devuelve la instancia única de la clase HorarioLaboralBO.
     * 
     * @return Instancia única de IHorarioLaboralBO.
     */
    public static synchronized IHorarioLaboralBO getInstance() {
        if (instance == null)
            instance = new HorarioLaboralBO();
        return instance;
    }

    /**
     * Valida si el empleado tiene asignado un horario laboral para una fecha específica.
     * 
     * @param empleado DTO del empleado a validar.
     * @param fechaAsistencia Fecha en la que se desea verificar el horario laboral.
     * @return true si tiene horario laboral asignado en esa fecha, false en caso contrario.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         no tiene horarios laborales, o ocurre un error en la capa de datos.
     */
    @Override
    public boolean validarHorarioLaboral(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws ObjetosNegocioException {
        if(empleado == null)
            throw new ObjetosNegocioException("El empleado a validar no puede ser nulo.");

        if(empleado.getRfc() == null)
            throw new ObjetosNegocioException("El RFC del empleado no puede estar vacío.");
        if(empleado.getHorariosLaborales()==null)
            throw new ObjetosNegocioException("El empleado no tiene horarios laborales asignados:");
        try{
            return horarioLaboralDAO.validarHorarioLaboral(EmpleadoMapper.toEntityViejo(empleado), fechaAsistencia);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(HorarioLaboralBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }

    /**
     * Obtiene los detalles del horario laboral del empleado para una fecha específica.
     * 
     * @param empleado DTO del empleado del cual se quiere obtener el horario.
     * @param fechaAsistencia Fecha para la que se desea obtener el horario laboral.
     * @return HorarioLaboralDTO con los detalles del horario para la fecha indicada.
     * @throws ObjetosNegocioException Si el empleado es nulo, su RFC está vacío, 
     *         no tiene horarios laborales, o ocurre un error en la capa de datos.
     */
    @Override
    public HorarioLaboralDTO obtenerDetallesHorarioLaboralDia(EmpleadoDTO empleado, LocalDate fechaAsistencia) throws ObjetosNegocioException {
        if(empleado == null)
            throw new ObjetosNegocioException("El empleado a validar no puede ser nulo.");

        if(empleado.getRfc() == null)
            throw new ObjetosNegocioException("El RFC del empleado no puede estar vacío.");
        if(empleado.getHorariosLaborales()==null)
            throw new ObjetosNegocioException("El empleado no tiene horarios laborales asignados:");
        try{
            return HorarioLaboralMapper.toDTO(horarioLaboralDAO.obtenerDetallesHorarioLaboralDia(EmpleadoMapper.toEntityViejo(empleado), fechaAsistencia));
        }catch (AccesoDatosException ex) {
            Logger.getLogger(HorarioLaboralBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ObjetosNegocioException(ex.getMessage(), ex);
        }
    }
}
