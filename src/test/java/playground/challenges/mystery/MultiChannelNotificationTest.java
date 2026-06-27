package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC04 - Abstração de Mensagens")
public class MultiChannelNotificationTest {

    @Test
    @DisplayName("Caso 1: Enviar mensagem Normal por Email")
    public void testNotification_NormalEmail() {
        MultiChannelNotification.SenderChannel email = new MultiChannelNotification.EmailSenderChannel();
        MultiChannelNotification.Message msg = new MultiChannelNotification.NormalMessage(email);

        assertEquals("[Email] Title: INFO | Body: Sistema atualizado com sucesso", msg.deliver("Sistema atualizado com sucesso"));
    }

    @Test
    @DisplayName("Caso 2: Enviar mensagem Urgente por SMS")
    public void testNotification_UrgentSms() {
        MultiChannelNotification.SenderChannel sms = new MultiChannelNotification.SmsSenderChannel();
        MultiChannelNotification.Message msg = new MultiChannelNotification.UrgentMessage(sms);

        assertEquals("[SMS] Title: ALERT | Body: ALERTA DE SEGURANCA", msg.deliver("Alerta de seguranca"));
    }
}
