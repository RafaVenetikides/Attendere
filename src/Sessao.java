import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao implements Comparable<Sessao>{
	private Filme filme;
	private Local local;
	private Double preco;
	private LocalDate data;
	private LocalTime horario;
	
	// opcional
	private String comentario;

	public Sessao(Filme filme, Local local, Double preco, LocalDate data, LocalTime horario, String comentario) {
		this.filme = filme;
		this.local = local;
		this.preco = preco;
		this.data = data;
		this.horario = horario;
		this.comentario = comentario;
	}

	public Sessao(Filme filme, Local local, Double preco, LocalDate data, LocalTime horario) {
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
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
		if (comentario == null){
			return "\t========== Sessao ==========" +
					"\n" + filme +
					"\n\tPreco: " + preco +
					"\n\tData: " + data +
					"\n\tHorario: " + horario +
					"\n" + local
					+ "\n\t=============================" +
					"\n\n";
		}else {
			return "\t========== Sessao ==========" +
					"\n" + filme +
					"\n\tPreco: " + preco +
					"\n\tData: " + data +
					"\n\tHorario: " + horario +
					"\n\tComentario: " + comentario +
					"\n" + local
					+ "\n\t=============================" +
					"\n\n";
		}

	}

	public String comentarioToString(){
		return "Comentario: " + filme.getComentario();
	}
	public String avaliacaoToString(){
		return "Avaliação: " + filme.getNota();
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
