<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Cadastro de Produtos</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

	<form action="/produto/incluir" method="post">
		<h3>Cadastro de Produtos</h3>

			<c:if test="${not empty produto}">
				<input type="hidden" id="input-id" value="${produto.id}" class="form-control">
			</c:if>

			<label>EAN:</label>
			<input type="text" name="ean" id="input-ean" <c:if test="${not empty produto}">value="${produto.ean}"</c:if> class="form-control">

			<label>Nome:</label>
			<input type="text" name="nome" id="input-nome" <c:if test="${not empty produto}">value="${produto.nome}"</c:if> class="form-control">

			<label>Preço:</label>
			<input type="text" name="preco" id="input-preco" <c:if test="${not empty produto}">value="${produto.preco}"</c:if> class="form-control">

			<label>ImageLink:</label>
			<input type="text" name="imglink" id="input-imglink" <c:if test="${not empty produto}">value="${produto.imglink}"</c:if> class="form-control">

		<button type="submit" id="btn-cadastrar">Cadastrar</button>
	</form>
</div>
</body>
</html>