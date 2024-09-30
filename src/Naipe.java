import java.util.Random;

// Enum com os símbolos dos Naipes
public enum Naipe {
    OUROS('♦'),
    ESPADAS('♠'),
    COPAS('♥'),
    PAUS('♣');

    // Char contendo um símbolo selecionado
    private final char simbol;
    public char getSimbol() {
        return this.simbol;
    }
    // Index aleatório para retorno
    private static final Random idx = new Random();

    // Atribuição do símbolo
    Naipe(char simbol) {

        this.simbol = simbol;

    }

    // Metodo estático que retorna um símbolo aleatório de um naipe
    public static char getRandomNaipe() {

        Naipe[] naipes = values();
        return naipes[idx.nextInt(naipes.length)].simbol;

    }
}