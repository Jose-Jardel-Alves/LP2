package documin.modelo;

/**
 * Classe VisaoResumida
 * Um tipo de Visao
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class VisaoResumida extends Visao{
	
	/**
	 * Construtor
	 * Documento é passado para construtor de Visao
	 * @param documento documento que a visão irá ser baseada
	 */
	public VisaoResumida(Documento documento) {
		super(documento);
	}
	
	/**
	 * Método para exibir a VisaoResumida
	 * @return Retorna um array de string em que cada elemento do array é a representação resumida
	 * de cada elemento do documento
	 */
	@Override
	public String[] exibir() {
	String[] saida = new String[this.documento.getElementos().size()];
		
		for (int i = 0; i<this.documento.getElementos().size(); i++) {
			saida[i] = this.documento.getElementos().get(i).gerarRepresentacaoResumida();
		}
		return saida;
	}

}
