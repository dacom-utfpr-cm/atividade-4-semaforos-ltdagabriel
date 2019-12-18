package atividade_02;

import java.util.concurrent.Semaphore;

/**
 * Enviar sinalização para um ponto de encontro entre threads.Faça um código que
 * uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.
 */
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        // Thread 1
        Thread a = new Thread(() -> {
            try {
                semaphore1.acquire(1);
                System.out.println("trecho1.1");
                Thread.sleep(100);
                semaphore1.release(2);

                semaphore2.acquire(2);
                System.out.println("trecho1.2");
                semaphore2.release(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        //Thread 2
        Thread b = new Thread(() -> {
            try {
                semaphore1.acquire(2);
                System.out.println("trecho2.1");
                Thread.sleep(100);
                semaphore1.release(2);


                semaphore2.acquire(1);
                System.out.println("trecho2.2");
                semaphore2.release(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        a.start();
        b.start();
    }
}
