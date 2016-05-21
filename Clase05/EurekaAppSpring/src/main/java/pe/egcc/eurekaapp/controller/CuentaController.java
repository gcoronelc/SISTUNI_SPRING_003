package pe.egcc.eurekaapp.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.egcc.eurekaapp.domain.MovimientoBean;

@Controller
public class CuentaController {

  
  @RequestMapping(value="deposito.htm", method=RequestMethod.GET)
  public String deposito(){
    return "deposito";
  }
  
  @RequestMapping(value="deposito.htm", method=RequestMethod.POST, produces="Application/json")
  @ResponseBody
  public String deposito(@ModelAttribute MovimientoBean movimientoBean){
    Map<String, Object> rpta = new HashMap<String, Object>();
    /// Proceso
    rpta.put("code", 1);
    rpta.put("mensaje", "Proceso ejecutado correctamente.");
    // Creación del JSON
    Gson gson = new Gson();
    String textoJson = gson.toJson(rpta); 
    return textoJson;
  }
  
  @RequestMapping(value="deposito2.htm", method=RequestMethod.POST, 
      produces="Application/json")
  @ResponseBody
  public Map<String,Object> deposito2(@ModelAttribute MovimientoBean movimientoBean){
    Map<String, Object> rpta = new HashMap<String, Object>();
    /// Proceso
    rpta.put("code", 1);
    rpta.put("mensaje", "Proceso ejecutado correctamente.");
    // Retorno
    return rpta;
  }
  
  
  
}
