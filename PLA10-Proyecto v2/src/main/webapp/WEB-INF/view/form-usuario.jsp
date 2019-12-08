<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
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
				<h3>Añadir usuario</h3>
			</div>
		</div>

		<form:form action="saveuser" modelAttribute="user" method="post">
			<form:hidden path="username" />
			<div class="form-group">
				<label for="username">Usuario:</label>
				<form:input path="username" class="form-control" />
				<label for="password">Contraseña:</label>
				<form:input type="password" path="password" class="form-control" />
				<label for="enabled">Activado:</label>
				<select name="enabled" class="form-control">
				    <option value="0">NO</option>
				    <option value="1" selected>SÍ</option> <!-- Opción por defecto -->
			  	</select>

			</div>

			<input type="submit" value="Guardar" class="btn btn-success" />
			<a href="${pageContext.request.contextPath}/admin/index-usuarios"
				class="btn btn-outline-primary float-right"> Volver a lista de
				usuarios</a>
		</form:form>
	</div>
	
	<script>
		submitForms = function() {
		  document.getElementById("saveauser").submit();
		  document.getElementById("saveauthority").submit();
		}
	</script>
</body>
</html>