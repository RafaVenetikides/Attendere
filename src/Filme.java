
public class Filme {
	private String nome;
	private Avaliacao nota;
	private Boolean favorito;
	// opcional
	private String comentario;
	// ter um atributo comentário no filme OU Sessão
	// se feito nos dois, é bônus

	private Genero genero;
	public Filme(String nome, Genero genero, boolean favorito, Avaliacao nota, String comentario) {
		this.nome = nome;
		this.nota = nota;
		this.genero = genero;
		this.favorito = favorito;
		this.comentario = comentario;
	}

	public Filme(String nome, Genero genero, boolean favorito) {
		this.nome = nome;
		this.genero = genero;
		this.favorito = favorito;
	}

	public Filme(String nome, Genero genero, boolean favorito, Avaliacao nota) {
		this.nome = nome;
		this.genero = genero;
		this.nota = nota;
		this.favorito = favorito;
	}

	public Filme(String nome, Genero genero, boolean favorito, String comentario) {
		this.nome = nome;
		this.genero = genero;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		if (nota == null && comentario == null){
			return "\t---------- Filme ----------" +
					"\n\tNome: " + nome +
					"\n\t" + genero +
					"\n\tFavorito: " + favorito;
		} else if (nota == null) {
			return "\t---------- Filme ----------" +
					"\n\tNome:" + nome +
					"\n\t" + genero +
					"\n\tFavorito: " + favorito +
					"\n\tcomentario do filme: " + comentario;
		} else if (comentario == null) {
			return "\t---------- Filme ----------" +
					"\n\tNome:" + nome +
					"\n\t" + genero +
					"\n\tNota:" + nota.getDescricao() +
					"\n\tFavorito: " + favorito;
		} else {
			return "\t---------- Filme ----------" +
					"\n\tNome:" + nome +
					"\n\t" + genero +
					"\n\tNota:" + nota.getDescricao() +
					"\n\tFavorito: " + favorito +
					"\n\tcomentario do Filme: " + comentario;
		}
	}

	// outro adicional
	// private Genero genero;

}
