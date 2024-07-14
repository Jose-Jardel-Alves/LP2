package modelo;

/**
 * Classe de Time 
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Time {
	/**
	 * codigo é a variável que vai armazenar o código do time
	 * nome é a variável que vai armazenar o nome do time
	 * mascote é a variável que vai armazenar o mascote do time
	 */
	private String codigo;
	private String nome;
	private String mascote;
	
	/**
	 * Construtor
	 * Faz validação da entrada antes, para então construir de fato
	 * @param codigo Código
	 * @param nome Nome
	 * @param mascote Mascote
	 */
	public Time(String codigo, String nome, String mascote) {
		validaEntradas(codigo, nome, mascote);
		this.codigo = codigo;		
		this.nome = nome;
		this.mascote = mascote;
	}

	
	/**
	 * Método para validar as entradas para saber se são nulas ou vazias
	 * @param codigo Código do time
	 * @param nome Nome do time
	 * @param mascote Mascote do time
	 */
	private void validaEntradas(String codigo, String nome, String mascote) {
		if (codigo == null || nome == null || mascote == null) {
			throw new NullPointerException("ENTRADAS INVÁLIDAS");
		}
		if (codigo.isBlank() || nome.isBlank() || mascote.isBlank()) {
			throw new IllegalArgumentException("ENTRADAS INVÁLIDAS");
		}
	}
	
	/**
	 * Get do código
	 * @return Código
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Get do nome
	 * @return Nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * ToString do Time
	 * @return Formato: [codigo] nome / mascote
	 */
	@Override
	public String toString() {
		return "[" + codigo + "] " + nome + " / " + mascote;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
