package modelo;

/**
 * Classe de aposta
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class Aposta {
	/**
	 * time é a variável que vai armazenar o time que irá ser apostado
	 * campeonato é a variável que vai armazenar o campeonato que vai ser apostado
	 * colocacao é a variável que vai armazenar a colocação que o time vai ficar no campeonato
	 * participantes é a variável que vai armazenar quantos participantes o campeonato pode ter
	 * valor é a variável que vai armazenar o valor da aposta
	 */
	private Time time;
	private Campeonato campeonato;
	private int colocacao;
	private int quantParticipantesLimite;
	private double valor;
	
	/**
	 * Construtor de Aposta
	 * Faz a validação de entradas, para então construir, de fato.
	 * @param time Time a ser apostado
	 * @param campeonato Campeonato a ser apostado
	 * @param colocacao Colocação que o time apostado irá ficar no campeonato
	 * @param valor Valor da aposta
	 */
	public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
		validaEntradas(time, campeonato, colocacao, valor);
		this.time = time;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.quantParticipantesLimite = campeonato.getQuantidadeDeTimesLimite();
		this.valor = valor;
	}
	
	/**
	 * Método para fazer a validação de entradas do usuário para saber se nenhuma entrada é nula ou vazia.
	 * O time e o campeonato já estão validados para entradas vazias, pois não é possível fazer esses objetos com entradas vazias.
	 * @param campeonato Campeonato
	 * @param colocacao Colocação do time no campeonato
	 * @param valor Valor da aposta
	 */
	private void validaEntradas(Time time, Campeonato campeonato, int colocacao, double valor) {
		if (time == null || campeonato == null) {
			throw new IllegalArgumentException("ENTRADAS INVÁLIDAS");
		}
		if (colocacao<=0 || valor<=0) {
			throw new IllegalArgumentException("ENTRADAS INVÁLIDAS");
		}
		if (colocacao>campeonato.getQuantidadeDeTimesLimite()) {
			throw new IllegalArgumentException("APOSTA NÃO REGISTRADA");
		}
	
	}
	
	/**
	 * ToString da aposta
	 * @return Formato: [codigoDoTime] nomeDoTime / mascoteDoTime + nomeDoCampeonato +
	 * colocacaoApostadaNoCampeonato/quantidadeLimiteDeParticiántes +
	 * R$ valorDaAposta
	 */
	@Override
	public String toString() {
		return time.toString() + System.lineSeparator() + campeonato.getNome() + System.lineSeparator() + Integer.toString(colocacao) + "/"
				+ Integer.toString(quantParticipantesLimite) + System.lineSeparator() + "R$ " + Double.toString(valor);
	}
}
	
