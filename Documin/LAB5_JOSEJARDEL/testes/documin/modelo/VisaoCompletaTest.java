package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisaoCompletaTest {

	private Visao visaoCompleta;
	private Documento documento;
	private Elemento texto;
	private Elemento titulo;
	
	@BeforeEach
	void before() {
		documento = new Documento("documento");
		texto = new Texto("texto", 2);
		titulo = new Titulo("titulo", 2, 2, true);
		documento.criarElemento(texto);
		documento.criarElemento(titulo);
	}
	
	
	@DisplayName("Criar visão completa com documento nulo")
	@Test
	void criarVisaoCompletaComDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> visaoCompleta = new VisaoCompleta(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir visão completa sem elementos")
	@Test
	void exibirVisaoCompletaSemElementos() {
		String[] out = {};
		Documento documento2 = new Documento("documento2");
		visaoCompleta = new VisaoCompleta(documento2);
		assertTrue(Arrays.equals(out, visaoCompleta.exibir()));
	}
	
	@DisplayName("Exibir visão completa")
	@Test
	void exibirVisaoCompleta() {
		String[] out = {"texto", "2. titulo --" + System.lineSeparator() + "2-TITULO"};
		visaoCompleta = new VisaoCompleta(documento);
		assertTrue(Arrays.equals(out, visaoCompleta.exibir()));
	}

}
