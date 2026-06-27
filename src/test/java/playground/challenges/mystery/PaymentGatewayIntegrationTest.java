package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentGatewayIntegrationTest {

    @Test
    public void testPaymentAdapter_Standard() {
        PaymentGatewayIntegration.SuperPaySDK sdk = new PaymentGatewayIntegration.SuperPaySDK();
        PaymentGatewayIntegration.InternalProcessor processor = new PaymentGatewayIntegration.PaymentAdapter(sdk);

        String result = processor.charge(125.45);
        assertEquals("SuperPay: Cobrado o valor de $125.45", result);
    }

    @Test
    public void testPaymentAdapter_Rounding() {
        PaymentGatewayIntegration.SuperPaySDK sdk = new PaymentGatewayIntegration.SuperPaySDK();
        PaymentGatewayIntegration.InternalProcessor processor = new PaymentGatewayIntegration.PaymentAdapter(sdk);

        String result = processor.charge(50);
        assertEquals("SuperPay: Cobrado o valor de $50.00", result);
    }
}
