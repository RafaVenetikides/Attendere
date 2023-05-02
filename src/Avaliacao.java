// haverá as seguintes opções
// 5 - Excelente
// 4 - Muito bom
// 3 - Bom
// 2 - Regular
// 1 - Ruim

public enum Avaliacao {
    five, four, three, two, one;
    public static Avaliacao fromInt(int valor){
        return switch (valor) {
            case 1 -> one;
            case 2 -> two;
            case 3 -> three;
            case 4 -> four;
            case 5 -> five;
            default -> throw new IllegalStateException("Unexpected value: " + valor);
        };
    }
}
