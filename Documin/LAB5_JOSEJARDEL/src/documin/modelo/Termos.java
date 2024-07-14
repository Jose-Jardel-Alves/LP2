package documin.modelo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import documin.validaEntrada.Validador;

/**
 * Classe Termos
 * Um tipo de elemento
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Termos extends Elemento {
	
	/**
	 * Construtor
	 * Valida as entradas e inicializa as variáveis, o que não é prioridade e valor, entra no mapa
	 * @param valorTermos valor do elemento/termos
	 * @param prioridade prioridade do elemento/termos
	 * @param separador separador dos termos, onde o valorTermos irá ser quebrado para fazer uma lista
	 * @param ordem a ordem que os termos irão ser exibidas. ALFABÉTICA, TAMANHO, NENHUMA.
	 */
	public Termos(String valorTermos, int prioridade, String separador, String ordem) {
		super(valorTermos, prioridade);
		Validador.validaEntrada(separador, ordem);
		verificarOrdem(ordem.toUpperCase());
		this.propriedades.put("separador", separador);
		this.propriedades.put("ordem", ordem.toUpperCase());
	}
	
	/**
	 * Método para gerar representação completa dos termos
	 * Ex de valorTermos: termos / Aleatórios / Testando
	 * Ordem: ALFABÉTICA
	 * representação completa: Total de termos: 3
	 * 							Aleatórios, termos, Testando
	 *  Ordem: TAMANHO
	 * representação completa: Total de termos: 3
	 * 							Aleatórios, Testando, termos
	 *  Ordem: NENHUMA
	 * representação completa: Total de termos: 3
	 * 							termos, Aleatórios, Testando
	 * @return representação completa no modelo acima
	 */
	public String gerarRepresentacaoCompleta() {
		List<String> valoresSeparados = escolherOrdenacao(this.valor);
		String representacaoCompleta = "Total de termos: " + Integer.toString(valoresSeparados.size()) + System.lineSeparator();
		
		for (int i = 0; i<valoresSeparados.size(); i++) {
			if (i!=valoresSeparados.size()-1) {
				representacaoCompleta += valoresSeparados.get(i).trim() + ", ";	
			}
			else {
				representacaoCompleta += valoresSeparados.get(i).trim();
			}
			
		}
		return representacaoCompleta;
	}
	
	/**
	 * Método para gerar representação resumida dos termos
	 * Ex de valorTermos: termos / Aleatórios / Testando
	 * Ordem: ALFABÉTICA
	 * representação resumida: Aleatórios / termos / Testando
	 *  Ordem: TAMANHO
	 * representação resumida: Aleatórios / Testando / termos
	 *  Ordem: NENHUMA
	 * representação resumida: termos / Aleatórios / Testando
	 * @return representação resumida no modelo acima
	 */
	
	public String gerarRepresentacaoResumida() {
		String representacaoResumida = "";
		List<String> valoresSeparados = escolherOrdenacao(this.valor);
		for (int i = 0; i<valoresSeparados.size(); i++) {
			if (i!=valoresSeparados.size()-1) {
				representacaoResumida += valoresSeparados.get(i).trim() + " / ";
			}
			else{
				representacaoResumida += valoresSeparados.get(i).trim();
			}
		}
		return representacaoResumida;
	}
	/**
	 * Verificar se a ordem é diferente de TAMANHO, ALFABÉTICA E NENHUMA
	 * Se sum, um IllegalArgumentException("ENTRADA INVÁLIDA") é lançado
	 * @param ordem Ordem a ser verificada
	 */
	private void verificarOrdem(String ordem) {
		if (!ordem.equals("TAMANHO") && !ordem.equals("ALFABÉTICA") && !ordem.equals("NENHUMA")){
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	
	/**
	 * Método para escolher a ordenação e ordenar a lista de acordo com a ordem passada no construtor
	 * @param valorTermos valorTermos passado no construtor
	 * @return Lista com os elementos quebrados no separador e ordenados de acordo com a ordem passada
	 */
	private List<String> escolherOrdenacao(String valorTermos) {
		List<String> valoresSeparados = Arrays.asList(valor.split(propriedades.get("separador")));
		switch (propriedades.get("ordem")) {
			case "NENHUMA":
				break;
			case "ALFABÉTICA":  
				Collections.sort(valoresSeparados);
				break;
			case "TAMANHO":
				Collections.sort(valoresSeparados, Comparator.comparingInt(String::length).reversed());
				break;
		
		}
		return valoresSeparados;
		
		
	}
}
