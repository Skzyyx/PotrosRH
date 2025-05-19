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

/**
 *
 * @author Benjamin Soto Coronado (253183)
 */
public class HorarioLaboralDAO implements IHorarioLaboralDAO{
    
    private final MongoCollection<HorarioLaboral> HorarioLaboralCollection;
    
    public HorarioLaboralDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.HorarioLaboralCollection = database.getCollection("horario_laboral", HorarioLaboral.class);
    }
    
    
    
    
    @Override
    public boolean validarHorarioLaboral(Empleado empleado, LocalDate fechaAsistencia) throws AccesoDatosException {
        try {
            DiaSemana diaAsistencia = DiaSemana.fromDayOfWeek(fechaAsistencia.getDayOfWeek());
            return empleado.getHorariosLaborales().stream().anyMatch(horario -> horario.getDiaSemana() == diaAsistencia);
        } catch (Exception e) {
            throw new AccesoDatosException("Error al validar el horario laboral", e);
        }
    }
    @Override
    public HorarioLaboral obtenerDetallesHorarioLaboralDia(Empleado empleado, LocalDate fechaAsistencia) throws AccesoDatosException {
        try {
            DiaSemana diaBuscado = DiaSemana.fromDayOfWeek(fechaAsistencia.getDayOfWeek());
            return empleado.getHorariosLaborales().stream().filter(horario -> horario.getDiaSemana() == diaBuscado).findFirst().orElse(null);
        } catch (Exception e) {
            throw new AccesoDatosException("Error al obtener el horario laboral del día", e);
        }
    }
}
