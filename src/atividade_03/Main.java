package atividade_03;

/**
 * Garantir acesso exclusivo à seção crítica.Faça um código que possibilite
 * que 2 ou mais threads realizem o incremento de um contador. Faça aexclusão mútua com semáforo.
 */
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int value = buffer.increment();

                System.out.println(value);
            }).start();
        }
    }
}
