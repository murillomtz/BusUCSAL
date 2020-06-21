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
		
		// Pega o cookie do usuário
		Object usuario = httpServletRequest.getSession().getAttribute("USUARIO");
		
		// Verifica se o usuário não está logado no servidor
		if (usuario==null) {
			
			
			// Redireciona o usuário para a página inicial
			httpServletResponse.sendRedirect("/BusUCASAL/index.jsp");
			//TODO Notificação dizendo que o usuário não está logado
		}
		chain.doFilter(request, response);
		// Menssagem para informar 
		String menssagem = "USUARIO NÃO PERMITIDO";
		PrintWriter out = response.getWriter();
		out.print("<script>alert("+menssagem+");</script>");
	}


}
