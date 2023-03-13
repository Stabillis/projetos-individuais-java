package sptech.projeto.individual;

import java.util.Scanner;

/**
 *
 * @author alan
 */
public class TesteFutebolAmericano {

    public static void main(String[] args) {
        FutebolAmericano ratingqb = new FutebolAmericano();
        Scanner scan = new Scanner(System.in);
        Integer opcao = 1;

        while (opcao != 0) {
            System.out.println("Olá, Técnico, o que quer fazer? \n "
                    + "1-Calcular rating \n 2-Verificar nível do QB \n 3-Simular Temporada Regular \n 0-sair \n"
                    + "------------------------------------------");
            opcao = scan.nextInt();

            switch (opcao) {

                case 0:
                    System.out.println("Até logo!");
                    break;

                case 1:
                    System.out.println("Calcule o rating do seu QuarterBack: \n"
                            + "------------------------------------------");
                    System.out.println("Quantos passes completos o seu QB fez?");
                    Integer completos = scan.nextInt();
                    System.out.println("Quantas tentativas de passe ele fez?");
                    Integer tentativas = scan.nextInt();
                    System.out.println("Quantas jardas ele conquistou?");
                    Integer jardas = scan.nextInt();
                    System.out.println("Quantos touchdowns ele fez?");
                    Integer touchdowns = scan.nextInt();
                    System.out.println("Quantas interceptações ele sofreu?");
                    Integer interceptacoes = scan.nextInt();
                    Double ratingCalculado = ratingqb.calcularRating(completos, tentativas, jardas, touchdowns, interceptacoes);
                    ratingqb.exibirRating(ratingCalculado);
                    break;

                case 2:
                    System.out.println("Quantas jardas o seu QB lançou na última temporada?");
                    Integer jardasLancadas = scan.nextInt();

                    String nivelQb = ratingqb.identificarNivel(jardasLancadas);
                    ratingqb.exibirNivel(nivelQb);
                    break;

                case 3:
                    scan.nextLine();
                    System.out.println("Qual o nome do seu time?");
                    String nomeDigitado = scan.nextLine();

                    String resultados = ratingqb.simularTemporada(nomeDigitado);
                    ratingqb.exibirVitorias(resultados);
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }

        }

    }
}
