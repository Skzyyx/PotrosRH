/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Control;

import Control.ControlRegistrarAsistencia;
import dto.EmpleadoDTO;
import dto.HorarioLaboralDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControlRegistrarAsistenciaTest {

//    private ControlRegistrarAsistencia control;
//
//    @BeforeEach
//    public void setUp() {
//        control = new ControlRegistrarAsistencia();
//    }
//
//    @Test
//    public void testRegistrarEntrada() throws Exception {
//        EmpleadoDTO empleado = crearEmpleadoCompletoConHorarioValido();
//        LocalDate fechaAsistencia = LocalDate.now();
//        LocalTime horaEntrada = LocalTime.of(8, 0);
//
//        boolean resultado = control.registrarEntrada(empleado, fechaAsistencia, horaEntrada);
//        assertTrue(resultado);
//    }
//
//    @Test
//    public void testRegistrarSalida() throws Exception {
//        EmpleadoDTO empleado = crearEmpleadoCompletoConHorarioValido();
//        LocalDate fechaAsistencia = LocalDate.now();
//        LocalTime horaSalida = LocalTime.of(17, 0);
//
//        boolean resultado = control.registrarSalida(empleado, fechaAsistencia, horaSalida);
//        assertTrue(resultado);
//    }
//
//    @Test
//    public void testValidarHorarioLaboral() throws Exception {
//        EmpleadoDTO empleado = crearEmpleadoCompletoConHorarioValido();
//        LocalDate fechaAsistencia = LocalDate.now();
//
//        boolean resultado = control.validarHorarioLaboral(empleado, fechaAsistencia);
//        assertTrue(resultado);
//    }
//
//    @Test
//    public void testObtenerDetallesHorarioLaboralDia() throws Exception {
//        EmpleadoDTO empleado = crearEmpleadoCompletoConHorarioValido();
//        LocalDate fechaAsistencia = LocalDate.now();
//
//        HorarioLaboralDTO horario = control.obtenerDetallesHorarioLaboralDia(empleado, fechaAsistencia);
//        assertNotNull(horario);
//        assertEquals(LocalTime.of(8, 0), horario.getHoraInicioTurno());
//        assertEquals(LocalTime.of(17, 0), horario.getHoraFinTurno());
//    }
//
//    @Test
//    public void testEnviarCorreo() throws Exception {
//        EmpleadoDTO empleado = crearEmpleadoCompletoConHorarioValido();
//        LocalDate fechaAsistencia = LocalDate.now();
//        LocalTime hora = LocalTime.of(8, 0);
//        String tipoAsistencia = "entrada";
//
//        boolean resultado = control.enviarCorreo(empleado, fechaAsistencia, hora, tipoAsistencia);
//        assertTrue(resultado);
//    }
//
//    // Método auxiliar
//    private EmpleadoDTO crearEmpleadoCompletoConHorarioValido() {
//        EmpleadoDTO empleado = new EmpleadoDTO();
//        empleado.setId("507f1f77bcf86cd799439011"); // ID válido con 24 caracteres hexadecimales
//        empleado.setNombre("Juan");
//        empleado.setApellidoPaterno("Pérez");
//        empleado.setApellidoMaterno("Gómez");
//        empleado.setFechaNacimiento(LocalDate.of(1990, 1, 1));
//        empleado.setSexo("HOMBRE");
//        empleado.setEmail("juan.perez@example.com");
//        empleado.setRfc("JUAP900101HDF");
//        empleado.setCurp("JUAP900101HDFRZN08");
//        empleado.setCalle("Calle Falsa");
//        empleado.setColonia("Centro");
//        empleado.setNumero("123");
//        empleado.setTelefono("5551234567");
//        empleado.setDepartamento("TI");
//        empleado.setPuesto("Desarrollador");
//        empleado.setSalarioBase(15000.0);
//        empleado.setEstado("ACTIVO");
//
//        HorarioLaboralDTO horario = new HorarioLaboralDTO();
//        horario.setDiaSemana("JUEVES");
//        horario.setHoraInicioTurno(LocalTime.of(8, 0));
//        horario.setHoraFinTurno(LocalTime.of(17, 0));
//
//        List<HorarioLaboralDTO> horarios = new ArrayList<>();
//        horarios.add(horario);
//        empleado.setHorariosLaborales(horarios);
//
//        return empleado;
//    }
}
