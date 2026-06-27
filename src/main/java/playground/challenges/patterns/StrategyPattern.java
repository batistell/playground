package playground.challenges.patterns;

/**
 * DP07: Strategy (Cálculo de Pagamentos)
 * 
 * O padrão Strategy define uma família de algoritmos, encapsula cada um deles
 * e os torna intercambiáveis. O Strategy permite que o algoritmo varie
 * independentemente dos clientes que o utilizam.
 * 
 * Exercício:
 * Implemente as estratégias de pagamento (`CreditCardPayment` e `PixPayment`)
 * e integre-as no contexto `ShoppingCart`.
 */
public class StrategyPattern {

    // Interface Strategy
    public interface PaymentStrategy {
        String pay(int amount);
    }

    // TODO: Implemente as duas estratégias concretas abaixo:
    // 1. CreditCardPayment: Deve retornar "Pago R$ " + amount + " via Cartão de Crédito"
    // 2. PixPayment: Deve retornar "Pago R$ " + amount + " via Pix"

    public static class CreditCardPayment implements PaymentStrategy {
        @Override
        public String pay(int amount) {
            // TODO: Lógica de pagamento com Cartão de Crédito.
            return null;
        }
    }

    public static class PixPayment implements PaymentStrategy {
        @Override
        public String pay(int amount) {
            // TODO: Lógica de pagamento com Pix.
            return null;
        }
    }

    // Contexto
    public static class ShoppingCart {
        private PaymentStrategy strategy;
        private int totalAmount = 0;

        public void addAmount(int amount) {
            this.totalAmount += amount;
        }

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public String checkout() {
            // TODO: Execute o pagamento usando a estratégia configurada.
            // Lance um IllegalStateException se nenhuma estratégia foi definida.
            
            return null;
        }
    }
}
