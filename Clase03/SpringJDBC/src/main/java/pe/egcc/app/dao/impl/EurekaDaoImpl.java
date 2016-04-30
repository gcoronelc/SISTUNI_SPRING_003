package pe.egcc.app.dao.impl;

import org.springframework.stereotype.Repository;

import pe.egcc.app.dao.espec.EurekaDaoEspec;

@Repository
public class EurekaDaoImpl extends AbstractDao implements EurekaDaoEspec {

  @Override
  public double getSaldoCuenta(String cuenta) {
    String sql = "select dec_cuensaldo "
        + "from cuenta where chr_cuencodigo = ? " ;
    Object[] parms = {cuenta};
    double saldo = jdbcTemplate.queryForObject(
        sql, parms, Double.class);
    return saldo;
  }

}
