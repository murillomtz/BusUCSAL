package br.ucsal.busUcsal.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AcessoFilter
 */
@WebFilter("/private/*")
public class AcessoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		// Atributo request
		HttpServletRequest httpServletRequest= (HttpServletRequest) request;
		// Atributo repsponse
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		// Teste para saber se acessou o filter
		System.out.println("FILTRO DE ACESSO: "+ httpServletRequest.getRequestURL());
		
		// Pega o cookie do usu�rio
		Object usuario = httpServletRequest.getSession().getAttribute("USUARIO");
		
		// Verifica se o usu�rio n�o est� logado no servidor
		if (usuario==null) {
			
			
			// Redireciona o usu�rio para a p�gina inicial
			httpServletResponse.sendRedirect("/BusUCASAL/index.jsp");
			//TODO Notifica��o dizendo que o usu�rio n�o est� logado
		}
		chain.doFilter(request, response);
		// Menssagem para informar 
		String menssagem = "USUARIO N�O PERMITIDO";
		PrintWriter out = response.getWriter();
		out.print("<script>alert("+menssagem+");</script>");
	}


}
