package SolucionandoDesafiosEmJava;
import java.io.IOException;
import java.util.Scanner;

public class Diferenca {
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);

        int a, b, c, d, calculo;
        System.out.println("");
        a = ler.nextInt();
        System.out.println("");
        b = ler.nextInt();
        System.out.println("");
        c = ler.nextInt();
        System.out.println("");
        d = ler.nextInt();
        calculo = (a * b - c * d);
        System.out.println("DIFERENCA = " + calculo);

    }

}
