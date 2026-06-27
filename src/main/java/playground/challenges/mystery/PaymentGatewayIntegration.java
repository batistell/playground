package playground.challenges.mystery;

/**
 * MC05: Integração de Gateway
 * 
 * Requisito:
 * Seu sistema de e-commerce utiliza a interface `InternalProcessor` para cobrar valores via `charge(double value)`.
 * Uma nova diretoria exige a integração com um gateway de pagamento legado chamado `SuperPaySDK` que realiza
 * cobranças através de `makePayment(String usdAmount)`, onde o valor deve ser formatado como string com um prefixo "$" (ex: "$100.00").
 * Você não pode alterar o código do `SuperPaySDK`.
 * 
 * Exercício:
 * Implemente a classe intermediária necessária para conectar o `SuperPaySDK` à interface `InternalProcessor`.
 */
public class PaymentGatewayIntegration {

    // Interface esperada pela sua aplicação
    public interface InternalProcessor {
        String charge(double value);
    }

    // SDK de Terceiros que não pode ser alterado
    public static class SuperPaySDK {
        public String makePayment(String usdAmount) {
            return "SuperPay: Cobrado o valor de " + usdAmount;
        }
    }

    // TODO: Implemente a classe abaixo para adaptar o SuperPaySDK para a interface InternalProcessor.
    public static class PaymentAdapter implements InternalProcessor {
        private final SuperPaySDK sdk;

        public PaymentAdapter(SuperPaySDK sdk) {
            this.sdk = sdk;
        }

        @Override
        public String charge(double value) {
            // TODO: Formate o double como string com duas casas decimais e o caractere "$" no início (ex: 45.5 -> "$45.50").
            // Chame o método makePayment do sdk e retorne o resultado.
            return null;
        }
    }
}
