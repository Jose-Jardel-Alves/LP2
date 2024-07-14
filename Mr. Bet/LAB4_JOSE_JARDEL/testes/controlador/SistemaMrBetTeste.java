package controlador;



import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


class SistemaMrBetTeste {

	private SistemaMrBet mrBet;
	@BeforeEach
	void before() {
		mrBet = new SistemaMrBet();
		mrBet.incluirTimes("250_PB", "Nacional de Patos", "Canário");
		mrBet.incluirTimes("252_PB", "Sport Lagoa Seca", "Carneiro");
		mrBet.incluirTimes("002_RJ", "Clubre de Regatas do Flamengo", "Urubu");
		mrBet.incluirTimes("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}
	
	//Testes pedidos no documento
	
	@DisplayName("Cadastrando um campeonato com sucesso")
	@Test
	void testCadastrarCampeonatoComSucesso() {
		String out = "INCLUSÃO REALIZADA";
		assertEquals(out, mrBet.adicionarCampeonato("Brasileirão série A 2023", 20));
	}
	
	@DisplayName("Cadastrando um campeonato que já existe.")
	@Test
	void testCadastrarCampeonatoQueJaExiste() {
		String out = "CAMPEONATO JÁ EXISTE";
		mrBet.adicionarCampeonato("Brasileirão série A 2023", 20);
		assertEquals(out, mrBet.adicionarCampeonato("Brasileirão série A 2023", 20));
		
	}
	
	@DisplayName("Incluir time em campeonato com sucesso")
	@Test
	void testIncluirTimeEmCampeonato() {
		String out = "TIME INCLUÍDO NO CAMPEONATO";
		mrBet.adicionarCampeonato("Brasileirão série A 2023", 20);
		assertEquals(out, mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "250_PB"));
		assertEquals(out, mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "252_PB"));
	}
	
