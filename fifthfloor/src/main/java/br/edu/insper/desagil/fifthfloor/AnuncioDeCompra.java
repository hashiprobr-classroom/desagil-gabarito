package br.edu.insper.desagil.fifthfloor;

import java.util.Map;

public class AnuncioDeCompra extends Anuncio {
	public AnuncioDeCompra(Imovel imovel, int preco) {
		super(imovel, preco);
	}

	@Override
	public Map<String, String> resume() {
		Map<String, String> resumo = super.resume();
		resumo.put("Preço", Integer.toString(getPreco()));
		return resumo;
	}
}
