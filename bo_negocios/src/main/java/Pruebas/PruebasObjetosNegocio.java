package Pruebas;


import Exceptions.ObjetosNegocioException;
import bo.CandidatoBO;
import dto.CandidatoDTO;
import dto.CandidatoFiltroDTO;
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
        
        CandidatoFiltroDTO filtro = new CandidatoFiltroDTO();
        filtro.setRfc("DASDASDASDA");
        try {
            List<CandidatoDTO> candidatosFiltrados = CandidatoBO.getInstance().obtenerPorFiltro(filtro);
            candidatosFiltrados.forEach(t -> {
                System.out.println(t.toString());
            });
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(PruebasObjetosNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}