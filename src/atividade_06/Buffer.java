package atividade_06;

import java.util.concurrent.Semaphore;

public class Buffer {
    int cont = 0;
    Semaphore semaphore = new Semaphore(0);
    Semaphore lock = new Semaphore(1);
    int N;
    String s = "";

    public Buffer(int N) {

        this.N = N;
    }


    void barreira() {
        int value = 0;
        try {
            lock.acquire();
            cont++;
            value = cont;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.release();
        }
        if(value == N){
            semaphore.release(N);

            try {
                lock.acquire();
                cont = 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.release();
            }
        }
        if (semaphore.availablePermits() < N) {
            System.out.println(Thread.currentThread().getName() + "\tBarrado '-' [aguardando]");
        }

        if(value<= N){
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // regiao critica
        System.out.println(Thread.currentThread().getName() + "\tAtravessou a barreira");

    }

}
