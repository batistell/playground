package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT04 - Integração de Logs")
public class LoggerIntegrationTest {

    @Test
    @DisplayName("Caso 1: Adaptar chamadas do logger para o formato legado")
    public void testLoggerAdaptation() {
        LoggerIntegration.LegacyLoggerSDK legacySDK = new LoggerIntegration.LegacyLoggerSDK();
        LoggerIntegration.AuditLogger logger = new LoggerIntegration.LoggerAdapter(legacySDK);

        String result1 = logger.log("INFO", "Usuario autenticado");
        assertEquals("LegacySDK: [INFO] Usuario autenticado", result1);

        String result2 = logger.log("ERROR", "Erro de conexao");
        assertEquals("LegacySDK: [ERROR] Erro de conexao", result2);
    }
}
