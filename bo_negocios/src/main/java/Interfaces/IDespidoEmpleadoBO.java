package Interfaces;

import Exceptions.AccesoDatosException;
import Exceptions.ObjetosNegocioException;
import dto.DespidoDTO;

/**
 *
 * @author Jesús Ernesto López Ibarra (252663)
 */
public interface IDespidoEmpleadoBO {
  public void registrarDespido(DespidoDTO despidoDTO) throws AccesoDatosException;
  public void actualizarEstadoEmpleado(String rfc) throws ObjetosNegocioException, AccesoDatosException;  
} 