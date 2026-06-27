package playground.challenges.patterns;

/**
 * DP06: Decorator (Formatadores de Texto HTML)
 * 
 * O padrão Decorator anexa responsabilidades adicionais a um objeto de maneira
 * dinâmica. Decoradores fornecem uma alternativa flexível à subclassificação
 * para estender a funcionalidade.
 * 
 * Exercício:
 * Implemente decoradores de texto HTML (`BoldDecorator` e `ItalicDecorator`)
 * que envolvem strings em tags HTML sem alterar a classe original `PlainTextProcessor`.
 */
public class DecoratorPattern {

    // Componente base
    public interface TextProcessor {
        String process(String text);
    }

    // Componente concreto
    public static class PlainTextProcessor implements TextProcessor {
        @Override
        public String process(String text) {
            return text;
        }
    }

    // Decorador abstrato base
    public static abstract class TextDecorator implements TextProcessor {
        protected final TextProcessor wrapper;

        public TextDecorator(TextProcessor wrapper) {
            this.wrapper = wrapper;
        }

        @Override
        public String process(String text) {
            return wrapper.process(text);
        }
    }

    // TODO: Implemente os dois decoradores concretos abaixo:
    // 1. BoldDecorator: Envolve o texto resultante em "<b>" e "</b>"
    // 2. ItalicDecorator: Envolve o texto resultante em "<i>" e "</i>"

    public static class BoldDecorator extends TextDecorator {
        public BoldDecorator(TextProcessor wrapper) {
            super(wrapper);
        }

        @Override
        public String process(String text) {
            // TODO: Formate o texto aplicando a tag HTML correspondente à negrito.
            return null;
        }
    }

    public static class ItalicDecorator extends TextDecorator {
        public ItalicDecorator(TextProcessor wrapper) {
            super(wrapper);
        }

        @Override
        public String process(String text) {
            // TODO: Formate o texto aplicando a tag HTML correspondente à itálico.
            return null;
        }
    }
}
