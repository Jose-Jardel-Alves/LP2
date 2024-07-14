package documin.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DocumentoTest {
	
	private Documento documento;
	
	@BeforeEach
	@Test
	void before() {
		
	}
	
	@DisplayName("Criar documento com titulo nulo")
	@Test
	void criarDocumentoComTituloNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documento = new Documento(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo vazio")
	@Test
	void criarDocumentoComTituloVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo vazio com espaço")
	@Test
	void criarDocumentoComTituloVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento no segundo construtor com titulo nulo")
	@Test
	void criarDocumentNoSegundoConstrutoroComTituloNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documento = new Documento(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento no segundo construtor com titulo vazio")
	@Test
	void criarDocumentoNoSegundoConstrutorComTituloVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento no segundo construtor com titulo vazio com espaço")
	@Test
	void criarDocumentoNoSegundoConstrutorComTituloVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento no segundo construtor com prioridade 0")
	@Test
	void criarDocumentoNoSegundoConstrutorComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento("", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento no segundo construtor com prioridade negativa")
	@Test
	void criarDocumentoNoSegundoConstrutorComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento(" ", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento no segundo construtor com prioridade acima de 5")
	@Test
	void criarDocumentoNoSegundoConstrutorComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento = new Documento(" ", -6));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar elemento com sucesso quando tamanho não foi indicado no construtor")
	@Test
	void criarElementoComSucessoQuandoTamanhoNaoFoiIndicadoNoConstrutor() {
		Elemento elemento = new Texto("texto", 2);
		Documento documento = new Documento("documento");
		assertEquals(0, documento.criarElemento(elemento));
	}
	
	@DisplayName("Criar elemento com sucesso quando tamanho foi indicado no construtor")
	@Test
	void criarElementoComSucessoQuandoTamanhoFoiIndicadoNoConstrutor() {
		Elemento elemento = new Texto("texto", 2);
		Documento documento = new Documento("documento", 2);
		assertEquals(0, documento.criarElemento(elemento));
	}
	
	@DisplayName("Criar elemento excedendo a quantidade limite passada no construtor")
	@Test
	void criarElementoExcedendoAQuantidadeLimitePassadaNoConstrutor() {
		String out = "NÃO PODE MAIS ADICIONAR ELEMENTO";
		Elemento elemento = new Texto("texto", 2);
		Elemento elemento2 = new Texto("texto", 2);
		Elemento elemento3 = new Texto("texto", 2);
		Documento documento = new Documento("documento", 2);
		documento.criarElemento(elemento);
		documento.criarElemento(elemento2);
		ArrayIndexOutOfBoundsException e = assertThrows(ArrayIndexOutOfBoundsException.class, () -> documento.criarElemento(elemento3));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Aumenta contador atalhos")
	@Test
	void aumentaContadorAtalhos() {
		Documento documento = new Documento("documento", 2);
		int countAtalhos = documento.getCountAtalhos();
		documento.aumentaContadorAtalhos();
		assertEquals(countAtalhos+1, documento.getCountAtalhos());
	}
	
	@DisplayName("Diminui contador atalhos")
	@Test
	void diminuiContadorAtalhos() {
		Documento documento = new Documento("documento", 2);
		documento.aumentaContadorAtalhos();
		int countAtalhos = documento.getCountAtalhos();
		documento.diminuiContadorAtalhos();
		assertEquals(countAtalhos-1, documento.getCountAtalhos());
	}
	
	@DisplayName("Mover para cima com elementoPosicao menor que 0")
	@Test
	void moverParaCimaComElementoPosicaoMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		Documento documento = new Documento("documento", 2);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento.moverParaCima(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima com elementoPosicao 0")
	@Test
	void moverParaCimaComElementoPosicaoZero() {
		String out = "NÃO SE PODE MOVER PARA CIMA O PRIMEIRO ELEMENTO";
		Documento documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 2);
		documento.criarElemento(texto);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento.moverParaCima(0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima com elementoPosicao excedendo a quantidade de elementos")
	@Test
	void moverParaCimaComElementoPosicaoExcedendoAQuantidadeDeElementos() {
		String out = "O ELEMENTO NÃO EXISTE";
		Documento documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 2);
		documento.criarElemento(texto);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documento.moverParaCima(1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo com elementoPosicao menor que 0")
	@Test
	void moverParaBaixoComElementoPosicaoMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		Documento documento = new Documento("documento", 2);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento.moverParaBaixo(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo com elementoPosicao 0")
	@Test
	void moverParaBaixoComElementoPosicaoZero() {
		String out = "NÃO SE PODE MOVER PARA BAIXO O ÚLTIMO ELEMENTO";
		Documento documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 2);
		documento.criarElemento(texto);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento.moverParaBaixo(0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo com elementoPosicao excedendo a quantidade de elementos")
	@Test
	void moverParaBaixoComElementoPosicaoExcedendoAQuantidadeDeElementos() {
		String out = "O ELEMENTO NÃO EXISTE";
		Documento documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 2);
		documento.criarElemento(texto);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documento.moverParaBaixo(1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir documento com sucesso")
	@Test
	void exibirDocumentoComSucesso() {
		String[] out = {"texto", "1. TITULO"};
		documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 1);
		Elemento titulo = new Titulo("TITULO", 2, 1, false);
		documento.criarElemento(texto);
		documento.criarElemento(titulo);
		assertTrue(Arrays.equals(out, documento.exibir()));
	}
	
	@DisplayName("Apagar elemento com posicao menor que 0")
	@Test
	void apagarElementoComPosicaoMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		documento = new Documento("documento", 2);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documento.apagarElemento(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento com posicao excedendo a quantidade de elemntos")
	@Test
	void apagarElementoComPosicaoExcedendoAQuantidadeDeElementos() {
		String out = "NÃO EXISTE ELEMENTO NESSA POSIÇÃO";
		documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 1);
		documento.criarElemento(texto);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documento.apagarElemento(1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento com sucesso")
	@Test
	void apagarElementoComSucesso() {
		documento = new Documento("documento", 2);
		Elemento texto = new Texto("texto", 1);
		documento.criarElemento(texto);
		assertTrue(documento.apagarElemento(0));
	}
	
}
