<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Login ADM</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>

<body>
	<header class="container-fluid">
		<p>BUSUCSAL ADM</p>
		<img src="img/busUcsal.png" class="img-responsive" alt="logo">
	</header>

	<div class="container">
		<a class="links" id="paracadastro"></a> <a class="links"
			id="paralogin"></a>

		<div class="content">
			<!--FORMULÁRIO DE LOGIN-->
			<div id="login">
				<img class="photo" src="img/perfil.png" alt="perfil">
				<form action="login" method="post">
					<p>
						<label for="matricula_login">Matrícula do ADM</label> <input
							id="matricula_login" name="matricula_login" required="required"
							type="number" placeholder="ex. 000123321" />
					</p>

					<p>
						<label for="senha">Senha</label> <input id="senha" name="senha"
							required="required" type="password" placeholder="ex. senha" />
					</p>
					<br>
					<div>
						<c:out value="${erro}"></c:out>
					</div>
					<p>
						<input type="submit" value="Logar" />
					</p>



				</form>
			</div>

			<p>
				<a href="index.jsp"><input type="submit" value="Voltar" /></a>
			</p>
		</div>
	</div>
</body>
</html>