	@DisplayName("Incluir time em campeonato que o time já foi incluído")
	@Test
	void testIncluirTimeEmCampeonatoQueJaFoiIncluido() {
		String out = "TIME INCLUÍDO NO CAMPEONATO";
		mrBet.adicionarCampeonato("Brasileirão série A 2023", 20);
		assertEquals(out, mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "250_PB"));
		assertEquals(out, mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "252_PB"));
		assertEquals("O TIME ESTÁ NO CAMPEONATO", mrBet.verificarSeTimeEstaNoCampeonato("252_PB", "Brasileirão série A 2023"));
		assertEquals(out, mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "252_PB"));
	}
	
	@DisplayName("Incluir time em campeonato que o time não existe")
	@Test 
	void testIncluirTimeEmCampeonatoQuandoOTimeNãoExiste() {
		String out = "O TIME NÃO EXISTE!";
		mrBet.adicionarCampeonato("Brasileirão série A 2023", 20);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "005_PB"));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Incluir time em campeonato em que o campeonato não existe")
	@Test
	void testIncluirTimeEmCampeonatoQuandoOCampeonatoNãoExiste() {
		String out = "O CAMPEONATO NÃO EXISTE!";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão série D 2023", "252_PB"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time no campeonato, em que o campeonato já está cheio")
	@Test
	void testIncluirTimeEmCampeonatoExcedendoParticipantes() {
		String out1 = "INCLUSÃO REALIZADA";
		String out2 = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		assertEquals(out1, mrBet.adicionarCampeonato("Brasileirão série A 2023", 1));
		mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "252_PB");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão série A 2023", "250_PB"));
		assertEquals(out2, e.getMessage());
	}
	
	@DisplayName("Verificar se time pertence a campeonato")
	@Test
	void testVerificarSeTimePertenceACampeonato() {
		String out1 = "O TIME ESTÁ NO CAMPEONATO";
		String out2 = "O TIME NÃO ESTÁ NO CAMPEONATO";
		mrBet.adicionarCampeonato("Copa do Nordeste 2023", 20);
		mrBet.incluirTimeEmCampeonato("Copa do Nordeste 2023", "250_PB");
		assertEquals(out1, mrBet.verificarSeTimeEstaNoCampeonato("250_PB", "Copa do Nordeste 2023"));
		assertEquals(out2, mrBet.verificarSeTimeEstaNoCampeonato("252_PB", "Copa do Nordeste 2023"));
	}
	
	@DisplayName("Verificar se time pertence a campeonato não cadastrado")
	@Test
	void testVerificarSeTimePertenceACampeonatoNaoCadastrado() {
		String out = "O CAMPEONATO NÃO EXISTE!";	
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão série D 2023", "250_PB"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Verificar se tim pertence a campeonato, quando o time não existe")
	@Test
	void testVerificarSeTimeNaoCadastradoPertenceACampeonato() {
		String out = "O TIME NÃO EXISTE!";
		mrBet.adicionarCampeonato("Copa do Nordeste 2023", 20);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Copa do Nordeste 2023", "005_PB"));
		assertEquals(out, e.getMessage());
	}
	
	
	
	//Testes que imagino que sejam necessários
	
	@DisplayName("Incluir time com código nulo")
	@Test
	void testIncluirTimesComCodigoNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.incluirTimes(null, "Campinense", "Raposa"));
		assertEquals(out, e.getMessage());
	
	}
	
	@DisplayName("Incluit time com nome nulo")
	@Test 
	void testIncluirTimeComNomeNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.incluirTimes("001_PB", null, "Raposa"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time com mascote nulo")
	@Test 
	void testIncluirTimeComMascoteNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.incluirTimes("001_PB", "Campinense", null));
		assertEquals(out, e.getMessage());	
		
	}
	
	@DisplayName("Incluir time com codigo vazio")
	@Test 
	void testIncluirTimesComCodigoVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimes("", "Campinense", "Raposa"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time com nome vazio")
	@Test 
	void testIncluirTimeComNomeVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimes("001_PB", "", "Raposa"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time com mascote vazio")
	@Test 
	void testIncluirTimeComMascoteVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimes("001_PB", "Campinense", ""));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Incluir time com codigo vazio com espaço")
	@Test 
	void testIncluirTimesComCodigoVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimes(" ", "Campinense", "Raposa"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time com nome vazio com espaço")
	@Test 
	void testIncluirTimeComNomeVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimes("001_PB", " ", "Raposa"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time com mascote vazio com espaço")
	@Test 
	void testIncluirTimeComMascoteVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimes("001_PB", "Campinense", " "));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Recuperar time com sucesso")
	@Test
	void testRecuperarTime() {
		String out = "[250_PB] Nacional de Patos / Canário";
		assertEquals(out, mrBet.recuperarTimes("250_PB"));
	}
	
	@DisplayName("Recuperar time com time que não existe")
	@Test
	void testRecuperarTimeComTimeQueNãoExiste() {
		String out = "O TIME NÃO EXISTE!";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.recuperarTimes("007_RJ"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Recuperar time com codigo nulo")
	@Test 
	void testRecuperarTimeComCodigoNulo(){
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.recuperarTimes(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Recuperar time com codigo vazio")
	@Test
	void testRecuperarTimeComCodigoVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.recuperarTimes(""));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Recuperar time com codigo vazio com espaço")
	@Test
	void testRecuperarTimeComCodigoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.recuperarTimes(" "));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Adicionar campeonato com nome nulo")
	@Test
	void testAdicionarCampeonatoComNomeNulo() {
		String out = "ENTRADAS INVÁLIDAS";
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.adicionarCampeonato(null, 2));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Adicionar campeonato com nome vazio")
	@Test
	void testAdicionarCampeonatoComNomeVazio() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.adicionarCampeonato("", 2));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Adicionar campeonato com nome vazio com espaço")
	@Test
	void testAdicionarCampeonatoComNomeVazioComEspaco() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.adicionarCampeonato(" ", 2));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Adicionar campeonato com quantidade 0")
	@Test
	void testAdicionarCampeonatoComQuantidadeZero() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.adicionarCampeonato("Brasileirão", 0));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Adicionar campeonato com quantidade negativa")
	@Test
	void testAdicionarCampeonatoComQuantidadeNegativa() {
		String out = "ENTRADAS INVÁLIDAS";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.adicionarCampeonato("Brasileirão", -5));
		assertEquals(out, e.getMessage());		
	}
	
	@DisplayName("Incluir time em campeonato com diferença entre letras maiúsculas e minúsculas")
	@Test
	void testIncluirTimeEmCampeonatoComNomeDoCampeonatoComDiferencaNasLetrasMaiusculasEMinusculas() {
		String out = "TIME INCLUÍDO NO CAMPEONATO";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		assertEquals(out, mrBet.incluirTimeEmCampeonato("braSILeirãO", "250_PB"));
	}
	
	@DisplayName("Incluir time em campeonato com nome do campeonato nulo")
	@Test 
	void testIncluirTimeEmCampeonatoComNomeDoCampeonatoNulo() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.incluirTimeEmCampeonato(null, "250_PB"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time em campeonato com código do tune nulo")
	@Test
	void testIncluirTimeEmCampeonatoComCodigoDoTimeNulo() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão", null));
		assertEquals(out, e.getMessage());	
		
	}
	
	@DisplayName("Incluir time em campeonato nome do campeonato vazio")
	@Test 
	void testIncluirTimeEmCampeonatoComNomeDoCampeonatoVazio() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("", "250_PB"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time em campeonato  com código do time vazio")
	@Test 
	void testIncluirTimeEmCampeonatoComCodigoDoTimeVazio() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão", ""));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Incluir time em campeonatocom nome do campeonato vazio com espaço")
	@Test 
	void testIncluirTimeEmCampeonatoComNomeDoCampeonatoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato(" ", "250_PB"));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Incluir time em campeonato com código do time vazio com espaço")
	@Test 
	void testIncluirTimeEmCampeonatoComCodigoDoTimeVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.incluirTimeEmCampeonato("Brasileirão", " "));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Verificar se time está no campeonato com nome do campeoanto com diferença nas letras maiúsculas e minúsculas")
	@Test
	void testVerificarSeTimeEstaEmCampeonatoComNomeDoCampeonatoComDiferencaNasLetrasMaiusculasEMinusculas() {
		String out = "O TIME ESTÁ NO CAMPEONATO";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		assertEquals(out, mrBet.verificarSeTimeEstaNoCampeonato("250_PB", "braSILeirãO"));
	}
	
	@DisplayName("Verificar se time está no campeonato com codigo do time nulo")
	@Test 
	void testVerificarSeTimeEstaEmCampeonatoComCodigoDoTimeNulo() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.verificarSeTimeEstaNoCampeonato(null, "Brasileirão"));
		assertEquals(out, e.getMessage());
			
	}
	
	@DisplayName("Verificar se time está no campeonato com nome do campeonato nulo")
	@Test 
	void testVerificarSeTimeEstaEmCampeonatoComNomeDoCampeonatoNulo() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.verificarSeTimeEstaNoCampeonato("250_PB", null));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Verificar se time está no campeonato com código do time vazio")
	@Test 
	void testVerificarSeTimeEstaEmCampeonatoComCodigoDoTimeVazio() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.verificarSeTimeEstaNoCampeonato("", "Brasileirão"));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Verificar se time está no campeonato com nome do campeonato vazio")
	@Test 
	void testVerificarSeTimeEstaEmCampeonatoComNomeDoCampeonatoVazio() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.verificarSeTimeEstaNoCampeonato("250_PB", ""));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Verificar se time está no campeonato com código do time vazio com espaço")
	@Test 
	void testVerificarSeTimeEstaEmCampeonatoComCodigoDoTimeVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.verificarSeTimeEstaNoCampeonato(" ", "Brasileirão"));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Verificar se time está no campeonato com nome do campeonato vazio com espaço")
	@Test 
	void testVerificarSeTimeEstaEmCampeonatoComNomeDoCampeonatoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.verificarSeTimeEstaNoCampeonato("250_PB", " "));
		assertEquals(out, e.getMessage());	
	}
	
	@DisplayName("Exibit campeonatos que o time participa")
	@Test
	void testExibirCampeonatosQueOTimeParticipa() {
		String out = "Time: 250_PB\n"
				+ "\n"
				+ "Campeonatos do Nacional de Patos: \n"
				+ "* Brasileirão - 1/20\n"
				+ "* Champions - 1/8";
		mrBet.adicionarCampeonato("Brasileirão", 20);
		mrBet.adicionarCampeonato("Champions", 8);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		mrBet.incluirTimeEmCampeonato("Champions", "250_PB");
		assertEquals(out, mrBet.exibirCampeonatosTimeParticipa("250_PB"));
	}
	
	@DisplayName("Exibir campeonatos que o time participa com código do time nulo")
	@Test
	void testExibirCampeonatosQueOTimeParticipaComCodigoDoTimeNulo() {
		String out = "ENTRADA INVÁLIDA";
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.exibirCampeonatosTimeParticipa(null));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir campeonatos que o time participa com código do time vazio")
	@Test
	void testExibirCampeonatosQueOTimeParticipaComCodigoDoTimeVazio() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.exibirCampeonatosTimeParticipa(""));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Exibir campoenatos que o time participa com código do time vazio com espaço")
	@Test
	void testExibirCampeonatosQueOTimeParticipaComCodigoDoTimeVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.exibirCampeonatosTimeParticipa(" "));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com sucesso")
	@Test
	void testCriarAposta() {
		String out = "APOSTA REGISTRADA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		assertEquals(out, mrBet.criarAposta("250_PB", "Brasileirão", 2, 175.5));
	}
	
	@DisplayName("Criar aposta com nome do campeonato com diferença nas letras maiúsculas e minúsculas")
	@Test
	void testCriarApostaPassandoNomeDoCampeonatoComDiferençaNasLetrasMaiusculaseMinusculas() {
		String out = "APOSTA REGISTRADA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		assertEquals(out, mrBet.criarAposta("250_PB", "braSILeIrão", 2, 175.5));
	}
	
	@DisplayName("Criar aposta com a colocação acima da quantidade de times limites naquele campeonato")
	@Test
	void testCriarApostaQuandoExcedeNumeroDeParticipantes(){
		String out = "APOSTA NÃO REGISTRADA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", 7, 175.5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com time não cadastrado")
	@Test
	void testCriarApostaQuandoTimeNaoCadastrado(){
		String out = "O TIME NÃO EXISTE!";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("007_PB", "Brasileirão", 2, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta com campeonato não cadastrado")
	@Test
	void testCriarApostaQuandoCampeonatoNaoCadastrado(){
		String out = "O CAMPEONATO NÃO EXISTE!";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", 7, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta quando o time não está naquele campeonato")
	@Test
	void testCriarApostaQuandoTimeNaoEstaNoCampeonato(){
		String out = "ESSE TIME NÃO ESTÁ NO CAMPEONATO";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", 2, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta com código do time nulo")
	@Test
	void testCriarApostaComCodigoDoTimeNulo() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.criarAposta(null, "Brasileirão", 2, 175.5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com nome do campeonato nulo")
	@Test
	void testCriarApostaComNomeDoCampeonatoNulo() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		NullPointerException e = assertThrows(NullPointerException.class, () -> mrBet.criarAposta("250_PB", null, 2, 175.5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com código do time vazio")
	@Test
	void testCriarApostaComCodigoDoTimeVazio() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("", "Brasileirão", 2, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta com nome do campeonato vazio")
	@Test
	void testCriarApostaComNomeDoCampeonatoVazio() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "", 2, 175.5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com codigo do time vazio com espaço")
	@Test
	void testCriarApostaComCodigoDoTimeVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta(" ", "Brasileirão", 2, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta com nome do campeonato vazio com espaço")
	@Test
	void testCriarApostaComNomeDoCampeonatoVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", " ", 2, 175.5));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com colocação igual a 0")
	@Test
	void testCriarApostaComColocacaoIgualAZero() {
		String out = "ENTRADAS INVÁLIDAS";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", 0, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta com valor igual a 0")
	@Test
	void testCriarApostaComValorIgualAZero() {
		String out = "ENTRADAS INVÁLIDAS";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", 2, 0));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Criar aposta com colocação negativa")
	@Test
	void testCriarApostaComColocacaoNegativa() {
		String out = "ENTRADAS INVÁLIDAS";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", -1, 175.5));
		assertEquals(out, e.getMessage());
		
	}
	
	@DisplayName("Criar aposta com valor negativo")
	@Test
	void testCriarApostaComValorNegativo() {
		String out = "ENTRADAS INVÁLIDAS";
		mrBet.adicionarCampeonato("Brasileirão", 5);
		mrBet.incluirTimeEmCampeonato("Brasileirão", "250_PB");
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> mrBet.criarAposta("250_PB", "Brasileirão", 2, -1));
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Status das apostas")
	@Test
	void testStatusDasApostas() {
		String out = "Apostas: \n"
				+ "\n"
				+ "1. [250_PB] Nacional de Patos / Canário\n"
				+ "Campeonato Paraibano 2023\n"
				+ "2/14\n"
				+ "R$ 50.0\n"
				+ "\n"
				+ "2. [252_PB] Sport Lagoa Seca / Carneiro\n"
				+ "Nordestão 2023\n"
				+ "1/20\n"
				+ "R$ 250.0\n"
				+ "\n"
				+ "";
		
		mrBet.adicionarCampeonato("Campeonato Paraibano 2023", 14);
		mrBet.adicionarCampeonato("Nordestão 2023", 20);
		mrBet.incluirTimeEmCampeonato("Campeonato Paraibano 2023", "250_PB");
		mrBet.incluirTimeEmCampeonato("Nordestão 2023", "252_PB");
		mrBet.criarAposta("250_PB", "Campeonato Paraibano 2023", 2, 50.0);
		mrBet.criarAposta("252_PB", "Nordestão 2023", 1, 250);
		assertEquals(out, mrBet.statusDasApostas());
	}
	
	@DisplayName("Status das apostas com nenhuma aposta feita")
	@Test 
	void testStatusDasApostasComNenhumaApostaFeita(){
		String out = "Apostas: \n"
				+ "\n"
				+ "";
		
		assertEquals(out, mrBet.statusDasApostas());
	}
	
	@DisplayName("Fechar programa")
	@Test
	void fecharPrograma() {
		String out = "Valeu :)";
		assertEquals(out, mrBet.fecharPrograma());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
