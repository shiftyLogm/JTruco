import java.util.*;

// Interface usada para jogar as cartas
interface JogarRound {

    // Metodo para jogar a carta
    static void round(List<String> yourHand, List<String> enemyHand){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lista de opcoes válida para verificacao
        List<String> validOptions = new ArrayList<>(Arrays.asList("1", "2", "3"));

        while (true) {

            System.out.println("-------------------------------------");
            // Iteração para mostrar as cartas e seus respectivos inputs de teclas para serem jogados
            int count = 1;
            for (String card : yourHand) {
                System.out.printf("Tecla %s: Jogar %s%n", count, card);
                count++;
            }
            System.out.println("-------------------------------------");

            // Loop While para verificar se o player usou alguma tecla invalida
            while(true) {

                System.out.print("Jogar carta: ");

                // Scanner que guarda a tecla e verifica se é uma opcao valida
                String cartaJogada = scanner.nextLine();

                if (validOptions.contains(cartaJogada)) {

                    System.out.println("-------------------------------------");
                    // Mostra a carta jogada e ja remove-a da Lista de Mão atual
                    System.out.printf("Jogou %s%n", yourHand.get(Integer.parseInt(cartaJogada) - 1));
                    yourHand.remove(Integer.parseInt(cartaJogada) - 1);

                    int idxEnemyCard = random.nextInt(enemyHand.toArray().length);
                    System.out.printf("Inimigo jogou: %s%n", enemyHand.get(idxEnemyCard));
                    enemyHand.remove(idxEnemyCard);
                    validOptions.remove(Integer.parseInt(cartaJogada) - 1);

                    break;

                } else {
                    System.out.println("Tecla inválida");
                }

            }

        }


    }

}

public class Partida{

    public static void main(String[] args) {
        Round round = new Round();
        List<String> yourHand = round.showHand();
        List<String> enemyHand = round.enemyHand();

        System.out.println("-------------------------------------");

        System.out.print("Sua mão: ");
        yourHand.forEach(c -> formatPrint(c));

        System.out.println();
        System.out.print("Vira: ");
        System.out.print(round.getVira());

        System.out.println();
        System.out.print("Manilhas: ");
        round.showManilhas().forEach(m -> formatPrint(m));

        System.out.println();

        JogarRound.round(yourHand, enemyHand);

    }

    private static void formatPrint(String s) {
        System.out.printf("%s ", s);
    }

}