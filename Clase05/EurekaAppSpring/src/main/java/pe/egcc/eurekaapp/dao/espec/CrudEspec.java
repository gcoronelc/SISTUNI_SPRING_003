package pe.egcc.eurekaapp.dao.espec;

import java.util.List;

/**
 * 
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 * @date   27/12/2015
 *
 */

public interface CrudEspec <T>{

  T traerPorCodigo(String codigo);
  
  List<T> traerPorNombre(T bean);
  
  void insertar(T bean);
  
  void actualizar(T bean);
  
  void eliminar(String codigo);
  
}


