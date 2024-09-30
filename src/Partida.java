import java.util.*;

public class Partida{

    public static void main(String[] args) {

        while(Jogo.getEnemyPoints() < 12 || Jogo.getPlayerPoints() < 12) {
            Round round = new Round();
            List<Carta> yourHand = round.showHand();
            List<Carta> enemyHand = round.enemyHand();
            Jogo jogo = new Jogo();

            System.out.println("-------------------------------------");

            System.out.print("Sua mão: ");
            yourHand.forEach(c -> formatPrint(c));

            System.out.println();
            System.out.print("Vira: ");
            System.out.print(round.getVira());

            System.out.println();
            System.out.print("Manilhas: ");
            round.showManilhas().forEach(m -> System.out.printf("%s ", m));
            System.out.println();

            System.out.println("-------------------------------------");
            System.out.printf("Seus pontos: %s%nPontos do inimigo: %s", Jogo.getPlayerPoints(), Jogo.getEnemyPoints());
            System.out.println();

            jogo.round(yourHand, enemyHand);
        }
    }

    // Mostrando a carta formatada
    private static void formatPrint(Carta c) {

        System.out.printf("%s ", c.showCard());

    }

}