package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class ApostaTest {
	
	@DisplayName("Criar aposta com colocação 0")
	@Test
	void testCriarApostaComColocaoZero() {
		String out = "ENTRADAS INVÁLIDAS";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Aposta(time, campeonato, 0, 5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com colocação negativa")
	@Test
	void testCriarApostaComColocaoNegativa() {
		String out = "ENTRADAS INVÁLIDAS";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Aposta(time, campeonato, -1, 5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com valor 0")
	@Test
	void testCriarApostaComValorZero() {
		String out = "ENTRADAS INVÁLIDAS";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Aposta(time, campeonato, 5, 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com valor negativo")
	@Test
	void testCriarApostaComValorNegativo() {
		String out = "ENTRADAS INVÁLIDAS";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Aposta(time, campeonato, 4, -4));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com colocação negativa")
	@Test
	void testCriarApostaComColocaoMaiorQueLimite() {
		String out = "APOSTA NÃO REGISTRADA";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Aposta(time, campeonato, 6, 5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("ToString")
	@Test
	void testToString(){
		String out = "[007_RJ] Flamengo / Urubu\n"
				+ "Brasileirão\n"
				+ "2/5\n"
				+ "R$ 20.2";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonato.adicionarTime(time);
		Aposta aposta = new Aposta(time, campeonato, 2, 20.2);
		assertEquals(out, aposta.toString());
		
		
		
	}
}
