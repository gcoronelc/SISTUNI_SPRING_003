package pe.egcc.eurekaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.egcc.eurekaapp.domain.ClienteBean;
import pe.egcc.eurekaapp.service.ClienteService;
import pe.egcc.eurekaapp.util.EurekaUtil;

@Controller
public class ClienteController {

  @Autowired
  private ClienteService clienteService;
  
  @RequestMapping(value="mantClientes.htm", method=RequestMethod.GET)
  public String principal(){
    return "mantClientes";
  }
  
  @RequestMapping(value="traerCliente.htm", method=RequestMethod.GET)
  public String traerCliente(@RequestParam("codigo") String codigo, Model model){
    ClienteBean clienteBean =clienteService.traerCliente(codigo);
    model.addAttribute("bean", clienteBean);
    return "conCliente";
  }
  
  @RequestMapping(value="traerClientes.htm", method=RequestMethod.POST)
  public String traerClientes(@ModelAttribute ClienteBean clienteBean, Model model){
    List<ClienteBean> listado =clienteService.traerClientes(clienteBean);
    model.addAttribute("listado", listado);
    return "conClientes";
  }
  
  @RequestMapping(value="nuevoCliente.htm", method=RequestMethod.GET)
  public String nuevo(Model model){
    ClienteBean bean = new ClienteBean();
    bean.setCodigo(EurekaUtil.CRUD_NUEVO);
    model.addAttribute("ACCION", EurekaUtil.CRUD_NUEVO);
    model.addAttribute("clienteBean", bean);
    return "editCliente";
  }
  
  @RequestMapping(value="editarCliente.htm", method=RequestMethod.POST)
  public String editar(@RequestParam("codigo") String codigo, Model model){
    ClienteBean bean = clienteService.traerCliente(codigo);
    if(bean == null){
      throw new RuntimeException("No existe el codigo " + codigo + ".");
    }
    model.addAttribute("ACCION", EurekaUtil.CRUD_EDITAR);
    model.addAttribute("clienteBean", bean);
    return "editCliente";
  }
  
  @RequestMapping(value="eliminarCliente.htm", method=RequestMethod.POST)
  public String eliminar(@RequestParam("codigo") String codigo, Model model){
    ClienteBean bean = clienteService.traerCliente(codigo);
    model.addAttribute("ACCION", EurekaUtil.CRUD_ELIMINAR);
    model.addAttribute("clienteBean", bean);
    model.addAttribute("editar", "disabled='disabled'");
    return "editCliente";
  }
  
  @RequestMapping(value="procesarCliente.htm", method=RequestMethod.POST)
  @ResponseBody
  public String procesar(@ModelAttribute ClienteBean clienteBean){
    String rpta;
    try {
      clienteService.procesar(clienteBean);
      rpta = "1";
    } catch (Exception e) {
      rpta = e.getMessage();
    }
    return rpta;
  }
  
  
}
