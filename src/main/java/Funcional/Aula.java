package Funcional;

public class Aula {
    public static void main(String[] args) {
        Funcao1 funcao1  = valor -> {
            System.out.println(valor);
            System.out.println(valor);
        };
        funcao1.gerar("Joao");
    }
}

interface Funcao1{
    void gerar(String valor);
}
