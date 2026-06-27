package playground.challenges.mystery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImageFiltersTest {

    @Test
    public void testFilters_Base() {
        ImageFilters.ImageProcessor processor = new ImageFilters.BaseImageProcessor();
        assertEquals("foto.png", processor.apply("foto.png"));
    }

    @Test
    public void testFilters_Blur() {
        ImageFilters.ImageProcessor processor = new ImageFilters.BlurFilter(new ImageFilters.BaseImageProcessor());
        assertEquals("Blur(foto.png)", processor.apply("foto.png"));
    }

    @Test
    public void testFilters_Grayscale() {
        ImageFilters.ImageProcessor processor = new ImageFilters.GrayscaleFilter(new ImageFilters.BaseImageProcessor());
        assertEquals("Grayscale(foto.png)", processor.apply("foto.png"));
    }

    @Test
    public void testFilters_Stacking() {
        ImageFilters.ImageProcessor processor = new ImageFilters.BlurFilter(
                new ImageFilters.GrayscaleFilter(
                        new ImageFilters.BaseImageProcessor()
                )
        );
        assertEquals("Blur(Grayscale(foto.png))", processor.apply("foto.png"));
    }
}
