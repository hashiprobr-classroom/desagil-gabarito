package br.edu.insper.desagil.fifthfloor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Anuncio {
	private Imovel imovel;
	private int preco;
	private List<Oferta> ofertas;
	private boolean ativo;

	public Anuncio(Imovel imovel, int preco) {
		this.imovel = imovel;
		this.preco = preco;
		this.ofertas = new ArrayList<>();
		this.ativo = true;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Oferta maiorOferta() {
		Oferta maior = null;
		for (Oferta oferta : ofertas) {
			if (maior == null || maior.getPreco() < oferta.getPreco()) {
				maior = oferta;
			}
		}
		return maior;
	}

	public void fazOferta(String cpf, int preco) {
		for (Oferta oferta : ofertas) {
			if (oferta.getCpf().equals(cpf)) {
				oferta.setPreco(preco);
				return;
			}
		}
		Oferta oferta = new Oferta(cpf, preco);
		ofertas.add(oferta);
	}

	public Map<String, String> resume() {
		return imovel.resume();
	}

	public void fecha(String cpf) {
		for (Oferta oferta : ofertas) {
			if (oferta.getCpf().equals(cpf)) {
				oferta.setAceita(true);
				ativo = false;
				return;
			}
		}
	}
}
