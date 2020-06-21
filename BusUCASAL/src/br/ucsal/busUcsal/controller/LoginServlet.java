package br.ucsal.busUcsal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busUcsal.business.LoginBO;
import br.ucsal.busUcsal.exception.DadoInsuficienteException;
import br.ucsal.busUcsal.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginBO service = new LoginBO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Atribui os parametros
		String matriculaString = request.getParameter("matricula_login");
		String senha = request.getParameter("senha");

		// Converte String para Integer
		Integer matricula = Integer.parseInt(matriculaString);

		// Encaminha os dados para a regra de negócio
		Usuario usuario=null;
		try {
			usuario = service.checkLogin(matricula, senha);
		} catch (DadoInsuficienteException menssagem) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert("+menssagem+");</script>");
		}

		// Se usuario for encontrado
		if (usuario != null) {

			// Cria o cookie
			request.getSession().setAttribute("USUARIO", usuario);

			// Cria dispatcher e encaminha os atributos
			RequestDispatcher dispatcher = request.getRequestDispatcher("./private/direcionamento.jsp");
			dispatcher.forward(request, response);
		} else {
			
			// Cria uma key "erro" e sua value
			request.setAttribute("erro", "Login ou Senha Invalidos");

			// Cria dispatcher e encaminha os atributos
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
