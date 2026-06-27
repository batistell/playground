package playground.challenges.patterns;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorPatternTest {

    @Test
    public void testDecorator_PlainText() {
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.PlainTextProcessor();
        assertEquals("Ola", processor.process("Ola"));
    }

    @Test
    public void testDecorator_BoldText() {
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.BoldDecorator(
                new DecoratorPattern.PlainTextProcessor()
        );
        assertEquals("<b>Ola</b>", processor.process("Ola"));
    }

    @Test
    public void testDecorator_ItalicText() {
        DecoratorPattern.TextProcessor processor = new DecoratorPattern.ItalicDecorator(
                new DecoratorPattern.PlainTextProcessor()
        );
        assertEquals("<i>Ola</i>", processor.process("Ola"));
    }

    @Test
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
