package agenda;

import java.util.Objects;

/**
 * Uma classe referente a um contato.
 * @author Jardel
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private boolean favorito;

	/**
	 * Construtor
	 * @param nome nome
	 * @param sobrenome sobrenome
	 * @param telefone teelefone
	 */
	public Contato(String nome, String sobrenome, String telefone){
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.favorito = false;
		
	}
	/**
	 * Get de nome
	 * @return Retorna o nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Set de nome
	 * @param nome Novo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Get de sobrenome
	 * @return Retorna o sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * Get de favorito
	 * @return Retorna se está favorito ou não
	 */
	public boolean isFavorito() {
		return favorito;
	}
	/**
	 * Set de favorito, é alterado quando é adicionado ou removido da lista de favoritos
	 * @param favorito Favoritado = true. Não favoritado = false
	 */
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	/**
	 * Set de sobrenome
	 * @param sobrenome Novo sobrenome
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	/**
	 * Get de telefone
	 * @return Telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * Set de telefone
	 * @param telefone Novo telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * ToString
	 * @return "nome sobrenome"
	 */
	public String toString(){
		return this.nome + " " + this.sobrenome;
	}
	/**
	 * Função para exibir o contato.
	 * @return Caso esteja favoritado, retorna um coração com o nome, sobrenome e telefone na próxima linha. Caso não, retorna apenas nome, sobrenome e telefone
	 */
	public String exibeContato() {
		if (this.favorito) {
			return "❤️ " + this.nome + " " + this.sobrenome + System.lineSeparator() +
		 			this.telefone;
		}
		return this.nome + " " + this.sobrenome + System.lineSeparator() +
	 			this.telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}
	/**
	 * Sobrescrevendo a função equals, assim dois contatos são iguais se possuirem os mesmos nomes e sobrenomes.
	 * @return true = nome e sobrenome iguais. false = no mínimo o nome ou sobrenome diferentes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	

	
}