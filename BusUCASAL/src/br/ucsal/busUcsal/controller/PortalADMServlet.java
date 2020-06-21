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
 * Servlet implementation class PortalADMServlet
 */
@WebServlet("/portalADM")
public class PortalADMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Atribui as listas de roteiros e avisos nos request com key respectivas keys
		request.setAttribute("roteiros", RoteiroBO.listarTodosRoteiros());
		request.setAttribute("avisos", AvisoBO.listarTodosAvisos());

		// Encaminha os dados para o portalADM.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("./private/portalADM.jsp");
		dispatcher.forward(request, response);
	}
	
}
