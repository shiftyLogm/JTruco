public class Partida {

    public static void main(String[] args) {
        Round round = new Round();

        for(String i : round.showHand()) {
            System.out.println(i);
        }

        System.out.println(round.getManilha());


    }

}