package Control;

import Excepciones.CorreoException;
import Exceptions.GenerarNominaException;
import Exceptions.ObjetosNegocioException;
import Interfaces.IGenerarNomina;
import SistemaCorreo.Correo;
import bo.NominaBO;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.ICorreo;
import Interfaces.INominaBO;
import enums.EstadoEmpleado;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlGenerarNomina implements IGenerarNomina {
    
    private final INominaBO nominaBO = NominaBO.getInstance();

    /**
     * Genera la nómina de un empleado activo.
     *
     * @param empleado Objeto EmpleadoDTO con la información del empleado.
     * @return Objeto NominaDTO con los detalles de la nómina generada.
     * @throws GenerarNominaException Si el empleado es nulo o está inactivo.
     */
    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException {
        if (empleado == null) 
            throw new GenerarNominaException("El empleado no puede ser nulo.");
        
        if(empleado.getEstado() == EstadoEmpleado.INACTIVO)
            throw new GenerarNominaException("El empleado debe de estar activo.");
        
        try {
            return nominaBO.generarNomina(empleado);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException("Error al generar la nómina: " + ex.getMessage());
        }
    }

    /**
     * Guarda la nómina en la base de datos y envía un correo al empleado.
     *
     * @param nomina Objeto NominaDTO con la información de la nómina.
     * @return `true` si el proceso fue exitoso, `false` en caso contrario.
     * @throws GenerarNominaException Si la nómina es nula o si ocurre un error.
     */
    @Override
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException{
        if(nomina == null)
            throw new GenerarNominaException("La nomina no puede ser nula.");
        
        ICorreo sistemaCorreo = new Correo();
        try {
            nominaBO.guardarNomina(nomina);
            sistemaCorreo.enviarCorreo(nomina);
            return true;
        } catch (CorreoException ex) {
            Logger.getLogger(ControlGenerarNomina.class.getName()).log(Level.SEVERE, null, ex);
            throw new GenerarNominaException("Ocurrió un error al enviar el correo.");
        }
    }
}