package Control;

import Excepciones.CorreoException;
import Exceptions.GenerarNominaException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IGenerarNomina;
import bo.NominaBO;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.INominaBO;
import SistemaCorreo.SistemaCorreo;
import SistemaCorreo.PlantillaCorreo;
import SistemaCorreo.RepoPlantillaCorreo;
import SistemaCorreo.TipoPlantillaCorreo;
import java.util.Map;
import Interface.ISistemaCorreo;
import Interfaces.IEmpleadoBO;
import bo.EmpleadoBO;
import dto.CorreoDTO;

/**
 * Realiza validaciones de negocio y genera la nómina correspondiente al
 * empleado recibido.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlGenerarNomina implements IGenerarNomina {

    /**
     * Objeto BO de las nóminas.
     */
    private final INominaBO nominaBO = NominaBO.getInstance();
    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstance();
    /**
     * Genera la nómina de un empleado activo.
     *
     * @param empleado Objeto EmpleadoDTO con la información del empleado.
     * @return Objeto NominaDTO con los detalles de la nómina generada.
     * @throws GenerarNominaException Si el empleado es nulo o está inactivo.
     */
    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException {
        // Si el empleado es null
        if (empleado == null) {
            throw new GenerarNominaException("El empleado no puede ser nulo.");
        }
        // Si el empleado está inactivo.
        if (!empleado.getEstado().equals("ACTIVO")) {
            throw new GenerarNominaException("El empleado debe de estar activo.");
        }

        try {
            return nominaBO.generarNomina(empleado); // Se genera la nómina y se regresa como un DTO.
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException("Error al generar la nómina: " + ex.getMessage());
        }
    }

    /**
     * Guarda la nómina en la base de datos.
     *
     * @param nomina Objeto NominaDTO con la información de la nómina.
     * @return `true` si el proceso fue exitoso, `false` en caso contrario.
     * @throws GenerarNominaException Si la nómina es nula o si ocurre un error.
     */
    @Override
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException {
        // Si la nómina está vacía.
        if (nomina == null) {
            throw new GenerarNominaException("La nomina no puede ser nula.");
        }
        // Sistema de correo electrónico.
        //ICorreo sistemaCorreo = new Correo();
        try {
            nominaBO.guardarNomina(nomina); // Se guarda la nómina.
            return true; // Regresa true como confirmación de nómina generada con éxito.
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException(ex.getMessage(), ex);
        }
    }

    /**
     * Envia un correo al empleado con la información de su nómina.
     *
     * @param nomina Objeto NominaDTO con la información de la nómina.
     * @return `true` si el proceso fue exitoso, `false` en caso contrario.
     * @throws GenerarNominaException Si ocurre un error al enviar el correo.
     */
    public boolean enviarCorreo(NominaDTO nomina) throws GenerarNominaException {
        try {
            EmpleadoDTO empleadoBuscar = new EmpleadoDTO();
            empleadoBuscar.setId(nomina.getEmpleadoId());
            EmpleadoDTO empleado = empleadoBO.obtenerEmpleadoId(empleadoBuscar);
            
            ISistemaCorreo sistemaCorreo = new SistemaCorreo();
            
            CorreoDTO dto = new CorreoDTO();
            dto.setCorreoReceptor(empleado.getEmail());
            dto.setPlantillaCorreo("NOMINA");
            
            Map<String, Object> values = Map.of(
                    "nombreCompleto", String.join(" ",
                            empleado.getNombre(),
                            empleado.getApellidoPaterno(),
                            empleado.getApellidoMaterno()
                    ),
                    "fechaCorte", nomina.getFechaCorte(),
                    "salarioBase", empleado.getSalarioBase(),
                    "bono", nomina.getBono(),
                    "salarioBruto", nomina.getSalarioBruto(),
                    "isr", nomina.getIsr(),
                    "salarioNeto", nomina.getSalarioNeto()
            );
            
            dto.setValues(values);
            
            sistemaCorreo.sendEmail(dto);
            return true;
        } catch (CorreoException | ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarNominaException("Ocurrió un error al intentar enviar el correo.");
        }
    }
}
