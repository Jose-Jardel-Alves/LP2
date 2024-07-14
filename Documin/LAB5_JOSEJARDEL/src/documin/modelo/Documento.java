package documin.modelo;
import documin.validaEntrada.*;
import java.util.*;

/**
 * Classe Documento
 * Uma classe que representa um documento que pode ter elementos dos tipos texto, titulo, lista, termos e atalho. 
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Documento {
	/**
	 * titulo é a variável que armazena o título do documento
	 * tamanho é a variável quea armazena o tamanho limite - caso tenha - do máximo de elementos que o documento pode ter
	 * posicao é a variável que armazena a posicao que o elemento que irá ser criado vai ser armazenado
	 * countAtalhos é a variável que armazena a quantidade de vezea que o documento virou atalho de um outro documento
	 * elementos é a variável que armazena a lista de elementos que o documento possui
	 */
	private String titulo;
	private Integer tamanho;
	private Integer posicao;
	private Integer countAtalhos;
	private List<Elemento> elementos;
	
	/**
	 * Construtor sem passar o tamanho de um documento
	 * Valida o titulo e inicia as variáveis
	 * @param titulo Título do documento
	 */
	public Documento(String titulo) {
		Validador.validaEntrada(titulo);
		this.titulo = titulo;
		this.tamanho = 0;
		this.posicao = 0;
		this.countAtalhos = 0;
		elementos = new ArrayList<Elemento>();
	}
	/**
	 * Construtor passando o tamanho limite da quantidade de elementos que um documento pode ter
	 * Valida o titulo e o tamanho e inicia as variáveis
	 * @param titulo Título do documento
	 * @param tamanho Tamano limite da quantidade de elementos
	 */
	public Documento(String titulo, Integer tamanho) {
		Validador.validaEntrada(titulo, tamanho);
		this.titulo = titulo;
		this.tamanho = tamanho;
		this.posicao = 0;
		this.countAtalhos = 0;
		elementos = new ArrayList<Elemento>();
	}
	/**
	 * Get de posicao
	 * @return valor da variavel posicao
	 */
	public int getPosicao() {
		return this.posicao;
	}
	
	/**
	 * Get de countAtalhos
	 * @return valor da variável countAtalhos
	 */
	public int getCountAtalhos() {
		return this.countAtalhos;
	}
	
	/**
	 *Incrementa em um a variável countAtalhos 
	 */
	public void aumentaContadorAtalhos() {
		this.countAtalhos += 1;
	}
	
	/**
	 * Decrementa em um a variável atalhos
	 */
	public void diminuiContadorAtalhos() {
		this.countAtalhos -= 1;
	}
	
	/**
	 * Get de elementos
	 * @return retorna a lista de elementos, o valor da variável elementos
	 */
	public List<Elemento> getElementos(){
		return elementos;
	}
	
	/**
	 * Método para adicionar um elemento na lista elementos
	 * Se o tamanho for 0, apenas adiciona o elemento, retorna a posicao que foi adicionado, ainda incrementando 1 na variável posicao
	 * Se tamaho diferente de 0 e posicao menor que tamanho, adiciona  o elemento, retorna a posicao que foi adicionado, ainda incrementando 1 na variável posicao
	 * Se tamanho diferente de 0 e maior/igual a tamanho um ArrayIndexOutOfBoundsException("NÃO PODE MAIS ADICIONAR ELEMENTO") é lançado
	 * @param elemento Elemento que irá ser adicionado
	 * @return Retorna a posição que o elemento foi adicionado
	 */
	public int criarElemento(Elemento elemento){
		if (tamanho==0) {                                                                                                                                                               
			elementos.add(elemento);
			return posicao++;
		}
		else {
			if (posicao<tamanho){
				elementos.add(elemento);
				return posicao++;
			}
			throw new ArrayIndexOutOfBoundsException("NÃO PODE MAIS ADICIONAR ELEMENTO");	
		}
	}
	
	/**
	 * Método para mover elemento para cima
	 * Faz a validaçaõ e verifica se o elemento está no intervalo possível de mover para cima
	 * Mover o elemento a uma posiçaõ acima na lista de elementos, caso o elemento esteja na posiçaõ 0 um IllegalArgumentException("NÃO SE PODE MOVER PARA CIMA O PRIMEIRO ELEMENTO") 
	 * é lançado
	 * @param elementoPosicao Posição em que o elemento está
	 */
	public void moverParaCima(Integer elementoPosicao) {
		Validador.validarEVerificarSeElementoExiste(elementos.size(), elementoPosicao);
		if (elementoPosicao>0 && elementoPosicao<elementos.size()) {
			Collections.swap(elementos, elementoPosicao, elementoPosicao-1);
		}
		else{
			throw new IllegalArgumentException("NÃO SE PODE MOVER PARA CIMA O PRIMEIRO ELEMENTO");
		}
		
		
		
	}
	
	/**
	 * Método para mover elemento para baixo
	 * Faz a validaçaõ e verifica se o elemento está no intervalo possível de mover para baixo
	 * Mover o elemento a uma posiçaõ abaixo na lista de elementos, caso o elemento esteja na última posiçaõ um IllegalArgumentException("NÃO SE PODE MOVER PARA CIMA O PRIMEIRO ELEMENTO") 
	 * é lançado
	 * @param elementoPosicao Posição em que o elemento está
	 * @param elementoPosicao
	 */
	public void moverParaBaixo(Integer elementoPosicao) {
		Validador.validarEVerificarSeElementoExiste(elementos.size(), elementoPosicao);
		if (elementoPosicao>= 0 && elementoPosicao<elementos.size()-1) {			
			Collections.swap(elementos, elementoPosicao, elementoPosicao+1);
		}
		if (elementoPosicao == elementos.size()-1) {
			throw new IllegalArgumentException("NÃO SE PODE MOVER PARA BAIXO O ÚLTIMO ELEMENTO");
		}
	}
	
	/**
	 * Método para exibir o documento
	 * Varre a lista de elementos e retorna um array de String em que cada elemento do array é a representação completa de cada elemento do documento
	 * @return Retorna o array de String com a  representação completa de cada elemento do documento
	 */
	public String[] exibir() {
		String[] exibir = new String[elementos.size()];
		
		for (int i = 0; i<elementos.size(); i++) {
			exibir[i] = elementos.get(i).gerarRepresentacaoCompleta();
		}
		return exibir;
	}
	
	/**
	 * Método para apagar elemento do documento 
	 * Primeiro faz a validação do idPosicao e verifica se ele é menor que a quantidade de elementos, se não um IndexOutOfBoundsException("NÃO EXISTE ELEMENTO NESSA POSIÇÃO")
	 * Se sim, o elemento é puxado da lista de elementos pela idPosicao e apagado da lista, retornando true
	 * @param idPosicao id do elemento que irá ser apagado
	 * @return true true quando removido
	 */
	public boolean apagarElemento(int idPosicao) {
		Validador.validarElemento(idPosicao);
		if(idPosicao<elementos.size()) {
			Elemento elemento = elementos.get(idPosicao);
			return elementos.remove(elemento);
		}
		throw new IndexOutOfBoundsException("NÃO EXISTE ELEMENTO NESSA POSIÇÃO");
		
		
		
	}
}
