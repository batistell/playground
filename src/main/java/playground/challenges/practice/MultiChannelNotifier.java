package playground.challenges.practice;

/**
 * PT06: Sistema de Notificação
 * 
 * Requisito:
 * Seu sistema envia mensagens básicas de texto. Você deseja estender dinamicamente a forma de notificação
 * adicionando novos canais (como SMS e Push) em qualquer combinação em tempo de execução, sem a necessidade
 * de criar subclasses acopladas para cada combinação de canais.
 * 
 * Exercício:
 * Implemente as estruturas necessárias de modo que os novos canais possam envolver um notificador
 * base existente e estender seu comportamento.
 */
public class MultiChannelNotifier {

    public interface Notifier {
        String send(String msg);
    }

    public static class BaseNotifier implements Notifier {
        @Override
        public String send(String msg) {
            return msg;
        }
    }

    // TODO: Implemente os canais adicionais de notificação abaixo.
    // Ambos devem ser capazes de embrulhar outro Notifier e estender seu comportamento:
    // 1. SmsNotifier: Deve delegar ao Notifier interno e adicionar " [SMS]" ao final.
    // 2. PushNotifier: Deve delegar ao Notifier interno e adicionar " [Push]" ao final.

    public static class SmsNotifier implements Notifier {
        
        // TODO: Declare o construtor necessário.
        public SmsNotifier(Notifier wrapped) {
            // Implemente.
        }

        @Override
        public String send(String msg) {
            // TODO: Implemente.
            return null;
        }
    }

    public static class PushNotifier implements Notifier {
        
        // TODO: Declare o construtor necessário.
        public PushNotifier(Notifier wrapped) {
            // Implemente.
        }

        @Override
        public String send(String msg) {
            // TODO: Implemente.
            return null;
        }
    }
}
