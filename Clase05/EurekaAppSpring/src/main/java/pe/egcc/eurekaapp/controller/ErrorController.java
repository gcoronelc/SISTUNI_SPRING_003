package pe.egcc.eurekaapp.controller;

//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ErrorController {

  
  @ExceptionHandler(RuntimeException.class)
  public ModelAndView handleCustomException(RuntimeException ex) {

    ModelAndView view = new ModelAndView("mensajeError");
    view.addObject("mensaje", ex.getMessage());

    return view;

  }
  
}
