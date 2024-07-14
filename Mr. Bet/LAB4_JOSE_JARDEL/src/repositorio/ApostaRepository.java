package repositorio;
import modelo.Aposta;
import java.util.*;


/**
 * Classe para repositório de apostas
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class ApostaRepository {
	/**
	 * apostas é a variável que armazena o repositório, por meio de um ArrayList
	 */
	private List<Aposta> apostas;
	
	/**
	 * Construtor
	 */
	public ApostaRepository() {
		this.apostas = new ArrayList<Aposta>(); 
	}
	
	/**
	 * Método para adicionar uma aposta no repositório
	 * @param aposta Aposta feita
	 */
	public void registrarAposta(Aposta aposta) {
		apostas.add(aposta);
	}
	
	/**
	 * Método para validar o indice que não pode ser negativo
	 * @param indice Indice
	 */
	private void validaEntrada(int indice) {
		if (indice<=-1) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para pegar uma aposta específica pelo índice
	 * Faz a validação do índice e depois retorna a aposta específica
	 * @param indice Índice da aposta
	 * @return aposta específica armazenada no ArrayList no índice
	 */
	public Aposta apostaEspecifica(int indice){
		validaEntrada(indice);
		return apostas.get(indice);
	}
	
	/**
	 * Get de quantidade de apostas feitas
	 * @return A quantidade de apostas feitas
	 */
	public int getQuantidadeDeApostasFeitas() {
		return apostas.size();
	}
}

