/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import Conexion.Conexion;
import DAO.EmpleadoDAO;
import Entidades.Empleado;
import Entidades.Nomina;
import Exceptions.AccesoDatosException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;

/**
 * Clase de pruebas.
 * @author PC WHITE WOLF
 */
public class NominaPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoCollection<Nomina> nominas = Conexion.getDatabase().getCollection("nominas", Nomina.class);
        Empleado rfc = new Empleado();
        rfc.setRfc("GUMF900101ABC");
        
        try {
            Empleado empleado = new EmpleadoDAO().obtenerEmpleado(rfc);
            // Filtro para buscar el empleado por su ID
            Bson filtroEmpleado = Filters.eq("empleado_id", empleado.getId());
            // Se ejecuta la consuta y se obtiene la fecha
            Nomina fechaUltimaNomina = nominas
                    .find(filtroEmpleado)
                    .projection(Projections.include("fechaCorte"))
                    .sort(Sorts.descending("fechaCorte"))
                    .first();
            
            if(fechaUltimaNomina == null)
                System.out.println("Error en consulta");
            else
                System.out.printf("Exito, eso creo.");
            
        } catch (AccesoDatosException e) {
            System.out.println("Algo salio mal.");
        }
    }
    
}