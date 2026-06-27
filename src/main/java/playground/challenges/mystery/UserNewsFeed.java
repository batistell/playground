package playground.challenges.mystery;

import java.util.ArrayList;
import java.util.List;

/**
 * MC07: Feed de Notícias e Seguidores
 * 
 * Requisito:
 * Em uma rede social, quando um criador de conteúdo publica um novo artigo, todos os seus seguidores
 * devem ser notificados imediatamente para atualizar seus respectivos feeds pessoais.
 * A lista de seguidores pode mudar dinamicamente (novos usuários seguindo ou deixando de seguir).
 * 
 * Exercício:
 * Projete e implemente a relação um-para-muitos e o sistema de disparo de atualizações.
 */
public class UserNewsFeed {

    // Assinante
    public interface Follower {
        void receiveNotification(String creatorName, String articleTitle);
    }

    // Assinante Concreto
    public static class UserFollower implements Follower {
        private final String username;
        private final List<String> feed = new ArrayList<>();

        public UserFollower(String username) {
            this.username = username;
        }

        @Override
        public void receiveNotification(String creatorName, String articleTitle) {
            // TODO: Adicione ao feed a mensagem: creatorName + " publicou: " + articleTitle
        }

        public List<String> getFeed() {
            return feed;
        }
    }

    // Publicador
    public static class ContentCreator {
        private final String name;
        // TODO: Mantenha uma coleção de seguidores cadastrados.
        private final List<Follower> followers = new ArrayList<>();

        public ContentCreator(String name) {
            this.name = name;
        }

        public void follow(Follower follower) {
            // TODO: Inscreva o seguidor.
        }

        public void unfollow(Follower follower) {
            // TODO: Cancele a inscrição do seguidor.
        }

        public void publishArticle(String title) {
            // TODO: Notifique todos os seguidores sobre a publicação do novo artigo com o título informado.
        }
    }
}
