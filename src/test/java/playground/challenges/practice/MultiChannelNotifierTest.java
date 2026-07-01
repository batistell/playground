package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT06 - Sistema de Notificação")
public class MultiChannelNotifierTest {

    @Test
    @DisplayName("Caso 1: Retornar notificação simples base")
    public void testBaseNotifier() {
        MultiChannelNotifier.Notifier notifier = new MultiChannelNotifier.BaseNotifier();
        assertEquals("Alerta de Sistema", notifier.send("Alerta de Sistema"));
    }

    @Test
    @DisplayName("Caso 2: Aplicar SMS")
    public void testSmsNotifier() {
        MultiChannelNotifier.Notifier notifier = new MultiChannelNotifier.SmsNotifier(
                new MultiChannelNotifier.BaseNotifier()
        );
        assertEquals("Alerta de Sistema [SMS]", notifier.send("Alerta de Sistema"));
    }

    @Test
    @DisplayName("Caso 3: Aplicar Push")
    public void testPushNotifier() {
        MultiChannelNotifier.Notifier notifier = new MultiChannelNotifier.PushNotifier(
                new MultiChannelNotifier.BaseNotifier()
        );
        assertEquals("Alerta de Sistema [Push]", notifier.send("Alerta de Sistema"));
    }

    @Test
    @DisplayName("Caso 4: Aplicar canais empilhados (SMS e Push)")
    public void testStackedNotifier() {
        MultiChannelNotifier.Notifier notifier = new MultiChannelNotifier.PushNotifier(
                new MultiChannelNotifier.SmsNotifier(
                        new MultiChannelNotifier.BaseNotifier()
                )
        );
        assertEquals("Alerta de Sistema [SMS] [Push]", notifier.send("Alerta de Sistema"));
    }
}
