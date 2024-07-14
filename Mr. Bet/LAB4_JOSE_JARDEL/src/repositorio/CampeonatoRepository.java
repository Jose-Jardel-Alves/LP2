package repositorio;


import modelo.Campeonato;
import java.util.*;
import java.util.Map;



/**
 * Classe de repositório de campeonatos
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class CampeonatoRepository {
	/**
	 * campeonatos é a variável do repositório que armazena os campeonatos atráves de um HashMap
	 */
	private Map<String, Campeonato> campeonatos;
	
	/**
	 * Construtor
	 */
	public CampeonatoRepository() {
		campeonatos = new HashMap<>();
	}
	
	/**
	 * Método para adicionar campeonato no repositório
	 * Faz a verificação se o campeonato existe ou não. Se não existir, adiciona o campeonato no mapa
	 * @param nome Nome do campeonato
	 * @param campeonato Objeto campeonato em si
	 * @return Se existe, "CAMPEONATO JÁ EXISTE". Se não, "INCLUSÃO REALIZADA"
	 */
	public String adicionarCampeonato(String nome, Campeonato campeonato) {
		if (verificarSeCampeonatoExiste(nome)) {
			return "CAMPEONATO JÁ EXISTE";
		}
		campeonatos.put(nome.toUpperCase(), campeonato);
		return "INCLUSÃO REALIZADA";
	}
	
	/**
	 * Método que verifica se o campeonato existe
	 * Antes de fazer a verificação, faz a validação de entrada (nulo ou vazio)
	 * @param nome Nome do campeonato
	 * @return True, se existe. False, se não
	 */
	private boolean verificarSeCampeonatoExiste(String nome) {
		validaEntrada(nome);
		if (campeonatos.containsKey(nome.toUpperCase())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Método para validar entrada e retornar um erro caso nulo ou vazio
	 * @param nome Nome do campeonato
	 */
	private void validaEntrada(String nome) {
		if (nome == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
		
	}
	
	/**
	 * Método para puxar um campeonato específico pelo nome dele
	 * Faz a validação se a entrada é valida e se o campeonato existe
	 * @param nome NOme do campeonato
	 * @return o campeonato com aquele nome específico
	 */
	public Campeonato puxarCampeonato(String nome) {
		validaEntrada(nome);
		if (!verificarSeCampeonatoExiste(nome)) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
		return campeonatos.get(nome.toUpperCase());
		
	}
	
	/**
	 * Get de quantidade de campeonatos no repositório
	 * @return A quantidade de campeonatos no repositório
	 */
	public int getQuantidadeCampeonatos() {
		return campeonatos.size();
	}
	
	/**
	 * Get para pegar todas as chaves do mapa.
	 * @return Um set de string com todas as chaves do mapa
	 */
	public Set<String> getChavesDosCampeonatos() {
		return campeonatos.keySet();
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
}
