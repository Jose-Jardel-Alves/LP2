package modelo;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

class TimeTest {

	@DisplayName("Criar time com código nulo")
	@Test
	void testEntradasNulasComCodigoNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> new Time(null, "Flamengo", "Urubu"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar time com nome nulo")
	@Test
	void testEntradasNulasComNomeNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> new Time("007_RJ", null, "Urubu"));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com mascote nulo")
	@Test
	void testEntradasNulasComMascoteNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> new Time("007_RJ", "Flamengo", null));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com código vazio")
	@Test
	void testEntradasInvalidasComCodigoVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Time("", "Flamengo", "Urubu"));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com nome vazio")
	@Test
	void testEntradasInvalidasComNomeVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Time("007_RJ", "", "Urubu"));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com mascote vazio")
	@Test
	void testEntradasInvalidasComMascoteVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Time("007_RJ", "Flamengo", ""));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com código vazio com espaço")
	@Test
	void testEntradasInvalidasComCodigoVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Time(" ", "Flamengo", "Urubu"));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com nome vazio com espaço")
	@Test
	void testEntradasInvalidasComNomeVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Time("007_RJ", " ", "Urubu"));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Criar time com mascote vazio com espaço")
	@Test
	void testEntradasInvalidasComMascoteVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Time("007_RJ", "Flamengo", " "));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("To String")
	@Test
	void testToString() {
		String out = "[007_RJ] Flamengo / Urubu";
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		assertEquals(out, time.toString());
	}


}
