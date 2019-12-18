package atividade_03;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int cont = 0;
    Semaphore semaphore = new Semaphore(1);


    int increment() {
        int value = 0;
        try {
            semaphore.acquire();
            cont++;
            value = cont;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return value;
    }

}
