/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.projeto.individual;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author alan
 */
public class FutebolAmericano {

    // case 1
    Double calcularRating(Integer completos, Integer tentativas, Integer jardas, Integer touchdowns, Integer interceptacoes) {
        double pc = ((double) completos / (double) tentativas - 0.3) * 5;
        double jpt = ((double) jardas / (double) tentativas - 3) * 0.25;
        double td = (double) touchdowns / (double) tentativas * 20;
        double intc = 2.375 - ((double) interceptacoes / (double) tentativas * 25);
        double rating = ((pc + jpt + td + intc) / 6) * 100;
        return rating;
    }

    void exibirRating(Double ratingCalculado) {
        System.out.println(String.format("O rating do seu QB é: %.1f \n "
                + "(Um rating de 158,3 é considerado perfeito) \n "
                + "------------------------------------------", ratingCalculado));
    }
//----------------------------------------------------------------------------------

    //case2
    String identificarNivel(Integer jardasLancadas) {
        String nivel = null;
        if (jardasLancadas > 5000) {
            nivel = "Elite";
        } else if (jardasLancadas >= 4000 && jardasLancadas <= 5000) {
            nivel = "Muito bom";
        } else if (jardasLancadas > 3000 && jardasLancadas < 4000) {
            nivel = "Bom";
        } else if (jardasLancadas >= 2000 && jardasLancadas <= 3000) {
            nivel = "Mediano";
        } else if (jardasLancadas > 0 && jardasLancadas < 2000) {
            nivel = "Abaixo da média";
        }
        return nivel;
    }

    void exibirNivel(String nivelQb) {
        System.out.println(String.format("O seu QB é %s", nivelQb));
    }
//    -----------------------------------------------------------------------

    //case3
    String simularTemporada(String nomeDigitado) {
        int vitorias = 0;
        int derrotas = 0;
        int empates = 0;

        for (int i = 1; i <= 18; i++) {
            Integer pontuacaoHome = ThreadLocalRandom.current().nextInt(0, 50);
            Integer pontuacaoAway = ThreadLocalRandom.current().nextInt(0, 50);

            if (pontuacaoHome > pontuacaoAway) {
                vitorias++;
            } else if (pontuacaoAway > pontuacaoHome) {
                derrotas++;
            } else {
                empates++;
            }

        }
//        resultados = String.format("O time %s terminou a temporada com %d vitórias.", nomeEscolhido, vitorias);

        String mensagem = String.format("O %s terminou a temporada"
                + " com %d vitórias, %d derrotas e %d empates.",
                nomeDigitado, vitorias, derrotas, empates);
        return mensagem;
    }

    void exibirVitorias(String mensagem) {
        System.out.println(mensagem);
    }
//-------------------------------------------------------------------------------
}
