package br.edu.insper.desagil.fifthfloor;

import java.util.Map;

public class Casa extends Imovel {
	private boolean deVila;

	public Casa(String descricao, String endereco, boolean deVila) {
		super(descricao, endereco);
		this.deVila = deVila;
	}

	@Override
	public Map<String, String> resume() {
		Map<String, String> resumo = super.resume();
		String value;
		if (deVila) {
			value = "SIM";
		} else {
			value = "NÃO";
		}
		resumo.put("Vila?", value);
		return resumo;
	}
}
