package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC09 - Gravador de Logs Compartilhado")
public class SharedFileLoggerTest {

    @Test
    @DisplayName("Caso 1: Garantir instância de log única")
    public void testLogger_SameInstance() {
        SharedFileLogger l1 = SharedFileLogger.getLogger();
        SharedFileLogger l2 = SharedFileLogger.getLogger();

        assertNotNull(l1);
        assertSame(l1, l2);
    }

    @Test
    @DisplayName("Caso 2: Gravação thread-safe concorrente no gravador único")
    public void testLogger_Writing() throws InterruptedException {
        SharedFileLogger logger = SharedFileLogger.getLogger();
        assertNotNull(logger);
        logger.getLogs().clear(); // Limpa logs anteriores
        
        int threadCount = 5;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            service.submit(() -> {
                SharedFileLogger.getLogger().log("Thread " + index + " log entry");
            });
        }

        service.shutdown();
        assertTrue(service.awaitTermination(2, TimeUnit.SECONDS));

        assertEquals(5, logger.getLogs().size(), "Devem haver exatamente 5 logs escritos no singleton centralizado");
    }
}
