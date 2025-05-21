/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DAO.HorarioLaboralDAO;
import Entidades.Empleado;
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
    
    public static IHorarioLaboralBO instance;
    private final IHorarioLaboralDAO horarioLaboralDAO= new HorarioLaboralDAO();
    
    public HorarioLaboralBO(){
    
    }
    
    public static synchronized IHorarioLaboralBO getInstance() {
        if (instance == null) 
            instance = new HorarioLaboralBO();
        return instance;
    }
    
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
