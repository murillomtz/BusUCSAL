<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:template title="Excluir Aviso"></mt:template>


<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/BusUCASAL/css/excluirRoteiro.css">

<script>
	function excluir() {
		window.confirm('O AVISO SELECIONADO SERÁ EXCLUIDO DEFINITIVAMENTE!');
	}
</script>
</head>

<body>
	<div class="form-group">
		<h1>Excluir Aviso</h1>
		<form action="/BusUCASAL/removerAviso" method="post" >
		<label for="exampleFormControlSelect1">Selecione o aviso que
			quer excluir:</label> <select class="form-control"
			id="exampleFormControlSelect1" name="select_aviso">

			<c:forEach var="aviso" items="${avisos}">  
    <option value="${aviso.id}">${aviso.nome}</option>  
  			</c:forEach> 

		</select>
		<div id="excluir">
			<p>
				<input type="submit" value="Excluir" onclick="excluir()"  />
			</p>
		</div>
		</form>
	</div>
</body>

</html>