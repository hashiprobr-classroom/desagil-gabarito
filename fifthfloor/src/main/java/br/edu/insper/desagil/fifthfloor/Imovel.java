package br.edu.insper.desagil.fifthfloor;

import java.util.HashMap;
import java.util.Map;

public abstract class Imovel {
	private String descricao;
	private String endereco;

	public Imovel(String descricao, String endereco) {
		this.descricao = descricao;
		this.endereco = endereco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Map<String, String> resume() {
		Map<String, String> resumo = new HashMap<>();
		resumo.put("Descrição", descricao);
		resumo.put("Endereço", endereco);
		return resumo;
	}
}
