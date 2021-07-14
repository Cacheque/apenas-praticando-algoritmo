package Threads;

public class ThreadExemplo1 {
    public static void main(String[] args) {
        GeradorPDF iniciarGeradorPdf = new GeradorPDF();
        BarraDeCarregamento3 iniciarBarraDeCarregamento3 = new BarraDeCarregamento3(iniciarGeradorPdf);

        iniciarGeradorPdf.start();
        iniciarBarraDeCarregamento3.start();


    }
}

class GeradorPDF extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("Iniciar o Gerador do PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento3 extends Thread {
    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento3(Thread iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("Loading ... ");
                if (iniciarGeradorPdf.isAlive()){
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
