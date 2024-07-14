package modelo;
import java.util.*;

/**
 * Classe de campeonato
 * @author oem
 *
 */
public class Campeonato {
	/**
	 * nome é a variável que vai armazenar o nome do campeonato
	 * times é a variável que vai armazenar o HashSet de times que participam daquele campeonato
	 * countQuantDeTimes é a variável que vai armazenar quantos times já foram adicionado
	 * quantidadeDeTimesLimite é a variável que vai armazenar a quantidade limite de times que podem ter no campeonato
	 */
	private String nome;
	private Set<Time> times; 
	private int countQuantDeTimes;
	private int quantidadeDeTimesLimite;

	/**
	 * Construtor
	 * Faz a validação dos atributos antes de construir de fato
	 * @param nome Nome do campeonato
	 * @param quantidadeDeTimes Quantidade de times limite que o campeonato pode ter
	 */
	public Campeonato(String nome, int quantidadeDeTimes){
		validaEntradas(nome, quantidadeDeTimes);
		this.nome = nome;
		this.quantidadeDeTimesLimite = quantidadeDeTimes;
		this.times = new HashSet<Time>();
		this.countQuantDeTimes = 0;
	}
	/**
	 * Método para validar entradas e retornar erros caso sejam nulas ou vazias
	 * @param nome Nome do campeonato
	 * @param quantidadeDeTimes Quantidade de times do campeonato
	 */
	private void validaEntradas(String nome, int quantidadeDeTimes) {
		if (nome == null) {
			throw new NullPointerException("ENTRADAS INVÁLIDAS");
		}
		if (nome.isBlank() || quantidadeDeTimes<=0) {
			throw new IllegalArgumentException("ENTRADAS INVÁLIDAS");
		}
	}
	
	/**
	 * Método para validar o código do time, é sobreposto ao outro
	 * @param codigoDoTime Código do time
	 */
	private void validaEntradas(String codigoDoTime) {
		if (codigoDoTime == null) {
			throw new NullPointerException("ENTRADA INVÁLIDA");
		}
		if (codigoDoTime.isBlank()){
			throw new IllegalArgumentException("ENTRADA INVÁLIDA");
		}
	}
	
	/**
	 * Método para adicionar time
	 * Faz a verificação se o campeonato ainda pode adicionar times, se sim, adiciona
	 * @param time Time a ser adicionado
	 */
	public void adicionarTime(Time time){
		if (this.countQuantDeTimes==this.quantidadeDeTimesLimite) {
			throw new IllegalArgumentException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
		}
		this.times.add(time);
		this.countQuantDeTimes++;
	}
	
	/**
	 * Método para verificar se o campeonato possui um time específico.
	 * Faz a validação de entrada antes para então fazer um for e ver se possui o time ou não
	 * @param codigoDoTime Código do time
	 * @return True, se possui o time. False, se não
	 */
	public boolean possuiTime(String codigoDoTime) {
		validaEntradas(codigoDoTime);
		for (Time time : times){
			if (codigoDoTime.equals(time.getCodigo())) {
				return true;
			}		

		}
		return false;
	}
	
	/**
	 * Get de quantidadeDeTimesLimite
	 * @return quantidadeDeTimesLimite
	 */
	public int getQuantidadeDeTimesLimite() {
		return quantidadeDeTimesLimite;
	}

	/**
	 * Get de nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * ToString
	 * @return Formato: nome - countQuantidadeDeTimes/quantidadeDeTimesLimite
	 */
	@Override
	public String toString() {
		return nome + " - " + countQuantDeTimes + "/" + quantidadeDeTimesLimite;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
