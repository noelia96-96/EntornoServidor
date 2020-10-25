<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar salario</title>
</head>
<body>

	<form method="get">

		<label for="dni">DNI:</label> 
		<input type="text" id="dni" name="dni" value="${dni}">
		<input class="boton" type="submit"value="Buscar">
		
	</form>
	
	<br>

	<form method="post" action="PruebaServlet?action=index">
		<input class="boton" type="submit" value="Volver">
	</form>
		
	

</body>
</html>