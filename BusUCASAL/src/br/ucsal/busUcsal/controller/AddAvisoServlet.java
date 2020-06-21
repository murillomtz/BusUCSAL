package br.ucsal.busUcsal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busUcsal.business.AvisoBO;
import br.ucsal.busUcsal.exception.DadoInsuficienteException;
import br.ucsal.busUcsal.model.Aviso;

/**
 * Servlet implementation class AddAvisoServlet
 */
@WebServlet("/adicionarAviso")
public class AddAvisoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Atribui os parametros 
		String nome = request.getParameter("nome_aviso");
		String descricao = request.getParameter("descricao_aviso");
		
		// Cria o objeto do tipo Aviso
		Aviso aviso = new Aviso(nome, descricao);
		
		try {
			// Encaminha o aviso para a regra de negócio
			AvisoBO.addAviso(aviso);
			
			// Redireciona para o portal
			response.sendRedirect("portalADM");
		} catch (DadoInsuficienteException menssagem) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert("+menssagem+");</script>");
		}
		
	}

}
