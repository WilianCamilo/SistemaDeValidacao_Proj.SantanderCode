import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        ligandoCandidato();
    }

    static void ligandoCandidato() {
        String[] canditatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto" };
        for (String candidato : canditatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " NA " + tentativasRealizadas + " tentativa.");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ", número maximo tentativas "
                    + tentativasRealizadas + " realizadas.");
        }

    }

    // selecionando os candidatos

    static void selecaoCandidatos() {

        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela",
                "Daniela", "Pati" };

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salario: " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    // imprimindo os selecionados para o RH

    static void imprimirSelecionado() {
        String[] canditatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto" };

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < canditatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice + 1) + " é o " + canditatos[indice]);
        }
    }

    // pequena simulação de analise de canditados

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidatoo");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguarda o resultado dos demais candidatos");
        }

    }

    // *** Metedos Auxiliares ***

    // metedo para simular a pretençção salarial
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // metedo para ligar pro candidato
    static boolean atender() {
        return new Random().nextInt(3) == 1;
        // simula que se o valor entre 1 e 3 for igual a 1 ele atendeu.
    }
}