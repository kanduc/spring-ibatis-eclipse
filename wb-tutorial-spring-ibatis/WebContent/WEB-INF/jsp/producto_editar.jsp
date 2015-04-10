<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Tutorial con Ibatis</title>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
	</head>
	<body>
		<h3>Editar producto</h3>
		
		<form action="actualizar.htm" commandName="producto" method="post">
			<label for="prod_nombre">Nombre de producto: </label>
			<input type="text" id="nombre_producto" name="nombre_producto" value="${producto.nombre_producto}"/>
			<input type="hidden" id="codigo_producto" name="codigo_producto" value="${producto.codigo_producto}"/>
			<button type="submit"> Editar</button>
		</form>
		
	</body>
</html>