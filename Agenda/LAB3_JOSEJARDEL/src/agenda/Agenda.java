package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Jardel
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos; 
	private Contato[] favoritos;
	
			//apenas uma simplificacao de contato

	/**
	 * Construtor
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];

	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	/**
	 * Get da lista de favoritos
	 * @return Retorna o array de favoritos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	/**
	 * Get de um contato específico acessando pela posição
	 * @param posicao Posição do contato que você quer 
	 * @return Retorna o contato que você quer. O "-1" é devido porque o usuário digita números de 1-100 e o array é de 0-99
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao-1];
	}
	
	

	/**
	 * Verifica se existe um contato naquele array de contatos
	 * @param contatoTemporario Contato que você quer verificar
	 * @param listaContatos Array de contatos que você quer saber se o contato está incluso
	 * @return true = se incluso. false, se não.
	 */
	private boolean existeContato(Contato contatoTemporario, Contato[] listaContatos) { //Função para verificar
		for (int i = 0; i<listaContatos.length; i++) {
			if (listaContatos[i] != null) {
				if (contatoTemporario.equals(listaContatos[i])) {
					return true;
				}
			}
		}
		return false;
		
	}
	/**
	 * Função para verificar se o nome, sobrenome ou telefone está null ou vazio("")
	 * @param contato Contato que é passado para fazer a verificação 
	 * @return true = se algum vazio("") ou null, false = se todos válidos.
	 */
	private boolean nomeSobrenomeTelefoneVazio(Contato contato) { //Função para verificar
		if (contato.getNome()== null || contato.getNome().equals("")) {
			return true;
		}
		else if(contato.getSobrenome() == null || contato.getSobrenome().equals("")){
			return true;
		}
		else if(contato.getTelefone() == null || contato.getTelefone().equals("")) {
			return true;
		}
		return false;
	}
	/**
	 * Função para cadastrar contato
	 * * A função faz um contatotemporário com os dados, caso passe pelas verificações de validar posição, se o contato já está cadastrado e de algum atributos vazio
	 * Ele cadastra no array de contatos. -1 porque o usuário trabalha com os índices de 1-100, enquanto o array de 0-99.
	 * @param posicao Posição do contato no array passada pelo usuário.
	 * @param nome Nome passado pelo usuário para cadastrar.
	 * @param sobrenome Sobrenome passado pelo usuário para cadastrar.
	 * @param telefone Telefone passado pelo usuário para cadastrar.
	 * @return POSIÇÃO INVÁLIDA = caso não esteja entre 1-100. CONTATO JÁ CADASTRADO = caso esteja presente no array de contatos. CONTATO CADASTRADO = caso passe pelas verificações e realize o cadastro
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato contatoTemporario = new Contato(nome.trim(), sobrenome.trim(), telefone);
		if (!validaPosicao(posicao, contatos.length)) {
			return "POSIÇÃO INVÁLIDA";
		}
		if (existeContato(contatoTemporario, contatos)) {
			return "CONTATO JÁ CADASTRADO";
		}
		if (nomeSobrenomeTelefoneVazio(contatoTemporario)) {
			return "CONTATO INVÁLIDO";
		}
		
		contatos[posicao-1] = new Contato(nome, sobrenome, telefone); 
		return "CONTATO CADASTRADO";
	}
	/**
	 * Função para adicionar o contato no array de favoritos
	 * A função verifica se o contato já ffoi favoritado, caso não verifica se possui algum outro contato na posição que o contato irá ser cadastrado. Se sim,
	 * chama a função removeFavorito e remove o contato do array de favoritos. Após isso, o contato que o usuário deseja cadastrar, será então cadastrado no array de favoritos.
	 * @param idContato Id do Contato passado pelo usuário
	 * @param posicao Posição que estará o contato no array de favoritos
	 * @return CONTATO FAVORITADO NA POSIÇÃO X = Contato foi favoritado com sucesso. CONTATO JÁ ESTÁ FAVORITADO = O contato já estava favoritado em uma das posições do array favoritos. 
	 */
	public String adcionaFavorito(int idContato, int posicao) {
		Contato contato = contatos[idContato-1];
		if (existeContato(contato, favoritos)) {
			return "CONTATO JÁ ESTÁ FAVORITADO";
		}
		if (verificarSeExisteContato(posicao, favoritos)) {
			removeFavorito(posicao);
		}
		favoritos[posicao-1] = contato;
		
		contato.setFavorito(true);
		return "CONTATO FAVORITADO NA POSIÇÃO " + Integer.toString(posicao);
	}
	/**
	 * Função para remover o contato do array de favoritos.
	 * A função primeiramente verifica se realmente existe um contato naquela posição para ser removido. Se sim, ele é retirado. O -1 é devido
	 * o usuário trabalhar com índices de 1-100, enquanto o array de 0-99.
	 * @param posicao Posição passada pelo usuário do contato que deseja remover
	 * @return Contato Removido = Caso tenha sido removido do array de favoritos. Não já contato nessa posição para remover = Não havia contato para remover em favoritos.
	 */
	public String removeFavorito(int posicao) {
		if (verificarSeExisteContato(posicao, favoritos)) {
			favoritos[posicao-1].setFavorito(false);
			favoritos[posicao-1] = null;
			return "Contato Removido";
		}
		return "Não há contato nessa posição para remover";
	
	}
	/**
	 * Função para verificar se índice está dentro daquele determinado intervalo.
	 * @param posicao Inteiro que irá ser avalisado se está dentro do intervalo.
	 * @param maximo O último inteiro(limite) que a posição pode ser.
	 * @return true = se dentro do intervalo. false = se não.
	 */
	public boolean validaPosicao(int posicao, int maximo) { //Função para verificar
		if (posicao < 1 || posicao > maximo) {
			return false;
		}
		return true;
		
	}
	/**
	 * Função para exibir contato.
	 * Primeiro verifica se a posição é válida, se sim, verifica se o contato existe, se sim, retorna os dados do contato.
	 * @param posicao Id do contato 
	 * @return Dados do contato {dados} = se o contato existe. CONTATO NÃO EXISTE = Contato não está cadastrado; POSIÇÃO INVÁLIDA = A posição passada não está dentro do intervalo 1-100
	 */
	public String exibirContato(int posicao){
		
		if (validaPosicao(posicao, contatos.length)) {
			boolean existeContato = verificarSeExisteContato(posicao, contatos);
			if (existeContato) {
				return "Dados do contato:\n" + contatos[posicao-1].exibeContato();
			}
			else {
				return "CONTATO NÃO EXISTE";
			}
		}
		else {
			return "POSIÇÃO INVÁLIDA";
		}
	
	}
	/**
	 * Função para verificar se o contato está dentro de um array de contatos. 
	 * @param posicao Posição que puxa o contato.
	 * @param listaDeContatos Array que irá ser passado para verificar se o contato está presente.
	 * @return true = se contato está incluso no array. false = se não.
	 */
	public boolean verificarSeExisteContato(int posicao, Contato[] listaDeContatos) { // Função para verificar
		if (listaDeContatos[posicao-1] != null) {
			return true;
		}
		return false;
	}

}
