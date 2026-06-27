package playground.challenges.patterns;

/**
 * DP01: Singleton (Thread-Safe Lazy Initialization)
 * 
 * O padrão Singleton garante que uma classe tenha apenas uma instância e fornece
 * um ponto de acesso global para ela.
 * 
 * Exercício:
 * Implemente a inicialização tardia (Lazy Initialization) de maneira segura para threads (Thread-Safe).
 * Dica: Utilize o padrão Double-Checked Locking para evitar problemas de concorrência sem penalidades excessivas de performance.
 */
public class Singleton {

    
    // TODO: Defina o campo estático para armazenar a instância única da classe.
    // Dica: Use a palavra-chave volatile para garantir a visibilidade entre threads.
    private static volatile Singleton singleton;
    
    // TODO: Crie um construtor privado para evitar a instanciação externa direta.
    private Singleton() {
    }

    public static Singleton getInstance() {
        // TODO: Implemente a lógica Double-Checked Locking para retornar a instância única.
        // 1. Verifique se a instância é nula.
        // 2. Se for nula, sincronize no bloco Singleton.class.
        // 3. Dentro da sincronização, verifique novamente se a instância é nula antes de criá-la.
        
        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
    
    // Um contador simples de testes para validar a instância única
    private int counter = 0;
    
    public void increment() {
        counter++;
    }
    
    public int getCounter() {
        return counter;
    }
}
