<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Cardapio</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div id="list" class="row">
		<div class="table-responsive col-md-12">
			<table class="table table-striped" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Descrição</th>
						<th>Valor</th>
						<th class="actions">Ações</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="cardapio" items="${cardapios}">
						<tr>
							<td>${cardapio.id }</td>
							<td>${cardapio.nome }</td>
							<td>${cardapio.descr }</td>
							<td>${cardapio.valor }</td>
                          <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterCardapio.do?acao=Visualizar&id=${cardapio.id }">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="ManterCliente.do?acao=Editar&id=${cardapio.id }">Editar</a>
                                                <button id="btn${cardapio.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${cardapio.id }">Excluir</button>
                                            </td>
						</tr>

					</c:forEach>
</body>
</html>