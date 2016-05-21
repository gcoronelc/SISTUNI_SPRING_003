package pe.egcc.eurekaapp.dao.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.eurekaapp.dao.espec.CrudClienteEspec;
import pe.egcc.eurekaapp.domain.ClienteBean;

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
public class CrudClienteImpl extends AbstractDao implements CrudClienteEspec{

  /**
   * Permite consultar los datos de un empleado 
   * segun su codigo.
   * 
   * @param codigo Codigo del cliente a buscar. 
   */
  @Override
  public ClienteBean traerPorCodigo(String codigo) {
    ClienteBean bean = null;
    String sql = "select "
        + "chr_cliecodigo     codigo, "
        + "vch_cliepaterno    paterno, "
        + "vch_cliematerno    materno, "
        + "vch_clienombre     nombre, "
        + "chr_cliedni        dni, "
        + "vch_clieciudad     ciudad, "
        + "vch_cliedireccion  direccion, "
        + "vch_clietelefono   telefono, "
        + "vch_clieemail      email "
        + "from cliente "
        + "where chr_cliecodigo = ? ";
    Object[] args = {codigo};
    try{
      bean = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper(ClienteBean.class));
    } catch(EmptyResultDataAccessException e){
      bean = null;
    }
    return bean;
  }

  
  @Override
  public List<ClienteBean> traerPorNombre(ClienteBean bean) {
    List<ClienteBean> lista = null;
    String sql = "select "
        + "chr_cliecodigo     codigo, "
        + "vch_cliepaterno    paterno, "
        + "vch_cliematerno    materno, "
        + "vch_clienombre     nombre, "
        + "chr_cliedni        dni, "
        + "vch_clieciudad     ciudad, "
        + "vch_cliedireccion  direccion, "
        + "vch_clietelefono   telefono, "
        + "vch_clieemail      email "
        + "from cliente "
        + "where vch_cliepaterno like ? "
        + "and vch_cliematerno like ? "
        + "and vch_clienombre like ?";
    Object[] args = {bean.getPaterno(), bean.getMaterno(), bean.getNombre()};
    lista = jdbcTemplate.query(sql, args, new BeanPropertyRowMapper(ClienteBean.class));
    return lista;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class)
  @Override
  public void insertar(ClienteBean bean) {
    // Leer contador
    String sql = "select int_contitem, int_contlongitud "
        + "from contador "
        + "where vch_conttabla='Cliente' "
        + "for update ";
    Map<String,Object> datos;
    datos = jdbcTemplate.queryForMap(sql);
    int cont = Integer.parseInt(datos.get("int_contitem").toString());
    int longitud = Integer.parseInt(datos.get("int_contlongitud").toString());
    // Para un retardo
    /*
    try {
      Thread.currentThread().sleep(1000);
    } catch (Exception e) {
    }
    */
    // Crear el codigo
    String patron = "";
    for(int i = 1; i <= longitud; i++){
      patron += "0";
    }
    DecimalFormat df = new DecimalFormat(patron);
    cont++;
    String codigo = df.format(cont);
    // Actualizar el contador
    sql = "update contador set int_contitem=? "
        + "where vch_conttabla='Cliente'";
    Object[] args = {cont};
    jdbcTemplate.update(sql, args);
    // Insertar cliente
    sql = "insert into cliente(chr_cliecodigo,vch_cliepaterno,"
        + "vch_cliematerno,vch_clienombre,chr_cliedni,"
        + "vch_clieciudad,vch_cliedireccion,vch_clietelefono,"
        + "vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
    args = new Object[]{codigo,bean.getPaterno(),bean.getMaterno(),
        bean.getNombre(),bean.getDni(),bean.getCiudad(),
        bean.getDireccion(),bean.getTelefono(),bean.getEmail()};
    jdbcTemplate.update(sql, args);
    bean.setCodigo(codigo);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class)
  @Override
  public void actualizar(ClienteBean bean) {
    String sql = "update cliente set vch_cliepaterno=?,"
        + "vch_cliematerno=?, vch_clienombre=?, chr_cliedni=?,"
        + "vch_clieciudad=?, vch_cliedireccion=?, vch_clietelefono=?,"
        + "vch_clieemail=? where chr_cliecodigo=?";
    Object[] args = {bean.getPaterno(),bean.getMaterno(),bean.getNombre(),
        bean.getDni(),bean.getCiudad(),bean.getDireccion(),
        bean.getTelefono(),bean.getEmail(),bean.getCodigo()};
    int filas = jdbcTemplate.update(sql, args);
    if(filas == 0){
      throw new RuntimeException("No existe el cliente.");
    }
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class)
  @Override
  public void eliminar(String codigo) {
    String sql = "delete from cliente where chr_cliecodigo=?";
    Object[] args = {codigo};
    int filas = jdbcTemplate.update(sql, args);
    if(filas == 0){
      throw new RuntimeException("No existe el cliente.");
    }
  }


  @Override
  public boolean tieneCuentas(String codigo) {
    String sql = "select count(1) from cuenta where chr_cliecodigo=?";
    Object[] args = {codigo};
    int cant = jdbcTemplate.queryForObject(sql, args, Integer.class);
    return (cant > 0);
  }

}


