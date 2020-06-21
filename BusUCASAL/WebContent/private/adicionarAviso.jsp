<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:template title="Adicionar Aviso"></mt:template>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/adicionarAviso.css">

<script>
function enviar(){
	window.alert('O AVISO FOI ADICIONADO!');
}
</script>
</head>

<body>
 <form class="needs-validation" action="/BusUCASAL/adicionarAviso" method="post" novalidate>
  <h1>Adicionar Aviso</h1>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationTooltip01">Nome do Aviso</label>
      <input type="text" class="form-control" id="validationTooltip01" name="nome_aviso"placeholder="ex: Manutenção" required>
     
    </div>
   </div>
  <!-- Fazer quebra de linhas -->
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationTooltip03">Descrição</label>
      <input type="text" class="form-control" id="validationTooltip03" name="descricao_aviso" placeholder="ex: Amanhã (Quinta-Feira), o ônibus estará em manutenção." required>
      
    </div>
    </div>
  <div id="Enviar">
	<p>
		<input type="submit" value="Salvar" onclick="enviar()"/>
	</p>
						
</div>
  
</form>
</body>
</html>