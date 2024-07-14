package documin.modelo;
import java.util.ArrayList;

import documin.validaEntrada.Validador;

/**
 * Classe VisaoPrioritaria
 * Um tipo de Visao
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class VisaoPrioritaria extends Visao {
	
	/**
	 * prioridade é a variável que armazena a prioridae que a visão irá se basear para exibir
	 */
	private int prioridade;
	
	/**
	 * Construtor
	 * valida as entradas e inicializa as variáveis 
	 * @param documento documento que a visão irá se basear
	 * @param prioridade prioridade que a visão prioritária irá se basear
	 */
	public VisaoPrioritaria(Documento documento, Integer prioridade) {
		super(documento);
		Validador.validaEntradaIntervaloUmACinco(prioridade);
		this.prioridade = prioridade;
	}

	/**
	 * Método para exibir a visão
	 * @return Retorna um array de string em que cada elemento do array é a representação completa
	 * de cada elemento com a prioridade maior ou igual a prioridade passada no construtor 
	 */
	@Override
	public String[] exibir() {
		ArrayList<String> saidaLista = new ArrayList<>();
		for (int i = 0; i < this.documento.getElementos().size(); i++) {
			if (this.documento.getElementos().get(i).getPrioridade()>=this.prioridade) {
				saidaLista.add(this.documento.getElementos().get(i).gerarRepresentacaoCompleta());
				
			}
		}
		String[] saida = new String[saidaLista.size()];
		saidaLista.toArray(saida);
		return saida;
	}
	
	
}
