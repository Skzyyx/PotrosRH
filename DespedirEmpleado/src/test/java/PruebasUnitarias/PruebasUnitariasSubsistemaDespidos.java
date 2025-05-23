package PruebasUnitarias;

import Excepciones.CorreoException;
import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IDespidoEmpleadoBO;
import Interfaces.IEmpleadoBO;
import dto.CorreoDTO;
import dto.DespidoDTO;
import dto.EmpleadoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Da error porque moví de lugar el proyecto y no me detecta el import del Control del subsistema
 * @author Jesús Ernesto López Ibarra (252663)
 */
@ExtendWith(MockitoExtension.class)
public class PruebasUnitariasSubsistemaDespidos {
//    @Mock
//    private IEmpleadoBO empleadoBO;
//
//    @Mock
//    private IDespidoEmpleadoBO despidoBO;
//
//    @Mock
//    private ISistemaCorreo sistemaCorreo;
//
//    @InjectMocks
//    private ControlSubsistemaDespidos controlDespidos;
//
//    private EmpleadoDTO empleado;
//
//    @BeforeEach
//    void setUp() {
//        empleado = new EmpleadoDTO();
//        empleado.setId("123");
//        empleado.setRfc("ABC123");
//        empleado.setNombre("Juan");
//        empleado.setApellidoPaterno("Pérez");
//        empleado.setApellidoMaterno("López");
//        empleado.setEmail("jesus.lopez252663@potros.itson.edu.mx");
//    }
//
//    @Test
//    void testDespidoExitoso() throws Exception {
//        // Act
//        controlDespidos.registrarDespido(empleado, "Incumplimiento de reglas");
//
//        // Assert
//        verify(despidoBO).registrarDespido(any(DespidoDTO.class));
//        verify(empleadoBO).actualizarEstadoEmpleadoD(eq("ABCD123FGHI"), eq("INACTIVO"));
//        verify(sistemaCorreo).sendEmail(any(CorreoDTO.class));
//    }
//
//    @Test
//    void testEmpleadoNuloLanzaExcepcion() {
//        ObjetosNegocioException exception = assertThrows(
//            ObjetosNegocioException.class,
//            () -> controlDespidos.registrarDespido(null, "motivo")
//        );
//        assertTrue(exception.getMessage().contains("Datos incompletos"));
//    }
//
//    @Test
//    void testEmpleadoSinIdLanzaExcepcion() {
//        empleado.setId(null);
//
//        ObjetosNegocioException exception = assertThrows(
//            ObjetosNegocioException.class,
//            () -> controlDespidos.registrarDespido(empleado, "motivo")
//        );
//        assertTrue(exception.getMessage().contains("Datos incompletos"));
//    }
//
//    @Test
//    void testMotivoVacioLanzaExcepcion() {
//        ObjetosNegocioException exception = assertThrows(
//            ObjetosNegocioException.class,
//            () -> {
//            try {
//                controlDespidos.registrarDespido(empleado, "");
//            } catch (CorreoException ex) {
//                Logger.getLogger(PruebasUnitariasSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ObjetosNegocioException ex) {
//                Logger.getLogger(PruebasUnitariasSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        );
//        assertTrue(exception.getMessage().contains("Datos incompletos"));
//    }
//
//    @Test
//    void testErrorEnRegistroDeDespidoLanzaExcepcion() throws Exception {
//        doThrow(new AccesoDatosException("fallo")).when(despidoBO).registrarDespido(any());
//
//        ObjetosNegocioException exception = assertThrows(
//            ObjetosNegocioException.class,
//            () -> {
//            try {
//                controlDespidos.registrarDespido(empleado, "motivo");
//            } catch (CorreoException ex) {
//                Logger.getLogger(PruebasUnitariasSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ObjetosNegocioException ex) {
//                Logger.getLogger(PruebasUnitariasSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        );
//        assertTrue(exception.getMessage().contains("Error al registrar el despido"));
//    }
//
//    @Test
//    void testErrorAlActualizarEstadoEmpleadoLanzaExcepcion() throws Exception {
//        doNothing().when(despidoBO).registrarDespido(any());
//        doThrow(new AccesoDatosException("fallo")).when(empleadoBO).actualizarEstadoEmpleadoD(anyString(), anyString());
//
//        ObjetosNegocioException exception = assertThrows(
//            ObjetosNegocioException.class,
//            () -> {
//            try {
//                controlDespidos.registrarDespido(empleado, "motivo");
//            } catch (CorreoException ex) {
//                Logger.getLogger(PruebasUnitariasSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ObjetosNegocioException ex) {
//                Logger.getLogger(PruebasUnitariasSubsistemaDespidos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        );
//        assertTrue(exception.getMessage().contains("Error al cambiar el estado del empleado"));
//    }
//
//    @Test
//    void testErrorAlEnviarCorreoLanzaExcepcion() throws Exception {
//        doNothing().when(despidoBO).registrarDespido(any());
//        doNothing().when(empleadoBO).actualizarEstadoEmpleadoD(anyString(), anyString());
//        doThrow(new CorreoException("fallo")).when(sistemaCorreo).sendEmail(any());
//
//        CorreoException exception = assertThrows(
//            CorreoException.class,
//            () -> controlDespidos.registrarDespido(empleado, "motivo")
//        );
//        assertTrue(exception.getMessage().contains("Error al enviar el correo de despido"));
//    }
}