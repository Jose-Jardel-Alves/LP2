package main;
import java.util.Scanner;
import controlador.SistemaMrBet;
public class Main {
	
	public static void main(String[] args) {
		SistemaMrBet mrBet = new SistemaMrBet();
		String escolha = "";
		while(!escolha.equals("!")) {
			Scanner scanner = new Scanner(System.in);
			escolha = exibeMenu(scanner);
			try {
				opcoes(escolha, mrBet, scanner);				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static String exibeMenu(Scanner scanner) {
		System.out.println("(M)Minha inclusão de times\n"
				+ "(R)Recuperar time\n"
				+ "(.)Adicionar campeonato\n"
				+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
				+ "(E)Exibir campeonatos que o time participa\n"
				+ "(T)Tentar a sorte e status\n"
				+ "(!)Já pode fechar o programa!\n");
		return scanner.next().toUpperCase();
	}
	
	private static String exibeSubMenu1(Scanner scanner) {
		System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		return scanner.next().toUpperCase();
	}
	private static String exibeSubMenu2(Scanner scanner) {
		System.out.println("(A)Apostar ou (S)Status das Apostas? ");
		return scanner.next().toUpperCase();
	}
	private static void opcoes(String escolha, SistemaMrBet mrBet, Scanner scanner) {
		
		switch (escolha){
		
		case "M":
			incluirTimes(scanner, mrBet);
			break;
		case "R":
			recuperarTime(scanner, mrBet);
			break;
		case ".":
			adicionarCampeonato(scanner, mrBet);
			break;
		case "B":
			boraIncluirTimeEmCampeonato(scanner, mrBet);
			break;
		case "E":
			exibirCampeonatosQueOTimeParticipa(scanner, mrBet);
			break;
		case "T":
			tentarASorte(scanner, mrBet);
		case "!":
			fecharPrograma(mrBet);
			break;
		default:
			System.out.println("Opção Inválida");
		}
		
	}
	
	private static void incluirTimes(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Mascote: ");
		String mascote = scanner.nextLine();
		try {
			System.out.println(mrBet.incluirTimes(codigo, nome, mascote));
			
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void recuperarTime(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		try {
			System.out.println(mrBet.recuperarTimes(codigo));
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void adicionarCampeonato(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Campeonato: ");
		String nomeDoCampeonato = scanner.nextLine();
		int quantidadeDeTImes = scanner.nextInt();
		try {
			System.out.println(mrBet.adicionarCampeonato(nomeDoCampeonato, quantidadeDeTImes));
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	private static void boraIncluirTimeEmCampeonato(Scanner scanner, SistemaMrBet mrBet) {
		String escolha = exibeSubMenu1(scanner);
		switch (escolha) {
		case "I":
			incluirTimeEmCampeonato(scanner, mrBet);
			break;
		case "V":
			verificarSeTimeEstaEmCampeonato(scanner, mrBet);
			break;	
		}
	}
	
	private static void incluirTimeEmCampeonato(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Código: ");
		String codigoDoTime = scanner.nextLine();
		System.out.println("Campeonato: ");
		String nomeDoCampeonato = scanner.nextLine();
		
		try {
			System.out.println(mrBet.incluirTimeEmCampeonato(nomeDoCampeonato, codigoDoTime));
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void verificarSeTimeEstaEmCampeonato(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Código: ");
		String codigoDoTime = scanner.nextLine();
		System.out.println("Campeonato: ");
		String nomeDoCampeonato = scanner.nextLine();
		
		try {
			System.out.println(mrBet.verificarSeTimeEstaNoCampeonato(codigoDoTime, nomeDoCampeonato));
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void exibirCampeonatosQueOTimeParticipa(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Código: ");
		String codigoDoTime = scanner.nextLine();
		
		try {
			System.out.println(mrBet.exibirCampeonatosTimeParticipa(codigoDoTime));
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void tentarASorte(Scanner scanner, SistemaMrBet mrBet) {
		String escolha = exibeSubMenu2(scanner);
		switch (escolha) {
		case "A":
			criarAposta(scanner, mrBet);
			break;
		case "S":
			statusApostas(mrBet);
			break;
		}
	}
	
	private static void criarAposta(Scanner scanner, SistemaMrBet mrBet) {
		scanner.nextLine();
		System.out.println("Código: ");
		String codigoDoTime = scanner.nextLine();
		System.out.println("Campeonato: ");
		String nomeDoCampeonato = scanner.nextLine();
		System.out.println("Colocação: ");
		int colocacao = scanner.nextInt();
		System.out.println("Valor: ");
		double valor = scanner.nextDouble();
		
		try {
			System.out.println(mrBet.criarAposta(codigoDoTime, nomeDoCampeonato, colocacao, valor));
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		} 	
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void statusApostas(SistemaMrBet mrBet) {
		System.out.println(mrBet.statusDasApostas());
	}
	
	private static void fecharPrograma(SistemaMrBet mrBet) {
		System.out.println(mrBet.fecharPrograma());
	}
}
	

