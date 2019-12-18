package atividade_05;

/**
 * Após N threads sincronizarem em um ponto em comum, um trecho específico (ponto crítico) pode ser executado
 * por cada uma delas.Faça um código que possibilite barrar N threads em um ponto específico de execução e,
 * após todas alcançarem o ponto, todas devem executar o trecho de código após esse ponto
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
