package repositorio;

import modelo.Time;
import java.util.*;
/**
 * Classe de repositório de times
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class TimeRepository {
	/**
	 * times é a variável que armazena os times cadastrados por meio de um HashMap 
	 */
	private Map<String, Time> times;
	
	/**
	 * Construtor
	 */
	public TimeRepository() {
		this.times = new HashMap<String, Time>();
	}
	
	/**
	 * Método para adicionar time no repositório/mapa
	 * Faz a validação para entradas nulas e vazias. Depois verifica se o time já existe, caso sim, não adiciona. Caso não, adiciona.
	 * @param codigo Código do time
	 * @param time O objeto time em si que vai ser adicionado
	 * @return Se o time já existe, "TIME JÁ EXISTE". Se não, "INCLUSÃO REALIZADA" 
	 */
	public String adicionarTime(String codigo, Time time) {
		validaEntrada(codigo);
		if (verificarSeTimeExiste(codigo)) {	
			return "TIME JÁ EXISTE";
		}
		this.times.put(codigo, time);
		return "INCLUSÃO REALIZADA";
	}
	
	/**
	 * Método para verificar se time já existe
	 * @param codigo Código do time que é a chave no mapa
	 * @return Se está cadastrado, True. Se não, False
	 */
	private boolean verificarSeTimeExiste(String codigo){
		if (this.times.containsKey(codigo)) {
			return true;
		};
		return false;
	}
	
	/**
	 * Método para validar entradas nulas ou vazias
	 * @param codigo Código do time
	 */
	private void validaEntrada(String codigo) {
		if (codigo == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
		if (codigo.isBlank()) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
		
	}
	
	/**
	 * Get de quantidade de times cadastrados no repositório
	 * @return A quantidade de times cadastrados no repositório
	 */
	public int getQuantidadeTimesCadastrados() {
		return times.size();
	}
	
	/**
	 * Método para pegar um time específico
	 * Faz a validação de entradas nulas ou vazias e verifica se o time existe. Caso exista, retorna o time específco pela chave
	 * @param codigo Código do time
	 * @return O time específico que possui o código
	 */
	public Time timeEspecifico(String codigo) {
		validaEntrada(codigo);
		if (!verificarSeTimeExiste(codigo)) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		return times.get(codigo);
		
	}
	

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
