<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Tutorial con Ibatis</title>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
		<style>
			.boton {
				margin:20px;
				color:white;
		        background:gray;
		        border:0px;
		        width:80px;
		        height:19px;
		        padding:10px 15px;
		        cursor:pointer;
		        text-decoration:none;   
			}
			
			.tabla{
				margin:20px;
			}
		</style>
		
	</head>
	<body>
		<h3>Bienvenidos al tutorial Spring integrado con Ibatis!!!</h3>
		
		<a href="crear.htm" class="boton"> Crear</a>
		
		<table class="tabla" border="1" cellspacing="0" cellpadding="10">
			<thead>
				<tr>
					<td>Nombre</td>
					<td>Código</td>
					<td>Editar</td>
					<td>Eliminar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ele" items="${lista}">
					<tr>
						<td>${ele.nombre_producto}</td>
						<td>${ele.codigo_producto}</td>
						<td><a href="editar.htm?codigo=${ele.codigo_producto}" class="boton">Editar</a></td>
						<td><a href="eliminar.htm?codigo=${ele.codigo_producto}" class="boton">Eliminar</a></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</body>
</html>