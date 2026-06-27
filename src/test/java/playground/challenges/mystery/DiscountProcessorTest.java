package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC10 - Regras de Desconto")
public class DiscountProcessorTest {

    @Test
    @DisplayName("Caso 1: Aplicar desconto Black Friday (20%)")
    public void testDiscount_BlackFriday() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(100.0);
        order.setDiscountPolicy(new DiscountProcessor.BlackFridayDiscount());

        double finalPrice = order.calculateFinalPrice();
        assertEquals(80.0, finalPrice, 0.001);
    }

    @Test
    @DisplayName("Caso 2: Aplicar desconto de Natal qualificado (> R$ 200)")
    public void testDiscount_ChristmasQualified() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(250.0);
        order.setDiscountPolicy(new DiscountProcessor.ChristmasDiscount());

        double finalPrice = order.calculateFinalPrice();
        assertEquals(200.0, finalPrice, 0.001);
    }

    @Test
    @DisplayName("Caso 3: Não aplicar desconto de Natal não qualificado (<= R$ 200)")
    public void testDiscount_ChristmasNotQualified() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(150.0);
        order.setDiscountPolicy(new DiscountProcessor.ChristmasDiscount());

        double finalPrice = order.calculateFinalPrice();
        assertEquals(150.0, finalPrice, 0.001);
    }

    @Test
    @DisplayName("Caso 4: Garantir que não há desconto por padrão (sem política)")
    public void testDiscount_FlatDefault() {
        DiscountProcessor.Order order = new DiscountProcessor.Order(100.0);
        
        // Sem política fornecida, deve manter preço original
        double finalPrice = order.calculateFinalPrice();
        assertEquals(100.0, finalPrice, 0.001);
    }
}
