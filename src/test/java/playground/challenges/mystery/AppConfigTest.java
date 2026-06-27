package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC01 - Configuração Central")
public class AppConfigTest {

    @Test
    @DisplayName("Caso 1: Garantir que retorna a mesma instância da configuração")
    public void testAppConfig_SameInstance() {
        AppConfig c1 = AppConfig.getInstance();
        AppConfig c2 = AppConfig.getInstance();

        assertNotNull(c1);
        assertSame(c1, c2);
    }

    @Test
    @DisplayName("Caso 2: Garantir unicidade sob múltiplas threads concorrentes")
    public void testAppConfig_ThreadSafety() throws InterruptedException {
        int threadCount = 8;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        AppConfig[] instances = new AppConfig[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            service.submit(() -> {
                instances[index] = AppConfig.getInstance();
            });
        }

        service.shutdown();
        assertTrue(service.awaitTermination(2, TimeUnit.SECONDS));

        AppConfig base = instances[0];
        assertNotNull(base);
        for (int i = 1; i < threadCount; i++) {
            assertSame(base, instances[i]);
        }
    }

    @Test
    @DisplayName("Caso 3: Persistência de valores definidos na configuração")
    public void testAppConfig_StateRetention() {
        AppConfig config = AppConfig.getInstance();
        assertNotNull(config);
        config.set("db.url", "jdbc:mysql://localhost:3306/db");
        config.set("app.timeout", "5000");

        AppConfig configCheck = AppConfig.getInstance();
        assertEquals("jdbc:mysql://localhost:3306/db", configCheck.get("db.url"));
        assertEquals("5000", configCheck.get("app.timeout"));
    }
}
