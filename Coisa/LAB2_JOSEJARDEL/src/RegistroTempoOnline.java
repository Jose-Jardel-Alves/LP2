
public class RegistroTempoOnline {
	private String nomeDisciplina;
	private int horasEsperadasOnline;
	private int tempoOnline;
	
	/**
	 * Construtor
	 * @param nomeDaDisciplina O nome da disciplina
	 * @param horasDaDisciplina Quantas horas online a disciplina precisa
	 */
	public RegistroTempoOnline(String nomeDaDisciplina, int horasDaDisciplina) {
		
		this.nomeDisciplina = nomeDaDisciplina;
		this.horasEsperadasOnline = horasDaDisciplina;
		
	}
	/**
	 * Segundo construtor, quando o usuário não passar o tempo online.
	 * @param nomeDaDisciplina Nome da disciplina.
	 */
	public RegistroTempoOnline(String nomeDaDisciplina) {
		this.nomeDisciplina = nomeDaDisciplina;
		this.horasEsperadasOnline = 120;
	}
		
	/**
	 * Soma e acumula o tempo que o usuário esteve online.
	 * @param tempo Quanto o usuário esteve online que vai somar com o tempo que já está salvo
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	/**
	 * Se o tempoOnline já for maior/igual que o tempo esperado, retorna true. Caso contrário, false.
	 * @return Retorna true se maior igual. False se menor
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnline>=this.horasEsperadasOnline) {
			return true;
		}
		return false;
	}
	/**
	* To String.
	*/
	public String toString() {
		
		return nomeDisciplina + " " + tempoOnline + "/" + 	Integer.toString(horasEsperadasOnline);
	}	                                                                                                          
}

