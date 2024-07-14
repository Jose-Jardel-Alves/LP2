package documin.modelo;
import java.util.*;

/**
 * Classe VisaoTitulo
 * Um tipo de Visao
 * @author oem José Jardel Alves de Medeiros
 *
 */
public class VisaoTitulo extends Visao {
	
	/**
	 * Construtor
	 * Passa o documento para o construtor de Visao
	 * @param documento documento que a visão irá se basear
	 */
	public VisaoTitulo(Documento documento) {
		super(documento);
	}
	
	/**
	 * Método para exibir a visãoTitulo
	 * @return Retorna um array de string em que cada elemento do array é a representação completa
	 * de cada elemento Titulo() do documento. Outros elementos de outros tipos nçao são pegos
	 */
	public String[] exibir() {
		ArrayList<String> saidaLista = new ArrayList<>();
		for (int i = 0; i<this.documento.getElementos().size(); i++) {
			if (this.documento.getElementos().get(i) instanceof Titulo) {
				saidaLista.add(this.documento.getElementos().get(i).gerarRepresentacaoResumida());
			}
		}
		
		
		String[] saida = new String[saidaLista.size()];
		saidaLista.toArray(saida);
		return saida;
		
	}
	
	
	
	
	
	
}

