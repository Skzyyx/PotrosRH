package Interface;

import Excepciones.CorreoException;
import dto.NominaDTO;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface ICorreo {
    public void enviarCorreo(NominaDTO nomina) throws CorreoException;
}