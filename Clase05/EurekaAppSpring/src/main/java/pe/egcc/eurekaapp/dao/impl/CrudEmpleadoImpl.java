package pe.egcc.eurekaapp.dao.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.egcc.eurekaapp.dao.espec.CrudEmpleadoEspec;
import pe.egcc.eurekaapp.domain.EmpleadoBean;

/**
 * 
 * @author Eric Gustavo Coronel Castillo
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 * @date   27/12/2015
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository
public class CrudEmpleadoImpl extends AbstractDao implements CrudEmpleadoEspec {

  @Override
  public EmpleadoBean traerPorCodigo(String codigo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<EmpleadoBean> traerPorNombre(EmpleadoBean bean) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void insertar(EmpleadoBean bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void actualizar(EmpleadoBean bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void eliminar(String codigo) {
    // TODO Auto-generated method stub

  }

  /**
   * Si encuentra retorna el objeto EmpleadoBean.
   * Si no lo encuentra retorna null.
   * 
   * @usuario Usuario de inicio de sesión
   * @clave   Contraseña del usuario
   */
  @Override
  public EmpleadoBean validar(String usuario, String clave) {
    EmpleadoBean bean = null;
    try {
      String sql = "select "
          + "chr_emplcodigo     CODIGO, "
          + "vch_emplpaterno    paterno, "
          + "vch_emplmaterno    materno, "
          + "vch_emplnombre     nombre, "
          + "vch_emplciudad     ciudad, "
          + "vch_empldireccion  direccion,"
          + "vch_emplusuario    usuario "
          + "from empleado "
          + "where vch_emplusuario = ? "
          + "and vch_emplclave = ?";
      Object[] args = {usuario, clave};
      bean = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper(EmpleadoBean.class));
    } catch (EmptyResultDataAccessException e) {
      bean = null;
    }
    return bean;
  }

}


