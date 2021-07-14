package DesafiosMatematicosEmJava;

import java.util.Scanner;

public class SeisNumerosImpares {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int x;
        int cont = 0;
        x = ler.nextInt();
        while(cont < 6) {
            if (x % 2 == 1) {
                cont++;
                System.out.println(x);
            }
            x++;
        }
    }
}