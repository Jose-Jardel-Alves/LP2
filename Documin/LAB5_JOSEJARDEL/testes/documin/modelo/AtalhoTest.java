package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AtalhoTest {

	private Documento documento;
	private Elemento atalho;
	private Elemento texto;
	private Elemento texto2;
	private Elemento titulo;
	
	
	
	
	@BeforeEach
	void before() {
		documento = new Documento("documento");

	}
	
	@DisplayName("Criar atalho com tituloReferenciado nulo")
	@Test
	void criarAtalhoComTituloReferenciadoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> atalho = new Atalho(null, 2, documento));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com tituloReferenciado vazio")
	@Test
	void criarAtalhoComTituloReferenciadoVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> atalho = new Atalho("", 2, documento));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com tituloReferenciado vazio com espaço")
	@Test
	void criarAtalhoComTituloReferenciadoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> atalho = new Atalho(" ", 2, documento));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com prioridade zero")
	@Test
	void criarAtalhoComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> atalho = new Atalho("documento", 0, documento));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com prioridade negativa")
	@Test
	void criarAtalhoComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> atalho = new Atalho("documento", -1, documento));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com prioridade acima de cinco")
	@Test
	void criarAtalhoComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> atalho = new Atalho("documento", 6, documento));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa de atalho")
	@Test
	void gerarRepresentacaoCompleta() {
		String out = "texto2" + System.lineSeparator() + "2. titulo --" + System.lineSeparator() + "2-TITULO";
		texto = new Texto("texto", 2);
		texto2 = new Texto("texto2", 4);
		titulo = new Titulo("titulo", 5, 2, true);
		documento.criarElemento(texto);
		documento.criarElemento(texto2);
		documento.criarElemento(titulo);
		atalho = new Atalho("documento", 1, documento);
		assertEquals(out, atalho.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação resumida de atalho")
	@Test
	void gerarRepresentacaoResumida() {
		String out = "texto2" + System.lineSeparator() + "2. titulo";
		texto = new Texto("texto", 2);
		texto2 = new Texto("texto2", 4);
		titulo = new Titulo("titulo", 5, 2, true);
		documento.criarElemento(texto);
		documento.criarElemento(texto2);
		documento.criarElemento(titulo);
		atalho = new Atalho("documento", 1, documento);
		assertEquals(out, atalho.gerarRepresentacaoResumida());
	}
}
