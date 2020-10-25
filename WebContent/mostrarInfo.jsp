<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Información de los empleados</title>
</head>
<body>

	<h1>Empleados</h1>

	<table border="1" width="100%">
		<tr>
			<td><b>Nombre</b></td>
			<td><b>DNI</b></td>
			<td><b>Sexo</b></td>
			<td><b>Categoría</b></td>
			<td><b>Años</b></td>

		</tr>

		<c:forEach var="empleado" items="${lista}">
			<tr>
				<td><c:out value="${empleado.nombre}" /></td>
				<td><c:out value="${empleado.dni}" /></td>
				<td><c:out value="${empleado.sexo}" /></td>
				<td><c:out value="${empleado.categoria}" /></td>
				<td><c:out value="${empleado.anyos}" /></td>

			</tr>
		</c:forEach>
	</table>
	
	<br>

	<form method="post" action="PruebaServlet?action=index">
		<input class="boton" type="submit" value="Volver">
	</form>
</body>
</html>