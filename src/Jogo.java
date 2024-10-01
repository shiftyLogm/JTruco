import java.util.*;

public class Jogo {

    // Contadores de pontos
    private static int playerPoints = 0;
    public static int getPlayerPoints() {
        return playerPoints;
    }

    private static int enemyPoints = 0;
    public static int getEnemyPoints() {
        return enemyPoints;
    }

    private int yourCardValue, enemyCardValue, yourRoundPoints, enemyRoundPoints;

    public void round(List<Carta> yourHand, List<Carta> enemyHand) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lista de opcoes válida para verificacao
        List<String> validOptions = new ArrayList<>(Arrays.asList("1", "2", "3"));

        while (true) {

            if(this.yourRoundPoints == 2 || this.enemyRoundPoints == 2) break;

            System.out.println("-------------------------------------");
            // Iteração para mostrar as cartas e seus respectivos inputs de teclas para serem jogados
            int count = 1;

            for (Carta card : yourHand) {
                System.out.printf("Tecla %s: Jogar %s%n", count, card.showCard());
                count++;
            }

            System.out.println("-------------------------------------");

            // Loop While para verificar se o player usou alguma tecla invalida
            while(true) {

                System.out.print("Jogar carta: ");

                // Scanner que guarda a tecla e verifica se é uma opcao valida
                String cartaJogada = scanner.nextLine();

                // Se caso a tecla inputada esteja certa
                if (validOptions.contains(cartaJogada)) {

                    System.out.println("-------------------------------------");

                    // Cria um objeto "Carta" com as informacoes da carta jogada
                    Carta yourCard = yourHand.get(Integer.parseInt(cartaJogada) - 1);

                    // Mostrar a carta que voce jogou
                    System.out.printf("Jogou %s%n", yourCard.showCard());

                    // Remover a carta da mao, ela nao pode ser jogada novamente
                    yourHand.remove(Integer.parseInt(cartaJogada) - 1);

                    // Pegando uma carta da mao do inimigo (Vai ser implementado)
                    int idxEnemyCard = random.nextInt(validOptions.toArray().length);

                    // Cria um objeto "Carta" com as informacoes da carta jogada pelo inimigo
                    Carta enemyCard = enemyHand.get(idxEnemyCard);

                    System.out.printf("Inimigo jogou: %s%n", enemyCard.showCard());

                    // Remover a carta que o inimigo jogou
                    enemyHand.remove(idxEnemyCard);

                    validOptions.removeLast();

                    /*
                     Valores que serão usados para verificar o vencedor de cada jogada
                     Isso é com base na posição do indice da Lista, quanto mais pra frente
                     mais forte a carta, a exceçao é as Manilhas
                    */
                    this.yourCardValue = getIndexBaralho(yourCard);
                    this.enemyCardValue = getIndexBaralho(enemyCard);

                    System.out.println(yourCardValue > enemyCardValue ? "Venceu" : "Perdeu");

                    // Aumenta a quantidade de jogadas vencidas
                    this.yourRoundPoints += yourCardValue > enemyCardValue ? 1 : 0;
                    this.enemyRoundPoints += enemyCardValue > yourCardValue ? 1 : 0;

                    break;

                } else {
                    System.out.println("Tecla inválida");
                }
            }
        }

        // Aumentar os pontos com base na quantia vencidada da rodad
        Jogo.playerPoints += yourRoundPoints > enemyRoundPoints ? 1 : 0;
        Jogo.enemyPoints += enemyRoundPoints > yourRoundPoints ? 1 : 0;
    }

    // Retornar o index do baralho que contenha a carta da mão
    private static int getIndexBaralho (Carta carta) {

        Baralho baralho = new Baralho();

        return baralho.getBaralho().indexOf(carta.getCarta());

    }
}
