package playground.challenges.patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueryBuilderTest {

    @Test
    public void testQueryBuilder_Complete() {
        String sql = QueryBuilder.start()
                .select("name", "age")
                .from("users")
                .where("age > 18")
                .build();
        assertEquals("SELECT name, age FROM users WHERE age > 18", sql);
    }

    @Test
    public void testQueryBuilder_SelectAll() {
        String sql = QueryBuilder.start()
                .from("orders")
                .build();
        assertEquals("SELECT * FROM orders", sql);
    }

    @Test
    public void testQueryBuilder_MultipleSelectCalls() {
        String sql = QueryBuilder.start()
                .select("id")
                .select("title", "description")
                .from("books")
                .build();
        assertEquals("SELECT id, title, description FROM books", sql);
    }

    @Test
    public void testQueryBuilder_NoTableException() {
        assertThrows(IllegalStateException.class, () -> {
            QueryBuilder.start().select("name").build();
        });
    }
}
