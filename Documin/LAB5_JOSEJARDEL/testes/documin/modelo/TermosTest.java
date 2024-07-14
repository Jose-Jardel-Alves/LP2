package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TermosTest {

	private Elemento termos;
	
	@DisplayName("Criar termos com valor nulo")
	@Test
	void criarTermosComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> termos = new Termos(null, 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com separador nulo")
	@Test
	void criarTermosComSeparadorNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 2, null, "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem nula")
	@Test
	void criarTermosComOrdemNula() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 2, "/", null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com valor vazio")
	@Test
	void criarTermosComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com separador vazio")
	@Test
	void criarTermosComSeparadorVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 2, "", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem vazia")
	@Test
	void criarTermosComOrdemVazia() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 2, "/", ""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com valor vazio com espaço")
	@Test
	void criarTermosComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos(" ", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com separador vazio com espaço")
	@Test
	void criarTermosComSeparadorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 2, " ", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem vazia com espaço")
	@Test
	void criarTermosComOrdemVaziaComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 2, "/", " "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem diferente de TAMANHO, ALFABÉTICA E NENHUMA")
	@Test
	void criarTermosComOrdemDiferente() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Lista / Aleatórios", 2, "/", "diferente"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com prioridade negativa")
	@Test
	void criarTermosComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", -1, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com prioridade zero")
	@Test
	void criarTermosComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 0, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com prioridade acima de cinco")
	@Test
	void criarTermosComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> termos = new Termos("Teste / Termos / Aleatórios", 6, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa com ordem TAMANHO")
	@Test
	void gerarRepresentacaoCompletaComOrdemTamanho() {
		String out = "Total de termos: 3" + System.lineSeparator() + "Aleatórios, Termos, Teste";
		termos = new Termos("Teste / Termos / Aleatórios", 2, "/", "TAMANHO");
		assertEquals(out, termos.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação completa com ordem ALFABÉTICA")
	@Test
	void gerarRepresentacaoCompletaComOrdemAlfabetica() {
		String out = "Total de termos: 3" + System.lineSeparator() + "Aleatórios, Lista, Teste";
		termos = new Termos("Teste / Lista / Aleatórios", 2, "/", "ALFABÉTICA");
		assertEquals(out, termos.gerarRepresentacaoCompleta());
	}
	
	@DisplayName("Gerar representação completa com ordem NENHUMA")
	@Test
	void gerarRepresentacaoCompletaComOrdemNenhuma() {
		String out = "Total de termos: 3" + System.lineSeparator() + "Teste, Lista, Aleatórios";
		termos = new Termos("Teste / Lista / Aleatórios", 2, "/", "NENHUMA");
		assertEquals(out, termos.gerarRepresentacaoCompleta());
	}
	
	
	@DisplayName("Gerar representação resumida com ordem TAMANHO")
	@Test
	void gerarRepresentacaoResumidaComOrdemTamanho() {
		String out = "Aleatórios / Termos / Teste";
		termos = new Termos("Teste / Termos / Aleatórios", 2, "/", "TAMANHO");
		assertEquals(out, termos.gerarRepresentacaoResumida());
	}
	
	@DisplayName("Gerar representação resumida com ordem ALFABÉTICA")
	@Test
	void gerarRepresentacaoResumidaComOrdemAlfabetica() {
		String out = "Aleatórios / Lista / Teste";
		termos = new Termos("Teste / Lista / Aleatórios", 2, "/", "ALFABÉTICA");
		assertEquals(out, termos.gerarRepresentacaoResumida());
	}
	
	@DisplayName("Gerar representação resumida com ordem NENHUMA")
	@Test
	void gerarRepresentacaoResumidaComOrdemNenhuma() {
		String out = "Teste / Lista / Aleatórios";
		termos = new Termos("Teste / Lista / Aleatórios", 2, "/", "NENHUMA");
		assertEquals(out, termos.gerarRepresentacaoResumida());
	}
	
	

}
