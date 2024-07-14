package modelo;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

class CampeonatoTest {
	
	@DisplayName("Criar campeonato com nome nulo")
	@Test
	void testCampeonatoComNomeEntradaNula() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> new Campeonato(null, 5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar campeonato com nome vazio")
	@Test
	void testCampeonatoComNomeEntradaVazia() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Campeonato("", 5));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar campeonato com nome vazio com espaço")
	@Test
	void testCampeonatoComNomeEntradaVaziaComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Campeonato(" ", 5));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar campeonato co quantidade zero")
	@Test
	void testCampeonatoComQuantidadeZero() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Campeonato("Brasileirão", 0));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar campeonato com quantidade negativa")
	@Test
	void testCampeonatoComQuantidadeNegativa() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Campeonato("Brasileirão", -5));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Adicionar time excedendo a quantidade limite")
	@Test
	void testAdicionarTimeExcedendoAQuantidadeLimite() {
		String out = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Time time2 = new Time("003_SP", "Corinthians", "Gavião");
		Campeonato campeonato = new Campeonato("Brasileirão", 1);
		campeonato.adicionarTime(time);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> campeonato.adicionarTime(time2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Verificar se time pertence ao campeonato")
	@Test
	void testTimePertenceACampeonato() {
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		assertTrue(campeonato.possuiTime("007_RJ"));
	}
	
	@DisplayName("Verificar se time não pertence ao campeonato")
	@Test
	void testTimeNaoPertenceACampeonato() {
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		assertFalse(campeonato.possuiTime("007_RJ"));
	}
	
	@DisplayName("Verificar se time pertence a campeonato passando o código do time como nulo")
	@Test
	void testTimePertenceACampeonatoComEntradaNula() {
		String out = "ENTRADA INVÁLIDA";
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, ()-> campeonato.possuiTime(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Verificar se time pertence a campeonato passando o código do time vazio")
	@Test
	void testTimePertenceACampeonatoComEntradaVazia() {
		String out = "ENTRADA INVÁLIDA";
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()-> campeonato.possuiTime(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Verificar se time pertence a campeonato passando o código do time vazio com espaço")
	@Test
	void testTimePertenceACampeonatoComEntradaVaziaComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()-> campeonato.possuiTime(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("ToString")
	@Test
	void testToString() {
		String out = "Brasileirão - 1/5";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		assertEquals(out, campeonato.toString());
	}
	

}
