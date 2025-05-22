/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import Exceptions.ObjetosNegocioException;
import Exceptions.RegistrarObtenerCandidatoException;
import Interfaces.ICandidatoBO;
import bo.CandidatoBO;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 * Pruebas unitarias para la clase ControlRegistrarObtenerCandidato
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ControlRegistrarObtenerCandidatoTest {

    @Mock
    private ICandidatoBO candidatoBO;

    @InjectMocks
    private ControlRegistrarObtenerCandidato controlCandidato;

    private CandidatoDTO candidatoValido;

    @BeforeEach
    public void setUp() throws Exception {
        // Inicializar mocks
        MockitoAnnotations.openMocks(this);

        // Inyectar el mock en el campo estático usando reflection
        Field field = ControlRegistrarObtenerCandidato.class.getDeclaredField("candidatoBO");
        field.setAccessible(true);
        field.set(null, candidatoBO);

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
        candidatoValido.setExperiencia("3 Años");
        candidatoValido.setNivelEstudio("Licenciatura");
        candidatoValido.setHabilidadesClave("Liderazgo");
    }

    @Test
    public void testValidarDatosCandidatoValido() throws RegistrarObtenerCandidatoException {
        // Ejecutar
        boolean resultado = controlCandidato.validarDatosCandidato(candidatoValido);

        // Verificar
        assertTrue(resultado);
    }

    @Test
    public void testValidarDatosCandidatoEmailInvalido() {
        // Preparar
        candidatoValido.setEmail("correo_invalido");

        // Ejecutar y verificar
        RegistrarObtenerCandidatoException exception = assertThrows(
                RegistrarObtenerCandidatoException.class,
                () -> controlCandidato.validarDatosCandidato(candidatoValido)
        );

        assertEquals("El correo no tiene el formato correcto", exception.getMessage());
    }

    @Test
    public void testValidarDatosCandidatoRfcInvalido() {
        // Preparar
        candidatoValido.setRfc("RFC-INVALIDO");

        // Ejecutar y verificar
        RegistrarObtenerCandidatoException exception = assertThrows(
                RegistrarObtenerCandidatoException.class,
                () -> controlCandidato.validarDatosCandidato(candidatoValido)
        );

        assertEquals("RFC con formato inválido.", exception.getMessage());
    }

    @Test
    public void testRegistrarCandidato() throws RegistrarObtenerCandidatoException, ObjetosNegocioException {
        // Preparar
        when(candidatoBO.registrarCandidato(any(CandidatoDTO.class))).thenReturn(candidatoValido);

        // Ejecutar
        CandidatoDTO resultado = controlCandidato.registrarCandidato(candidatoValido);

        // Verificar
        assertNotNull(resultado);
        verify(candidatoBO, times(1)).registrarCandidato(any(CandidatoDTO.class));
    }

    @Test
    public void testRegistrarCandidatoConError() throws ObjetosNegocioException {
        // Preparar
        when(candidatoBO.registrarCandidato(any(CandidatoDTO.class)))
                .thenThrow(new ObjetosNegocioException("Error al registrar candidato"));

        // Ejecutar y verificar
        RegistrarObtenerCandidatoException exception = assertThrows(
                RegistrarObtenerCandidatoException.class,
                () -> controlCandidato.registrarCandidato(candidatoValido)
        );

        assertEquals("Error al registrar candidato", exception.getMessage());
    }

    @Test
    public void testObtenerCandidato() throws RegistrarObtenerCandidatoException, ObjetosNegocioException {
        // Preparar
        when(candidatoBO.obtenerCandidato(any(CandidatoDTO.class))).thenReturn(candidatoValido);

        // Ejecutar
        CandidatoDTO resultado = controlCandidato.obtenerCandidato(candidatoValido);

        // Verificar
        assertNotNull(resultado);
        verify(candidatoBO, times(1)).obtenerCandidato(any(CandidatoDTO.class));
    }

    @Test
    public void testObtenerTodos() throws RegistrarObtenerCandidatoException, ObjetosNegocioException {
        // Preparar
        List<CandidatoDTO> candidatos = new ArrayList<>();
        candidatos.add(candidatoValido);
        when(candidatoBO.obtenerTodos()).thenReturn(candidatos);

        // Ejecutar
        List<CandidatoDTO> resultado = controlCandidato.obtenerTodos();

        // Verificar
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(candidatoBO, times(1)).obtenerTodos();
    }
}
