package atividade_05;

import java.util.concurrent.Semaphore;

public class Buffer {
    int cont = 0;
    Semaphore semaphore = new Semaphore(0);
    int N;
    String s = "";

    public Buffer(int N) {

        this.N = N;
    }


    void barreira() {
        semaphore.release(1);
        if (semaphore.availablePermits() < N) {
            System.out.println(Thread.currentThread().getName() +"\tBarrado '-' [aguardando]");
        }
        try {
            semaphore.acquire(N);
            System.out.println(Thread.currentThread().getName() +"\tAtravessou a barreira");
            /// Regiao Critica
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(N);
        }
    }

}
