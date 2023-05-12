import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Aplicacao {
	
	// usar a lista de sessões
	private static Lista watchlist = new Lista();
	// para simular o banco de dados dos locais
	private static ArrayList<Local> locais = new ArrayList<Local>();

	private static ArrayList<Genero> generos = new ArrayList<Genero>();

	private static Scanner teclado = new Scanner(System.in);
	// scanner
	// etc..
    private static DateTimeFormatter formattermesano = DateTimeFormatter.ofPattern("MMMM/yyy", new Locale("pt", "BR"));
    private static DateTimeFormatter formatterdata = DateTimeFormatter.ofPattern("dd (EE HH:mm)", new Locale("pt", "BR"));
    private static DateTimeFormatter formatterdattacompleta = DateTimeFormatter.ofPattern("dd/MM/yyyy, EEEE", new Locale("pt", "BR"));

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

		Local l1 = new Local("Muller", "Cinemark");
		Local l2 = new Local("Barigui", "Cinemark");
		Local l3 = new Local("Jockey Plaza", "Cinepolis");

		locais.add(l1);
		locais.add(l2);
		locais.add(l3);

		Genero g1 = new Genero("Ação");
		Genero g2 = new Genero("Fantasia");
		Genero g3 = new Genero("Scifi");
		Genero g4 = new Genero("Zombie");

		generos.add(g1);
		generos.add(g2);
		generos.add(g3);
		generos.add(g4);

		Sessao s1 = new Sessao(new Filme("Star Wars: Uma Nova Esperança", generos.get(2) ,true, Avaliacao.fromInt(4),"legal :)"),
					locais.get(0),
					15.50, LocalDate.of(2022, 7, 12), LocalTime.of(12, 30), "Pegamos ótimos lugares");
		Sessao s2 = new Sessao(new Filme("Hobbit",  generos.get(1),true, Avaliacao.fromInt(4),"massa :D"),
				locais.get(1),
				21.50, LocalDate.of(2023, 8, 2), LocalTime.of(15, 0));
		Sessao s3 = new Sessao(new Filme("Zombieland",  generos.get(3),false, Avaliacao.fromInt(4),"bom :)"),
				locais.get(2),
				35.50, LocalDate.of(2020, 9, 22), LocalTime.of(17, 45));
		Sessao s4 = new Sessao(new Filme("Star Wars: A Vingança dos Sith", generos.get(2) ,true, Avaliacao.fromInt(5),"muito bom :)"),
				locais.get(2),
				35.50, LocalDate.of(2021, 8, 19), LocalTime.of(18, 30));

		watchlist.add(s1);
		watchlist.add(s2);
		watchlist.add(s3);
		watchlist.add(s4);

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
				case 2:
					Sessao s = procuraSessao();

					if (s == null){
						System.out.println("Sessão não encontrada");
					} else {
						System.out.println(s);
					}
					break;
				case 3:
					Sessao session = procuraSessao();
					int escolha;

					if(session == null){
						System.out.println("Sessão não encontrada");
					} else{
						System.out.println(session.getFilme().getNome());
						System.out.println(session.avaliacaoToString());
						System.out.println(session.comentarioToString());
						System.out.println("O que deseja editar? ");
						System.out.println("1 - Avaliação");
						System.out.println("2 - Comentario");
						escolha = teclado.nextInt();
						teclado.nextLine();
						if (escolha == 1){
							System.out.print("Defina a nova nota: ");
							session.getFilme().setNota(Avaliacao.fromInt(teclado.nextInt()));
							teclado.nextLine();
							System.out.println("Nova nota definida");
						} else if (escolha == 2) {
							System.out.print("Defina o novo comentario: ");
							session.getFilme().setComentario(teclado.nextLine());
						} else {
							System.out.println("Opção inválida");
						}
					}
					break;
				case 4:
					watchlist.ordemAlfabetica();
					imprimeAZ();
					break;
				case 5:
					watchlist.sortAvaliacao();
					imprimeAvaliacao();
					break;
				case 6:
					watchlist.sortCronologico();
					imprimeOrdemCronologica();
					break;
				case 7:
					watchlist.sortFavorito();
					imprimeFavoritos();
					break;
			}

		} while(opcao != 0);
	}
	private static Filme novoFilme(){
		String nome;
		Boolean favorito;
		Avaliacao avaliacao = null;
		String comentario = null;
		Genero genero = new Genero();
		System.out.println("======= DADOS DO FILME =======");
		System.out.print("Informe o nome: ");
		nome = teclado.nextLine();
		genero = escolheGenero();
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
			return new Filme(nome, genero, favorito);
		} else if (avaliacao == null) {
			return new Filme(nome, genero,favorito, comentario);
		} else{
			return new Filme(nome, genero,favorito, avaliacao);
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

		Local local = new Local(nome, franquia);
		locais.add(local);

		return local;
	}
	private static Sessao novaSessao(){

		Local local;
		String comentario = null;
		String opcao;
		Double preco;
		String data;
		int dia;
		int mes;
		int ano;
		String horario;
		int hour;
		int min;
		int escolha;
		Filme filme;

		System.out.println("========== DADOS DA SESSÃO ==========");

		filme = novoFilme();

		System.out.println("Qual foi o preco do ingresso?");
		preco = teclado.nextDouble();
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
		System.out.println("Qual foi o local da sessao? ");
		System.out.println("[0] - Novo local");
		for(int i = 0; i < locais.size(); i++){
			System.out.println("[" + (i+1) + "] - " + locais.get(i).getNome() + " (" + locais.get(i).getFranquia() + ")");
		}
		escolha = teclado.nextInt();
		teclado.nextLine();
		if (escolha == 0){
			local = novolocal();
		}
		else{
			local = locais.get(escolha-1);
		}
		if (comentario == null){
			return new Sessao(filme, local, preco, LocalDate.of(ano, mes, dia), LocalTime.of(hour, min));
		} else {
			return new Sessao(filme, local, preco, LocalDate.of(ano, mes, dia), LocalTime.of(hour, min), comentario);
		}
	}
	private static void imprimelista(){
		for (Sessao sessao : watchlist) {
			System.out.println(sessao);
		}
	}
    private static void imprimeAZ(){
        System.out.println("Listagem em ordem alfabética: \n");
        for(Sessao s : watchlist){
            System.out.println(s.getFilme().getNome() + " " + formatterdattacompleta.format(s.getData()) + " - " + s.getLocal().getNome());
        }
        System.out.println("\n");
    }
	private static void imprimeOrdemCronologica(){
		int flag = 0;
        System.out.println("Listagem em ordem cronológica: \n");
		for(int i = 0; i < watchlist.getTamanho(); i++){
			Sessao s = watchlist.get(i);
			if(flag == 1) {
				if((watchlist.get(i-1).getData().getMonth() != s.getData().getMonth()) || (watchlist.get(i-1).getData().getYear() != s.getData().getYear())) {
					System.out.println(formattermesano.format(s.getData()));
					System.out.println(formatterdata.format(s.getData().atTime(s.getHorario()))  + " - " + s.getFilme().getNome() + " - " + s.getLocal().getNome());
				} else {
					System.out.println(formatterdata.format(s.getData().atTime(s.getHorario()))  + " - " + s.getFilme().getNome() + " - " + s.getLocal().getNome());
				}
			} else {
				System.out.println(formattermesano.format(s.getData()));
				System.out.println(formatterdata.format(s.getData().atTime(s.getHorario()))  + " - " + s.getFilme().getNome() + " - " + s.getLocal().getNome());
				flag = 1;
			}
		}
        System.out.println("\n");
	}
    private static void imprimeAvaliacao(){
        int flag = 0;
        System.out.println("Listagem por avaliação: \n");
        for(int i = 0; i < watchlist.getTamanho(); i++){
            Sessao s = watchlist.get(i);
            if(flag == 1){
                if (watchlist.get(i-1).getFilme().getNota() != s.getFilme().getNota()){
                    System.out.println("(" + s.getFilme().getNota().getDescricao() + ")");
                    System.out.println(s.getFilme().getNome() + formatterdattacompleta.format(s.getData()) + " - " + s.getLocal().getNome());
                } else {
                    System.out.println(s.getFilme().getNome() + formatterdattacompleta.format(s.getData()) + " - " + s.getLocal().getNome());
                }
            } else{
                System.out.println("(" + s.getFilme().getNota().getDescricao() + ")");
                System.out.println(s.getFilme().getNome() + " " + formatterdattacompleta.format(s.getData()) + " - " + s.getLocal().getNome());
                flag = 1;
            }
        }
        System.out.println("\n");
    }
    private static void imprimeFavoritos(){
        System.out.println("Listagem dos favoritos: \n");
        for(Sessao s : watchlist){
            if(s.getFilme().isFavorito()){
                System.out.println(s.getFilme().getNome() + " " + formatterdattacompleta.format(s.getData()) + " - " + s.getLocal().getNome());
            }
        }
        System.out.println("\n");
    }
	private static Sessao procuraSessao(){

		String nome;
		String resposta;

		System.out.println("Qual filme deseja pesquisar?");
		nome = teclado.nextLine();

		for (Sessao s : watchlist){
			if (s.getFilme().getNome().toLowerCase().startsWith(nome.toLowerCase())){
				System.out.println(s.getFilme().getNome() + " é o filme procurado? (S/N)");
				resposta = teclado.nextLine();
				if (resposta.equalsIgnoreCase("S")){
					return s;
				} else System.out.println();
			}
		}
		return null;
	}
	private static Genero escolheGenero(){
		int opcao;

		System.out.println("Qual o genero do filme? ");
		System.out.println("[0] - Novo Genero");
		for(int i = 0; i < generos.size(); i++){
			System.out.println("[" + (i+1) + "] - " + generos.get(i).getNome());
		}
		opcao = teclado.nextInt();
		teclado.nextLine();
		if (opcao == 0){
			return novoGenero();
		}else {
			return generos.get(opcao-1);
		}
	}
	private static Genero novoGenero(){
		String nome;
		Genero g = new Genero();

		System.out.print("Informe o nome do Genero: ");
		nome = teclado.nextLine();

		g.setNome(nome);
		generos.add(g);
		return g;
	}
}



