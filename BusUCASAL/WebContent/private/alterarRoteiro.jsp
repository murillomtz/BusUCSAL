<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:template title="Alterar Roteiro"></mt:template>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/BusUCASAL/css/adicionarRoteiro.css">

<script>
function enviar(){
	window.alert('O ROTEIRO FOI ALTERADO!');
}
</script>
</head>

<body>
 <form class="needs-validation" novalidate method="post" action ="/BusUCASAL/atualizarRoteiro">
  <h1>Alterar Roteiro</h1>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="exampleFormControlSelect1">Selecione o roteiro:</label>
    <select class="form-control" id="exampleFormControlSelect1" name ="select_roteiro">
        <c:forEach var="roteiro" items="${roteiros}">  
    <option value="${roteiro.idRoteiro}">${roteiro.nomeRoteiro}</option>  
  	  </c:forEach> 
    </select>
     
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationTooltipUsername">Alterar nome do roteiro</label>
      <div class="input-group">
        <input name ="nome_roteiro" type="text" class="form-control" id="validationTooltipUsername" placeholder="ex: Roteiro 1" required>
       
      </div>
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationTooltip02">Horário do Roteiro</label>
      <input name ="horario_roteiro" type="time" class="form-control" id="validationTooltip02" placeholder="07:00" required>
      
    </div>
    
  </div>
  
  <!-- Fazer quebra de linhas -->
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationTooltip03">Descrição</label>
      <input name="descricao_roteiro" type="text" class="form-control" id="validationTooltip03" placeholder="ex: Saindo da UCSAL, primeira parada no ponto pituaçu..." required>
      
    </div>
    </div>
  <div id="Enviar">
	<p>
		<input type="submit" value="Alterar" onclick="enviar()"/>
	</p>
						
</div>
  
</form>
</body>
</html>