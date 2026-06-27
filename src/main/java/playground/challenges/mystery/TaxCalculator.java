package playground.challenges.mystery;

/**
 * MC06: Cálculo Tributário
 * 
 * Requisito:
 * Seu sistema de faturamento precisa calcular o imposto de vendas sobre o valor de um item.
 * O percentual de imposto varia dependendo da região do cliente:
 * - Brasil: 15% de imposto.
 * - EUA: 8% de imposto.
 * - Europa: 20% de imposto.
 * Você deseja evitar uma árvore gigante de condicionais `if-else` ou `switch` dentro da classe de pedido,
 * permitindo mudar a regra tributária de cálculo dinamicamente em tempo de execução.
 * 
 * Exercício:
 * Desenhe a estrutura que permita encapsular essas variações de algoritmos de cálculo.
 */
public class TaxCalculator {

    // TODO: Defina a interface do algoritmo de cálculo de imposto.
    public interface TaxRule {
        double calculateTax(double amount);
    }

    // TODO: Implemente as regras de taxas concretas abaixo:
    // 1. BrazilTaxRule: Retorna 15% do valor (amount * 0.15)
    // 2. UsaTaxRule: Retorna 8% do valor (amount * 0.08)
    // 3. EuropeTaxRule: Retorna 20% do valor (amount * 0.20)

    public static class BrazilTaxRule implements TaxRule {
        @Override
        public double calculateTax(double amount) {
            // TODO: Lógica de taxa para o Brasil.
            return 0.0;
        }
    }

    public static class UsaTaxRule implements TaxRule {
        @Override
        public double calculateTax(double amount) {
            // TODO: Lógica de taxa para os EUA.
            return 0.0;
        }
    }

    public static class EuropeTaxRule implements TaxRule {
        @Override
        public double calculateTax(double amount) {
            // TODO: Lógica de taxa para a Europa.
            return 0.0;
        }
    }

    // Contexto de Vendas
    public static class Invoice {
        private TaxRule taxRule;

        public void setTaxRule(TaxRule taxRule) {
            this.taxRule = taxRule;
        }

        public double calculateTotal(double amount) {
            // TODO: Calcule o valor do imposto usando a regra configurada.
            // Lance um IllegalStateException se a regra tributária não for informada.
            // Retorne o valor do imposto calculado.
            return 0.0;
        }
    }
}
