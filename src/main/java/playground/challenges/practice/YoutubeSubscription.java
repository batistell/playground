package playground.challenges.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * PT08: Canal de Conteúdo
 * 
 * Requisito:
 * Em um aplicativo de compartilhamento de vídeo, quando um canal (TubeChannel) posta um novo vídeo,
 * todos os seus usuários inscritos (Subscribers) devem ser notificados imediatamente para que
 * atualizem seus respectivos painéis de novidades.
 * A lista de inscritos pode ser alterada dinamicamente a qualquer momento.
 * 
 * Exercício:
 * Implemente a relação de notificação e manutenção da lista de inscritos.
 */
public class YoutubeSubscription {

    // Ouvinte / Assinante
    public interface Subscriber {
        void update(String channelName, String videoTitle);
    }

    // Ouvinte Concreto
    public static class UserSubscriber implements Subscriber {
        private final String username;
        private final List<String> notifications = new ArrayList<>();

        public UserSubscriber(String username) {
            this.username = username;
        }

        @Override
        public void update(String channelName, String videoTitle) {
            // TODO: Adicione à lista 'notifications': channelName + " postou: " + videoTitle
        }

        public List<String> getNotifications() {
            return notifications;
        }
    }

    // Sujeito / Publicador
    public static class TubeChannel {
        private final String name;
        // TODO: Crie a estrutura de coleção para gerenciar os ouvintes/assinantes.

        public TubeChannel(String name) {
            this.name = name;
        }

        public void subscribe(Subscriber s) {
            // TODO: Inscreva o ouvinte.
        }

        public void unsubscribe(Subscriber s) {
            // TODO: Desinscreva o ouvinte.
        }

        public void postVideo(String title) {
            // TODO: Notifique todos os ouvintes inscritos sobre o novo vídeo.
        }
    }
}
