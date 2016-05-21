package pe.egcc.eurekaapp.domain;

public class MovimientoBean {

  private String cuenta;
  private String clave;
  private double importe;
  private String empleado;

  public MovimientoBean() {
  }

  public String getCuenta() {
    return cuenta;
  }

  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public String getEmpleado() {
    return empleado;
  }

  public void setEmpleado(String empleado) {
    this.empleado = empleado;
  }

}
