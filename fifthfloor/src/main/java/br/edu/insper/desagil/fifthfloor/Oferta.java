package br.edu.insper.desagil.fifthfloor;

import java.time.LocalDate;

public class Oferta {
	private String cpf;
	private LocalDate data;
	private int preco;
	private boolean aceita;

	public Oferta(String cpf, int preco) {
		this.cpf = cpf;
		this.data = LocalDate.now();
		this.preco = preco;
		this.aceita = false;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getData() {
		return data;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public boolean isAceita() {
		return aceita;
	}

	public void setAceita(boolean aceita) {
		this.aceita = aceita;
	}
}
