package Threads;

public class ThreadExemplo {

    public static void main(String[] args) {
        Thread thread = new Thread(new BarraDeCarregamento1());
        Thread thread1 = new Thread(new BarraDeCarregamento2());
        Thread thread2 = new Thread(new BarraDeCarregamento());
        thread.start();
        thread1.start();
        thread2.start();
        System.out.println("Nome da Thread : " + thread.getName());
        System.out.println("Nome da Thread : " + thread1.getName());
        System.out.println("Nome da Thread : " + thread2.getName());
    }
}


class GerarPDF implements Runnable{

    @Override
    public void run() {
        System.out.println("Gerar PDF");
    }
}

class BarraDeCarregamento implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(10000);
            System.out.println("Loading... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento1 implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            System.out.println("Rodei Barra de Carregamento1: " );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento2  implements Runnable {
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("Rodei Barra de Carregamento2: ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
