import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// lista agrega todas as sessões
// ela encapsula um arraylist de forma
// a esconder sua estrutura interna 
public class Lista implements Iterable<Sessao>{
	private ArrayList<Sessao> lista;

	// construtor

	public Lista(ArrayList<Sessao> lista) {
		this.lista = lista;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	// toString

}
