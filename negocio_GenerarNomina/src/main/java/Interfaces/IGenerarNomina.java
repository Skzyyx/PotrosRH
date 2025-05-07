package Interfaces;

import Exceptions.GenerarNominaException;
import dto.EmpleadoDTO;
import dto.NominaDTO;

/**
 * Interfaz que declara los métodos del subsistema GenerarNomina.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface IGenerarNomina {
    
    /**
     * Genera la nómina de un empleado activo.
     * @param empleado El objeto {@link EmpleadoDTO} que contiene los datos del empleado.
     * @return Un objeto {@link NominaDTO} con la nómina generada.
     * @throws GenerarNominaException Si el empleado es nulo o no está activo.
     */
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException;
    
    /**
     * Guarda la nómina generada en la base de datos y envía un correo al empleado.
     * @param nomina El objeto {@link NominaDTO} que contiene la información de la nómina.
     * @return `true` si la nómina fue guardada y el correo enviado correctamente, `false` en caso contrario.
     * @throws GenerarNominaException Si la nómina es nula o si ocurre un error al guardar la nómina o enviar el correo.
     */
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException;
}