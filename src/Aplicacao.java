import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
	
	// usar a lista de sessões
	private static Lista lista;
	// para simular o banco de dados dos locais
	private ArrayList<Local> locais;
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
			System.out.println("0 - sair");
			System.out.println("1 - Cadastrar filme");
			System.out.println("2 - Mostrar dados filme (filme, sessão)");
			System.out.println("3 - Editar filme");
			System.out.println("4 - Listagem ordem alfabética");
			System.out.println("5 - Listagem ordem avaliação");
			System.out.println("6 - Listagem cronológica");
			System.out.println("7 - Listagem favoritos");
			System.out.print("\nOpcao: ");
			opcao = teclado.nextInt();
			teclado.nextLine();
			switch (opcao){
				case 1:

			}
		} while(opcao != 0);
	}
	private static Filme leFilme(){
		String nome;
		Boolean favorito;
		Avaliacao avaliacao;
		String comentario;
		System.out.println("====== NOVO FILME ======");
		System.out.print("Informe o nome: ");
		nome = teclado.nextLine();
		System.out.println("Deseja adicionar o Filme aos favoritos? (S/N)");
		String resposta = teclado.nextLine();
		favorito = resposta.toUpperCase().charAt(0) == 'S';
		return new Filme(nome, favorito);
	}
}


