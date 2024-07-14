package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisaoTituloTest {

	private Visao visaoTitulo;
	private Documento documento;
	private Elemento texto;
	private Elemento texto2;
	private Elemento titulo;
	
	
	@BeforeEach
	void before() {
		documento = new Documento("documento");
		texto = new Texto("texto", 2);
		texto2 = new Texto("texto2", 3);
		documento.criarElemento(texto);
		documento.criarElemento(texto2);
		
	}
	
	
	@DisplayName("Criar visão titulo com documento nulo")
	@Test
	void criarVisaoTituloComDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> visaoTitulo = new VisaoTitulo(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir visão titulo sem elementos")
	@Test
	void exibirVisaoTituloSemElementos() {
		String[] out = {};
		Documento documento2 = new Documento("documento2");
		visaoTitulo = new VisaoTitulo(documento2);
		assertTrue(Arrays.equals(out, visaoTitulo.exibir()));
	}
	
	@DisplayName("Exibir visão titulo sem elementos titulo")
	@Test
	void exibirVisaoTituloSemElementosTitulo() {
		String[] out = {};
		visaoTitulo = new VisaoTitulo(documento);
		assertTrue(Arrays.equals(out, visaoTitulo.exibir()));
	}
	
	@DisplayName("Exibir visão titulo")
	@Test
	void exibirVisaoTitulo() {
		String[] out = {"1. titulo", "2. titulo2"};
		Elemento titulo = new Titulo("titulo", 1, 1, false);
		Elemento titulo2 = new Titulo("titulo2", 1, 2, false);
		documento.criarElemento(titulo);
		documento.criarElemento(titulo2);
		visaoTitulo = new VisaoTitulo(documento);
		assertTrue(Arrays.equals(out, visaoTitulo.exibir()));
	}
}
