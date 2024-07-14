package repositorio;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Campeonato;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class CampeonatoRepositoryTest {

	@DisplayName("Adicionar campeonato com sucesso")
	@Test
	void testAdicionarCampeonatoComSucesso() {
		String out = "INCLUSÃO REALIZADA";
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		assertEquals(out, campeonatos.adicionarCampeonato("Brasileirão", campeonato));
	}
	
	@DisplayName("Adicionar campeonato que já existe")
	@Test
	void testAdicionarCampeonatoQueJáExiste() {
		String out = "CAMPEONATO JÁ EXISTE";
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonatos.adicionarCampeonato("Brasileirão", campeonato);
		assertEquals(out, campeonatos.adicionarCampeonato("Brasileirão", campeonato));
	}
	
	@DisplayName("Puxar campeonato com sucesso")
	@Test
	void testPuxarCampeonatoComSucesso() {
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonatos.adicionarCampeonato("Brasileirão", campeonato);
		assertEquals(campeonato, campeonatos.puxarCampeonato("Brasileirão"));
	}
	
	@DisplayName("Puxar campeonato com nome do campeonato com diferença de letra maiúscula e minúscula")
	@Test
	void testPuxarCampeonatoComDiferençaNasLetrasMaiúsculasEMinúsuculas() {
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonatos.adicionarCampeonato("Brasileirão", campeonato);
		assertEquals(campeonato, campeonatos.puxarCampeonato("braSILeirão"));
	}
	
	@DisplayName("Puxar campeonato que não existe")
	@Test
	void testPuxarCampeonatoQueNãoExiste() {
		String out = "O CAMPEONATO NÃO EXISTE!";
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> campeonatos.puxarCampeonato("Champions")); 
		assertEquals(out, e.getMessage());
	
	}
	
	@DisplayName("Puxar campeonato com nome nulo")
	@Test
	void testPuxarCampeonatoComNomeNulo() {
		String out = "ENTRADA INVÁLIDA";
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonatos.adicionarCampeonato("Brasileirão", campeonato);
		NullPointerException e = assertThrows(NullPointerException.class, () -> campeonatos.puxarCampeonato(null)); 
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Puxar campeonato com nome vazio")
	@Test
	void testPuxarCampeonatoComNomeVazio() {
		String out = "ENTRADA INVÁLIDA";
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonatos.adicionarCampeonato("Brasileirão", campeonato);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> campeonatos.puxarCampeonato("")); 
		assertEquals(out, e.getMessage());
	}
	
	@DisplayName("Puxar campeonato com nome vazio com espaço")
	@Test
	void testPuxarCampeonatoComNomeVazioComEspaco() {
		String out = "ENTRADA INVÁLIDA";
		CampeonatoRepository campeonatos = new CampeonatoRepository();
		Campeonato campeonato = new Campeonato("Brasileirão", 5);
		campeonatos.adicionarCampeonato("Brasileirão", campeonato);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> campeonatos.puxarCampeonato(" ")); 
		assertEquals(out, e.getMessage());
	}
	
	
	

}
