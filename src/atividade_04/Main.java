package atividade_04;

/**
 * Garantir acesso à seção crítica para no máximo N threads.Faça um código que possibilite que N threads
 * estejam na seção crítica simultaneamente.
 *
 * @author Gabriel Choptian
 */
public class Main {
    public static void main(String[] args) {
        // 4 threads possui acesso a regiao critica
        Buffer buffer = new Buffer(4);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                buffer.critico();
            }).start();
        }
    }
}
