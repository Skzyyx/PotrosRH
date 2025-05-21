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
import java.util.Map;
import Interface.ISistemaCorreo;
import Interfaces.IEmpleadoBO;
import bo.EmpleadoBO;
import dto.CorreoDTO;
import java.time.LocalDate;

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
        if (!(empleado != null && empleado.getId() != null)) 
            throw new GenerarNominaException("El empleado no puede ser nulo.");
        
        // Si el empleado está inactivo.
        if (!(empleado.getEstado() != null && empleado.getEstado().toUpperCase().equals("ACTIVO"))) 
            throw new GenerarNominaException("El empleado debe de estar activo.");
        
        // Si el DTO recibido no tiene el salario base del empleado.
        if(empleado.getSalarioBase() == null )
            throw new GenerarNominaException("El empleado recibido no cuenta con un salario base.");
        
        // Si el empleado no está cargado con su horario laboral completo.
        if(!(empleado.getHorariosLaborales() != null && !empleado.getHorariosLaborales().isEmpty()))
            throw new GenerarNominaException("El empleado recibido no cuenta con su horario laboral completo.");

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
    public NominaDTO guardarNomina(NominaDTO nomina) throws GenerarNominaException {
        // Si la nómina está vacía.
        if (nomina == null) 
            throw new GenerarNominaException("La nomina no puede ser nula.");
        
        // Valida los atributos de la nómina recibida.
        validarNomina(nomina);
        
        try {
            NominaDTO nominaDTO = nominaBO.guardarNomina(nomina); // Se guarda la nómina.
            return nominaDTO; // Regresa true como confirmación de nómina generada con éxito.
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
    /**
     * Valida los atributos de una nómina recibida.
     * @param nomina Nómina a validar.
     * @throws GenerarNominaException 
     */
    private void validarNomina(NominaDTO nomina) throws GenerarNominaException{
        // Si la nómina no tiene un empleado asociado.
        if(!(nomina.getEmpleadoId() != null && !nomina.getEmpleadoId().isEmpty()))
            throw new GenerarNominaException("La nomina debe tener un empleado asociado.");
        
        // Si la nómina cuenta con un bono, pero es negativo.
        if(nomina.getBono() != null && nomina.getBono() < 0.0)
            throw new GenerarNominaException("No se le puede aplicar un bono negativo a la nómina.");
        
        // Si la nómina no tiene el ISR
        if(nomina.getIsr() == null)
            throw new GenerarNominaException("La nomina debe contar con el ISR aplicado al sueldo del empleado.");
        // Si el ISR es negativo.
        if(nomina.getIsr() < 0.0)
            throw new GenerarNominaException("El ISR no puede ser negativo.");
        
        // Si la nómina no cuenta con el salario bruto.
        if(nomina.getSalarioBruto() == null)
            throw new GenerarNominaException("La nómina debe contar con el salario bruto.");
        
        // Si el salario bruto es negativo.
        if(nomina.getSalarioBruto() < 0.0)
            throw new GenerarNominaException("El salario bruto no puede ser negativo.");
        
        // Si la nómina no cuenta con el salario neto.
        if(nomina.getSalarioNeto() == null)
            throw new GenerarNominaException("La nómina debe contar con el salario neto.");
        
        // Si el salario neto es negativo.
        if(nomina.getSalarioNeto() < 0.0)
            throw new GenerarNominaException("El salario neto no puede ser negativo.");
        
        // Si la nómina no tiene la fecha de corte.
        if(nomina.getFechaCorte() == null)
            throw new GenerarNominaException("La nómina debe contar con una fecha de corte");
        
        // Si la fecha de corte está después de la actual.
        if(nomina.getFechaCorte().isAfter(LocalDate.now()))
            throw new GenerarNominaException("La fecha de corte no puede estar después de la fecha actual.");
        
        // Si la nómina no cuenta con los días trabajados.
        if(nomina.getDiasTrabajados() == null)
            throw new GenerarNominaException("La nómina debe contar con los días trabajados del empleado.");
        
        // Si los días trabajados es una cantidad negativa
        if(nomina.getDiasTrabajados() < 0)
            throw new GenerarNominaException("La nomina debe contar con los días trabajados del empleado.");
        
        // Si la nómina no cuenta con las horas trabajadas del empleado.
        if(nomina.getHorasTrabajadas() == null)
            throw new GenerarNominaException("La nómina debe contar con las horas trabajadas del empleado");
        
        // Si las horas trabajas es un número negativo
        if(nomina.getHorasTrabajadas() < 0.0)
            throw new GenerarNominaException("Las cantidad de horas trabajadas no puede ser negativa.");
        
        // Si la nómina cuenta con horas extra, pero es una cantidad negativa
        if(nomina.getHorasExtra() != null && nomina.getHorasExtra() < 0.0)
            throw new GenerarNominaException("Las cantidad de horas extra no puede ser negativa.");
        
        // Si el estado de cobro de la nómina es positivo
        if(nomina.getEstadoCobro() == true)
            throw new GenerarNominaException("No se puede guardar una nómina que ya ha sido cobrada.");
    }
}
