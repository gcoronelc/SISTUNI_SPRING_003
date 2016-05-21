<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" 
    src="<c:url value="/resources/jquery/jquery.js"/>"></script>
<title>EUREKA APP</title>
</head>
<body>
  <h1>EUREKA APP</h1>
  <table >
    <tr>
      <td>Usuario: ${usuario.usuario}</td>
      <td><a href="#">Salir</a></td>
    </tr>
    <tr>
      <td>
        <a href="mantClientes.htm" target="WORK">Clientes</a> &nbsp;&nbsp;
      </td>
      <td>
        <a href="deposito.htm" target="WORK">Depósito</a> &nbsp;&nbsp;
      </td>
    </tr>
  </table>
  <br/>
  <iframe name="WORK" width="900" height="550" frameborder="1"></iframe>
</body>
</html>