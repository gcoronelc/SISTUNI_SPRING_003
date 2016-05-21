<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>EUREKA APP</title>
</head>
<body>
<h1>EUREKA APP</h1>
<h2>Inicio de Sesión</h2>
<form method="post" action="logon.htm">
  <p style="color:red;">${error}</p>
  <table>
    <tr>
      <td>Usuario:</td>
      <td><input type="text" name="usuario"></td>
    </tr>
    <tr>
      <td>Clave:</td>
      <td><input type="password" name="clave"></td>
    </tr>
  </table>
  <input type="submit" value="Ingresar">
</form>
</body>
</html>
