package playground.challenges.mystery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MC03 - Filtros Dinâmicos de Imagem")
public class ImageFiltersTest {

    @Test
    @DisplayName("Caso 1: Retornar imagem base sem filtros")
    public void testFilters_Base() {
        ImageFilters.ImageProcessor processor = new ImageFilters.BaseImageProcessor();
        assertEquals("foto.png", processor.apply("foto.png"));
    }

    @Test
    @DisplayName("Caso 2: Aplicar filtro Blur (Desfoque)")
    public void testFilters_Blur() {
        ImageFilters.ImageProcessor processor = new ImageFilters.BlurFilter(new ImageFilters.BaseImageProcessor());
        assertEquals("Blur(foto.png)", processor.apply("foto.png"));
    }

    @Test
    @DisplayName("Caso 3: Aplicar filtro Grayscale (Preto e Branco)")
    public void testFilters_Grayscale() {
        ImageFilters.ImageProcessor processor = new ImageFilters.GrayscaleFilter(new ImageFilters.BaseImageProcessor());
        assertEquals("Grayscale(foto.png)", processor.apply("foto.png"));
    }

    @Test
    @DisplayName("Caso 4: Aplicar filtros aninhados (Blur e Grayscale)")
    public void testFilters_Stacking() {
        ImageFilters.ImageProcessor processor = new ImageFilters.BlurFilter(
                new ImageFilters.GrayscaleFilter(
                        new ImageFilters.BaseImageProcessor()
                )
        );
        assertEquals("Blur(Grayscale(foto.png))", processor.apply("foto.png"));
    }
}
