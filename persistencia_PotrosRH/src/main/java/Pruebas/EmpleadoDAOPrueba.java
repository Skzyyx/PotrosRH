package Pruebas;

import DAO.EmpleadoDAO;
import Exceptions.AccesoDatosException;
import Interfaces.IEmpleadoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC WHITE WOLF
 */
public class EmpleadoDAOPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IEmpleadoDAO eDAO = new EmpleadoDAO();
        
        try {
            eDAO.obtenerTodosSinContrato(new ArrayList<>()).forEach((t) -> {
                System.out.println(t.toString());
            });
        } catch (AccesoDatosException ex) {
            Logger.getLogger(EmpleadoDAOPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}