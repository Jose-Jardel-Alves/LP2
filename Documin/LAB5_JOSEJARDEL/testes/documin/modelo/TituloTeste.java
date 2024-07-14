package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TituloTeste {

	private Elemento titulo;
	
	@DisplayName("Criar titulo com valor nulo")
	@Test
	void criarTituloComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> titulo = new Titulo(null, 2, 2, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com valor vazio")
	@Test
	void criarTituloComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("", 2, 2, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com valor vazio com espaço")
	@Test
	void criarTituloComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo(" ", 2, 2, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com prioridade negativa")
	@Test
	void criarTituloComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("titulo", -1, 2, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com prioridade zero")
	@Test
	void criarTituloComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("titulo", 0, 2, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com prioridade acima de 5")
	@Test
	void criarTituloComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("titulo", 6, 2, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com nível negativa")
	@Test
	void criarTituloComNivelNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("titulo", 2, -1, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com nível zero")
	@Test
	void criarTituloComNivelZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("titulo", 2, 0, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com nível acima de 5")
	@Test
	void criarTituloComNivelAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> titulo = new Titulo("titulo", 2, 6, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa com linkavel true")
	@Test
	void gerarRepresentacaoCompletaComLinkavelTrue() {
		String out = "2. titulo --" + System.lineSeparator() + "2-TITULO";
		titulo = new Titulo("titulo", 2, 2, true);
		assertEquals(out, titulo.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação completa com linkavel false")
	@Test
	void gerarRepresentacaoCompletaComLinkavelFalse() {
		String out = "2. titulo";
		titulo = new Titulo("titulo", 2, 2, false);
		assertEquals(out, titulo.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação resumida com linkavel false")
	@Test
	void gerarRepresentacaoResumida() {
		String out = "2. titulo";
		titulo = new Titulo("titulo", 2, 2, false);
		assertEquals(out, titulo.gerarRepresentacaoResumida());
	}
	
	

}
