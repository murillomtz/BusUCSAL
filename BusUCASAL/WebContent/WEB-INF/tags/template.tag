<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/BusUCASAL/css/template.css">
    <!--Boostrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


<title>${title}</title>
</head>
<body>

 <header class="container-fluid">
        <p>BUSUCSAL</p>
        <img src="/BusUCASAL/img/busUcsal.png" class="img-responsive" id="img-responsive" alt="logo">
        <div class="bot"><a href="/BusUCASAL/logout"><button type="submit" class="btn btn-default">Sair</button></a></div>
    </header>

     <nav>
        <ul id="respMenu" class="ace-responsive-menu" data-menu-style="vertical">
            
            <li>
                <a href="/BusUCASAL/private/adicionarRoteiro.jsp">
                    <i class="fa fa-cube" aria-hidden="true"></i>
                    <span class="title">Adicionar Roteiro</span>
                </a>
			</li>
			<li>
                <a href="/BusUCASAL/atualizarRoteiro"> 
                    <i class="fa fa-cube" aria-hidden="true"></i>
                    <span class="title">Alterar Roteiro</span>
                </a>
			</li>
			<li>
                <a href="/BusUCASAL/removerRoteiro">

                    <i class="fa fa-cube" aria-hidden="true"></i>
                    <span class="title">Excluir Roteiro</span>
                </a>
			</li>
			<li>
                <a href="/BusUCASAL/private/adicionarAviso.jsp">

                    <i class="fa fa-cube" aria-hidden="true"></i>
                    <span class="title">Adicionar Aviso</span>
                </a>
			</li>
			<li>
				<a href="/BusUCASAL/removerAviso"> 
					<i class="fa fa-cube" aria-hidden="true"></i> 
					<span class="title">Excluir Aviso</span>
			</a></li>
		</ul>
    </nav>
   
</body>
</html>

