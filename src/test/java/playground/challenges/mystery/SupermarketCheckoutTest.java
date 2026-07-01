package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC11 - Caixa de Supermercado com Promoções")
public class SupermarketCheckoutTest {

    private final SupermarketCheckout checkout = new SupermarketCheckout();

    @Test
    @DisplayName("Carrinho Vazio: Deve retornar R$ 0.00")
    public void testEmptyCart() {
        Map<String, Integer> cart = new HashMap<>();
        assertEquals(0.00, checkout.calculateTotal(cart), 0.001);
    }

    @Test
    @DisplayName("Somente Alface: Preço linear de R$ 10.00 por unidade")
    public void testOnlyAlface() {
        Map<String, Integer> cart = new HashMap<>();
        cart.put("alface", 1);
        assertEquals(10.00, checkout.calculateTotal(cart), 0.001);

        cart.put("alface", 3);
        assertEquals(30.00, checkout.calculateTotal(cart), 0.001);
    }

    @Test
    @DisplayName("Somente Pasta de Dente: Promoção Leve 2, Pague 1 (R$ 5.00 a unidade)")
    public void testOnlyPastaDeDente() {
        Map<String, Integer> cart = new HashMap<>();
        
        // 1 unidade -> R$ 5.00
        cart.put("pasta_de_dente", 1);
        assertEquals(5.00, checkout.calculateTotal(cart), 0.001);

        // 2 unidades -> R$ 5.00
        cart.put("pasta_de_dente", 2);
        assertEquals(5.00, checkout.calculateTotal(cart), 0.001);

        // 3 unidades -> R$ 10.00
        cart.put("pasta_de_dente", 3);
        assertEquals(10.00, checkout.calculateTotal(cart), 0.001);

        // 4 unidades -> R$ 10.00
        cart.put("pasta_de_dente", 4);
        assertEquals(10.00, checkout.calculateTotal(cart), 0.001);

        // 5 unidades -> R$ 15.00
        cart.put("pasta_de_dente", 5);
        assertEquals(15.00, checkout.calculateTotal(cart), 0.001);
    }

    @Test
    @DisplayName("Somente Produto X: Promoção compre 2, o 2º com 50% de desconto (R$ 8.00 a unidade)")
    public void testOnlyProdutoX() {
        Map<String, Integer> cart = new HashMap<>();

        // 1 unidade -> R$ 8.00
        cart.put("produto_x", 1);
        assertEquals(8.00, checkout.calculateTotal(cart), 0.001);

        // 2 unidades -> R$ 12.00 (8.00 + 4.00)
        cart.put("produto_x", 2);
        assertEquals(12.00, checkout.calculateTotal(cart), 0.001);

        // 3 unidades -> R$ 20.00 (12.00 + 8.00)
        cart.put("produto_x", 3);
        assertEquals(20.00, checkout.calculateTotal(cart), 0.001);

        // 4 unidades -> R$ 24.00 (12.00 + 12.00)
        cart.put("produto_x", 4);
        assertEquals(24.00, checkout.calculateTotal(cart), 0.001);
    }

    @Test
    @DisplayName("Carrinho Misto (Caso do Áudio): 2 Alfaces + 3 Pastas + 4 Produtos X = R$ 54.00")
    public void testMixedCartFromAudio() {
        Map<String, Integer> cart = new HashMap<>();
        cart.put("alface", 2);          // 2 * 10 = 20
        cart.put("pasta_de_dente", 3);  // Leve 2, pague 1 (3 items) = 2 * 5 = 10
        cart.put("produto_x", 4);       // Compre 2, 2º com 50% (4 items) = 8 + 4 + 8 + 4 = 24
        
        // Total esperado: 20 + 10 + 24 = 54
        assertEquals(54.00, checkout.calculateTotal(cart), 0.001);
    }

    @Test
    @DisplayName("Case-Insensitive: Chaves com maiúsculas devem ser aceitas")
    public void testCaseInsensitivity() {
        Map<String, Integer> cart = new HashMap<>();
        cart.put("ALfAcE", 1);
        cart.put("PASTA_de_DENTE", 2);
        cart.put("pRoDuTo_X", 2);
        
        assertEquals(27.00, checkout.calculateTotal(cart), 0.001); // 10 + 5 + 12 = 27
    }

    @Test
    @DisplayName("Validação: Deve lançar IllegalArgumentException para quantidade negativa")
    public void testNegativeQuantity() {
        Map<String, Integer> cart = new HashMap<>();
        cart.put("alface", -1);
        assertThrows(IllegalArgumentException.class, () -> checkout.calculateTotal(cart));
    }

    @Test
    @DisplayName("Validação: Deve lançar IllegalArgumentException para produto desconhecido")
    public void testUnknownProduct() {
        Map<String, Integer> cart = new HashMap<>();
        cart.put("shampoo", 1);
        assertThrows(IllegalArgumentException.class, () -> checkout.calculateTotal(cart));
    }
}
