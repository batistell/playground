package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT07 - Cálculo de Frete")
public class ShippingCalculatorTest {

    @Test
    @DisplayName("Caso 1: Calcular frete Regular e Expresso")
    public void testShippingCalculations() {
        ShippingCalculator.DeliveryOrder order = new ShippingCalculator.DeliveryOrder(10.0);

        // Regular
        order.setShippingStrategy(new ShippingCalculator.RegularShipping());
        assertEquals(15.0, order.calculateShippingCost(), 0.001);

        // Express
        order.setShippingStrategy(new ShippingCalculator.ExpressShipping());
        assertEquals(30.0, order.calculateShippingCost(), 0.001);
    }

    @Test
    @DisplayName("Caso 2: Frete Grátis")
    public void testFreeShipping() {
        ShippingCalculator.DeliveryOrder order = new ShippingCalculator.DeliveryOrder(100.0);
        order.setShippingStrategy(new ShippingCalculator.FreeShipping());

        assertEquals(0.0, order.calculateShippingCost(), 0.001);
    }

    @Test
    @DisplayName("Caso 3: Exceção quando estratégia não é configurada")
    public void testNoStrategyException() {
        ShippingCalculator.DeliveryOrder order = new ShippingCalculator.DeliveryOrder(15.0);
        assertThrows(IllegalStateException.class, order::calculateShippingCost);
    }
}
