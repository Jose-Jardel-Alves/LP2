package documin.modelo;

import documin.validaEntrada.Validador;

/**
 * Classe lista
 * Um tipo de Elemento
 * @author oem José Jardel ALves de Medeiros
 *
 */
public class Lista extends Elemento{
	
	/**
	 * Construtor
	 * Valida as entradas e inicializa as variaveis, o que não é prioridade e valor é salvo no mapa
	 * @param valorLista Valor do elemento/lista
	 * @param prioridade Prioridade do elemento/lista
	 * @param separador Separador da lista, onde a lista irá ser quebrada
	 * @param charLista caractere da lista
	 */
	public Lista(String valorLista, int prioridade, String separador, String charLista ) {
		super(valorLista, prioridade);
		Validador.validaEntrada(separador, charLista);
		this.propriedades.put("separador", separador);
		this.propriedades.put("charLista", charLista);
	}
	
	/**
	 * Representação completa da lista, faz uma array quebrando o valor da lista no separador
	 * Ex: 
	 * valor: valor / da / lista
	 * separador: /
	 * caractere: -
	 * representação completa	- valor
	 * 							- da
	 * 							- lista 
	 * @return a representação completa no formato acima
	 */
	public String gerarRepresentacaoCompleta() {
		String representacaoCompleta = "";
		String[] valoresSeparados = valor.split("\\" + propriedades.get("separador"));
		for (int i = 0; i<valoresSeparados.length; i++) {
			if (i== valoresSeparados.length -1) {
				representacaoCompleta += propriedades.get("charLista") + " " + valoresSeparados[i].trim();
			}
			else {
				representacaoCompleta += propriedades.get("charLista") + " " + valoresSeparados[i].trim() + System.lineSeparator();
			}
		}
		return representacaoCompleta;
	}
	
	/**
	 * Representação resumida da lista, faz uma array quebrando o valor da lista no separador
	 * Ex: 
	 * valor: valor / da / lista
	 * separador: /
	 * caractere: -
	 * representação resumida valor/ da/ lista
	 * @return a representação resumida no formato acima
	 */
	public String gerarRepresentacaoResumida() {
		String[] valoresSeparados = valor.split("\\" + propriedades.get("separador"));
		valoresSeparados[0] = valoresSeparados[0].trim();
		String representacaoResumida = valoresSeparados[0] + propriedades.get("separador") + " ";
		for (int i = 1; i<valoresSeparados.length; i++) {
			valoresSeparados[i] = valoresSeparados[i].trim();
			if (i == valoresSeparados.length-1) {
				representacaoResumida += valoresSeparados[i];
			}
			else {
				representacaoResumida += valoresSeparados[i] + propriedades.get("separador") + " ";	
			}
		}
		return representacaoResumida;
	}
	
}
