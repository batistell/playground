package playground.challenges.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * PT01: Acesso a Banco
 * 
 * Requisito:
 * Sua aplicação precisa de um componente centralizado para simular a conexão com o banco de dados.
 * Esse componente deve garantir que em toda a execução exista no máximo uma única instância
 * na memória. O acesso a ele deve ser global e thread-safe.
 * 
 * Exercício:
 * Implemente as restrições e métodos necessários para garantir a unicidade e o acesso correto.
 */
public class DatabaseConnection {

    private final Map<String, String> data = new HashMap<>();

    // TODO: Adicione a estrutura necessária para garantir instância única e thread-safe.
    private static DatabaseConnection instance;

    private DatabaseConnection() {}
    
    public static DatabaseConnection getInstance() {
        // TODO: Retorne a instância única.
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void insert(String key, String value) {
        data.put(key, value);
    }

    public String select(String key) {
        return data.get(key);
    }
}
