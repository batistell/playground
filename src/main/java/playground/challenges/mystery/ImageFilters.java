package playground.challenges.mystery;

/**
 * MC03: Filtros Dinâmicos de Imagem
 * 
 * Requisito:
 * Você está construindo uma aplicação de edição de imagens. A aplicação precisa aplicar efeitos
 * a uma string que representa uma imagem. Esses efeitos (filtros) podem ser aplicados
 * dinamicamente em qualquer ordem ou combinação (ex: apenas Blur, Blur + Grayscale, Grayscale + Blur).
 * Não deve ser necessário criar subclasses complexas para cada combinação possível de filtros.
 * 
 * Exercício:
 * Desenvolva o mecanismo que permite estender o comportamento do processamento de imagens dinamicamente.
 */
public class ImageFilters {

    public interface ImageProcessor {
        String apply(String img);
    }

    public static class BaseImageProcessor implements ImageProcessor {
        @Override
        public String apply(String img) {
            return img;
        }
    }

    // TODO: Crie a estrutura para aplicar efeitos sobre a imagem envolvendo um ImageProcessor existente.
    
    // TODO: Implemente o efeito "Blur" que adiciona "[Blur]" ao redor do resultado do processamento da imagem (ex: "Blur(imagem)").
    public static class BlurFilter implements ImageProcessor {
        private final ImageProcessor processor;

        public BlurFilter(ImageProcessor processor) {
            this.processor = processor;
        }

        @Override
        public String apply(String img) {
            // TODO: Aplique o efeito Blur.
            return null;
        }
    }

    // TODO: Implemente o efeito "Grayscale" que adiciona "[Grayscale]" ao redor do resultado do processamento (ex: "Grayscale(imagem)").
    public static class GrayscaleFilter implements ImageProcessor {
        private final ImageProcessor processor;

        public GrayscaleFilter(ImageProcessor processor) {
            this.processor = processor;
        }

        @Override
        public String apply(String img) {
            // TODO: Aplique o efeito Grayscale.
            return null;
        }
    }
}
