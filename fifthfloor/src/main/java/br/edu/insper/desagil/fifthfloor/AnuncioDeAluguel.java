package br.edu.insper.desagil.fifthfloor;

import java.util.Map;

public class AnuncioDeAluguel extends Anuncio {
	public AnuncioDeAluguel(Imovel imovel, int preco) {
		super(imovel, preco);
	}

	@Override
	public Map<String, String> resume() {
		Map<String, String> resumo = super.resume();
		resumo.put("Aluguel", Integer.toString(getPreco()));
		return resumo;
	}
}
