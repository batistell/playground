package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT01 - Acesso a Banco")
public class DatabaseConnectionTest {

    @Test
    @DisplayName("Caso 1: Garantir que retorna a mesma instância")
    public void testSameInstance() {
        DatabaseConnection c1 = DatabaseConnection.getInstance();
        DatabaseConnection c2 = DatabaseConnection.getInstance();

        assertNotNull(c1);
        assertSame(c1, c2);
    }

    @Test
    @DisplayName("Caso 2: Unicidade concorrente")
    public void testThreadSafety() throws InterruptedException {
        int threads = 10;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        DatabaseConnection[] connections = new DatabaseConnection[threads];

        for (int i = 0; i < threads; i++) {
            final int idx = i;
            service.submit(() -> connections[idx] = DatabaseConnection.getInstance());
        }

        service.shutdown();
        assertTrue(service.awaitTermination(2, TimeUnit.SECONDS));

        DatabaseConnection first = connections[0];
        assertNotNull(first);
        for (int i = 1; i < threads; i++) {
            assertSame(first, connections[i]);
        }
    }
}
