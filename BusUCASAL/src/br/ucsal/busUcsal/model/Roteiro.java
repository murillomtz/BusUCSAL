package br.ucsal.busUcsal.model;

public class Roteiro {

	private Integer idRoteiro;
	private String hora;
	private String descricao;
	private String nomeRoteiro;

	public Roteiro(Integer idRoteiro, String hora, String descricao, String nomeRoteiro) {
		super();
		this.idRoteiro = idRoteiro;
		this.hora = hora;
		this.descricao = descricao;
		this.nomeRoteiro = nomeRoteiro;
	}

	public Roteiro(String hora, String descricao, String nomeRoteiro) {
		super();
		this.hora = hora;
		this.descricao = descricao;
		this.nomeRoteiro = nomeRoteiro;
	}

	public Integer getIdRoteiro() {
		return idRoteiro;
	}

	public void setIdRoteiro(Integer idRoteiro) {
		this.idRoteiro = idRoteiro;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeRoteiro() {
		return nomeRoteiro;
	}

	public void setNomeRoteiro(String nomeRoteiro) {
		this.nomeRoteiro = nomeRoteiro;
	}

}
