package playground.challenges.mystery;

/**
 * MC10: Regras de Desconto
 * 
 * Requisito:
 * Uma loja online precisa calcular descontos de forma flexível. Durante a "Black Friday", o desconto deve
 * ser de 20% sobre o preço total. No "Natal", o desconto deve ser fixo de R$ 50 para compras acima de R$ 200.
 * Em dias comuns, nenhum desconto é aplicado.
 * A lógica deve ser facilmente expandida sem alterar o fluxo do carrinho de compras e deve ser
 * configurada dinamicamente.
 * 
 * Exercício:
 * Projete e implemente a abstração para encapsular a lógica de cálculo de desconto.
 */
public class DiscountProcessor {

    // TODO: Defina a interface para o cálculo do desconto.
    public interface DiscountPolicy {
        double applyDiscount(double originalPrice);
    }

    // TODO: Implemente as políticas de descontos concretas:
    // 1. BlackFridayDiscount: Retorna 20% de desconto (originalPrice * 0.20)
    // 2. ChristmasDiscount: Se originalPrice > 200.0, retorna 50.0 de desconto; caso contrário, retorna 0.0
    // 3. FlatDiscount: Sempre retorna 0.0 (sem desconto)

    public static class BlackFridayDiscount implements DiscountPolicy {
        @Override
        public double applyDiscount(double originalPrice) {
            // TODO: Lógica Black Friday.
            return 0.0;
        }
    }

    public static class ChristmasDiscount implements DiscountPolicy {
        @Override
        public double applyDiscount(double originalPrice) {
            // TODO: Lógica Natal.
            return 0.0;
        }
    }

    public static class FlatDiscount implements DiscountPolicy {
        @Override
        public double applyDiscount(double originalPrice) {
            // TODO: Lógica Flat.
            return 0.0;
        }
    }

    // Carrinho de Compras
    public static class Order {
        private final double originalPrice;
        private DiscountPolicy discountPolicy;

        public Order(double originalPrice) {
            this.originalPrice = originalPrice;
        }

        public void setDiscountPolicy(DiscountPolicy discountPolicy) {
            this.discountPolicy = discountPolicy;
        }

        public double calculateFinalPrice() {
            // TODO: Calcule o preço final subtraindo o desconto da política ativa do preço original.
            // Se nenhuma política foi fornecida, assuma que não há desconto (FlatDiscount).
            return originalPrice;
        }
    }
}
