package playground.challenges.mystery;

import java.util.ArrayList;
import java.util.List;

/**
 * MC09: Gravador de Logs Compartilhado
 * 
 * Requisito:
 * Sua aplicação web possui centenas de classes que precisam gravar mensagens de logs de auditoria
 * em uma única lista centralizada em memória. Se múltiplas instâncias do gravador fossem criadas, 
 * haveria duplicação desnecessária e inconsistência no controle de auditoria. 
 * Garanta que exista apenas uma instância centralizada deste gravador de log em toda a aplicação.
 * A inicialização deve ser feita somente na primeira chamada (lazy) e ser thread-safe.
 * 
 * Exercício:
 * Implemente as restrições de instanciação corretas.
 */
public class SharedFileLogger {

    private final List<String> logs = new ArrayList<>();

    private static volatile SharedFileLogger instance;

    private SharedFileLogger() {}

    public static SharedFileLogger getLogger() {
        if (instance == null) {
            synchronized (SharedFileLogger.class) {
                if (instance == null) {
                    instance = new SharedFileLogger();
                }
            }
        }
        return instance;
    }

    public synchronized void log(String message) {
        logs.add(message);
    }

    public List<String> getLogs() {
        return logs;
    }
}
