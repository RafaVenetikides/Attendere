import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacao {
	
	// usar a lista de sessões
	private static Lista watchlist = new Lista();
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

		Sessao s1 = new Sessao(new Filme("Star Wars",  true, Avaliacao.fromInt(5),"legal :)"),
					new Local("Muller", "Cinemark"),
					15.50F, LocalDate.of(2022, 7, 12), LocalTime.of(12, 30));
		Sessao s2 = new Sessao(new Filme("Hobbit",  true, Avaliacao.fromInt(4),"massa :D"),
				new Local("Barigui", "Cinemark"),
				21.50F, LocalDate.of(2023, 8, 2), LocalTime.of(15, 0));
		Sessao s3 = new Sessao(new Filme("Zombieland",  false, Avaliacao.fromInt(4),"bom :)"),
				new Local("Jockey", "Cinepolis"),
				35.50F, LocalDate.of(2020, 9, 22), LocalTime.of(17, 45));
		watchlist.add(s1);
		watchlist.add(s2);
		watchlist.add(s3);

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
			System.out.print("\nOpção: ");
			opcao = teclado.nextInt();
			teclado.nextLine();
			switch (opcao){
				case 1:
					watchlist.add(novaSessao());
					break;
				case 4:
					watchlist.ordemAlfabetica();
					imprimelista();
					break;
				case 5:
					watchlist.sortAvaliacao();
					imprimelista();
					break;
				case 6:
					watchlist.sortCronologico();
					imprimelista();
					break;
				case 7:
					watchlist.sortFavorito();
					imprimelista();
					break;
			}

		} while(opcao != 0);
	}
	private static Filme novoFilme(){
		String nome;
		Boolean favorito;
		Avaliacao avaliacao = null;
		String comentario = null;
		System.out.println("======= DADOS DO FILME =======");
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
		if (resposta.equalsIgnoreCase("S")) {
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
	private static Local novolocal(){

		String nome;
		String franquia;

		System.out.println("======= NOVO LOCAL =======");

		System.out.println("Qual o nome do local da sessão?");
		nome = teclado.nextLine();

		System.out.println("Qual a franquia da sessão?");
		franquia = teclado.nextLine();

		System.out.println("==============================");

		return new Local(nome, franquia);
	}
	private static Sessao novaSessao(){

		String comentario = null;
		String opcao;
		float preco;
		String data;
		int dia;
		int mes;
		int ano;
		String horario;
		int hour;
		int min;

		System.out.println("======= DADOS DA SESSÃO =======");

		System.out.println("Qual foi o preco do ingresso?");
		preco = teclado.nextFloat();
		teclado.nextLine();

		System.out.println("Qual foi a data da sua sessão? (DD/MM/AAAA)");
		data = teclado.nextLine();
		String vetdata[] = data.split("/");
		dia = Integer.parseInt(vetdata[0]);
		mes = Integer.parseInt(vetdata[1]);
		ano = Integer.parseInt(vetdata[2]);

		System.out.println("Qual o horario da sua sessão? (HH:MM)");
		horario = teclado.nextLine();
		String vethorario[] = horario.split(":");
		hour = Integer.parseInt(vethorario[0]);
		min = Integer.parseInt(vethorario[1]);

		System.out.println("Gostaria de comentar sobre a sessão? (S/N)");
		opcao = teclado.nextLine();
		if (opcao.equalsIgnoreCase("S")){
			System.out.print("comentario: ");
			comentario = teclado.nextLine();
		}
		if (comentario == null){
			return new Sessao(novoFilme(), novolocal(), preco, LocalDate.of(ano, mes, dia), LocalTime.of(hour, min));
		} else {
			return new Sessao(novoFilme(), novolocal(), preco, LocalDate.of(ano, mes, dia), LocalTime.of(hour, min), comentario);
		}
	}
	private static void imprimelista(){
		Iterator<Sessao> iterator = watchlist.iterator();
		while (iterator.hasNext()){
			Sessao sessao = iterator.next();
			System.out.println(sessao);
		}
	}
}


