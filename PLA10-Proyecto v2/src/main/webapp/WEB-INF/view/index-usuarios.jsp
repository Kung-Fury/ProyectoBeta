<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<h1>Gestión Usuarios</h1>
			</div>	

		</div>
		
		<sec:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath}/admin/adduser"
				class="btn btn-primary mb-1">Añadir usuario</a>
		</sec:authorize>
		
		<a href="${pageContext.request.contextPath}/index"
				class="btn btn-outline-primary float-right"> Volver a lista de
				categorías</a>

		<table class="table table-striped" style="display: inline-block; border: 1px solid; float: left; ">
			<tr>
				<th>Nombre usuario</th>
				<th>Activado</th>
				<sec:authorize access="hasRole('ADMIN')">
					<th>Acciones</th>
				</sec:authorize>
			</tr>

			<c:forEach var="user" items="${user}">
				<c:url var="linkEditar" value="/admin/updateuser">
					<c:param name="username" value="${user.username }" />
				</c:url>
				<c:url var="linkBorrar" value="/admin/deleteuser">
					<c:param name="username" value="${user.username }" />
				</c:url>
				<tr>
					<td>${user.username }</td>
					<td>${user.enabled }</td>
					<sec:authorize access="hasRole('ADMIN')">
						<td><sec:authorize access="hasRole('ADMIN')">
								<a href="${linkEditar }" class="btn btn-outline-success btn-sm">Editar</a>
							</sec:authorize>
							 <sec:authorize access="hasRole('ADMIN')">
								<a href="${linkBorrar }"
									onclick="if(!confirm('¿Está seguro?')) return false"
									class="btn btn-outline-danger btn-sm">Borrar</a>
							</sec:authorize></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
		<table class="table table-striped" style="display: inline-block; border: 1px solid; ">
			<tr>
				<th>Nombre usuario</th>
				<th>Autoridad</th>
				<sec:authorize access="hasRole('ADMIN')">
					<th>Acciones</th>
				</sec:authorize>
			</tr>
			<c:forEach var="authority" items="${authority}">
<%-- 					<c:url var="linkEditar" value="/admin/updateuser"> --%>
<%-- 						<c:param name="username" value="${authority.username }" /> --%>
<%-- 					</c:url> --%>
<%-- 					<c:url var="linkBorrar" value="/admin/deleteuser"> --%>
<%-- 						<c:param name="username" value="${authority.username }" /> --%>
<%-- 					</c:url> --%>
					<tr>
						<td>${authority.user.username }</td>
						<td>${authority.authority }</td>
						<sec:authorize access="hasRole('ADMIN')">
							<td><sec:authorize access="hasRole('ADMIN')">
									<a href="${linkEditar }" class="btn btn-outline-success btn-sm">Editar</a>
								</sec:authorize>
								 <sec:authorize access="hasRole('ADMIN')">
									<a href="${linkBorrar }"
										onclick="if(!confirm('¿Está seguro?')) return false"
										class="btn btn-outline-danger btn-sm">Borrar</a>
								</sec:authorize></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</table>
	</div>