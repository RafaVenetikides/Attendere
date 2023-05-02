
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


	@Override
	public String toString() {
		return "Local{" +
				"nome='" + nome + '\'' +
				", franquia='" + franquia + '\'' +
				'}';
	}
}
