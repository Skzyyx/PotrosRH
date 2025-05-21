package Pruebas;


import Exceptions.ObjetosNegocioException;
import bo.CandidatoBO;
import bo.EmpleadoBO;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
import dto.EmpleadoDTO;
import dto.EmpleadoFiltroDTO;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase de pruebas del proyecto.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class PruebasObjetosNegocio {

    /**
     * Método main.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EmpleadoFiltroDTO filtro = new EmpleadoFiltroDTO();
        filtro.setRfc("LOI");
        try {
            List<EmpleadoDTO> candidatosFiltrados = EmpleadoBO.getInstance().obtenerTodosSinContrato(filtro);
            candidatosFiltrados.forEach(t -> {
                System.out.println(t.toString());
            });
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(PruebasObjetosNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}