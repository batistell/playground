package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP08 - Observer (Publicador de Eventos)")
public class ObserverPatternTest {

    @Test
    @DisplayName("Caso 1: Inscrever observadores e disparar notificações de eventos")
    public void testObserver_SubscriptionAndNotification() {
        ObserverPattern.EventManager eventManager = new ObserverPattern.EventManager();
        ObserverPattern.EmailNotificationListener emailListener1 = new ObserverPattern.EmailNotificationListener("dev1@test.com");
        ObserverPattern.EmailNotificationListener emailListener2 = new ObserverPattern.EmailNotificationListener("dev2@test.com");

        eventManager.subscribe("open", emailListener1);
        eventManager.subscribe("open", emailListener2);
        eventManager.subscribe("save", emailListener1);

        eventManager.notify("open", "arquivo.txt");

        assertEquals("Email enviado para dev1@test.com ref. evento open: arquivo.txt", emailListener1.getLastMessageReceived());
        assertEquals("Email enviado para dev2@test.com ref. evento open: arquivo.txt", emailListener2.getLastMessageReceived());

        eventManager.notify("save", "projeto_final.zip");
        assertEquals("Email enviado para dev1@test.com ref. evento save: projeto_final.zip", emailListener1.getLastMessageReceived());
        // dev2 não se inscreveu no evento "save", o último dele deve continuar o do evento "open"
        assertEquals("Email enviado para dev2@test.com ref. evento open: arquivo.txt", emailListener2.getLastMessageReceived());
    }

    @Test
    @DisplayName("Caso 2: Cancelar inscrição de observadores e interromper notificações")
    public void testObserver_Unsubscription() {
        ObserverPattern.EventManager eventManager = new ObserverPattern.EventManager();
        ObserverPattern.EmailNotificationListener emailListener = new ObserverPattern.EmailNotificationListener("test@test.com");

        eventManager.subscribe("alert", emailListener);
        eventManager.notify("alert", "Aviso 1");
        assertEquals("Email enviado para test@test.com ref. evento alert: Aviso 1", emailListener.getLastMessageReceived());

        eventManager.unsubscribe("alert", emailListener);
        eventManager.notify("alert", "Aviso 2");
        // O listener não deve ter recebido a segunda notificação, mantendo o estado anterior
        assertEquals("Email enviado para test@test.com ref. evento alert: Aviso 1", emailListener.getLastMessageReceived());
    }
}
