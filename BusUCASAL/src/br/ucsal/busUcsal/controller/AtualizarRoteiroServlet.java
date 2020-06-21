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
 * Servlet implementation class AtualizarRoteiroServlet
 */
@WebServlet("/atualizarRoteiro")
public class AtualizarRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Atribui a lista de avisos no request com key "avisos"
		request.setAttribute("roteiros", RoteiroBO.listarTodosRoteiros());

		// Encaminha os dados para a página de remover avisos
		RequestDispatcher dispatcher = request.getRequestDispatcher("./private/alterarRoteiro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Atribui os parametros
		String idString = request.getParameter("select_roteiro");
		String nome = request.getParameter("nome_roteiro");
		String horario = request.getParameter("descricao_roteiro");
		String descricao = request.getParameter("descricao_roteiro");

		// Converte de String para Integer
		Integer id = Integer.parseInt(idString);

		// Encaminha os dados da atualização para a regra de negócio
		RoteiroBO.atualizarRoteiro(id, nome, horario, descricao);
		
		// Redireciona para o portal
		response.sendRedirect("portalADM");
	}

}
