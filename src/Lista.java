import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// lista agrega todas as sessões
// ela encapsula um arraylist de forma
// a esconder sua estrutura interna 
public class Lista implements Iterable<Sessao>{
	private ArrayList<Sessao> lista;

	// construtor

	public Lista() {
		this.lista = new ArrayList<Sessao>();
	}

	// getters e setters

	public ArrayList<Sessao> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Sessao> lista) {
		this.lista = lista;
	}

	// outros para ORDENACAO
	public void add(Sessao sessao){
		lista.add(sessao);
	}
	public ArrayList<Sessao> ordenaZA(){
		ArrayList<Sessao> copia = new ArrayList<Sessao>();
		copia.addAll(lista);
		Collections.sort(copia, Collections.reverseOrder());
		return copia;
	}
	
	@Override
	public Iterator<Sessao> iterator() {
		return lista.iterator();
	}

	public void ordemAlfabetica(){
		Collections.sort(lista);
	}

	public void sortAvaliacao(){
		Collections.sort(lista, new Comparator<Sessao>() {
			@Override
			public int compare(Sessao o1, Sessao o2) {
				if (o1.getFilme().getNota() == o2.getFilme().getNota()){
					return o1.getFilme().getNome().compareToIgnoreCase(o2.getFilme().getNome());
				}
				return o1.getFilme().getNota().compareTo(o2.getFilme().getNota());
			}
		});
	}
	
	// toString

}
