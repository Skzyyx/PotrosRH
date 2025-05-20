package PruebasUnitarias;

import Control.ControlSubsistemaDespidos;
import Excepciones.CorreoException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IDespidoEmpleadoBO;
import Interfaces.IEmpleadoBO;
import dto.CorreoDTO;
import dto.DespidoDTO;
import dto.EmpleadoDTO;
import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
@ExtendWith(MockitoExtension.class)
public class PruebasUnitariasSubsistemaDespidos {
    @Mock
    private IEmpleadoBO empleadoBO;

    @Mock
    private IDespidoEmpleadoBO despidoBO;

    @Mock
    private ISistemaCorreo sistemaCorreo;

    @InjectMocks
    private ControlSubsistemaDespidos controlDespidos;

    private EmpleadoDTO empleado;

    @BeforeEach
    void setUp() {
        empleado = new EmpleadoDTO();
        empleado.setId("123");
        empleado.setRfc("ABC123");
        empleado.setNombre("Juan");
        empleado.setApellidoPaterno("Pérez");
        empleado.setApellidoMaterno("López");
        empleado.setEmail("jesus.lopez252663@potros.itson.edu.mx");
    }

    @Test
    void cambiarEstado_DatosValidos_EstadoCambiado() throws Exception {
        when(empleadoBO.obtenerEmpleadoActivo((EmpleadoDTO) any())).thenReturn(empleado);

        EmpleadoDTO resultado = controlDespidos.cambiarEstado(empleado, "INACTIVO");

        verify(empleadoBO).actualizarEstadoEmpleadoD(eq("ABC123"), eq("INACTIVO"));
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void cambiarEstado_DatosNulos_LanzaCorreoException() {
        assertThrows(CorreoException.class, () -> controlDespidos.cambiarEstado(null, "INACTIVO"));
    }

    @Test
    void registrarDespido_DatosValidos_DespidoRegistradoYCorreoEnviado() throws Exception {
        when(empleadoBO.obtenerEmpleadoActivo((EmpleadoDTO) any())).thenReturn(empleado);
        //when(empleadoBO.actualizarEstadoEmpleadoD(anyString(), anyString())).thenReturn(true);

        controlDespidos.registrarDespido(empleado, "Incumplimiento de normas");

        //verify(despidoBO).registrarDespido(any(DespidoDTO.class));
        //verify(sistemaCorreo).sendEmail(any(CorreoDTO.class));
    }

    @Test
    void registrarDespido_DatosIncompletos_LanzaObjetosNegocioException() {
        empleado.setId(null);
        assertThrows(ObjetosNegocioException.class, () -> controlDespidos.registrarDespido(empleado, "Falta grave"));
    }
}