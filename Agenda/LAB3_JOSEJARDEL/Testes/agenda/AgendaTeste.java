package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


class AgendaTeste {

	private Contato contato;
	private Agenda agenda;
	
	@BeforeEach
	void before(){
		Contato contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		Agenda agenda = new Agenda();
		this.contato = contato;
		this.agenda = agenda;
		
	}
	
	@DisplayName("Teste para cadastrar contato na posição vazia")
	@Test
	void testCadastrarContatoPosicaoVazia(){

		String out = "CONTATO CADASTRADO";
		assertNull(agenda.getContatos()[0]);
		assertEquals(agenda.cadastraContato(1, contato.getNome(), contato.getSobrenome(), contato.getTelefone()), out);
			
	}
	@DisplayName("Teste para cadastrat contato em posição com contato já cadastrado")
	@Test
	void testCadastrarContatoPosicaoExistente(){
		String out = "CONTATO CADASTRADO";
		assertNull(agenda.getContatos()[0]);
		agenda.cadastraContato(1, contato.getNome(), contato.getSobrenome(), contato.getTelefone());
		assertNotEquals(agenda.getContatos()[0], null);
		assertEquals(agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111"), out);
		
	}
	@DisplayName("Cadastrando contato com nome e sobrenome iguais")
	@Test
	void testNomeSobrenomeJaCadastrados() {
		String out = "CONTATO JÁ CADASTRADO";
		assertNull(agenda.getContatos()[0]);
		agenda.cadastraContato(1, contato.getNome(), contato.getSobrenome(), contato.getTelefone());
		assertNotEquals(agenda.getContatos()[0], null);
		assertEquals(agenda.cadastraContato(3, contato.getNome(), contato.getSobrenome() , "40028922"), out);
	}
	@DisplayName("Cadastrar contato na posição limite (100)")
	@Test
	void testeCadastrarContatoPosicaoLimite() {
		String out = "CONTATO CADASTRADO";
		assertNull(agenda.getContatos()[99]);
		assertEquals(agenda.cadastraContato(100, contato.getNome(), contato.getSobrenome(), contato.getTelefone()), out);
		
	}
	@DisplayName("Cadastrar contato na posição acima do limite (101)")
	@Test
	void testCadastratContatoPosicaoAcimaLimite() {
		String out = "POSIÇÃO INVÁLIDA";
		assertEquals(agenda.cadastraContato(101, contato.getNome(), contato.getSobrenome(), contato.getTelefone()), out);
	}
	
	@DisplayName("Cadastrar contato na posição abaixo do limite (0)")
	@Test
	void testCadastrarContatoPosicaoAbaixoLimite() {
		String out = "POSIÇÃO INVÁLIDA";
		assertEquals(agenda.cadastraContato(0, contato.getNome(), contato.getSobrenome(), contato.getTelefone()), out);
	}
	@DisplayName("Cadastrando contato com telefone vazio")
	@Test
	void testCadastrarContatoFoneVazio() {
		String out = "CONTATO INVÁLIDO";
		assertEquals(agenda.cadastraContato(1, contato.getNome(), contato.getSobrenome(), ""), out);
	}
	@DisplayName("Cadastrar contato com nome vazio")
	@Test
	void testCadastrarContatoNomeVazio() {
		String out = "CONTATO INVÁLIDO";
		assertEquals(agenda.cadastraContato(1, "", contato.getSobrenome(), contato.getTelefone()), out);
	}
	
	//TESTES DE EXIBIR CONTATO
	@DisplayName("Exibindo contato")
	@Test
	void testExibirContato() {
		String out = "Dados do contato:\nMatheus Gaudencio" + System.lineSeparator() + "(83) 99999-0000";
		agenda.cadastraContato(1, contato.getNome(), contato.getSobrenome(), contato.getTelefone());
		assertEquals(agenda.exibirContato(1), out);
		
	}
	
	@DisplayName("Tentar exibir contato que não existe")
	@Test
	void testExibirContatoNaoExistente() {
		String out = "CONTATO NÃO EXISTE";
		assertNull(agenda.getContatos()[99]);
		assertEquals(agenda.exibirContato(100), out);
	}
	
	@DisplayName("Tentar exibir contato com posição 0")
	@Test
	void testExibirContatoAbaixoDePosicaoAceita() {
		String out = "POSIÇÃO INVÁLIDA";
		assertEquals(agenda.exibirContato(0), out);
	}
	
	@DisplayName("Tentar exibir contato com posição 101")
	@Test
	void testExibirContatoAcimaDePosicaoAceita() {
		String out = "POSIÇÃO INVÁLIDA";
		assertEquals(agenda.exibirContato(101), out);
	}
	
	@DisplayName("Exibindo contato favoritado")
	@Test
	void testExibirContatoFavoritado() {
		String out = "Dados do contato:\n❤️ Matheus Gaudencio" + System.lineSeparator() + "(83) 99999-0000";
		agenda.cadastraContato(1, contato.getNome(), contato.getSobrenome(), contato.getTelefone());
		agenda.adcionaFavorito(1, 1);
		assertEquals(agenda.exibirContato(1), out);
		
	}
	
	
	
	
	
	

}