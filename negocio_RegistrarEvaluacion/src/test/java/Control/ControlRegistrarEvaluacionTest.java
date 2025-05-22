/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import Exceptions.ObjetosNegocioException;
import Exceptions.RegistrarEvaluacionException;
import Interfaces.IEmpleadoBO;
import Interfaces.IEvaluacionBO;
import dto.CandidatoDTO;
import dto.EmpleadoDTO;
import dto.EvaluacionDTO;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author skyro
 */
public class ControlRegistrarEvaluacionTest {

    @Mock
    private IEvaluacionBO evaluacionBO;
    
    @Mock
    private IEmpleadoBO empleadoBO;

    @InjectMocks
    private ControlRegistrarEvaluacion controlEvaluacion;

    private EvaluacionDTO evaluacionValida;
    private CandidatoDTO candidatoValido;

    @BeforeEach
    public void setUp() throws Exception {
        // Inicializar mocks
        MockitoAnnotations.openMocks(this);
        
        // Inyectar los mocks en los campos estáticos usando reflection
        Field fieldEvaluacion = ControlRegistrarEvaluacion.class.getDeclaredField("evaluacionBO");
        fieldEvaluacion.setAccessible(true);
        fieldEvaluacion.set(null, evaluacionBO);
        
        Field fieldEmpleado = ControlRegistrarEvaluacion.class.getDeclaredField("empleadoBO");
        fieldEmpleado.setAccessible(true);
        fieldEmpleado.set(null, empleadoBO);
        
        // Crear un candidato válido para las pruebas
        candidatoValido = new CandidatoDTO();
        candidatoValido.setNombre("Juan");
        candidatoValido.setApellidoPaterno("Pérez");
        candidatoValido.setApellidoMaterno("López");
        candidatoValido.setFechaNacimiento(LocalDate.now());
        candidatoValido.setEmail("juan.perez@example.com");
        candidatoValido.setRfc("PELJ901231ABC");
        candidatoValido.setCurp("PELJ901231HDFRZN09");
        candidatoValido.setCalle("Calle Principal");
        candidatoValido.setNumero("123");
        candidatoValido.setColonia("Centro");
        candidatoValido.setTelefono("1234567890");
        candidatoValido.setSexo("M");
        
        // Crear una evaluación válida para las pruebas
        evaluacionValida = new EvaluacionDTO();
        evaluacionValida.setCandidato(candidatoValido);
        evaluacionValida.setFechaHoraEvaluacion(LocalDateTime.now());
        evaluacionValida.setNotas("Buen desempeño en la entrevista");
        evaluacionValida.setResultado("APROBADO");
        evaluacionValida.setPuntuacionesClave("Respuestas Precisas");
    }

    @Test
    public void testValidarEvaluacionValida() throws RegistrarEvaluacionException {
        // Ejecutar
        boolean resultado = controlEvaluacion.validarEvaluacion(evaluacionValida);
        
        // Verificar
        assertTrue(resultado);
    }

    @Test
    public void testValidarEvaluacionCampoNulo() {
        // Preparar
        evaluacionValida.setNotas(null);
        
        // Ejecutar y verificar
        RegistrarEvaluacionException exception = assertThrows(
            RegistrarEvaluacionException.class,
            () -> controlEvaluacion.validarEvaluacion(evaluacionValida)
        );
        
        assertTrue(exception.getMessage().contains("no puede ser nulo"));
    }

    @Test
    public void testRegistrarEvaluacion() throws RegistrarEvaluacionException, ObjetosNegocioException {
        // Preparar
        when(empleadoBO.registrarEmpleado(any(EmpleadoDTO.class))).thenReturn(new EmpleadoDTO());
        when(evaluacionBO.registrarEvaluacion(any(EvaluacionDTO.class))).thenReturn(evaluacionValida);
        
        // Ejecutar
        EvaluacionDTO resultado = controlEvaluacion.registrarEvaluacion(evaluacionValida);
        
        // Verificar
        assertNotNull(resultado);
        verify(empleadoBO, times(1)).registrarEmpleado(any(EmpleadoDTO.class));
        verify(evaluacionBO, times(1)).registrarEvaluacion(any(EvaluacionDTO.class));
    }

    @Test
    public void testRegistrarEvaluacionNula() {
        // Ejecutar y verificar
        RegistrarEvaluacionException exception = assertThrows(
            RegistrarEvaluacionException.class,
            () -> controlEvaluacion.registrarEvaluacion(null)
        );
        
        assertEquals("La evaluación no puede ser nula.", exception.getMessage());
    }

    @Test
    public void testRegistrarEvaluacionConErrorEmpleado() throws ObjetosNegocioException {
        // Preparar
        when(empleadoBO.registrarEmpleado(any(EmpleadoDTO.class)))
            .thenThrow(new ObjetosNegocioException("Error al registrar empleado"));
        
        // Ejecutar y verificar
        RegistrarEvaluacionException exception = assertThrows(
            RegistrarEvaluacionException.class,
            () -> controlEvaluacion.registrarEvaluacion(evaluacionValida)
        );
        
        assertEquals("Error al registrar empleado", exception.getMessage());
        verify(empleadoBO, times(1)).registrarEmpleado(any(EmpleadoDTO.class));
        verify(evaluacionBO, never()).registrarEvaluacion(any(EvaluacionDTO.class));
    }
}