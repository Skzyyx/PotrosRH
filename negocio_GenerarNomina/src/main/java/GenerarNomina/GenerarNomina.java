/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarNomina;

import Interfaces.IGenerarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.time.LocalDate;

/**
 *
 * @author skyro
 */
public class GenerarNomina implements IGenerarNomina{

    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado, double bono) {
        return new NominaDTO(empleado, bono, 3.8, 8000, 6500, LocalDate.now(), 40, 5);
    }
    
}
