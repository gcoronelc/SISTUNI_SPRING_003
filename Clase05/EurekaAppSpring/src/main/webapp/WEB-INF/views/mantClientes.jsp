<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO DE CLIENTES</title>
<script type="text/javascript" 
    src="<c:url value="/resources/jquery/jquery.js"/>"></script>
</head>
<body>
<h2>MANTENIMIENTO DE CLIENTES</h2>
<form id="form1">
<table>
  <tr>
    <td>Paterno</td>
    <td>Materno</td>
    <td>Nombre</td>
    <td rowspan="2" style="vertical-align: bottom;">
      <input id="btnConsultar" type="button" value="Consultar" />
      <input id="btnNuevo" type="button" value="Nuevo" />
      <input type="button" value="Excel" />
      <input type="button" value="PDF" />
    </td>
  </tr>
  <tr>
    <td><input type="text" name="paterno"/></td>
    <td><input type="text" name="materno"/></td>
    <td><input type="text" name="nombre"/></td>
    
  </tr>
</table>
</form>

<div id="CONTENIDO"></div>


<script type="text/javascript">

  $("#btnConsultar").click(function(){
	  var data = $("#form1").serialize();
	  $.post("traerClientes.htm",data,function(pagina){
		  $("#CONTENIDO").html(pagina);
	  });
  });

  $("#btnNuevo").click(function(){
	  $("#CONTENIDO").load("nuevoCliente.htm");
	});
  
  
  function fnClienteEditar( codigo ){
	  var data = "codigo=" + codigo;
	  $.post("editarCliente.htm",data,function(pagina){
		  $("#CONTENIDO").html(pagina);
	  });
  }
  
  function fnClienteEliminar( codigo ){
	    var data = "codigo=" + codigo;
	    $.post("eliminarCliente.htm",data,function(pagina){
	      $("#CONTENIDO").html(pagina);
	    });
	  }
    
</script>
</body>
</html>