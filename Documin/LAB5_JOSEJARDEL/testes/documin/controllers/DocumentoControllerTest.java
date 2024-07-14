package documin.controllers;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import org.junit.jupiter.api.Test;


class DocumentoControllerTest {

	private DocumentoController documentoController;
	@BeforeEach
	void before() {
		documentoController = new DocumentoController();
	}
	
	
	//Testes de criar documento sem tamanho
	 
	@DisplayName("Criar documento com titulo do documento nulo")
	@Test
	void criarDocumentoComTituloNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarDocumento(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo do documento vazio")
	@Test
	void criarDocumentoComTituloVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarDocumento(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo do documento vazio com espaço")
	@Test
	void criarDocumentoComTituloVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarDocumento(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com sucesso")
	@Test
	void criarDocumentoComSucesso() {
		assertTrue(documentoController.criarDocumento("título de documento válido"));
	}
	
	@DisplayName("Criar documento com titulo de documento já cadastrado")
	@Test
	void criarDocumentoComTituloJaCadastrado() {
		documentoController.criarDocumento("titulo");
		assertFalse(documentoController.criarDocumento("titulo"));
	}

	//Testes para criar documento com tamanho
	 
	@DisplayName("Criar documento com titulo do documento nulo no método que também passa o tamanho")
	@Test
	void criarDocumentoComTituloNuloNoMetodoQueTambemPassaTamanho() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarDocumento(null, 10));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo do documento vazio no método que também passa o tamanho")
	@Test
	void criarDocumentoComTituloVazioNoMetodoQueTambemPassaTamanho() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarDocumento("", 10));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo do documento vazio com espaço no método que também passa o tamanho")
	@Test
	void criarDocumentoComTituloVazioComEspacoNoMetodoQueTambemPassaTamanho() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarDocumento(" ", 10));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo do documento tamanho zero")
	@Test
	void criarDocumentoComTamanhoZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarDocumento("titulo", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com titulo do documento tamanho inválido")
	@Test
	void criarDocumentoComTamanhoInvalido() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarDocumento("titulo", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar documento com sucesso no método que também passa o tamanho")
	@Test
	void criarDocumentoComSucessoNoMetodoQueTambemPassaTamanho() {
		assertTrue(documentoController.criarDocumento("título de documento válido", 10));
	}
	
	@DisplayName("Criar documento com titulo de documento já cadastrado no método que também passa o tamanho")
	@Test
	void criarDocumentoComTituloJaCadastradoNoMetodoQueTambemPassaTamanho() {
		documentoController.criarDocumento("titulo", 10);
		assertFalse(documentoController.criarDocumento("titulo", 10));
	}
	
	@DisplayName("Criar documento com titulo de documento já cadastrado (variação), cadastrando o primeiro sem passar o tamanho e o segundo passando")
	@Test
	void criarDocumentoComTituloJaCadastradoNoMetodoQueTambemPassaTamanhoVariacao() {
		documentoController.criarDocumento("titulo");
		assertFalse(documentoController.criarDocumento("titulo", 10));
	}
	
	@DisplayName("Criar documento com titulo de documento já cadastrado (variação), cadastrando o primeiro passando o tamanho e o segundo sem passar")
	@Test
	void criarDocumentoComTituloJaCadastradoNoMetodoQueTambemPassaTamanhoVariacao2() {
		documentoController.criarDocumento("titulo", 10);
		assertFalse(documentoController.criarDocumento("titulo"));
	}

	//Testes para remover documento
	
	@DisplayName("Remover documento passando titulo nulo")
	@Test
	void removerDocumentoComTituloNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.removerDocumento(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Remover documento passando titulo vazio")
	@Test
	void removerDocumentoComTituloVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.removerDocumento(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Remover documento passando titulo vazio com espaço")
	@Test
	void removerDocumentoComTituloVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.removerDocumento(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Remover documento passando titulo referente a documento que não existe")
	@Test
	void removerDocumentoComTituloDeDocumentoNaoExiste() {
		String out = "NÃO HÁ DOCUMENTO PARA SER REMOVIDO";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.removerDocumento("tituloDocNaoExiste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Remover documento com sucesso")
	@Test
	void removerDocumentoComSucesso() {
		documentoController.criarDocumento("titulo");
		assertTrue(documentoController.removerDocumento("titulo"));
	}
	
	
	//Testes para criar texto
	 
	@DisplayName("Criar texto passando o titulo do doc como nulo")
	@Test
	void criarTextoComTituloDoDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTexto(null, "texto", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando o valor como nulo")
	@Test
	void criarTextoComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTexto("titulo", null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando o titulo do doc como vazio")
	@Test
	void criarTextoComTituloDoDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto("", "texto", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando o valor como vazio")
	@Test
	void criarTextoComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto("titulo", "", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando o titulo do doc como vazio com espaço")
	@Test
	void criarTextoComTituloDoDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto(" ", "texto", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando o valor como vazio com espaço")
	@Test
	void criarTextoComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto("titulo", " ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando prioridade 0")
	@Test
	void criarTextoComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto("titulo", "texto", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando prioridade negativa")
	@Test
	void criarTextoComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto("titulo", "texto", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando prioridade acima de 5")
	@Test
	void criarTextoComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTexto("titulo", "texto", 6));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto passando titulo de documento que não existe")
	@Test
	void criarTextoComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarTexto("tituloDeDocumentoQueNaoExiste", "texto", 6));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar texto com sucesso com prioridade no limite menor (1)")
	@Test
	void criarTextoComPrioridadeUm() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTexto("titulo", "texto", 1));
	}
	
	@DisplayName("Criar texto com sucesso com prioridade no limite maior (5)")
	@Test
	void criarTextoComPrioridadeCinco() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTexto("titulo", "texto", 5));
	}
	
	//Testes para criar titulo
	
	@DisplayName("Criar titulo passando o titulo do documento nulo")
	@Test
	void criarTituloComTituloDoDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTitulo(null, "TITULO", 5, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando o valor nulo")
	@Test
	void criarTituloComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTitulo("titulo", null, 5, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando o titulo do documento vazio")
	@Test
	void criarTituloComTituloDoDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("", "TITULO", 5, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando o valor vazio")
	@Test
	void criarTituloComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "", 5, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando o titulo do documento vazio com espaço")
	@Test
	void criarTituloComTituloDoDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo(" ", "TITULO", 5, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando o valor vazio com espaço")
	@Test
	void criarTituloComValorVazioComESpaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", " ", 5, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando prioridade 0")
	@Test
	void criarTituloComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "TITULO", 0, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando nível 0")
	@Test
	void criarTituloComNivelZero() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "TITULO", 5, 0, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando prioridade negativa")
	@Test
	void criarTituloComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "TITULO", -1, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando nível negativo")
	@Test
	void criarTituloComNivelNegativo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "TITULO", 5, -1, false));
		assertEquals(out, e.getMessage());
	}
	
	
	@DisplayName("Criar titulo passando prioridade acima de 5")
	@Test
	void criarTituloComPrioridadeAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "TITULO", 6, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando nível acima de 5")
	@Test
	void criarTituloComNivelAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTitulo("titulo", "TITULO", 5, 6, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo passando titulo de documento que não existe")
	@Test
	void criarTituloComTituloDoDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarTitulo("tituloDocNaoExiste", "TITULO", 2, 5, false));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar titulo com sucesso com prioridade no limite menor (1)")
	@Test
	void criarTituloComPrioridadeNoLimiteMenor() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTitulo("titulo", "TITULO", 1, 4, false));
	}
	
	@DisplayName("Criar titulo com sucesso com prioridade no limite maior (5)")
	@Test
	void criarTituloComPrioridadeNoLimiteMaior() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTitulo("titulo", "TITULO", 2, 5, false));
	}
	
	@DisplayName("Criar titulo com sucesso com nivel no limite menor (1)")
	@Test
	void criarTituloComNivelNoLimiteMenor() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTitulo("titulo", "TITULO", 2, 1, false));
	}
	
	@DisplayName("Criar titulo com sucesso com nivel no limite maior (5)")
	@Test
	void criarTituloComNivelComLimiteMaior() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTitulo("titulo", "TITULO", 1, 5, false));
	}
	
	@DisplayName("Criar titulo com sucesso com linkavel true")
	@Test
	void criarTituloComNivelComLinkavelTrue() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTitulo("titulo", "TITULO", 1, 5, true));
	}
	
	//Testes para criar lista
	
	@DisplayName("Criar lista passando o titulo do documento nulo")
	@Test
	void criarListaComTituloDoDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarLista(null, "valor | da | lista", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o valor nulo")
	@Test
	void criarListaComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarLista("titulo", null, 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o separador nulo")
	@Test
	void criarListaComSeparadorNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 2, null, "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o caractere nulo")
	@Test
	void criarListaComCaractereNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 2, "|", null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o titulo do documento vazio")
	@Test
	void criarListaComTituloDoDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("", "valor | da | lista", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando valor vazio")
	@Test
	void criarListaComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o separador vazio")
	@Test
	void criarListaComSeparadorVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 2, "", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o caractere vazio")
	@Test
	void criarListaComCaractereVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 2, "|", ""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o titulo do documento vazio com espaço")
	@Test
	void criarListaComTituloDoDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista(" ", "valor | da | lista", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando valor vazio com espaço")
	@Test
	void criarListaComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", " ", 2, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o separador vazio com espaço")
	@Test
	void criarListaComSeparadorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 2, " ", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o caractere vazio com espaço")
	@Test
	void criarListaComCaractereVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 2, "|", " "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o prioridade 0")
	@Test
	void criarListaComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 0, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando o prioridade acima de 5")
	@Test
	void criarListaComPrioridadeAcimaCinco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 6, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista passando titulo de documento que não existe")
	@Test
	void criarListaComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarLista("titulo", "valor | da | lista", 5, "|", "-"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar lista com sucesso com prioridade no limite menor (1)")
	@Test
	void criarListaComSucessoComPrioridadeUM() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarLista("titulo", "valor | da | lista", 1, "|", "-"));
	}
	
	@DisplayName("Criar lista com sucesso com prioridade no limite maior (5)")
	@Test
	void criarListaComSucessoComPrioridadeCinco() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarLista("titulo", "valor | da | lista", 5, "|", "-"));
	}
	
	//Testes para criar termos
	
	@DisplayName("Criar termos com titulo do documento nulo")
	@Test
	void criarTermosComTituloDoDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTermos(null, "Teste / Termos / Aleatórios", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com valor nulo")
	@Test
	void criarTermosComValorNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTermos("titulo", null, 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com separador nulo")
	@Test
	void criarTermosComSeparadorNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, null, "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem nulo")
	@Test
	void criarTermosComOrdemNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "/", null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com titulo do documento vazio")
	@Test
	void criarTermosComTituloDoDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("", "Teste / Termos / Aleatórios", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com valor vazio")
	@Test
	void criarTermosComValorVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com separador vazio")
	@Test
	void criarTermosComSeparadorVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem vazia")
	@Test
	void criarTermosComOrdemVazia() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "/", ""));
		assertEquals(out, e.getMessage());
	}
	
	
	@DisplayName("Criar termos com titulo do documento vazio com espaço")
	@Test
	void criarTermosComTituloDoDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos(" ", "Teste / Termos / Aleatórios", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com valor vazio com espaço")
	@Test
	void criarTermosComValorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", " ", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com separador vazio com espaço")
	@Test
	void criarTermosComSeparadorVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, " ", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem vazia com espaço")
	@Test
	void criarTermosComOrdemVaziaComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "/", " "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com ordem diferente de NENHUMA, TAMANHO, ALFABÉTICA")
	@Test
	void CriarTermosComOrdemDiferente() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "/", "diferente"));
		assertEquals(out, e.getMessage());
	}	
	
	@DisplayName("Criar termos com prioridade 0")
	@Test
	void criarTermosComPrioridadeZero() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 0, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com prioridade negativa")
	@Test
	void criarTermosComPrioridadeNegativa() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", -1, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com titulo de documento que não existe")
	@Test
	void criarTermosComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarTermos("tituloDeDocumentoQueNaoExiste", "Teste / Termos / Aleatórios", 2, "/", "TAMANHO"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar termos com sucesso com prioridade no limite menor (1)")
	@Test
	void criarTermosComPrioridadeUm() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 1, "/", "TAMANHO"));
	}
	
	@DisplayName("Criar termos com sucesso com prioridade no limite maior (5)")
	@Test
	void criarTermosComPrioridadeCinco() {
		documentoController.criarDocumento("titulo");
		assertEquals(0, documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 5, "/", "TAMANHO"));
	}
	
	@DisplayName("Criar termos com sucesso com ordem ALFABÉTICA")
	@Test
	void criarTermosComOrdemAlfabetica() {
		String out = "Aleatórios / termos / Teste";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Teste / Aleatórios / termos", 5, "/", "ALFABÉTICA");
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}
	
	//Testes para gerar representação completa
	
	@DisplayName("Gerar representação completa passando o titulo do documento nulo")
	@Test
	void gerarRepresentacaoCompletaComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.gerarRepresentacaoCompleta(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa passando o titulo do documento vazio")
	@Test
	void gerarRepresentacaoCompletaComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.gerarRepresentacaoCompleta("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa passando o titulo do documento vazio com espaço")
	@Test
	void gerarRepresentacaoCompletaComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.gerarRepresentacaoCompleta(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa passando id do elemento negativo")
	@Test
	void gerarRepresentacaoCompletaComIdDoElementoNegativo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.gerarRepresentacaoCompleta("titulo", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa passando titulo de documento que não existe")
	@Test
	void gerarRepresentacaoCompletaComComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.gerarRepresentacaoCompleta("tituloQueNaoExiste", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa passando id do elemento passando da quantidade de elementos que o documento possui")
	@Test
	void gerarRepresentacaoCompletaComComIdDoElementoExcedentoAQuantidadeDeElementos() {
		String out = "O ELEMENTO NÃO EXISTE";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "TEXTO", 2);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documentoController.gerarRepresentacaoCompleta("titulo", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação completa com sucesso com elemento texto")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoTexto() {
		String out = "TEXTO";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "TEXTO", 2);
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}
	
	@DisplayName("Gerar representação completa com sucesso com elemento titulo não linkavel")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoTituloNaoLinkavel() {
		String out = "5. teste";
		documentoController.criarDocumento("titulo");
		documentoController.criarTitulo("titulo", "teste", 2, 5, false);
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}	
	
	@DisplayName("Gerar representação completa com sucesso com elemento titulo linkavel")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoTituloLinkavel() {
		String out = "5. Teste de titulo --" + System.lineSeparator() + "5-TESTEDETITULO";
		documentoController.criarDocumento("titulo");
		documentoController.criarTitulo("titulo", "Teste de titulo", 2, 5, true);
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}	
	
	@DisplayName("Gerar representação completa com sucesso com elemento lista")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoLista() {
		String out = "- Valor" + System.lineSeparator() + "- de uma" + System.lineSeparator() + "- lista";
		documentoController.criarDocumento("titulo");
		documentoController.criarLista("titulo", "Valor | de uma | lista", 2, "|", "-");
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}	
		
	@DisplayName("Gerar representação completa com sucesso com elemento termos com ordem NENHUMA")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoTermosComOrdemNenhuma() {
		String out = "Total de termos: 3" + System.lineSeparator() + "Teste, Termos, Aleatórios";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "/", "NENHUMA");
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}	
	
	@DisplayName("Gerar representação completa com sucesso com elemento termos com ordem TAMANHO")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoTermosComOrdemTamanho() {
		String out = "Total de termos: 3" + System.lineSeparator() + "Aleatórios, Testando, Termos";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Testando / Termos / Aleatórios", 2, "/", "TAMANHO");
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}	
	
	@DisplayName("Gerar representação completa com sucesso com elemento termos com ordem ALFABÉTICA")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoTermosComOrdemAlfabetica() {
		String out = "Total de termos: 3" + System.lineSeparator() + "Aleatórios, Termos, Testando";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Testando / Termos / Aleatórios", 2, "/", "ALFABÉTICA");
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}	
	
	@DisplayName("Gerar representação completa com sucesso com elemento atalho")
	@Test
	void gerarRepresentacaoCompletaComSucessoComElementoAtalho() {
		String out = "texto" + System.lineSeparator() + "5. texto2";
		documentoController.criarDocumento("tituloDoc");
		documentoController.criarDocumento("tituloDoc2");
		documentoController.criarTexto("tituloDoc2", "texto", 5);
		documentoController.criarTitulo("tituloDoc2", "texto2", 4, 5, false);
		documentoController.criarAtalho("tituloDoc", "tituloDoc2");
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("tituloDoc", 0));
	}	
	
	//Testes para gerar representação resumida
	
	@DisplayName("Gerar representação resumida passando o titulo do documento nulo")
	@Test
	void gerarRepresentacaoResumidaComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.gerarRepresentacaoResumida(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação resumida passando o titulo do documento vazio")
	@Test
	void gerarRepresentacaoResumidaComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.gerarRepresentacaoResumida("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação resumida passando o titulo do documento vazio com espaço")
	@Test
	void gerarRepresentacaoResumidaComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.gerarRepresentacaoResumida(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação resumida passando id do elemento negativo")
	@Test
	void gerarRepresentacaoResumidaComIdDoElementoNegativo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.gerarRepresentacaoResumida("titulo", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação resumida passando titulo de documento que não existe")
	@Test
	void gerarRepresentacaoResumidaComComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.gerarRepresentacaoResumida("tituloQueNaoExiste", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação resumida passando id do elemento passando da quantidade de elementos que o documento possui")
	@Test
	void gerarRepresentacaoResumidaComComIdDoElementoExcedentoAQuantidadeDeElementos() {
		String out = "O ELEMENTO NÃO EXISTE";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "TEXTO", 2);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documentoController.gerarRepresentacaoResumida("titulo", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Gerar representação resumida com sucesso com elemento texto")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoTexto() {
		String out = "TEXTO";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "TEXTO", 2);
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}
	
	@DisplayName("Gerar representação resumida com sucesso com elemento titulo não linkavel")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoTituloNaoLinkavel() {
		String out = "5. teste";
		documentoController.criarDocumento("titulo");
		documentoController.criarTitulo("titulo", "teste", 2, 5, false);
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}	
	
	@DisplayName("Gerar representação resumida com sucesso com elemento titulo linkavel")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoTituloLinkavel() {
		String out = "5. Teste de titulo";
		documentoController.criarDocumento("titulo");
		documentoController.criarTitulo("titulo", "Teste de titulo", 2, 5, true);
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}	
	
	@DisplayName("Gerar representação resumida com sucesso com elemento lista")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoLista() {
		String out = "Valor| de uma| lista";
		documentoController.criarDocumento("titulo");
		documentoController.criarLista("titulo", "Valor | de uma | lista", 2, "|", "-");
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}	
		
	@DisplayName("Gerar representação resumida com sucesso com elemento termos com ordem NENHUMA")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoTermosComOrdemNenhuma() {
		String out = "Teste / Termos / Aleatórios";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Teste / Termos / Aleatórios", 2, "/", "NENHUMA");
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}	
	
	@DisplayName("Gerar representação resumida com sucesso com elemento termos com ordem TAMANHO")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoTermosComOrdemTamanho() {
		String out = "Aleatórios / Testando / Termos";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Testando / Termos / Aleatórios", 2, "/", "TAMANHO");
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}
	
	@DisplayName("Gerar representação resumida com sucesso com elemento termos com ordem ALFABÉTICA")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoTermosComOrdemAlfabetica() {
		String out = "Aleatórios / Termos / Testando";
		documentoController.criarDocumento("titulo");
		documentoController.criarTermos("titulo", "Testando / Termos / Aleatórios", 2, "/", "ALFABÉTICA");
		assertEquals(out, documentoController.gerarRepresentacaoResumida("titulo", 0));
	}
	
	@DisplayName("Gerar representação resumida com sucesso com elemento atalho")
	@Test
	void gerarRepresentacaoResumidaComSucessoComElementoAtalho() {
		String out = "texto" + System.lineSeparator() + "texto2";
		documentoController.criarDocumento("tituloDoc");
		documentoController.criarDocumento("tituloDoc2");
		documentoController.criarTexto("tituloDoc2", "texto", 5);
		documentoController.criarTexto("tituloDoc2", "texto2", 4);
		documentoController.criarAtalho("tituloDoc", "tituloDoc2");
		assertEquals(out, documentoController.gerarRepresentacaoResumida("tituloDoc", 0));
	}	
	
	//Testes para contar elementos
	
	@DisplayName("Contar elementos passando titulo nulo")
	@Test
	void contarElementosComTituloNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.contarElementos(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Contar elementos passando titulo vazio")
	@Test
	void contarElementosComTituloVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.contarElementos(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Contar elementos passando titulo vazio com espaço")
	@Test
	void contarElementosComTituloVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.contarElementos(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Contar elementos passando titulo referente a documento que não existe")
	@Test
	void contarElementosComTituloDeDocumentoNaoExiste() {
		assertEquals(0, documentoController.contarElementos("tituloQueNaoTemDocumento"));
	}
	
	@DisplayName("Contar elementos com sucesso")
	@Test
	void contarElementosComSucesso() {
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		assertEquals(1, documentoController.contarElementos("titulo"));
	}
	
	//Testes para exibir o documento
	
	@DisplayName("Exibir documento com titulo nulo")
	@Test
	void exibirDocumentoComTituloNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.exibirDocumento(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir documento com titulo vazio")
	@Test
	void exibirDocumentoComTituloVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.exibirDocumento(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir documento com titulo vazio com espaço")
	@Test
	void exibirDocumentoComTituloVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.exibirDocumento(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir documento com titulo de documento que não existe")
	@Test
	void exibirDocumentoComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.exibirDocumento("tituloDoDocNaoExiste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir documento com sucesso")
	@Test
	void exibirDocumentoComSucesso() {
		String[] out = {"texto", "- valor" + System.lineSeparator() + "- da" + System.lineSeparator() + "- lista"};
		documentoController.criarDocumento("documento");
		documentoController.criarTexto("documento", "texto", 5);
		documentoController.criarLista("documento", "valor | da | lista", 3, "|", "-");
		assertTrue(Arrays.equals(out, documentoController.exibirDocumento("documento")));
	
	}
	
	//Testes para apagar elemento
	
	@DisplayName("Apagar elemento passando titulo do documento como nulo")
	@Test
	void apagarElementoComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.apagarElemento(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento passando titulo do documento vazio")
	@Test
	void apagarElementoComTituloDeDocumentoVazio(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.apagarElemento("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento passando titulo do documento vazio com espaço")
	@Test
	void apagarElementoComTituloDeDocumentoVazioComEspaco(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.apagarElemento(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento passando titulo de documento que não existe ")
	@Test
	void apagarElementoComTituloDeDocumentoQueNaoExiste(){
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.apagarElemento("tituloDeDocQueNaoExiste", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento passando id do elemento menor que 0")
	@Test
	void apagarElementoComIdDoElementoMenorQueZero(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.apagarElemento("titulo", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento passando id do elemento excedendo a quantidade de elementos")
	@Test
	void apagarElementoComIdDoElementoExcedendoAQuantidadeDeElementos(){
		String out = "O ELEMENTO NÃO EXISTE";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documentoController.apagarElemento("titulo", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Apagar elemento com sucesso")
	@Test
	void apagarElementoComSucesso(){
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		assertTrue(documentoController.apagarElemento("titulo", 0));
	}
	
	//Testes para mover para cima
	
	@DisplayName("Mover para cima passando titulo do documento como nulo")
	@Test
	void moverParaCimaComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.moverParaCima(null, 2));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima passando titulo do documento vazio")
	@Test
	void moverParaCimaComTituloDeDocumentoVazio(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaCima("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima passando titulo do documento vazio com espaço")
	@Test
	void moverParaCimaComTituloDeDocumentoVazioComEspaco(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaCima(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima passando titulo de documento que não existe ")
	@Test
	void moverParaCimaComTituloDeDocumentoQueNaoExiste(){
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.moverParaCima("tituloDeDocQueNaoExiste", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima passando id do elemento negativo")
	@Test
	void moverParaCimaComIdDoElementoNegativo(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaCima("titulo", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima passando id do elemento excedendo a quantidade de elementos")
	@Test
	void moverParaCimaComIdDoElementoExcedendoAQuantidadeDeElementos(){
		String out = "O ELEMENTO NÃO EXISTE";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documentoController.moverParaCima("titulo", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima quando é o primeiro elemento")
	@Test
	void moverParaCimaComPrimeiroElemento(){
		String out = "NÃO SE PODE MOVER PARA CIMA O PRIMEIRO ELEMENTO";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaCima("titulo", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para cima com sucesso")
	@Test
	void moverParaCimaComSucesso(){
		String out = "texto2";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		documentoController.criarTexto("titulo", "texto2", 3);
		documentoController.moverParaCima("titulo", 1);
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 0));
	}

	//Testes para mover para baixo
	
	@DisplayName("Mover para baixo passando titulo do documento como nulo")
	@Test
	void moverParaBaixoComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.moverParaBaixo(null, 2));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo passando titulo do documento vazio")
	@Test
	void moverParaBaixoComTituloDeDocumentoVazio(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaBaixo("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo passando titulo do documento vazio com espaço")
	@Test
	void moverParaBaixoComTituloDeDocumentoVazioComEspaco(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaBaixo(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo passando titulo de documento que não existe ")
	@Test
	void moverParaBaixoComTituloDeDocumentoQueNaoExiste(){
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.moverParaBaixo("tituloDeDocQueNaoExiste", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo passando id do elemento negativo")
	@Test
	void moverParaBaixoComIdDoElementoNegativo(){
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaBaixo("titulo", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo passando id do elemento excedendo a quantidade de elementos")
	@Test
	void moverParaBaixoComIdDoElementoExcedendoAQuantidadeDeElementos(){
		String out = "O ELEMENTO NÃO EXISTE";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> documentoController.moverParaBaixo("titulo", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo quando é o último elemento")
	@Test
	void moverParaBaixoComUltimoElemento(){
		String out = "NÃO SE PODE MOVER PARA BAIXO O ÚLTIMO ELEMENTO";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.moverParaBaixo("titulo", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Mover para baixo com sucesso")
	@Test
	void moverParaBaixoComSucesso(){
		String out = "texto";
		documentoController.criarDocumento("titulo");
		documentoController.criarTexto("titulo", "texto", 2);
		documentoController.criarTexto("titulo", "texto2", 3);
		documentoController.moverParaBaixo("titulo", 0);
		assertEquals(out, documentoController.gerarRepresentacaoCompleta("titulo", 1));
	}
	
	//Testes para criar atalho
	
	@DisplayName("Criar atalho com titulo do documento nulo")
	@Test
	void criarAtalhoComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		documentoController.criarDocumento("documento2");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarAtalho(null, "documento2"));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento referenciado nulo")
	@Test
	void criarAtalhoComTituloDeDocumentoReferenciadoNulo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		documentoController.criarDocumento("documento2");
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarAtalho("documento", null));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento vazio")
	@Test
	void criarAtalhoComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		documentoController.criarDocumento("documento2");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarAtalho("", "documento2"));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento referenciado vazio")
	@Test
	void criarAtalhoComTituloDeDocumentoReferenciadoVazio() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		documentoController.criarDocumento("documento2");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarAtalho("documento", ""));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento vazio com espaço")
	@Test
	void criarAtalhoComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		documentoController.criarDocumento("documento2");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarAtalho(" ", "documento2"));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento referenciado vazio com espaço")
	@Test
	void criarAtalhoComTituloDeDocumentoReferenciadoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("titulo");
		documentoController.criarDocumento("documento2");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarAtalho("documento", " "));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento que não existe")
	@Test
	void criarAtalhoComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		documentoController.criarDocumento("documento2");
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarAtalho("documentoQueNaoExiste", "documento2"));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com titulo do documento referenciado que não existe")
	@Test
	void criarAtalhoComTituloDeDocumentoReferenciadoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		documentoController.criarDocumento("documento");
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarAtalho("documento", "documentoQueNaoExiste"));;
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho com sucesso")
	@Test
	void criarAtalhoComSucesso() {
	documentoController.criarDocumento("documento");
	documentoController.criarDocumento("documento2");
	documentoController.criarTexto("documento2", "texto", 2);
	assertEquals(0, documentoController.criarAtalho("documento", "documento2"));
	}
	
	@DisplayName("Criar atalho em que documento referenciado não tem elementos")
	@Test
	void criarAtalhoComDocumentoReferenciadoSemElementos() {
	String out = "NÃO PODE SER ATALHO, MÉDIA COM DIVISÃO POR 0 (QUANTIDADE DE ELEMENTOS)";
	documentoController.criarDocumento("documento");
	documentoController.criarDocumento("documento2");
	ArithmeticException e = assertThrows(ArithmeticException.class, () -> documentoController.criarAtalho("documento", "documento2"));
	assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho quando documento referenciado já tem atalho")
	@Test
	void criarAtalhoComDocumentoReferenciadoPossuindoAtalho() {
	String out = "O DOCUMENTO REFERENCIADO JÁ POSSUI UM ATALHO";
	documentoController.criarDocumento("documento");
	documentoController.criarDocumento("documento2");
	documentoController.criarDocumento("documento3");
	documentoController.criarTexto("documento3", "texto", 1);
	documentoController.criarAtalho("documento2", "documento3");
	IllegalStateException e = assertThrows(IllegalStateException.class, () -> documentoController.criarAtalho("documento", "documento2"));
	assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar atalho quando documento é um atalho de outro documento")
	@Test
	void criarAtalhoComDocumentoJaAtalhoDeOutroDocumento() {
	String out = "O DOCUMENTO É UM ATALHO, LOGO NÃO PODE TER ATALHOS ADICIONADOS";
	documentoController.criarDocumento("documento1");
	documentoController.criarDocumento("documento2");
	documentoController.criarDocumento("documento3");
	documentoController.criarTexto("documento1", "texto", 1);
	documentoController.criarAtalho("documento3", "documento1");
	IllegalStateException e = assertThrows(IllegalStateException.class, () -> documentoController.criarAtalho("documento1", "documento2"));
	assertEquals(out, e.getMessage());
	}
	
	//Testes para cirar visão completa
	
	@DisplayName("Criar visão completa com titulo do documento nulo")
	@Test
	void criarVisaoCompletaComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarVisaoCompleta(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão completa com titulo do documento vazio")
	@Test
	void criarVisaoCompletaComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoCompleta(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão completa com titulo do documento vazio com espaço")
	@Test
	void criarVisaoCompletaComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoCompleta(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão completa com titulo de documento que não existe")
	@Test
	void criarVisaoCompletaComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarVisaoCompleta("documentoQueNaoExiste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão completa com sucesso")
	@Test
	void criarVisaoCompletaComSucesso() {
		documentoController.criarDocumento("documento");
		assertEquals(0, documentoController.criarVisaoCompleta("documento"));
	}
	
	//Testes para criar visão resumida
	
	@DisplayName("Criar visão resumida com titulo do documento nulo")
	@Test
	void criarVisaoResumidaComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarVisaoResumida(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão resumida com titulo do documento vazio")
	@Test
	void criarVisaoResumidaComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoResumida(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão resumida com titulo do documento vazio com espaço")
	@Test
	void criarVisaoResumidaComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoResumida(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão resumida com titulo de documento que não existe")
	@Test
	void criarVisaoResumidaComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarVisaoResumida("documentoQueNaoExiste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão resumida com sucesso")
	@Test
	void criarVisaoResumidaComSucesso() {
		documentoController.criarDocumento("documento");
		assertEquals(0, documentoController.criarVisaoResumida("documento"));
	}
	
	//Testes para criar visão prioritária
	
	@DisplayName("Criar visão prioritaria com titulo do documento nulo")
	@Test
	void criarVisaoPrioritariaComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarVisaoPrioritaria(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com titulo do documento vazio")
	@Test
	void criarVisaoPrioritariaComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoPrioritaria("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com titulo do documento vazio com espaço")
	@Test
	void criarVisaoPrioritariaComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoPrioritaria(" ", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com id de elemento zero")
	@Test
	void criarVisaoPrioritariaComIdDeElementoZero() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("documento");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoPrioritaria("documento", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com id de elemento negativo")
	@Test
	void criarVisaoPrioritariaComIdDeElementoNegativo() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("documento");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoPrioritaria("documento", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com id de elemento acima de 5")
	@Test
	void criarVisaoPrioritariaComIdDeElementoAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		documentoController.criarDocumento("documento");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoPrioritaria("documento", 6));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com titulo de documento que não existe")
	@Test
	void criarVisaoPrioritariaComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarVisaoPrioritaria("documentoQueNaoExiste", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão prioritaria com sucesso com prioridade no limite menor (1)")
	@Test
	void criarVisaoPrioritariaComSucessoComPrioridadeUm() {
		documentoController.criarDocumento("documento");
		assertEquals(0, documentoController.criarVisaoPrioritaria("documento", 1));
	}
	
	@DisplayName("Criar visão prioritaria com sucesso com prioridade no limite maior (5)")
	@Test
	void criarVisaoPrioritariaComSucessoComPrioridadeCinco() {
		documentoController.criarDocumento("documento");
		assertEquals(0, documentoController.criarVisaoPrioritaria("documento", 5));
	}
	
	//Testes para criar visão título
	
	@DisplayName("Criar visão titulo com titulo do documento nulo")
	@Test
	void criarVisaoTituloComTituloDeDocumentoNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> documentoController.criarVisaoTitulo(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão titulo com titulo do documento vazio")
	@Test
	void criarVisaoTituloComTituloDeDocumentoVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoTitulo(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão titulo com titulo do documento vazio com espaço")
	@Test
	void criarVisaoTituloComTituloDeDocumentoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> documentoController.criarVisaoTitulo(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão titulo com titulo de documento que não existe")
	@Test
	void criarVisaoTituloComTituloDeDocumentoQueNaoExiste() {
		String out = "O DOCUMENTO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.criarVisaoTitulo("documentoQueNaoExiste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar visão titulo com sucesso")
	@Test
	void criarVisaoTituloComSucesso() {
		documentoController.criarDocumento("documento");
		assertEquals(0, documentoController.criarVisaoTitulo("documento"));
	}
	
	//Testes para exibir visão
	
	@DisplayName("Exibir visão com idVisao menor que zero")
	@Test
	void exibirVisaoComIdVisaoMenorQueZero() {
		String out = "A VISÃO NÃO EXISTE";
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.exibirVisao(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir visão com idVisao excedendo a quantidade de visoes")
	@Test
	void exibirVisaoComIdVisaoExcedendoQuantidadeDeVisoes() {
		String out = "A VISÃO NÃO EXISTE";
		documentoController.criarDocumento("documento");
		documentoController.criarTexto("documento", "texto", 1);
		NoSuchElementException e = assertThrows(NoSuchElementException.class, () -> documentoController.exibirVisao(1));
		assertEquals(out, e.getMessage());
	}
		
	@DisplayName("Exibir visão com sucesso com visao completa")
	@Test
	void exibirVisaoComSucessoComVisaoCompleta(){
		String[] out = {"texto", "1. titulo", "- valor" + System.lineSeparator() + "- da" + System.lineSeparator() + "- lista", "Total de termos: 3" + System.lineSeparator() + "Aleatorios, Termos, Teste"};
		documentoController.criarDocumento("documento");
		documentoController.criarTexto("documento", "texto", 1);
		documentoController.criarTitulo("documento", "titulo", 1, 1, false);
		documentoController.criarLista("documento", "valor| da| lista", 1, "|", "-");
		documentoController.criarTermos("documento", "Teste / Termos / Aleatorios", 2, "/", "ALFABÉTICA");
		documentoController.criarVisaoCompleta("documento");
		assertTrue(Arrays.equals(out, documentoController.exibirVisao(0)));
	}
	
	@DisplayName("Exibir visão com sucesso com visao resumida")
	@Test
	void exibirVisaoComSucessoComVisaoResumida(){
		String[] out = {"texto", "1. titulo", "valor| da| lista", "Aleatorios / Termos / Teste"};
		documentoController.criarDocumento("documento");
		documentoController.criarTexto("documento", "texto", 1);
		documentoController.criarTitulo("documento", "titulo", 1, 1, false);
		documentoController.criarLista("documento", "valor| da| lista", 1, "|", "-");
		documentoController.criarTermos("documento", "Teste / Termos / Aleatorios", 2, "/", "ALFABÉTICA");
		documentoController.criarVisaoResumida("documento");
		assertTrue(Arrays.equals(out, documentoController.exibirVisao(0)));
	}
	
	@DisplayName("Exibir visão com sucesso com visão prioritaria")
	@Test
	void exibirVisaoComSucessoComVisaoPrioritaria(){
		String[] out = {"texto", "1. titulo"};
		documentoController.criarDocumento("documento");
		documentoController.criarTexto("documento", "texto", 3);
		documentoController.criarTitulo("documento", "titulo", 5, 1, false);
		documentoController.criarLista("documento", "valor| da| lista", 1, "|", "-");
		documentoController.criarTermos("documento", "Teste / Termos / Aleatorios", 2, "/", "ALFABÉTICA");
		documentoController.criarVisaoPrioritaria("documento", 3);
		assertTrue(Arrays.equals(out, documentoController.exibirVisao(0)));
	}
	
	@DisplayName("Exibir visão com sucesso com visão titulo")
	@Test
	void exibirVisaoComSucessoComVisaoTitulo(){
		String[] out = {"1. titulo"};
		documentoController.criarDocumento("documento");
		documentoController.criarTexto("documento", "texto", 3);
		documentoController.criarTitulo("documento", "titulo", 5, 1, false);
		documentoController.criarLista("documento", "valor| da| lista", 1, "|", "-");
		documentoController.criarTermos("documento", "Teste / Termos / Aleatorios", 2, "/", "ALFABÉTICA");
		documentoController.criarVisaoTitulo("documento");
		assertTrue(Arrays.equals(out, documentoController.exibirVisao(0)));
	}
	


	
	
	
	
	
	
	
	
	
	
}	



	

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

