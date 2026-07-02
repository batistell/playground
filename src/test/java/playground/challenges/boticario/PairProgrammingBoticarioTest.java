package playground.challenges.boticario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Desafio Boticário - Pair Programming")
public class PairProgrammingBoticarioTest {

    @Test
    @DisplayName("Caso 1: Testar entrada válida (Cenário de Sucesso)")
    public void testCasoValido() {
        // TODO: Instancie a classe e valide o cenário de sucesso (ex: retorno true, objeto correto, etc.)
        // Exemplo:
        PairProgrammingBoticario challenge = new PairProgrammingBoticario();
        assertTrue(challenge.isValid());
    }

    @Test
    @DisplayName("Caso 2: Testar entrada inválida (Cenário de Falha)")
    public void testCasoInvalido() {
        // TODO: Instancie a classe e valide o cenário de falha (ex: retorno false, erro tratado, etc.)
        // Exemplo:
        // PairProgrammingBoticario challenge = new PairProgrammingBoticario();
        // assertFalse(challenge.isValid("dado_invalido"));
    }

    @Test
    @DisplayName("Caso 3: Testar comportamento com valores nulos ou vazios (Validações de Borda)")
    public void testCasoNuloOuVazio() {
        // TODO: Instancie a classe e valide o comportamento limite (ex: lançamento de exceções)
        // Exemplo:
        // PairProgrammingBoticario challenge = new PairProgrammingBoticario();
        // assertThrows(IllegalArgumentException.class, () -> challenge.isValid(null));
    }

    @Test
    @DisplayName("Caso 4: Cenário de Teste Customizado (Regra de Negócio Específica)")
    public void testCasoCustomizado() {
        // TODO: Implemente aqui um cenário de validação específico do desafio
        // Exemplo:
        // PairProgrammingBoticario challenge = new PairProgrammingBoticario();
        // assertEquals(expectedValue, challenge.calculateOrValidate(input));
    }
}

