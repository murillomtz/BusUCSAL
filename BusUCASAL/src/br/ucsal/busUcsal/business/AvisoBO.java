package br.ucsal.busUcsal.business;

import java.util.List;

import br.ucsal.busUcsal.exception.DadoInsuficienteException;
import br.ucsal.busUcsal.model.Aviso;
import br.ucsal.busUcsal.persistence.AvisoDAO;

public class AvisoBO {

	// Retorna uma lista de avisos da persistence
	public static List<Aviso> listarTodosAvisos(){
		return AvisoDAO.buscarTodosAvisos();
	}
	
	// Passa o parametro id para a remoção na DAO
	public static void removerAviso(Integer id) {
		AvisoDAO.removerAviso(id);
	}

	// Passa o objeto para a adição na DAO
	public static void addAviso(Aviso aviso) throws DadoInsuficienteException {
		validar(aviso);
		AvisoDAO.adicionaAviso(aviso);
	}

	// Valida os atributos do objeto
	private static void validar(Aviso aviso) throws DadoInsuficienteException {
		if (aviso.getNome() == null || aviso.getNome().trim().isEmpty()) {
			throw new DadoInsuficienteException("O nome do aviso deve ser informado !");
		}
		if (aviso.getDescricao() == null || aviso.getDescricao().trim().isEmpty()) {
			throw new DadoInsuficienteException("A descrição do aviso deve ser informada !");
		}

	}
}
