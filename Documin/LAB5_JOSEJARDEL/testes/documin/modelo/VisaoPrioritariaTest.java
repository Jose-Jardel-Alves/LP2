package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisaoPrioritariaTest {
	
	private Visao visaoPrioritaria;
	private Documento documento;
	private Elemento texto;
	private Elemento titulo;
	
	@BeforeEach
	void before() {
		documento = new Documento("documento");
		texto = new Texto("texto", 1);
		titulo = new Titulo("titulo", 1, 2, true);
		documento.criarElemento(texto);
		documento.criarElemento(titulo);
	}
	
	
	@DisplayName("Criar visão prioritária com documento nulo")
	@Test
	void criarVisaoPrioritariaComDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> visaoPrioritaria = new VisaoPrioritaria(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritária com prioridade zero")
	@Test
	void criarVisaoPrioritariaComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> visaoPrioritaria = new VisaoPrioritaria(documento, 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritária com prioridade menor que zero")
	@Test
	void criarVisaoPrioritariaComPrioridadeMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> visaoPrioritaria = new VisaoPrioritaria(documento, -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritária com prioridade acima de cinco")
	@Test
	void criarVisaoPrioritariaComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> visaoPrioritaria = new VisaoPrioritaria(documento, 6));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir visão prioritaria sem elementos")
	@Test
	void exibirVisaoPrioritariaSemElementos() {
		String[] out = {};
		Documento documento2 = new Documento("documento2");
		visaoPrioritaria = new VisaoPrioritaria(documento2, 2);
		assertTrue(Arrays.equals(out, visaoPrioritaria.exibir()));
	}
	
	@DisplayName("Exibir visão prioritaria com apenas prioridade dos elementos abaixo da prioridade passada")
	@Test
	void exibirVisaoPrioritariaComApenasPrioridadeDosElementosAbaixoDaPrioridadePassada() {
		String[] out = {};
		visaoPrioritaria = new VisaoPrioritaria(documento, 2);
		assertTrue(Arrays.equals(out, visaoPrioritaria.exibir()));
	}
	
	@DisplayName("Exibir visão prioritaria")
	@Test
	void exibirVisaoPrioritaria() {
		String[] out = {"textoComPrioridadeAcima", "3. tituloComPrioridadeAcima --" + System.lineSeparator() + "3-TITULOCOMPRIORIDADEACIMA"};
		Elemento texto2 = new Texto("textoComPrioridadeAcima", 4);
		Elemento titulo2 = new Titulo("tituloComPrioridadeAcima", 4, 3, true);
		Elemento titulo3 = new Titulo("tituloComPrioridadeAbaixo", 1, 2, true);
		documento.criarElemento(texto2);
		documento.criarElemento(titulo2);
		documento.criarElemento(titulo3);
		visaoPrioritaria = new VisaoPrioritaria(documento, 2);
		assertTrue(Arrays.equals(out, visaoPrioritaria.exibir()));
	}

}
