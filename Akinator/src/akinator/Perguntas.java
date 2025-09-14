package akinator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Perguntas {

    Scanner scanner = new Scanner(System.in);
    List<Times> listaTimes = CaracteristicasTimes.listaTimes();

    public void iniciarPerguntas() {
        System.out.println("Pense em um time de futebol...");
        for (Times Times : listaTimes) {

            System.out.println(Times);

        }

        pergunta1();
    }

    public void pergunta1() {
        System.out.println("\nO time já foi campeão da Libertadores?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> time.venceuLibertadores == (resposta == 1))
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta2);
    }

    public void pergunta2() {
        System.out.println("\nO time já ganhou o Brasileirão?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> (resposta == 1 ? time.titulosBrasileirao > 0 : time.titulosBrasileirao == 0))
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta3);
    }

    public void pergunta3() {
        System.out.println("\nO time já ganhou mais de 3 títulos do Brasileirão?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> (resposta == 1 ? time.titulosBrasileirao > 3 : time.titulosBrasileirao <= 3))
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta4);
    }

    public void pergunta4() {
        System.out.println("\nO time é da região Sudeste do Brasil?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean sudeste = time.estadoOrigem.equalsIgnoreCase("São Paulo")
                            || time.estadoOrigem.equalsIgnoreCase("Minas Gerais")
                            || time.estadoOrigem.equalsIgnoreCase("Rio Janeiro");
                    return resposta == 1 ? sudeste : !sudeste;
                })
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta5);
    }
    
        public void pergunta5() {
        System.out.println("\nO time é pertencente ao estado de Minas Gerais?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean estadoOrigem = (time.estadoOrigem.equalsIgnoreCase("Minas Gerais"));
                    return resposta == 1 ? estadoOrigem : !estadoOrigem;
                })
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta6);
    }

    public void pergunta6() {
        System.out.println("\nO time é pertencente ao estado do Rio de Janeiro?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean estadoOrigem = (time.estadoOrigem.equalsIgnoreCase("Rio Janeiro"));
                    return resposta == 1 ? estadoOrigem : !estadoOrigem;
                })
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta7);
    }

    public void pergunta7() {
        System.out.println("\nO time é Rubro-Negro? (Cores principais são Vermelho e Preto)");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean rubronegro = (time.corPrincipal.equalsIgnoreCase("Vermelho")
                            && time.corSecundaria.equalsIgnoreCase("Preto"));
                    return resposta == 1 ? rubronegro : !rubronegro;
                })
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta8);
    }

    public void pergunta8() {
        System.out.println("\nO time possui a cor verde no escudo?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean verde = (time.corPrincipal.equalsIgnoreCase("verde"));
                    return resposta == 1 ? verde : !verde;
                })
                .collect(Collectors.toList());

        verificarResultadoOuFinalizar();
    }



    public void verificarResultadoOuContinuar(Runnable proximaPergunta) {
        if (listaTimes.size() == 1) {
            System.out.print("\nO time que você pensou foi o: ");
            System.out.println(listaTimes.get(0));
        } else if (listaTimes.isEmpty()) {
            System.out.println("\nNão encontramos nenhum time com essas características! Verifique se não informou nenhuma resposta incorretamente.");
        } else {
            proximaPergunta.run();
        }
    }

    public void verificarResultadoOuFinalizar() {
        if (listaTimes.size() == 1) {
            System.out.print("\nO time que você pensou foi o: ");
            System.out.println(listaTimes.get(0));
        } else {
            System.out.println("\nNão encontramos nenhum time com essas características! Verifique se não informou nenhuma resposta incorretamente.");
            listaTimes.forEach(System.out::println);
        }
    }

    public static int validador(Scanner scanner) {
        int resposta = 0;
        boolean numeroValido = false;

        while (!numeroValido) {
            try {
                System.out.print("1 - Sim \n2 - Não \nR: ");
                resposta = scanner.nextInt();

                if (resposta == 1 || resposta == 2) {
                    numeroValido = true;
                } else {
                    System.out.println("\nValor inválido! Digite 1 ou 2.");
                }

            } catch (Exception e) {
                System.out.println("\nValor inválido! Digite um número.");
                scanner.nextLine();
            }
        }

        return resposta;
    }
}
