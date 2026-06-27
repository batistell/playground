package playground.challenges.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DP08: Observer (Publicador de Eventos)
 * 
 * O padrão Observer define uma dependência um-para-muitos entre objetos, de modo que
 * quando um objeto muda de estado, todos os seus dependentes são notificados e
 * atualizados automaticamente.
 * 
 * Exercício:
 * Implemente o publicador de eventos `EventManager` e o assinante concreto `EmailNotificationListener`.
 */
public class ObserverPattern {

    // Interface Observer (Assinante)
    public interface EventListener {
        void update(String eventType, String data);
    }

    // Concrete Observer (Assinante Concreto)
    public static class EmailNotificationListener implements EventListener {
        private final String email;
        private String lastMessageReceived;

        public EmailNotificationListener(String email) {
            this.email = email;
        }

        @Override
        public void update(String eventType, String data) {
            // TODO: Atualize lastMessageReceived no formato: "Email enviado para " + email + " ref. evento " + eventType + ": " + data
        }

        public String getLastMessageReceived() {
            return lastMessageReceived;
        }
    }

    // Subject / Publisher (Publicador)
    public static class EventManager {
        // TODO: Defina uma estrutura para mapear os tipos de eventos (ex: "open", "save") para os ouvintes correspondentes.
        private final Map<String, List<EventListener>> listeners = new HashMap<>();

        public void subscribe(String eventType, EventListener listener) {
            // TODO: Adicione o ouvinte à lista associada ao eventType especificado.
        }

        public void unsubscribe(String eventType, EventListener listener) {
            // TODO: Remova o ouvinte da lista associada ao eventType especificado.
        }

        public void notify(String eventType, String data) {
            // TODO: Notifique todos os ouvintes inscritos para o tipo de evento (eventType)
            // chamando o método update(eventType, data) de cada um.
        }
    }
}
