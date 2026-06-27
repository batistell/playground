package playground.challenges.patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationFactoryTest {

    private final NotificationFactory factory = new NotificationFactory();

    @Test
    public void testFactoryMethod_Email() {
        NotificationFactory.Notification notification = factory.createNotification(NotificationFactory.Type.EMAIL);
        assertNotNull(notification);
        assertTrue(notification instanceof NotificationFactory.EmailNotification);
        assertEquals("Email enviado com sucesso: Ola Mundo", notification.send("Ola Mundo"));
    }

    @Test
    public void testFactoryMethod_SMS() {
        NotificationFactory.Notification notification = factory.createNotification(NotificationFactory.Type.SMS);
        assertNotNull(notification);
        assertTrue(notification instanceof NotificationFactory.SMSNotification);
        assertEquals("SMS enviado com sucesso: Ola Mundo", notification.send("Ola Mundo"));
    }

    @Test
    public void testFactoryMethod_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createNotification(null);
        });
    }
}
