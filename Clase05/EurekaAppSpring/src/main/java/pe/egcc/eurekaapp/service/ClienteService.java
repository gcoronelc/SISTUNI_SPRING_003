package pe.egcc.eurekaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.eurekaapp.dao.espec.CrudClienteEspec;
import pe.egcc.eurekaapp.domain.ClienteBean;
import pe.egcc.eurekaapp.util.EurekaUtil;

/**
 * 
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 * @date 27/12/2015
 *
 */
@Service
public class ClienteService {

  @Autowired
  private CrudClienteEspec crudCliente;
  
  
  public ClienteBean traerCliente(String codigo){
    return crudCliente.traerPorCodigo(codigo);
  }
  
  public List<ClienteBean> traerClientes(ClienteBean clienteBean){
    clienteBean.setPaterno(clienteBean.getPaterno() + "%");
    clienteBean.setMaterno(clienteBean.getMaterno() + "%");
    clienteBean.setNombre(clienteBean.getNombre() + "%");
    return crudCliente.traerPorNombre(clienteBean);    
  }

  public void procesar(ClienteBean clienteBean) {
    if(clienteBean.getAccion().equals(EurekaUtil.CRUD_NUEVO)){
      crudCliente.insertar(clienteBean);
    } else if(clienteBean.getAccion().equals(EurekaUtil.CRUD_EDITAR)){
      crudCliente.actualizar(clienteBean);
    } else if(clienteBean.getAccion().equals(EurekaUtil.CRUD_ELIMINAR)){
      if(crudCliente.tieneCuentas(clienteBean.getCodigo())){
        throw new RuntimeException("No puede eliminarse por que tiene cuentas.");
      }
      crudCliente.eliminar(clienteBean.getCodigo());
    }
  }
  
}
