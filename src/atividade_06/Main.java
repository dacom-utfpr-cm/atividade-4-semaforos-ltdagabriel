package atividade_06;

/**
 * Threds em um laço executam uma série de passos e sincronizam em uma barreira a cada passo.
 * Faça um código que implemente uma barreira reusável que feche a si própria após todas as threads passarem.
 *
 * @author Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        // 4 threads possui acesso a regiao critica
        Buffer buffer = new Buffer(4);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                buffer.barreira();
            }).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
