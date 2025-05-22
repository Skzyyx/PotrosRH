/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Excepciones.ObtenerEmpleadoException;
import Excepciones.PresentacionException;
import Exceptions.GenerarContratoException;
import Exceptions.RegistrarEvaluacionException;
import Exceptions.RegistrarObtenerCandidatoException;
import Fachada.GenerarContrato;
import Fachada.ObtenerEmpleado;
import Fachada.RegistrarEvaluacion;
import Fachada.RegistrarObtenerCandidato;
import Interface.IRegistrarEvaluacion;
import Interfaces.IGenerarContrato;
import Interfaces.IObtenerEmpleado;
import Interfaces.IRegistrarObteneCandidato;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import dto.ContratoDTO;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import dto.EvaluacionDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador principal para el registro de candidatos, evaluaciones y
 * contratos. Coordina las operaciones entre las diferentes fachadas del sistema
 * y maneja las excepciones de negocio convirtiéndolas en excepciones de
 * presentación. Implementa el patrón Singleton para garantizar una única
 * instancia.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ControlRegistro {

    private static ControlRegistro instance;

    private CandidatoDTO candidatoDTO;
    private EvaluacionDTO evaluacionDTO;
    private ContratoDTO contratoDTO;

    private final IRegistrarObteneCandidato registrarObteneCandidato = RegistrarObtenerCandidato.getInstance();
    private final IRegistrarEvaluacion registrarEvaluacion = RegistrarEvaluacion.getInstance();
    private final IGenerarContrato generarContrato = GenerarContrato.getInstance();
    private final IObtenerEmpleado obtenerEmpleado = ObtenerEmpleado.getInstance();

    /**
     * Constructor privado para implementar el patrón Singleton. Inicializa los
     * DTOs necesarios para las operaciones.
     */
    private ControlRegistro() {
        this.candidatoDTO = new CandidatoDTO();
        this.evaluacionDTO = new EvaluacionDTO();
        this.contratoDTO = new ContratoDTO();
    }

    /**
     * Obtiene la instancia única del controlador (Singleton).
     *
     * @return La instancia única de ControlRegistro
     */
    public static ControlRegistro getInstance() {
        if (instance == null) {
            instance = new ControlRegistro();
        }
        return instance;
    }

    /**
     * Registra un nuevo candidato en el sistema.
     *
     * @param candidato DTO con los datos del candidato a registrar
     * @return El candidato registrado con su ID generado
     * @throws PresentacionException Si ocurre un error durante el registro
     */
    public CandidatoDTO registrarCandidato(CandidatoDTO candidato) throws PresentacionException {
        try {
            candidatoDTO = registrarObteneCandidato.registrarCandidato(candidato);
            return candidatoDTO;
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Obtiene un candidato específico del sistema.
     *
     * @param candidato DTO con los datos de búsqueda (generalmente RFC)
     * @return El candidato encontrado
     * @throws PresentacionException Si el candidato no existe o hay un error
     */
    public CandidatoDTO obtenerCandidato(CandidatoDTO candidato) throws PresentacionException {
        try {
            return registrarObteneCandidato.obtenerCandidato(candidato);
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Obtiene todos los candidatos registrados en el sistema.
     *
     * @return Lista de todos los candidatos
     * @throws PresentacionException Si hay un error al recuperar los candidatos
     */
    public List<CandidatoDTO> obtenerTodosCandidatos() throws PresentacionException {
        try {
            return registrarObteneCandidato.obtenerTodos();
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Registra una evaluación para un candidato en el sistema.
     *
     * @param evaluacion DTO con los datos de la evaluación
     * @return La evaluación registrada con su ID generado
     * @throws PresentacionException Si hay un error al registrar la evaluación
     */
    public EvaluacionDTO registrarEvaluacion(EvaluacionDTO evaluacion) throws PresentacionException {
        try {
            evaluacionDTO = registrarEvaluacion.registrarEvaluacion(evaluacion);
            return evaluacionDTO;
        } catch (RegistrarEvaluacionException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Registra un nuevo contrato en el sistema.
     *
     * @param contrato DTO con los datos del contrato
     * @return El contrato registrado con su ID generado
     * @throws PresentacionException Si hay un error al registrar el contrato
     */
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws PresentacionException {
        try {
            contratoDTO = generarContrato.registrarContrato(contrato);
            return contratoDTO;
        } catch (GenerarContratoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Obtiene candidatos que coinciden con los criterios de filtrado.
     *
     * @param filtro DTO con los criterios de búsqueda
     * @return Lista de candidatos que coinciden con el filtro
     * @throws PresentacionException Si hay un error en la búsqueda
     */
    public List<CandidatoDTO> obtenerPorFiltro(CandidatoFiltroDTO filtro) throws PresentacionException {
        try {
            return registrarObteneCandidato.obtenerPorFiltro(filtro);
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Obtiene empleados que no tienen contrato asignado.
     *
     * @param filtro DTO con los criterios de búsqueda
     * @return Lista de empleados sin contrato
     * @throws PresentacionException Si hay un error en la búsqueda
     */
    public List<EmpleadoDTO> obtenerTodosSinContrato(EmpleadoFiltroDTO filtro) throws PresentacionException {
        try {
            return obtenerEmpleado.obtenerTodosSinContrato(filtro);
        } catch (ObtenerEmpleadoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }

    /**
     * Obtiene un empleado específico por su RFC.
     *
     * @param empleado DTO con el RFC del empleado a buscar
     * @return El empleado encontrado
     * @throws PresentacionException Si el empleado no existe o hay un error
     */
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws PresentacionException {
        EmpleadoDTO rfc = new EmpleadoDTO();
        rfc.setRfc(empleado.getRfc());
        try {
            return obtenerEmpleado.obtenerEmpleado(rfc);
        } catch (ObtenerEmpleadoException ex) {
            Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new PresentacionException(ex.getMessage());
        }
    }
}
