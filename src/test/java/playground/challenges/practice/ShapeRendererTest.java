package playground.challenges.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PT05 - Sistema Gráfico")
public class ShapeRendererTest {

    @Test
    @DisplayName("Caso 1: Círculo com Renderizadores Vetorial e Raster")
    public void testCircleRendering() {
        ShapeRenderer.Renderer vector = new ShapeRenderer.VectorRenderer();
        ShapeRenderer.Renderer raster = new ShapeRenderer.RasterRenderer();

        ShapeRenderer.Shape circleVector = new ShapeRenderer.CircleShape(10, vector);
        ShapeRenderer.Shape circleRaster = new ShapeRenderer.CircleShape(15, raster);

        assertEquals("Drawing Circle with radius 10 as Vector", circleVector.draw());
        assertEquals("Drawing Circle with radius 15 as Raster pixels", circleRaster.draw());
    }

    @Test
    @DisplayName("Caso 2: Quadrado com Renderizadores Vetorial e Raster")
    public void testSquareRendering() {
        ShapeRenderer.Renderer vector = new ShapeRenderer.VectorRenderer();
        ShapeRenderer.Renderer raster = new ShapeRenderer.RasterRenderer();

        ShapeRenderer.Shape squareVector = new ShapeRenderer.SquareShape(20, vector);
        ShapeRenderer.Shape squareRaster = new ShapeRenderer.SquareShape(25, raster);

        assertEquals("Drawing Square with side 20 as Vector", squareVector.draw());
        assertEquals("Drawing Square with side 25 as Raster pixels", squareRaster.draw());
    }
}
