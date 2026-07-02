package playground.challenges.practice;

/**
 * PT04: Integração de Logs
 * 
 * Requisito:
 * Seu sistema moderno utiliza a interface `AuditLogger` para registrar logs através do método
 * `log(String level, String msg)`.
 * Contudo, a gerência exige que os logs também sejam enviados para uma ferramenta externa legada,
 * representada pelo `LegacyLoggerSDK`. O SDK legado realiza logs chamando o método `logInfo(String text)`
 * e você não pode de forma alguma alterar o código interno do `LegacyLoggerSDK`.
 * 
 * Exercício:
 * Implemente a classe intermediária necessária para conectar o `LegacyLoggerSDK` à interface `AuditLogger`.
 */
public class LoggerIntegration {

    // Interface esperada pelo seu sistema moderno
    public interface AuditLogger {
        String log(String level, String msg);
    }

    // SDK Legado de Terceiros que não pode ser alterado
    public static class LegacyLoggerSDK {
        public String logInfo(String text) {
            return "LegacySDK: " + text;
        }
    }

    // TODO: Implemente a classe LoggerAdapter abaixo para adaptar o LegacyLoggerSDK para a interface AuditLogger.
    public static class LoggerAdapter implements AuditLogger {
        LegacyLoggerSDK legacyLogger;
        // TODO: Declare o construtor e guarde a referência necessária.
        public LoggerAdapter(LegacyLoggerSDK legacyLogger) {
            // Implemente.
            this.legacyLogger = legacyLogger;
        }

        @Override
        public String log(String level, String msg) {
            // TODO: Formate a mensagem de entrada como: "[" + level + "] " + msg
            // Chame o método logInfo da classe legacyLogger passando o texto formatado e retorne o resultado.
            String msgFormatted = "[" + level + "] " + msg;
            return legacyLogger.logInfo(msgFormatted);
        }
    }
}
