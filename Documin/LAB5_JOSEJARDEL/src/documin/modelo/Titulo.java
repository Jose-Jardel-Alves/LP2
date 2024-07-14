package documin.modelo;
import documin.validaEntrada.Validador;

/**
 * Classe Titulo
 * Um tipo de elemento
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Titulo extends Elemento{
	

	/**
	 * Construtor
	 * As entradas são validadas e as variáveis inicializadas, o que não é prioridade e valor, entra no mapa
	 * @param valor valor do titulo/elemento
	 * @param prioridade prioridade do titulo/elemento, inteiro de 1 a 5 
	 * @param nivel nivel do titulo, inteiro de 1 a 5
	 * @param linkavel boolenao linkavel para saber se o titulo é linkavel ou não
	 */
	public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		Validador.validaEntradaIntervaloUmACinco(nivel);
		this.propriedades.put("nivel", Integer.toString(nivel));
		this.propriedades.put("linkavel", Boolean.toString(linkavel));
		
	}
	
	/**
	 * Gera a representação completa do titulo
	 * Ex:
	 * valor = titulo
	 * nivel = 2
	 * Se linkavel = true
	 * representacao completa = 2. titulo 
	 * 							2-TITULO
	 * Se linkavel = false
	 * representação completa = 2. titulo  
	 * @return representação completa no modelo acima
	 */
	public String gerarRepresentacaoCompleta() {
		boolean linkavel = Boolean.valueOf(propriedades.get("linkavel"));
		
		if (linkavel) {
			return propriedades.get("nivel") + ". " + valor +  " --" + System.lineSeparator() + propriedades.get("nivel") + "-" + valor.replaceAll(" ", "").toUpperCase();
		}
		else {
			return propriedades.get("nivel") + ". " + valor;
		}
		
	}
	/**
	 * Gera a representação resumida do titulo
	 * Ex: valor = titulo
	 * nivel = 2
	 * representacao resumida: 2. titulo
	 * @return representação resumida no modelo acima
	 */
	public String gerarRepresentacaoResumida() {
		return propriedades.get("nivel") + ". " + valor;
	}
	
	/**
	 * Get de prioridade 
	 * @return prioridade do titulo/elemento
	 */
	public int getPrioridade() {
		return this.prioridade;
	}
	

}
