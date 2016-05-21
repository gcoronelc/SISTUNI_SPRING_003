package pe.egcc.eurekaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.eurekaapp.dao.espec.CrudEmpleadoEspec;
import pe.egcc.eurekaapp.domain.EmpleadoBean;

@Service
public class LogonService {

  @Autowired
  private CrudEmpleadoEspec crudEmpleado;
  
  public EmpleadoBean validar(String usuario, String clave){
    if(usuario == null || usuario.isEmpty()){
      throw new RuntimeException("Faltan datos.");
    }
    if(clave == null || clave.isEmpty()){
      throw new RuntimeException("Faltan datos.");
    }
    EmpleadoBean bean = crudEmpleado.validar(usuario, clave);
    if(bean == null){
      throw new RuntimeException("Datos incorrectos.");
    }
    return bean;
  }
  
  
}
