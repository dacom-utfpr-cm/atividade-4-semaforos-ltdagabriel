package atividade_04;

import java.util.concurrent.Semaphore;

public class Buffer {
    int cont = 0;
    Semaphore semaphore;

    public Buffer(int N) {
        semaphore = new Semaphore(N);
    }


    void critico() {
        try {
            semaphore.acquire(1);
            cont++;
            System.out.println("Acesso simultaneo: " + cont);
            /// Regiao Critica
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cont--;
            semaphore.release();
        }
    }

}
