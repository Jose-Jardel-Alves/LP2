package documin.modelo;

import documin.validaEntrada.Validador;

/**
 * Classe abstract Visao
 * @author oem José Jardel Alves de Medeiros
 *
 */
public abstract class Visao {
	/**
	 * documento é a variável que armazena o documento que a visão irá utilizar
	 */
	protected Documento documento;
	
	/**
	 * Constutor
	 * valida o documento e inicializa a variável
	 * @param documento
	 */
	public Visao(Documento documento) {
		Validador.validaEntrada(documento);
		this.documento = documento;
	}
	/**
	 * Método abstrato exibir
	 * @return array de strings da representação de cada elemento de acordo com a visão
	 */
	public abstract String[] exibir();
	
}
