package documin.validaEntrada;

import documin.modelo.Documento;
/**
 * Classe Validador
 * Uma classe para validar as entradas do usuário
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Validador {
	
	/**
	 * Método para validar string
	 * Se string nula, um NullPointerException("ENTRADA INVÁLIDA") é lançado
	 * Se string vazia ou vazia com espaço, um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado 
	 * @param string String a ser validada
	 */
	public static void validaEntrada(String string) {
		if (string == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para validar documento
	 * Se documento nulo, um NullPointerException("ENTRADA INVÁLIDA") é lançado
	 * @param documento Documento a ser validado
	 */
	public static void validaEntrada(Documento documento) {
		if (documento == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para validar duas strings
	 * Se string1 ou string2 nulas, um NullPointerException("ENTRADA INVÁLIDA") é lançado
	 * Se string1 ou string2 vazias, um IllegalArgumentException("ENTRADA INVÁLIDA") é lamçado  
	 * @param string String1 a ser validada.
	 * @param string2 String2 a ser validada.
	 */
	public static void validaEntrada(String string, String string2) {
		if (string == null || string2 == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
		if (string.isBlank() || string2.isBlank()) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para validar string e inteiro
	 * Se string nula, um NullPointerException("ENTRADA INVÁLIDA") é lançado
	 * Se string vazia ou vazia com espaço, um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado 
	 * Se inteiro menor ou igual a 0 um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado
	 * @param string String a ser validada
	 * @param inteiro Integer a ser validada
	 */
	public static void validaEntrada(String string, Integer inteiro) {
		if (string == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
		if (string.isBlank()) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
		if (inteiro<=0) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}

	}
	
	/**
	 * Método para validar e verificar um elemento
	 * Valida o integer elementoPosicao
	 * Verifica se o elementoPosicao é diferente de 0, se sim, verifica se o elementoPosicao é maior que limite, caso sim, um IndexOutOfBoundsException("O ELEMENTO NÃO EXISTE") é lançado
	 * @param limite Limite/tamanho máximo do array de elementos
	 * @param elementoPosicao Posição do elemento
	 */
	public static void validarEVerificarSeElementoExiste(Integer limite, Integer elementoPosicao) {
		validarElemento(elementoPosicao);
		if (elementoPosicao != 0) {
			if (elementoPosicao>=limite) {
				throw new IndexOutOfBoundsException("O ELEMENTO NÃO EXISTE");
			}
		}
	}
	
	/**
	 * Método para validar elemento
	 * Se o elementoPosição for menor que 0, um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado
	 * @param elementoPosicao Posição do elemento a ser validado
	 */
	public static void validarElemento(Integer elementoPosicao) {
		if (elementoPosicao<0) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para validar entrada de inteiro
	 * Se o inteiro for menor/igual a 0, um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado
	 * @param inteiro Inteiro a ser validado
	 */
	public static void validaEntrada(Integer inteiro) {
		if (inteiro<=0) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para validar o intervalo de 1 a 5
	 * Se o inteiro estiver fora do intervalo de 1 a 5, um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado
	 * @param inteiro Inteiro a ser validao
	 */
	public static void validaEntradaIntervaloUmACinco(Integer inteiro) {
		if (inteiro<=0 || inteiro>5) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	
}
	