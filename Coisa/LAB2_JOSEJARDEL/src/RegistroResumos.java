
public class RegistroResumos {
private String temaResumos[];
private String resumos[];
private int count;
private int limite;
private boolean encheu;
	/**	
	*Construtor
	* @param numeroDeResumos Quantidade de resumos que irá armazenar
	*/
	public RegistroResumos(int numeroDeResumos) {
		this.count = 0;
		this.limite = numeroDeResumos;
		this.temaResumos = new String[this.limite];
		this.resumos = new String[this.limite];
		this.encheu = false;
		
	}
	/**
	 * Adciona um resumo ao array, com seu tema e seu conteúdo aos respectivos arrays.
	 * A variável "encheu" irá servir para descobrir se o array não tem mais "null" mais a frente.
	 * @param tema = Tema do resumo.
	 * @param resumo = Conteúdo do resumo em si.
	 */
	public void adiciona(String tema, String resumo) {
		if (this.count >= this.limite) {
			this.count = 0;
			this.encheu = true;
		}
		this.temaResumos[this.count] = tema;
		this.resumos[this.count] = resumo;
		this.count++;
		
	
	}
	/**
	 * Retorna um array com todos os resumos existentes.
	 * @return Array com os resumos.
	 */
	public String[] pegaResumos(){
		
		if (this.encheu) {
			String[] resumosCriados = new String[this.limite];
			for (int j = 0; j<limite; j++) {
				resumosCriados[j] = temaResumos[j] + ": " + resumos[j];
			}
			return resumosCriados;
		}
		else {
			String[] resumosCriados = new String[this.count];
			for (int j = 0; j<this.count; j++) {
				resumosCriados[j] = temaResumos[j] + ": " + resumos[j];
			}
			return resumosCriados;
		}
		
	}
	/**
	 * Imprime a quantidade de resumos cadastrados e quais resumos tem(pelo tema).
	 * O método concatena em uma string a quantidade de resumos, transformando o inteiro para string com o Integer.toString
	 * e concatena também com os temas de resumos existententes. Além disso tem um System.lineSeparator para organizar a quebra de linha
	 * @return retorna a string concatenada com todos os dados acima explicados
	 */
	public String imprimeResumos() {
		String fraseASerImprimida = "";
		if (encheu) {
			fraseASerImprimida += "- " + Integer.toString(this.limite) + " resumo(s) cadastrado(s)" + System.lineSeparator() + "- "; 
			for (int i = 0; i<this.limite; i++) {
				if (i == this.limite-1) {
					fraseASerImprimida += temaResumos[i];
				}
				else {
					fraseASerImprimida += temaResumos[i] + " | ";
				}
			}
		}
		else {
			fraseASerImprimida += "- " + Integer.toString(this.count) + " resumo(s) cadastrado(s)" + System.lineSeparator() + "- ";
			for (int i = 0; i<(this.count); i++) {
				if (i == count-1) {
					fraseASerImprimida += temaResumos[i];
				}
				else {
					fraseASerImprimida += temaResumos[i] + " | ";
				}
			}	
		}
		
		return fraseASerImprimida;
		}
		

	/**
	 * Método para retornar quantos resumos exitem dentro do array.
	 * @return Se o array estiver cheio(sem null), existem exatamente o tamanho do array. Se não estiver cheio, retorna o contador
	 * de quantos resumos foram colocados.
	 */
	public int conta() {
		if (encheu) {
			return (this.limite);
		}
		else {
			return (this.count);
		}
		
	}
	/**
	 * Procura um determinado resumo pelo tema.
	 * @param Tema tema do resumo a ser procurado.
	 * @return Retorna true se o resumo com aquele tema existe, false, se não.
	 */
	public boolean temResumo(String tema) {
		for (int i = 0; i<this.limite; i++) {
			if (tema.equals(this.temaResumos[i])){
				return true;
			}
		}
		return false;
	}
	

}
