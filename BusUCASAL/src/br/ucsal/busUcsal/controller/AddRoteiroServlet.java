package br.ucsal.busUcsal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busUcsal.business.RoteiroBO;
import br.ucsal.busUcsal.exception.DadoInsuficienteException;
import br.ucsal.busUcsal.model.Roteiro;

/**
 * Servlet implementation class AddRoteiroServlet
 */
@WebServlet("/adicionarRoteiro")
public class AddRoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Atribui os parametros
		String nome = request.getParameter("nome_roteiro");
		String horario = request.getParameter("horario_roteiro");
		String desc = request.getParameter("descricao_roteiro");
		
		// Cria o objeto do tipo Aviso
		Roteiro roteiro = new Roteiro(horario, desc, nome);

		try {
			// Encaminha o roteiro para a regra de negócio
			RoteiroBO.addRoteiro(roteiro);
			
			// Redireciona para o portal
			response.sendRedirect("portalADM");
		} catch (DadoInsuficienteException menssagem) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert("+menssagem+");</script>");
		}
	}

}
