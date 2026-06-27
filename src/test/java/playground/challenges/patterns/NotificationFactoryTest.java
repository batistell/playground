package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP02 - Factory Method (Sistema de Notificações)")
public class NotificationFactoryTest {

    private final NotificationFactory factory = new NotificationFactory();

    @Test
    @DisplayName("Caso 1: Criar e enviar notificação por Email")
    public void testFactoryMethod_Email() {
        NotificationFactory.Notification notification = factory.createNotification(NotificationFactory.Type.EMAIL);
        assertNotNull(notification);
        assertTrue(notification instanceof NotificationFactory.EmailNotification);
        assertEquals("Email enviado com sucesso: Ola Mundo", notification.send("Ola Mundo"));
    }

    @Test
    @DisplayName("Caso 2: Criar e enviar notificação por SMS")
    public void testFactoryMethod_SMS() {
        NotificationFactory.Notification notification = factory.createNotification(NotificationFactory.Type.SMS);
        assertNotNull(notification);
        assertTrue(notification instanceof NotificationFactory.SMSNotification);
        assertEquals("SMS enviado com sucesso: Ola Mundo", notification.send("Ola Mundo"));
    }

    @Test
    @DisplayName("Caso 3: Lançar exceção para tipo de notificação nulo")
    public void testFactoryMethod_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createNotification(null);
        });
    }
}
