package com.mycompany.subsistema_despedir_empleado;

import Control.ControlSubsistemaDespidos;
import Excepciones.CorreoException;
import Exceptions.ObjetosNegocioException;
import dto.EmpleadoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class Subsistema_Despedir_Empleado {

    public static void main(String[] args) {
        ControlSubsistemaDespidos controlDespidos = new ControlSubsistemaDespidos();
        EmpleadoDTO empleadoPrueba = new EmpleadoDTO();

        empleadoPrueba.setRfc("RFCPrueba123");
        empleadoPrueba.setNombre("Jesús Ernesto");
        empleadoPrueba.setApellidoPaterno("López");
        empleadoPrueba.setApellidoMaterno("Perez");
        empleadoPrueba.setEmail("jesus.lopez252663@potros.itson.edu.mx");

        String motivoDespido = "Prueba de despido para envío de correo";

        try {
            controlDespidos.registrarDespido(empleadoPrueba, motivoDespido);
            System.out.println("Prueba de registro de despido y envío de correo completada (revisa la consola para posibles errores y tu bandeja de entrada).");
        } catch (CorreoException e) {
            System.err.println("Error durante la prueba de registro de despido o envío de correo (CorreoException): " + e.getMessage());
        } catch (ObjetosNegocioException e) {
            System.err.println("Error durante la prueba de registro de despido (ObjetosNegocioException): " + e.getMessage());
        }
    }
}