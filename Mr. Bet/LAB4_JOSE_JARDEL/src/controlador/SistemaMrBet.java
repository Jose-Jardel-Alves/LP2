package controlador;

import modelo.Campeonato;
import modelo.Time;
import modelo.Aposta;
import repositorio.CampeonatoRepository;
import repositorio.TimeRepository;
import repositorio.ApostaRepository;

/**
 * Classe SistemaMrBet
 * Um controlador de um sistema de apostas no geral, em que você consegue adicionar times, campeonatos, criar apostad, entre outros
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class SistemaMrBet {
	/**
	 * apostas é a variável que é o repositório de apostas, por isso é do tipo ApostaRepository
	 * campeonatos é a variável que é o repositório de campeonatos, por isso é do tipo CampeonatoRepository
	 * times é a variável que é o repositório de times, por isso é do tipo TimeRepository
	 */
	private ApostaRepository apostas;
	private CampeonatoRepository campeonatos;
	private TimeRepository times;
	
	/**
	 * Construtor do SistemaMrBEt
	 */
	public SistemaMrBet(){
		this.campeonatos = new CampeonatoRepository();
		this.times = new TimeRepository();
		this.apostas = new ApostaRepository();
	}
	
	/**
	 * Método para incluir um time no repositório de times
	 * Faz um time temporário, assim faz todas as verificações necessárias(nulo e vazio) e depois adiciona no repositório de times
	 * @param codigo Código do time
	 * @param nome Nome do time
	 * @param mascote Mascote do time
	 * @return String relatando se foi um sucesso a inclusão ou não. Se sim, "INCLUSÃO REALIZADA", se não "TIME JÁ EXISTE"
	 * 
	 */
	public String incluirTimes(String codigo, String nome, String mascote){
		Time time = new Time(codigo, nome, mascote);
		return times.adicionarTime(codigo, time);
	}
	
	/**
	 * Método para recuperau um time específico, mostrando todas as informações dele
	 * Faz um time temporário para verificar se no repositório o time existe e para fazer todas as verificações de código(nulo, vazio)
	 * @param codigo Código do time
	 * @return ToString do time, todas as informações referentes aquele time. Formato [codigoDoTime] NomeDoTime / MascoteDoTime
	 */
	public String recuperarTimes(String codigo){
		Time time = times.timeEspecifico(codigo);
		return time.toString();
	}
		
	/**
	 * Método para adicionar um campeonato no repositório de campeonatos
	 * Faz um campeonato temporário para fazer todas as cerificações de entradas(nulo e vazio), para então, adicioná-lo no repositório
	 * @param nome Nome do Campeonato
	 * @param quantidadeDeTimes Quantidade de times que o campeonato pode ter
	 * @return String avisando se o campeonato foi adicionado ou não. Se sim, "INCLUSÃO REALIZADA", se não "CAMPEONATO JÁ EXISTE"
	 */
	public String adicionarCampeonato(String nome, int quantidadeDeTimes) {
		Campeonato campeonatoTemporario = new Campeonato(nome, quantidadeDeTimes);
		
		return campeonatos.adicionarCampeonato(nome, campeonatoTemporario);
		
	}
	
	/**
	 *Método para incluir um time específico em um determinado campeonato, que são passados pelo código do time e o nome do campeonato, respectivamente.
	 *Faz variáveis temporárias que fazem todas as verificações de entradas, depois verificam se o campeonato já possui o time. Caso o time já esteja no campeonato não faz a inclusão 
	 * @param nomeDoCampeonato Nome do campeonato
	 * @param codigoDoTime Código do time
	 * @return "TIME INCLUÍDO NO CAMPEONATO"
	 */
	public String incluirTimeEmCampeonato(String nomeDoCampeonato, String codigoDoTime) {
			
		Campeonato campeonato = campeonatos.puxarCampeonato(nomeDoCampeonato);
		Time time = times.timeEspecifico(codigoDoTime);
		
		if (campeonato.possuiTime(codigoDoTime)) {
			return "TIME INCLUÍDO NO CAMPEONATO";
		}
		
		campeonato.adicionarTime(time);
		return "TIME INCLUÍDO NO CAMPEONATO";
		
	}

	/**
	 * Método para verifica se um determinado time está naquele campeonato.
	 * Chamam os métodos "puxarCampeonato" e "possuiTime" para fazer as verificações de entrada e armazenar o campeonato, após isso verifica se o campeonato possui o time
	 * @param codigoDoTime Código do time
	 * @param nomeDoCampeonato Nome do campeonato
	 * @return Se o campeonato possui o time, "O TIME ESTÁ NO CAMPEONATO". Se não, "O TIME NÃO ESTÁ NO CAMPEONATO"
	 */
	public String verificarSeTimeEstaNoCampeonato(String codigoDoTime, String nomeDoCampeonato) {
		
		Campeonato campeonato = campeonatos.puxarCampeonato(nomeDoCampeonato);	
		times.timeEspecifico(codigoDoTime);
		
		if (campeonato.possuiTime(codigoDoTime)) {
			return "O TIME ESTÁ NO CAMPEONATO";
		}
		return "O TIME NÃO ESTÁ NO CAMPEONATO";
		
	}
	
	/**
	 * Método que exibe todos os campeonatos que o time participa.
	 * Possui uma variável texto inicialmente que vai concatenando as strings ao decorrer do método. Assim, faz um for para varrer todos os campeonatos, 
	 * acessando-os pelas chaves do mapa do repositório, então faz uma variável campeonato temporário para então verificar se o time está presente no 
	 * campeonato. Se sim, há a concatenação na variável texto com o formatação de exibição + toString do campeonato. 
	 * Vale ressaltar, que o "times.timeEspecífico(codigoDoTime) faz todas as verificações de entrada necessárias para o código do time"
	 * @param codigoDoTime Código do time
	 * @return Campeonatos do [nomeDoCampeonato]
	 * * toString do campeonato1
	 * * toString do campeonato2
	 * .
	 * .
	 * .
	 * 
	 */
	public String exibirCampeonatosTimeParticipa(String codigoDoTime) {
		
		String texto = "Time: " + codigoDoTime + System.lineSeparator() + System.lineSeparator() + "Campeonatos do "
		+ times.timeEspecifico(codigoDoTime).getNome() + ": ";
		
		for (String chaveCampeonato : campeonatos.getChavesDosCampeonatos()) {
			Campeonato campeonatoTemporario = campeonatos.puxarCampeonato(chaveCampeonato);
			if (campeonatoTemporario.possuiTime(codigoDoTime)) {
				texto += System.lineSeparator() + "* " + campeonatoTemporario.toString();
			}
	
		}
		return texto;
		
	}
	
	/**
	 * Método para criar uma aposta
	 * Faz variáveis do tipo Campeonato e Time, que fazem as verificações de entrada(nulo, vazio, <=0 os valores númericos). Então verifica
	 * se o campeonato possui o time, se não retorna um erro com "ESSE TIME NÃO ESTÁ NO CAMPEONATO". Com o time estando no campeonato, faz
	 * uma variável do tipo Aposta, que faz as verificações das demais entradas do usuário, as entradas númericas, verificando se são <=0,
	 * para então, adicionar a aposta no repositório de apostas.
	 * @param codigoDoTime Código do time
	 * @param nomeDoCampeonato Nome do campeonato
	 * @param colocacao Colocação no campeonato
	 * @param valor Valor da aposta
	 * @return "APOSTA REGISTRADA"
	 */
    public String criarAposta(String codigoDoTime, String nomeDoCampeonato, int colocacao, double valor){
    		
	Campeonato campeonato = campeonatos.puxarCampeonato(nomeDoCampeonato);
	Time time = times.timeEspecifico(codigoDoTime);
		
	if (!campeonato.possuiTime(codigoDoTime)){;
		throw new IllegalArgumentException("ESSE TIME NÃO ESTÁ NO CAMPEONATO");
	}
	Aposta apostaTemporaria = new Aposta(time, campeonato, colocacao, valor);
		
	apostas.registrarAposta(apostaTemporaria);
	return "APOSTA REGISTRADA";
		
	}
	
    /**
     * Método para exibir o status das apostas.
     * Faz uma variável das apostas feitas para ir concatenando. Faz um for para acessar todas as apostas do repositório de apostas e ir
     * concatenando com os \n e o toString de cada aposta
     * @return Apostas:
     * 1. [toStringDaAposta1]
     * 2. [toStringDaAposta2]
     * .
     * .
     * .
     */
    
	public String statusDasApostas() {
		String apostasFeitas = "Apostas: " + System.lineSeparator() + System.lineSeparator();
		
		for (int i = 0; i<apostas.getQuantidadeDeApostasFeitas(); i++) {
			apostasFeitas += Integer.toString(i+1) + ". " + apostas.apostaEspecifica(i).toString() + System.lineSeparator() + System.lineSeparator();
		}
		return apostasFeitas;
		
	}
	
	/**
	 * Método para exibir mensagem para fechar o programa.
	 * @return "Valeu :)"
	 */
	public String fecharPrograma() {
		return "Valeu :)";
	}
	
}
