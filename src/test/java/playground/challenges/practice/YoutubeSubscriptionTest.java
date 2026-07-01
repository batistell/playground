package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT08 - Canal de Conteúdo")
public class YoutubeSubscriptionTest {

    @Test
    @DisplayName("Caso 1: Notificar inscritos quando vídeo for publicado")
    public void testNotification() {
        YoutubeSubscription.TubeChannel channel = new YoutubeSubscription.TubeChannel("DevTips");
        YoutubeSubscription.UserSubscriber user1 = new YoutubeSubscription.UserSubscriber("alice");
        YoutubeSubscription.UserSubscriber user2 = new YoutubeSubscription.UserSubscriber("bob");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.postVideo("Design Patterns 101");

        assertEquals(1, user1.getNotifications().size());
        assertEquals("DevTips postou: Design Patterns 101", user1.getNotifications().get(0));

        assertEquals(1, user2.getNotifications().size());
        assertEquals("DevTips postou: Design Patterns 101", user2.getNotifications().get(0));
    }

    @Test
    @DisplayName("Caso 2: Não notificar usuário após desinscrição")
    public void testUnsubscribe() {
        YoutubeSubscription.TubeChannel channel = new YoutubeSubscription.TubeChannel("DevTips");
        YoutubeSubscription.UserSubscriber user1 = new YoutubeSubscription.UserSubscriber("alice");

        channel.subscribe(user1);
        channel.postVideo("Video 1");

        channel.unsubscribe(user1);
        channel.postVideo("Video 2");

        assertEquals(1, user1.getNotifications().size());
        assertEquals("DevTips postou: Video 1", user1.getNotifications().get(0));
    }
}
