/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Control.ControlGenerarNomina;
import Exceptions.GenerarNominaException;
import Interfaces.IGenerarNomina;
import dto.EmpleadoDTO;
import dto.NominaDTO;

/**
 *
 * @author skyro
 */
public class GenerarNomina implements IGenerarNomina {

    private static GenerarNomina instance;
    private ControlGenerarNomina control;

    private GenerarNomina() {
        this.control = new ControlGenerarNomina();
    }
    
    public static synchronized IGenerarNomina getInstance() {
        if (instance == null) {
            instance = new GenerarNomina();
        }
        return instance;
    }
    
    @Override
    public NominaDTO generarNomina(EmpleadoDTO empleado) throws GenerarNominaException {
        return control.generarNomina(empleado);
    }

    @Override
    public boolean guardarNomina(NominaDTO nomina) throws GenerarNominaException {
        return control.guardarNomina(nomina);
    }
    
}
