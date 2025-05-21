/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Empleado;
import Entidades.HorarioLaboral;
import Enums.DiaSemana;
import Exceptions.AccesoDatosException;
import Interfaces.IHorarioLaboralDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Implementación de IHorarioLaboralDAO para manejar operaciones relacionadas con horarios laborales
 * en una base de datos MongoDB.
 * 
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralDAO implements IHorarioLaboralDAO {
    
    private final MongoCollection<HorarioLaboral> HorarioLaboralCollection;
    
    /**
     * Constructor que inicializa la conexión con la colección 'horario_laboral' en MongoDB.
     * Utiliza la conexión proporcionada por la clase Conexion.
     */
    public HorarioLaboralDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.HorarioLaboralCollection = database.getCollection("horario_laboral", HorarioLaboral.class);
    }
    
    /**
     * Valida si un empleado tiene horario laboral para un día específico.
     * 
     * @param empleado El empleado cuyo horario se va a validar
     * @param fechaAsistencia La fecha para la cual se verifica el horario
     * @return true si el empleado tiene horario para ese día, false en caso contrario
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos
     */
    @Override
    public boolean validarHorarioLaboral(Empleado empleado, LocalDate fechaAsistencia) throws AccesoDatosException {
        try {
            if (empleado == null) {
                throw new AccesoDatosException("El empleado no puede ser nulo");
            }
            
            List<HorarioLaboral> horarios = empleado.getHorariosLaborales();
            if (horarios == null || horarios.isEmpty()) {
                return false;
            }
            
            DiaSemana diaAsistencia = DiaSemana.fromDayOfWeek(fechaAsistencia.getDayOfWeek());
            return horarios.stream()
                          .anyMatch(horario -> horario != null && horario.getDiaSemana() == diaAsistencia);
        } catch (Exception e) {
            throw new AccesoDatosException("Error al validar el horario laboral", e);
        }
    }
    
    /**
     * Obtiene los detalles del horario laboral de un empleado para un día específico.
     * 
     * @param empleado El empleado cuyo horario se va a consultar
     * @param fechaAsistencia La fecha para la cual se solicita el horario
     * @return El objeto HorarioLaboral correspondiente al día solicitado, o null si no existe horario para ese día
     * @throws AccesoDatosException Si ocurre un error al acceder a los datos
     */
    @Override
    public HorarioLaboral obtenerDetallesHorarioLaboralDia(Empleado empleado, LocalDate fechaAsistencia) throws AccesoDatosException {
        try {
            if (empleado == null) {
                throw new AccesoDatosException("El empleado no puede ser nulo");
            }
            
            List<HorarioLaboral> horarios = empleado.getHorariosLaborales();
            if (horarios == null || horarios.isEmpty()) {
                return null;
            }
            
            DiaSemana diaBuscado = DiaSemana.fromDayOfWeek(fechaAsistencia.getDayOfWeek());
            return horarios.stream()
                          .filter(horario -> horario != null && horario.getDiaSemana() == diaBuscado)
                          .findFirst()
                          .orElse(null);
        } catch (Exception e) {
            throw new AccesoDatosException("Error al obtener el horario laboral del día", e);
        }
    }
}
