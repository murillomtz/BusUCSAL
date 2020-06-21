<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:template title="Excluir Roteiro"></mt:template>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/BusUCASAL/css/excluirRoteiro.css">

<script>
function excluir(){
	window.confirm('O ROTEIRO SELECIONADO SERÁ EXCLUIDO DEFINITIVAMENTE!');
}
</script>
</head>

<body>
<div class="form-group">
 <h1>Excluir Roteiro</h1>
 <form action="/BusUCASAL/removerRoteiro" method="post" >
    <label for="exampleFormControlSelect1">Selecione o roteiro que quer excluir:</label>
    <select class="form-control" id="exampleFormControlSelect1" name="select_roteiro">
    
      <c:forEach var="roteiro" items="${roteiros}">  
    <option value="${roteiro.idRoteiro}">${roteiro.nomeRoteiro}</option>  
  			</c:forEach> 
  	  
    </select>
<div id="excluir">
	<p>
		<input type="submit" value="Excluir" onclick="excluir()"/>
	</p>
						
</div>
</form>
</div>
</body>

</html>