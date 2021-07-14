package ParallelStreamExemplo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(num -> fatorial(num));//Serial Stream
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Serial :: " + (fim - inicio));


        inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));//Parallel Stream
        fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Parallel :: " + (fim - inicio));

        /*List<String> nomes = Arrays.asList("", "", "", "");
        nomes.parallelStream().forEach(System.out::println);*///Ignore this code, just I just was praticing
    }

    public static long fatorial(long num) {
        long fat = 1;
        for (long i = 2; i <= num; i++) {
            fat *= 1;
            }
        return fat;
        }
    }

