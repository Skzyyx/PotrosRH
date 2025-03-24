/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author alfre
 */
import dto.EmpleadoDTO;
import enums.EstadoEmpleado;

public class EmpleadoBO {
    private EmpleadoDTO empleado;

    public EmpleadoBO(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public boolean esEmpleadoActivo() {
        return empleado.getEstado() == EstadoEmpleado.ACTIVO;
    }

    public void actualizarSalario(double nuevoSalario) {
        if (nuevoSalario > 0) {
            empleado.setSalarioBase(nuevoSalario);
        } else {
            throw new IllegalArgumentException("El salario debe ser mayor a 0");
        }
    }
}