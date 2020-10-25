<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Empleados/Nóminas</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<table cellspacing="2" cellpadding="3" border="0" width="100%"
		align="center" bgcolor="#cococo">
		<tr>
			<td width="86%" align="center">
				<P>
					&nbsp; <FONT color="#000000" size="5"><STRONG>Portal
							del empleado</STRONG></FONT>
				</P>
			</td>

		</tr>
	</table>

	<br>

	<form align="center" action="PruebaServlet?action=mostrarInfo" method="post">
		<input class="boton" type="submit" value="Mostrar datos">
	</form>
	<br>
	<form align="center" action="PruebaServlet?action=mostrarSalario"
		method="post">
		<input class="boton" type="submit" value="Consultar salario">
	</form>
	<br>
	<form align="center" action="PruebaServlet?action=modificarDatos"
		method="post">
		<input class="boton" type="submit" value="Modificar datos">
	</form>



</body>
</body>
</html>
