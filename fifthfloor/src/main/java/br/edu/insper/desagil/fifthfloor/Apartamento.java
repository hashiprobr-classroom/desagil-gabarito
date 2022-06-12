package br.edu.insper.desagil.fifthfloor;

import java.util.Map;

public class Apartamento extends Imovel {
	private int condominio;

	public Apartamento(String descricao, String endereco, int condominio) {
		super(descricao, endereco);
		this.condominio = condominio;
	}

	public void setCondominio(int condominio) {
		this.condominio = condominio;
	}

	@Override
	public Map<String, String> resume() {
		Map<String, String> resumo = super.resume();
		resumo.put("Condomínio", Integer.toString(condominio));
		return resumo;
	}
}
