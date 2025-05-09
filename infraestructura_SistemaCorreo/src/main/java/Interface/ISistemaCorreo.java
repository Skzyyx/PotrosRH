package Interface;


import Excepciones.CorreoException;
import SistemaCorreo.PlantillaCorreo;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 * Clase que se encarga del envío de correos electrónicos.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public interface ISistemaCorreo {
    
    /**
     * Envía un correo electrónico con los detalles del recibo de nómina de un empleado.
     * 
     * @param correo Correo electrónico al que se enviará.
     * @param template Plantilla del tipo de correo.
     * @param values Conjunto de variables y valores a reemplazar.
     * @throws CorreoException Si ocurre un error al enviar el correo.
     * 
     * @return true si se logra el envío.
     */
    boolean sendEmail(String correo, PlantillaCorreo template, Map<String, Object> values) throws CorreoException;
}
