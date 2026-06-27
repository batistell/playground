package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC05 - Integração de Gateway")
public class PaymentGatewayIntegrationTest {

    @Test
    @DisplayName("Caso 1: Adaptar valor decimal de cobrança para formato da SuperPay")
    public void testPaymentAdapter_Standard() {
        PaymentGatewayIntegration.SuperPaySDK sdk = new PaymentGatewayIntegration.SuperPaySDK();
        PaymentGatewayIntegration.InternalProcessor processor = new PaymentGatewayIntegration.PaymentAdapter(sdk);

        String result = processor.charge(125.45);
        assertEquals("SuperPay: Cobrado o valor de $125.45", result);
    }

    @Test
    @DisplayName("Caso 2: Adaptar valor inteiro de cobrança arredondando para duas casas decimais")
    public void testPaymentAdapter_Rounding() {
        PaymentGatewayIntegration.SuperPaySDK sdk = new PaymentGatewayIntegration.SuperPaySDK();
        PaymentGatewayIntegration.InternalProcessor processor = new PaymentGatewayIntegration.PaymentAdapter(sdk);

        String result = processor.charge(50);
        assertEquals("SuperPay: Cobrado o valor de $50.00", result);
    }
}
