package playground.challenges.practice;

/**
 * PT05: Sistema Gráfico
 * 
 * Requisito:
 * Você está construindo uma aplicação de desenho. Existem diferentes formas geométricas (como Círculo e Quadrado)
 * e diferentes motores de renderização gráfica (como Renderizador Vetorial e Renderizador Rasterizado).
 * Evite criar subclasses acopladas para todas as combinações (como VectorCircle, RasterCircle, VectorSquare, etc.),
 * permitindo que as formas (abstração) e os renderizadores (implementação) variem de forma independente.
 * 
 * Exercício:
 * Implemente os construtores e o método draw() para as formas geométricas.
 */
public class ShapeRenderer {

    // Implementação da Renderização
    public interface Renderer {
        String renderCircle(int radius);
        String renderSquare(int side);
    }

    // Renderizador Concreto 1
    public static class VectorRenderer implements Renderer {
        @Override
        public String renderCircle(int radius) {
            return "Drawing Circle with radius " + radius + " as Vector";
        }

        @Override
        public String renderSquare(int side) {
            return "Drawing Square with side " + side + " as Vector";
        }
    }

    // Renderizador Concreto 2
    public static class RasterRenderer implements Renderer {
        @Override
        public String renderCircle(int radius) {
            return "Drawing Circle with radius " + radius + " as Raster pixels";
        }

        @Override
        public String renderSquare(int side) {
            return "Drawing Square with side " + side + " as Raster pixels";
        }
    }

    // Abstração da Forma
    public static abstract class Shape {
        protected final Renderer renderer;

        protected Shape(Renderer renderer) {
            this.renderer = renderer;
        }

        public abstract String draw();
    }

    // TODO: Implemente os dois tipos de Formas abaixo estendendo a classe Shape.
    // Garanta que elas definam as propriedades (radius / side) e construtores apropriados
    // para inicializar a Forma com o Renderer correspondente e executar o desenho delegando ao renderer.

    public static class CircleShape extends Shape {
        private final int radius;

        // TODO: Declare as propriedades e o construtor necessário.
        public CircleShape(int radius, Renderer renderer) {
            super(renderer);
            this.radius = radius;
        }

        @Override
        public String draw() {
            // TODO: Desenhe o círculo usando o renderizador configurado.
            return renderer.renderCircle(radius);
        }
    }

    public static class SquareShape extends Shape {
        private final int side;

        // TODO: Declare as propriedades e o construtor necessário.
        public SquareShape(int side, Renderer renderer) {
            super(renderer);
            this.side = side;
        }

        @Override
        public String draw() {
            // TODO: Desenhe o quadrado usando o renderizador configurado.
            return renderer.renderSquare(side);
        }
    }
}
