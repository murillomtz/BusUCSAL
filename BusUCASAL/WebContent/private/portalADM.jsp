<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:template title="Portal Administrador"></mt:template>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/BusUCASAL/css/index.css">


<!--Boostrap-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!--Calendário-->


<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

<title>BusUcsal</title>
</head>
<body>

	<div class="overflow">
		<div class="overflow-rotas">
			<p>HORÁRIOS E ROTAS</p>
			<br>
			<c:forEach var="roteiro" items="${roteiros}">
				<tr>
					<td><STRONG><img src="img/onibus.png" alt ="onibus" class="img-responsive"> ${roteiro.hora}</STRONG></td>
					<td><b>${roteiro.nomeRoteiro}</b></td>
					<td><ins>${roteiro.descricao}</ins><br><br><br><br></td>
				</tr>
			</c:forEach>
		</div>
	</div>

	<!-- Calendar -->
	<!-- show date events with a modal window -->

	<!-- Aviso  -->
	<div class="overflow-aviso">
		<p><img src="img/aviso.png" alt ="onibus" class="img-responsive">Avisos!</p>
		<c:forEach var="aviso" items="${avisos}">
			<tr>
				<td><STRONG>${aviso.nome}</STRONG><br></td>
				<td><ins>${aviso.descricao}</ins><br><br></td>
			</tr>
		</c:forEach>
	</div>
</body>
</html>