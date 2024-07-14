package documin.controllers;
import documin.modelo.*;
import java.util.*;
import documin.validaEntrada.*;
/**
 * Classe DocumentoController
 * Um controlador para o Documin que gerencia a classe Documento e as demais classes no geral 
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class DocumentoController {
	
	/**
	 * documentos é a variável que armazena o mapa com todos os documentos
	 * visoes é a variável que armazena a lista com todas as visões
	 */
	private Map<String, Documento> documentos;
	private List<Visao> visoes;
	
	/**
	 * Construtor, apenas instancia as variáveis
	 */
	public DocumentoController() {
		documentos = new HashMap<String, Documento>();
		visoes = new ArrayList<>();
		
	}
	
	/**
	 * Método para criar um documento
	 * Primeiro valida o tituloDoc, depois verifica se não existe documento com esse nome. Caso não, cria o documento, salva no mapa e retorna true.
	 * Caso exista documento, não faz operação e retorna false
	 * @param tituloDoc Título do documento a ser criado
	 * @return true se documento criado com sucesso, false se não.
	 */
	public boolean criarDocumento(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
		if (!verificarSeDocumentoExiste(tituloDoc)) {
			
			Documento documento = new Documento(tituloDoc);
			documentos.put(tituloDoc, documento);
			return true;
			
		}
		return false;
	}
	
	/**
	 * Método para criar um documento com tamanho limite 
	 * Este criarDocumento passa o tamanho máximo de um documento, isto é, a maior quantidade de elementos que um documento pode ter
	 * Primeiro as entradas são validadas, então há a verificação caso o documento já exista, se sim retorna false.
	 * Se não, o documento é criado com um tamanho limite, salvo no mapa e retorna true.
	 * @param tituloDoc Título do documento a ser criado
	 * @param tamanhoMaximo Máximo de elementos que o documento pode ter
	 * @return true se documento criado, false se não.
	 */
	public boolean criarDocumento(String tituloDoc, Integer tamanhoMaximo) {
		Validador.validaEntrada(tituloDoc, tamanhoMaximo);
		if (!verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = new Documento(tituloDoc, tamanhoMaximo); 
			documentos.put(tituloDoc, documento);
			return true;	
		}
		return false;
	}
	
	/**
	 * Método para remover um documento
	 * Primeiro a entrada é validada e passa pela verificaçaõ caso o documento não exista. Se o documento não existir, um NoSuchElementException("NÃO HÁ DOCUMENTO PARA SER REMOVIDO") é lançado
	 * Caso o documento exista, ele é removido do mapa e retorna true
	 * @param tituloDoc Título do documento a ser removido
	 * @return true se removido.
	 */
	public boolean removerDocumento(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
		if (!verificarSeDocumentoExiste(tituloDoc)) {
			throw new NoSuchElementException("NÃO HÁ DOCUMENTO PARA SER REMOVIDO");
		}
		documentos.remove(tituloDoc);
		return true;
	}
	/**
	 * Método para contar elementos de um documento
	 * Primeiro valida a entrada e verifica se o documento existe, se existe puxa o documento do mapa e retorna quantos elementos possui
	 * @param tituloDoc Título do documento que irá ter seus elementos contados
	 * @return A quantidade de elementos que o documento possui, caso o documento exista. Caso não, retorna 0.
	 */
	public int contarElementos(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			return documento.getPosicao();
		}
		return 0;
	}
	
	/**
	 * Método para exibir um documento
	 * Primeiro valida a entrada e verifica se o documento exista, caso não exista é lançado um NoSuchElementException("O DOCUMENTO NÃO EXISTE"), caso
	 * exista, puxa o documento no mapa e chama o método exibir() da classe Documento, referente a representação completa de cada elemento do documento.
	 * @param tituloDoc Título do documento
	 * @return um String[] em que cada elemento é a representação completa de cada elemento do documento
	 */
	public String[] exibirDocumento(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
		if (verificarSeDocumentoExiste(tituloDoc)) {
			return documentos.get(tituloDoc).exibir();
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
		
	}
	
	/**
	 * Método para criar elemento texto em um documento
	 * Primeiro valida a entrada para o titulo do documento e verifica se o documento existe. Caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, um objeto Texto() é criado com as demais entradas e salvo no documento, cujo foi puxado pelo titulo passado anteriormente.
	 * @param tituloDoc Título do documento
	 * @param valor Valor do texto que o objeto Texto vai ter
	 * @param prioridade Prioridade do elemento Texto que está sendo criado, inteiro de 1 a 5
	 * @return retorna a posição que esse elemento texto está em relação aos elementos do documento. Com 0 sendo o primeiro elemento
	 */
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		
		Validador.validaEntrada(tituloDoc);
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			
			Elemento texto = new Texto(valor, prioridade);
			return documento.criarElemento(texto);
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
		
	}
	/**
	 * Método para criar elemento titulo em um documento.
	 * Primeiro valida a entrada para o titulo do documento e verifica se o documento existe. Caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, um objeto Titulo() é criado com as demais entradas e salvo no documento, cujo foi puxado pelo titulo passado anteriormente.
	 * @param tituloDoc Título do documento
	 * @param valor Valor do título que o objeto Título irá ter
	 * @param prioridade Prioridade do elemento Título que está sendo criado, inteiro de 1 a 5
	 * @param nivel Nível do título, inteiro de 1 a 5
	 * @param linkavel Se o título é linkavel, booleano que irá alterar a representação completa e resumida do título 
	 * @return Retorna a posição que esse elemento ttitulo está em relação aos elementos do documento. Com 0 sendo o primeiro elemento
	 */
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
		
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Elemento titulo = new Titulo(valor, prioridade, nivel, linkavel);
			return documento.criarElemento(titulo);
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para criar elemento lista em um documento 
	 * Primeiro valida a entrada para o titulo do documento e verifica se o documento existe. Caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, um objeto Lista() é criado com as demais entradas e salvo no documento, cujo foi puxado pelo titulo passado anteriormente. 
	 * @param tituloDoc Título do documento
	 * @param valorLista Valor da lista que o objeto Lista() irá ter
	 * @param prioridade Prioridade do elemento Lista() que está sendo criado, inteiro de 1 a 5
	 * @param separador Separador da lista, onde a lista irá ser dividida
	 * @param charLista String que irá ser utilizada para exibir a lista, na frente de cada elemento na representação completa
	 * @return Retorna a posição que esse elemento lista está em relação aos elementos do documento. Com 0 sendo o primeiro elemento
	 */
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
		
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Elemento lista = new Lista(valorLista, prioridade, separador, charLista);
			
			return documento.criarElemento(lista);
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método que irá criar elemento termos no documento
	 * Primeiro valida a entrada para o titulo do documento e verifica se o documento existe. Caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, um objeto Termos() é criado com as demais entradas e salvo no documento, cujo foi puxado pelo titulo passado anteriormente. 
	 * @param tituloDoc Título do documento 
	 * @param valorTermos Valor dos termos que o objeto Termos() irá ter
	 * @param prioridade Prioridade do elemento Termos() que está sendo criado, inteiro de 1 a 5
	 * @param separador Separador dos termos, onde os termos irão ser divididos
	 * @param ordem A ordem que os termos serão exibidos. NENHUMA, ALFABÉTICA OU TAMANHO
	 * @return Retorna a posição que esse elemento termos está em relação aos elementos do documento. Com 0 sendo o primeiro elemento 
	 */
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Elemento termos = new Termos(valorTermos, prioridade, separador, ordem);
			return documento.criarElemento(termos);
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para gerar a representação completa de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, puxa o documento no mapa pelo tituloDoc e faz a validaçao do elementoPosicao, caso nenhum erro seja encontrado, puxa o elemento do documento
	 * pela posição e gera sua representação completa. 
	 * @param tituloDoc Título do documento
	 * @param elementoPosicao Posição do elemento no documento
	 * @return A representação completa do elemento que foi pedido
	 */
	public String gerarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Validador.validarEVerificarSeElementoExiste(documento.getElementos().size(), elementoPosicao);
			Elemento elemento = documento.getElementos().get(elementoPosicao);
			return elemento.gerarRepresentacaoCompleta();
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
		
	}
	
	/**
	 * Método para gerar a representação resumida de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, puxa o documento no mapa pelo tituloDoc e faz a validaçao do elementoPosicao, caso nenhum erro seja encontrado, puxa o elemento do documento
	 * pela posição e gera sua representação resumida.
	 * @param tituloDoc Titulo do documento
	 * @param elementoPosicao Posição do elemento no documento
	 * @return A representaçãp resumida do elemento que foi pedido
	 */
	public String gerarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Validador.validarEVerificarSeElementoExiste(documento.getElementos().size(), elementoPosicao);
			Elemento elemento = documento.getElementos().get(elementoPosicao);
			return elemento.gerarRepresentacaoResumida();
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para apagar um elemento de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, puxa o documento no mapa pelo tituloDoc e faz a validaçao do elementoPosicao, caso nenhum erro seja encontrado, chama o método apaggarElemento()
	 * da classe Documento e por fim o elemento é apagado.
	 * @param tituloDoc Titulo do documento
	 * @param elementoPosicao Posiçaõ do elemento no documento
	 * @return true se nenhum erro/exceção for lançado
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao){
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			
			Documento documento = documentos.get(tituloDoc);
			Validador.validarEVerificarSeElementoExiste(documento.getElementos().size(), elementoPosicao);
			if (documento.getElementos().get(elementoPosicao) instanceof Atalho) {
				documento.diminuiContadorAtalhos();
			}
			return documento.apagarElemento(elementoPosicao);
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
		
	}
	
	/**
	 * Método para mover um elemento para cima
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, puxa o documento no mapa pelo tituloDoc e faz a validaçao do elementoPosicao, caso nenhum erro seja encontrado, chama o método moverParaCima()
	 * da classe Documento, fazendo assim, a troca de posição para cima do elemento do documento. Vale ressaltar que se o elementoPosicao for 0, não é movido para cima. 
	 * @param tituloDoc Titulo do documento
	 * @param elementoPosicao Posição do elemento no documento
	 */
	public void moverParaCima(String tituloDoc, Integer elementoPosicao) {
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Validador.validarEVerificarSeElementoExiste(documento.getElementos().size(), elementoPosicao);
			documento.moverParaCima(elementoPosicao);
		
		}
		else {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");		
		}
	}
	/**
	 * Método para mover um elemento para cima
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, puxa o documento no mapa pelo tituloDoc e faz a validaçao do elementoPosicao, caso nenhum erro seja encontrado, chama o método moverParaBaixo()
	 * da classe Documento, fazendo assim, a troca de posição para cima do elemento do documento. Vale ressaltar que se o elementoPosicao for a última posiçao,
	 * o elemento não é movido para baixo.  
	 * @param tituloDoc Titulo do documento
	 * @param elementoPosicao Posição do elemento no documento
	 */
	public void moverParaBaixo(String tituloDoc, Integer elementoPosicao) {
		Validador.validaEntrada(tituloDoc);
		
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Validador.validarEVerificarSeElementoExiste(documento.getElementos().size(), elementoPosicao);
			documento.moverParaBaixo(elementoPosicao);
		
		}
		else {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
		}
	}
	/**
	 * Método para criar elemento atalho em um documento
	 * Primeiro valida a entrada do titulo do documento e do titulo do documento referenciado, após verifica se eles existem, caso não existam 
	 * um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado. Se os dois existem, puxa o documento que vai ser atalho e verifica
	 * se ele possui algum elemento que seja atalho. Se sim, um IllegalStateException("O DOCUMENTO REFERENCIADO JÁ POSSUI UM ATALHO")  é lançado.
	 * Se não, o documento que irá ter o atalho adicionado é puxado do mapa e verifica se ele é atalho de algum documento, se sim um 
	 * IllegalStateException("O DOCUMENTO É UM ATALHO, LOGO NÃO PODE TER ATALHOS ADICIONADOS") é lançado. Caso não, o objeto Atalho() finalmente
	 * é criado e adicionado no documento.
	 * @param tituloDoc Titulo do documento que irá ter um atalho como elemento
	 * @param tituloReferenciado Titulo do documento que irá ser atalho
	 * @return Retorna a posição que o elemento atalho ficou no documento. 0 caso a primeira
	 */
	public int criarAtalho(String tituloDoc, String tituloReferenciado) {
		Validador.validaEntrada(tituloDoc, tituloReferenciado);
		if (verificarSeDocumentoExiste(tituloDoc, tituloReferenciado)) {
			Documento documentoAtalho = documentos.get(tituloReferenciado);
			for (int i = 0; i<documentoAtalho.getElementos().size(); i++) {
				Elemento elemento = documentoAtalho.getElementos().get(i);
				if (elemento instanceof Atalho) {
					throw new IllegalStateException("O DOCUMENTO REFERENCIADO JÁ POSSUI UM ATALHO");
				}
			}
			
			Documento documento = documentos.get(tituloDoc);
			
			if (documento.getCountAtalhos() == 0) {
				Integer media = calculaMediaPrioridade(documentoAtalho);
				Elemento atalho = new Atalho(tituloReferenciado, media, documentoAtalho);
				documentoAtalho.aumentaContadorAtalhos();
				return documento.criarElemento(atalho); 
			}
			
			throw new IllegalStateException("O DOCUMENTO É UM ATALHO, LOGO NÃO PODE TER ATALHOS ADICIONADOS");
		}
		
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para criar uma visão completa de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, o obejto VisaoCompleta() é criado referente ao documento que foi puxado no mapa com o tituloDoc passado pelo usuário. E então a visão é 
	 * adicionada na lista de visões
	 * @param tituloDoc Título do documento que irá ter uma visão completa
	 * @return Retorna a posição da visão completa que foi criada na lista de visões
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
			
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Visao visao = new VisaoCompleta(documento);
			visoes.add(visao);
			return visoes.size()-1;
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para criar uma visão resumida de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, o obejto VisaoResumida() é criado referente ao documento que foi puxado no mapa com o tituloDoc passado pelo usuário. E então a visão é 
	 * adicionada na lista de visões
	 * @param tituloDoc Título do documento que irá ter uma visão resumida
	 * @return Retorna a posição da visão resumida que foi criada na lista de visões
	 */
	public int criarVisaoResumida(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
			
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Visao visao = new VisaoResumida(documento);
			visoes.add(visao);
			return visoes.size()-1;
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para criar uma visão prioritária  de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, o obejto VisaoPrioritaria() é criado com a prioridade passada pelo usuário, criado referente ao documento que foi puxado no mapa com 
	 * o tituloDoc passado pelo usuário. E então a visão é adicionada na lista de visões
	 * @param tituloDoc Título do documento que irá ter uma visão prioritária 
	 * @param prioridade Prioridade que irá ser usada de paramêtro no objeto VisaoPrioritaria() para exibir apenas os elementos com prioridade maior 
	 * que essa prioridade passada
	 * @return Retorna a posiçaõ da visão prioritária que foi criada na lista de visões
	 */
	public int criarVisaoPrioritaria(String tituloDoc, Integer prioridade) {
		Validador.validaEntrada(tituloDoc);
			
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Visao visao = new VisaoPrioritaria(documento, prioridade);
			visoes.add(visao);
			return visoes.size()-1;
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para criar uma visão titulo  de um documento
	 * Primeiro valida a entrada do titulo do documento e verifica se ele existe, caso não exista um NoSuchElementException("O DOCUMENTO NÃO EXISTE") é lançado
	 * Caso exista, o obejto VisaoTitulo() é criado referente ao documento que foi puxado no mapa com o tituloDoc passado pelo usuário. E então a visão é 
	 * adicionada na lista de visões.
	 * @param tituloDoc Titulo do documento que irá ter a visão título
	 * @return Retorna a posiçaõ da visão titulo que foi criada na lista de visões
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
			
		if (verificarSeDocumentoExiste(tituloDoc)) {
			Documento documento = documentos.get(tituloDoc);
			Visao visao = new VisaoTitulo(documento);
			visoes.add(visao);
			return visoes.size()-1;
		}
		throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE");
	}
	
	/**
	 * Método para exibir visão de documento
	 * Primeiro valida a entrada do visaoId, caso a visão não exista um NoSuchElementException("A VISÃO NÃO EXISTE") é lançado
	 * então puxa a visão pelo visaoId na lista visoes e chama seu método exibir
	 * @param visaoId Id da visão que quer ser exibida
	 * @return Array de String da representão completa e/ ou resumida, dependendo da visão, de cada elemento que deve ser exibido.
	 */
	public String[] exibirVisao(int visaoId) {
		if (verificarSeIdVisaoValido(visaoId)) {
			Visao visao = visoes.get(visaoId);
			return visao.exibir();	
		}
		throw new NoSuchElementException("A VISÃO NÃO EXISTE");
	}
	
	/**
	 * Método privado para calcular a média das prioridades dos elementos
	 * Vale ressaltar que caso o documento não tenha elementos, sua média é 0 então um ArithmeticException("NÃO PODE SER ATALHO, MÉDIA COM DIVISÃO POR 0 (QUANTIDADE DE ELEMENTOS)")
	 * é lançado.
	 * @param documento Documento que a média das prioridades dos elementos seão calculadas
	 * @return Retorna a média das prioridades dos elementos
	 */
	private Integer calculaMediaPrioridade(Documento documento) {
		int quant = 0;
		int soma = 0;
		
		for (int i = 0; i<documento.getElementos().size(); i++) {
			soma += documento.getElementos().get(i).getPrioridade();
			quant += 1;
		}
		if (quant == 0) {
			throw new ArithmeticException("NÃO PODE SER ATALHO, MÉDIA COM DIVISÃO POR 0 (QUANTIDADE DE ELEMENTOS)");
		}
		int media = soma/quant;
		return media;
		
	}
	
	/**
	 * Método privado para verificar se o documento existe
	 * @param tituloDoc Titulo do documento
	 * @return true, se o titulo é alguma chave do mapa documentos. false, se não.
	 */
	private boolean verificarSeDocumentoExiste(String tituloDoc) {
		Validador.validaEntrada(tituloDoc);
		if (documentos.containsKey(tituloDoc)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método privado para verificar se dois documentos existem
	 * @param tituloDoc Titulo do documento 1
	 * @param tituloDoc2 Titulo do documento 2 
	 * @return true, se os dois titulos são chaves do mapa documentos. false, se pelo menos um não.
	 */
	private boolean verificarSeDocumentoExiste(String tituloDoc, String tituloDoc2) {
		Validador.validaEntrada(tituloDoc, tituloDoc2);
		if (documentos.containsKey(tituloDoc) && documentos.containsKey(tituloDoc2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método privado para verificar se visaoId está dentro de um intervalo. Entre 0 e a quantidade de visoes-1
	 * @param visaoId visaoId
	 * @return true se está dentro do intervalo, false se não.
	 */
	private boolean verificarSeIdVisaoValido(int visaoId) {
		if (visaoId>=0 && visaoId<visoes.size()) {
			return true;
		}
		return false;
	}
	
}
