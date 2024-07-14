package documin.modelo;

/**
 * Classe texto
 * Um tipo de Elemento
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Texto extends Elemento {
	
	/**
	 * Passa as variáveis para o construtor de elemento
	 * @param valor Valor do texto/elemento
	 * @param prioridade Prioridade do texto/elemento
	 */
	public Texto(String valor, int prioridade){
		super(valor, prioridade);
		
	}
	
	/**
	 * Representação completa do texto
	 * Ex: valor: texto
	 * representação completa: texto
	 * @return representação completa no modelo acima
	 */
	public String gerarRepresentacaoCompleta() {
		return valor;
	}
	
	/**
	 * Representação resumida do texto
	 * Ex: valor: texto
	 * representação resumia: texto
	 * @return representação resumida no modelo acima
	 */
	public String gerarRepresentacaoResumida() {
		return valor;
	}
	
	/**
	 * Get de prioridade
	 * @return prioridade do texto/elemento
	 */
	public int getPrioridade() {
		return prioridade;
	}
}
