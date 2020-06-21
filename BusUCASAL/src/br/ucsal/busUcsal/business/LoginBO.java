package br.ucsal.busUcsal.business;

import br.ucsal.busUcsal.exception.DadoInsuficienteException;
import br.ucsal.busUcsal.model.Usuario;
import br.ucsal.busUcsal.persistence.UsuarioDAO;

public class LoginBO {

	// Retorna um usuário
	public Usuario checkLogin(Integer matricula, String senha) throws DadoInsuficienteException {
		validar(matricula, senha);
		return UsuarioDAO.autenticate(matricula, senha);
	}

	private void validar(Integer matricula, String senha) throws DadoInsuficienteException {
		if (matricula == null) {
			throw new DadoInsuficienteException("A matricula deve ser informada !");
		}
		if (senha == null || senha.trim().isEmpty()) {
			throw new DadoInsuficienteException("A senha deve ser informada !");
		}
		
	}

}
