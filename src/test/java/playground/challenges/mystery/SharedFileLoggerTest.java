package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class SharedFileLoggerTest {

    @Test
    public void testLogger_SameInstance() {
        SharedFileLogger l1 = SharedFileLogger.getLogger();
        SharedFileLogger l2 = SharedFileLogger.getLogger();

        assertNotNull(l1);
        assertSame(l1, l2);
    }

    @Test
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
