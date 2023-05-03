
public class Local {
	private String nome;
	private String franquia;

	public Local(String nome, String franquia) {
		this.nome = nome;
		this.franquia = franquia;
	}
	// eventualmente outros atributos
	
	// exemplos:
	// private String franquia; // Cinemark, etc
	// comentário


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	@Override
	public String toString() {
		return "\t---------- Local ----------" +
				"\n\tNome: " + nome +
				"\n\tFranquia: " + franquia;
	}
}
