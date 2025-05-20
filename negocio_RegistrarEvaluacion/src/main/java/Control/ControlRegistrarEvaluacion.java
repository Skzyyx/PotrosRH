/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Exceptions.ObjetosNegocioException;
import Exceptions.RegistrarEvaluacionException;
import Interfaces.IEmpleadoBO;
import Interfaces.IEvaluacionBO;
import bo.EmpleadoBO;
import bo.EvaluacionBO;
import dto.CandidatoDTO;
import dto.EmpleadoDTO;
import dto.EvaluacionDTO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class ControlRegistrarEvaluacion {

    private static IEvaluacionBO evaluacionBO = EvaluacionBO.getInstance();
    private static IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();

    public ControlRegistrarEvaluacion() {
    }

    public Boolean validarEvaluacion(EvaluacionDTO evaluacion) throws RegistrarEvaluacionException {
        for (Field field : evaluacion.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            // Filtrar atributos que no quieres validar
            if (field.getName().equals("id")) {
                continue;
            }

            try {
                if (field.get(evaluacion) == null) {
                    throw new RegistrarEvaluacionException("El campo '" + field.getName() + "' no puede ser nulo.");
                }
            } catch (IllegalAccessException e) {
                throw new RegistrarEvaluacionException("Error al acceder al campo: " + field.getName());
            }
        }
        return true;
    }

//    private String departamento;
//    private String puesto;
//    private Double salarioBase;
//    private String estado;
//    private List<HorarioLaboralDTO> horariosLaborales;
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws RegistrarEvaluacionException {
        if (evaluacion == null) {
            throw new RegistrarEvaluacionException("La evaluación no puede ser nula.");
        }
        try {
            CandidatoDTO can = evaluacion.getCandidato();
            EmpleadoDTO empleado = new EmpleadoDTO();

            empleado.setNombre(can.getNombre());
            empleado.setApellidoPaterno(can.getApellidoPaterno());
            empleado.setApellidoMaterno(can.getApellidoMaterno());
            empleado.setFechaNacimiento(can.getFechaNacimiento());
            empleado.setEmail(can.getEmail());
            empleado.setRfc(can.getRfc());
            empleado.setCurp(can.getCurp());
            empleado.setCalle(can.getCalle());
            empleado.setNumero(can.getNumero());
            empleado.setColonia(can.getColonia());
            empleado.setTelefono(can.getTelefono());
            empleado.setSexo(can.getSexo());
            empleado.setEstado("SIN_CONTRATO");
            empleado.setHorariosLaborales(new ArrayList<>());

            empleadoBO.registrarEmpleado(empleado);
            
            
            return evaluacionBO.registrarEvaluacion(evaluacion);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlRegistrarEvaluacion.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new RegistrarEvaluacionException(ex.getMessage());
        }
    }
}
