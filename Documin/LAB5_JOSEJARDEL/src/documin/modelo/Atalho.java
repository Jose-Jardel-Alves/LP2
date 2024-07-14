package documin.modelo;

/**
 * Classe atalho, um tipo de elemento para a classe Documento
 * @author oem  José Jardel ALves de Medeiros
 *
 */
public class Atalho extends Elemento{
	/**
	 * documento é a variável que armazena o documento no qual o atalho está sendo referenciado
	 */
	private Documento documento;
	
	/**
	 * Construtor
	 * Apenas inicializa as variáveis
	 * @param tituloReferenciado Valor do elemento, titulo do documento referenciado
	 * @param media media das prioridades do documento, prioridade do elemento
	 * @param documento documento referenciado
	 */
	public Atalho(String tituloReferenciado, Integer media, Documento documento) {
		super(tituloReferenciado, media);
		this.documento = documento;
	}
	
	/**
	 * Gera a representação completa do atalho, que consistem em gerar a representação completa de cada elemento do documento com prioridade
	 * acima ou igual a 4.
	 * @return representação completa do atalho
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		String representacaoCompleta = "";
		for (int i = 0; i< documento.getElementos().size(); i++) {
			Elemento elemento = documento.getElementos().get(i); 
			if (elemento.getPrioridade()>=4) {
				if (i == documento.getElementos().size() - 1) {
					representacaoCompleta += elemento.gerarRepresentacaoCompleta();
				}
				else {
					representacaoCompleta += elemento.gerarRepresentacaoCompleta() + System.lineSeparator();
				}
			}
		}
		return representacaoCompleta;
	}

	/**
	 *  Gera a representação resumida do atalho, que consistem em gerar a representação resumida de cada elemento do documento com prioridade
	 * acima ou igual a 4.
	 * @return representação resumida do atalho
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		String representacaoResumida = "";
		for (int i = 0; i< documento.getElementos().size(); i++) {
			Elemento elemento = documento.getElementos().get(i); 
			if (elemento.getPrioridade()>=4) {
				if (i == documento.getElementos().size() - 1) {
					representacaoResumida += elemento.gerarRepresentacaoResumida();
				}
				else {
					representacaoResumida += elemento.gerarRepresentacaoResumida() + System.lineSeparator();
				}
			}
		}
		return representacaoResumida;
	}
	
}
