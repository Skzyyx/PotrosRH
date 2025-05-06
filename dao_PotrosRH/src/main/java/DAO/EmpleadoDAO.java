/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Direccion;
import Entidades.Empleado;
import Exceptions.AccesoDatosException;
import Interfaces.IEmpleadoDAO;
import enums.EstadoEmpleado;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class EmpleadoDAO implements IEmpleadoDAO {   
    
    private List<Empleado> empleados = Arrays.asList(
                new Empleado("Freddy", "Guzman", "Moreno", 
                    "jose.islas252574@potros.itson.edu.mx", 
                    "GUMF900101ABC",
                    "CURPFREDDY1234",
                    new Direccion("Peppa", "Power Rangers", "123"), 
                    "1231231950", 
                    "Limpieza", 
                    "Empleado", 
                    4000.0, 
                    EstadoEmpleado.ACTIVO),
                
                new Empleado("Jesús Ernesto", "López", "Ibarra", 
                    "jose.islas252574@potros.itson.edu.mx", 
                    "LOIJ920315XYZ",
                    "CURPNETO1234",
                    new Direccion("Furbo", "Real Madrid", "123"), 
                    "6442291849", 
                    "Recursos Humanos", 
                    "Empleado", 
                    8000.0, 
                    EstadoEmpleado.ACTIVO),
                
                new Empleado("José Luis", "Islas", "Molina", 
                    "jose.islas252574@potros.itson.edu.mx", 
                    "ISLM850525DEF",
                    "CURPJOSE1234",
                    new Direccion("Avenida Siempre Viva", "Centro", "456"), 
                    "9876543210", 
                    "TI", 
                    "Analista", 
                    12000.0, 
                    EstadoEmpleado.ACTIVO)
        );

    @Override
    public boolean validarEstado(String rfc) throws AccesoDatosException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarPorcentajeAsistencias(String rfc) throws AccesoDatosException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado obtenerEmpleado(String rfc) throws AccesoDatosException {
        // Buscar al empleado por RFC
        for (Empleado empleado : empleados) {
            if (empleado.getRfc().equalsIgnoreCase(rfc)) {
                return empleado;
            }
        }

        // Si no se encuentra el empleado, lanza una excepción
        throw new AccesoDatosException("No se encontró un empleado con el RFC proporcionado");
    }
}
