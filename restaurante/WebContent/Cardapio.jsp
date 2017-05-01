<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Insert title here</title>
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
					</tr>
				</thead>
				<tbody>
						<tr>
							<td>${cardapio.id }</td>
							<td>${cardapio.nome }</td>
							<td>${cardapio.descr }</td>
							<td>${cardapio.valor }</td>
							</td>
						</tr>


</body>
</html>