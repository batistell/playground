package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP07 - Strategy (Cálculo de Pagamentos)")
public class StrategyPatternTest {

    @Test
    @DisplayName("Caso 1: Finalizar compra pagando com Cartão de Crédito")
    public void testStrategy_CreditCard() {
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.addAmount(150);
        cart.setPaymentStrategy(new StrategyPattern.CreditCardPayment());

        String result = cart.checkout();
        assertEquals("Pago R$ 150 via Cartão de Crédito", result);
    }

    @Test
    @DisplayName("Caso 2: Finalizar compra pagando com Pix")
    public void testStrategy_Pix() {
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.addAmount(75);
        cart.setPaymentStrategy(new StrategyPattern.PixPayment());

        String result = cart.checkout();
        assertEquals("Pago R$ 75 via Pix", result);
    }

    @Test
    @DisplayName("Caso 3: Lançar exceção se tentar pagar sem definir uma estratégia")
    public void testStrategy_NoStrategyException() {
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.addAmount(100);
        
        assertThrows(IllegalStateException.class, () -> {
            cart.checkout();
        });
    }
}
