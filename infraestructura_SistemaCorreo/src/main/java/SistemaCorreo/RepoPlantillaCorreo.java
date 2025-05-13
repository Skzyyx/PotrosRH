package SistemaCorreo;

import java.util.Map;

/**
 *
 * @author skyro
 */
public class RepoPlantillaCorreo {
    
    private static final Map<TipoPlantillaCorreo, PlantillaCorreo> templates = Map.of(
        TipoPlantillaCorreo.CONTRATACION, new PlantillaCorreo(
            "Bienvenido, {{nombre}}",
            "Hola {{nombre}}, has sido contratado para el puesto de {{puesto}} desde el {{fechaInicio}}."
        ),
        TipoPlantillaCorreo.DESPIDO, new PlantillaCorreo(
            "Notificación de término de contrato",
            "Hola {{nombre}}, lamentamos informarte que tu contrato ha sido terminado a partir del {{fechaDespido}}."
        ),
        TipoPlantillaCorreo.NOMINA, new PlantillaCorreo(
            "Resumen de nómina de {{nombreCompleto}}",
            """
            <html>
            <head>
                <style>
                    body { font-family: Arial, sans-serif; color: #333; }
                    .container { width: 80%; margin: auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; }
                    h2 { color: #007bff; }
                    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
                    th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
                    .total { font-weight: bold; color: #28a745; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h2>Recibo de Nómina</h2>
                    <p>Estimado(a) <strong>{{nombreCompleto}}</strong>,</p>
                    <p>Te compartimos tu recibo de nómina correspondiente a la fecha de corte de {{fechaCorte}}</strong>.</p>
                    
                    <table>
                        <tr>
                            <th>Concepto</th>
                            <th>Monto</th>
                        </tr>
                        <tr>
                            <td>Salario Base</td>
                            <td>${{salarioBase}}</td>
                        </tr>
                        <tr>
                            <td>Bono</td>
                            <td>${{bono}}</td>
                        </tr>
                        <tr>
                            <td>Salario Bruto</td>
                            <td>${{salarioBruto}}</td>
                        </tr>
                        <tr>
                            <td>ISR Retenido</td>
                            <td>${{isr}}</td>
                        </tr>
                        <tr class="total">
                            <td>Neto a Pagar</td>
                            <td>${{salarioNeto}}</td>
                        </tr>
                    </table>
                    
                    <p>Gracias por tu esfuerzo y dedicación.</p>
                    <p><em>- Departamento de Recursos Humanos</em></p>
                </div>
            </body>
            </html>
            """
        )
    );

    public static PlantillaCorreo getTemplate(TipoPlantillaCorreo type) {
        return templates.get(type);
    }
}
