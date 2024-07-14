
public class Descanso {
	private int horasDescansadas;
	private int numeroDeSemanas;
	private double horasDescansadasPorSemana;
	
	/**
	 * Construtor.
	 */
	public Descanso() {
		
		this.horasDescansadas = 0;
		this.numeroDeSemanas = 1; 
		this.horasDescansadasPorSemana = 0;
	}
	
	/**
	 * Cadastra quantas horas o usuário precisa descansar
	 * @param horasDescanso Quantidade de horas que precisam ser descansadas pelo usuário.
	 */
	public void defineHorasDescanso(int horasDescanso){
		
		this.horasDescansadas = horasDescanso;
	}
	/**
	 * Cadastra quantas semanas o usuário descansou. Faz um tratamento para ver se o número não é 0
	 *@param numeroSemanas Quantas semanas o usuário descansou.
	 */
	public void defineNumeroSemanas(int numeroSemanas){
		if (numeroSemanas != 0) {
			this.numeroDeSemanas = numeroSemanas;
		}
	} 
	
	/**
	 * Comparativo para saber se o usuário está descansado. 
	 * @return Se maior que 26, retorna "descansado". Se não, retorna "cansado".
	 */
	public String getStatusGeral(){
		
		this.horasDescansadasPorSemana = this.horasDescansadas/this.numeroDeSemanas;
		
		if (this.horasDescansadasPorSemana>=26) {
			return "descansado";
		}
		else {
			return "cansado";
		}
		
	}
}
