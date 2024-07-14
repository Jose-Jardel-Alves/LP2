package documin.modelo;
import documin.validaEntrada.*;

import java.util.HashMap;
import java.util.Map;
/**
 * Classe elemento
 * Uma classe abstrata para ser elemento de um documento
 * @author oem José Jardel Alves de Medeiros
 *
 */
public abstract class Elemento {
	/**
	 * valor é a variável que armazena o valor do elemento
	 * prioridade  é a variável que armazena a prioridade do elemento
	 *  propriedades é a variável que armazena o mapa de propriedades do elemento 
	 */
	protected String valor;
	protected Integer prioridade;
	protected Map<String, String> propriedades;
	
	/**
	 * Construtor
	 * Valida as entradas e inicializa as variáveis
	 * @param valor Valor do elemento
	 * @param prioridade Prioridade do elemento
	 */
	public Elemento(String valor, int prioridade) {
		Validador.validaEntrada(valor, prioridade);
		Validador.validaEntradaIntervaloUmACinco(prioridade);
		this.valor = valor;
		this.prioridade = prioridade;
		this.propriedades = new HashMap<>();
	}
	
	/**
	 * Get de prioridade
	 * @return valor da prioridade do elemento
	 */
	public int getPrioridade() {
		return prioridade;
	}
	
	/**
	 * metodo abstract para gerar a representação completa
	 * @return string com a representação completa
	 */
	public abstract String gerarRepresentacaoCompleta();
	
	/**
	 * metodo abstract para gerar a representação resumida
	 * @return string com a representação resumida
	 */
	public abstract String gerarRepresentacaoResumida();
	
}


