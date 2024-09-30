import java.util.Random;

public class Baralho {

    // Array com as cartas usada no truco
    private final String[] baralho = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};

    // Get do baralho
    public String[] getBaralho() {
        return this.baralho;
    }
    // Retornar carta aleatória
    public String getRandomCard() {

        // Retornar carta aleatória do array de baralho com base em seu index
        return baralho[new Random().nextInt(baralho.length)];

    }


}
