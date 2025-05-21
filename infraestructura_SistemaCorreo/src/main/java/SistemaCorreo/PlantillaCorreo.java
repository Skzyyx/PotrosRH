package SistemaCorreo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Plantilla de un correo electrónico.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class PlantillaCorreo {
    
    private final String subjectTemplate;
    private final String bodyTemplate;

    public PlantillaCorreo(String subjectTemplate, String bodyTemplate) {
        this.subjectTemplate = subjectTemplate;
        this.bodyTemplate = bodyTemplate;
    }

    public String getSubject(Map<String, Object> values) {return replacePlaceholders(subjectTemplate, values);}

    public String getBody(Map<String, Object> values) {return replacePlaceholders(bodyTemplate, values);}

    private String replacePlaceholders(String template, Map<String, Object> values) {
        String result = template;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String formattedValue = formatValue(entry.getValue());
            result = result.replace("{{" + entry.getKey() + "}}", formattedValue);
        }
        return result;
    }

    private String formatValue(Object value) {
        if (value instanceof BigDecimal || value instanceof Double || value instanceof Float) {
            return String.format("%.2f", value);
        }
        return value != null ? value.toString() : "";
    }   
}