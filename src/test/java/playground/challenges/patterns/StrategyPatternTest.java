package playground.challenges.patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyPatternTest {

    @Test
    public void testStrategy_CreditCard() {
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.addAmount(150);
        cart.setPaymentStrategy(new StrategyPattern.CreditCardPayment());

        String result = cart.checkout();
        assertEquals("Pago R$ 150 via Cartão de Crédito", result);
    }

    @Test
    public void testStrategy_Pix() {
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.addAmount(75);
        cart.setPaymentStrategy(new StrategyPattern.PixPayment());

        String result = cart.checkout();
        assertEquals("Pago R$ 75 via Pix", result);
    }

    @Test
    public void testStrategy_NoStrategyException() {
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.addAmount(100);
        
        assertThrows(IllegalStateException.class, () -> {
            cart.checkout();
        });
    }
}
