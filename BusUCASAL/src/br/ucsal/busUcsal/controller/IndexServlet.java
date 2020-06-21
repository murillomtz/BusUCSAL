package br.ucsal.busUcsal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busUcsal.business.AvisoBO;
import br.ucsal.busUcsal.business.RoteiroBO;

/**
 * Servlet implementation class ListarAvisosServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Atribui as listas de roteiros e avisos nos request com key respectivas keys
		request.setAttribute("roteiros", RoteiroBO.listarTodosRoteiros());
		request.setAttribute("avisos", AvisoBO.listarTodosAvisos());
		
		// Encaminha os dados para o dashboard.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dashboard.jsp");
		dispatcher.forward(request, response);
	}

}
