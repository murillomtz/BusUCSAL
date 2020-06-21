package br.ucsal.busUcsal.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class PerformanceFilter
 */
@WebFilter("/*")
public class PerformanceFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Armazena o tempo antes de filtrar
		Long tempoInicial = new Date().getTime();	
		
		// Filtra
		chain.doFilter(request, response);
		
		// Armazena o tempo após filtrar
		Long tempoFinal = new Date().getTime();
		
		// Imprime o tempo de filtragem
		System.out.println("Filtro de tempo: " + (tempoFinal - tempoInicial));
	}


}
