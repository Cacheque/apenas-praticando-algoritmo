package Exemplos;

public class Carro extends Veiculo {

    public static void main(String[] args) {
        int quantidadeDePessoas = 10;
        Carro carro = new Carro();
        carro.setModelo("Prisma");
        carro.setMarca("Chevrolet");
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Marca: " + carro.getMarca());
        System.out.println("Pessoas: " + quantidadeDePessoas);
    }


    /*private void remover(int quantidadeDePessoas) {
    }

    private int add(int quantidadeDePessoas) {

    }*/
}
