package documin.modelo;

/**
 * Classe VisaoCompleta
 * Um tipo de Visao
 * @author oem José Jardel Alves de Medeiros
 */
public class VisaoCompleta extends Visao {
	
	/**
	 * Construtor
	 * Passa o documento para o construtor de Visao
	 * @param documento Documento da visão
	 */
	public VisaoCompleta(Documento documento) {
		super(documento);
		
	}
	
	/**
	 * Método para exibir uma visão
	 * @return retorna um array de string em que cada elemento do array é a representação completa de cada elemento do documento 
	 */
	@Override
	public String[] exibir() {
		String[] saida = new String[this.documento.getElementos().size()];
		
		for (int i = 0; i<this.documento.getElementos().size(); i++) {
			saida[i] = this.documento.getElementos().get(i).gerarRepresentacaoCompleta();
		}
		return saida;
	}
	
}
