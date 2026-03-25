<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>Listagem de Produtos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Produtos</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/produto" method="get">
			<button type="submit" id="link-novo">Novo</button>
		</form>

		<c:if test="${empty produtos}">
			<h5>Não existem produtos cadastrados!!!</h5>
		</c:if>
	
		<c:if test="${not empty produtos}">
			<h5>Quantidade de produtos cadastrados: ${produtos.size()}</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
				  <th>Foto</th>
			      <th>Ean</th>
			      <th>Nome</th>
			      <th>Preço</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="p" items="${produtos}">
				    <tr>
				      <td>${p.id}</td>
					  <td><img src="${p.imglink}" width="96" height="96"></td>
				      <td>${p.ean}</td>
				      <td>${p.nome}</td>
				      <td>${p.preco}</td>
					  <td><a href="/produto/${p.id}/editar" class="link-editar">Editar</a></td>
				      <td><a href="/produto/${p.id}/excluir" class="link-excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>