package Exemplos;

public class Pessoa extends Alguem{
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        pessoa.setName("Solwazi ");
        pessoa.setSobrenome("Cacheque");
        pessoa.setIdade(1);
        System.out.println(pessoa.getName() + pessoa.getSobrenome() + ". Idade: " + pessoa.getIdade());

    }

}