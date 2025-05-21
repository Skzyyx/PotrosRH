package Interfaces;

import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.time.LocalDate;

/**
 * Interfaz del objeto de Negocio NominaBO.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface INominaBO {
    /**
     * Simula el guardado de una nómina en la base de datos.
     * @param nomina Objeto NominaDTO que se desea guardar.
     * @return NominaDTO con nómina insertada.
     * @throws Exceptions.ObjetosNegocioException Excepción.
     */
    public NominaDTO guardarNomina(NominaDTO nomina) throws ObjetosNegocioException;
    /**
     * Obtiene la fecha de la última nómina de un empleado.
     * @param empleado Empleado asociado.
     * @return Fecha de la última nómina del empleado.
     * @throws ObjetosNegocioException Excepción.
     */
    public LocalDate obtenerFechaUltimaNomina(EmpleadoDTO empleado) throws ObjetosNegocioException;
    /**
     * Al no contar con un atributo especial en alguna entidad, y suponiendo que el empleado
     * falte a su primer día de trabajo, se obtiene la fecha en la que debería haber trabajado
     * por primera vez. Esto se hace al tomar el primer día del horario laboral del empleado
     * que se ubique dentro el período, tomando como límite superior la fecha actual, y como
     * límite inferior la fecha de inicio del contrato del empleado. ¿Se podría considerar
     * una mexicanada?
     * @param empleado Empleado, con su horario laboral completo.
     * @param fechaInicioContrato Fecha de inicio del contrato del empleado.
     * @return Fecha del primero día de trabajo del empleado.
     */
    public LocalDate obtenerFechaPrimerDiaTrabajoEsperado(EmpleadoDTO empleado, LocalDate fechaInicioContrato);
    /**
     * Calcula las horas esperadas de un empleado, a partir 
     * de su horario laboral y la fecha de inicio, que se
     * espera que sea de la última nómina o la de su primer
     * día esperado de trabajo.
     * @param empleado Empleado asociado a la nómina.
     * @param fechaInicio Fecha de inicio del período de la nómina.
     * @return Horas esperadas de trabajo del empleado, de acuerdo al período.
     */
    public Double calcularHorasEsperadas(EmpleadoDTO empleado, LocalDate fechaInicio);
}