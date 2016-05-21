package pe.egcc.eurekaapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.LogonService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private LogonService logonService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		return "home";
	}
	
	
	
	@RequestMapping(value="logon.htm", method=RequestMethod.POST)
	public String logon(@ModelAttribute EmpleadoBean empleadoBean,
	    HttpSession session, Model model){
	  String destino;
	  try {
      EmpleadoBean bean ;
      bean = logonService.validar(empleadoBean.getUsuario(), empleadoBean.getClave());
      session.setAttribute("usuario", bean);
	    destino = "main";
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      destino = "home";
    }
	  return destino;
	}
}
