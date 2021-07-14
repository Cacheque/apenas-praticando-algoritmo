package DesafiosMatematicosEmJava;

import java.io.IOException;
import java.util.Scanner;


public class AnalisesDeNumeros {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);

        int z, par, impar, pos, neg;

        par = 0;
        impar = 0;
        pos = 0;
        neg = 0;

        for(int i = 0; i < 5; i ++){

            z = ler.nextInt();

            if(z % 2 == 0){
                par++;
            }else {
                impar++;
            }

            if (z > 0) pos++;
            if (z < 0) neg++;

        }
        System.out.println("" + par + " valor(es) par(es)");
        System.out.println("" + impar + " valor(es) impar(es)");
        System.out.println("" + pos + " valor(es) positivo(s)");
        System.out.println("" + neg +  " valor(es) negativo(s)");
    }

}


