package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiChannelNotificationTest {

    @Test
    public void testNotification_NormalEmail() {
        MultiChannelNotification.SenderChannel email = new MultiChannelNotification.EmailSenderChannel();
        MultiChannelNotification.Message msg = new MultiChannelNotification.NormalMessage(email);

        assertEquals("[Email] Title: INFO | Body: Sistema atualizado com sucesso", msg.deliver("Sistema atualizado com sucesso"));
    }

    @Test
    public void testNotification_UrgentSms() {
        MultiChannelNotification.SenderChannel sms = new MultiChannelNotification.SmsSenderChannel();
        MultiChannelNotification.Message msg = new MultiChannelNotification.UrgentMessage(sms);

        assertEquals("[SMS] Title: ALERT | Body: ALERTA DE SEGURANCA", msg.deliver("Alerta de seguranca"));
    }
}
