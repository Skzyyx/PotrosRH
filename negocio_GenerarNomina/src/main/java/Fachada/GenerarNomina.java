package Fachada;

import Control.ControlGenerarNomina;
import Excepciones.CorreoException;
import Exceptions.GenerarNominaException;
import Interfaces.IGenerarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase fachada que conecta con presentación e implementa la interfaza
 * iGenerarNomina.
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class GenerarNomina implements IGenerarNomina {

    /**
     * Atributo SingleTon de la clase.
     */
    private static GenerarNomina instance;
    /**
     * Clase control del subsistema.
     */
    private ControlGenerarNomina control;

    /**
     * Constructor por defecto.
     */
    private GenerarNomina() {
        this.control = new ControlGenerarNomina();
    }

    /**
     * Método que devuelve el objeto SingleTon de la clase. Si el objeto aún no
     * se ha creado, se crea y se retorna.
     *
     * @return Objeto SingleTon de la clase.
     */
    public static synchronized IGenerarNomina getInstance() {
        if (instance == null) {
            instance = new GenerarNomina();
        }
        return instance;
    }

    /**
     * Genera la nómina de un empleado activo.
     *
     * @param empleado El objeto {@link EmpleadoDTO} que contiene los datos del
     * empleado.
     * @return Un objeto {@link NominaDTO} con la nómina generada.
     * @throws GenerarNominaException Si el empleado es nulo o no está activo.
     */
    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException {
        return control.generarNomina(empleado);
    }

    /**
     * Guarda la nómina generada en la base de datos y envía un correo al
     * empleado.
     *
     * @param nomina El objeto {@link NominaDTO} que contiene la información de
     * la nómina.
     * @return `true` si la nómina fue guardada y el correo enviado
     * correctamente, `false` en caso contrario.
     * @throws GenerarNominaException Si la nómina es nula o si ocurre un error
     * al guardar la nómina o enviar el correo.
     */
    @Override
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException {
        try {
            return control.guardarNomina(nomina) && control.enviarCorreo(nomina);
        } catch (GenerarNominaException ex) {
            Logger.getLogger(GenerarNomina.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarNominaException(ex.getMessage());
        }

    }
}
