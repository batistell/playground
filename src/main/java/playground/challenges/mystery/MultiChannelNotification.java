package playground.challenges.mystery;

/**
 * MC04: Abstração de Mensagens
 * 
 * Requisito:
 * Seu sistema possui dois tipos de mensagens: "Normal" e "Urgente". E três canais de entrega: "Email" e "SMS".
 * Em vez de criar classes como "NormalEmailMessage", "UrgenteEmailMessage", "NormalSmsMessage" e "UrgenteSmsMessage"
 * (o que geraria uma explosão de subclasses conforme novos canais ou tipos fossem adicionados),
 * você deseja separar o "Tipo da Mensagem" (a abstração) do "Canal de Envio" (a implementação),
 * permitindo que ambos variem de forma independente.
 * 
 * Exercício:
 * Desenvolva o design que conecta as mensagens aos seus respectivos canais sem acoplamento rígido.
 */
public class MultiChannelNotification {

    // Canal de envio (Implementador)
    public interface SenderChannel {
        String sendRaw(String title, String body);
    }

    // Canal Concreto 1
    public static class EmailSenderChannel implements SenderChannel {
        @Override
        public String sendRaw(String title, String body) {
            return "[Email] Title: " + title + " | Body: " + body;
        }
    }

    // Canal Concreto 2
    public static class SmsSenderChannel implements SenderChannel {
        @Override
        public String sendRaw(String title, String body) {
            return "[SMS] Title: " + title + " | Body: " + body;
        }
    }

    // Abstração de Mensagem
    public static abstract class Message {
        protected final SenderChannel channel;

        protected Message(SenderChannel channel) {
            this.channel = channel;
        }

        public abstract String deliver(String content);
    }

    // TODO: Implemente os dois tipos de mensagens estendendo a classe Message:
    // 1. NormalMessage: define o título como "INFO" e repassa o conteúdo para o canal.
    // 2. UrgentMessage: define o título como "ALERT" e repassa o conteúdo em maiúsculas (uppercase) para o canal.

    public static class NormalMessage extends Message {
        public NormalMessage(SenderChannel channel) {
            super(channel);
        }

        @Override
        public String deliver(String content) {
            // TODO: Envie a mensagem no formato INFO.
            return null;
        }
    }

    public static class UrgentMessage extends Message {
        public UrgentMessage(SenderChannel channel) {
            super(channel);
        }

        @Override
        public String deliver(String content) {
            // TODO: Envie a mensagem no formato ALERT com conteúdo em maiúsculo.
            return null;
        }
    }
}
