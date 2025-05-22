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
 * Controlador para las operaciones de registro de evaluaciones. Valida los
 * datos de evaluación y maneja la conversión de candidatos a empleados.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ControlRegistrarEvaluacion {

    private static IEvaluacionBO evaluacionBO = EvaluacionBO.getInstance();
    private static IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();

    /**
     * Constructor por defecto de la clase ControlRegistrarEvaluacion.
     */
    public ControlRegistrarEvaluacion() {
    }

    /**
     * Valida que todos los campos requeridos de una evaluación no sean nulos.
     *
     * @param evaluacion El DTO de evaluación a validar
     * @return true si todos los campos requeridos son válidos
     * @throws RegistrarEvaluacionException Si algún campo requerido es nulo o
     * hay un error de acceso
     */
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

    /**
     * Registra una nueva evaluación en el sistema y convierte al candidato
     * asociado en un empleado.
     *
     * @param evaluacion El DTO de evaluación a registrar
     * @return La evaluación registrada
     * @throws RegistrarEvaluacionException Si la evaluación es nula o ocurre un
     * error durante el registro
     */
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
