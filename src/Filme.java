
public class Filme {
	private String nome;
	private Avaliacao nota;
	private Boolean favorito;
	// opcional
	private String comentario;
	// ter um atributo comentário no filme OU Sessão
	// se feito nos dois, é bônus

	public Filme(String nome, boolean favorito, Avaliacao nota, String comentario) {
		this.nome = nome;
		this.nota = nota;
		this.favorito = favorito;
		this.comentario = comentario;
	}

	public Filme(String nome, boolean favorito) {
		this.nome = nome;
		this.favorito = favorito;
	}

	public Filme(String nome,  boolean favorito, Avaliacao nota) {
		this.nome = nome;
		this.nota = nota;
		this.favorito = favorito;
	}

	public Filme(String nome, boolean favorito, String comentario) {
		this.nome = nome;
		this.favorito = favorito;
		this.comentario = comentario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Avaliacao getNota() {
		return nota;
	}

	public void setNota(Avaliacao nota) {
		this.nota = nota;
	}

	public Boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Filme{" +
				"nome='" + nome + '\'' +
				", nota=" + nota +
				", favorito=" + favorito +
				", comentario='" + comentario + '\'' +
				'}';
	}

	// outro adicional
	// private Genero genero;

}
