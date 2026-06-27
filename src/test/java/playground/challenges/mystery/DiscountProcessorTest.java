package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountProcessorTest {

    @Test
    public void testDiscount_BlackFriday() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(100.0);
        order.setDiscountPolicy(new DiscountProcessor.BlackFridayDiscount());

        double finalPrice = order.calculateFinalPrice();
        assertEquals(80.0, finalPrice, 0.001);
    }

    @Test
    public void testDiscount_ChristmasQualified() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(250.0);
        order.setDiscountPolicy(new DiscountProcessor.ChristmasDiscount());

        double finalPrice = order.calculateFinalPrice();
        assertEquals(200.0, finalPrice, 0.001);
    }

    @Test
    public void testDiscount_ChristmasNotQualified() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(150.0);
        order.setDiscountPolicy(new DiscountProcessor.ChristmasDiscount());

        double finalPrice = order.calculateFinalPrice();
        assertEquals(150.0, finalPrice, 0.001);
    }

    @Test
    public void testDiscount_FlatDefault() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(100.0);
        
        // Sem política fornecida, deve manter preço original
        double finalPrice = order.calculateFinalPrice();
        assertEquals(100.0, finalPrice, 0.001);
    }
}
