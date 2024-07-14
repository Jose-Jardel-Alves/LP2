package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisaoResumidaTest {

	private Visao visaoResumida;
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
	
	
	@DisplayName("Criar visão resumida com documento nulo")
	@Test
	void criarVisaoResumidaComDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> visaoResumida = new VisaoResumida(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir visão resumida sem elementos")
	@Test
	void exibirVisaoResumidaSemElementos() {
		String[] out = {};
		Documento documento2 = new Documento("documento2");
		visaoResumida = new VisaoResumida(documento2);
		assertTrue(Arrays.equals(out, visaoResumida.exibir()));
	}
	
	@DisplayName("Exibir visão resumida")
	@Test
	void exibirVisaoResumida() {
		String[] out = {"texto", "2. titulo"};
		visaoResumida = new VisaoResumida(documento);
		assertTrue(Arrays.equals(out, visaoResumida.exibir()));
	}

}
