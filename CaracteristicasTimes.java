import java.util.ArrayList;
import java.util.List;

public class CaracteristicasTimes {

    public static List<Times> listaTimes() {

        List<Times> listaTimes = new ArrayList<>();

        Times cruzeiro = new Times();

        cruzeiro.corPrincipal = "Azul";
        cruzeiro.corSecundaria = "Branco";
        cruzeiro.estadoOrigem = "Minas Gerais";
        cruzeiro.titulosBrasileirao = 4;
        cruzeiro.venceuLibertadores = true;
        listaTimes.add(cruzeiro);

        Times atleticoMG = new Times();

        atleticoMG.corPrincipal = "Preto";
        atleticoMG.corSecundaria = "Branco";
        atleticoMG.estadoOrigem = "Minas Gerais";
        atleticoMG.titulosBrasileirao = 3;
        atleticoMG.venceuLibertadores = true;
        listaTimes.add(atleticoMG);

        Times americaMG = new Times();

        americaMG.corPrincipal = "Verde";
        americaMG.corSecundaria = "Branco";
        americaMG.estadoOrigem = "Minas Gerais";
        americaMG.titulosBrasileirao = 0;
        americaMG.venceuLibertadores = false;
        listaTimes.add(americaMG);

        Times flamengo = new Times();

        flamengo.corPrincipal = "Vermelho";
        flamengo.corSecundaria = "Preto";
        flamengo.estadoOrigem = "Rio Janeiro";
        flamengo.titulosBrasileirao = 7;
        flamengo.venceuLibertadores = true;
        listaTimes.add(flamengo);

        Times vasco = new Times();

        vasco.corPrincipal = "Preto";
        vasco.corSecundaria = "Branco";
        vasco.estadoOrigem = "Rio Janeiro";
        vasco.titulosBrasileirao = 4;
        vasco.venceuLibertadores = true;
        listaTimes.add(vasco);

        Times palmeiras = new Times();

        palmeiras.corPrincipal = "Verde";
        palmeiras.corSecundaria = "Branco";
        palmeiras.estadoOrigem = "São Paulo";
        palmeiras.titulosBrasileirao = 10;
        palmeiras.venceuLibertadores = true;
        listaTimes.add(palmeiras);

        Times bahia = new Times();

        bahia.corPrincipal = "Azul";
        bahia.corSecundaria = "Vermelha";
        bahia.estadoOrigem = "Bahia";
        bahia.titulosBrasileirao = 2;
        bahia.venceuLibertadores = false;
        listaTimes.add(bahia);

        Times internacional = new Times();

        internacional.corPrincipal = "Vermelho";
        internacional.corSecundaria = "Branco";
        internacional.estadoOrigem = "Porto Alegre";
        internacional.titulosBrasileirao = 3;
        internacional.venceuLibertadores = true;
        listaTimes.add(internacional);

        Times vitoria = new Times();

        vitoria.corPrincipal = "Vermelho";
        vitoria.corSecundaria = "Preto";
        vitoria.estadoOrigem = "Salvador";
        vitoria.titulosBrasileirao = 0;
        vitoria.venceuLibertadores = false;
        listaTimes.add(vitoria);

        Times corinthians = new Times();

        corinthians.corPrincipal = "Preto";
        corinthians.corSecundaria = "Branco";
        corinthians.estadoOrigem = "São Paulo";
        corinthians.titulosBrasileirao = 7;
        corinthians.venceuLibertadores = true;
        listaTimes.add(corinthians);

        return listaTimes;

    }

}
