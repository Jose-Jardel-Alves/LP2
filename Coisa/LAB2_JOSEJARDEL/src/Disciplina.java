import java.util.*;

public class Disciplina {
	private String nomeDaDisciplina;
	private double notas[] = new double[4];
	private double media;
	private int horas;
	
	/**
	 * Construtor
	 * @param nomeDaDisciplina Nome Da Disciplina.
	 */
	public Disciplina(String nomeDaDisciplina) {
		this.nomeDaDisciplina = nomeDaDisciplina;
		this.horas = 0;
	}
	/**
	 * Soma e acumula o número de horas que o usuário esteve online.
	 * @param horas Quantas horas irão ser somadas mais as que já estão salvas.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Atualiza a nota do usuário
	 * @param nota Qual nota o usuário irá atualizar. nota1, nota2, nota3 ou nota4.
	 * @param valorNota Valor da nota que irá ser atualizada
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Método para saber se o aluno está aprovado ou reprovado, cálcula a média e faz o resultado.
	 * @return true, se a média maior/igual que 7.0. False, se menor
	 */
	public boolean aprovado() {
		this.media = (notas[0] + notas[1] + notas[2] + notas[3])/4;
		
		if (media>=7.0) {
			return true;
		}
		return false;
	}
	/**
	 * To String
	 */
	public String toString() {
		return this.nomeDaDisciplina + " " + Integer.toString(this.horas) + " " + Double.toString(this.media) + " " + Arrays.toString(this.notas);
	}
	
	
}
