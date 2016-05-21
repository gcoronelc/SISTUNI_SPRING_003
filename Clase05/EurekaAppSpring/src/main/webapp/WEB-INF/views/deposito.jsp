<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" 
    src="<c:url value="/resources/jquery/jquery.js"/>"></script>
<title>DEPOSITO</title>
</head>
<body>
  <h1>DEPOSITO</h1>
  <form id="form1">
    <table>
      <tr>
        <td>Cuenta</td>
        <td><input type="text" name="cuenta" /></td>
      </tr>
      <tr>
        <td>Importe</td>
        <td><input type="text" name="importe" /></td>
      </tr>
    </table>
  </form>
  <input type="button" id="btnProcesar" value="Procesar" />
  <script type="text/javascript">
  
    $("#btnProcesar").click(function(){
    	var data = $("#form1").serialize();
        $.post("deposito.htm",data,function(objJson){
          alert(objJson);
          //alert(objJson.code + " - " + objJson.mensaje)
        });
    });
    
  </script>
</body>
</html>