package Pruebas;

import Conexion.Conexion;
import DAO.EmpleadoDAO;
import Entidades.Empleado;
import Entidades.RegistroAsistencia;
import Exceptions.AccesoDatosException;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

/**
 *
 * @author PC WHITE WOLF
 */
public class RegistroAsistenciaDAOPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoCollection<RegistroAsistencia> rDAO = Conexion.getDatabase().getCollection("registro_asistencia", RegistroAsistencia.class);
        
        try {
            Empleado rfc = new Empleado();
            rfc.setRfc("GUMF900101ABC");
            rfc = new EmpleadoDAO().obtenerEmpleado(rfc);
            
            RegistroAsistencia r1 = new RegistroAsistencia(rfc.getId(), LocalDate.of(2025, Month.MAY, 13), LocalTime.of(9, 7, 55), LocalTime.of(16, 35, 24));
            RegistroAsistencia r2 = new RegistroAsistencia(rfc.getId(), LocalDate.of(2025, Month.MAY, 14), LocalTime.of(9, 32, 45), LocalTime.of(17, 02, 57));
            RegistroAsistencia r3 = new RegistroAsistencia(rfc.getId(), LocalDate.of(2025, Month.MAY, 15), LocalTime.of(10, 21, 00), LocalTime.of(16, 58, 49));
            RegistroAsistencia r4 = new RegistroAsistencia(rfc.getId(), LocalDate.of(2025, Month.MAY, 16), LocalTime.of(9, 1, 54), LocalTime.of(17, 0, 0));
            RegistroAsistencia r5 = new RegistroAsistencia(rfc.getId(), LocalDate.of(2025, Month.MAY, 19), LocalTime.of(9, 0, 24), LocalTime.of(16, 44, 50));
            RegistroAsistencia r6 = new RegistroAsistencia(rfc.getId(), LocalDate.of(2025, Month.MAY, 20), LocalTime.of(8, 50, 35), LocalTime.of(18, 0, 56));
            
            rDAO.insertMany(Arrays.asList(r1, r2, r3, r4, r5, r6));
            
        } catch (AccesoDatosException e) {System.out.println("Algo salió mal.");}
    }
    
}