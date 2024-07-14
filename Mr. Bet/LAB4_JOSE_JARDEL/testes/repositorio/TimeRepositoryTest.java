package repositorio;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Time;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class TimeRepositoryTest {

	@DisplayName("Adicionar time com sucesso")
	@Test
	void testAdicionarTimeComSucesso() {
		String out = "INCLUSÃO REALIZADA";
		TimeRepository times = new TimeRepository();
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		assertEquals(out, times.adicionarTime("007_RJ", time));
	}
	
	@DisplayName("Adicionar time que já existe")
	@Test
	void testAdicionarTimeQueJaExiste() {
		String out = "TIME JÁ EXISTE";
		TimeRepository times = new TimeRepository();
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		times.adicionarTime("007_RJ", time);
		assertEquals(out, times.adicionarTime("007_RJ", time));
	}
	
	@DisplayName("Puxar time com sucesso")
	@Test
	void testPuxarTimeComSucesso() {
		TimeRepository times = new TimeRepository();
		Time time = new Time("007_RJ", "Flamengo", "Urubu");
		times.adicionarTime("007_RJ", time);
		assertEquals(time, times.timeEspecifico("007_RJ"));
	}
	
	@DisplayName("Puxar time que não existe")
	@Test
	void testPuxarTimeQueNaoExiste() {
		String out = "O TIME NÃO EXISTE!";
		TimeRepository times = new TimeRepository();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> times.timeEspecifico("002_SP")); 
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Puxar time com código nulo")
	@Test
	void testPuxarTimeQueComCodigoNulo() {
		String out = "ENTRADA INVÁLIDA";
		TimeRepository times = new TimeRepository();
		NullPointerException e = assertThrows(NullPointerException.class, () -> times.timeEspecifico(null)); 
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Puxar time com código vazio")
	@Test
	void testPuxarTimeQueComCodigoVazio() {
		String out = "ENTRADA INVÁLIDA";
		TimeRepository times = new TimeRepository();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> times.timeEspecifico("")); 
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Puxar time com código vazio com espaço")
	@Test
	void testPuxarTimeQueComCodigoVazioComEspaço() {
		String out = "ENTRADA INVÁLIDA";
		TimeRepository times = new TimeRepository();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> times.timeEspecifico(" ")); 
		assertEquals(out, e.getMessage());
	}
	
	


}
