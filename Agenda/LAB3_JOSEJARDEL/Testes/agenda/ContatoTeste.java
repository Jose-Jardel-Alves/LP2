package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;



class ContatoTeste {

	private Contato contato;
	
	@BeforeEach
	void before() {
		Contato contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		this.contato = contato;
	}
	
	@Test
	@DisplayName("Teste para exibir contato normal(sem estar favoritado)")
	void testExibeContato() {
		String out = "Matheus Gaudencio\n(83) 99999-0000";
		assertEquals(this.contato.exibeContato(), out);
	
	}
	
	@Test
	@DisplayName("Teste para toString")
	void testToString(){
		String out = "Matheus Gaudencio";
		assertEquals(this.contato.toString(), out);
		
	}
}