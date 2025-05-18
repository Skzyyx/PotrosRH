/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Pruebas;

import Control.ControlGenerarContrato;
import dto.ContratoDTO;
import dto.CorreoDTO;
import dto.EvaluacionDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author skyro
 */
public class Negocio_GenerarContrato {

    public static void main(String[] args) {
        
        ControlGenerarContrato control = new ControlGenerarContrato();
        
        // Crear horarios laborales
        Set<HorarioLaboralDTO> horarios = new LinkedHashSet<>();
        horarios.add(new HorarioLaboralDTO("Lunes", LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboralDTO("Martes", LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboralDTO("Miercoles", LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboralDTO("Jueves", LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboralDTO("Viernes", LocalTime.of(9, 0), LocalTime.of(17, 0)));

        // Crear evaluación (puedes personalizar los atributos según tu clase EvaluacionDTO)
        EvaluacionDTO evaluacion = new EvaluacionDTO();
        evaluacion.setId("EV123");

        // Crear contrato
        ContratoDTO contrato = new ContratoDTO(
                "C-001",
                "Recursos Humanos",
                "Indefinido",
                "Ciudad de México",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2026, 6, 1),
                "Analista de Datos",
                25000.0,
                "Mensual",
                "Transferencia Bancaria",
                evaluacion,
                "EMP-456",
                horarios
        );
        
        CorreoDTO correo = new CorreoDTO();
        correo.setCorreoReceptor("jose.islas252574@potros.itson.edu.mx");
        correo.setPlantillaCorreo("CONTRATACION");
        correo.setValues(new HashMap<String, Object>());
        
        control.enviarContrato(correo, contrato);
    }
}
