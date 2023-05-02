import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
	
	// usar a lista de sessões
	private static Lista watchlist;
	// para simular o banco de dados dos locais
	private static ArrayList<Local> locais;

	private static Scanner teclado = new Scanner(System.in);
	// scanner
	// etc..
	
	public static void main(String[] args) {

		int opcao;
		// apresentar o menu principal
		// 0 - sair
		// 1 - Cadastrar filme
		// 2 - Mostrar dados filme (filme, sessão)
		// 3 - Editar filme 
		//      muda apenas a avaliação e comentário
		// 4 - Listagem ordem alfabética
		// 5 - Listagem ordem avaliação
		// 6 - Listagem cronológica
		// 7 - Listagem favoritos

		do{
			System.out.println("+-------------------------------------------+");
			System.out.println("|                 Attendere                 |");
			System.out.println("+-------------------------------------------+");
			System.out.println("| 0 - sair                                  |");
			System.out.println("| 1 - Cadastrar filme                       |");
			System.out.println("| 2 - Mostrar dados filme (filme, sessão)   |");
			System.out.println("| 3 - Editar filme                          |");
			System.out.println("| 4 - Listagem ordem alfabética             |");
			System.out.println("| 5 - Listagem ordem avaliação              |");
			System.out.println("| 6 - Listagem cronológica                  |");
			System.out.println("| 7 - Listagem favoritos                    |");
			System.out.println("+-------------------------------------------+");
			System.out.print("\nOpcao: ");
			opcao = teclado.nextInt();
			teclado.nextLine();
			switch (opcao){
				case 1:
					watchlist.add(novaSessao(new Local("Agua verde", "Cinemark")));
					break;
			}

		} while(opcao != 0);
	}
	private static Filme novoFilme(){
		String nome;
		Boolean favorito;
		Avaliacao avaliacao = null;
		String comentario = null;
		System.out.println(" NOVO FILME ");
		System.out.print("Informe o nome: ");
		nome = teclado.nextLine();
		System.out.println("Deseja adicionar o Filme aos favoritos? (S/N)");
		String resposta = teclado.nextLine();
		favorito = resposta.toUpperCase().charAt(0) == 'S';
		System.out.println("Deseja avaliar o filme? (S/N)");
		resposta = teclado.nextLine();
		if (resposta.equalsIgnoreCase("S")) {
			int estrelas;
			do {
				System.out.println("Qual a sua avaliação de 1-5?");
				estrelas = teclado.nextInt();
				teclado.nextLine();
			} while ((0>=estrelas) || (6<=estrelas));
			avaliacao = Avaliacao.fromInt(estrelas);
		}
		System.out.println("Deseja comentar o filme? (S/N)");
		resposta = teclado.nextLine();
		if (resposta.equalsIgnoreCase("S")){
			System.out.print("Comentário: ");
			comentario = teclado.nextLine();
		}
		if(avaliacao == null && comentario == null){
			return new Filme(nome, favorito);
		} else if (avaliacao == null) {
			return new Filme(nome, favorito, comentario);
		} else{
			return new Filme(nome, favorito, avaliacao);
		}
	}
	private static Sessao novaSessao(Local local){
		int preco;
		int dia;
		int mes;
		int ano;
		int hour;
		int min;
		System.out.println("Qual foi o preco do ingresso?");
		preco = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Qual foi o dia da sua sessão?");
		dia = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Qual foi o mês da sua sessão?");
		mes = teclado.nextInt();
		teclado.nextInt();
		System.out.println("Qual foi o ano da sua sessão?");
		ano = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Qual a hora da sessão?");
		hour = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Qual os minutos da sessão?");
		min = teclado.nextInt();
		teclado.nextLine();

		Sessao sessao = new Sessao(novoFilme(), local, preco, LocalDate.of(ano, mes, dia), LocalTime.of(hour, min));
		return sessao;
	}
}


