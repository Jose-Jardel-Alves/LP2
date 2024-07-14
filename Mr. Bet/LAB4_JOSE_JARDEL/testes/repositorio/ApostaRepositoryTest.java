package repositorio;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Campeonato;
import modelo.Time;
import modelo.Aposta;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

class ApostaRepositoryTest {

	@DisplayName("Aposta Específica")
	@Test
	void testApostaEspecifica() {
		Time time = new Time("007_RJ", "Flamengo", "Uruubu");
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		Aposta aposta = new Aposta(time, campeonato, 2, 5);
		ApostaRepository apostas = new ApostaRepository();
		apostas.registrarAposta(aposta);
		assertEquals(aposta, apostas.apostaEspecifica(0));
	}
	
	@DisplayName("Aposta Específica Com Indíce Negativo")
	@Test
	void testApostaEspecificaComIndiceNegativo() {
		ApostaRepository apostas = new ApostaRepository();
		String out = "ENTRADA INVÁLIDA";
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> apostas.apostaEspecifica(-1));
		assertEquals(out, e.getMessage());
	}

}
