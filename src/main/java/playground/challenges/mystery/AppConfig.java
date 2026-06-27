package playground.challenges.mystery;

import java.util.HashMap;
import java.util.Map;

/**
 * MC01: Configuração Central
 * 
 * Requisito:
 * Sua aplicação precisa de um componente central que armazene pares de chave-valor correspondentes
 * a configurações globais (como URLs de banco de dados e portas de servidores). 
 * Esse componente deve ter um ponto de acesso global e garantir que em nenhuma circunstância existam
 * duas cópias dele em memória, mesmo quando acessado por múltiplas threads simultaneamente.
 * 
 * Exercício:
 * Implemente a estrutura interna desta classe para atender aos requisitos de concorrência e unicidade.
 */
public class AppConfig {

    private final Map<String, String> settings = new HashMap<>();

    // TODO: Defina as estruturas internas necessárias para controlar a instanciação única e thread-safe.

    // TODO: Defina o construtor apropriado para evitar que instâncias sejam criadas de fora.

    public static AppConfig getInstance() {
        // TODO: Retorne a instância única e thread-safe.
        return null;
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }

    public String get(String key) {
        return settings.get(key);
    }
}
