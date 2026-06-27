package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserNewsFeedTest {

    @Test
    public void testFeed_SubscriptionAndPublishing() {
        UserNewsFeed.ContentCreator creator = new UserNewsFeed.ContentCreator("Alura");
        UserNewsFeed.UserFollower user1 = new UserNewsFeed.UserFollower("carlos");
        UserNewsFeed.UserFollower user2 = new UserNewsFeed.UserFollower("ana");

        creator.follow(user1);
        creator.follow(user2);

        creator.publishArticle("Descomplicando Git");

        assertEquals(1, user1.getFeed().size());
        assertEquals("Alura publicou: Descomplicando Git", user1.getFeed().get(0));

        assertEquals(1, user2.getFeed().size());
        assertEquals("Alura publicou: Descomplicando Git", user2.getFeed().get(0));
    }

    @Test
    public void testFeed_Unsubscribe() {
        UserNewsFeed.ContentCreator creator = new UserNewsFeed.ContentCreator("DevMedia");
        UserNewsFeed.UserFollower user = new UserNewsFeed.UserFollower("carlos");

        creator.follow(user);
        creator.publishArticle("Java OO");
        assertEquals(1, user.getFeed().size());

        creator.unfollow(user);
        creator.publishArticle("Novidades do Java 21");
        // O feed deve continuar com tamanho 1 (não recebeu o segundo artigo)
        assertEquals(1, user.getFeed().size());
    }
}
