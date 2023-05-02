import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

public class Sessao implements Comparable<Sessao>{
	private Filme filme;
	private Local local;
	private float preco;
	private LocalDate data;
	private LocalTime horario;
	
	// opcional
	private String comentario;

	public Sessao(Filme filme, Local local, float preco, LocalDate data, LocalTime horario, String comentario) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.data = data;
		this.horario = horario;
		this.comentario = comentario;
	}

	public Sessao(Filme filme, Local local, float preco, LocalDate data, LocalTime horario) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.data = data;
		this.horario = horario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Sessao{" +
				"filme=" + filme +
				", local=" + local +
				", preco=" + preco +
				", data=" + data +
				", horario=" + horario +
				", comentario='" + comentario + '\'' +
				'}';
	}

	@Override
	public int compareTo(Sessao sessao) {
		return getFilme().getNome().compareToIgnoreCase(sessao.getFilme().getNome());
	}

	// ter um atributo comentário no filme OU Sessão
	// se feito nos dois, é bônus
	
	// PRECISA guardar a data e horário da sessão
	// opcao 1, LocalDateTime
	// opcao 2, separa em 2, LocalDate, LocalTime
	

}
