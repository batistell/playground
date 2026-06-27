package playground.challenges.patterns;

/**
 * DP02: Factory Method (Sistema de Notificações)
 * 
 * O padrão Factory Method define uma interface para criar um objeto, mas deixa as
 * subclasses decidirem qual classe instanciar. Ele permite que uma classe adie
 * a instanciação para subclasses.
 * 
 * Exercício:
 * Implemente as notificações e a fábrica correspondente baseada em um tipo enum/string.
 */
public class NotificationFactory {

    public enum Type {
        EMAIL, SMS
    }

    public interface Notification {
        String send(String message);
    }

    // TODO: Implemente as duas classes concretas abaixo que implementam a interface Notification:
    // 1. EmailNotification: deve retornar "Email enviado com sucesso: " + message
    // 2. SMSNotification: deve retornar "SMS enviado com sucesso: " + message

    public static class EmailNotification implements Notification {
        @Override
        public String send(String message) {
            return "Email enviado com sucesso: " + message;
        }
    }

    public static class SMSNotification implements Notification {
        @Override
        public String send(String message) {
            return "SMS enviado com sucesso: " + message;
        }
    }

    /**
     * Factory Method
     */
    public Notification createNotification(Type type) {
        // TODO: Implemente o método de fábrica para instanciar a notificação correta com base no Type.
        // Se for passado um tipo nulo ou desconhecido, lance uma IllegalArgumentException.
        if (type == null) {
            throw new IllegalArgumentException("Tipo de notificação nulo");
        }
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            default -> throw new IllegalArgumentException("Tipo de notificação inválido: " + type);
        };
    }
}
