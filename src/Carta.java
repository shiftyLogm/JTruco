public class Carta {

    // String carta que recebe o valor da carta
    private final String carta;
    public String getCarta() {
        return this.carta;
    }

    // Char que recebe o simbolo do Naipe escolhido
    private final char naipe;
    public char getNaipe() {
        return this.naipe;
    }

    // Construtor criando uma nova carta
    public Carta() {

        Baralho card = new Baralho();
        this.carta = card.getRandomCard();
        this.naipe = Naipe.getRandomNaipe();

    }

    // Gerar uma carta
    public String showCard() {

        // O metodo do objeto baralho gera uma carta aleatoria que é concatenada com um indice do Enum de Naipes
        return carta + naipe;

    }



}
