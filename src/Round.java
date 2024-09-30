import java.util.ArrayList;
import java.util.List;

public class Round {

    // Variável que armazena as cartas geradas na rodada atual
    private final Carta[] round;
    public Carta[] getRound() {
        return round;
    }

    // Variável que armazena as manilhas da rodada
    private final Manilha manilha;
    public String getManilha() {
        return manilha.showCard();
    }

    // O construtor faz a variável receber o metodo que cria o round
    public Round() {

        // Instanciando as manilhas atuais
        this.manilha = new Manilha();
        manilha.getManilhas().forEach(m -> System.out.println(m));

        // Gerando o round na variavel round
        this.round = generateRound();


    }

    // Metodo que gera o round, coloca as cartas em um array
    private Carta[] generateRound() {


        // Array com todas as cartas da rodada
        final Carta[] hand = new Carta[7];

        // Lista usada para a não repeticao de cartas
        List<String> usedCards = new ArrayList<String>();


        // Iteracao com For utilizando Do e While, ou seja, fará o que está em "Do" enquanto o while for verdadeiro
        // Metodo utilizado para evitar a repeticao de cartas
        for (int i = 0; i < 6; i++) {

            Carta newCard;
            String cardValue;

            do {
                newCard = new Carta();
                cardValue = newCard.showCard();
            } while (usedCards.contains(cardValue));

            hand[i] = newCard;
            usedCards.add(cardValue);
            hand[6] = this.manilha;

        }

        // Retorno das cartas da rodada
        return hand;
    }

    // Metodo que mostra a sua mao atual da rodada
    public String[] showHand() {

        String[] hand = new String[3];

        for (int i = 0; i < 3; i++) {
            hand[i] = round[i].showCard();
        }

        return hand;

    }

}
