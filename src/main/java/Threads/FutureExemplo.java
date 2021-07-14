package Threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());
        List<Future<String>> futuros =
                new CopyOnWriteArrayList<>(casa.obterAfazeresDeCasa().stream()
                        .map(atividade ->  pessoasParaExecutarAtividade.submit(() -> {
                                try {
                                    return atividade.realizar();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            })
                        )
                        .collect(Collectors.toList()));

        while (true) {
            int numeroDeAtividadesNaoRealizadas = 0;
            for (Future<?> futuro : futuros) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns, Solwazi! Tu terminaste de: " + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    numeroDeAtividadesNaoRealizadas++;
                }
            }
            if (futuros.stream().allMatch(Future::isDone)){
                break;
            }

            System.out.println("Numero de atividades não finalizadas :: " +numeroDeAtividadesNaoRealizadas);
            Thread.sleep(500);
        }
        pessoasParaExecutarAtividade.shutdown();

    }
}

class Casa{
    private List<Comodo> comodos;

    Casa (Comodo... comodos) {
        this.comodos = Arrays.asList(comodos); }

    List<Atividade> obterAfazeresDeCasa () {
        return this.comodos.stream().map(Comodo:: obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}
interface Atividade{
    String realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::arrumarGuardaRoupa,
                this::varrerOQuarto,
                this::arrumarCama
        );
    }

    private String arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        String arrumar_o_guarda_roupa = "Arrumar o guarda Roupa";
        System.out.println("Arrumar o guarda Roupa");
        return arrumar_o_guarda_roupa;
    }

    private String varrerOQuarto() throws InterruptedException {
        Thread.sleep(7000);
        String arrumar_o_quarto = "Arrumar o Quarto";
        System.out.println("arrumar o Quarto");
        return arrumar_o_quarto;
    }

    private String arrumarCama() throws InterruptedException {
        Thread.sleep(10000);
        String arrumar_a_cama = "Arrumar a Cama";
        System.out.println("Arrumar a Cama");
        return arrumar_a_cama;
    }
}
