package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP03 - Builder (QueryBuilder SQL)")
public class QueryBuilderTest {

    @Test
    @DisplayName("Caso 1: Construir query completa com SELECT, FROM e WHERE")
    public void testQueryBuilder_Complete() {
        String sql = QueryBuilder.start()
                .select("name", "age")
                .from("users")
                .where("age > 18")
                .build();
        assertEquals("SELECT name, age FROM users WHERE age > 18", sql);
    }

    @Test
    @DisplayName("Caso 2: Construir query com SELECT * (todas as colunas)")
    public void testQueryBuilder_SelectAll() {
        String sql = QueryBuilder.start()
                .from("orders")
                .build();
        assertEquals("SELECT * FROM orders", sql);
    }

    @Test
    @DisplayName("Caso 3: Construir query acumulando múltiplas chamadas de colunas")
    public void testQueryBuilder_MultipleSelectCalls() {
        String sql = QueryBuilder.start()
                .select("id")
                .select("title", "description")
                .from("books")
                .build();
        assertEquals("SELECT id, title, description FROM books", sql);
    }

    @Test
    @DisplayName("Caso 4: Lançar exceção se nenhuma tabela (FROM) for informada")
    public void testQueryBuilder_NoTableException() {
        assertThrows(IllegalStateException.class, () -> {
            QueryBuilder.start().select("name").build();
        });
    }
}
