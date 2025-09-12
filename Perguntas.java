import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Perguntas {

    Scanner scanner = new Scanner(System.in);
    List<Times> listaTimes = CaracteristicasTimes.listaTimes();

    public void iniciarPerguntas() {
        System.out.println("Pense em um time de futebol...");

        pergunta1();
    }

    public void pergunta1() {
        System.out.println("O time já foi campeão da Libertadores?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> time.venceuLibertadores == (resposta == 1))
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta2);
    }

    public void pergunta2() {
        System.out.println("O time já ganhou o Brasileirão?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> (resposta == 1 ? time.titulosBrasileirao > 0 : time.titulosBrasileirao == 0))
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta3);
    }

    public void pergunta3() {
        System.out.println("O time já ganhou mais de 4 títulos do Brasileirão?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> (resposta == 1 ? time.titulosBrasileirao > 4 : time.titulosBrasileirao <= 4))
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta4);
    }

    public void pergunta4() {
        System.out.println("O time é alvinegro? (Cores principais são Preto e Branco)");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean alvinegro = (time.corPrincipal.equalsIgnoreCase("Preto")
                            && time.corSecundaria.equalsIgnoreCase("Branco"));
                    return resposta == 1 ? alvinegro : !alvinegro;
                })
                .collect(Collectors.toList());

        verificarResultadoOuContinuar(this::pergunta5);
    }

    public void pergunta5() {
        System.out.println("O time é da região Sudeste do Brasil?");
        int resposta = validador(scanner);

        listaTimes = listaTimes.stream()
                .filter(time -> {
                    boolean sudeste = time.estadoOrigem.equalsIgnoreCase("São Paulo")
                            || time.estadoOrigem.equalsIgnoreCase("Minas Gerais")
                            || time.estadoOrigem.equalsIgnoreCase("Rio Janeiro");
                    return resposta == 1 ? sudeste : !sudeste;
                })
                .collect(Collectors.toList());

        verificarResultadoOuFinalizar();
    }

    public void verificarResultadoOuContinuar(Runnable proximaPergunta) {
        if (listaTimes.size() == 1) {
            System.out.println("O time que você pensou foi:");
            System.out.println(listaTimes.get(0));
        } else if (listaTimes.isEmpty()) {
            System.out.println("Não encontramos um time com essas características!");
        } else {
            proximaPergunta.run();
        }
    }

    public void verificarResultadoOuFinalizar() {
        if (listaTimes.size() == 1) {
            System.out.println("O time que você pensou foi:");
            System.out.println(listaTimes.get(0));
        } else if (listaTimes.isEmpty()) {
            System.out.println("Não encontramos um time com essas características!");
        } else {
            System.out.println("Ainda restam vários times com essas características:");
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
                    System.out.println("Valor inválido! Digite 1 ou 2.");
                }

            } catch (Exception e) {
                System.out.println("Valor inválido! Digite um número.");
                scanner.nextLine();
            }
        }

        return resposta;
    }
}