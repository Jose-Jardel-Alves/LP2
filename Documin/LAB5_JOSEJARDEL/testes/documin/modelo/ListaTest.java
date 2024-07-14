package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListaTest {
	
	
	private Elemento lista;
	
	@DisplayName("Criar lista com valor nulo")
	@Test
	void criarListaComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> lista = new Lista(null, 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com separador nulo")
	@Test
	void criarListaComSeparadorNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> lista = new Lista("valor | da | lista", 2, null, "-"));
		assertEquals(out, e.getMessage());
	}

	@DisplayName("Criar lista com caractere nulo")
	@Test
	void criarListaComCaractereNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> lista = new Lista("valor | da | lista", 2, "|", null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com valor vazio")
	@Test
	void criarListaComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com separador vazio")
	@Test
	void criarListaComSeparadorVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", 2, "", "-"));
		assertEquals(out, e.getMessage());
	}

	@DisplayName("Criar lista com caractere vazio")
	@Test
	void criarListaComCaractereVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", 2, "|", ""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com valor vazio com espaço")
	@Test
	void criarListaComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista(" ", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com separador vazio com espaço")
	@Test
	void criarListaComSeparadorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", 2, " ", "-"));
		assertEquals(out, e.getMessage());
	}

	@DisplayName("Criar lista com caractere vazio com espaço")
	@Test
	void criarListaComCaractereVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", 2, "|", " "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com prioridade negativa")
	@Test
	void criarListaComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", -1, "|", "-"));
		assertEquals(out, e.getMessage());
	}

	@DisplayName("Criar lista com prioridade zero")
	@Test
	void criarListaComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", 0, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	

	@DisplayName("Criar lista com prioridade acima de 5")
	@Test
	void criarListaComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> lista = new Lista("valor | da | lista", 6, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa")
	@Test
	void gerarRepresentacaoCompleta() {
		String out = "- valor" + System.lineSeparator() + "- da" + System.lineSeparator() + "- lista";
		lista = new Lista("valor | da | lista", 2, "|", "-");
		assertEquals(out, lista.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação resumida")
	@Test
	void gerarRepresentacaoResumida() {
		String out = "valor| da| lista";
		lista = new Lista("valor | da | lista", 2, "|", "-");
		assertEquals(out, lista.gerarRepresentacaoResumida());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
