package atividade_01;

import java.util.concurrent.Semaphore;

/**
 * Enviar sinal para outra thread para indicar que um evento ocorreu. Faça um código que uma thread t1 e t2
 * são inicializadas simultaneamente, mas a t2 pode somente continuar a execução após a sinalização de t1.
 *
 * @author Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        // Thread 1
        Thread a = new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println("Thread 1 em execução");

                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 Liberada");
            semaphore.release(2);

        });

        //Thread 2
        Thread b = new Thread(() -> {
            try {
                System.out.println("Aguardadndo Thread 1");
                semaphore.acquire(2);
                System.out.println("Thread 2 em execução");

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 Liberada");
            semaphore.release(2);
        });


        a.start();
        b.start();
    }
}
