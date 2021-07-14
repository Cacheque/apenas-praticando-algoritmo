package DesafiosMatematicosEmJava;

import java.util.Scanner;

public class VisitaNaFeira {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int a, b, total;
        System.out.println("Digite o valor do pimentão amarelo: ");
        a = ler.nextInt();
        System.out.println("Digite o valor do pimentão vermelho: ");
        b = ler.nextInt();
        total = a + b;
        System.out.println("X = " + total);
    }
}
