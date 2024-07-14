package documin.modelo;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class TextoTest {

	private Elemento texto;
	
	
	@DisplayName("fn")
	@Test
	void criarTextoComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> texto = new Texto(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	
	@DisplayName("Criar texto com valor vazio")
	@Test
	void criarTextoComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> texto = new Texto("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto com valor vazio com espaço")
	@Test
	void criarTextoComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> texto = new Texto(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	
	@DisplayName("Criar texto com prioridade negativa")
	@Test
	void criarTextoComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> texto = new Texto("texto", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto com prioridade 0")
	@Test
	void criarTextoComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> texto = new Texto("texto", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto com prioridade acima de 5")
	@Test
	void criarTextoComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> texto = new Texto("texto", 6));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa")
	@Test
	void gerarRepresentacaoCompleta() {
		String out = "texto";
		texto = new Texto("texto", 2);
		assertEquals(out, texto.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação resumida")
	@Test
	void gerarRepresentacaoResumida() {
		String out = "texto";
		texto = new Texto("texto", 2);
		assertEquals(out, texto.gerarRepresentacaoResumida());
	}

}
