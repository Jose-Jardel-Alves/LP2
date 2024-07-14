package documin;
import documin.controllers.DocumentoController;

/**
 * Classe Facade
 * @author oem José Jardel ALves de Medeiros
 *
 */
public class Facade {
	/**
	 * documentoController é a variável que armazena o controller
	 */
	private DocumentoController documentoController;
	
	/**
	 * Construtor
	 * Apenas inicializa a variável
	 */
	public Facade() {		
		this.documentoController = new DocumentoController();
	}
	
	/**
	 * Método para criar documento
	 * @param tituloDoc Título do documento
	 * @return true, se criado. false, se não.
	 */
    public boolean criarDocumento(String tituloDoc) {
        return this.documentoController.criarDocumento(tituloDoc);
    }
    
    /**
     * Método para criar documento passsando o tamanho
     * @param tituloDoc Título do documento
     * @param tamanhoMaximo Tamanho máximo da quantidade de elementos do documento
     * @return true, se documento criado. false, se não.
     */
    public boolean criarDocumento(String tituloDoc, int tamanhoMaximo) {
    	return this.documentoController.criarDocumento(tituloDoc, tamanhoMaximo);
    }
    
    /**
     * Método para remover um documento pelo título
     * @param tituloDoc Título do documento a ser removido
     */
    public void removerDocumento(String tituloDoc) {
    	this.documentoController.removerDocumento(tituloDoc);
    }
    
    /**
     * Método para contar os elementos de um documento
     * @param tituloDoc Título do documento
     * @return Quantidade de elementos que o documento possui
     */
    public int contarElementos(String tituloDoc) {
    	return this.documentoController.contarElementos(tituloDoc);
    }
    
    /**
     * Método para exibir documento
     * @param tituloDoc Título do documento
     * @return Array com a representação completa de cada elemento do documento
     */
    public String[] exibirDocumento(String tituloDoc) {
    	return this.documentoController.exibirDocumento(tituloDoc);
    }
    
    /**
     * Método para criar elemento texto em um documento 
     * @param tituloDoc Título do documento
     * @param valor Valor do texto
     * @param prioridade Prioridade do texto/elemento, inteiro de 1 a 5
     * @return posição do elemento texto que foi criado em relação a lista de elementos do documento
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
 	}
    
    /**
     * Método para criar elemento titulo em um documento 
     * @param tituloDoc Título de um documento
     * @param valor Valor do título/elemento
     * @param prioridade Prioridade do título/elemento, inteiro de 1 a 5
     * @param nivel Nível do título, inteiro de 1 a 5
     * @param linkavel Linkavel booleano para título ser linkavel ou não
     * @return posição do elemento título que foi criado em relação a lista de elementos do documento
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    
    /**
     * Método para criar elemento lista em um documento 
     * @param tituloDoc Título de um documento
     * @param valorLista Valor de uma lista/elemento
     * @param prioridade Prioridade da lista/elemento, inteiro de 1 a 5
     * @param separador Separador que o valorLista seŕa quebrado para exibição
     * @param charLista Caracter onde irá anteceder os elementos da lista na representação completa
     * @return posição do elemento lista que foi criado em relação a lista de elementos do documento
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    
    /**
     * Método para criar elemento termos em um documento 
     * @param tituloDoc Título de um documento
     * @param valorTermos Valor de termos/elemento
     * @param prioridade Prioridade de termos/elemento, inteiro de 1 a 5
     * @param separador Separador que o valorTermos seŕa quebrado para divisão de termos
     * @param ordem Ordem em que os valores serão exibidos. ALFABÉTICA, TAMANHO, NENHUMA
     * @return Posição do elemento termos que foi criado em relação a lista de elementos do documento
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    
    /**
     * Método para gerar a representação completa de um elemento
     * @param tituloDoc Título de um documento
     * @param elementoPosicao Posição do elemento a ser exibido na lista de elementos do documento
     * @return Representação completa do elemento
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.gerarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }
    /**
     * Método para gerar a representação resumida de um elemento
     * @param tituloDoc Título de um documento
     * @param elementoPosicao Título de um documento
     * @return Representação resumida do elemento
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.gerarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    
    /**
     * Método para apagar elemento
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento que vai ser apagado referente a lista de elementos do documento
     * @return true se apagado
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.apagarElemento(tituloDoc, elementoPosicao);
    }
    
    /**
     * Método para mover elemento para cima
     * Primeiro elemento não é afetado
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posiçaõ do elemento referente a lista de elementos do documento
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }
    
    /**
     * Método para mover elemento para baixo
     * Último elemento não é afetado
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento referente a lista de elementos do documento
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }
    
    /**
     * Método para criar atalho
     * @param tituloDoc Título de documento
     * @param tituloReferenciado Título do documento referenciado, que vai virar atalho
     * @return Posição do elemento atalho que foi criado em relação a lista de elementos do documento
     */
    public int criarAtalho(String tituloDoc, String tituloReferenciado) {
    	return this.documentoController.criarAtalho(tituloDoc, tituloReferenciado);
    }
    
    /**
     * Método para criar visão completa 
     * @param tituloDoc Título do documento que irá ser criado a visão
     * @return Posição da visão em relação a lista de visões 
     */
    public int criarVisaoCompleta(String tituloDoc) {
    	return documentoController.criarVisaoCompleta(tituloDoc);
    }
    
    /**
     * Método para criar visão resumida
     * @param tituloDoc Título do documento que irá ser criado a visão
     * @return Posição da visão em relação a lista de visões 
     */
    public int criarVisaoResumida(String tituloDoc) {
    	return documentoController.criarVisaoResumida(tituloDoc);
    }
    
    /**
     * Método para criar visão prioritaria
     * @param tituloDoc Título do documento que irá ser criado a visão
     * @param prioridade Prioridade que irá ser baseada na exibição dos elementos da visão
     * @return Posição da visão em relação a lista de visões 
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }
    
    /**
     * Método para criar visão título
     * @param tituloDoc Título do documento que irá ser criado a visão
     * @return Posição da visão em relação a lista de visões 
     */
    public int criarVisaoTitulo(String tituloDoc) {
    	return documentoController.criarVisaoTitulo(tituloDoc);
    }
    
    /**
     * Método para exibir visão
     * Exibe a visão de acordo com a posição da visão na lista de visões
     * @param visaoId Posição da visão em relação a lista de visões
     * @return Array de strings com cada elemento representado de acordo com o tipo da visão
     */
    public String[] exibirVisao(int visaoId) {
    	return documentoController.exibirVisao(visaoId);
    }
    
    
}

