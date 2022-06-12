package br.edu.insper.desagil.fifthfloor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;

class AnuncioTest {
	@Test
	void resumeAluguelDeCasa() {
		Imovel imovel = new Casa("Casa modesta e discreta na Vila Olímpia", "Rua Quatá, 300", false);
		Anuncio anuncio = new AnuncioDeAluguel(imovel, 2500);
		Map<String, String> resumo = anuncio.resume();
		assertEquals(4, resumo.size());
		assertEquals("Casa modesta e discreta na Vila Olímpia", resumo.get("Descrição"));
		assertEquals("Rua Quatá, 300", resumo.get("Endereço"));
		assertEquals("NÃO", resumo.get("Vila?"));
		assertEquals("2500", resumo.get("Aluguel"));
	}

	@Test
	void resumeCompraDeApartamento() {
		Imovel imovel = new Apartamento("Apartamento modesto e discreto na Vila Olímpia", "Rua Quatá, 300", 1000);
		Anuncio anuncio = new AnuncioDeCompra(imovel, 5000000);
		Map<String, String> resumo = anuncio.resume();
		assertEquals(4, resumo.size());
		assertEquals("Apartamento modesto e discreto na Vila Olímpia", resumo.get("Descrição"));
		assertEquals("Rua Quatá, 300", resumo.get("Endereço"));
		assertEquals("1000", resumo.get("Condomínio"));
		assertEquals("5000000", resumo.get("Preço"));
	}

	@Test
	void identificaMaiorOferta() {
		Imovel imovel = mock(Imovel.class);
		Anuncio anuncio = new AnuncioDeAluguel(imovel, 2500);
		anuncio.fazOferta("123", 2500);
		anuncio.fazOferta("456", 3000);
		anuncio.fazOferta("789", 2000);
		Oferta oferta = anuncio.maiorOferta();
		assertEquals("456", oferta.getCpf());
		assertEquals(3000, oferta.getPreco());
	}

	@Test
	void aceitaUmaOferta() {
		Imovel imovel = mock(Imovel.class);
		Anuncio anuncio = new AnuncioDeCompra(imovel, 5000000);
		anuncio.fazOferta("123", 5000000);
		anuncio.fazOferta("456", 5500000);
		anuncio.fazOferta("789", 4500000);
		anuncio.fecha("456");
		assertFalse(anuncio.isAtivo());
		// Aqui havia um errinho no enunciado. Era para confirmar
		// que a oferta escolhida foi aceita, mas não era necessário
		// confirmar que as outras não foram.
		assertTrue(anuncio.maiorOferta().isAceita());
	}
}
