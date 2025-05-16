package com.mycompany.subsistema_despedir_empleado;

import Control.ControlSubsistemaDespidos;
import Excepciones.CorreoException;
import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class Subsistema_Despedir_Empleado {

    public static void main(String[] args) {
        ControlSubsistemaDespidos controlDespidos = new ControlSubsistemaDespidos();
        EmpleadoDTO empleadoPrueba = new EmpleadoDTO();

        // Simula la información de un empleado
        empleadoPrueba.setNombre("Jesús Ernesto");
        empleadoPrueba.setApellidoPaterno("López");
        empleadoPrueba.setApellidoMaterno("Ibarra");
        empleadoPrueba.setEmail("jesus.lopez252663@potros.itson.edu.mx");

        try {
            controlDespidos.enviarCorreoDespido(empleadoPrueba);
            System.out.println("Prueba de envío de correo completada (revisa la consola para posibles errores).");
        } catch (CorreoException e) {
            System.err.println("Error durante la prueba de envío de correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
