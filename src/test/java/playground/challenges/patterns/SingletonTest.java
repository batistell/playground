package playground.challenges.patterns;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void testSingleton_SameInstance() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        assertNotNull(s1, "A instância não deve ser nula");
        assertSame(s1, s2, "Ambas as referências devem apontar para a mesma instância");
    }

    @Test
    public void testSingleton_ThreadSafety() throws InterruptedException {
        int threadCount = 10;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        Singleton[] instances = new Singleton[threadCount];
        AtomicInteger nullCount = new AtomicInteger(0);

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            service.submit(() -> {
                try {
                    instances[index] = Singleton.getInstance();
                    if (instances[index] == null) {
                        nullCount.incrementAndGet();
                    }
                } catch (Exception e) {
                    // Ignora
                }
            });
        }

        service.shutdown();
        assertTrue(service.awaitTermination(2, TimeUnit.SECONDS), "As threads não terminaram a tempo");

        assertEquals(0, nullCount.get(), "Nenhuma instância retornada deve ser nula");
        
        Singleton first = instances[0];
        assertNotNull(first, "A primeira instância criada não deve ser nula");
        for (int i = 1; i < threadCount; i++) {
            assertSame(first, instances[i], "Todas as threads devem obter a mesma instância única");
        }
    }
}
