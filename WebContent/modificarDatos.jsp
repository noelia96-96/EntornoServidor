<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<form method="get">


		<label for="dni">DNI:</label> 
		<input type="text" id="dni2" name="dni2" value="${dni2}">
		
		
		<br>
		
		<label for="nombre">Nombre:</label> 
		<input type="text" id="nombre2" name="nombre2" value="${nombre2}">
		
		
		<br>
		
		<label for="sexo">Sexo:</label> 
		<input type="text" id="sexo2" name="sexo2" value="${sexo2}">
		
		
		<br>
		
		<label for="categoria">Categoria:</label> 
		<input type="text" id="categoria2" name="categoria2" value="${categoria2}">
		
		
		<br>
		
		<label for="anyos">Años:</label> 
		<input type="text" id="anyos2" name="anyos2" value="${anyos2}">
		
		<br>
		<input class="boton" type="submit"value="Buscar">
		
	</form>
	
	<br>
	

	<form method="post" action="PruebaServlet?action=index">
		<input class="boton" type="submit" value="Volver">
	</form>

</body>
</html>