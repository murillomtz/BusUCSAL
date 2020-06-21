package br.ucsal.busUcsal.business;

import java.util.List;

import br.ucsal.busUcsal.exception.DadoInsuficienteException;
import br.ucsal.busUcsal.model.Roteiro;
import br.ucsal.busUcsal.persistence.RoteiroDAO;

public class RoteiroBO {

	public static void addRoteiro(Roteiro roteiro) throws DadoInsuficienteException {
		validate(roteiro);
		RoteiroDAO.adicionarRoteiro(roteiro);
	}


	public static List<Roteiro> listarTodosRoteiros() {
		return RoteiroDAO.buscarTodosRoteiros();
	}

	public static void removerRoteiro(Integer id) {
		RoteiroDAO.removerRoteiro(id);
		
	}
	public static void atualizarRoteiro(Integer id, String nome, String horario, String descricao) {
		RoteiroDAO.updateRoteiro(id, nome, horario, descricao);
	}

	private static void validate(Roteiro roteiro) throws DadoInsuficienteException {
		if (roteiro.getNomeRoteiro() == null || roteiro.getNomeRoteiro().trim().isEmpty()) {
			throw new DadoInsuficienteException("O nome do roteiro deve ser informado !");
		}
		if (roteiro.getDescricao() == null || roteiro.getDescricao().trim().isEmpty()) {
			throw new DadoInsuficienteException("A descrição do roteiro deve ser informada !");
		}
		if (roteiro.getHora() == null || roteiro.getHora().trim().isEmpty()) {
			throw new DadoInsuficienteException("A hora do roteiro deve ser informada !");
		}
		
	}
}
