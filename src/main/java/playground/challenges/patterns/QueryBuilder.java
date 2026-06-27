package playground.challenges.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * DP03: Builder (QueryBuilder SQL)
 * 
 * O padrão Builder separa a construção de um objeto complexo de sua representação,
 * de modo que o mesmo processo de construção possa criar diferentes representações.
 * 
 * Exercício:
 * Implemente um QueryBuilder fluente que constrói queries SQL simples no formato:
 * "SELECT col1, col2 FROM tabela WHERE condicao"
 */
public class QueryBuilder {

    private final List<String> columns = new ArrayList<>();
    private String table;
    private String condition;

    // Construtor privado para forçar o uso do Builder ou do próprio fluxo fluente.
    private QueryBuilder() {}

    public static QueryBuilder start() {
        return new QueryBuilder();
    }

    public QueryBuilder select(String... cols) {
        for (String col : cols) {
            this.columns.add(col);
        }
        return this;
    }

    public QueryBuilder from(String tbl) {
        this.table = tbl;
        return this;
    }

    public QueryBuilder where(String cond) {
        this.condition = cond;
        return this;
    }

    public String build() {
        // TODO: Construa e retorne a query SQL como string com base nas configurações informadas.
        // 1. Se nenhuma coluna for definida no select, use "*" por padrão.
        // 2. Se a tabela não for definida (from nulo ou vazio), lance um IllegalStateException.
        // 3. Monte a query garantindo o espaçamento correto. Se WHERE não for fornecido, não adicione a cláusula WHERE.
        // Exemplo esperado: "SELECT name, age FROM users WHERE age > 18"
        if (table == null || table.isEmpty()) {
            throw new IllegalStateException("Tabela não definida");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        if (columns.isEmpty()) {
            sb.append("*");
        } else {
            sb.append(String.join(", ", columns));
        }
        sb.append(" FROM ").append(table);
        if (condition != null && !condition.isEmpty()) {
            sb.append(" WHERE ").append(condition);
        }
        return sb.toString();
    }
}
