package playground.challenges.practice;

/**
 * PT07: Cálculo de Frete
 * 
 * Requisito:
 * Seu e-commerce precisa calcular o valor de frete de uma entrega com base na distância em km.
 * O algoritmo de cálculo muda de acordo com o método escolhido (Expresso, Regular, Grátis).
 * Evite colocar múltiplos condicionais if-else ou switch acoplados na classe de pedido,
 * permitindo alterar e configurar o algoritmo tributário/frete dinamicamente em tempo de execução.
 * 
 * Exercício:
 * Implemente e configure as estruturas de modo a isolar as estratégias de cálculo do frete.
 */
public class ShippingCalculator {

    // TODO: Defina a abstração/interface do algoritmo de frete.
    public interface ShippingStrategy {
        double calculate(double distanceKm);
    }

    // TODO: Implemente as políticas concretas de frete que assinam a interface ShippingStrategy:
    // 1. RegularShipping: cobra R$ 1.50 por km (distanceKm * 1.50).
    // 2. ExpressShipping: cobra R$ 3.00 por km (distanceKm * 3.00).
    // 3. FreeShipping: frete sempre gratuito (retorna 0.0).

    public static class RegularShipping implements ShippingStrategy {
        @Override
        public double calculate(double distanceKm) {
            // Implemente.
            return 0.0;
        }
    }

    public static class ExpressShipping implements ShippingStrategy {
        @Override
        public double calculate(double distanceKm) {
            // Implemente.
            return 0.0;
        }
    }

    public static class FreeShipping implements ShippingStrategy {
        @Override
        public double calculate(double distanceKm) {
            // Implemente.
            return 0.0;
        }
    }

    // Pedido / Carrinho
    public static class DeliveryOrder {
        private final double distanceKm;
        
        // TODO: Mantenha uma referência para a estratégia de frete ativa e exponha um método de configuração (setter).

        public DeliveryOrder(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public void setShippingStrategy(ShippingStrategy shippingStrategy) {
            // TODO: Defina a estratégia ativa.
        }

        public double calculateShippingCost() {
            // TODO: Calcule e retorne o frete com base na estratégia ativa.
            // Lance um IllegalStateException se nenhuma estratégia foi configurada.
            return 0.0;
        }
    }
}
