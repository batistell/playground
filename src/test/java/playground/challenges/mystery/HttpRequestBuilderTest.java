package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC08 - Construção de Requisições HTTP")
public class HttpRequestBuilderTest {

    @Test
    @DisplayName("Caso 1: Construir requisição POST completa com headers e body")
    public void testRequestBuilder_CompletePost() {
        HttpRequestBuilder.HttpRequest request = new HttpRequestBuilder.Builder()
                .url("https://api.github.com/users")
                .method("POST")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer token")
                .body("{\"name\": \"carlos\"}")
                .build();

        assertNotNull(request);
        assertEquals("https://api.github.com/users", request.getUrl());
        assertEquals("POST", request.getMethod());
        assertEquals("application/json", request.getHeaders().get("Content-Type"));
        assertEquals("Bearer token", request.getHeaders().get("Authorization"));
        assertEquals("{\"name\": \"carlos\"}", request.getBody());
    }

    @Test
    @DisplayName("Caso 2: Construir requisição GET simples com método padrão")
    public void testRequestBuilder_DefaultGet() {
        HttpRequestBuilder.HttpRequest request = new HttpRequestBuilder.Builder()
                .url("https://api.github.com/users/octocat")
                .build();

        assertNotNull(request);
        assertEquals("https://api.github.com/users/octocat", request.getUrl());
        assertEquals("GET", request.getMethod());
        assertTrue(request.getHeaders().isEmpty());
        assertNull(request.getBody());
    }

    @Test
    @DisplayName("Caso 3: Lançar exceção se tentar construir requisição sem URL")
    public void testRequestBuilder_NoUrlException() {
        assertThrows(IllegalStateException.class, () -> {
            new HttpRequestBuilder.Builder().method("GET").build();
        });
    }
}
