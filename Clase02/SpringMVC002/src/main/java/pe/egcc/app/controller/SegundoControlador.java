package pe.egcc.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.app.service.MateService;

@Controller
public class SegundoControlador {
  
  @Autowired
  private MateService mateService;

  @RequestMapping(value="suma.htm", method=RequestMethod.GET)
  public String calcSuma(){
    return "suma";
  }
  
  
  @RequestMapping(value="suma.htm", method=RequestMethod.POST)
  public String calcSuma(HttpServletRequest request, 
      Model model){
    // Datos
    int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));
    // Proceso
    int suma = mateService.sumar(n1, n2);
    // Reporte
    model.addAttribute("n1", n1);
    model.addAttribute("n2", n2);
    model.addAttribute("suma", suma);
    // Forward
    return "suma";
  }
  
  @RequestMapping(value="suma2.htm", method=RequestMethod.POST)
  public String calcSuma2(
      @RequestParam(value="n1", defaultValue="0", required=false) Integer num1, 
      @RequestParam("n2") int num2,
      Model model){
    // Proceso
    int suma = mateService.sumar((num1==null)?0:num1, num2);
    // Reporte
    model.addAttribute("n1", num1);
    model.addAttribute("n2", num2);
    model.addAttribute("suma", suma);
    // Forward
    return "suma";
  }


  
  
}
