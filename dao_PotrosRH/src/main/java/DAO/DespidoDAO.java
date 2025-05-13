package DAO;

import Entidades.Despido;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public class DespidoDAO {

    public DespidoDAO() {
    }

    public void guardarDespido(Despido despido) {
        // TODO: Implementar la lógica para guardar la información del despido en la base de datos
        // (probablemente convertir el DespidoDTO a una entidad de Despido primero)
        System.out.println("DespidoDAO: Guardar despido del empleado con RFC " + despido.getRfcEmpleado() +
                           " con motivo: " + despido.getMotivo() +
                           " en fecha: " + despido.getFechaDespido());
    }

    // Otros métodos para interactuar con la tabla de despidos
}
