package br.ucsal.busUcsal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busUcsal.business.RoteiroBO;

/**
 * Servlet implementation class RemoverRoteiroServler
 */
@WebServlet("/removerRoteiro")
public class RemoverRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Atribui a lista de avisos no request com key "avisos"
		request.setAttribute("roteiros", RoteiroBO.listarTodosRoteiros());

		// Encaminha os dados para a página de remover avisos
		RequestDispatcher dispatcher = request.getRequestDispatcher("./private/excluirRoteiro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Artibui o parametro
		String idString = request.getParameter("select_roteiro");
		
		// Converte String para Integer
		Integer id = Integer.parseInt(idString);
		
		// Encaminha o id para as regras de negócio
		RoteiroBO.removerRoteiro(id);
		
		// Redireciona para o portal
		response.sendRedirect("portalADM");
		
	}

}
