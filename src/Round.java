import java.util.ArrayList;
import java.util.List;

interface Hands {

    static List<Carta> hands(Carta[] round, int begin, int end) {

        List<Carta> hand = new ArrayList<>();

        for (int i = begin; i < end; i++) {
            hand.add(round[i]);
        }

        return hand;
    }
}

public class Round implements Hands{

    // Variável que armazena as cartas geradas na rodada atual
    private final Carta[] round;
    public Carta[] getRound() {
        return round;
    }

    // Variável que armazena as manilhas da rodada
    private final Manilha manilha;
    public String getVira() {
        return manilha.showCard();
    }

    // O construtor faz a variável receber o metodo que cria o round
    public Round() {

        // Instanciando as manilhas atuais
        this.manilha = new Manilha();

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
    public List<Carta> showHand() {

        return Hands.hands(round, 0, 3);

    }

    public List<Carta> enemyHand() {

        return Hands.hands(round, 3, 6);

    }


    // Metodo que retorna em um ArrayList as manilhas da rodada
    public List<String> showManilhas() {

        return manilha.getManilhas();

    }

}
