<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:template title="Adicionar Roteiro"></mt:template>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="../css/adicionarRoteiro.css">

<script>
	function enviar() {
		window.alert('O ROTEIRO FOI ADICIONADO!');
	}
</script>
</head>

<body>
	<form action="/BusUCASAL/adicionarRoteiro" method="post"
		class="needs-validation" novalidate>
		<h1>Adicionar Roteiro</h1>
		<div class="form-row">
			<div class="col-md-4 mb-3">
				<label for="validationTooltip01">Nome do roteiro</label> <input
					type="text" class="form-control" id="validationTooltip01"
					name="nome_roteiro" placeholder="ex: Roteiro 1" required>

			</div>
			<div class="col-md-4 mb-3">
				<label for="validationTooltip02">Horário do Roteiro</label> <input
					type="time" class="form-control" id="validationTooltip02"
					name="horario_roteiro" placeholder="07:00" required>

			</div>
			
		</div>

		<!-- Fazer quebra de linhas -->
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<label for="validationTooltip03">Descrição</label> <input
					type="text" class="form-control" name="descricao_roteiro"
					id="validationTooltip03"
					placeholder="ex: Saindo da UCSAL, primeira parada no ponto pituaçu..."
					required>

			</div>
		</div>
		<div id="Enviar">
			<p>
				<input type="submit" value="Salvar" onclick="enviar()" />
			</p>

		</div>

	</form>
</body>
</html>