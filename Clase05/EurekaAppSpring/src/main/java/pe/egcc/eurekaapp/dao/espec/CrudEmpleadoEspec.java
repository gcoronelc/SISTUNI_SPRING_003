package pe.egcc.eurekaapp.dao.espec;

import pe.egcc.eurekaapp.domain.EmpleadoBean;

/**
 * 
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 * @date   27/12/2015
 *
 */

public interface CrudEmpleadoEspec extends CrudEspec<EmpleadoBean> {

  EmpleadoBean validar(String usuario, String clave);
}


