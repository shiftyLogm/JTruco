import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manilha extends Carta {

    // Metodo construtor herdando a classe a construcao da superclasse Carta
    public Manilha() {
        super();
    }

    // Metodo para pegar as 4 manilhas atuais da rodada
    public List<String> getManilhas() {

        // Instancia do objeto baralho para consulto do array que contém as cartas utilizadas
        Baralho baralho = new Baralho();

        // Index para conseguir o valor da manilha na lista abaixo
        final int idxVira = baralho.getBaralho().indexOf(this.getCarta());

        // Caso a vira seja "3", precisamos utilizar um ternario(ou if) para retornar para o valor "4", ou seja, o primeiro índice do Array
        final String valorCartaManilha = idxVira == baralho.getBaralho().toArray().length - 1
                ? baralho.getBaralho().getFirst()
                : baralho.getBaralho().get(idxVira + 1);

        List<String> manilhas = new ArrayList<>();

        // Adição das manilhas em um array
        for (Naipe naipe : Naipe.values()) {
            manilhas.add(valorCartaManilha + naipe.getSimbol());
        }

        return manilhas;
    }
}
