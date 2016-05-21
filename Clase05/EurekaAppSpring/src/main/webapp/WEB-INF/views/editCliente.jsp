<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>${ACCION} CLIENTE</h2>
  <form id="form2">
    <input type="hidden" name="accion" value="${ACCION}"/>
    <input type="hidden" name="codigo" value="${clienteBean.codigo}"/>
    <table>
      <tr>
        <td>Código</td>
        <td>${clienteBean.codigo}</td>
      </tr>
      <tr>
        <td>Paterno</td>
        <td>
          <input type="text" name="paterno" value="${clienteBean.paterno}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>Materno</td>
        <td>
          <input type="text" name="materno" value="${clienteBean.materno}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>Nombre</td>
        <td>
          <input type="text"  name="nombre" value="${clienteBean.nombre}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>DNI</td>
        <td>
          <input type="text"  name="dni" value="${clienteBean.dni}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>Ciudad</td>
        <td>
          <input type="text"  name="ciudad" value="${clienteBean.ciudad}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>Dirección</td>
        <td>
          <input type="text"  name="direccion" value="${clienteBean.direccion}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>Telefono</td>
        <td>
          <input type="text"  name="telefono" value="${clienteBean.telefono}" ${editar} />
        </td>
      </tr>
      <tr>
        <td>Email</td>
        <td>
          <input type="text"  name="email" value="${clienteBean.email}" ${editar} />
        </td>
      </tr>
    </table>
  
  </form>
  <input id="btnProcesar" type="button" value="Procesar" />

  <script type="text/javascript">
     $("#btnProcesar").click(function(){
    	 var data = $("#form2").serialize();
    	 alert(data);
    	 $.post("procesarCliente.htm",data,function(texto){
    		 if(texto == "1"){
    			 alert("Proceso ok.");
    		 } else {
    			 alert(texto);
    		 }
    	 });
     });
  
  </script>
</body>
</html>