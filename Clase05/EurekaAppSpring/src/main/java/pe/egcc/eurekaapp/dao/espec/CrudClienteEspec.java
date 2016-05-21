package pe.egcc.eurekaapp.dao.espec;

import pe.egcc.eurekaapp.domain.ClienteBean;

/**
 * 
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 * @date   27/12/2015
 *
 */

public interface CrudClienteEspec extends CrudEspec<ClienteBean>{

  boolean tieneCuentas(String codigo);
  
}


