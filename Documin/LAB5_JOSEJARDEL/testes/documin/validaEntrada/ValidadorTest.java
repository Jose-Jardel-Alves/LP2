package documin.validaEntrada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidadorTest {

	@DisplayName("validaEntrada(string) - vazio")
	@Test
	void validaEntradaStringVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string) - vazio com espaço")
	@Test
	void validaEntradaStringVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, string) - nulo")
	@Test
	void validaEntradaStringEStringComPrimeiraStringNula() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> Validador.validaEntrada(null, "teste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Validador (string, string) - primeira vazia")
	@Test
	void validaEntradaStringEStringComPrimeiraStringVazia() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada("", "teste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, string) - primeira vazia com espaço")
	@Test
	void validaEntradaStringEStringComPrimeiraStringVaziaComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada(" ", "teste"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, string) - segunda vazia")
	@Test
	void validaEntradaStringEStringComSegundaStringVazia() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada("teste", ""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, string) - segunda vazia com espaço")
	@Test
	void validaEntradaStringEStringComPrimeiraSegundaVaziaComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada("teste", " "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, Integer) - string nula")
	@Test
	void validaEntradaStringEIntegerComStringNula() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> Validador.validaEntrada(null, 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, Integer) - string vazia")
	@Test
	void validaEntradaStringEIntegerComStringVazia() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada("", 2));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, integer) - string vazia com espaço")
	@Test
	void validaEntradaStringEIntegerComStringVaziaComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada(" ", 1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, integer) - integer menor que 0")
	@Test
	void validaEntradaStringEIntegerComIntegerMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada("teste", -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada(string, integer) - integer 0")
	@Test
	void validaEntradaStringEIntegerComIntegerZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada("teste", 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validarEVerificarSeElementoExiste(integer, integer) - segundo integer menor que zero")
	@Test
	void validarEVerificarSeElementoExisteComSegundoIntegerMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validarEVerificarSeElementoExiste(2, -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validarEVerificarSeElementoExiste(integer, integer) - segundo integer maior que o primeiro, elementoPosicao>limite")
	@Test
	void validarEVerificarSeElementoExisteComSegundoIntegerMaiorQueOPrimeiro() {
		String out = "O ELEMENTO NÃO EXISTE";
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> Validador.validarEVerificarSeElementoExiste(2, 3));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validarElemento com integer menor que 0")
	@Test
	void validarElementoComIntegerMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validarElemento(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada com integer menor que 0")
	@Test
	void validaEntradaComIntegerMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntrada com integer 0")
	@Test
	void validaEntradaComIntegerZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntrada(0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntradaIntervaloUmACinco com integer 0")
	@Test
	void validaEntradaIntervaloUmACincoComIntegerZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntradaIntervaloUmACinco(0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntradaIntervaloUmACinco com integer menor que 0")
	@Test
	void validaEntradaIntervaloUmACincoComIntegerMenorQueZero() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntradaIntervaloUmACinco(-1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("validaEntradaIntervaloUmACinco com integer acima de cinco")
	@Test
	void validaEntradaIntervaloUmACincoComIntegerAcimaDeCinco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validador.validaEntradaIntervaloUmACinco(6));
		assertEquals(out, e.getMessage());
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
