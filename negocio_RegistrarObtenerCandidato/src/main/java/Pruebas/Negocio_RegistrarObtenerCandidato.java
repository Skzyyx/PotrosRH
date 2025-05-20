/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Pruebas;

import Exceptions.RegistrarObtenerCandidatoException;
import Fachada.RegistrarObtenerCandidato;
import Interfaces.IRegistrarObteneCandidato;
import dto.CandidatoFiltroDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class Negocio_RegistrarObtenerCandidato {

    public static void main(String[] args) {
        CandidatoFiltroDTO filtro = new CandidatoFiltroDTO();
        filtro.setRfc("DASDASDASDA");
        
        IRegistrarObteneCandidato roc = RegistrarObtenerCandidato.getInstance();
        
        try {
            roc.obtenerPorFiltro(filtro).forEach((t) -> {
                System.out.println(t.toString());
            });
            
            
        } catch (RegistrarObtenerCandidatoException ex) {
            Logger.getLogger(Negocio_RegistrarObtenerCandidato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
