<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
<style>
	.error {
	color: red;
	font-size: 13px;
	}
</style>

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="float-right">
				Usuario:
				<sec:authentication property="principal.username" />
				<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<button type="submit" class="btn btn-warning">Salir</button>
				</form:form>
			</div>
			<div>
				<h1>Catálogo</h1>
				<h3>Añadir vehículo</h3>
			</div>
		</div>

		<form:form action="savevehiculos" modelAttribute="vehiculos" method="post">
			<form:hidden path="idvehiculo" />
			<div class="form-group">
				<label for="modelo">Modelo:</label>
				<form:input path="vehiculoModelo" class="form-control" />
			</div>


<!-- 			<div class="form-group"> -->
<!-- 				<label for="modelo">Color:</label> -->
<%-- 				<form:input path="vehiculoColor" class="form-control" /> --%>
<!-- 			</div> -->
			<div class="form-group">
				<label for="nombre">Color:</label>
				<form:select class="form-control" path="vehiculoColor">
					<option value="0">--Selecciona--</option>
					<option value="Negro">Negro</option>
					<option value="Azul">Azul</option>
					<option value="Rojo">Rojo</option>
				</form:select>
			</div>
			<form:errors path="vehiculoPrecio" cssClass="error" />
			<div class="form-group">
				<label for="modelo">Precio:</label>
				<form:input path="vehiculoPrecio" class="form-control" />
			</div>
			<div class="form-group">
				<label for="nombre">Categoría:</label>
				<form:select class="form-control" path="categoria.idcategoria">
					<option value="0">--Selecciona--</option>
					<form:options items="${categorias}" itemValue="idcategoria"
						itemLabel="categoriaNombre" />
				</form:select>
			</div>
			<input type="submit" value="Guardar" class="btn btn-success" />
			<a href="${pageContext.request.contextPath}/index"
				class="btn btn-outline-primary float-right"> Volver a lista de
				categorías</a>
		</form:form>
	</div>
</body>
</html>