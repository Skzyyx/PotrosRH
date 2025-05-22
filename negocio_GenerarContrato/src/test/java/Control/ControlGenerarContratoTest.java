/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import Entidades.Empleado;
import Exceptions.GenerarContratoException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IContratoBO;
import bo.ContratoBO;
import dto.ContratoDTO;
import dto.CorreoDTO;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Pruebas unitarias para la clase ControlGenerarContrato
 * 
 * @author Jose Luis Islas Molina 252574
 */
class ControlGenerarContratoTest {

    @Mock
    private IContratoBO contratoBO = ContratoBO.getInstance();

    private ControlGenerarContrato control;
    private ContratoDTO contratoValido;
    private CorreoDTO correoValido;
    private java.util.List<HorarioLaboralDTO> horariosValidos;
    private EmpleadoDTO empleado;

    @BeforeEach
    void setUp() {
        control = new ControlGenerarContrato();
        
        // Crear horarios válidos
        horariosValidos = new ArrayList<>();
        HorarioLaboralDTO horario1 = new HorarioLaboralDTO();
        horario1.setDiaSemana("Lunes");
        horario1.setHoraInicioTurno(LocalTime.of(8, 0));
        horario1.setHoraFinTurno(LocalTime.of(17, 0));

        HorarioLaboralDTO horario2 = new HorarioLaboralDTO();
        horario2.setDiaSemana("Martes");
        horario2.setHoraInicioTurno(LocalTime.of(8, 0));
        horario2.setHoraFinTurno(LocalTime.of(17, 0));

        horariosValidos.add(horario1);
        horariosValidos.add(horario2);
        
        // Empleado
        empleado = new EmpleadoDTO();
        
        empleado.setId("682f7a87e96ea2027c1246ce");
        empleado.setHorariosLaborales(horariosValidos);
        empleado.setNombre("Leonardo");
        empleado.setApellidoPaterno("Flores");
        empleado.setApellidoMaterno("Leyva");
        empleado.setSexo("HOMBRE");
        empleado.setRfc("ABCD123456LEO");
        empleado.setEmail("leonardo.guapo252390@potros.itson.edu.mx");
        empleado.setTelefono("6441903464");
        empleado.setCurp("FLOA001106HSLMNS01");
        empleado.setFechaNacimiento(LocalDate.of(2005, Month.OCTOBER, 9));
        empleado.setDepartamento("Recursos Humanos");
        empleado.setCalle("CalleFalsa");
        empleado.setNumero("1243");
        empleado.setColonia("ColoniaFake");
        empleado.setEstado("ACTIVO");
        empleado.setPuesto("Administrador de Recursos Humanos");
        empleado.setSalarioBase(500.00);

        // Crear contrato válido para las pruebas
        contratoValido = new ContratoDTO();
        contratoValido.setDepartamento("Desarrollo");
        contratoValido.setLugarTrabajo("Oficina Central");
        contratoValido.setFechaInicio(LocalDate.of(2024, 1, 1));
        contratoValido.setFechaFin(LocalDate.of(2024, 12, 31));
        contratoValido.setPuesto("Desarrollador Java");
        contratoValido.setSueldo(25000.00);
        contratoValido.setPeriodoPago("SEMANAL");
        contratoValido.setModoPago("CHEQUE");
        contratoValido.setHorarios(new LinkedHashSet<>(horariosValidos));
        contratoValido.setEmpleado(empleado);
    }

    // ========== Pruebas para registrarContrato ==========
    @Test
    void testRegistrarContrato_ContratoValido_RetornaContratoRegistrado() 
            throws GenerarContratoException, ObjetosNegocioException {
        
        // Arrange
        ContratoDTO contratoEsperado = new ContratoDTO();
        contratoEsperado.setEmpleado(empleado);
        contratoEsperado.setDepartamento("Desarrollo");
        
        try (MockedStatic<ContratoBO> contratoBOMock = Mockito.mockStatic(ContratoBO.class)) {
            contratoBOMock.when(ContratoBO::getInstance).thenReturn(contratoBO);
//            when(contratoBO.registrarContrato(any(ContratoDTO.class)))
//                .thenReturn(contratoEsperado);
            
            // Act
            ContratoDTO resultado = control.registrarContrato(contratoValido);
            
            // Assert
            assertNotNull(resultado);
            assertEquals("Desarrollo", resultado.getDepartamento());
            assertEquals("Leonardo", resultado.getEmpleado().getNombre());
            assertEquals("Flores", resultado.getEmpleado().getApellidoPaterno());
            assertEquals("Leyva", resultado.getEmpleado().getApellidoMaterno());
        }
    }
    
    @Test
    void testRegistrarContrato_ContratoNulo_LanzaExcepcion() {
        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(null)
        );

        assertEquals("El contrato no puede ser nulo.", exception.getMessage());
    }

    @Test
    void testRegistrarContrato_DepartamentoNulo_LanzaExcepcion() {
        contratoValido.setDepartamento(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("departamento"));
    }

    @Test
    void testRegistrarContrato_LugarTrabajoNulo_LanzaExcepcion() {
        contratoValido.setLugarTrabajo(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("lugarTrabajo"));
    }

    @Test
    void testRegistrarContrato_FechaInicioNula_LanzaExcepcion() {
        contratoValido.setFechaInicio(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("fechaInicio"));
    }

    @Test
    void testRegistrarContrato_FechaFinNula_LanzaExcepcion() {
        contratoValido.setFechaFin(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("fechaFin"));
    }

    @Test
    void testRegistrarContrato_PuestoNulo_LanzaExcepcion() {
        contratoValido.setPuesto(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("puesto"));
    }

    @Test
    void testRegistrarContrato_SueldoNulo_LanzaExcepcion() {
        contratoValido.setSueldo(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("sueldo"));
    }

    @Test
    void testRegistrarContrato_PeriodoPagoNulo_LanzaExcepcion() {
        contratoValido.setPeriodoPago(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("periodoPago"));
    }

    @Test
    void testRegistrarContrato_ModoPagoNulo_LanzaExcepcion() {
        contratoValido.setModoPago(null);

        GenerarContratoException exception = assertThrows(
                GenerarContratoException.class,
                () -> control.registrarContrato(contratoValido)
        );

        assertTrue(exception.getMessage().contains("modoPago"));
    }
}
