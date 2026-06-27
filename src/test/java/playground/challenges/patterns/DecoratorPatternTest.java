package playground.challenges.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DP06 - Decorator (Formatadores de Texto HTML)")
public class DecoratorPatternTest {

    @Test
    @DisplayName("Caso 1: Retornar texto plano sem formatação")
    public void testDecorator_PlainText() {
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.PlainTextProcessor();
        assertEquals("Ola", processor.process("Ola"));
    }

    @Test
    @DisplayName("Caso 2: Formatar texto com tag Negrito (Bold)")
    public void testDecorator_BoldText() {
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.BoldDecorator(
                new DecoratorPattern.PlainTextProcessor()
        );
        assertEquals("<b>Ola</b>", processor.process("Ola"));
    }

    @Test
    @DisplayName("Caso 3: Formatar texto com tag Itálico (Italic)")
    public void testDecorator_ItalicText() {
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.ItalicDecorator(
                new DecoratorPattern.PlainTextProcessor()
        );
        assertEquals("<i>Ola</i>", processor.process("Ola"));
    }

    @Test
    @DisplayName("Caso 4: Formatar texto combinando Negrito e Itálico")
    public void testDecorator_CombinedBoldAndItalic() {
        // Envolve primeiro com Itálico, depois Negrito: <b><i>Ola</i></b>
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.BoldDecorator(
                new DecoratorPattern.ItalicDecorator(
                        new DecoratorPattern.PlainTextProcessor()
                )
        );
        assertEquals("<b><i>Ola</i></b>", processor.process("Ola"));
    }
}
