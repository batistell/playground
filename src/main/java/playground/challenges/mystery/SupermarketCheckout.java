package playground.challenges.mystery;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * MC11: Caixa de Supermercado com Promoções
 * 
 * Requisito:
 * Um supermercado possui três produtos com diferentes regras de preço e promoção:
 * 
 * 1. Alface (Lettuce):
 *    - Preço unitário: R$ 10.00
 *    - Promoção: Nenhuma.
 * 
 * 2. Pasta de Dente (Toothpaste):
 *    - Preço unitário: R$ 5.00
 *    - Promoção: "Leve 2, Pague 1" (A cada 2 unidades, você só paga por 1).
 *      Exemplos de preços: 1 unit = R$ 5, 2 units = R$ 5, 3 units = R$ 10, 4 units = R$ 10, 5 units = R$ 15.
 * 
 * 3. Produto X (Sabonete/Soap):
 *    - Preço unitário: R$ 8.00
 *    - Promoção: "Compre dois, leve o segundo com 50% de desconto" (A cada par, o segundo item sai com 50% de desconto).
 *      Exemplos de preços: 1 unit = R$ 8, 2 units = R$ 12, 3 units = R$ 20, 4 units = R$ 24.
 * 
 * Desafio:
 * Implemente o método `calculateTotal` para calcular o valor total da compra com base nas promoções.
 * O método `main` abaixo simula a compra de 2 alfaces, 3 pastas de dente e 4 produtos X, cujo total deve ser R$ 54.00.
 */
public class SupermarketCheckout {

    public static void main(String[] args) {
        SupermarketCheckout checkout = new SupermarketCheckout();
        
        Map<String, Integer> cart = new HashMap<>();
        cart.put("alface", 2);
        cart.put("pasta_de_dente", 3);
        cart.put("produto_x", 4);
        
        try {
            double total = checkout.calculateTotal(cart);
            System.out.println("Carrinho de Compras:");
            System.out.println("- 2 Alfaces");
            System.out.println("- 3 Pastas de Dente");
            System.out.println("- 4 Produtos X");
            System.out.println("-------------------------");
            System.out.printf("Total Calculado: R$ %.2f\n", total);
            System.out.println("Total Esperado:  R$ 54.00");
        } catch (UnsupportedOperationException e) {
            System.out.println("Desafio pendente: implemente o método calculateTotal!");
        }
    }

    public double calculateTotal(Map<String, Integer> cart) {
        double total = 0.0;
        
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String key = entry.getKey();
            Integer quantity = entry.getValue();
            
            if (quantity == null || quantity < 0) {
                throw new IllegalArgumentException("Quantidade inválida para o produto: " + key);
            }
            
            String normalizedKey = key.toLowerCase();
            switch (normalizedKey) {
                case "alface":
                    total += quantity * 10.0;
                    break;
                case "pasta_de_dente":
                    int paidToothpastes = quantity - (quantity / 2);
                    total += paidToothpastes * 5.0;
                    break;
                case "produto_x":
                    int pairs = quantity / 2;
                    int remainder = quantity % 2;
                    total += (pairs * 12.0) + (remainder * 8.0);
                    break;
                default:
                    throw new IllegalArgumentException("Produto desconhecido: " + key);
            }
        }
        
        return total;
    }
}
