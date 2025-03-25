package SistemaCorreo;

import Excepciones.CorreoException;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import Interface.ICorreo;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class Correo implements ICorreo {

    /**
     * Envía un correo electrónico con los detalles del recibo de nómina de un empleado.
     * 
     * @param nomina Objeto {@code NominaDTO} que contiene los detalles de la nómina a enviar.
     * @throws CorreoException Si ocurre un error al enviar el correo.
     */
    @Override
    public void enviarCorreo(NominaDTO nomina) throws CorreoException {
        
        EmpleadoDTO empleado = nomina.getEmpleado();
        String nombre = empleado.getNombre() + " " + empleado.getApellidoMaterno() + " " + empleado.getApellidoPaterno();
        
        Resend resend = new Resend("re_JVn91i7s_BPEFemUDeoW7sj55cKbj1maz");

        String htmlTemplate = String.format("""
            <html>
            <head>
                <style>
                    body { font-family: Arial, sans-serif; color: #333; }
                    .container { width: 80%%; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; }
                    h2 { color: #007bff; }
                    table { width: 100%%; border-collapse: collapse; margin-top: 20px; }
                    th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
                    .total { font-weight: bold; color: #28a745; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h2>Recibo de Nómina</h2>
                    <p>Estimado(a) <strong>%s</strong>,</p>
                    <p>Te compartimos tu recibo de nómina correspondiente a la fecha de corte de %s</strong>.</p>
                    
                    <table>
                        <tr>
                            <th>Concepto</th>
                            <th>Monto</th>
                        </tr>
                        <tr>
                            <td>Salario Base</td>
                            <td>$%s</td>
                        </tr>
                        <tr>
                            <td>Bono</td>
                            <td>$%s</td>
                        </tr>
                        <tr>
                            <td>Salario Bruto</td>
                            <td>$%s</td>
                        </tr>
                        <tr>
                            <td>ISR Retenido</td>
                            <td>$%.1f</td>
                        </tr>
                        <tr class="total">
                            <td>Neto a Pagar</td>
                            <td>$%.1f</td>
                        </tr>
                    </table>
                    
                    <p>Gracias por tu esfuerzo y dedicación.</p>
                    <p><em>- Departamento de Recursos Humanos</em></p>
                </div>
            </body>
            </html>
            """, 
                nombre, 
                nomina.getFechaCorte(), 
                empleado.getSalarioBase(), 
                nomina.getBono(), 
                nomina.getSalarioBruto(), 
                nomina.getIsr(), 
                nomina.getSalarioNeto());

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("PotrosRH <potros_rh@resend.dev>")
                .to(nomina.getEmpleado().getEmail())
                .subject("Tu Recibo de Nómina")
                .html(htmlTemplate)
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            throw new CorreoException("Ocurrió un error al enviar el correo.");
        }
    }
}